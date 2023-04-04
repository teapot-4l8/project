package com.bumptech.glide.g.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.g.b.b;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class d<Z> extends i<ImageView, Z> implements b.a {

    /* renamed from: b  reason: collision with root package name */
    private Animatable f5181b;

    protected abstract void a(Z z);

    public d(ImageView imageView) {
        super(imageView);
    }

    public void e(Drawable drawable) {
        ((ImageView) this.f5186a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.g.a.i, com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void b(Drawable drawable) {
        super.b(drawable);
        b((d<Z>) null);
        e(drawable);
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void c(Drawable drawable) {
        super.c(drawable);
        b((d<Z>) null);
        e(drawable);
    }

    @Override // com.bumptech.glide.g.a.i, com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
    public void a(Drawable drawable) {
        super.a(drawable);
        Animatable animatable = this.f5181b;
        if (animatable != null) {
            animatable.stop();
        }
        b((d<Z>) null);
        e(drawable);
    }

    @Override // com.bumptech.glide.g.a.h
    public void a(Z z, com.bumptech.glide.g.b.b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            b((d<Z>) z);
        } else {
            c((d<Z>) z);
        }
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.d.i
    public void c() {
        Animatable animatable = this.f5181b;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.d.i
    public void d() {
        Animatable animatable = this.f5181b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void b(Z z) {
        a((d<Z>) z);
        c((d<Z>) z);
    }

    private void c(Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f5181b = animatable;
            animatable.start();
            return;
        }
        this.f5181b = null;
    }
}
