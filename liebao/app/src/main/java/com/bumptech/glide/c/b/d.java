package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.b.a;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.d<DataType> f4765a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f4766b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.j f4767c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.bumptech.glide.c.d<DataType> dVar, DataType datatype, com.bumptech.glide.c.j jVar) {
        this.f4765a = dVar;
        this.f4766b = datatype;
        this.f4767c = jVar;
    }

    @Override // com.bumptech.glide.c.b.b.a.b
    public boolean a(File file) {
        return this.f4765a.a(this.f4766b, file, this.f4767c);
    }
}
