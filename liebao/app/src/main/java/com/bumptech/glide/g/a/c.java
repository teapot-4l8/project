package com.bumptech.glide.g.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class c extends d<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.g.a.d
    /* renamed from: d */
    public void a(Drawable drawable) {
        ((ImageView) this.f5186a).setImageDrawable(drawable);
    }
}
