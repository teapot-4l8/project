package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.ax;
import androidx.core.h.w;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
class k extends androidx.appcompat.app.a {

    /* renamed from: a  reason: collision with root package name */
    ad f626a;

    /* renamed from: b  reason: collision with root package name */
    boolean f627b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f628c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f629d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f630e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new Runnable() { // from class: androidx.appcompat.app.k.1
        @Override // java.lang.Runnable
        public void run() {
            k.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c() { // from class: androidx.appcompat.app.k.2
        @Override // androidx.appcompat.widget.Toolbar.c
        public boolean a(MenuItem menuItem) {
            return k.this.f628c.onMenuItemSelected(0, menuItem);
        }
    };

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f626a = new ax(toolbar, false);
        c cVar = new c(callback);
        this.f628c = cVar;
        this.f626a.a(cVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f626a.a(charSequence);
    }

    public Window.Callback h() {
        return this.f628c;
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        w.a(this.f626a.a(), f);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        return this.f626a.b();
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.f626a.a(charSequence);
    }

    public void a(int i, int i2) {
        this.f626a.c((i & i2) | ((i2 ^ (-1)) & this.f626a.o()));
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.f626a.o();
    }

    @Override // androidx.appcompat.app.a
    public boolean c() {
        return this.f626a.k();
    }

    @Override // androidx.appcompat.app.a
    public boolean d() {
        return this.f626a.l();
    }

    @Override // androidx.appcompat.app.a
    public boolean e() {
        this.f626a.a().removeCallbacks(this.g);
        w.a(this.f626a.a(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        if (this.f626a.c()) {
            this.f626a.d();
            return true;
        }
        return false;
    }

    void i() {
        Menu j = j();
        androidx.appcompat.view.menu.g gVar = j instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) j : null;
        if (gVar != null) {
            gVar.stopDispatchingItemsChanged();
        }
        try {
            j.clear();
            if (!this.f628c.onCreatePanelMenu(0, j) || !this.f628c.onPreparePanel(0, null, j)) {
                j.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.startDispatchingItemsChanged();
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu j = j();
        if (j != null) {
            j.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return j.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void g() {
        this.f626a.a().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
        if (z == this.f630e) {
            return;
        }
        this.f630e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).a(z);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    private class c extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !k.this.f627b) {
                k.this.f626a.m();
                k.this.f627b = true;
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(k.this.f626a.b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu j() {
        if (!this.f629d) {
            this.f626a.a(new a(), new b());
            this.f629d = true;
        }
        return this.f626a.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class a implements m.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f634b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (k.this.f628c != null) {
                k.this.f628c.onMenuOpened(108, gVar);
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.f634b) {
                return;
            }
            this.f634b = true;
            k.this.f626a.n();
            if (k.this.f628c != null) {
                k.this.f628c.onPanelClosed(108, gVar);
            }
            this.f634b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class b implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            if (k.this.f628c != null) {
                if (k.this.f626a.i()) {
                    k.this.f628c.onPanelClosed(108, gVar);
                } else if (k.this.f628c.onPreparePanel(0, null, gVar)) {
                    k.this.f628c.onMenuOpened(108, gVar);
                }
            }
        }
    }
}
