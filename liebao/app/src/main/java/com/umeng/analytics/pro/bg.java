package com.umeng.analytics.pro;

import java.io.Serializable;

/* compiled from: FieldValueMetaData.java */
/* loaded from: classes2.dex */
public class bg implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6427a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f6428b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6429c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6430d;

    public bg(byte b2, boolean z) {
        this.f6428b = b2;
        this.f6427a = false;
        this.f6429c = null;
        this.f6430d = z;
    }

    public bg(byte b2) {
        this(b2, false);
    }

    public bg(byte b2, String str) {
        this.f6428b = b2;
        this.f6427a = true;
        this.f6429c = str;
        this.f6430d = false;
    }

    public boolean a() {
        return this.f6427a;
    }

    public String b() {
        return this.f6429c;
    }

    public boolean c() {
        return this.f6428b == 12;
    }

    public boolean d() {
        byte b2 = this.f6428b;
        return b2 == 15 || b2 == 13 || b2 == 14;
    }

    public boolean e() {
        return this.f6430d;
    }
}
