package com.bumptech.glide.c.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.i.i;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements q, u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f5052a;

    public b(T t) {
        this.f5052a = (T) i.a(t);
    }

    @Override // com.bumptech.glide.c.b.u
    /* renamed from: b */
    public final T d() {
        Drawable.ConstantState constantState = this.f5052a.getConstantState();
        if (constantState == null) {
            return this.f5052a;
        }
        return (T) constantState.newDrawable();
    }

    @Override // com.bumptech.glide.c.b.q
    public void a() {
        T t = this.f5052a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.bumptech.glide.c.d.e.c) {
            ((com.bumptech.glide.c.d.e.c) t).b().prepareToDraw();
        }
    }
}
