package com.facebook.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.facebook.crypto.f;

/* compiled from: SharedPrefsBackedKeyChain.java */
/* loaded from: classes.dex */
public class d implements com.facebook.crypto.b.a {

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f5282a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f5283b;

    /* renamed from: c  reason: collision with root package name */
    private final f f5284c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f5285d;

    /* renamed from: e  reason: collision with root package name */
    private final b f5286e = new b();

    public d(Context context, f fVar) {
        this.f5285d = context.getSharedPreferences(a(fVar), 0);
        this.f5284c = fVar;
    }

    private static String a(f fVar) {
        if (fVar == f.KEY_128) {
            return "crypto";
        }
        return "crypto." + String.valueOf(fVar);
    }

    @Override // com.facebook.crypto.b.a
    public synchronized byte[] a() {
        if (!this.f5283b) {
            this.f5282a = a("cipher_key", this.f5284c.f5324d);
        }
        this.f5283b = true;
        return this.f5282a;
    }

    @Override // com.facebook.crypto.b.a
    public byte[] b() {
        byte[] bArr = new byte[this.f5284c.f5325e];
        this.f5286e.nextBytes(bArr);
        return bArr;
    }

    private byte[] a(String str, int i) {
        String string = this.f5285d.getString(str, null);
        if (string == null) {
            return b(str, i);
        }
        return a(string);
    }

    private byte[] b(String str, int i) {
        byte[] bArr = new byte[i];
        this.f5286e.nextBytes(bArr);
        SharedPreferences.Editor edit = this.f5285d.edit();
        edit.putString(str, a(bArr));
        edit.commit();
        return bArr;
    }

    byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }
}
