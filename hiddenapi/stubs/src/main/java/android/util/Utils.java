package android.util;

public final class Utils {
    private Utils() {}

    // property — bukan method
    public static final boolean isMIUI = false;
    public static final boolean isSamsung = false;

    // single string
    public static void logD(String msg) {}
    public static void logI(String msg) {}
    public static void logW(String msg) {}
    public static void logE(String msg) {}

    // string + string
    public static void logD(String tag, String msg) {}
    public static void logI(String tag, String msg) {}
    public static void logW(String tag, String msg) {}
    public static void logE(String tag, String msg) {}

    // string + throwable
    public static void logD(String msg, Throwable t) {}
    public static void logI(String msg, Throwable t) {}
    public static void logW(String msg, Throwable t) {}
    public static void logE(String msg, Throwable t) {}

    // string + string + throwable
    public static void logD(String tag, String msg, Throwable t) {}
    public static void logW(String tag, String msg, Throwable t) {}
    public static void logE(String tag, String msg, Throwable t) {}

    public static void checkFlagsArgument(long requestedFlags,
            long validFlagsMask) {}
    public static int intValueOf(boolean value) { return value ? 1 : 0; }
}
