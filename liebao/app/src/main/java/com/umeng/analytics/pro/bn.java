package com.umeng.analytics.pro;

/* compiled from: TField.java */
/* loaded from: classes2.dex */
public class bn {

    /* renamed from: a  reason: collision with root package name */
    public final String f6456a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f6457b;

    /* renamed from: c  reason: collision with root package name */
    public final short f6458c;

    public bn() {
        this("", (byte) 0, (short) 0);
    }

    public bn(String str, byte b2, short s) {
        this.f6456a = str;
        this.f6457b = b2;
        this.f6458c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f6456a + "' type:" + ((int) this.f6457b) + " field-id:" + ((int) this.f6458c) + ">";
    }

    public boolean a(bn bnVar) {
        return this.f6457b == bnVar.f6457b && this.f6458c == bnVar.f6458c;
    }
}
