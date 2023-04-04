package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableApi21.java */
/* loaded from: classes.dex */
public class h extends g {

    /* renamed from: d  reason: collision with root package name */
    private static Method f1633d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Drawable drawable) {
        super(drawable);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, Resources resources) {
        super(iVar, resources);
        c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.f1630c.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f1630c.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f1630c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f1630c.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        if (b()) {
            super.setTintList(colorStateList);
        } else {
            this.f1630c.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTint(int i) {
        if (b()) {
            super.setTint(i);
        } else {
            this.f1630c.setTint(i);
        }
    }

    @Override // androidx.core.graphics.drawable.g, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            super.setTintMode(mode);
        } else {
            this.f1630c.setTintMode(mode);
        }
    }

    @Override // androidx.core.graphics.drawable.g, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return true;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.g
    protected boolean b() {
        if (Build.VERSION.SDK_INT == 21) {
            Drawable drawable = this.f1630c;
            return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        if (this.f1630c != null && (method = f1633d) != null) {
            try {
                return ((Boolean) method.invoke(this.f1630c, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
            }
        }
        return false;
    }

    private void c() {
        if (f1633d == null) {
            try {
                f1633d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }
}
