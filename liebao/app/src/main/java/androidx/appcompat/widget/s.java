package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R;

/* compiled from: AppCompatRadioButton.java */
/* loaded from: classes.dex */
public class s extends RadioButton implements androidx.core.h.v, androidx.core.widget.j {

    /* renamed from: a  reason: collision with root package name */
    private final j f1107a;

    /* renamed from: b  reason: collision with root package name */
    private final f f1108b;

    /* renamed from: c  reason: collision with root package name */
    private final y f1109c;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        ar.a(this, getContext());
        j jVar = new j(this);
        this.f1107a = jVar;
        jVar.a(attributeSet, i);
        f fVar = new f(this);
        this.f1108b = fVar;
        fVar.a(attributeSet, i);
        y yVar = new y(this);
        this.f1109c = yVar;
        yVar.a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        j jVar = this.f1107a;
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
        j jVar = this.f1107a;
        return jVar != null ? jVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        j jVar = this.f1107a;
        if (jVar != null) {
            jVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        j jVar = this.f1107a;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    @Override // androidx.core.widget.j
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        j jVar = this.f1107a;
        if (jVar != null) {
            jVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        j jVar = this.f1107a;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1108b;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.h.v
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1108b;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1108b;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.h.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1108b;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1108b;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.f1108b;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1108b;
        if (fVar != null) {
            fVar.c();
        }
        y yVar = this.f1109c;
        if (yVar != null) {
            yVar.b();
        }
    }
}
