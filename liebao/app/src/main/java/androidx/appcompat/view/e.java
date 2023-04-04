package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f699a;

    /* renamed from: b  reason: collision with root package name */
    private ActionBarContextView f700b;

    /* renamed from: c  reason: collision with root package name */
    private b.a f701c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<View> f702d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f703e;
    private boolean f;
    private androidx.appcompat.view.menu.g g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f699a = context;
        this.f700b = actionBarContextView;
        this.f701c = aVar;
        androidx.appcompat.view.menu.g defaultShowAsAction = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.g = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f = z;
    }

    @Override // androidx.appcompat.view.b
    public void b(CharSequence charSequence) {
        this.f700b.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void a(CharSequence charSequence) {
        this.f700b.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void a(int i) {
        b(this.f699a.getString(i));
    }

    @Override // androidx.appcompat.view.b
    public void b(int i) {
        a((CharSequence) this.f699a.getString(i));
    }

    @Override // androidx.appcompat.view.b
    public void a(boolean z) {
        super.a(z);
        this.f700b.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.b
    public boolean h() {
        return this.f700b.d();
    }

    @Override // androidx.appcompat.view.b
    public void a(View view) {
        this.f700b.setCustomView(view);
        this.f702d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void d() {
        this.f701c.b(this, this.g);
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.f703e) {
            return;
        }
        this.f703e = true;
        this.f700b.sendAccessibilityEvent(32);
        this.f701c.a(this);
    }

    @Override // androidx.appcompat.view.b
    public Menu b() {
        return this.g;
    }

    @Override // androidx.appcompat.view.b
    public CharSequence f() {
        return this.f700b.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f700b.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public View i() {
        WeakReference<View> weakReference = this.f702d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater a() {
        return new g(this.f700b.getContext());
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f701c.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
        d();
        this.f700b.a();
    }
}
