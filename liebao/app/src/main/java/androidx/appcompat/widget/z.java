package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.f.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: AppCompatTextView.java */
/* loaded from: classes.dex */
public class z extends TextView implements androidx.core.h.v, androidx.core.widget.b, androidx.core.widget.k {

    /* renamed from: a  reason: collision with root package name */
    private final f f1150a;

    /* renamed from: b  reason: collision with root package name */
    private final y f1151b;

    /* renamed from: c  reason: collision with root package name */
    private final x f1152c;

    /* renamed from: e  reason: collision with root package name */
    private Future<androidx.core.f.c> f1153e;

    public z(Context context) {
        this(context, null);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public z(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        ar.a(this, getContext());
        f fVar = new f(this);
        this.f1150a = fVar;
        fVar.a(attributeSet, i);
        y yVar = new y(this);
        this.f1151b = yVar;
        yVar.a(attributeSet, i);
        this.f1151b.b();
        this.f1152c = new x(this);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.f1150a;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1150a;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1150a;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.h.v
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1150a;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1150a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.h.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1150a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1150a;
        if (fVar != null) {
            fVar.c();
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (f1776d) {
            super.setTextSize(i, f);
            return;
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f1151b == null || f1776d || !this.f1151b.d()) {
            return;
        }
        this.f1151b.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f1776d) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f1776d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f1776d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (f1776d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            return yVar.e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f1776d) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            return yVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f1776d) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            return yVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f1776d) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f1151b;
        if (yVar != null) {
            return yVar.h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f1776d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f1151b;
        return yVar != null ? yVar.i() : new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            androidx.core.widget.i.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            androidx.core.widget.i.c(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.c(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.d(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        androidx.core.widget.i.d(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }

    public c.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.e(this);
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        androidx.core.widget.i.a(this, aVar);
    }

    public void setPrecomputedText(androidx.core.f.c cVar) {
        androidx.core.widget.i.a(this, cVar);
    }

    private void a() {
        Future<androidx.core.f.c> future = this.f1153e;
        if (future != null) {
            try {
                this.f1153e = null;
                androidx.core.widget.i.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        a();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f1152c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f1152c) == null) {
            return super.getTextClassifier();
        }
        return xVar.a();
    }

    public void setTextFuture(Future<androidx.core.f.c> future) {
        this.f1153e = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? androidx.appcompat.a.a.a.b(context, i) : null, i2 != 0 ? androidx.appcompat.a.a.a.b(context, i2) : null, i3 != 0 ? androidx.appcompat.a.a.a.b(context, i3) : null, i4 != 0 ? androidx.appcompat.a.a.a.b(context, i4) : null);
        y yVar = this.f1151b;
        if (yVar != null) {
            yVar.a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1151b.j();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1151b.a(colorStateList);
        this.f1151b.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1151b.k();
    }

    @Override // androidx.core.widget.k
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1151b.a(mode);
        this.f1151b.b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface a2 = (typeface == null || i <= 0) ? null : androidx.core.graphics.d.a(getContext(), typeface, i);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i);
    }
}
