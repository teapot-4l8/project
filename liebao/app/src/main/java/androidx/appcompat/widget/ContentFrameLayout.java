package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TypedValue f871a;

    /* renamed from: b  reason: collision with root package name */
    private TypedValue f872b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f873c;

    /* renamed from: d  reason: collision with root package name */
    private TypedValue f874d;

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f875e;
    private TypedValue f;
    private final Rect g;
    private a h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.h = aVar;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        if (androidx.core.h.w.A(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        boolean z;
        int measuredWidth;
        TypedValue typedValue;
        int i3;
        float fraction;
        int i4;
        float fraction2;
        int i5;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f874d : this.f873c;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    fraction3 = typedValue2.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                } else {
                    i5 = 0;
                    if (i5 > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(Math.min(i5 - (this.g.left + this.g.right), View.MeasureSpec.getSize(i)), 1073741824);
                        z = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z3 ? this.f875e : this.f;
                            if (typedValue3 != null && typedValue3.type != 0) {
                                if (typedValue3.type == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (typedValue3.type == 6) {
                                    fraction2 = typedValue3.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels);
                                } else {
                                    i4 = 0;
                                    if (i4 > 0) {
                                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                                    }
                                }
                                i4 = (int) fraction2;
                                if (i4 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i, i2);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z && mode == Integer.MIN_VALUE) {
                            typedValue = !z3 ? this.f872b : this.f871a;
                            if (typedValue != null && typedValue.type != 0) {
                                if (typedValue.type != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (typedValue.type == 6) {
                                    fraction = typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                                } else {
                                    i3 = 0;
                                    if (i3 > 0) {
                                        i3 -= this.g.left + this.g.right;
                                    }
                                    if (measuredWidth < i3) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                        if (z2) {
                                            super.onMeasure(makeMeasureSpec, i2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i3 = (int) fraction;
                                if (i3 > 0) {
                                }
                                if (measuredWidth < i3) {
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                }
                i5 = (int) fraction3;
                if (i5 > 0) {
                }
            }
        }
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i, i2);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z) {
            if (!z3) {
            }
            if (typedValue != null) {
                if (typedValue.type != 5) {
                }
                i3 = (int) fraction;
                if (i3 > 0) {
                }
                if (measuredWidth < i3) {
                }
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.f871a == null) {
            this.f871a = new TypedValue();
        }
        return this.f871a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f872b == null) {
            this.f872b = new TypedValue();
        }
        return this.f872b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f873c == null) {
            this.f873c = new TypedValue();
        }
        return this.f873c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f874d == null) {
            this.f874d = new TypedValue();
        }
        return this.f874d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f875e == null) {
            this.f875e = new TypedValue();
        }
        return this.f875e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }
}
