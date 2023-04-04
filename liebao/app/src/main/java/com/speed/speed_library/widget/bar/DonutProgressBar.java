package com.speed.speed_library.widget.bar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.speed.speed_library.R;

/* loaded from: classes2.dex */
public class DonutProgressBar extends View {
    private final float A;
    private final int B;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final float I;
    private final float J;
    private final int K;

    /* renamed from: a  reason: collision with root package name */
    protected Paint f5909a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f5910b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f5911c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f5912d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f5913e;
    private RectF f;
    private RectF g;
    private int h;
    private boolean i;
    private float j;
    private int k;
    private int l;
    private float m;
    private int n;
    private int o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private int f5914q;
    private float r;
    private float s;
    private int t;
    private String u;
    private String v;
    private String w;
    private float x;
    private String y;
    private float z;

    public DonutProgressBar(Context context) {
        this(context, null);
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new RectF();
        this.g = new RectF();
        this.h = 0;
        this.m = 0.0f;
        this.u = "";
        this.v = "%";
        this.w = null;
        this.B = Color.rgb(66, 145, 241);
        this.C = Color.rgb(204, 204, 204);
        this.D = Color.rgb(66, 145, 241);
        this.E = Color.rgb(66, 145, 241);
        this.F = 0;
        this.G = 100;
        this.H = 0;
        this.I = b(getResources(), 18.0f);
        this.K = (int) a(getResources(), 100.0f);
        this.A = a(getResources(), 10.0f);
        this.J = b(getResources(), 18.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DonutProgressBar, i, 0);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        a();
    }

    protected void a() {
        if (this.i) {
            TextPaint textPaint = new TextPaint();
            this.f5909a = textPaint;
            textPaint.setColor(this.k);
            this.f5909a.setTextSize(this.j);
            this.f5909a.setAntiAlias(true);
            TextPaint textPaint2 = new TextPaint();
            this.f5910b = textPaint2;
            textPaint2.setColor(this.l);
            this.f5910b.setTextSize(this.x);
            this.f5910b.setAntiAlias(true);
        }
        Paint paint = new Paint();
        this.f5911c = paint;
        paint.setColor(this.o);
        this.f5911c.setStyle(Paint.Style.STROKE);
        this.f5911c.setAntiAlias(true);
        this.f5911c.setStrokeWidth(this.r);
        Paint paint2 = new Paint();
        this.f5912d = paint2;
        paint2.setColor(this.p);
        this.f5912d.setStyle(Paint.Style.STROKE);
        this.f5912d.setAntiAlias(true);
        this.f5912d.setStrokeWidth(this.s);
        Paint paint3 = new Paint();
        this.f5913e = paint3;
        paint3.setColor(this.t);
        this.f5913e.setAntiAlias(true);
    }

    protected void a(TypedArray typedArray) {
        this.o = typedArray.getColor(R.styleable.DonutProgressBar_donut_finished_color, this.B);
        this.p = typedArray.getColor(R.styleable.DonutProgressBar_donut_unfinished_color, this.C);
        this.i = typedArray.getBoolean(R.styleable.DonutProgressBar_donut_show_text, true);
        this.h = typedArray.getResourceId(R.styleable.DonutProgressBar_donut_inner_drawable, 0);
        setMax(typedArray.getInt(R.styleable.DonutProgressBar_donut_max, 100));
        setProgress(typedArray.getFloat(R.styleable.DonutProgressBar_donut_progress, 0.0f));
        this.r = typedArray.getDimension(R.styleable.DonutProgressBar_donut_finished_stroke_width, this.A);
        this.s = typedArray.getDimension(R.styleable.DonutProgressBar_donut_unfinished_stroke_width, this.A);
        if (this.i) {
            if (typedArray.getString(R.styleable.DonutProgressBar_donut_prefix_text) != null) {
                this.u = typedArray.getString(R.styleable.DonutProgressBar_donut_prefix_text);
            }
            if (typedArray.getString(R.styleable.DonutProgressBar_donut_suffix_text) != null) {
                this.v = typedArray.getString(R.styleable.DonutProgressBar_donut_suffix_text);
            }
            if (typedArray.getString(R.styleable.DonutProgressBar_donut_text) != null) {
                this.w = typedArray.getString(R.styleable.DonutProgressBar_donut_text);
            }
            this.k = typedArray.getColor(R.styleable.DonutProgressBar_donut_text_color, this.D);
            this.j = typedArray.getDimension(R.styleable.DonutProgressBar_donut_text_size, this.I);
            this.x = typedArray.getDimension(R.styleable.DonutProgressBar_donut_inner_bottom_text_size, this.J);
            this.l = typedArray.getColor(R.styleable.DonutProgressBar_donut_inner_bottom_text_color, this.E);
            this.y = typedArray.getString(R.styleable.DonutProgressBar_donut_inner_bottom_text);
        }
        this.x = typedArray.getDimension(R.styleable.DonutProgressBar_donut_inner_bottom_text_size, this.J);
        this.l = typedArray.getColor(R.styleable.DonutProgressBar_donut_inner_bottom_text_color, this.E);
        this.y = typedArray.getString(R.styleable.DonutProgressBar_donut_inner_bottom_text);
        this.f5914q = typedArray.getInt(R.styleable.DonutProgressBar_donut_circle_starting_degree, 0);
        this.t = typedArray.getColor(R.styleable.DonutProgressBar_donut_background_color, 0);
    }

    @Override // android.view.View
    public void invalidate() {
        a();
        super.invalidate();
    }

    public void setShowText(boolean z) {
        this.i = z;
    }

    public float getFinishedStrokeWidth() {
        return this.r;
    }

