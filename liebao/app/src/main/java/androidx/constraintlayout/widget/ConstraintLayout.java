package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.a.g;
import androidx.constraintlayout.a.a.i;
import androidx.constraintlayout.a.a.m;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f1355a;

    /* renamed from: b  reason: collision with root package name */
    g f1356b;

    /* renamed from: c  reason: collision with root package name */
    int f1357c;

    /* renamed from: d  reason: collision with root package name */
    int f1358d;

    /* renamed from: e  reason: collision with root package name */
    int f1359e;
    int f;
    private ArrayList<b> g;
    private final ArrayList<androidx.constraintlayout.a.a.f> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private c o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private HashMap<String, Integer> f1360q;
    private int r;
    private int s;
    private androidx.constraintlayout.a.f t;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1360q == null) {
                this.f1360q = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1360q.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object a(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.f1360q;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.f1360q.get(str);
        }
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.f1355a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.f1356b = new g();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 7;
        this.o = null;
        this.p = -1;
        this.f1360q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.f1357c = -1;
        this.f1358d = -1;
        this.f1359e = 0;
        this.f = 0;
        b((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1355a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.f1356b = new g();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 7;
        this.o = null;
        this.p = -1;
        this.f1360q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.f1357c = -1;
        this.f1358d = -1;
        this.f1359e = 0;
        this.f = 0;
        b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1355a = new SparseArray<>();
        this.g = new ArrayList<>(4);
        this.h = new ArrayList<>(100);
        this.f1356b = new g();
        this.i = 0;
        this.j = 0;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = true;
        this.n = 7;
        this.o = null;
        this.p = -1;
        this.f1360q = new HashMap<>();
        this.r = -1;
        this.s = -1;
        this.f1357c = -1;
        this.f1358d = -1;
        this.f1359e = 0;
        this.f = 0;
        b(attributeSet);
    }

    @Override // android.view.View
    public void setId(int i) {
        this.f1355a.remove(getId());
        super.setId(i);
        this.f1355a.put(getId(), this);
    }

    private void b(AttributeSet attributeSet) {
        this.f1356b.a(this);
        this.f1355a.put(getId(), this);
        this.o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.j = obtainStyledAttributes.getDimensionPixelOffset(index, this.j);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.k = obtainStyledAttributes.getDimensionPixelOffset(index, this.k);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.l = obtainStyledAttributes.getDimensionPixelOffset(index, this.l);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        c cVar = new c();
                        this.o = cVar;
                        cVar.a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.o = null;
                    }
                    this.p = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1356b.a(this.n);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        androidx.constraintlayout.a.a.f a2 = a(view);
        if ((view instanceof e) && !(a2 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            aVar.al = new i();
            aVar.Y = true;
            ((i) aVar.al).a(aVar.S);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.g.contains(bVar)) {
                this.g.add(bVar);
            }
        }
        this.f1355a.put(view.getId(), view);
        this.m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f1355a.remove(view.getId());
        androidx.constraintlayout.a.a.f a2 = a(view);
        this.f1356b.c(a2);
        this.g.remove(view);
        this.h.remove(a2);
        this.m = true;
    }

    public void setMinWidth(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.j) {
            return;
        }
        this.j = i;
        requestLayout();
    }

    public int getMinWidth() {
        return this.i;
    }

    public int getMinHeight() {
        return this.j;
    }

    public void setMaxWidth(int i) {
        if (i == this.k) {
            return;
        }
        this.k = i;
        requestLayout();
    }

    public void setMaxHeight(int i) {
        if (i == this.l) {
            return;
        }
        this.l = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMaxHeight() {
        return this.l;
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.h.clear();
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v62 */
    private void c() {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        androidx.constraintlayout.a.a.f b2;
        androidx.constraintlayout.a.a.f b3;
        androidx.constraintlayout.a.a.f b4;
        androidx.constraintlayout.a.a.f b5;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r3 = 0;
        if (isInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    a(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    b(childAt.getId()).a(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            androidx.constraintlayout.a.a.f a2 = a(getChildAt(i5));
            if (a2 != null) {
                a2.f();
            }
        }
        if (this.p != -1) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (childAt2.getId() == this.p && (childAt2 instanceof d)) {
                    this.o = ((d) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.o;
        if (cVar != null) {
            cVar.a((ConstraintLayout) this);
        }
        this.f1356b.U();
        int size = this.g.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.g.get(i7).a((ConstraintLayout) this);
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt3 = getChildAt(i8);
            if (childAt3 instanceof f) {
                ((f) childAt3).a(this);
            }
        }
        int i9 = 0;
        while (i9 < childCount) {
            View childAt4 = getChildAt(i9);
            androidx.constraintlayout.a.a.f a3 = a(childAt4);
            if (a3 != null) {
                a aVar = (a) childAt4.getLayoutParams();
                aVar.a();
                if (aVar.am) {
                    aVar.am = r3;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        a(r3, resourceName2, Integer.valueOf(childAt4.getId()));
                        b(childAt4.getId()).a(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                a3.e(childAt4.getVisibility());
                if (aVar.aa) {
                    a3.e(8);
                }
                a3.a(childAt4);
                this.f1356b.b(a3);
                if (!aVar.W || !aVar.V) {
                    this.h.add(a3);
                }
                if (aVar.Y) {
                    i iVar = (i) a3;
                    int i10 = aVar.ai;
                    int i11 = aVar.aj;
                    float f3 = aVar.ak;
                    if (Build.VERSION.SDK_INT < 17) {
                        i10 = aVar.f1361a;
                        i11 = aVar.f1362b;
                        f3 = aVar.f1363c;
                    }
                    if (f3 != -1.0f) {
                        iVar.e(f3);
                    } else if (i10 != -1) {
                        iVar.u(i10);
                    } else if (i11 != -1) {
                        iVar.v(i11);
                    }
                } else if (aVar.f1364d != -1 || aVar.f1365e != -1 || aVar.f != -1 || aVar.g != -1 || aVar.f1366q != -1 || aVar.p != -1 || aVar.r != -1 || aVar.s != -1 || aVar.h != -1 || aVar.i != -1 || aVar.j != -1 || aVar.k != -1 || aVar.l != -1 || aVar.Q != -1 || aVar.R != -1 || aVar.m != -1 || aVar.width == -1 || aVar.height == -1) {
                    int i12 = aVar.ab;
                    int i13 = aVar.ac;
                    int i14 = aVar.ad;
                    int i15 = aVar.ae;
                    int i16 = aVar.af;
                    int i17 = aVar.ag;
                    float f4 = aVar.ah;
                    if (Build.VERSION.SDK_INT < 17) {
                        int i18 = aVar.f1364d;
                        int i19 = aVar.f1365e;
                        int i20 = aVar.f;
                        i15 = aVar.g;
                        int i21 = aVar.t;
                        int i22 = aVar.v;
                        float f5 = aVar.z;
                        if (i18 == -1 && i19 == -1) {
                            if (aVar.f1366q != -1) {
                                i18 = aVar.f1366q;
                            } else if (aVar.p != -1) {
                                i19 = aVar.p;
                            }
                        }
                        int i23 = i19;
                        i12 = i18;
                        if (i20 == -1 && i15 == -1) {
                            if (aVar.r != -1) {
                                i20 = aVar.r;
                            } else if (aVar.s != -1) {
                                i15 = aVar.s;
                            }
                        }
                        i3 = i21;
                        i2 = i22;
                        f = f5;
                        i13 = i23;
                        i = i20;
                    } else {
                        i = i14;
                        i2 = i17;
                        i3 = i16;
                        f = f4;
                    }
                    int i24 = i15;
                    if (aVar.m != -1) {
                        androidx.constraintlayout.a.a.f b6 = b(aVar.m);
                        if (b6 != null) {
                            a3.a(b6, aVar.o, aVar.n);
                        }
                    } else {
                        if (i12 != -1) {
                            androidx.constraintlayout.a.a.f b7 = b(i12);
                            if (b7 != null) {
                                f2 = f;
                                a3.a(e.c.LEFT, b7, e.c.LEFT, aVar.leftMargin, i3);
                            } else {
                                f2 = f;
                            }
                        } else {
                            f2 = f;
                            if (i13 != -1 && (b2 = b(i13)) != null) {
                                a3.a(e.c.LEFT, b2, e.c.RIGHT, aVar.leftMargin, i3);
                            }
                        }
                        if (i != -1) {
                            androidx.constraintlayout.a.a.f b8 = b(i);
                            if (b8 != null) {
                                a3.a(e.c.RIGHT, b8, e.c.LEFT, aVar.rightMargin, i2);
                            }
                        } else if (i24 != -1 && (b3 = b(i24)) != null) {
                            a3.a(e.c.RIGHT, b3, e.c.RIGHT, aVar.rightMargin, i2);
                        }
                        if (aVar.h != -1) {
                            androidx.constraintlayout.a.a.f b9 = b(aVar.h);
                            if (b9 != null) {
                                a3.a(e.c.TOP, b9, e.c.TOP, aVar.topMargin, aVar.u);
                            }
                        } else if (aVar.i != -1 && (b4 = b(aVar.i)) != null) {
                            a3.a(e.c.TOP, b4, e.c.BOTTOM, aVar.topMargin, aVar.u);
                        }
                        if (aVar.j != -1) {
                            androidx.constraintlayout.a.a.f b10 = b(aVar.j);
                            if (b10 != null) {
                                a3.a(e.c.BOTTOM, b10, e.c.TOP, aVar.bottomMargin, aVar.w);
                            }
                        } else if (aVar.k != -1 && (b5 = b(aVar.k)) != null) {
                            a3.a(e.c.BOTTOM, b5, e.c.BOTTOM, aVar.bottomMargin, aVar.w);
                        }
                        if (aVar.l != -1) {
                            View view = this.f1355a.get(aVar.l);
                            androidx.constraintlayout.a.a.f b11 = b(aVar.l);
                            if (b11 != null && view != null && (view.getLayoutParams() instanceof a)) {
                                aVar.X = true;
                                ((a) view.getLayoutParams()).X = true;
                                a3.a(e.c.BASELINE).a(b11.a(e.c.BASELINE), 0, -1, e.b.STRONG, 0, true);
                                a3.a(e.c.TOP).i();
                                a3.a(e.c.BOTTOM).i();
                            }
                        }
                        float f6 = f2;
                        if (f6 >= 0.0f && f6 != 0.5f) {
                            a3.a(f6);
                        }
                        if (aVar.A >= 0.0f && aVar.A != 0.5f) {
                            a3.b(aVar.A);
                        }
                    }
                    if (isInEditMode && (aVar.Q != -1 || aVar.R != -1)) {
                        a3.a(aVar.Q, aVar.R);
                    }
                    if (!aVar.V) {
                        if (aVar.width == -1) {
                            a3.a(f.a.MATCH_PARENT);
                            a3.a(e.c.LEFT).f1272d = aVar.leftMargin;
                            a3.a(e.c.RIGHT).f1272d = aVar.rightMargin;
                        } else {
                            a3.a(f.a.MATCH_CONSTRAINT);
                            a3.j(0);
                        }
                    } else {
                        a3.a(f.a.FIXED);
                        a3.j(aVar.width);
                    }
                    if (!aVar.W) {
                        if (aVar.height == -1) {
                            a3.b(f.a.MATCH_PARENT);
                            a3.a(e.c.TOP).f1272d = aVar.topMargin;
                            a3.a(e.c.BOTTOM).f1272d = aVar.bottomMargin;
                            r3 = 0;
                        } else {
                            a3.b(f.a.MATCH_CONSTRAINT);
                            r3 = 0;
                            a3.k(0);
                        }
                    } else {
                        r3 = 0;
                        a3.b(f.a.FIXED);
                        a3.k(aVar.height);
                    }
                    if (aVar.B != null) {
                        a3.b(aVar.B);
                    }
                    a3.c(aVar.E);
                    a3.d(aVar.F);
                    a3.r(aVar.G);
                    a3.s(aVar.H);
                    a3.a(aVar.I, aVar.K, aVar.M, aVar.O);
                    a3.b(aVar.J, aVar.L, aVar.N, aVar.P);
                }
            }
            i9++;
            r3 = r3;
        }
    }

    private final androidx.constraintlayout.a.a.f b(int i) {
        if (i == 0) {
            return this.f1356b;
        }
        View view = this.f1355a.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1356b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    public final androidx.constraintlayout.a.a.f a(View view) {
        if (view == this) {
            return this.f1356b;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).al;
    }

    private void a(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                androidx.constraintlayout.a.a.f fVar = aVar.al;
                if (!aVar.Y && !aVar.Z) {
                    fVar.e(childAt.getVisibility());
                    int i4 = aVar.width;
                    int i5 = aVar.height;
                    if (aVar.V || aVar.W || (!aVar.V && aVar.I == 1) || aVar.width == -1 || (!aVar.W && (aVar.J == 1 || aVar.height == -1))) {
                        if (i4 == 0) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                            z = true;
                        } else if (i4 == -1) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -1);
                            z = false;
                        } else {
                            z = i4 == -2;
                            childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i4);
                        }
                        if (i5 == 0) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                            z2 = true;
                        } else if (i5 == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = i5 == -2;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        androidx.constraintlayout.a.f fVar2 = this.t;
                        if (fVar2 != null) {
                            fVar2.f1337a++;
                        }
                        fVar.b(i4 == -2);
                        fVar.c(i5 == -2);
                        i4 = childAt.getMeasuredWidth();
                        i5 = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    fVar.j(i4);
                    fVar.k(i5);
                    if (z) {
                        fVar.n(i4);
                    }
                    if (z2) {
                        fVar.o(i5);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        fVar.q(baseline);
                    }
                }
            }
        }
    }

    private void d() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof f) {
                ((f) childAt).b(this);
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.g.get(i2).c(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02cd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, int i2) {
        long j;
        int i3;
        ConstraintLayout constraintLayout;
        int i4;
        int i5;
        long j2;
        boolean z;
        int childMeasureSpec;
        boolean z2;
        int childMeasureSpec2;
        androidx.constraintlayout.a.f fVar;
        int baseline;
        int i6;
        int baseline2;
        ConstraintLayout constraintLayout2 = this;
        int i7 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            j = 1;
            i3 = 8;
            if (i8 >= childCount) {
                break;
            }
            View childAt = constraintLayout2.getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                androidx.constraintlayout.a.a.f fVar2 = aVar.al;
                if (!aVar.Y && !aVar.Z) {
                    fVar2.e(childAt.getVisibility());
                    int i9 = aVar.width;
                    int i10 = aVar.height;
                    if (i9 == 0 || i10 == 0) {
                        i6 = paddingTop;
                        fVar2.i().e();
                        fVar2.j().e();
                    } else {
                        boolean z3 = i9 == -2;
                        int childMeasureSpec3 = getChildMeasureSpec(i, paddingLeft, i9);
                        boolean z4 = i10 == -2;
                        childAt.measure(childMeasureSpec3, getChildMeasureSpec(i7, paddingTop, i10));
                        androidx.constraintlayout.a.f fVar3 = constraintLayout2.t;
                        i6 = paddingTop;
                        if (fVar3 != null) {
                            fVar3.f1337a++;
                        }
                        fVar2.b(i9 == -2);
                        fVar2.c(i10 == -2);
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        fVar2.j(measuredWidth);
                        fVar2.k(measuredHeight);
                        if (z3) {
                            fVar2.n(measuredWidth);
                        }
                        if (z4) {
                            fVar2.o(measuredHeight);
                        }
                        if (aVar.X && (baseline2 = childAt.getBaseline()) != -1) {
                            fVar2.q(baseline2);
                        }
                        if (aVar.V && aVar.W) {
                            fVar2.i().a(measuredWidth);
                            fVar2.j().a(measuredHeight);
                        }
                    }
                    i8++;
                    i7 = i2;
                    paddingTop = i6;
                }
            }
            i6 = paddingTop;
            i8++;
            i7 = i2;
            paddingTop = i6;
        }
        int i11 = paddingTop;
        constraintLayout2.f1356b.P();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt2 = constraintLayout2.getChildAt(i12);
            if (childAt2.getVisibility() != i3) {
                a aVar2 = (a) childAt2.getLayoutParams();
                androidx.constraintlayout.a.a.f fVar4 = aVar2.al;
                if (!aVar2.Y && !aVar2.Z) {
                    fVar4.e(childAt2.getVisibility());
                    int i13 = aVar2.width;
                    int i14 = aVar2.height;
                    if (i13 == 0 || i14 == 0) {
                        m a2 = fVar4.a(e.c.LEFT).a();
                        m a3 = fVar4.a(e.c.RIGHT).a();
                        boolean z5 = (fVar4.a(e.c.LEFT).g() == null || fVar4.a(e.c.RIGHT).g() == null) ? false : true;
                        m a4 = fVar4.a(e.c.TOP).a();
                        m a5 = fVar4.a(e.c.BOTTOM).a();
                        i5 = childCount;
                        boolean z6 = (fVar4.a(e.c.TOP).g() == null || fVar4.a(e.c.BOTTOM).g() == null) ? false : true;
                        if (i13 == 0 && i14 == 0 && z5 && z6) {
                            constraintLayout = constraintLayout2;
                            i4 = i12;
                            j2 = 1;
                        } else {
                            i4 = i12;
                            boolean z7 = constraintLayout2.f1356b.F() != f.a.WRAP_CONTENT;
                            boolean z8 = constraintLayout2.f1356b.G() != f.a.WRAP_CONTENT;
                            if (!z7) {
                                fVar4.i().e();
                            }
                            if (!z8) {
                                fVar4.j().e();
                            }
                            if (i13 == 0) {
                                if (z7 && fVar4.d() && z5 && a2.g() && a3.g()) {
                                    i13 = (int) (a3.d() - a2.d());
                                    fVar4.i().a(i13);
                                    childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i13);
                                    z = false;
                                    if (i14 != 0) {
                                    }
                                } else {
                                    childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -2);
                                    z7 = false;
                                    z = true;
                                    if (i14 != 0) {
                                        if (z8 && fVar4.e() && z6 && a4.g() && a5.g()) {
                                            i14 = (int) (a5.d() - a4.d());
                                            fVar4.j().a(i14);
                                            childMeasureSpec2 = getChildMeasureSpec(i2, i11, i14);
                                            z2 = false;
                                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                            constraintLayout = this;
                                            fVar = constraintLayout.t;
                                            if (fVar == null) {
                                            }
                                            fVar4.b(i13 != -2);
                                            fVar4.c(i14 != -2);
                                            int measuredWidth2 = childAt2.getMeasuredWidth();
                                            int measuredHeight2 = childAt2.getMeasuredHeight();
                                            fVar4.j(measuredWidth2);
                                            fVar4.k(measuredHeight2);
                                            if (z) {
                                            }
                                            if (z2) {
                                            }
                                            if (!z7) {
                                            }
                                            if (!z8) {
                                            }
                                            if (aVar2.X) {
                                                fVar4.q(baseline);
                                            }
                                        } else {
                                            childMeasureSpec2 = getChildMeasureSpec(i2, i11, -2);
                                            z8 = false;
                                            z2 = true;
                                            childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                            constraintLayout = this;
                                            fVar = constraintLayout.t;
                                            if (fVar == null) {
                                                j2 = 1;
                                                fVar.f1337a++;
                                            } else {
                                                j2 = 1;
                                            }
                                            fVar4.b(i13 != -2);
                                            fVar4.c(i14 != -2);
                                            int measuredWidth22 = childAt2.getMeasuredWidth();
                                            int measuredHeight22 = childAt2.getMeasuredHeight();
                                            fVar4.j(measuredWidth22);
                                            fVar4.k(measuredHeight22);
                                            if (z) {
                                                fVar4.n(measuredWidth22);
                                            }
                                            if (z2) {
                                                fVar4.o(measuredHeight22);
                                            }
                                            if (!z7) {
                                                fVar4.i().a(measuredWidth22);
                                            } else {
                                                fVar4.i().c();
                                            }
                                            if (!z8) {
                                                fVar4.j().a(measuredHeight22);
                                            } else {
                                                fVar4.j().c();
                                            }
                                            if (aVar2.X && (baseline = childAt2.getBaseline()) != -1) {
                                                fVar4.q(baseline);
                                            }
                                        }
                                    } else if (i14 == -1) {
                                        childMeasureSpec2 = getChildMeasureSpec(i2, i11, -1);
                                        z2 = false;
                                        childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                        constraintLayout = this;
                                        fVar = constraintLayout.t;
                                        if (fVar == null) {
                                        }
                                        fVar4.b(i13 != -2);
                                        fVar4.c(i14 != -2);
                                        int measuredWidth222 = childAt2.getMeasuredWidth();
                                        int measuredHeight222 = childAt2.getMeasuredHeight();
                                        fVar4.j(measuredWidth222);
                                        fVar4.k(measuredHeight222);
                                        if (z) {
                                        }
                                        if (z2) {
                                        }
                                        if (!z7) {
                                        }
                                        if (!z8) {
                                        }
                                        if (aVar2.X) {
                                        }
                                    } else {
                                        z2 = i14 == -2;
                                        childMeasureSpec2 = getChildMeasureSpec(i2, i11, i14);
                                        childAt2.measure(childMeasureSpec, childMeasureSpec2);
                                        constraintLayout = this;
                                        fVar = constraintLayout.t;
                                        if (fVar == null) {
                                        }
                                        fVar4.b(i13 != -2);
                                        fVar4.c(i14 != -2);
                                        int measuredWidth2222 = childAt2.getMeasuredWidth();
                                        int measuredHeight2222 = childAt2.getMeasuredHeight();
                                        fVar4.j(measuredWidth2222);
                                        fVar4.k(measuredHeight2222);
                                        if (z) {
                                        }
                                        if (z2) {
                                        }
                                        if (!z7) {
                                        }
                                        if (!z8) {
                                        }
                                        if (aVar2.X) {
                                        }
                                    }
                                }
                            } else if (i13 == -1) {
                                childMeasureSpec = getChildMeasureSpec(i, paddingLeft, -1);
                                z = false;
                                if (i14 != 0) {
                                }
                            } else {
                                z = i13 == -2;
                                childMeasureSpec = getChildMeasureSpec(i, paddingLeft, i13);
                                if (i14 != 0) {
                                }
                            }
                        }
                        i12 = i4 + 1;
                        constraintLayout2 = constraintLayout;
                        childCount = i5;
                        j = j2;
                        i3 = 8;
                    }
                }
            }
            constraintLayout = constraintLayout2;
            i4 = i12;
            i5 = childCount;
            j2 = j;
            i12 = i4 + 1;
            constraintLayout2 = constraintLayout;
            childCount = i5;
            j = j2;
            i3 = 8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0151  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int i7;
        int i8;
        boolean z5;
        int baseline;
        int i9 = i;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f1356b.h(paddingLeft);
        this.f1356b.i(paddingTop);
        this.f1356b.c(this.k);
        this.f1356b.d(this.l);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f1356b.a(getLayoutDirection() == 1);
        }
        c(i, i2);
        int p = this.f1356b.p();
        int r = this.f1356b.r();
        if (this.m) {
            this.m = false;
            b();
            z = true;
        } else {
            z = false;
        }
        boolean z6 = (this.n & 8) == 8;
        if (z6) {
            this.f1356b.O();
            this.f1356b.f(p, r);
            b(i, i2);
        } else {
            a(i, i2);
        }
        d();
        if (getChildCount() > 0 && z) {
            androidx.constraintlayout.a.a.a.a(this.f1356b);
        }
        if (this.f1356b.as) {
            if (this.f1356b.at && mode == Integer.MIN_VALUE) {
                if (this.f1356b.av < size2) {
                    g gVar = this.f1356b;
                    gVar.j(gVar.av);
                }
                this.f1356b.a(f.a.FIXED);
            }
            if (this.f1356b.au && mode2 == Integer.MIN_VALUE) {
                if (this.f1356b.aw < size3) {
                    g gVar2 = this.f1356b;
                    gVar2.k(gVar2.aw);
                }
                this.f1356b.b(f.a.FIXED);
            }
        }
        if ((this.n & 32) == 32) {
            int p2 = this.f1356b.p();
            int r2 = this.f1356b.r();
            if (this.r != p2 && mode == 1073741824) {
                androidx.constraintlayout.a.a.a.a(this.f1356b.ar, 0, p2);
            }
            if (this.s != r2 && mode2 == 1073741824) {
                androidx.constraintlayout.a.a.a.a(this.f1356b.ar, 1, r2);
            }
            if (this.f1356b.at && this.f1356b.av > size2) {
                androidx.constraintlayout.a.a.a.a(this.f1356b.ar, 0, size2);
            }
            if (this.f1356b.au && this.f1356b.aw > size3) {
                androidx.constraintlayout.a.a.a.a(this.f1356b.ar, 1, size3);
                if (getChildCount() > 0) {
                    a("First pass");
                }
                size = this.h.size();
                int paddingBottom = paddingTop + getPaddingBottom();
                int paddingRight = paddingLeft + getPaddingRight();
                if (size <= 0) {
                    boolean z7 = this.f1356b.F() == f.a.WRAP_CONTENT;
                    boolean z8 = this.f1356b.G() == f.a.WRAP_CONTENT;
                    int max = Math.max(this.f1356b.p(), this.i);
                    int max2 = Math.max(this.f1356b.r(), this.j);
                    int i10 = 0;
                    boolean z9 = false;
                    int i11 = 0;
                    while (i10 < size) {
                        androidx.constraintlayout.a.a.f fVar = this.h.get(i10);
                        int i12 = size;
                        View view = (View) fVar.B();
                        if (view == null) {
                            i6 = p;
                            i5 = r;
                        } else {
                            i5 = r;
                            a aVar = (a) view.getLayoutParams();
                            i6 = p;
                            if (!aVar.Z && !aVar.Y) {
                                z4 = z9;
                                if (view.getVisibility() != 8 && (!z6 || !fVar.i().g() || !fVar.j().g())) {
                                    if (aVar.width == -2 && aVar.V) {
                                        makeMeasureSpec = getChildMeasureSpec(i9, paddingRight, aVar.width);
                                    } else {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(fVar.p(), 1073741824);
                                    }
                                    if (aVar.height == -2 && aVar.W) {
                                        makeMeasureSpec2 = getChildMeasureSpec(i2, paddingBottom, aVar.height);
                                    } else {
                                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(fVar.r(), 1073741824);
                                    }
                                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                                    androidx.constraintlayout.a.f fVar2 = this.t;
                                    i7 = paddingBottom;
                                    if (fVar2 != null) {
                                        fVar2.f1338b++;
                                    }
                                    int measuredWidth = view.getMeasuredWidth();
                                    int measuredHeight = view.getMeasuredHeight();
                                    if (measuredWidth != fVar.p()) {
                                        fVar.j(measuredWidth);
                                        if (z6) {
                                            fVar.i().a(measuredWidth);
                                        }
                                        if (z7 && fVar.x() > max) {
                                            max = Math.max(max, fVar.x() + fVar.a(e.c.RIGHT).e());
                                        }
                                        z4 = true;
                                    }
                                    if (measuredHeight != fVar.r()) {
                                        fVar.k(measuredHeight);
                                        if (z6) {
                                            fVar.j().a(measuredHeight);
                                        }
                                        if (z8 && fVar.y() > max2) {
                                            max2 = Math.max(max2, fVar.y() + fVar.a(e.c.BOTTOM).e());
                                        }
                                        i8 = max2;
                                        z5 = true;
                                    } else {
                                        i8 = max2;
                                        z5 = z4;
                                    }
                                    if (aVar.X && (baseline = view.getBaseline()) != -1 && baseline != fVar.A()) {
                                        fVar.q(baseline);
                                        z5 = true;
                                    }
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        i11 = combineMeasuredStates(i11, view.getMeasuredState());
                                    }
                                    z4 = z5;
                                    max2 = i8;
                                    i10++;
                                    i9 = i;
                                    paddingBottom = i7;
                                    p = i6;
                                    size = i12;
                                    r = i5;
                                    z9 = z4;
                                }
                                i7 = paddingBottom;
                                i11 = i11;
                                i10++;
                                i9 = i;
                                paddingBottom = i7;
                                p = i6;
                                size = i12;
                                r = i5;
                                z9 = z4;
                            }
                        }
                        z4 = z9;
                        i7 = paddingBottom;
                        i11 = i11;
                        i10++;
                        i9 = i;
                        paddingBottom = i7;
                        p = i6;
                        size = i12;
                        r = i5;
                        z9 = z4;
                    }
                    int i13 = size;
                    int i14 = p;
                    int i15 = r;
                    boolean z10 = z9;
                    i3 = paddingBottom;
                    int i16 = i11;
                    if (z10) {
                        this.f1356b.j(i14);
                        this.f1356b.k(i15);
                        if (z6) {
                            this.f1356b.P();
                        }
                        a("2nd pass");
                        if (this.f1356b.p() < max) {
                            this.f1356b.j(max);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.f1356b.r() < max2) {
                            this.f1356b.k(max2);
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (z3) {
                            a("3rd pass");
                        }
                    }
                    for (int i17 = 0; i17 < i13; i17++) {
                        androidx.constraintlayout.a.a.f fVar3 = this.h.get(i17);
                        View view2 = (View) fVar3.B();
                        if (view2 != null && (view2.getMeasuredWidth() != fVar3.p() || view2.getMeasuredHeight() != fVar3.r())) {
                            if (fVar3.l() != 8) {
                                view2.measure(View.MeasureSpec.makeMeasureSpec(fVar3.p(), 1073741824), View.MeasureSpec.makeMeasureSpec(fVar3.r(), 1073741824));
                                androidx.constraintlayout.a.f fVar4 = this.t;
                                if (fVar4 != null) {
                                    fVar4.f1338b++;
                                }
                            }
                        }
                    }
                    i4 = i16;
                } else {
                    i3 = paddingBottom;
                    i4 = 0;
                }
                int p3 = this.f1356b.p() + paddingRight;
                int r3 = this.f1356b.r() + i3;
                if (Build.VERSION.SDK_INT < 11) {
                    int min = Math.min(this.k, resolveSizeAndState(p3, i, i4) & 16777215);
                    int min2 = Math.min(this.l, resolveSizeAndState(r3, i2, i4 << 16) & 16777215);
                    if (this.f1356b.K()) {
                        min |= 16777216;
                    }
                    if (this.f1356b.L()) {
                        min2 |= 16777216;
                    }
                    setMeasuredDimension(min, min2);
                    this.r = min;
                    this.s = min2;
                    return;
                }
                setMeasuredDimension(p3, r3);
                this.r = p3;
                this.s = r3;
                return;
            }
        }
        if (getChildCount() > 0) {
        }
        size = this.h.size();
        int paddingBottom2 = paddingTop + getPaddingBottom();
        int paddingRight2 = paddingLeft + getPaddingRight();
        if (size <= 0) {
        }
        int p32 = this.f1356b.p() + paddingRight2;
        int r32 = this.f1356b.r() + i3;
        if (Build.VERSION.SDK_INT < 11) {
        }
    }

    private void c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.a aVar = f.a.FIXED;
        f.a aVar2 = f.a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = f.a.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.k, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = f.a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = f.a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.l, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = f.a.WRAP_CONTENT;
        }
        this.f1356b.l(0);
        this.f1356b.m(0);
        this.f1356b.a(aVar);
        this.f1356b.j(size);
        this.f1356b.b(aVar2);
        this.f1356b.k(size2);
        this.f1356b.l((this.i - getPaddingLeft()) - getPaddingRight());
        this.f1356b.m((this.j - getPaddingTop()) - getPaddingBottom());
    }

    protected void a(String str) {
        this.f1356b.N();
        androidx.constraintlayout.a.f fVar = this.t;
        if (fVar != null) {
            fVar.f1339c++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            androidx.constraintlayout.a.a.f fVar = aVar.al;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.aa) {
                int t = fVar.t();
                int u = fVar.u();
                int p = fVar.p() + t;
                int r = fVar.r() + u;
                childAt.layout(t, u, p, r);
                if ((childAt instanceof f) && (content = ((f) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(t, u, p, r);
                }
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.g.get(i6).b(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f1356b.a(i);
    }

    public int getOptimizationLevel() {
        return this.f1356b.J();
    }

    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void setConstraintSet(c cVar) {
        this.o = cVar;
    }

    public View a(int i) {
        return this.f1355a.get(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((parseInt / 1080.0f) * width);
                        int i3 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i2;
                        float f2 = i3;
                        float f3 = i2 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i3 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        float C;
        int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        boolean V;
        boolean W;
        boolean X;
        boolean Y;
        boolean Z;

        /* renamed from: a  reason: collision with root package name */
        public int f1361a;
        boolean aa;
        int ab;
        int ac;
        int ad;
        int ae;
        int af;
        int ag;
        float ah;
        int ai;
        int aj;
        float ak;
        androidx.constraintlayout.a.a.f al;
        public boolean am;

        /* renamed from: b  reason: collision with root package name */
        public int f1362b;

        /* renamed from: c  reason: collision with root package name */
        public float f1363c;

        /* renamed from: d  reason: collision with root package name */
        public int f1364d;

        /* renamed from: e  reason: collision with root package name */
        public int f1365e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public float o;
        public int p;

        /* renamed from: q  reason: collision with root package name */
        public int f1366q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public float z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0029a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f1367a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1367a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f1367a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f1367a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.f1361a = -1;
            this.f1362b = -1;
            this.f1363c = -1.0f;
            this.f1364d = -1;
            this.f1365e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.f1366q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new androidx.constraintlayout.a.a.f();
            this.am = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = C0029a.f1367a.get(index);
                switch (i3) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f;
                        if (f < 0.0f) {
                            this.o = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1361a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1361a);
                        break;
                    case 6:
                        this.f1362b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1362b);
                        break;
                    case 7:
                        this.f1363c = obtainStyledAttributes.getFloat(index, this.f1363c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1364d);
                        this.f1364d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1364d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1365e);
                        this.f1365e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1365e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1366q);
                        this.f1366q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1366q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D == 1) {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i);
                                        if (substring4.length() > 0) {
                                            this.C = Float.parseFloat(substring4);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                continue;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f1363c == -1.0f && this.f1361a == -1 && this.f1362b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.al instanceof i)) {
                this.al = new i();
            }
            ((i) this.al).a(this.S);
        }

        public a(int i, int i2) {
            super(i, i2);
            this.f1361a = -1;
            this.f1362b = -1;
            this.f1363c = -1.0f;
            this.f1364d = -1;
            this.f1365e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.f1366q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new androidx.constraintlayout.a.a.f();
            this.am = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1361a = -1;
            this.f1362b = -1;
            this.f1363c = -1.0f;
            this.f1364d = -1;
            this.f1365e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = 0.0f;
            this.p = -1;
            this.f1366q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.aa = false;
            this.ab = -1;
            this.ac = -1;
            this.ad = -1;
            this.ae = -1;
            this.af = -1;
            this.ag = -1;
            this.ah = 0.5f;
            this.al = new androidx.constraintlayout.a.a.f();
            this.am = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            float f;
            int i6 = this.leftMargin;
            int i7 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.ad = -1;
            this.ae = -1;
            this.ab = -1;
            this.ac = -1;
            this.af = -1;
            this.ag = -1;
            this.af = this.t;
            this.ag = this.v;
            this.ah = this.z;
            this.ai = this.f1361a;
            this.aj = this.f1362b;
            this.ak = this.f1363c;
            boolean z = false;
            if (1 == getLayoutDirection()) {
                int i8 = this.p;
                if (i8 != -1) {
                    this.ad = i8;
                } else {
                    int i9 = this.f1366q;
                    if (i9 != -1) {
                        this.ae = i9;
                    }
                    i2 = this.r;
                    if (i2 != -1) {
                        this.ac = i2;
                        z = true;
                    }
                    i3 = this.s;
                    if (i3 != -1) {
                        this.ab = i3;
                        z = true;
                    }
                    i4 = this.x;
                    if (i4 != -1) {
                        this.ag = i4;
                    }
                    i5 = this.y;
                    if (i5 != -1) {
                        this.af = i5;
                    }
                    if (z) {
                        this.ah = 1.0f - this.z;
                    }
                    if (this.Y && this.S == 1) {
                        f = this.f1363c;
                        if (f == -1.0f) {
                            this.ak = 1.0f - f;
                            this.ai = -1;
                            this.aj = -1;
                        } else {
                            int i10 = this.f1361a;
                            if (i10 != -1) {
                                this.aj = i10;
                                this.ai = -1;
                                this.ak = -1.0f;
                            } else {
                                int i11 = this.f1362b;
                                if (i11 != -1) {
                                    this.ai = i11;
                                    this.aj = -1;
                                    this.ak = -1.0f;
                                }
                            }
                        }
                    }
                }
                z = true;
                i2 = this.r;
                if (i2 != -1) {
                }
                i3 = this.s;
                if (i3 != -1) {
                }
                i4 = this.x;
                if (i4 != -1) {
                }
                i5 = this.y;
                if (i5 != -1) {
                }
                if (z) {
                }
                if (this.Y) {
                    f = this.f1363c;
                    if (f == -1.0f) {
                    }
                }
            } else {
                int i12 = this.p;
                if (i12 != -1) {
                    this.ac = i12;
                }
                int i13 = this.f1366q;
                if (i13 != -1) {
                    this.ab = i13;
                }
                int i14 = this.r;
                if (i14 != -1) {
                    this.ad = i14;
                }
                int i15 = this.s;
                if (i15 != -1) {
                    this.ae = i15;
                }
                int i16 = this.x;
                if (i16 != -1) {
                    this.af = i16;
                }
                int i17 = this.y;
                if (i17 != -1) {
                    this.ag = i17;
                }
            }
            if (this.r == -1 && this.s == -1 && this.f1366q == -1 && this.p == -1) {
                int i18 = this.f;
                if (i18 != -1) {
                    this.ad = i18;
                    if (this.rightMargin <= 0 && i7 > 0) {
                        this.rightMargin = i7;
                    }
                } else {
                    int i19 = this.g;
                    if (i19 != -1) {
                        this.ae = i19;
                        if (this.rightMargin <= 0 && i7 > 0) {
                            this.rightMargin = i7;
                        }
                    }
                }
                int i20 = this.f1364d;
                if (i20 != -1) {
                    this.ab = i20;
                    if (this.leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    this.leftMargin = i6;
                    return;
                }
                int i21 = this.f1365e;
                if (i21 != -1) {
                    this.ac = i21;
                    if (this.leftMargin > 0 || i6 <= 0) {
                        return;
                    }
                    this.leftMargin = i6;
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.m = true;
        this.r = -1;
        this.s = -1;
        this.f1357c = -1;
        this.f1358d = -1;
        this.f1359e = 0;
        this.f = 0;
    }
}
