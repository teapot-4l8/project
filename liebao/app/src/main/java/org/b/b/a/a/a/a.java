package org.b.b.a.a.a;

import android.content.Context;
import org.b.a.a.a.a.b;

/* compiled from: OpenIDSDK.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(Context context) {
        org.b.a.a.a.a.a.f7762b = b.C0190b.f7770a.a(context.getApplicationContext());
        org.b.a.a.a.a.a.f7761a = true;
    }

    public static boolean a() {
        if (org.b.a.a.a.a.a.f7761a) {
            return org.b.a.a.a.a.a.f7762b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (org.b.a.a.a.a.a.f7761a) {
            return b.C0190b.f7770a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
