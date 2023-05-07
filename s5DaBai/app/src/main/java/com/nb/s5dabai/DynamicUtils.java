package com.nb.s5dabai;

class DynamicUtils {
    static {
        System.loadLibrary("dym");
    }

    public static native String ssss(int v1, int v2);
    public static native String dymMD5(String input);
}
