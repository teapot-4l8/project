package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ak;
import androidx.appcompat.widget.al;
import androidx.core.h.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {
    private static final int g = R.layout.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;

    /* renamed from: a  reason: collision with root package name */
    final Handler f761a;

    /* renamed from: d  reason: collision with root package name */
    View f764d;

    /* renamed from: e  reason: collision with root package name */
    ViewTreeObserver f765e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private View r;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean y;
    private m.a z;
    private final List<g> m = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    final List<a> f762b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f763c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.d.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.c() || d.this.f762b.size() <= 0 || d.this.f762b.get(0).f774a.i()) {
                return;
            }
            View view = d.this.f764d;
            if (view == null || !view.isShown()) {
                d.this.b();
                return;
            }
            for (a aVar : d.this.f762b) {
                aVar.f774a.b_();
            }
        }
    };
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.d.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d.this.f765e != null) {
                if (!d.this.f765e.isAlive()) {
                    d.this.f765e = view.getViewTreeObserver();
                }
                d.this.f765e.removeGlobalOnLayoutListener(d.this.f763c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final ak o = new ak() { // from class: androidx.appcompat.view.menu.d.3
        @Override // androidx.appcompat.widget.ak
        public void a(g gVar, MenuItem menuItem) {
            d.this.f761a.removeCallbacksAndMessages(gVar);
        }

        @Override // androidx.appcompat.widget.ak
        public void b(final g gVar, final MenuItem menuItem) {
            d.this.f761a.removeCallbacksAndMessages(null);
            int size = d.this.f762b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.f762b.get(i).f775b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < d.this.f762b.size() ? d.this.f762b.get(i2) : null;
            d.this.f761a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.d.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        d.this.f = true;
                        aVar.f775b.close(false);
                        d.this.f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        gVar.performItemAction(menuItem, 4);
                    }
                }
            }, gVar, SystemClock.uptimeMillis() + 200);
        }
    };
    private int p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f766q = 0;
    private boolean x = false;
    private int s = h();

    @Override // androidx.appcompat.view.menu.k
    protected boolean e() {
        return false;
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

    public d(Context context, View view, int i, int i2, boolean z) {
        this.h = context;
        this.r = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f761a = new Handler();
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(boolean z) {
        this.x = z;
    }

    private al g() {
        al alVar = new al(this.h, null, this.j, this.k);
        alVar.a(this.o);
        alVar.a((AdapterView.OnItemClickListener) this);
        alVar.a((PopupWindow.OnDismissListener) this);
        alVar.b(this.r);
        alVar.f(this.f766q);
        alVar.a(true);
        alVar.i(2);
        return alVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void b_() {
        if (c()) {
            return;
        }
        for (g gVar : this.m) {
            c(gVar);
        }
        this.m.clear();
        View view = this.r;
        this.f764d = view;
        if (view != null) {
            boolean z = this.f765e == null;
            ViewTreeObserver viewTreeObserver = this.f764d.getViewTreeObserver();
            this.f765e = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f763c);
            }
            this.f764d.addOnAttachStateChangeListener(this.n);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void b() {
        int size = this.f762b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f762b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f774a.c()) {
                    aVar.f774a.b();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            b();
            return true;
        }
        return false;
    }

    private int h() {
        return w.g(this.r) == 1 ? 0 : 1;
    }

    private int d(int i) {
        List<a> list = this.f762b;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f764d.getWindowVisibleDisplayFrame(rect);
        return this.s == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
        gVar.addMenuPresenter(this, this.h);
        if (c()) {
            c(gVar);
        } else {
            this.m.add(gVar);
        }
    }

    private void c(g gVar) {
        a aVar;
        View view;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.h);
        f fVar = new f(gVar, from, this.l, g);
        if (!c() && this.x) {
            fVar.a(true);
        } else if (c()) {
            fVar.a(k.b(gVar));
        }
        int a2 = a(fVar, null, this.h, this.i);
        al g2 = g();
        g2.a((ListAdapter) fVar);
        g2.h(a2);
        g2.f(this.f766q);
        if (this.f762b.size() > 0) {
            List<a> list = this.f762b;
            aVar = list.get(list.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            g2.c(false);
            g2.a((Object) null);
            int d2 = d(a2);
            boolean z = d2 == 1;
            this.s = d2;
            if (Build.VERSION.SDK_INT >= 26) {
                g2.b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f766q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f766q & 5) == 5) {
                if (!z) {
                    a2 = view.getWidth();
                    i3 = i - a2;
                }
                i3 = i + a2;
            } else {
                if (z) {
                    a2 = view.getWidth();
                    i3 = i + a2;
                }
                i3 = i - a2;
            }
            g2.b(i3);
            g2.b(true);
            g2.a(i2);
        } else {
            if (this.t) {
                g2.b(this.v);
            }
            if (this.u) {
                g2.a(this.w);
            }
            g2.a(f());
        }
        this.f762b.add(new a(g2, gVar, this.s));
        g2.b_();
        ListView c_ = g2.c_();
        c_.setOnKeyListener(this);
        if (aVar == null && this.y && gVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c_, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.getHeaderTitle());
            c_.addHeaderView(frameLayout, null, false);
            g2.b_();
        }
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        f fVar;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.f775b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a2 == fVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean c() {
        return this.f762b.size() > 0 && this.f762b.get(0).f774a.c();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.f762b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f762b.get(i);
            if (!aVar.f774a.c()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.f775b.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z) {
        for (a aVar : this.f762b) {
            a(aVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.z = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        for (a aVar : this.f762b) {
            if (rVar == aVar.f775b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (rVar.hasVisibleItems()) {
            a(rVar);
            m.a aVar2 = this.z;
            if (aVar2 != null) {
                aVar2.a(rVar);
            }
            return true;
        }
        return false;
    }

    private int d(g gVar) {
        int size = this.f762b.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.f762b.get(i).f775b) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z) {
        int d2 = d(gVar);
        if (d2 < 0) {
            return;
        }
        int i = d2 + 1;
        if (i < this.f762b.size()) {
            this.f762b.get(i).f775b.close(false);
        }
        a remove = this.f762b.remove(d2);
        remove.f775b.removeMenuPresenter(this);
        if (this.f) {
            remove.f774a.b((Object) null);
            remove.f774a.e(0);
        }
        remove.f774a.b();
        int size = this.f762b.size();
        if (size > 0) {
            this.s = this.f762b.get(size - 1).f776c;
        } else {
            this.s = h();
        }
        if (size != 0) {
            if (z) {
                this.f762b.get(0).f775b.close(false);
                return;
            }
            return;
        }
        b();
        m.a aVar = this.z;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f765e;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f765e.removeGlobalOnLayoutListener(this.f763c);
            }
            this.f765e = null;
        }
        this.f764d.removeOnAttachStateChangeListener(this.n);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        if (this.p != i) {
            this.p = i;
            this.f766q = androidx.core.h.e.a(i, w.g(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.f766q = androidx.core.h.e.a(this.p, w.g(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView c_() {
        if (this.f762b.isEmpty()) {
            return null;
        }
        List<a> list = this.f762b;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.y = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final al f774a;

        /* renamed from: b  reason: collision with root package name */
        public final g f775b;

        /* renamed from: c  reason: collision with root package name */
        public final int f776c;

        public a(al alVar, g gVar, int i) {
            this.f774a = alVar;
            this.f775b = gVar;
            this.f776c = i;
        }

        public ListView a() {
            return this.f774a.c_();
        }
    }
}
