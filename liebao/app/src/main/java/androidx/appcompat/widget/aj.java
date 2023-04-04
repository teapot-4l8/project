package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class aj implements androidx.appcompat.view.menu.p {

    /* renamed from: a  reason: collision with root package name */
    private static Method f954a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f955b;
    private static Method h;
    private AdapterView.OnItemClickListener A;
    private AdapterView.OnItemSelectedListener B;
    private final d C;
    private final c D;
    private final a E;
    private Runnable F;
    private final Rect G;
    private Rect H;
    private boolean I;

    /* renamed from: c  reason: collision with root package name */
    af f956c;

    /* renamed from: d  reason: collision with root package name */
    int f957d;

    /* renamed from: e  reason: collision with root package name */
    final e f958e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f959q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private View v;
    private int w;
    private DataSetObserver x;
    private View y;
    private Drawable z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f954a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f955b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public aj(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.s = 0;
        this.t = false;
        this.u = false;
        this.f957d = Integer.MAX_VALUE;
        this.w = 0;
        this.f958e = new e();
        this.C = new d();
        this.D = new c();
        this.E = new a();
        this.G = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.n = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        q qVar = new q(context, attributeSet, i, i2);
        this.g = qVar;
        qVar.setInputMethodMode(1);
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.x;
        if (dataSetObserver == null) {
            this.x = new b();
        } else {
            ListAdapter listAdapter2 = this.j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.x);
        }
        af afVar = this.f956c;
        if (afVar != null) {
            afVar.setAdapter(this.j);
        }
    }

    public void d(int i) {
        this.w = i;
    }

    public void a(boolean z) {
        this.I = z;
        this.g.setFocusable(z);
    }

    public boolean i() {
        return this.I;
    }

    public Drawable d() {
        return this.g.getBackground();
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void e(int i) {
        this.g.setAnimationStyle(i);
    }

    public View j() {
        return this.y;
    }

    public void b(View view) {
        this.y = view;
    }

    public int f() {
        return this.m;
    }

    public void b(int i) {
        this.m = i;
    }

    public int e() {
        if (this.p) {
            return this.n;
        }
        return 0;
    }

    public void a(int i) {
        this.n = i;
        this.p = true;
    }

    public void a(Rect rect) {
        this.H = rect != null ? new Rect(rect) : null;
    }

    public void f(int i) {
        this.s = i;
    }

    public int k() {
        return this.l;
    }

    public void g(int i) {
        this.l = i;
    }

    public void h(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            this.l = this.G.left + this.G.right + i;
            return;
        }
        g(i);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public void b_() {
        int h2 = h();
        boolean m = m();
        androidx.core.widget.h.a(this.g, this.o);
        boolean z = true;
        if (this.g.isShowing()) {
            if (androidx.core.h.w.D(j())) {
                int i = this.l;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = j().getWidth();
                }
                int i2 = this.k;
                if (i2 == -1) {
                    if (!m) {
                        h2 = -1;
                    }
                    if (m) {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(0);
                    } else {
                        this.g.setWidth(this.l == -1 ? -1 : 0);
                        this.g.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    h2 = i2;
                }
                this.g.setOutsideTouchable((this.u || this.t) ? false : false);
                this.g.update(j(), this.m, this.n, i < 0 ? -1 : i, h2 < 0 ? -1 : h2);
                return;
            }
            return;
        }
        int i3 = this.l;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = j().getWidth();
        }
        int i4 = this.k;
        if (i4 == -1) {
            h2 = -1;
        } else if (i4 != -2) {
            h2 = i4;
        }
        this.g.setWidth(i3);
        this.g.setHeight(h2);
        c(true);
        this.g.setOutsideTouchable((this.u || this.t) ? false : true);
        this.g.setTouchInterceptor(this.C);
        if (this.r) {
            androidx.core.widget.h.a(this.g, this.f959q);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = h;
            if (method != null) {
                try {
                    method.invoke(this.g, this.H);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.g.setEpicenterBounds(this.H);
        }
        androidx.core.widget.h.a(this.g, j(), this.m, this.n, this.s);
        this.f956c.setSelection(-1);
        if (!this.I || this.f956c.isInTouchMode()) {
            l();
        }
        if (this.I) {
            return;
        }
        this.f.post(this.E);
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        this.g.dismiss();
        g();
        this.g.setContentView(null);
        this.f956c = null;
        this.f.removeCallbacks(this.f958e);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    private void g() {
        View view = this.v;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.v);
            }
        }
    }

    public void i(int i) {
        this.g.setInputMethodMode(i);
    }

    public void j(int i) {
        af afVar = this.f956c;
        if (!c() || afVar == null) {
            return;
        }
        afVar.setListSelectionHidden(false);
        afVar.setSelection(i);
        if (afVar.getChoiceMode() != 0) {
            afVar.setItemChecked(i, true);
        }
    }

    public void l() {
        af afVar = this.f956c;
        if (afVar != null) {
            afVar.setListSelectionHidden(true);
            afVar.requestLayout();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.g.isShowing();
    }

    public boolean m() {
        return this.g.getInputMethodMode() == 2;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView c_() {
        return this.f956c;
    }

    af a(Context context, boolean z) {
        return new af(context, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int h() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.f956c == null) {
            Context context = this.i;
            this.F = new Runnable() { // from class: androidx.appcompat.widget.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    View j = aj.this.j();
                    if (j == null || j.getWindowToken() == null) {
                        return;
                    }
                    aj.this.b_();
                }
            };
            af a2 = a(context, !this.I);
            this.f956c = a2;
            Drawable drawable = this.z;
            if (drawable != null) {
                a2.setSelector(drawable);
            }
            this.f956c.setAdapter(this.j);
            this.f956c.setOnItemClickListener(this.A);
            this.f956c.setFocusable(true);
            this.f956c.setFocusableInTouchMode(true);
            this.f956c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.aj.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    af afVar;
                    if (i4 == -1 || (afVar = aj.this.f956c) == null) {
                        return;
                    }
                    afVar.setListSelectionHidden(false);
                }
            });
            this.f956c.setOnScrollListener(this.D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.B;
            if (onItemSelectedListener != null) {
                this.f956c.setOnItemSelectedListener(onItemSelectedListener);
            }
            af afVar = this.f956c;
            View view = this.v;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.w;
                if (i4 == 0) {
                    linearLayout.addView(view);
                    linearLayout.addView(afVar, layoutParams);
                } else if (i4 == 1) {
                    linearLayout.addView(afVar, layoutParams);
                    linearLayout.addView(view);
                } else {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.w);
                }
                int i5 = this.l;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                afVar = linearLayout;
            } else {
                i = 0;
            }
            this.g.setContentView(afVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view2 = this.v;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            i2 = this.G.top + this.G.bottom;
            if (!this.p) {
                this.n = -this.G.top;
            }
        } else {
            this.G.setEmpty();
            i2 = 0;
        }
        int a3 = a(j(), this.n, this.g.getInputMethodMode() == 2);
        if (this.t || this.k == -1) {
            return a3 + i2;
        }
        int i6 = this.l;
        if (i6 == -2) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.G.left + this.G.right), Integer.MIN_VALUE);
        } else if (i6 == -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.G.left + this.G.right), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        int a4 = this.f956c.a(makeMeasureSpec, 0, -1, a3 - i, -1);
        if (a4 > 0) {
            i += i2 + this.f956c.getPaddingTop() + this.f956c.getPaddingBottom();
        }
        return a4 + i;
    }

    public void b(boolean z) {
        this.r = true;
        this.f959q = z;
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (aj.this.c()) {
                aj.this.b_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            aj.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aj.this.f956c == null || !androidx.core.h.w.D(aj.this.f956c) || aj.this.f956c.getCount() <= aj.this.f956c.getChildCount() || aj.this.f956c.getChildCount() > aj.this.f957d) {
                return;
            }
            aj.this.g.setInputMethodMode(2);
            aj.this.b_();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && aj.this.g != null && aj.this.g.isShowing() && x >= 0 && x < aj.this.g.getWidth() && y >= 0 && y < aj.this.g.getHeight()) {
                aj.this.f.postDelayed(aj.this.f958e, 250L);
                return false;
            } else if (action == 1) {
                aj.this.f.removeCallbacks(aj.this.f958e);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || aj.this.m() || aj.this.g.getContentView() == null) {
                return;
            }
            aj.this.f.removeCallbacks(aj.this.f958e);
            aj.this.f958e.run();
        }
    }

    private void c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f954a;
            if (method != null) {
                try {
                    method.invoke(this.g, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.g.setIsClippedToScreen(z);
    }

    private int a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f955b;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            return this.g.getMaxAvailableHeight(view, i);
        }
        return this.g.getMaxAvailableHeight(view, i, z);
    }
}
