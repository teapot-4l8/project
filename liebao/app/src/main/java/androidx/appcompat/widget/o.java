package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView.java */
/* loaded from: classes.dex */
public class o extends ImageView implements androidx.core.h.v, androidx.core.widget.l {

    /* renamed from: a  reason: collision with root package name */
    private final f f1097a;

    /* renamed from: b  reason: collision with root package name */
    private final n f1098b;

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        ar.a(this, getContext());
        f fVar = new f(this);
        this.f1097a = fVar;
        fVar.a(attributeSet, i);
        n nVar = new n(this);
        this.f1098b = nVar;
        nVar.a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.f1097a;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1097a;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1097a;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.h.v
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1097a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1097a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.h.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1097a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintList(ColorStateList colorStateList) {
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.a(colorStateList);
        }
    }

    @Override // androidx.core.widget.l
    public ColorStateList getSupportImageTintList() {
        n nVar = this.f1098b;
        if (nVar != null) {
            return nVar.b();
        }
        return null;
    }

    @Override // androidx.core.widget.l
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.a(mode);
        }
    }

    @Override // androidx.core.widget.l
    public PorterDuff.Mode getSupportImageTintMode() {
        n nVar = this.f1098b;
        if (nVar != null) {
            return nVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1097a;
        if (fVar != null) {
            fVar.c();
        }
        n nVar = this.f1098b;
        if (nVar != null) {
            nVar.d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1098b.a() && super.hasOverlappingRendering();
    }
}
