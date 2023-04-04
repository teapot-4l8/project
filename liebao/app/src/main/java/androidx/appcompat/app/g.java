package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.core.h.f;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class g extends Dialog implements d {
    private e mDelegate;
    private final f.a mKeyDispatcher;

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

    public g(Context context) {
        this(context, 0);
    }

    public g(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new f.a() { // from class: androidx.appcompat.app.g.1
            @Override // androidx.core.h.f.a
            public boolean a(KeyEvent keyEvent) {
                return g.this.superDispatchKeyEvent(keyEvent);
            }
        };
        e delegate = getDelegate();
        delegate.a(getThemeResId(context, i));
        delegate.a((Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new f.a() { // from class: androidx.appcompat.app.g.1
            @Override // androidx.core.h.f.a
            public boolean a(KeyEvent keyEvent) {
                return g.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().h();
        super.onCreate(bundle);
        getDelegate().a(bundle);
    }

    public a getSupportActionBar() {
        return getDelegate().a();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().b(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().a(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().d();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().g();
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().d(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().f();
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a(this, this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.h.f.a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
