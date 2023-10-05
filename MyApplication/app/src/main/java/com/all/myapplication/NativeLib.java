package com.all.myapplication;

public class NativeLib {
    static {
        System.loadLibrary("AntiUtils");
    }

    // anti frida
    public static native String AntiFrida();
}
