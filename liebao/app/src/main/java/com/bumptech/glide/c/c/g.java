package com.bumptech.glide.c.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.c.h {

    /* renamed from: b  reason: collision with root package name */
    private final h f4918b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f4919c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4920d;

    /* renamed from: e  reason: collision with root package name */
    private String f4921e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public g(URL url) {
        this(url, h.f4923b);
    }

    public g(String str) {
        this(str, h.f4923b);
    }

    public g(URL url, h hVar) {
        this.f4919c = (URL) com.bumptech.glide.i.i.a(url);
        this.f4920d = null;
        this.f4918b = (h) com.bumptech.glide.i.i.a(hVar);
    }

    public g(String str, h hVar) {
        this.f4919c = null;
        this.f4920d = com.bumptech.glide.i.i.a(str);
        this.f4918b = (h) com.bumptech.glide.i.i.a(hVar);
    }

    public URL a() {
        return d();
    }

    private URL d() {
        if (this.f == null) {
            this.f = new URL(e());
        }
        return this.f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f4921e)) {
            String str = this.f4920d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.bumptech.glide.i.i.a(this.f4919c)).toString();
            }
            this.f4921e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f4921e;
    }

    public Map<String, String> b() {
        return this.f4918b.a();
    }

    public String c() {
        String str = this.f4920d;
        return str != null ? str : ((URL) com.bumptech.glide.i.i.a(this.f4919c)).toString();
    }

    public String toString() {
        return c();
    }

    @Override // com.bumptech.glide.c.h
    public void a(MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    private byte[] f() {
        if (this.g == null) {
            this.g = c().getBytes(f5102a);
        }
        return this.g;
    }

    @Override // com.bumptech.glide.c.h
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return c().equals(gVar.c()) && this.f4918b.equals(gVar.f4918b);
        }
        return false;
    }

    @Override // com.bumptech.glide.c.h
    public int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 31) + this.f4918b.hashCode();
        }
        return this.h;
    }
}
