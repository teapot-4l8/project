package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.core.h.b;

/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class i implements androidx.core.a.a.b {
    private View A;
    private androidx.core.h.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    g f793a;

    /* renamed from: b  reason: collision with root package name */
    private final int f794b;

    /* renamed from: c  reason: collision with root package name */
    private final int f795c;

    /* renamed from: d  reason: collision with root package name */
    private final int f796d;

    /* renamed from: e  reason: collision with root package name */
    private final int f797e;
    private CharSequence f;
    private CharSequence g;
    private Intent h;
    private char i;
    private char k;
    private Drawable m;
    private r o;
    private Runnable p;

    /* renamed from: q  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f798q;
    private CharSequence r;
    private CharSequence s;
    private int z;
    private int j = 4096;
    private int l = 4096;
    private int n = 0;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private boolean D = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.f793a = gVar;
        this.f794b = i2;
        this.f795c = i;
        this.f796d = i3;
        this.f797e = i4;
        this.f = charSequence;
        this.z = i5;
    }

    public boolean b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f798q;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(this)) {
            g gVar = this.f793a;
            if (gVar.dispatchMenuItemSelected(gVar, this)) {
                return true;
            }
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return true;
            }
            if (this.h != null) {
                try {
                    this.f793a.getContext().startActivity(this.h);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
                }
            }
            androidx.core.h.b bVar = this.B;
            return bVar != null && bVar.b();
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f795c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f794b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f796d;
    }

    public int c() {
        return this.f797e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.k == c2) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.k == c2 && this.l == i) {
            return this;
        }
        this.k = Character.toLowerCase(c2);
        this.l = KeyEvent.normalizeMetaState(i);
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.i;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.i == c2) {
            return this;
        }
        this.i = c2;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        if (this.i == c2 && this.j == i) {
            return this;
        }
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState(i);
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.i = c2;
        this.k = Character.toLowerCase(c3);
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.i = c2;
        this.j = KeyEvent.normalizeMetaState(i);
        this.k = Character.toLowerCase(c3);
        this.l = KeyEvent.normalizeMetaState(i2);
        this.f793a.onItemsChanged(false);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char d() {
        return this.f793a.isQwertyMode() ? this.k : this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        char d2 = d();
        if (d2 == 0) {
            return "";
        }
        Resources resources = this.f793a.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f793a.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i = this.f793a.isQwertyMode() ? this.l : this.j;
        a(sb, i, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        a(sb, i, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        a(sb, i, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        a(sb, i, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        a(sb, i, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        a(sb, i, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (d2 == '\b') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (d2 == '\n') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (d2 == ' ') {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        } else {
            sb.append(d2);
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f793a.isShortcutsVisible() && d() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public void a(r rVar) {
        this.o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence a(n.a aVar) {
        if (aVar != null && aVar.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f = charSequence;
        this.f793a.onItemsChanged(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f793a.getContext().getString(i));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.g;
        if (charSequence == null) {
            charSequence = this.f;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.g = charSequence;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.m;
        if (drawable != null) {
            return a(drawable);
        }
        if (this.n != 0) {
            Drawable b2 = androidx.appcompat.a.a.a.b(this.f793a.getContext(), this.n);
            this.n = 0;
            this.m = b2;
            return a(b2);
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.n = 0;
        this.m = drawable;
        this.x = true;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.m = null;
        this.n = i;
        this.x = true;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            if (this.v) {
                androidx.core.graphics.drawable.a.a(drawable, this.t);
            }
            if (this.w) {
                androidx.core.graphics.drawable.a.a(drawable, this.u);
            }
            this.x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.y = i2;
        if (i != i2) {
            this.f793a.onItemsChanged(false);
        }
        return this;
    }

    public void a(boolean z) {
        this.y = (z ? 4 : 0) | (this.y & (-5));
    }

    public boolean g() {
        return (this.y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.f793a.setExclusiveItemChecked(this);
        } else {
            b(z);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        int i = this.y;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.y = i2;
        if (i != i2) {
            this.f793a.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.h.b bVar = this.B;
        return (bVar == null || !bVar.d()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(boolean z) {
        int i = this.y;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.y = i2;
        return i != i2;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.f793a.onItemVisibleChanged(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f798q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public void h() {
        this.f793a.onItemActionRequestChanged(this);
    }

    public boolean i() {
        return this.f793a.getOptionalIconsVisible();
    }

    public boolean j() {
        return (this.y & 32) == 32;
    }

    public boolean k() {
        return (this.z & 1) == 1;
    }

    public boolean l() {
        return (this.z & 2) == 2;
    }

    public void d(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    public boolean m() {
        return (this.z & 4) == 4;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i;
        this.f793a.onItemActionRequestChanged(this);
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.f794b) > 0) {
            view.setId(i);
        }
        this.f793a.onItemActionRequestChanged(this);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(int i) {
        Context context = this.f793a.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.h.b bVar = this.B;
        if (bVar != null) {
            View a2 = bVar.a(this);
            this.A = a2;
            return a2;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.a.a.b
    public androidx.core.h.b a() {
        return this.B;
    }

    @Override // androidx.core.a.a.b
    public androidx.core.a.a.b a(androidx.core.h.b bVar) {
        androidx.core.h.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.f();
        }
        this.A = null;
        this.B = bVar;
        this.f793a.onItemsChanged(true);
        androidx.core.h.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.a(new b.InterfaceC0040b() { // from class: androidx.appcompat.view.menu.i.1
                @Override // androidx.core.h.b.InterfaceC0040b
                public void a(boolean z) {
                    i.this.f793a.onItemVisibleChanged(i.this);
                }
            });
        }
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (n()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f793a.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f793a.collapseItemActionView(this);
        }
        return false;
    }

    public boolean n() {
        androidx.core.h.b bVar;
        if ((this.z & 8) != 0) {
            if (this.A == null && (bVar = this.B) != null) {
                this.A = bVar.a(this);
            }
            return this.A != null;
        }
        return false;
    }

    public void e(boolean z) {
        this.D = z;
        this.f793a.onItemsChanged(false);
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.f793a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }
}
