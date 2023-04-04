package com.bumptech.glide.d;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f5114a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f5115b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5116c;

    @Override // com.bumptech.glide.d.h
    public void a(i iVar) {
        this.f5114a.add(iVar);
        if (this.f5116c) {
            iVar.e();
        } else if (this.f5115b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    @Override // com.bumptech.glide.d.h
    public void b(i iVar) {
        this.f5114a.remove(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f5115b = true;
        for (i iVar : com.bumptech.glide.i.j.a(this.f5114a)) {
            iVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f5115b = false;
        for (i iVar : com.bumptech.glide.i.j.a(this.f5114a)) {
            iVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f5116c = true;
        for (i iVar : com.bumptech.glide.i.j.a(this.f5114a)) {
            iVar.e();
        }
    }
}
