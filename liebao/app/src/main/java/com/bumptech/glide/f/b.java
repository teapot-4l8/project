package com.bumptech.glide.f;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bumptech.glide.c.f> f5158a = new ArrayList();

    public synchronized List<com.bumptech.glide.c.f> a() {
        return this.f5158a;
    }

    public synchronized void a(com.bumptech.glide.c.f fVar) {
        this.f5158a.add(fVar);
    }
}
