package cn.jpush.android.c;

import android.os.Bundle;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4298a;

    /* renamed from: b  reason: collision with root package name */
    private int f4299b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f4300c;

    public a(String str, int i) {
        this.f4298a = str;
        this.f4299b = i;
    }

    public int a() {
        return this.f4299b;
    }

    public void a(Bundle bundle) {
        this.f4300c = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd='" + this.f4298a + "', errorCode=" + this.f4299b + ", extra=" + this.f4300c + '}';
    }
}