    public void setFinishedStrokeWidth(float f) {
        this.r = f;
        invalidate();
    }

    public float getUnfinishedStrokeWidth() {
        return this.s;
    }

    public void setUnfinishedStrokeWidth(float f) {
        this.s = f;
        invalidate();
    }

    private float getProgressAngle() {
        return (getProgress() / this.n) * 360.0f;
    }

    public float getProgress() {
        return this.m;
    }

    public void setProgress(float f) {
        this.m = f;
        if (f > getMax()) {
            this.m %= getMax();
        }
        invalidate();
    }

    public int getMax() {
        return this.n;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.n = i;
            invalidate();
        }
    }

    public float getTextSize() {
        return this.j;
    }

    public void setTextSize(float f) {
        this.j = f;
        invalidate();
    }

    public int getTextColor() {
        return this.k;
    }

    public void setTextColor(int i) {
        this.k = i;
        invalidate();
    }

    public int getFinishedStrokeColor() {
        return this.o;
    }

    public void setFinishedStrokeColor(int i) {
        this.o = i;
        invalidate();
    }

    public int getUnfinishedStrokeColor() {
        return this.p;
    }

    public void setUnfinishedStrokeColor(int i) {
        this.p = i;
        invalidate();
    }

    public String getText() {
        return this.w;
    }

    public void setText(String str) {
        this.w = str;
        invalidate();
    }

    public String getSuffixText() {
        return this.v;
    }

    public void setSuffixText(String str) {
        this.v = str;
        invalidate();
    }

    public String getPrefixText() {
        return this.u;
    }

    public void setPrefixText(String str) {
        this.u = str;
        invalidate();
    }

    public int getInnerBackgroundColor() {
        return this.t;
    }

    public void setInnerBackgroundColor(int i) {
        this.t = i;
        invalidate();
    }

    public String getInnerBottomText() {
        return this.y;
    }

    public void setInnerBottomText(String str) {
        this.y = str;
        invalidate();
    }

    public float getInnerBottomTextSize() {
        return this.x;
    }

    public void setInnerBottomTextSize(float f) {
        this.x = f;
        invalidate();
    }

    public int getInnerBottomTextColor() {
        return this.l;
    }

    public void setInnerBottomTextColor(int i) {
        this.l = i;
        invalidate();
    }

    public int getStartingDegree() {
        return this.f5914q;
    }

    public void setStartingDegree(int i) {
        this.f5914q = i;
        invalidate();
    }

    public int getAttributeResourceId() {
        return this.h;
    }

    public void setAttributeResourceId(int i) {
        this.h = i;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), a(i2));
        this.z = getHeight() - ((getHeight() * 3) / 4);
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.K;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap decodeResource;
        super.onDraw(canvas);
        float max = Math.max(this.r, this.s);
        this.f.set(max, max, getWidth() - max, getHeight() - max);
        this.g.set(max, max, getWidth() - max, getHeight() - max);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - Math.min(this.r, this.s)) + Math.abs(this.r - this.s)) / 2.0f, this.f5913e);
        canvas.drawArc(this.f, getStartingDegree(), getProgressAngle(), false, this.f5911c);
        canvas.drawArc(this.g, getProgressAngle() + getStartingDegree(), 360.0f - getProgressAngle(), false, this.f5912d);
        if (this.i) {
            String str = this.w;
            if (str == null) {
                str = this.u + this.m + this.v;
            }
            if (!TextUtils.isEmpty(str)) {
                canvas.drawText(str, (getWidth() - this.f5909a.measureText(str)) / 2.0f, (getWidth() - (this.f5909a.descent() + this.f5909a.ascent())) / 2.0f, this.f5909a);
            }
            if (!TextUtils.isEmpty(getInnerBottomText())) {
                this.f5910b.setTextSize(this.x);
                canvas.drawText(getInnerBottomText(), (getWidth() - this.f5910b.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.z) - ((this.f5909a.descent() + this.f5909a.ascent()) / 2.0f), this.f5910b);
            }
        }
        if (this.h != 0) {
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), this.h), (getWidth() - decodeResource.getWidth()) / 2.0f, (getHeight() - decodeResource.getHeight()) / 2.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt("starting_degree", getStartingDegree());
        bundle.putFloat("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putString("text", getText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putFloat("unfinished_stroke_width", getUnfinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        bundle.putInt("inner_drawable", getAttributeResourceId());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.k = bundle.getInt("text_color");
            this.j = bundle.getFloat("text_size");
            this.x = bundle.getFloat("inner_bottom_text_size");
            this.y = bundle.getString("inner_bottom_text");
            this.l = bundle.getInt("inner_bottom_text_color");
            this.o = bundle.getInt("finished_stroke_color");
            this.p = bundle.getInt("unfinished_stroke_color");
            this.r = bundle.getFloat("finished_stroke_width");
            this.s = bundle.getFloat("unfinished_stroke_width");
            this.t = bundle.getInt("inner_background_color");
            this.h = bundle.getInt("inner_drawable");
            a();
            setMax(bundle.getInt("max"));
            setStartingDegree(bundle.getInt("starting_degree"));
            setProgress(bundle.getFloat("progress"));
            this.u = bundle.getString("prefix");
            this.v = bundle.getString("suffix");
            this.w = bundle.getString("text");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setDonut_progress(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setProgress(Integer.parseInt(str));
    }

    public static float a(Resources resources, float f) {
        return (f * resources.getDisplayMetrics().density) + 0.5f;
    }

    public static float b(Resources resources, float f) {
        return f * resources.getDisplayMetrics().scaledDensity;
    }
}
