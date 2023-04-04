package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* compiled from: UMInnerManager.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f6701a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f6702b;

    static {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMInnerImpl");
            if (cls != null) {
                f6701a = cls;
                Method declaredMethod = cls.getDeclaredMethod("initAndSendInternal", Context.class);
                if (declaredMethod != null) {
                    f6702b = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE != 1) {
            Class<?> cls = f6701a;
            if (cls == null || (method = f6702b) == null) {
                return;
            }
            try {
                method.invoke(cls, context);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        UMConfigureInternation.sendInternal(context);
    }
}
