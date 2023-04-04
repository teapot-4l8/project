package com.lxj.xpopup.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.transition.aa;
import androidx.transition.w;
import androidx.transition.x;
import androidx.transition.y;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpermission.XPermission;
import com.lxj.xpopup.R;
import com.lxj.xpopup.f.k;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import java.util.List;

/* compiled from: ImageViewerPopupView.java */
/* loaded from: classes.dex */
public class f extends b implements View.OnClickListener, com.lxj.xpopup.e.b {
    protected int A;

    /* renamed from: a  reason: collision with root package name */
    protected PhotoViewContainer f5425a;

    /* renamed from: b  reason: collision with root package name */
    protected BlankView f5426b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f5427c;

    /* renamed from: d  reason: collision with root package name */
    protected TextView f5428d;

    /* renamed from: e  reason: collision with root package name */
    protected HackyViewPager f5429e;
    protected ArgbEvaluator f;
    protected List<Object> g;
    protected com.lxj.xpopup.e.e h;
    protected com.lxj.xpopup.e.c i;
    protected int j;
    protected Rect p;

    /* renamed from: q  reason: collision with root package name */
    protected ImageView f5430q;
    protected k r;
    protected boolean s;
    protected int t;
    protected int u;
    protected int v;
    protected boolean w;
    protected boolean x;
    protected boolean y;
    protected View z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void g() {
    }

