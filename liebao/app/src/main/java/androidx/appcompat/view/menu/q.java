package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.al;
import androidx.core.h.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class q extends k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, m {

    /* renamed from: e  reason: collision with root package name */
    private static final int f819e = R.layout.abc_popup_menu_item_layout;

    /* renamed from: a  reason: collision with root package name */
    final al f820a;

    /* renamed from: c  reason: collision with root package name */
    View f822c;

    /* renamed from: d  reason: collision with root package name */
    ViewTreeObserver f823d;
    private final Context f;
    private final g g;
    private final f h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private PopupWindow.OnDismissListener n;
    private View o;
    private m.a p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f824q;
    private boolean r;
    private int s;
    private boolean u;

    /* renamed from: b  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f821b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.q.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.c() || q.this.f820a.i()) {
                return;
            }
            View view = q.this.f822c;
            if (view == null || !view.isShown()) {
                q.this.b();
            } else {
                q.this.f820a.b_();
            }
        }
    };
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.q.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (q.this.f823d != null) {
                if (!q.this.f823d.isAlive()) {
                    q.this.f823d = view.getViewTreeObserver();
                }
                q.this.f823d.removeGlobalOnLayoutListener(q.this.f821b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        return null;
    }

    public q(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = gVar;
        this.i = z;
        this.h = new f(gVar, LayoutInflater.from(context), this.i, f819e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.o = view;
        this.f820a = new al(this.f, null, this.k, this.l);
        gVar.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(boolean z) {
        this.h.a(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        this.t = i;
    }

    private boolean g() {
        View view;
        if (c()) {
            return true;
        }
        if (this.f824q || (view = this.o) == null) {
            return false;
        }
        this.f822c = view;
        this.f820a.a((PopupWindow.OnDismissListener) this);
        this.f820a.a((AdapterView.OnItemClickListener) this);
        this.f820a.a(true);
        View view2 = this.f822c;
        boolean z = this.f823d == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f823d = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f821b);
        }
        view2.addOnAttachStateChangeListener(this.m);
        this.f820a.b(view2);
        this.f820a.f(this.t);
        if (!this.r) {
            this.s = a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.f820a.h(this.s);
        this.f820a.i(2);
        this.f820a.a(f());
        this.f820a.b_();
        ListView c_ = this.f820a.c_();
        c_.setOnKeyListener(this);
        if (this.u && this.g.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c_, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.g.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            c_.addHeaderView(frameLayout, null, false);
        }
        this.f820a.a((ListAdapter) this.h);
        this.f820a.b_();
        return true;
    }

    @Override // androidx.appcompat.view.menu.p
    public void b_() {
        if (!g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        if (c()) {
            this.f820a.b();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return !this.f824q && this.f820a.c();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f824q = true;
        this.g.close();
        ViewTreeObserver viewTreeObserver = this.f823d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f823d = this.f822c.getViewTreeObserver();
            }
            this.f823d.removeGlobalOnLayoutListener(this.f821b);
            this.f823d = null;
        }
        this.f822c.removeOnAttachStateChangeListener(this.m);
        PopupWindow.OnDismissListener onDismissListener = this.n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z) {
        this.r = false;
        f fVar = this.h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f, rVar, this.f822c, this.i, this.k, this.l);
            lVar.a(this.p);
            lVar.a(k.b(rVar));
            lVar.a(this.n);
            this.n = null;
            this.g.close(false);
            int f = this.f820a.f();
            int e2 = this.f820a.e();
            if ((Gravity.getAbsoluteGravity(this.t, w.g(this.o)) & 7) == 5) {
                f += this.o.getWidth();
            }
            if (lVar.a(f, e2)) {
                m.a aVar = this.p;
                if (aVar != null) {
                    aVar.a(rVar);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z) {
        if (gVar != this.g) {
            return;
        }
        b();
        m.a aVar = this.p;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        this.o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            b();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView c_() {
        return this.f820a.c_();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.f820a.b(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.f820a.a(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.u = z;
    }
}
