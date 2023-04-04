package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsActionBarView.java */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0024a f922a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f923b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f924c;

    /* renamed from: d  reason: collision with root package name */
    protected c f925d;

    /* renamed from: e  reason: collision with root package name */
    protected int f926e;
    protected androidx.core.h.aa f;
    private boolean g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f922a = new C0024a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f923b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f923b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f925d;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f926e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f926e;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.f922a.f927a;
        }
        return getVisibility();
    }

    public androidx.core.h.aa a(int i, long j) {
        androidx.core.h.aa aaVar = this.f;
        if (aaVar != null) {
            aaVar.b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            androidx.core.h.aa a2 = androidx.core.h.w.m(this).a(1.0f);
            a2.a(j);
            a2.a(this.f922a.a(a2, i));
            return a2;
        }
        androidx.core.h.aa a3 = androidx.core.h.w.m(this).a(0.0f);
        a3.a(j);
        a3.a(this.f922a.a(a3, i));
        return a3;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            androidx.core.h.aa aaVar = this.f;
            if (aaVar != null) {
                aaVar.b();
            }
            super.setVisibility(i);
        }
    }

    public boolean a() {
        c cVar = this.f925d;
        if (cVar != null) {
            return cVar.c();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0024a implements androidx.core.h.ab {

        /* renamed from: a  reason: collision with root package name */
        int f927a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f929c = false;

        protected C0024a() {
        }

        public C0024a a(androidx.core.h.aa aaVar, int i) {
            a.this.f = aaVar;
            this.f927a = i;
            return this;
        }

        @Override // androidx.core.h.ab
        public void a(View view) {
            a.super.setVisibility(0);
            this.f929c = false;
        }

        @Override // androidx.core.h.ab
        public void b(View view) {
            if (this.f929c) {
                return;
            }
            a.this.f = null;
            a.super.setVisibility(this.f927a);
        }

        @Override // androidx.core.h.ab
        public void c(View view) {
            this.f929c = true;
        }
    }
}
