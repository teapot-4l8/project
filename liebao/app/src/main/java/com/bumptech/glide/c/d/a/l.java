package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter.java */
/* loaded from: classes.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final com.bumptech.glide.c.b.a.e f5014a = new com.bumptech.glide.c.b.a.f() { // from class: com.bumptech.glide.c.d.a.l.1
        @Override // com.bumptech.glide.c.b.a.f, com.bumptech.glide.c.b.a.e
        public void a(Bitmap bitmap) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.bumptech.glide.c.b.u<Bitmap> a(com.bumptech.glide.c.b.a.e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = b(eVar, current, i, i2);
            z = true;
        }
        if (!z) {
            eVar = f5014a;
        }
        return d.a(bitmap, eVar);
    }

    private static Bitmap b(com.bumptech.glide.c.b.a.e eVar, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock a2 = u.a();
            a2.lock();
            Bitmap a3 = eVar.a(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(a3);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return a3;
            } finally {
                a2.unlock();
            }
        }
    }
}
