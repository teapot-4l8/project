package com.bumptech.glide.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends d<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.g.a.d
    public void a(Bitmap bitmap) {
        ((ImageView) this.f5186a).setImageBitmap(bitmap);
    }
}
