package com.bumptech.glide.c.b;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class r {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.bumptech.glide.c.h, k<?>> f4855a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.bumptech.glide.c.h, k<?>> f4856b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<?> a(com.bumptech.glide.c.h hVar, boolean z) {
        return a(z).get(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar, k<?> kVar) {
        a(kVar.a()).put(hVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.bumptech.glide.c.h hVar, k<?> kVar) {
        Map<com.bumptech.glide.c.h, k<?>> a2 = a(kVar.a());
        if (kVar.equals(a2.get(hVar))) {
            a2.remove(hVar);
        }
    }

    private Map<com.bumptech.glide.c.h, k<?>> a(boolean z) {
        return z ? this.f4856b : this.f4855a;
    }
}
