package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class i<E> extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f1859a;

    /* renamed from: b  reason: collision with root package name */
    final k f1860b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1861c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f1862d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1863e;

    @Override // androidx.fragment.app.f
    public View a(int i) {
        return null;
    }

    public void a(d dVar, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // androidx.fragment.app.f
    public boolean a() {
        return true;
    }

    public boolean a(d dVar) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
    }

    public void e() {
    }

    public boolean f() {
        return true;
    }

    public abstract E h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }

    i(Activity activity, Context context, Handler handler, int i) {
        this.f1860b = new k();
        this.f1859a = activity;
        this.f1861c = (Context) androidx.core.g.f.a(context, "context == null");
        this.f1862d = (Handler) androidx.core.g.f.a(handler, "handler == null");
        this.f1863e = i;
    }

    public LayoutInflater c() {
        return LayoutInflater.from(this.f1861c);
    }

    public void a(d dVar, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f1861c.startActivity(intent);
    }

    public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.a.a(this.f1859a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public int g() {
        return this.f1863e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity i() {
        return this.f1859a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context j() {
        return this.f1861c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler k() {
        return this.f1862d;
    }
}
