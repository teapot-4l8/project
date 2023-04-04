package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f758a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.b.g<androidx.core.a.a.b, MenuItem> f759b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.b.g<androidx.core.a.a.c, SubMenu> f760c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f758a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (menuItem instanceof androidx.core.a.a.b) {
            androidx.core.a.a.b bVar = (androidx.core.a.a.b) menuItem;
            if (this.f759b == null) {
                this.f759b = new androidx.b.g<>();
            }
            MenuItem menuItem2 = this.f759b.get(menuItem);
            if (menuItem2 == null) {
                j jVar = new j(this.f758a, bVar);
                this.f759b.put(bVar, jVar);
                return jVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof androidx.core.a.a.c) {
            androidx.core.a.a.c cVar = (androidx.core.a.a.c) subMenu;
            if (this.f760c == null) {
                this.f760c = new androidx.b.g<>();
            }
            SubMenu subMenu2 = this.f760c.get(cVar);
            if (subMenu2 == null) {
                s sVar = new s(this.f758a, cVar);
                this.f760c.put(cVar, sVar);
                return sVar;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        androidx.b.g<androidx.core.a.a.b, MenuItem> gVar = this.f759b;
        if (gVar != null) {
            gVar.clear();
        }
        androidx.b.g<androidx.core.a.a.c, SubMenu> gVar2 = this.f760c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.f759b == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.f759b.size()) {
            if (this.f759b.b(i2).getGroupId() == i) {
                this.f759b.d(i2);
                i2--;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        if (this.f759b == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f759b.size(); i2++) {
            if (this.f759b.b(i2).getItemId() == i) {
                this.f759b.d(i2);
                return;
            }
        }
    }
}
