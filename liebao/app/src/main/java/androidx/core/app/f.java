package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.h.f;
import androidx.lifecycle.h;
import androidx.lifecycle.v;

/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class f extends Activity implements f.a, androidx.lifecycle.l {

    /* renamed from: a  reason: collision with root package name */
    private androidx.b.g<Class<? extends Object>, Object> f1431a = new androidx.b.g<>();

    /* renamed from: b  reason: collision with root package name */
    private androidx.lifecycle.m f1432b = new androidx.lifecycle.m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f1432b.a(h.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public androidx.lifecycle.h getLifecycle() {
        return this.f1432b;
    }

    @Override // androidx.core.h.f.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h.f.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h.f.a(decorView, keyEvent)) {
            return androidx.core.h.f.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
