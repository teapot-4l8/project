package com.fm.openinstall.b;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: classes.dex */
public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f5347a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f5348b = "";

    public String a() {
        return this.f5347a;
    }

    public void a(String str) {
        this.f5347a = str;
    }

    public String b() {
        return this.f5348b;
    }

    public void b(String str) {
        this.f5348b = str;
    }

    public boolean c() {
        return TextUtils.isEmpty(a()) && TextUtils.isEmpty(b());
    }

    public String toString() {
        return "AppData{channel='" + this.f5347a + "', data='" + this.f5348b + "'}";
    }
}
