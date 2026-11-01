package com.he.autoclick;

import android.app.Application;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.view.InputEvent;
import android.view.MotionEvent;

import java.lang.reflect.Method;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface.PackageLoadedParam;

public class AutoClickEntry extends XposedModule {

    private static final long TAP_INTERVAL_MS = 1000L;
    private static final float TAP_X = 540f;
    private static final float TAP_Y = 1200f;

    private volatile boolean running = false;

    @Override
    public void onPackageLoaded(PackageLoadedParam param) {
        try {
            // Ambil method attach dari class Application
            Method attachMethod = Application.class.getDeclaredMethod("attach", Context.class);
            
            // Panggil hook secara langsung karena kita sudah extends XposedModule
            hook(attachMethod).intercept(chain -> {
                Object result = chain.proceed();
                Context ctx = (Context) chain.getArg(0);
                startAutoClick(ctx);
                return result;
            });
        } catch (Throwable t) {
            // Abaikan jika gagal mengambil method
        }
    }

    private void startAutoClick(Context context) {
        if (running) return;
        running = true;

        Thread clickThread = new Thread(() -> {
            InputManager im = getInputManager();
            if (im == null) return;

            while (running) {
                try {
                    injectTap(im, TAP_X, TAP_Y);
                } catch (Throwable ignored) {}
                SystemClock.sleep(TAP_INTERVAL_MS);
            }
        }, "AutoClickWorker");

        clickThread.setDaemon(true);
        clickThread.start();
    }

    private InputManager getInputManager() {
        try {
            Method getInstance = InputManager.class.getDeclaredMethod("getInstance");
            getInstance.setAccessible(true);
            return (InputManager) getInstance.invoke(null);
        } catch (Throwable t) {
            return null;
        }
    }

    private void injectTap(InputManager im, float x, float y) throws Exception {
        long now = SystemClock.uptimeMillis();
        MotionEvent down = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, x, y, 0);
        MotionEvent up = MotionEvent.obtain(now, now + 50, MotionEvent.ACTION_UP, x, y, 0);

        Method inject = InputManager.class.getMethod("injectInputEvent", InputEvent.class, int.class);
        inject.setAccessible(true);

        inject.invoke(im, down, 0);
        inject.invoke(im, up, 0);

        down.recycle();
        up.recycle();
    }
}
