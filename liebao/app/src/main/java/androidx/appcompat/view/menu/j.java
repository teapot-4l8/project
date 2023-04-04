package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.h.b;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public class j extends androidx.appcompat.view.menu.c implements MenuItem {

    /* renamed from: b  reason: collision with root package name */
    private final androidx.core.a.a.b f800b;

    /* renamed from: c  reason: collision with root package name */
    private Method f801c;

    public j(Context context, androidx.core.a.a.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f800b = bVar;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f800b.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f800b.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f800b.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f800b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f800b.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f800b.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f800b.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f800b.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f800b.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f800b.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f800b.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f800b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f800b.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f800b.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f800b.setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f800b.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f800b.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f800b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f800b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f800b.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f800b.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f800b.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f800b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f800b.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f800b.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f800b.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f800b.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f800b.setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f800b.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f800b.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f800b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f800b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return a(this.f800b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f800b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f800b.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f800b.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f800b.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f800b.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f800b.setActionView(i);
        View actionView = this.f800b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f800b.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f800b.getActionView();
        return actionView instanceof c ? ((c) actionView).c() : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.h.b aVar;
        if (Build.VERSION.SDK_INT >= 16) {
            aVar = new b(this.f758a, actionProvider);
        } else {
            aVar = new a(this.f758a, actionProvider);
        }
        androidx.core.a.a.b bVar = this.f800b;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        androidx.core.h.b a2 = this.f800b.a();
        if (a2 instanceof a) {
            return ((a) a2).f802a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f800b.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f800b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f800b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f800b.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f800b.a(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f800b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f800b.b(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f800b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f800b.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f800b.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f800b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f800b.getIconTintMode();
    }

    public void a(boolean z) {
        try {
            if (this.f801c == null) {
                this.f801c = this.f800b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f801c.invoke(this.f800b, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f810b;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f810b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f810b.onMenuItemClick(j.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: b  reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f808b;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f808b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f808b.onMenuItemActionExpand(j.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f808b.onMenuItemActionCollapse(j.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class a extends androidx.core.h.b {

        /* renamed from: a  reason: collision with root package name */
        final ActionProvider f802a;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f802a = actionProvider;
        }

        @Override // androidx.core.h.b
        public View a() {
            return this.f802a.onCreateActionView();
        }

        @Override // androidx.core.h.b
        public boolean b() {
            return this.f802a.onPerformDefaultAction();
        }

        @Override // androidx.core.h.b
        public boolean c() {
            return this.f802a.hasSubMenu();
        }

        @Override // androidx.core.h.b
        public void a(SubMenu subMenu) {
            this.f802a.onPrepareSubMenu(j.this.a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        private b.InterfaceC0040b f805d;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.h.b
        public View a(MenuItem menuItem) {
            return this.f802a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.h.b
        public boolean d() {
            return this.f802a.overridesItemVisibility();
        }

        @Override // androidx.core.h.b
        public boolean e() {
            return this.f802a.isVisible();
        }

        @Override // androidx.core.h.b
        public void a(b.InterfaceC0040b interfaceC0040b) {
            this.f805d = interfaceC0040b;
            this.f802a.setVisibilityListener(interfaceC0040b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            b.InterfaceC0040b interfaceC0040b = this.f805d;
            if (interfaceC0040b != null) {
                interfaceC0040b.a(z);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* loaded from: classes.dex */
    static class c extends FrameLayout implements androidx.appcompat.view.c {

        /* renamed from: a  reason: collision with root package name */
        final CollapsibleActionView f806a;

        c(View view) {
            super(view.getContext());
            this.f806a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.c
        public void a() {
            this.f806a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.c
        public void b() {
            this.f806a.onActionViewCollapsed();
        }

        View c() {
            return (View) this.f806a;
        }
    }
}
