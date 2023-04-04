package com.speed.speed_library.speed;

import android.util.Log;
import kotlin.d.b.i;

/* compiled from: General.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5845a = true;

    /* renamed from: b  reason: collision with root package name */
    private static String f5846b = "Speed";

    /* renamed from: c  reason: collision with root package name */
    private static String f5847c = "default";

    public static final String a() {
        return f5846b;
    }

    public static final void a(Object obj, Object obj2) {
        i.b(obj, "$this$showLog");
        if (f5845a) {
            Log.d("WG.Android", obj.getClass().getSimpleName() + ": " + obj2);
        }
    }
}
