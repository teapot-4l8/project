package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public class d extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f1382a;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.a {
        public float an;
        public boolean ao;
        public float ap;
        public float aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public a(int i, int i2) {
            super(i, i2);
            this.an = 1.0f;
            this.ao = false;
            this.ap = 0.0f;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = 0.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.an = 1.0f;
            this.ao = false;
            this.ap = 0.0f;
            this.aq = 0.0f;
            this.ar = 0.0f;
            this.as = 0.0f;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = 0.0f;
            this.aw = 0.0f;
            this.ax = 0.0f;
            this.ay = 0.0f;
            this.az = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.an = obtainStyledAttributes.getFloat(index, this.an);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.ap = obtainStyledAttributes.getFloat(index, this.ap);
                    this.ao = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.ar = obtainStyledAttributes.getFloat(index, this.ar);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.as = obtainStyledAttributes.getFloat(index, this.as);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.aq = obtainStyledAttributes.getFloat(index, this.aq);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.at = obtainStyledAttributes.getFloat(index, this.at);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.au = obtainStyledAttributes.getFloat(index, this.au);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.av = obtainStyledAttributes.getFloat(index, this.av);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.aw = obtainStyledAttributes.getFloat(index, this.aw);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.ax);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.ay = obtainStyledAttributes.getFloat(index, this.ay);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.az);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public c getConstraintSet() {
        if (this.f1382a == null) {
            this.f1382a = new c();
        }
        this.f1382a.a(this);
        return this.f1382a;
    }
}
