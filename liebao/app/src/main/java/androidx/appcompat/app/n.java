package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.ap;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ac;
import androidx.core.h.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class n extends androidx.appcompat.app.a implements ActionBarOverlayLayout.a {
    private static final Interpolator s = new AccelerateInterpolator();
    private static final Interpolator t = new DecelerateInterpolator();
    private boolean B;
    private boolean D;
    private boolean F;

    /* renamed from: a  reason: collision with root package name */
    Context f650a;

    /* renamed from: b  reason: collision with root package name */
    ActionBarOverlayLayout f651b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarContainer f652c;

    /* renamed from: d  reason: collision with root package name */
    ad f653d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContextView f654e;
    View f;
    ap g;
    a h;
    androidx.appcompat.view.b i;
    b.a j;
    boolean l;
    boolean m;
    androidx.appcompat.view.h n;
    boolean o;
    private Context u;
    private Activity v;
    private boolean y;
    private boolean z;
    private ArrayList<Object> w = new ArrayList<>();
    private int x = -1;
    private ArrayList<a.b> A = new ArrayList<>();
    private int C = 0;
    boolean k = true;
    private boolean E = true;
    final ab p = new ac() { // from class: androidx.appcompat.app.n.1
        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            if (n.this.k && n.this.f != null) {
                n.this.f.setTranslationY(0.0f);
                n.this.f652c.setTranslationY(0.0f);
            }
            n.this.f652c.setVisibility(8);
            n.this.f652c.setTransitioning(false);
            n.this.n = null;
            n.this.h();
            if (n.this.f651b != null) {
                w.r(n.this.f651b);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    final ab f655q = new ac() { // from class: androidx.appcompat.app.n.2
        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            n.this.n = null;
            n.this.f652c.requestLayout();
        }
    };
    final androidx.core.h.ad r = new androidx.core.h.ad() { // from class: androidx.appcompat.app.n.3
        @Override // androidx.core.h.ad
        public void a(View view) {
            ((View) n.this.f652c.getParent()).invalidate();
        }
    };

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void m() {
    }

    public n(Activity activity, boolean z) {
        this.v = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.f = decorView.findViewById(16908290);
    }

    public n(Dialog dialog) {
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.f651b = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f653d = b(view.findViewById(R.id.action_bar));
        this.f654e = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.f652c = actionBarContainer;
        ad adVar = this.f653d;
        if (adVar == null || this.f654e == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f650a = adVar.b();
        boolean z = (this.f653d.o() & 4) != 0;
        if (z) {
            this.y = true;
        }
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(this.f650a);
        b(a2.f() || z);
        k(a2.d());
        TypedArray obtainStyledAttributes = this.f650a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
            c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ad b(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        w.a(this.f652c, f);
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        k(androidx.appcompat.view.a.a(this.f650a).d());
    }

    private void k(boolean z) {
        this.B = z;
        if (!z) {
            this.f653d.a((ap) null);
            this.f652c.setTabContainer(this.g);
        } else {
            this.f652c.setTabContainer(null);
            this.f653d.a(this.g);
        }
        boolean z2 = true;
        boolean z3 = i() == 2;
        ap apVar = this.g;
        if (apVar != null) {
            if (z3) {
                apVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f651b;
                if (actionBarOverlayLayout != null) {
                    w.r(actionBarOverlayLayout);
                }
            } else {
                apVar.setVisibility(8);
            }
        }
        this.f653d.a(!this.B && z3);
        this.f651b.setHasNonEmbeddedTabs((this.B || !z3) ? false : false);
    }

    void h() {
        b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void a(int i) {
        this.C = i;
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
        androidx.appcompat.view.h hVar;
        this.F = z;
        if (z || (hVar = this.n) == null) {
            return;
        }
        hVar.c();
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
        if (z == this.z) {
            return;
        }
        this.z = z;
        int size = this.A.size();
        for (int i = 0; i < size; i++) {
            this.A.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
        this.f653d.b(z);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.f653d.a(charSequence);
    }

    public void a(int i, int i2) {
        int o = this.f653d.o();
        if ((i2 & 4) != 0) {
            this.y = true;
        }
        this.f653d.c((i & i2) | ((i2 ^ (-1)) & o));
    }

    public int i() {
        return this.f653d.p();
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.f653d.o();
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b a(b.a aVar) {
        a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.c();
        }
        this.f651b.setHideOnContentScrollEnabled(false);
        this.f654e.c();
        a aVar3 = new a(this.f654e.getContext(), aVar);
        if (aVar3.e()) {
            this.h = aVar3;
            aVar3.d();
            this.f654e.a(aVar3);
            j(true);
            this.f654e.sendAccessibilityEvent(32);
            return aVar3;
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void g(boolean z) {
        this.k = z;
    }

    private void n() {
        if (this.D) {
            return;
        }
        this.D = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f651b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        l(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m) {
            this.m = false;
            l(true);
        }
    }

    private void o() {
        if (this.D) {
            this.D = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f651b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        l(true);
    }

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
        if (z && !this.f651b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.f651b.setHideOnContentScrollEnabled(z);
    }

    private void l(boolean z) {
        if (a(this.l, this.m, this.D)) {
            if (this.E) {
                return;
            }
            this.E = true;
            h(z);
        } else if (this.E) {
            this.E = false;
            i(z);
        }
    }

    public void h(boolean z) {
        View view;
        View view2;
        int[] iArr;
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        this.f652c.setVisibility(0);
        if (this.C == 0 && (this.F || z)) {
            this.f652c.setTranslationY(0.0f);
            float f = -this.f652c.getHeight();
            if (z) {
                this.f652c.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            this.f652c.setTranslationY(f);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            aa b2 = w.m(this.f652c).b(0.0f);
            b2.a(this.r);
            hVar2.a(b2);
            if (this.k && (view2 = this.f) != null) {
                view2.setTranslationY(f);
                hVar2.a(w.m(this.f).b(0.0f));
            }
            hVar2.a(t);
            hVar2.a(250L);
            hVar2.a(this.f655q);
            this.n = hVar2;
            hVar2.a();
        } else {
            this.f652c.setAlpha(1.0f);
            this.f652c.setTranslationY(0.0f);
            if (this.k && (view = this.f) != null) {
                view.setTranslationY(0.0f);
            }
            this.f655q.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f651b;
        if (actionBarOverlayLayout != null) {
            w.r(actionBarOverlayLayout);
        }
    }

    public void i(boolean z) {
        View view;
        int[] iArr;
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
        }
        if (this.C == 0 && (this.F || z)) {
            this.f652c.setAlpha(1.0f);
            this.f652c.setTransitioning(true);
            androidx.appcompat.view.h hVar2 = new androidx.appcompat.view.h();
            float f = -this.f652c.getHeight();
            if (z) {
                this.f652c.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            aa b2 = w.m(this.f652c).b(f);
            b2.a(this.r);
            hVar2.a(b2);
            if (this.k && (view = this.f) != null) {
                hVar2.a(w.m(view).b(f));
            }
            hVar2.a(s);
            hVar2.a(250L);
            hVar2.a(this.p);
            this.n = hVar2;
            hVar2.a();
            return;
        }
        this.p.b(null);
    }

    public void j(boolean z) {
        aa a2;
        aa a3;
        if (z) {
            n();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.f653d.d(4);
                this.f654e.setVisibility(0);
                return;
            }
            this.f653d.d(0);
            this.f654e.setVisibility(8);
            return;
        }
        if (z) {
            a3 = this.f653d.a(4, 100L);
            a2 = this.f654e.a(0, 200L);
        } else {
            a2 = this.f653d.a(0, 200L);
            a3 = this.f654e.a(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.a(a3, a2);
        hVar.a();
    }

    private boolean p() {
        return w.A(this.f652c);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        if (this.u == null) {
            TypedValue typedValue = new TypedValue();
            this.f650a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.u = new ContextThemeWrapper(this.f650a, i);
            } else {
                this.u = this.f650a;
            }
        }
        return this.u;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void l() {
        androidx.appcompat.view.h hVar = this.n;
        if (hVar != null) {
            hVar.c();
            this.n = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        ad adVar = this.f653d;
        if (adVar == null || !adVar.c()) {
            return false;
        }
        this.f653d.d();
        return true;
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.b implements g.a {

        /* renamed from: b  reason: collision with root package name */
        private final Context f660b;

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.view.menu.g f661c;

        /* renamed from: d  reason: collision with root package name */
        private b.a f662d;

        /* renamed from: e  reason: collision with root package name */
        private WeakReference<View> f663e;

        public a(Context context, b.a aVar) {
            this.f660b = context;
            this.f662d = aVar;
            androidx.appcompat.view.menu.g defaultShowAsAction = new androidx.appcompat.view.menu.g(context).setDefaultShowAsAction(1);
            this.f661c = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater a() {
            return new androidx.appcompat.view.g(this.f660b);
        }

        @Override // androidx.appcompat.view.b
        public Menu b() {
            return this.f661c;
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            if (n.this.h != this) {
                return;
            }
            if (!n.a(n.this.l, n.this.m, false)) {
                n.this.i = this;
                n.this.j = this.f662d;
            } else {
                this.f662d.a(this);
            }
            this.f662d = null;
            n.this.j(false);
            n.this.f654e.b();
            n.this.f653d.a().sendAccessibilityEvent(32);
            n.this.f651b.setHideOnContentScrollEnabled(n.this.o);
            n.this.h = null;
        }

        @Override // androidx.appcompat.view.b
        public void d() {
            if (n.this.h != this) {
                return;
            }
            this.f661c.stopDispatchingItemsChanged();
            try {
                this.f662d.b(this, this.f661c);
            } finally {
                this.f661c.startDispatchingItemsChanged();
            }
        }

        public boolean e() {
            this.f661c.stopDispatchingItemsChanged();
            try {
                return this.f662d.a(this, this.f661c);
            } finally {
                this.f661c.startDispatchingItemsChanged();
            }
        }

        @Override // androidx.appcompat.view.b
        public void a(View view) {
            n.this.f654e.setCustomView(view);
            this.f663e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void a(CharSequence charSequence) {
            n.this.f654e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void b(CharSequence charSequence) {
            n.this.f654e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void a(int i) {
            b(n.this.f650a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public void b(int i) {
            a((CharSequence) n.this.f650a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public CharSequence f() {
            return n.this.f654e.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return n.this.f654e.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public void a(boolean z) {
            super.a(z);
            n.this.f654e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.b
        public boolean h() {
            return n.this.f654e.d();
        }

        @Override // androidx.appcompat.view.b
        public View i() {
            WeakReference<View> weakReference = this.f663e;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.f662d;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            if (this.f662d == null) {
                return;
            }
            d();
            n.this.f654e.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
        if (this.y) {
            return;
        }
        a(z);
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu b2;
        a aVar = this.h;
        if (aVar == null || (b2 = aVar.b()) == null) {
            return false;
        }
        b2.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return b2.performShortcut(i, keyEvent, 0);
    }
}
