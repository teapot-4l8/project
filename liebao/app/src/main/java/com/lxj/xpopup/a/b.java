package com.lxj.xpopup.a;

import android.view.View;

/* compiled from: PopupAnimator.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public View f5373a;

    /* renamed from: b  reason: collision with root package name */
    public com.lxj.xpopup.c.c f5374b;

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public b() {
    }

    public b(View view) {
        this(view, null);
    }

    public b(View view, com.lxj.xpopup.c.c cVar) {
        this.f5373a = view;
        this.f5374b = cVar;
    }
}
