package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
public class c extends androidx.appcompat.view.menu.b implements b.a {
    d g;
    e h;
    a i;
    RunnableC0025c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private int f1048q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private b z;

    public c(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void initForMenu(Context context, androidx.appcompat.view.menu.g gVar) {
        super.initForMenu(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.f1048q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i = this.f1048q;
        if (this.o) {
            if (this.g == null) {
                d dVar = new d(this.f753a);
                this.g = dVar;
                if (this.n) {
                    dVar.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.f754b).a();
        }
        if (this.f755c != null) {
            this.f755c.onItemsChanged(true);
        }
    }

    public void a(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void b(boolean z) {
        this.w = z;
    }

    public void a(Drawable drawable) {
        d dVar = this.g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.n = true;
        this.m = drawable;
    }

    public Drawable b() {
        d dVar = this.g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n a(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f;
        androidx.appcompat.view.menu.n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.n()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.initialize(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.z == null) {
            this.z = new b();
        }
        actionMenuItemView.setPopupCallback(this.z);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.f755c != null) {
            ArrayList<androidx.appcompat.view.menu.i> actionItems = this.f755c.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                androidx.core.h.b a2 = actionItems.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.i> nonActionItems = this.f755c != null ? this.f755c.getNonActionItems() : null;
        if (this.o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.f753a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else {
            d dVar = this.g;
            if (dVar != null && dVar.getParent() == this.f) {
                ((ViewGroup) this.f).removeView(this.g);
            }
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (rVar.hasVisibleItems()) {
            androidx.appcompat.view.menu.r rVar2 = rVar;
            while (rVar2.getParentMenu() != this.f755c) {
                rVar2 = (androidx.appcompat.view.menu.r) rVar2.getParentMenu();
            }
            View a2 = a(rVar2.getItem());
            if (a2 == null) {
                return false;
            }
            this.l = rVar.getItem().getItemId();
            int size = rVar.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MenuItem item = rVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i++;
            }
            a aVar = new a(this.f754b, rVar, a2);
            this.i = aVar;
            aVar.a(z);
            this.i.a();
            super.onSubMenuSelected(rVar);
            return true;
        }
        return false;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean c() {
        if (!this.o || g() || this.f755c == null || this.f == null || this.j != null || this.f755c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.j = new RunnableC0025c(new e(this.f754b, this.f755c, this.g, true));
        ((View) this.f).post(this.j);
        return true;
    }

    public boolean d() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar != null) {
            eVar.d();
            return true;
        }
        return false;
    }

    public boolean e() {
        return d() | f();
    }

    public boolean f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
            return true;
        }
        return false;
    }

    public boolean g() {
        e eVar = this.h;
        return eVar != null && eVar.f();
    }

    public boolean h() {
        return this.j != null || g();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i;
        int i2;
        int i3;
        int i4;
        c cVar = this;
        View view = null;
        int i5 = 0;
        if (cVar.f755c != null) {
            arrayList = cVar.f755c.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.s;
        int i7 = cVar.r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f;
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i10);
            if (iVar.l()) {
                i8++;
            } else if (iVar.k()) {
                i9++;
            } else {
                z = true;
            }
            if (cVar.w && iVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.o && (z || i9 + i8 > i6)) {
            i6--;
        }
        int i11 = i6 - i8;
        SparseBooleanArray sparseBooleanArray = cVar.y;
        sparseBooleanArray.clear();
        if (cVar.u) {
            int i12 = cVar.x;
            i3 = i7 / i12;
            i2 = i12 + ((i7 % i12) / i3);
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i13);
            if (iVar2.l()) {
                View a2 = cVar.a(iVar2, view, viewGroup);
                if (cVar.u) {
                    i3 -= ActionMenuView.a(a2, i2, i3, makeMeasureSpec, i5);
                } else {
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a2.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.d(true);
                i4 = i;
            } else if (iVar2.k()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i11 > 0 || z2) && i7 > 0 && (!cVar.u || i3 > 0);
                boolean z4 = z3;
                i4 = i;
                if (z3) {
                    View a3 = cVar.a(iVar2, null, viewGroup);
                    if (cVar.u) {
                        int a4 = ActionMenuView.a(a3, i2, i3, makeMeasureSpec, 0);
                        i3 -= a4;
                        if (a4 == 0) {
                            z4 = false;
                        }
                    } else {
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = a3.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z5 & (!cVar.u ? i7 + i14 <= 0 : i7 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i15);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.j()) {
                                i11++;
                            }
                            iVar3.d(false);
                        }
                    }
                }
                if (z3) {
                    i11--;
                }
                iVar2.d(z3);
            } else {
                i4 = i;
                iVar2.d(false);
                i13++;
                cVar = this;
                i = i4;
                view = null;
                i5 = 0;
            }
            i13++;
            cVar = this;
            i = i4;
            view = null;
            i5 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z) {
        e();
        super.onCloseMenu(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.f1058a = this.l;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof g) {
            g gVar = (g) parcelable;
            if (gVar.f1058a <= 0 || (findItem = this.f755c.findItem(gVar.f1058a)) == null) {
                return;
            }
            onSubMenuSelected((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.core.h.b.a
    public void c(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.f755c != null) {
            this.f755c.close(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.initialize(this.f755c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: androidx.appcompat.widget.c.g.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public g[] newArray(int i) {
                return new g[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public int f1058a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        g() {
        }

        g(Parcel parcel) {
            this.f1058a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1058a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class d extends o implements ActionMenuView.a {
        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ay.a(this, getContentDescription());
            setOnTouchListener(new ah(this) { // from class: androidx.appcompat.widget.c.d.1
                @Override // androidx.appcompat.widget.ah
                public androidx.appcompat.view.menu.p a() {
                    if (c.this.h == null) {
                        return null;
                    }
                    return c.this.h.b();
                }

                @Override // androidx.appcompat.widget.ah
                public boolean b() {
                    c.this.c();
                    return true;
                }

                @Override // androidx.appcompat.widget.ah
                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.d();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.c();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, R.attr.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (c.this.f755c != null) {
                c.this.f755c.close();
            }
            c.this.h = null;
            super.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).j()) {
                a(c.this.g == null ? (View) c.this.f : c.this.g);
            }
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            c.this.i = null;
            c.this.l = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == c.this.f755c) {
                return false;
            }
            c.this.l = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a a2 = c.this.a();
            if (a2 != null) {
                return a2.a(gVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.getRootMenu().close(false);
            }
            m.a a2 = c.this.a();
            if (a2 != null) {
                a2.a(gVar, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0025c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private e f1052b;

        public RunnableC0025c(e eVar) {
            this.f1052b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f755c != null) {
                c.this.f755c.changeMenuMode();
            }
            View view = (View) c.this.f;
            if (view != null && view.getWindowToken() != null && this.f1052b.c()) {
                c.this.h = this.f1052b;
            }
            c.this.j = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            if (c.this.i != null) {
                return c.this.i.b();
            }
            return null;
        }
    }
}
