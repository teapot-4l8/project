package com.a.a.c;

import android.os.Build;
import android.util.Log;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f4555a = c();

    public static b a() {
        return f4555a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return System.lineSeparator();
    }

    public void a(String str) {
        System.out.println(str);
    }

    private static b c() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static class a extends b {
        a() {
        }

        @Override // com.a.a.c.b
        String b() {
            return Build.VERSION.SDK_INT < 19 ? "\n" : System.lineSeparator();
        }

        @Override // com.a.a.c.b
        public void a(String str) {
            Log.w("XLog", str);
        }
    }
}
