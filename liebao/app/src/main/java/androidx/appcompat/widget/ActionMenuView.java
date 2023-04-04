package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ai;

/* loaded from: classes.dex */
public class ActionMenuView extends ai implements g.b, androidx.appcompat.view.menu.n {

    /* renamed from: a  reason: collision with root package name */
    g.a f845a;

    /* renamed from: b  reason: collision with root package name */
    e f846b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.view.menu.g f847c;

    /* renamed from: d  reason: collision with root package name */
    private Context f848d;

    /* renamed from: e  reason: collision with root package name */
    private int f849e;
    private boolean f;
    private androidx.appcompat.widget.c g;
    private m.a h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public interface a {
        boolean b();

        boolean c();
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean a(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.k = (int) (56.0f * f);
        this.l = (int) (f * 4.0f);
        this.f848d = context;
        this.f849e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f849e != i) {
            this.f849e = i;
            if (i == 0) {
                this.f848d = getContext();
            } else {
                this.f848d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f849e;
    }

    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.g = cVar;
        cVar.a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.widget.c cVar = this.g;
        if (cVar != null) {
            cVar.updateMenuView(false);
            if (this.g.g()) {
                this.g.d();
                this.g.c();
            }
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f846b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.View
    public void onMeasure(int i, int i2) {
        androidx.appcompat.view.menu.g gVar;
        boolean z = this.i;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.i = z2;
        if (z != z2) {
            this.j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.i && (gVar = this.f847c) != null && size != this.j) {
            this.j = size;
            gVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.i && childCount > 0) {
            a(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void a(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i7 = size - paddingLeft;
        int i8 = this.k;
        int i9 = i7 / i8;
        int i10 = i7 % i8;
        if (i9 == 0) {
            setMeasuredDimension(i7, 0);
            return;
        }
        int i11 = i8 + (i10 / i9);
        int childCount = getChildCount();
        int i12 = 0;
        int i13 = 0;
        boolean z4 = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            int i17 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z5 = childAt instanceof ActionMenuItemView;
                int i18 = i14 + 1;
                if (z5) {
                    int i19 = this.l;
                    i6 = i18;
                    r14 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f = r14;
                cVar.f852c = r14;
                cVar.f851b = r14;
                cVar.f853d = r14;
                cVar.leftMargin = r14;
                cVar.rightMargin = r14;
                cVar.f854e = z5 && ((ActionMenuItemView) childAt).a();
                int a2 = a(childAt, i11, cVar.f850a ? 1 : i9, childMeasureSpec, paddingTop);
                i15 = Math.max(i15, a2);
                if (cVar.f853d) {
                    i16++;
                }
                if (cVar.f850a) {
                    z4 = true;
                }
                i9 -= a2;
                i12 = Math.max(i12, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j |= 1 << i13;
                    i12 = i12;
                }
                i14 = i6;
            }
            i13++;
            size2 = i17;
        }
        int i20 = size2;
        boolean z6 = z4 && i14 == 2;
        boolean z7 = false;
        while (i16 > 0 && i9 > 0) {
            int i21 = 0;
            int i22 = 0;
            int i23 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i22 < childCount) {
                boolean z8 = z7;
                c cVar2 = (c) getChildAt(i22).getLayoutParams();
                int i24 = i12;
                if (cVar2.f853d) {
                    if (cVar2.f851b < i23) {
                        i23 = cVar2.f851b;
                        j2 = 1 << i22;
                        i21 = 1;
                    } else if (cVar2.f851b == i23) {
                        i21++;
                        j2 |= 1 << i22;
                    }
                }
                i22++;
                i12 = i24;
                z7 = z8;
            }
            z = z7;
            i5 = i12;
            j |= j2;
            if (i21 > i9) {
                i3 = mode;
                i4 = i7;
                break;
            }
            int i25 = i23 + 1;
            int i26 = 0;
            while (i26 < childCount) {
                View childAt2 = getChildAt(i26);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i27 = i7;
                int i28 = mode;
                long j3 = 1 << i26;
                if ((j2 & j3) == 0) {
                    if (cVar3.f851b == i25) {
                        j |= j3;
                    }
                    z3 = z6;
                } else {
                    if (z6 && cVar3.f854e && i9 == 1) {
                        int i29 = this.l;
                        z3 = z6;
                        childAt2.setPadding(i29 + i11, 0, i29, 0);
                    } else {
                        z3 = z6;
                    }
                    cVar3.f851b++;
                    cVar3.f = true;
                    i9--;
                }
                i26++;
                mode = i28;
                i7 = i27;
                z6 = z3;
            }
            i12 = i5;
            z7 = true;
        }
        i3 = mode;
        i4 = i7;
        z = z7;
        i5 = i12;
        boolean z9 = !z4 && i14 == 1;
        if (i9 <= 0 || j == 0 || (i9 >= i14 - 1 && !z9 && i15 <= 1)) {
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j);
            if (!z9) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f854e) {
                    bitCount -= 0.5f;
                }
                int i30 = childCount - 1;
                if ((j & (1 << i30)) != 0 && !((c) getChildAt(i30).getLayoutParams()).f854e) {
                    bitCount -= 0.5f;
                }
            }
            int i31 = bitCount > 0.0f ? (int) ((i9 * i11) / bitCount) : 0;
            z2 = z;
            for (int i32 = 0; i32 < childCount; i32++) {
                if ((j & (1 << i32)) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f852c = i31;
                        cVar4.f = true;
                        if (i32 == 0 && !cVar4.f854e) {
                            cVar4.leftMargin = (-i31) / 2;
                        }
                    } else if (cVar4.f850a) {
                        cVar4.f852c = i31;
                        cVar4.f = true;
                        cVar4.rightMargin = (-i31) / 2;
                    } else {
                        if (i32 != 0) {
                            cVar4.leftMargin = i31 / 2;
                        }
                        if (i32 != childCount - 1) {
                            cVar4.rightMargin = i31 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i33 = 0; i33 < childCount; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f851b * i11) + cVar5.f852c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i20);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.a();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.f853d = (cVar.f850a || !z2) ? false : false;
        cVar.f851b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = bc.a(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f850a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i5 = getPaddingLeft() + cVar.leftMargin;
                        width = i5 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i5 = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    a(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (a2) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f850a) {
                    int i16 = width2 - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f850a) {
                int i19 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft = i19 + measuredWidth4 + cVar3.rightMargin + max;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.g.a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.g.b();
    }

    public boolean a() {
        return this.f;
    }

    public void setOverflowReserved(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup
    /* renamed from: b */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup
    /* renamed from: a */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (cVar.h <= 0) {
                cVar.h = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.ai, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public c c() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f850a = true;
        return generateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(androidx.appcompat.view.menu.i iVar) {
        return this.f847c.performItemAction(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void initialize(androidx.appcompat.view.menu.g gVar) {
        this.f847c = gVar;
    }

    public Menu getMenu() {
        if (this.f847c == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
            this.f847c = gVar;
            gVar.setCallback(new d());
            androidx.appcompat.widget.c cVar = new androidx.appcompat.widget.c(context);
            this.g = cVar;
            cVar.a(true);
            androidx.appcompat.widget.c cVar2 = this.g;
            m.a aVar = this.h;
            if (aVar == null) {
                aVar = new b();
            }
            cVar2.setCallback(aVar);
            this.f847c.addMenuPresenter(this.g, this.f848d);
            this.g.a(this);
        }
        return this.f847c;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.h = aVar;
        this.f845a = aVar2;
    }

    public androidx.appcompat.view.menu.g d() {
        return this.f847c;
    }

    public boolean e() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.c();
    }

    public boolean f() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.d();
    }

    public boolean g() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.g();
    }

    public boolean h() {
        androidx.appcompat.widget.c cVar = this.g;
        return cVar != null && cVar.h();
    }

    public void i() {
        androidx.appcompat.widget.c cVar = this.g;
        if (cVar != null) {
            cVar.e();
        }
    }

    protected boolean a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = false | ((a) childAt).c();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : z | ((a) childAt2).b();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.g.b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return ActionMenuView.this.f846b != null && ActionMenuView.this.f846b.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            if (ActionMenuView.this.f845a != null) {
                ActionMenuView.this.f845a.onMenuModeChange(gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements m.a {
        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            return false;
        }

        b() {
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ai.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f850a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f851b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f852c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f853d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f854e;
        boolean f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f850a = cVar.f850a;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.f850a = false;
        }
    }
}
