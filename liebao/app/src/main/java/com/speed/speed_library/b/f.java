package com.speed.speed_library.b;

import android.os.Looper;
import android.widget.Toast;

/* compiled from: Ext.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f5608a;

    public static /* synthetic */ void a(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        a(str, i);
    }

    public static final void a(String str, int i) {
        kotlin.d.b.i.b(str, "content");
        if (kotlin.d.b.i.a(Looper.myLooper(), Looper.getMainLooper())) {
            Toast toast = f5608a;
            if (toast == null) {
                f5608a = Toast.makeText(g.f5610b.a(), str, i);
            } else if (toast != null) {
                toast.setText(str);
            }
            Toast toast2 = f5608a;
            if (toast2 != null) {
                toast2.show();
            }
        }
    }
}
