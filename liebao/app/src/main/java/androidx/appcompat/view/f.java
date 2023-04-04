package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f704a;

    /* renamed from: b  reason: collision with root package name */
    final b f705b;

    public f(Context context, b bVar) {
        this.f704a = context;
        this.f705b = bVar;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f705b.j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f705b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f705b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f705b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f705b.d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f705b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f704a, (androidx.core.a.a.a) this.f705b.b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f705b.f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f705b.a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f705b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f705b.b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f705b.i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f705b.a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f705b.a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f705b.k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f705b.a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f705b.h();
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f706a;

        /* renamed from: b  reason: collision with root package name */
        final Context f707b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f708c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final androidx.b.g<Menu, Menu> f709d = new androidx.b.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f707b = context;
            this.f706a = callback;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f706a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f706a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f706a.onActionItemClicked(b(bVar), new j(this.f707b, (androidx.core.a.a.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f706a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.f709d.get(menu);
            if (menu2 == null) {
                o oVar = new o(this.f707b, (androidx.core.a.a.a) menu);
                this.f709d.put(menu, oVar);
                return oVar;
            }
            return menu2;
        }

        public ActionMode b(b bVar) {
            int size = this.f708c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f708c.get(i);
                if (fVar != null && fVar.f705b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f707b, bVar);
            this.f708c.add(fVar2);
            return fVar2;
        }
    }
}
