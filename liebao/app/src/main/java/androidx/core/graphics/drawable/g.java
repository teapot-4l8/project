package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableApi14.java */
/* loaded from: classes.dex */
public class g extends Drawable implements Drawable.Callback, e, f {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f1628a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    i f1629b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f1630c;

    /* renamed from: d  reason: collision with root package name */
    private int f1631d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f1632e;
    private boolean f;
    private boolean g;

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(i iVar, Resources resources) {
        this.f1629b = iVar;
        a(resources);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Drawable drawable) {
        this.f1629b = c();
        a(drawable);
    }

    private void a(Resources resources) {
        i iVar = this.f1629b;
        if (iVar == null || iVar.f1635b == null) {
            return;
        }
        a(this.f1629b.f1635b.newDrawable(resources));
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1630c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1630c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1630c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1630c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i iVar = this.f1629b;
        return changingConfigurations | (iVar != null ? iVar.getChangingConfigurations() : 0) | this.f1630c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1630c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1630c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1630c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1630c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        i iVar;
        ColorStateList colorStateList = (!b() || (iVar = this.f1629b) == null) ? null : iVar.f1636c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1630c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f1630c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1630c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1630c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1630c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1630c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1630c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1630c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1630c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1630c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1630c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1630c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f1630c.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1630c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        i iVar = this.f1629b;
        if (iVar == null || !iVar.a()) {
            return null;
        }
        this.f1629b.f1634a = getChangingConfigurations();
        return this.f1629b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.g && super.mutate() == this) {
            this.f1629b = c();
            Drawable drawable = this.f1630c;
            if (drawable != null) {
                drawable.mutate();
            }
            i iVar = this.f1629b;
            if (iVar != null) {
                Drawable drawable2 = this.f1630c;
                iVar.f1635b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.g = true;
        }
        return this;
    }

    private i c() {
        return new i(this.f1629b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f1630c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintList(ColorStateList colorStateList) {
        this.f1629b.f1636c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1629b.f1637d = mode;
        a(getState());
    }

    private boolean a(int[] iArr) {
        if (b()) {
            ColorStateList colorStateList = this.f1629b.f1636c;
            PorterDuff.Mode mode = this.f1629b.f1637d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f || colorForState != this.f1631d || mode != this.f1632e) {
                    setColorFilter(colorForState, mode);
                    this.f1631d = colorForState;
                    this.f1632e = mode;
                    this.f = true;
                    return true;
                }
            } else {
                this.f = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // androidx.core.graphics.drawable.f
    public final Drawable a() {
        return this.f1630c;
    }

    @Override // androidx.core.graphics.drawable.f
    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f1630c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1630c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i iVar = this.f1629b;
            if (iVar != null) {
                iVar.f1635b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }
}
