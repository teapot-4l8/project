package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.f;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.v;

/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class b extends f implements d, ab, l, androidx.savedstate.c {

    /* renamed from: c  reason: collision with root package name */
    private aa f522c;

    /* renamed from: e  reason: collision with root package name */
    private int f524e;

    /* renamed from: a  reason: collision with root package name */
    private final m f520a = new m(this);

    /* renamed from: b  reason: collision with root package name */
    private final androidx.savedstate.b f521b = androidx.savedstate.b.a(this);

    /* renamed from: d  reason: collision with root package name */
    private final OnBackPressedDispatcher f523d = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.super.onBackPressed();
        }
    });

    @Deprecated
    public Object a() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComponentActivity.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Object f526a;

        /* renamed from: b  reason: collision with root package name */
        aa f527b;

        a() {
        }
    }

    public b() {
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a(new j() { // from class: androidx.activity.ComponentActivity$2
                @Override // androidx.lifecycle.j
                public void onStateChanged(l lVar, h.a aVar) {
                    if (aVar == h.a.ON_STOP) {
                        Window window = b.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a(new j() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.j
            public void onStateChanged(l lVar, h.a aVar) {
                if (aVar != h.a.ON_DESTROY || b.this.isChangingConfigurations()) {
                    return;
                }
                b.this.getViewModelStore().a();
            }
        });
        if (19 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 23) {
            return;
        }
        getLifecycle().a(new ImmLeaksCleaner(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f521b.a(bundle);
        v.a(this);
        int i = this.f524e;
        if (i != 0) {
            setContentView(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        h lifecycle = getLifecycle();
        if (lifecycle instanceof m) {
            ((m) lifecycle).b(h.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f521b.b(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object a2 = a();
        aa aaVar = this.f522c;
        if (aaVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            aaVar = aVar.f527b;
        }
        if (aaVar == null && a2 == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f526a = a2;
        aVar2.f527b = aaVar;
        return aVar2;
    }

    @Override // androidx.core.app.f, androidx.lifecycle.l
    public h getLifecycle() {
        return this.f520a;
    }

    @Override // androidx.lifecycle.ab
    public aa getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f522c == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.f522c = aVar.f527b;
            }
            if (this.f522c == null) {
                this.f522c = new aa();
            }
        }
        return this.f522c;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f523d.a();
    }

    @Override // androidx.activity.d
    public final OnBackPressedDispatcher b() {
        return this.f523d;
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f521b.a();
    }
}
