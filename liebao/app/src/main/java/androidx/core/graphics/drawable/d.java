package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: RoundedBitmapDrawableFactory.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: RoundedBitmapDrawableFactory.java */
    /* loaded from: classes.dex */
    private static class a extends b {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // androidx.core.graphics.drawable.b
        void a(int i, int i2, int i3, Rect rect, Rect rect2) {
            androidx.core.h.e.a(i, i2, i3, rect, rect2, 0);
        }
    }

    public static b a(Resources resources, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
