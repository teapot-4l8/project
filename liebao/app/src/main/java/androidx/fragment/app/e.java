package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class e extends androidx.activity.b implements a.InterfaceC0030a, a.c {

    /* renamed from: c  reason: collision with root package name */
    boolean f1853c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1854d;
    boolean f;
    boolean g;
    boolean h;
    int i;
    androidx.b.h<String> j;

    /* renamed from: a  reason: collision with root package name */
    final g f1851a = g.a(new a());

    /* renamed from: b  reason: collision with root package name */
    final androidx.lifecycle.m f1852b = new androidx.lifecycle.m(this);

    /* renamed from: e  reason: collision with root package name */
    boolean f1855e = true;

    public void a(d dVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f1851a.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String a2 = this.j.a(i4);
            this.j.b(i4);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            d a3 = this.f1851a.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.onActivityResult(i & 65535, i2, intent);
            return;
        }
        a.b a4 = androidx.core.app.a.a();
        if (a4 == null || !a4.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f1851a.a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f1851a.b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1851a.b();
        this.f1851a.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f1851a.a((d) null);
        if (bundle != null) {
            this.f1851a.a(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.j = new androidx.b.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.j.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.j == null) {
            this.j = new androidx.b.h<>();
            this.i = 0;
        }
        super.onCreate(bundle);
        this.f1852b.a(h.a.ON_CREATE);
        this.f1851a.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.f1851a.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1851a.a(view, str, context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1851a.j();
        this.f1852b.a(h.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1851a.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.f1851a.b(menuItem);
        }
        return this.f1851a.a(menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f1851a.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f1854d = false;
        this.f1851a.h();
        this.f1852b.a(h.a.ON_PAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1851a.b();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1851a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1854d = true;
        this.f1851a.b();
        this.f1851a.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        i();
    }

    protected void i() {
        this.f1852b.a(h.a.ON_RESUME);
        this.f1851a.g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return a(view, menu) | this.f1851a.a(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Deprecated
    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        c();
        this.f1852b.a(h.a.ON_STOP);
        Parcelable c2 = this.f1851a.c();
        if (c2 != null) {
            bundle.putParcelable("android:support:fragments", c2);
        }
        if (this.j.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.j.b()];
            String[] strArr = new String[this.j.b()];
            for (int i = 0; i < this.j.b(); i++) {
                iArr[i] = this.j.c(i);
                strArr[i] = this.j.d(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.f1855e = false;
        if (!this.f1853c) {
            this.f1853c = true;
            this.f1851a.e();
        }
        this.f1851a.b();
        this.f1851a.l();
        this.f1852b.a(h.a.ON_START);
        this.f1851a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f1855e = true;
        c();
        this.f1851a.i();
        this.f1852b.a(h.a.ON_STOP);
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1853c);
        printWriter.print(" mResumed=");
        printWriter.print(this.f1854d);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1855e);
        if (getApplication() != null) {
            androidx.loader.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1851a.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public j j() {
        return this.f1851a.a();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.h && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.h && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.g && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.g && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    static void c(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    @Override // androidx.core.app.a.c
    public final void b(int i) {
        if (this.f || i == -1) {
            return;
        }
        c(i);
    }

    @Override // android.app.Activity, androidx.core.app.a.InterfaceC0030a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f1851a.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a2 = this.j.a(i3);
            this.j.b(i3);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            d a3 = this.f1851a.a(a2);
            if (a3 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
                return;
            }
            a3.onRequestPermissionsResult(i & 65535, strArr, iArr);
        }
    }

    public void a(d dVar, Intent intent, int i, Bundle bundle) {
        this.h = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intent, -1, bundle);
                return;
            }
            c(i);
            androidx.core.app.a.a(this, intent, ((b(dVar) + 1) << 16) + (i & 65535), bundle);
        } finally {
            this.h = false;
        }
    }

    public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.g = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intentSender, i, intent, i2, i3, i4, bundle);
                return;
            }
            c(i);
            androidx.core.app.a.a(this, intentSender, ((b(dVar) + 1) << 16) + (i & 65535), intent, i2, i3, i4, bundle);
        } finally {
            this.g = false;
        }
    }

    private int b(d dVar) {
        if (this.j.b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.j.e(this.i) >= 0) {
            this.i = (this.i + 1) % 65534;
        }
        int i = this.i;
        this.j.b(i, dVar.mWho);
        this.i = (this.i + 1) % 65534;
        return i;
    }

    void a(d dVar, String[] strArr, int i) {
        if (i == -1) {
            androidx.core.app.a.a(this, strArr, i);
            return;
        }
        c(i);
        try {
            this.f = true;
            androidx.core.app.a.a(this, strArr, ((b(dVar) + 1) << 16) + (i & 65535));
        } finally {
            this.f = false;
        }
    }

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    class a extends i<e> implements androidx.activity.d, ab {
        public a() {
            super(e.this);
        }

        @Override // androidx.lifecycle.l
        public androidx.lifecycle.h getLifecycle() {
            return e.this.f1852b;
        }

        @Override // androidx.lifecycle.ab
        public aa getViewModelStore() {
            return e.this.getViewModelStore();
        }

        @Override // androidx.activity.d
        public OnBackPressedDispatcher b() {
            return e.this.b();
        }

        @Override // androidx.fragment.app.i
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.i
        public boolean a(d dVar) {
            return !e.this.isFinishing();
        }

        @Override // androidx.fragment.app.i
        public LayoutInflater c() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        @Override // androidx.fragment.app.i
        /* renamed from: d */
        public e h() {
            return e.this;
        }

        @Override // androidx.fragment.app.i
        public void e() {
            e.this.d();
        }

        @Override // androidx.fragment.app.i
        public void a(d dVar, Intent intent, int i, Bundle bundle) {
            e.this.a(dVar, intent, i, bundle);
        }

        @Override // androidx.fragment.app.i
        public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            e.this.a(dVar, intentSender, i, intent, i2, i3, i4, bundle);
        }

        @Override // androidx.fragment.app.i
        public void a(d dVar, String[] strArr, int i) {
            e.this.a(dVar, strArr, i);
        }

        @Override // androidx.fragment.app.i
        public boolean a(String str) {
            return androidx.core.app.a.a((Activity) e.this, str);
        }

        @Override // androidx.fragment.app.i
        public boolean f() {
            return e.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.i
        public int g() {
            Window window = e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.i
        public void b(d dVar) {
            e.this.a(dVar);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        public View a(int i) {
            return e.this.findViewById(i);
        }

        @Override // androidx.fragment.app.i, androidx.fragment.app.f
        public boolean a() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    private void c() {
        do {
        } while (a(j(), h.b.CREATED));
    }

    private static boolean a(j jVar, h.b bVar) {
        boolean z = false;
        for (d dVar : jVar.d()) {
            if (dVar != null) {
                if (dVar.getLifecycle().a().a(h.b.STARTED)) {
                    dVar.mLifecycleRegistry.b(bVar);
                    z = true;
                }
                if (dVar.getHost() != null) {
                    z |= a(dVar.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }
}
