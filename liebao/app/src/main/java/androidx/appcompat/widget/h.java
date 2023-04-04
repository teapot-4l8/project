package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R;

/* compiled from: AppCompatCheckBox.java */
/* loaded from: classes.dex */
public class h extends CheckBox implements androidx.core.h.v, androidx.core.widget.j {
    private final f mBackgroundTintHelper;
    private final j mCompoundButtonHelper;
    private final y mTextHelper;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        ar.a(this, getContext());
        j jVar = new j(this);
        this.mCompoundButtonHelper = jVar;
        jVar.a(attributeSet, i);
        f fVar = new f(this);
        this.mBackgroundTintHelper = fVar;
        fVar.a(attributeSet, i);
        y yVar = new y(this);
        this.mTextHelper = yVar;
        yVar.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        j jVar = this.mCompoundButtonHelper;
        return jVar != null ? jVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.h.v
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.h.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.c();
        }
        y yVar = this.mTextHelper;
        if (yVar != null) {
            yVar.b();
        }
    }
}
