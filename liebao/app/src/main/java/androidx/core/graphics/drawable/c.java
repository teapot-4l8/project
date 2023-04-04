package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: RoundedBitmapDrawable21.java */
/* loaded from: classes.dex */
class c extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        a();
        outline.setRoundRect(this.f1624b, b());
    }

    @Override // androidx.core.graphics.drawable.b
    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }
}
