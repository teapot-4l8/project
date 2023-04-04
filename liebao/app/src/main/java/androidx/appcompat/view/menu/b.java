package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    protected Context f753a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f754b;

    /* renamed from: c  reason: collision with root package name */
    protected g f755c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f756d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f757e;
    protected n f;
    private m.a g;
    private int h;
    private int i;
    private int j;

    public abstract void a(i iVar, n.a aVar);

    public boolean a(int i, i iVar) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    public b(Context context, int i, int i2) {
        this.f753a = context;
        this.f756d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public void initForMenu(Context context, g gVar) {
        this.f754b = context;
        this.f757e = LayoutInflater.from(context);
        this.f755c = gVar;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f == null) {
            n nVar = (n) this.f756d.inflate(this.h, viewGroup, false);
            this.f = nVar;
            nVar.initialize(this.f755c);
            updateMenuView(true);
        }
        return this.f;
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f755c;
        int i = 0;
        if (gVar != null) {
            gVar.flagActionItems();
            ArrayList<i> visibleItems = this.f755c.getVisibleItems();
            int size = visibleItems.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = visibleItems.get(i3);
                if (a(i2, iVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View a2 = a(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        a2.setPressed(false);
                        a2.jumpDrawablesToCurrentState();
                    }
                    if (a2 != childAt) {
                        a(a2, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.g = aVar;
    }

    public m.a a() {
        return this.g;
    }

    public n.a b(ViewGroup viewGroup) {
        return (n.a) this.f756d.inflate(this.i, viewGroup, false);
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a b2;
        if (view instanceof n.a) {
            b2 = (n.a) view;
        } else {
            b2 = b(viewGroup);
        }
        a(iVar, b2);
        return (View) b2;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z) {
        m.a aVar = this.g;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.g] */
    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        m.a aVar = this.g;
        r rVar2 = rVar;
        if (aVar != null) {
            if (rVar == null) {
                rVar2 = this.f755c;
            }
            return aVar.a(rVar2);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }
}
