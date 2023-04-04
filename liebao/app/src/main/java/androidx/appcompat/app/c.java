package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.bb;
import androidx.core.app.o;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class c extends androidx.fragment.app.e implements d, o.a {
    private e k;
    private Resources l;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
    }

    public void b(o oVar) {
    }

    @Deprecated
    public void g() {
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeFinished(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeStarted(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(h().b(context));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        e h = h();
        h.h();
        h.a(bundle);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        h().a(i);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h().b(bundle);
    }

    public a c() {
        return h().a();
    }

    public void a(Toolbar toolbar) {
        h().a(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return h().b();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        h().c(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        h().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().b(view, layoutParams);
    }

    @Override // androidx.fragment.app.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l != null) {
            this.l.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        h().a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        h().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onStart() {
        super.onStart();
        h().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        super.onStop();
        h().d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) h().b(i);
    }

    @Override // androidx.fragment.app.e, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a c2 = c();
        if (menuItem.getItemId() != 16908332 || c2 == null || (c2.a() & 4) == 0) {
            return false;
        }
        return e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        h().g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        h().a(charSequence);
    }

    @Override // androidx.fragment.app.e
    public void d() {
        h().f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        h().f();
    }

    public void a(o oVar) {
        oVar.a((Activity) this);
    }

    public boolean e() {
        Intent f = f();
        if (f != null) {
            if (a(f)) {
                o a2 = o.a((Context) this);
                a(a2);
                b(a2);
                a2.a();
                try {
                    androidx.core.app.a.a((Activity) this);
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            b(f);
            return true;
        }
        return false;
    }

    @Override // androidx.core.app.o.a
    public Intent f() {
        return androidx.core.app.g.a(this);
    }

    public boolean a(Intent intent) {
        return androidx.core.app.g.a(this, intent);
    }

    public void b(Intent intent) {
        androidx.core.app.g.b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.e, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        h().c(bundle);
    }

    public e h() {
        if (this.k == null) {
            this.k = e.a(this, this);
        }
        return this.k;
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a c2 = c();
        if (keyCode == 82 && c2 != null && c2.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.l == null && bb.a()) {
            this.l = new bb(this, super.getResources());
        }
        Resources resources = this.l;
        return resources == null ? super.getResources() : resources;
    }

    private boolean b(KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (b(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a c2 = c();
        if (getWindow().hasFeature(0)) {
            if (c2 == null || !c2.c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a c2 = c();
        if (getWindow().hasFeature(0)) {
            if (c2 == null || !c2.d()) {
                super.closeOptionsMenu();
            }
        }
    }
}
