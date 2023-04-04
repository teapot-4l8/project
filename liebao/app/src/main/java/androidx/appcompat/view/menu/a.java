package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public class a implements androidx.core.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f747a;

    /* renamed from: b  reason: collision with root package name */
    private final int f748b;

    /* renamed from: c  reason: collision with root package name */
    private final int f749c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f750d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f751e;
    private Intent f;
    private char g;
    private char i;
    private Drawable k;
    private Context l;
    private MenuItem.OnMenuItemClickListener m;
    private CharSequence n;
    private CharSequence o;
    private int h = 4096;
    private int j = 4096;
    private ColorStateList p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f752q = null;
    private boolean r = false;
    private boolean s = false;
    private int t = 16;

    @Override // androidx.core.a.a.b
    public androidx.core.h.b a() {
        return null;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    public a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.l = context;
        this.f747a = i2;
        this.f748b = i;
        this.f749c = i4;
        this.f750d = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f748b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f747a;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f749c;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f750d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f751e;
        return charSequence != null ? charSequence : this.f750d;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.t & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.t & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.t & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.t & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.t = (z ? 1 : 0) | (this.t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.t = (z ? 2 : 0) | (this.t & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.t = (z ? 16 : 0) | (this.t & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.k = androidx.core.content.b.a(this.l, i);
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase(c3);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i);
        this.i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f750d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f750d = this.l.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f751e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.t = (this.t & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b
    public androidx.core.a.a.b a(androidx.core.h.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public androidx.core.a.a.b setContentDescription(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.n;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public androidx.core.a.a.b setTooltipText(CharSequence charSequence) {
        this.o = charSequence;
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.o;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        this.r = true;
        b();
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.p;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f752q = mode;
        this.s = true;
        b();
        return this;
    }

    @Override // androidx.core.a.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f752q;
    }

    private void b() {
        if (this.k != null) {
            if (this.r || this.s) {
                Drawable g = androidx.core.graphics.drawable.a.g(this.k);
                this.k = g;
                Drawable mutate = g.mutate();
                this.k = mutate;
                if (this.r) {
                    androidx.core.graphics.drawable.a.a(mutate, this.p);
                }
                if (this.s) {
                    androidx.core.graphics.drawable.a.a(this.k, this.f752q);
                }
            }
        }
    }
}
