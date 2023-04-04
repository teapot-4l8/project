package ml.w568w.checkxposed.util;

/* loaded from: classes2.dex */
public class NativeDetect {
    // false
    public static native boolean detectXposed(int i);

    static {
        System.loadLibrary("xposed_check");
    }
}
