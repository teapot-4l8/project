package com.speed.speed_library.widget.bar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.speed.speed_library.R;

/* loaded from: classes2.dex */
public class NumberProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f5915a;

    /* renamed from: b  reason: collision with root package name */
    private int f5916b;

    /* renamed from: c  reason: collision with root package name */
    private int f5917c;

    /* renamed from: d  reason: collision with root package name */
    private int f5918d;

    /* renamed from: e  reason: collision with root package name */
    private int f5919e;
    private float f;
    private float g;
    private float h;
    private String i;
    private String j;
    private float k;
    private float l;
    private String m;
    private Paint n;
    private Paint o;
    private Paint p;

    /* renamed from: q  reason: collision with root package name */
    private RectF f5920q;
    private RectF r;
    private float s;
    private boolean t;
    private boolean u;
    private boolean v;
    private a w;

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public enum b {
        VISIBLE,
        INVISIBLE
    }

    public NumberProgressBar(Context context) {
        this(context, null);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5915a = 100;
        this.f5916b = 0;
        this.i = "%";
        this.j = "";
        this.f5920q = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.r = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.t = true;
        this.u = true;
        this.v = true;
        float a2 = a(1.5f);
        float a3 = a(1.0f);
        float b2 = b(10.0f);
        float a4 = a(3.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.NumberProgressBar, i, 0);
        this.f5917c = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_reached_color, Color.rgb(66, 145, 241));
        this.f5918d = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_unreached_color, Color.rgb(204, 204, 204));
        this.f5919e = obtainStyledAttributes.getColor(R.styleable.NumberProgressBar_progress_text_color, Color.rgb(66, 145, 241));
        this.f = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_text_size, b2);
        this.g = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_reached_bar_height, a2);
        this.h = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_unreached_bar_height, a3);
        this.s = obtainStyledAttributes.getDimension(R.styleable.NumberProgressBar_progress_text_offset, a4);
        if (obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_text_visibility, 0) != 0) {
            this.v = false;
        }
        setProgress(obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_current, 0));
        setMax(obtainStyledAttributes.getInt(R.styleable.NumberProgressBar_progress_max, 100));
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.f;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.f, Math.max((int) this.g, (int) this.h));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i, true), a(i2, false));
    }

    private int a(int i, boolean z) {
        int paddingTop;
        int paddingBottom;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (z) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i2 = paddingTop + paddingBottom;
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + i2;
        if (mode == Integer.MIN_VALUE) {
            if (z) {
                return Math.max(suggestedMinimumWidth, size);
            }
            return Math.min(suggestedMinimumWidth, size);
        }
        return suggestedMinimumWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.v) {
            c();
        } else {
            b();
        }
        if (this.u) {
            canvas.drawRect(this.r, this.n);
        }
        if (this.t) {
            canvas.drawRect(this.f5920q, this.o);
        }
        if (this.v) {
            canvas.drawText(this.m, this.k, this.l, this.p);
        }
    }

    private void a() {
        Paint paint = new Paint(1);
        this.n = paint;
        paint.setColor(this.f5917c);
        Paint paint2 = new Paint(1);
        this.o = paint2;
        paint2.setColor(this.f5918d);
        Paint paint3 = new Paint(1);
        this.p = paint3;
        paint3.setColor(this.f5919e);
        this.p.setTextSize(this.f);
    }

    private void b() {
        this.r.left = getPaddingLeft();
        this.r.top = (getHeight() / 2.0f) - (this.g / 2.0f);
        this.r.right = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) + getPaddingLeft();
        this.r.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
        this.f5920q.left = this.r.right;
        this.f5920q.right = getWidth() - getPaddingRight();
        this.f5920q.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.f5920q.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    private void c() {
        this.m = String.format("%d", Integer.valueOf((getProgress() * 100) / getMax()));
        String str = this.j + this.m + this.i;
        this.m = str;
        float measureText = this.p.measureText(str);
        if (getProgress() == 0) {
            this.u = false;
            this.k = getPaddingLeft();
        } else {
            this.u = true;
            this.r.left = getPaddingLeft();
            this.r.top = (getHeight() / 2.0f) - (this.g / 2.0f);
            this.r.right = (((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) - this.s) + getPaddingLeft();
            this.r.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
            this.k = this.r.right + this.s;
        }
        this.l = (int) ((getHeight() / 2.0f) - ((this.p.descent() + this.p.ascent()) / 2.0f));
        if (this.k + measureText >= getWidth() - getPaddingRight()) {
            float width = (getWidth() - getPaddingRight()) - measureText;
            this.k = width;
            this.r.right = width - this.s;
        }
        float f = this.k + measureText + this.s;
        if (f >= getWidth() - getPaddingRight()) {
            this.t = false;
            return;
        }
        this.t = true;
        this.f5920q.left = f;
        this.f5920q.right = getWidth() - getPaddingRight();
        this.f5920q.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.f5920q.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    public int getTextColor() {
        return this.f5919e;
    }

    public float getProgressTextSize() {
        return this.f;
    }

    public void setProgressTextSize(float f) {
        this.f = f;
        this.p.setTextSize(f);
        invalidate();
    }

    public int getUnreachedBarColor() {
        return this.f5918d;
    }

    public void setUnreachedBarColor(int i) {
        this.f5918d = i;
        this.o.setColor(i);
        invalidate();
    }

    public int getReachedBarColor() {
        return this.f5917c;
    }

    public void setReachedBarColor(int i) {
        this.f5917c = i;
        this.n.setColor(i);
        invalidate();
    }

    public int getProgress() {
        return this.f5916b;
    }

    public void setProgress(int i) {
        if (i > getMax() || i < 0) {
            return;
        }
        this.f5916b = i;
        invalidate();
    }

    public int getMax() {
        return this.f5915a;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f5915a = i;
            invalidate();
        }
    }

    public float getReachedBarHeight() {
        return this.g;
    }

    public void setReachedBarHeight(float f) {
        this.g = f;
    }

    public float getUnreachedBarHeight() {
        return this.h;
    }

    public void setUnreachedBarHeight(float f) {
        this.h = f;
    }

    public void setProgressTextColor(int i) {
        this.f5919e = i;
        this.p.setColor(i);
        invalidate();
    }

    public String getSuffix() {
        return this.i;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.i = "";
        } else {
            this.i = str;
        }
    }

    public String getPrefix() {
        return this.j;
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.j = "";
        } else {
            this.j = str;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getProgressTextSize());
        bundle.putFloat("reached_bar_height", getReachedBarHeight());
        bundle.putFloat("unreached_bar_height", getUnreachedBarHeight());
        bundle.putInt("reached_bar_color", getReachedBarColor());
        bundle.putInt("unreached_bar_color", getUnreachedBarColor());
        bundle.putInt("max", getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffix());
        bundle.putString("prefix", getPrefix());
        bundle.putBoolean("text_visibility", getProgressTextVisibility());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f5919e = bundle.getInt("text_color");
            this.f = bundle.getFloat("text_size");
            this.g = bundle.getFloat("reached_bar_height");
            this.h = bundle.getFloat("unreached_bar_height");
            this.f5917c = bundle.getInt("reached_bar_color");
            this.f5918d = bundle.getInt("unreached_bar_color");
            a();
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt("progress"));
            setPrefix(bundle.getString("prefix"));
            setSuffix(bundle.getString("suffix"));
            setProgressTextVisibility(bundle.getBoolean("text_visibility") ? b.VISIBLE : b.INVISIBLE);
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public float a(float f) {
        return (f * getResources().getDisplayMetrics().density) + 0.5f;
    }

    public float b(float f) {
        return f * getResources().getDisplayMetrics().scaledDensity;
    }

    public boolean getProgressTextVisibility() {
        return this.v;
    }

    public void setProgressTextVisibility(b bVar) {
        this.v = bVar == b.VISIBLE;
        invalidate();
    }

    public void setOnProgressBarListener(a aVar) {
        this.w = aVar;
    }
}
