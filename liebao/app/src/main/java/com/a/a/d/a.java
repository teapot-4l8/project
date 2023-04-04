package com.a.a.d;

import android.util.Log;

/* compiled from: AndroidPrinter.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private int f4561a;

    public a() {
        this(4063);
    }

    public a(int i) {
        this.f4561a = i;
    }

    @Override // com.a.a.d.b
    public void a(int i, String str, String str2) {
        if (str2.length() <= this.f4561a) {
            b(i, str, str2);
            return;
        }
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = a(str2, i2, Math.min(this.f4561a + i2, length));
            b(i, str, str2.substring(i2, a2));
            i2 = a2;
        }
    }

    static int a(String str, int i, int i2) {
        if (i2 == str.length() || str.charAt(i2) == '\n') {
            return i2;
        }
        for (int i3 = i2 - 1; i < i3; i3--) {
            if (str.charAt(i3) == '\n') {
                return i3 + 1;
            }
        }
        return i2;
    }

    void b(int i, String str, String str2) {
        Log.println(i, str, str2);
    }
}
