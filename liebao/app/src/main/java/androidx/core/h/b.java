package androidx.core.h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1705a;

    /* renamed from: b  reason: collision with root package name */
    private a f1706b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0040b f1707c;

    /* compiled from: ActionProvider.java */
    /* loaded from: classes.dex */
    public interface a {
        void c(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f1705a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        a aVar = this.f1706b;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void a(a aVar) {
        this.f1706b = aVar;
    }

    public void a(InterfaceC0040b interfaceC0040b) {
        if (this.f1707c != null && interfaceC0040b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1707c = interfaceC0040b;
    }

    public void f() {
        this.f1707c = null;
        this.f1706b = null;
    }
}
