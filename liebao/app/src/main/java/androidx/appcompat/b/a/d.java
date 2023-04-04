package androidx.appcompat.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a.b;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.am;
import androidx.core.content.b.g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateListDrawable.java */
/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    private a f689a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f690b;

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    d() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b2 = this.f689a.b(iArr);
        if (b2 < 0) {
            b2 = this.f689a.b(StateSet.WILD_CARD);
        }
        return a(b2) || onStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(a2.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.f689a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.z);
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        a aVar = this.f689a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray a2 = g.a(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                int resourceId = a2.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                Drawable a3 = resourceId > 0 ? am.a().a(context, resourceId) : null;
                a2.recycle();
                int[] a4 = a(attributeSet);
                if (a3 == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        a3 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.a(a4, a3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f690b && super.mutate() == this) {
            this.f689a.a();
            this.f690b = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.b
    /* renamed from: b */
    public a c() {
        return new a(this.f689a, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends b.AbstractC0023b {
        int[][] L;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()];
            }
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0023b
        void a() {
            int[][] iArr = this.L;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.L = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a(int[] iArr, Drawable drawable) {
            int a2 = a(drawable);
            this.L[a2] = iArr;
            return a2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d2 = d();
            for (int i = 0; i < d2; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0023b
        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.b
    public void a(b.AbstractC0023b abstractC0023b) {
        super.a(abstractC0023b);
        if (abstractC0023b instanceof a) {
            this.f689a = (a) abstractC0023b;
        }
    }

    d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }
}
