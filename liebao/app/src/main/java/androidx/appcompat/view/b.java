package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private Object f692a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f693b;

    /* compiled from: ActionMode.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(b bVar);

        boolean a(b bVar, Menu menu);

        boolean a(b bVar, MenuItem menuItem);

        boolean b(b bVar, Menu menu);
    }

    public abstract MenuInflater a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public abstract Menu b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract void c();

    public abstract void d();

    public abstract CharSequence f();

    public abstract CharSequence g();

    public boolean h() {
        return false;
    }

    public abstract View i();

    public void a(Object obj) {
        this.f692a = obj;
    }

    public Object j() {
        return this.f692a;
    }

    public void a(boolean z) {
        this.f693b = z;
    }

    public boolean k() {
        return this.f693b;
    }
}
