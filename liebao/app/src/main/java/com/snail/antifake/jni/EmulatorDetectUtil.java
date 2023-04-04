package com.snail.antifake.jni;

import android.content.Context;
import com.snail.antifake.a.a;

/* loaded from: classes2.dex */
public class EmulatorDetectUtil {
    public static native boolean detect();

    static {
        System.loadLibrary("emulator_check"); // 模拟器检测
    }

    public static boolean a(Context context) {
        return a.a(context) || detect();
    }
}
