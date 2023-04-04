package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.b.f;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1018a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1019b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1020c;

    public static aw a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new aw(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static aw a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new aw(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static aw a(Context context, int i, int[] iArr) {
        return new aw(context, context.obtainStyledAttributes(i, iArr));
    }

    private aw(Context context, TypedArray typedArray) {
        this.f1018a = context;
        this.f1019b = typedArray;
    }

    public TypedArray a() {
        return this.f1019b;
    }

    public Drawable a(int i) {
        int resourceId;
        if (this.f1019b.hasValue(i) && (resourceId = this.f1019b.getResourceId(i, 0)) != 0) {
            return androidx.appcompat.a.a.a.b(this.f1018a, resourceId);
        }
        return this.f1019b.getDrawable(i);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f1019b.hasValue(i) || (resourceId = this.f1019b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return k.b().a(this.f1018a, resourceId, true);
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.f1019b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1020c == null) {
            this.f1020c = new TypedValue();
        }
        return androidx.core.content.b.f.a(this.f1018a, resourceId, this.f1020c, i2, aVar);
    }

    public CharSequence c(int i) {
        return this.f1019b.getText(i);
    }

    public String d(int i) {
        return this.f1019b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.f1019b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f1019b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.f1019b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.f1019b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        int resourceId;
        ColorStateList a2;
        return (!this.f1019b.hasValue(i) || (resourceId = this.f1019b.getResourceId(i, 0)) == 0 || (a2 = androidx.appcompat.a.a.a.a(this.f1018a, resourceId)) == null) ? this.f1019b.getColorStateList(i) : a2;
    }

    public int c(int i, int i2) {
        return this.f1019b.getInteger(i, i2);
    }

    public float b(int i, float f) {
        return this.f1019b.getDimension(i, f);
    }

    public int d(int i, int i2) {
        return this.f1019b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.f1019b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.f1019b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f1019b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f1019b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f1019b.hasValue(i);
    }

    public void b() {
        this.f1019b.recycle();
    }
}
