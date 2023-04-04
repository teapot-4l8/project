package androidx.core.content.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.GradientColor);
        float a3 = g.a(a2, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float a4 = g.a(a2, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float a5 = g.a(a2, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float a6 = g.a(a2, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float a7 = g.a(a2, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float a8 = g.a(a2, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int a9 = g.a(a2, xmlPullParser, com.umeng.analytics.pro.d.y, R.styleable.GradientColor_android_type, 0);
        int b2 = g.b(a2, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean a10 = g.a(xmlPullParser, "centerColor");
        int b3 = g.b(a2, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int b4 = g.b(a2, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int a11 = g.a(a2, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float a12 = g.a(a2, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        a2.recycle();
        a a13 = a(b(resources, xmlPullParser, attributeSet, theme), b2, b4, a10, b3);
        if (a9 != 1) {
            if (a9 == 2) {
                return new SweepGradient(a7, a8, a13.f1491a, a13.f1492b);
            }
            return new LinearGradient(a3, a4, a5, a6, a13.f1491a, a13.f1492b, a(a11));
        } else if (a12 <= 0.0f) {
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        } else {
            return new RadialGradient(a7, a8, a12, a13.f1491a, a13.f1492b, a(a11));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.GradientColorItem);
                boolean hasValue = a2.hasValue(R.styleable.GradientColorItem_android_color);
                boolean hasValue2 = a2.hasValue(R.styleable.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = a2.getColor(R.styleable.GradientColorItem_android_color, 0);
                float f = a2.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                a2.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i, i3, i2);
        }
        return new a(i, i2);
    }

    private static Shader.TileMode a(int i) {
        if (i != 1) {
            if (i == 2) {
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1491a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f1492b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f1491a = new int[size];
            this.f1492b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f1491a[i] = list.get(i).intValue();
                this.f1492b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.f1491a = new int[]{i, i2};
            this.f1492b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.f1491a = new int[]{i, i2, i3};
            this.f1492b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
