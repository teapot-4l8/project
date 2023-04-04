package com.bumptech.glide.c.b.b;

import com.bumptech.glide.c.b.b.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0086a {

    /* renamed from: a  reason: collision with root package name */
    private final long f4725a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4726b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f4725a = j;
        this.f4726b = aVar;
    }

    @Override // com.bumptech.glide.c.b.b.a.InterfaceC0086a
    public com.bumptech.glide.c.b.b.a a() {
        File a2 = this.f4726b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f4725a);
        }
        return null;
    }
}
