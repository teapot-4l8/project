package com.nb.s5dabai;

public class Advancedmd5 {
    static {
        System.loadLibrary("utils");
    }

    public static native String encrypt(String str);
}