    @Override // com.lxj.xpopup.b.b
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.b.b
    protected int getPopupLayoutId() {
        return R.layout._xpopup_image_viewer_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void a() {
        super.a();
        this.f5427c = (TextView) findViewById(R.id.tv_pager_indicator);
        this.f5428d = (TextView) findViewById(R.id.tv_save);
        this.f5426b = (BlankView) findViewById(R.id.placeholderView);
        PhotoViewContainer photoViewContainer = (PhotoViewContainer) findViewById(R.id.photoViewContainer);
        this.f5425a = photoViewContainer;
        photoViewContainer.setOnDragChangeListener(this);
        HackyViewPager hackyViewPager = (HackyViewPager) findViewById(R.id.pager);
        this.f5429e = hackyViewPager;
        hackyViewPager.setAdapter(new a());
        this.f5429e.setOffscreenPageLimit(this.g.size());
        this.f5429e.setCurrentItem(this.j);
        this.f5429e.setVisibility(4);
        u();
        if (this.y) {
            this.f5429e.setOffscreenPageLimit(this.g.size() / 2);
        }
        this.f5429e.addOnPageChangeListener(new ViewPager.j() { // from class: com.lxj.xpopup.b.f.1
            @Override // androidx.viewpager.widget.ViewPager.j, androidx.viewpager.widget.ViewPager.f
            public void onPageSelected(int i) {
                f.this.j = i;
                f.this.t();
                if (f.this.i != null) {
                    f.this.i.a(f.this, i);
                }
            }
        });
        if (!this.x) {
            this.f5427c.setVisibility(8);
        }
        if (!this.w) {
            this.f5428d.setVisibility(8);
        } else {
            this.f5428d.setOnClickListener(this);
        }
    }

    private void s() {
        this.f5426b.setVisibility(this.s ? 0 : 4);
        if (this.s) {
            int i = this.t;
            if (i != -1) {
                this.f5426b.color = i;
            }
            int i2 = this.v;
            if (i2 != -1) {
                this.f5426b.radius = i2;
            }
            int i3 = this.u;
            if (i3 != -1) {
                this.f5426b.strokeColor = i3;
            }
            com.lxj.xpopup.g.c.a(this.f5426b, this.p.width(), this.p.height());
            this.f5426b.setTranslationX(this.p.left);
            this.f5426b.setTranslationY(this.p.top);
            this.f5426b.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.g.size() > 1) {
            int size = this.y ? this.j % this.g.size() : this.j;
            TextView textView = this.f5427c;
            textView.setText((size + 1) + "/" + this.g.size());
        }
        if (this.w) {
            this.f5428d.setVisibility(0);
        }
    }

    private void u() {
        if (this.f5430q == null) {
            return;
        }
        if (this.r == null) {
            k kVar = new k(getContext());
            this.r = kVar;
            this.f5425a.addView(kVar);
            this.r.setScaleType(this.f5430q.getScaleType());
            this.r.setTranslationX(this.p.left);
            this.r.setTranslationY(this.p.top);
            com.lxj.xpopup.g.c.a(this.r, this.p.width(), this.p.height());
        }
        s();
        this.r.setImageDrawable(this.f5430q.getDrawable());
    }

    @Override // com.lxj.xpopup.b.b
    public void l() {
        if (this.f5430q == null) {
            this.f5425a.setBackgroundColor(this.A);
            this.f5429e.setVisibility(0);
            t();
            this.f5425a.isReleasing = false;
            super.g();
            return;
        }
        this.f5425a.isReleasing = true;
        this.r.setVisibility(0);
        View view = this.z;
        if (view != null) {
            view.setVisibility(0);
        }
        this.r.post(new Runnable() { // from class: com.lxj.xpopup.b.f.2
            @Override // java.lang.Runnable
            public void run() {
                y.a((ViewGroup) f.this.r.getParent(), new aa().setDuration(com.lxj.xpopup.a.b()).a(new androidx.transition.c()).a(new androidx.transition.e()).a(new androidx.transition.d()).setInterpolator(new androidx.d.a.a.b()).addListener(new x() { // from class: com.lxj.xpopup.b.f.2.1
                    @Override // androidx.transition.x, androidx.transition.w.d
                    public void b(w wVar) {
                        f.this.f5429e.setVisibility(0);
                        f.this.r.setVisibility(4);
                        f.this.t();
                        f.this.f5425a.isReleasing = false;
                        f.super.g();
                    }
                }));
                f.this.r.setTranslationY(0.0f);
                f.this.r.setTranslationX(0.0f);
                f.this.r.setScaleType(ImageView.ScaleType.FIT_CENTER);
                com.lxj.xpopup.g.c.a(f.this.r, f.this.f5425a.getWidth(), f.this.f5425a.getHeight());
                f fVar = f.this;
                fVar.a(fVar.A);
                if (f.this.z != null) {
                    f.this.z.animate().alpha(1.0f).setDuration(com.lxj.xpopup.a.b()).start();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        final int color = ((ColorDrawable) this.f5425a.getBackground()).getColor();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lxj.xpopup.b.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.f5425a.setBackgroundColor(((Integer) f.this.f.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(color), Integer.valueOf(i))).intValue());
            }
        });
        ofFloat.setDuration(com.lxj.xpopup.a.b()).setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    @Override // com.lxj.xpopup.b.b
    public void m() {
        if (this.f5430q == null) {
            this.f5425a.setBackgroundColor(0);
            o();
            this.f5429e.setVisibility(4);
            this.f5426b.setVisibility(4);
            return;
        }
        this.f5427c.setVisibility(4);
        this.f5428d.setVisibility(4);
        this.f5429e.setVisibility(4);
        this.r.setVisibility(0);
        this.f5425a.isReleasing = true;
        y.a((ViewGroup) this.r.getParent(), new aa().setDuration(com.lxj.xpopup.a.b()).a(new androidx.transition.c()).a(new androidx.transition.e()).a(new androidx.transition.d()).setInterpolator(new androidx.d.a.a.b()).addListener(new x() { // from class: com.lxj.xpopup.b.f.4
            @Override // androidx.transition.x, androidx.transition.w.d
            public void b(w wVar) {
                f.this.o();
                f.this.f5429e.setVisibility(4);
                f.this.r.setVisibility(0);
                f.this.f5429e.setScaleX(1.0f);
                f.this.f5429e.setScaleY(1.0f);
                f.this.r.setScaleX(1.0f);
                f.this.r.setScaleY(1.0f);
                f.this.f5426b.setVisibility(4);
            }
        }));
        this.r.setTranslationY(this.p.top);
        this.r.setTranslationX(this.p.left);
        this.r.setScaleX(1.0f);
        this.r.setScaleY(1.0f);
        this.r.setScaleType(this.f5430q.getScaleType());
        com.lxj.xpopup.g.c.a(this.r, this.p.width(), this.p.height());
        a(0);
        View view = this.z;
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(com.lxj.xpopup.a.b()).setListener(new AnimatorListenerAdapter() { // from class: com.lxj.xpopup.b.f.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (f.this.z != null) {
                        f.this.z.setVisibility(4);
                    }
                }
            }).start();
        }
    }

    @Override // com.lxj.xpopup.b.b
    public void n() {
        if (this.n != com.lxj.xpopup.c.e.Show) {
            return;
        }
        this.n = com.lxj.xpopup.c.e.Dismissing;
        if (this.f5430q != null) {
            HackyViewPager hackyViewPager = this.f5429e;
            k kVar = (k) hackyViewPager.getChildAt(hackyViewPager.getCurrentItem());
            if (kVar != null) {
                Matrix matrix = new Matrix();
                kVar.a(matrix);
                this.r.b(matrix);
            }
        }
        m();
    }

    @Override // com.lxj.xpopup.e.b
    public void b() {
        n();
    }

    @Override // com.lxj.xpopup.e.b
    public void a(int i, float f, float f2) {
        float f3 = 1.0f - f2;
        this.f5427c.setAlpha(f3);
        View view = this.z;
        if (view != null) {
            view.setAlpha(f3);
        }
        if (this.w) {
            this.f5428d.setAlpha(f3);
        }
        this.f5425a.setBackgroundColor(((Integer) this.f.evaluate(f2 * 0.8f, Integer.valueOf(this.A), 0)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void p() {
        super.p();
        this.f5430q = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f5428d) {
            c();
        }
    }

    protected void c() {
        XPermission.a(getContext(), "android.permission-group.STORAGE").a(new XPermission.c() { // from class: com.lxj.xpopup.b.f.6
            @Override // com.lxj.xpermission.XPermission.c
            public void a() {
                com.lxj.xpopup.g.c.a(f.this.getContext(), f.this.h, f.this.g.get(f.this.y ? f.this.j % f.this.g.size() : f.this.j));
            }

            @Override // com.lxj.xpermission.XPermission.c
            public void b() {
                Toast.makeText(f.this.getContext(), "没有保存权限，保存功能无法使用！", 0).show();
            }
        }).e();
    }

    /* compiled from: ImageViewerPopupView.java */
    /* loaded from: classes.dex */
    public class a extends androidx.viewpager.widget.a {
        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return obj == view;
        }

        public a() {
        }

        @Override // androidx.viewpager.widget.a
        public int b() {
            if (f.this.y) {
                return 1073741823;
            }
            return f.this.g.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            k kVar = new k(viewGroup.getContext());
            if (f.this.h != null) {
                f.this.h.a(i, f.this.g.get(f.this.y ? i % f.this.g.size() : i), kVar);
            }
            viewGroup.addView(kVar);
            kVar.setOnClickListener(new View.OnClickListener() { // from class: com.lxj.xpopup.b.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.n();
                }
            });
            return kVar;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}
