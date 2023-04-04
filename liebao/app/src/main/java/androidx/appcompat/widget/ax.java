package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class ax implements ad {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1021a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f1022b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f1023c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1024d;

    /* renamed from: e  reason: collision with root package name */
    private int f1025e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private c n;
    private int o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1026q;

    @Override // androidx.appcompat.widget.ad
    public void b(boolean z) {
    }

    public ax(Toolbar toolbar, boolean z) {
        this(toolbar, z, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ax(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f1021a = toolbar;
        this.f1022b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.f1022b != null;
        this.j = toolbar.getNavigationIcon();
        aw a2 = aw.a(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.f1026q = a2.a(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c2 = a2.c(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c2)) {
                b(c2);
            }
            CharSequence c3 = a2.c(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c3)) {
                c(c3);
            }
            Drawable a3 = a2.a(R.styleable.ActionBar_logo);
            if (a3 != null) {
                b(a3);
            }
            Drawable a4 = a2.a(R.styleable.ActionBar_icon);
            if (a4 != null) {
                a(a4);
            }
            if (this.j == null && (drawable = this.f1026q) != null) {
                c(drawable);
            }
            c(a2.a(R.styleable.ActionBar_displayOptions, 0));
            int g = a2.g(R.styleable.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                a(LayoutInflater.from(this.f1021a.getContext()).inflate(g, (ViewGroup) this.f1021a, false));
                c(this.f1025e | 16);
            }
            int f = a2.f(R.styleable.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1021a.getLayoutParams();
                layoutParams.height = f;
                this.f1021a.setLayoutParams(layoutParams);
            }
            int d2 = a2.d(R.styleable.ActionBar_contentInsetStart, -1);
            int d3 = a2.d(R.styleable.ActionBar_contentInsetEnd, -1);
            if (d2 >= 0 || d3 >= 0) {
                this.f1021a.setContentInsetsRelative(Math.max(d2, 0), Math.max(d3, 0));
            }
            int g2 = a2.g(R.styleable.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f1021a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g2);
            }
            int g3 = a2.g(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f1021a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g3);
            }
            int g4 = a2.g(R.styleable.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1021a.setPopupTheme(g4);
            }
        } else {
            this.f1025e = r();
        }
        a2.b();
        e(i);
        this.m = this.f1021a.getNavigationContentDescription();
        this.f1021a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ax.1

            /* renamed from: a  reason: collision with root package name */
            final androidx.appcompat.view.menu.a f1027a;

            {
                this.f1027a = new androidx.appcompat.view.menu.a(ax.this.f1021a.getContext(), 0, 16908332, 0, 0, ax.this.f1022b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ax.this.f1023c == null || !ax.this.f1024d) {
                    return;
                }
                ax.this.f1023c.onMenuItemSelected(0, this.f1027a);
            }
        });
    }

    public void e(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f1021a.getNavigationContentDescription())) {
            f(this.p);
        }
    }

    private int r() {
        if (this.f1021a.getNavigationIcon() != null) {
            this.f1026q = this.f1021a.getNavigationIcon();
            return 15;
        }
        return 11;
    }

    @Override // androidx.appcompat.widget.ad
    public ViewGroup a() {
        return this.f1021a;
    }

    @Override // androidx.appcompat.widget.ad
    public Context b() {
        return this.f1021a.getContext();
    }

    @Override // androidx.appcompat.widget.ad
    public boolean c() {
        return this.f1021a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.ad
    public void d() {
        this.f1021a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.ad
    public void a(Window.Callback callback) {
        this.f1023c = callback;
    }

    @Override // androidx.appcompat.widget.ad
    public void a(CharSequence charSequence) {
        if (this.k) {
            return;
        }
        e(charSequence);
    }

    @Override // androidx.appcompat.widget.ad
    public CharSequence e() {
        return this.f1021a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.f1022b = charSequence;
        if ((this.f1025e & 8) != 0) {
            this.f1021a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.f1025e & 8) != 0) {
            this.f1021a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.ad
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.ad
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.ad
    public void a(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    @Override // androidx.appcompat.widget.ad
    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.ad
    public void b(int i) {
        b(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        int i = this.f1025e;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.i;
            if (drawable == null) {
                drawable = this.h;
            }
        } else {
            drawable = this.h;
        }
        this.f1021a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.ad
    public boolean h() {
        return this.f1021a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ad
    public boolean i() {
        return this.f1021a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.ad
    public boolean j() {
        return this.f1021a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.ad
    public boolean k() {
        return this.f1021a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ad
    public boolean l() {
        return this.f1021a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.ad
    public void m() {
        this.f1024d = true;
    }

    @Override // androidx.appcompat.widget.ad
    public void a(Menu menu, m.a aVar) {
        if (this.n == null) {
            c cVar = new c(this.f1021a.getContext());
            this.n = cVar;
            cVar.a(R.id.action_menu_presenter);
        }
        this.n.setCallback(aVar);
        this.f1021a.setMenu((androidx.appcompat.view.menu.g) menu, this.n);
    }

    @Override // androidx.appcompat.widget.ad
    public void n() {
        this.f1021a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.ad
    public int o() {
        return this.f1025e;
    }

    @Override // androidx.appcompat.widget.ad
    public void c(int i) {
        View view;
        int i2 = this.f1025e ^ i;
        this.f1025e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i2 & 3) != 0) {
                s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1021a.setTitle(this.f1022b);
                    this.f1021a.setSubtitle(this.l);
                } else {
                    this.f1021a.setTitle((CharSequence) null);
                    this.f1021a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.g) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f1021a.addView(view);
            } else {
                this.f1021a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.ad
    public void a(ap apVar) {
        View view = this.f;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1021a;
            if (parent == toolbar) {
                toolbar.removeView(this.f);
            }
        }
        this.f = apVar;
        if (apVar == null || this.o != 2) {
            return;
        }
        this.f1021a.addView(apVar, 0);
        Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
        bVar.width = -2;
        bVar.height = -2;
        bVar.f575a = 8388691;
        apVar.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.ad
    public void a(boolean z) {
        this.f1021a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.ad
    public int p() {
        return this.o;
    }

    public void a(View view) {
        View view2 = this.g;
        if (view2 != null && (this.f1025e & 16) != 0) {
            this.f1021a.removeView(view2);
        }
        this.g = view;
        if (view == null || (this.f1025e & 16) == 0) {
            return;
        }
        this.f1021a.addView(view);
    }

    @Override // androidx.appcompat.widget.ad
    public androidx.core.h.aa a(final int i, long j) {
        return androidx.core.h.w.m(this.f1021a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new androidx.core.h.ac() { // from class: androidx.appcompat.widget.ax.2

            /* renamed from: c  reason: collision with root package name */
            private boolean f1031c = false;

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void a(View view) {
                ax.this.f1021a.setVisibility(0);
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void b(View view) {
                if (this.f1031c) {
                    return;
                }
                ax.this.f1021a.setVisibility(i);
            }

            @Override // androidx.core.h.ac, androidx.core.h.ab
            public void c(View view) {
                this.f1031c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.f1025e & 4) != 0) {
            Toolbar toolbar = this.f1021a;
            Drawable drawable = this.j;
            if (drawable == null) {
                drawable = this.f1026q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1021a.setNavigationIcon((Drawable) null);
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public void f(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void u() {
        if ((this.f1025e & 4) != 0) {
            if (TextUtils.isEmpty(this.m)) {
                this.f1021a.setNavigationContentDescription(this.p);
            } else {
                this.f1021a.setNavigationContentDescription(this.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.ad
    public void d(int i) {
        this.f1021a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.ad
    public void a(m.a aVar, g.a aVar2) {
        this.f1021a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.ad
    public Menu q() {
        return this.f1021a.getMenu();
    }
}
