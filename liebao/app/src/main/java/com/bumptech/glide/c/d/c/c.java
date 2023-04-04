package com.bumptech.glide.c.d.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.u;

/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: classes.dex */
final class c extends b<Drawable> {
    @Override // com.bumptech.glide.c.b.u
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    private c(Drawable drawable) {
        super(drawable);
    }

    @Override // com.bumptech.glide.c.b.u
    public Class<Drawable> c() {
        return this.f5052a.getClass();
    }

    @Override // com.bumptech.glide.c.b.u
    public int e() {
        return Math.max(1, this.f5052a.getIntrinsicWidth() * this.f5052a.getIntrinsicHeight() * 4);
    }
}
