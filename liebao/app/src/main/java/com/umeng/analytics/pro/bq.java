package com.umeng.analytics.pro;

/* compiled from: TMessage.java */
/* loaded from: classes2.dex */
public final class bq {

    /* renamed from: a  reason: collision with root package name */
    public final String f6464a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f6465b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6466c;

    public bq() {
        this("", (byte) 0, 0);
    }

    public bq(String str, byte b2, int i) {
        this.f6464a = str;
        this.f6465b = b2;
        this.f6466c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.f6464a + "' type: " + ((int) this.f6465b) + " seqid:" + this.f6466c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof bq) {
            return a((bq) obj);
        }
        return false;
    }

    public boolean a(bq bqVar) {
        return this.f6464a.equals(bqVar.f6464a) && this.f6465b == bqVar.f6465b && this.f6466c == bqVar.f6466c;
    }
}
