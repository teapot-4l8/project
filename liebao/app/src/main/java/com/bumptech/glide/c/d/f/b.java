package com.bumptech.glide.c.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.q;
import com.bumptech.glide.c.j;
import com.bumptech.glide.i.i;

/* compiled from: BitmapDrawableTranscoder.java */
/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f5087a;

    public b(Resources resources) {
        this.f5087a = (Resources) i.a(resources);
    }

    @Override // com.bumptech.glide.c.d.f.e
    public u<BitmapDrawable> a(u<Bitmap> uVar, j jVar) {
        return q.a(this.f5087a, uVar);
    }
}
