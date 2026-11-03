# Obfuscate semua class
-repackageclasses 'a.b.c'
-allowaccessmodification

# Keep entry points
-keep class com.system.core.manager.ui.MainActivity {
    public *;
}

# Keep Xposed entry
-keep class * implements de.robv.android.xposed.IXposedHookLoadPackage {
    public void handleLoadPackage(...);
}

# Remove semua log
-assumenosideeffects class android.util.Log {
    public static int v(...);
    public static int d(...);
    public static int i(...);
    public static int w(...);
    public static int e(...);
}

# Remove XposedBridge log — gak ada trace di logcat
-assumenosideeffects class de.robv.android.xposed.XposedBridge {
    public static void log(...);
}

# Keep serialization
-keepattributes *Annotation*,InnerClasses,EnclosingMethod
-keepattributes Signature
-keepattributes EnclosingMethod

# Keep Gson
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Keep OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okhttp3.** { *; }

# Keep Kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# Remove debug info
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

# Obfuscate dictionary
-obfuscationdictionary proguard-dict.txt
-classobfuscationdictionary proguard-dict.txt
-packageobfuscationdictionary proguard-dict.txt

-dontwarn androidx.window.**
-dontwarn androidx.window.extensions.**
-dontwarn androidx.window.sidecar.**
-dontwarn androidx.window.area.**
-dontwarn androidx.window.layout.**
-dontwarn androidx.window.reflection.**
