package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bm;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer.java */
/* loaded from: classes2.dex */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f6416a;

    /* renamed from: b  reason: collision with root package name */
    private final ce f6417b;

    /* renamed from: c  reason: collision with root package name */
    private bs f6418c;

    public bc() {
        this(new bm.a());
    }

    public bc(bu buVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f6416a = byteArrayOutputStream;
        ce ceVar = new ce(byteArrayOutputStream);
        this.f6417b = ceVar;
        this.f6418c = buVar.a(ceVar);
    }

    public byte[] a(at atVar) {
        this.f6416a.reset();
        atVar.write(this.f6418c);
        return this.f6416a.toByteArray();
    }

    public String a(at atVar, String str) {
        try {
            return new String(a(atVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new az("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(at atVar) {
        return new String(a(atVar));
    }
}
