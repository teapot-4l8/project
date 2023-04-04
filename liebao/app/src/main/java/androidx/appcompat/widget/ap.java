package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ai;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class ap extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Runnable f984a;

    /* renamed from: b  reason: collision with root package name */
    ai f985b;

    /* renamed from: c  reason: collision with root package name */
    int f986c;

    /* renamed from: d  reason: collision with root package name */
    int f987d;

    /* renamed from: e  reason: collision with root package name */
    private b f988e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f985b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f986c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f986c = View.MeasureSpec.getSize(i) / 2;
            }
            this.f986c = Math.min(this.f986c, this.f987d);
        } else {
            this.f986c = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if ((z2 || !this.g) ? false : false) {
            this.f985b.measure(0, makeMeasureSpec);
            if (this.f985b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z2 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i);
    }

    private boolean a() {
        Spinner spinner = this.f;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f == null) {
            this.f = d();
        }
        removeView(this.f985b);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.f984a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f984a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (a()) {
            removeView(this.f);
            addView(this.f985b, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f.getSelectedItemPosition());
            return false;
        }
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.f985b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f985b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.f;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private Spinner d() {
        w wVar = new w(getContext(), null, R.attr.actionDropDownStyle);
        wVar.setLayoutParams(new ai.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(getContext());
        setContentHeight(a2.e());
        this.f987d = a2.g();
    }

    public void a(int i) {
        final View childAt = this.f985b.getChildAt(i);
        Runnable runnable = this.f984a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ap.1
            @Override // java.lang.Runnable
            public void run() {
                ap.this.smoothScrollTo(childAt.getLeft() - ((ap.this.getWidth() - childAt.getWidth()) / 2), 0);
                ap.this.f984a = null;
            }
        };
        this.f984a = runnable2;
        post(runnable2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f984a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f984a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    c a(a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar2.setFocusable(true);
            if (this.f988e == null) {
                this.f988e = new b();
            }
            cVar2.setOnClickListener(this.f988e);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f994b;

        /* renamed from: c  reason: collision with root package name */
        private a.c f995c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f996d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f997e;
        private View f;

        public c(Context context, a.c cVar, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            int[] iArr = {16842964};
            this.f994b = iArr;
            this.f995c = cVar;
            aw a2 = aw.a(context, null, iArr, R.attr.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.a(0));
            }
            a2.b();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(a.c cVar) {
            this.f995c = cVar;
            a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ap.this.f986c <= 0 || getMeasuredWidth() <= ap.this.f986c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ap.this.f986c, 1073741824), i2);
        }

        public void a() {
            a.c cVar = this.f995c;
            View c2 = cVar.c();
            if (c2 != null) {
                ViewParent parent = c2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c2);
                    }
                    addView(c2);
                }
                this.f = c2;
                TextView textView = this.f996d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f997e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f997e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f;
            if (view != null) {
                removeView(view);
                this.f = null;
            }
            Drawable a2 = cVar.a();
            CharSequence b2 = cVar.b();
            if (a2 != null) {
                if (this.f997e == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.f997e = oVar;
                }
                this.f997e.setImageDrawable(a2);
                this.f997e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f997e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f997e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(b2);
            if (z) {
                if (this.f996d == null) {
                    z zVar = new z(getContext(), null, R.attr.actionBarTabTextStyle);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f996d = zVar;
                }
                this.f996d.setText(b2);
                this.f996d.setVisibility(0);
            } else {
                TextView textView2 = this.f996d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f996d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f997e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.e());
            }
            ay.a(this, z ? null : cVar.e());
        }

        public a.c b() {
            return this.f995c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ap.this.f985b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ap.this.f985b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ap.this.a((a.c) getItem(i), true);
            }
            ((c) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScrollingTabContainerView.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = ap.this.f985b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ap.this.f985b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
