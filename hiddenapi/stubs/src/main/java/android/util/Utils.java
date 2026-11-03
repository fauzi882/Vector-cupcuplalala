package android.util;

public final class Utils {
    private Utils() {}

    public static boolean isMIUI() { return false; }
    public static boolean isSamsung() { return false; }

    public static void logD(String tag, String msg) {}
    public static void logD(String tag, String msg, Throwable t) {}
    public static void logI(String tag, String msg) {}
    public static void logI(String tag, String msg, Throwable t) {}
    public static void logW(String tag, String msg) {}
    public static void logW(String tag, String msg, Throwable t) {}
    public static void logE(String tag, String msg) {}
    public static void logE(String tag, String msg, Throwable t) {}

    public static void checkFlagsArgument(final long requestedFlags,
            final long validFlagsMask) {}
    public static int intValueOf(boolean value) { return value ? 1 : 0; }
}
