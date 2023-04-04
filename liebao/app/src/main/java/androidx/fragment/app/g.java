package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.ab;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final i<?> f1857a;

    public static g a(i<?> iVar) {
        return new g((i) androidx.core.g.f.a(iVar, "callbacks == null"));
    }

    private g(i<?> iVar) {
        this.f1857a = iVar;
    }

    public j a() {
        return this.f1857a.f1860b;
    }

    public d a(String str) {
        return this.f1857a.f1860b.b(str);
    }

    public void a(d dVar) {
        k kVar = this.f1857a.f1860b;
        i<?> iVar = this.f1857a;
        kVar.a(iVar, iVar, dVar);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1857a.f1860b.onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.f1857a.f1860b.p();
    }

    public Parcelable c() {
        return this.f1857a.f1860b.o();
    }

    public void a(Parcelable parcelable) {
        i<?> iVar = this.f1857a;
        if (!(iVar instanceof ab)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        iVar.f1860b.a(parcelable);
    }

    public void d() {
        this.f1857a.f1860b.q();
    }

    public void e() {
        this.f1857a.f1860b.r();
    }

    public void f() {
        this.f1857a.f1860b.s();
    }

    public void g() {
        this.f1857a.f1860b.t();
    }

    public void h() {
        this.f1857a.f1860b.u();
    }

    public void i() {
        this.f1857a.f1860b.v();
    }

    public void j() {
        this.f1857a.f1860b.x();
    }

    public void a(boolean z) {
        this.f1857a.f1860b.a(z);
    }

    public void b(boolean z) {
        this.f1857a.f1860b.b(z);
    }

    public void a(Configuration configuration) {
        this.f1857a.f1860b.a(configuration);
    }

    public void k() {
        this.f1857a.f1860b.y();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f1857a.f1860b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.f1857a.f1860b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.f1857a.f1860b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.f1857a.f1860b.b(menuItem);
    }

    public void b(Menu menu) {
        this.f1857a.f1860b.b(menu);
    }

    public boolean l() {
        return this.f1857a.f1860b.l();
    }
}
