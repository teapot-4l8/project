package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends b {
    private int f;
    private int g;
    private androidx.constraintlayout.a.a.b h;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f;
    }

    public void setType(int i) {
        this.f = i;
        this.g = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f;
            if (i2 == 5) {
                this.g = 0;
            } else if (i2 == 6) {
                this.g = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f;
                if (i3 == 5) {
                    this.g = 1;
                } else if (i3 == 6) {
                    this.g = 0;
                }
            } else {
                int i4 = this.f;
                if (i4 == 5) {
                    this.g = 0;
                } else if (i4 == 6) {
                    this.g = 1;
                }
            }
        }
        this.h.a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.b
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.h = new androidx.constraintlayout.a.a.b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.h.a(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1371d = this.h;
        a();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.h.a(z);
    }
}
