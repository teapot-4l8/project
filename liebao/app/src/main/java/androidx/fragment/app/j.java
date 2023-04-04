package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    static final h f1864a = new h();

    /* renamed from: b  reason: collision with root package name */
    private h f1865b = null;

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public void onFragmentActivityCreated(j jVar, d dVar, Bundle bundle) {
        }

        public void onFragmentAttached(j jVar, d dVar, Context context) {
        }

        public void onFragmentCreated(j jVar, d dVar, Bundle bundle) {
        }

        public void onFragmentDestroyed(j jVar, d dVar) {
        }

        public void onFragmentDetached(j jVar, d dVar) {
        }

        public void onFragmentPaused(j jVar, d dVar) {
        }

        public void onFragmentPreAttached(j jVar, d dVar, Context context) {
        }

        public void onFragmentPreCreated(j jVar, d dVar, Bundle bundle) {
        }

        public void onFragmentResumed(j jVar, d dVar) {
        }

        public void onFragmentSaveInstanceState(j jVar, d dVar, Bundle bundle) {
        }

        public void onFragmentStarted(j jVar, d dVar) {
        }

        public void onFragmentStopped(j jVar, d dVar) {
        }

        public void onFragmentViewCreated(j jVar, d dVar, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(j jVar, d dVar) {
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public abstract d.C0045d a(d dVar);

    public abstract d a(Bundle bundle, String str);

    public abstract d a(String str);

    public abstract p a();

    public abstract void a(int i, int i2);

    public abstract void a(Bundle bundle, String str, d dVar);

    public abstract void a(a aVar);

    public abstract void a(a aVar, boolean z);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public abstract boolean c();

    public abstract List<d> d();

    public abstract boolean e();

    public abstract boolean g();

    public void a(h hVar) {
        this.f1865b = hVar;
    }

    public h f() {
        if (this.f1865b == null) {
            this.f1865b = f1864a;
        }
        return this.f1865b;
    }
}
