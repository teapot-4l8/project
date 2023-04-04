package androidx.loader.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.b.h;
import androidx.lifecycle.aa;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.loader.a.a;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoaderManagerImpl.java */
/* loaded from: classes.dex */
public class b extends androidx.loader.a.a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f2053a = false;

    /* renamed from: b  reason: collision with root package name */
    private final l f2054b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2055c;

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    public static class a<D> extends r<D> implements c.InterfaceC0050c<D> {

        /* renamed from: a  reason: collision with root package name */
        private final int f2056a;
        private final Bundle f;
        private final androidx.loader.b.c<D> g;
        private l h;
        private C0048b<D> i;
        private androidx.loader.b.c<D> j;

        androidx.loader.b.c<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        protected void a() {
            if (b.f2053a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.q();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.f2053a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.t();
        }

        void f() {
            l lVar = this.h;
            C0048b<D> c0048b = this.i;
            if (lVar == null || c0048b == null) {
                return;
            }
            super.a((s) c0048b);
            a(lVar, c0048b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(s<? super D> sVar) {
            super.a((s) sVar);
            this.h = null;
            this.i = null;
        }

        androidx.loader.b.c<D> a(boolean z) {
            if (b.f2053a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.r();
            this.g.u();
            C0048b<D> c0048b = this.i;
            if (c0048b != null) {
                a((s) c0048b);
                if (z) {
                    c0048b.b();
                }
            }
            this.g.a(this);
            if ((c0048b != null && !c0048b.a()) || z) {
                this.g.w();
                return this.j;
            }
            return this.g;
        }

        @Override // androidx.loader.b.c.InterfaceC0050c
        public void a(androidx.loader.b.c<D> cVar, D d2) {
            if (b.f2053a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b((a<D>) d2);
                return;
            }
            if (b.f2053a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a((a<D>) d2);
        }

        @Override // androidx.lifecycle.r, androidx.lifecycle.LiveData
        public void b(D d2) {
            super.b((a<D>) d2);
            androidx.loader.b.c<D> cVar = this.j;
            if (cVar != null) {
                cVar.w();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2056a);
            sb.append(" : ");
            androidx.core.g.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2056a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            androidx.loader.b.c<D> cVar = this.g;
            cVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                C0048b<D> c0048b = this.i;
                c0048b.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().c(b()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: androidx.loader.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0048b<D> implements s<D> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.loader.b.c<D> f2057a;

        /* renamed from: b  reason: collision with root package name */
        private final a.InterfaceC0047a<D> f2058b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2059c;

        @Override // androidx.lifecycle.s
        public void a(D d2) {
            if (b.f2053a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f2057a + ": " + this.f2057a.c(d2));
            }
            this.f2058b.a(this.f2057a, d2);
            this.f2059c = true;
        }

        boolean a() {
            return this.f2059c;
        }

        void b() {
            if (this.f2059c) {
                if (b.f2053a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f2057a);
                }
                this.f2058b.a(this.f2057a);
            }
        }

        public String toString() {
            return this.f2058b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2059c);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* loaded from: classes.dex */
    static class c extends x {

        /* renamed from: a  reason: collision with root package name */
        private static final y.b f2060a = new y.b() { // from class: androidx.loader.a.b.c.1
            @Override // androidx.lifecycle.y.b
            public <T extends x> T a(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private h<a> f2061b = new h<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f2062c = false;

        c() {
        }

        static c a(aa aaVar) {
            return (c) new y(aaVar, f2060a).a(c.class);
        }

        void b() {
            int b2 = this.f2061b.b();
            for (int i = 0; i < b2; i++) {
                this.f2061b.d(i).f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.x
        public void a() {
            super.a();
            int b2 = this.f2061b.b();
            for (int i = 0; i < b2; i++) {
                this.f2061b.d(i).a(true);
            }
            this.f2061b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2061b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f2061b.b(); i++) {
                    a d2 = this.f2061b.d(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2061b.c(i));
                    printWriter.print(": ");
                    printWriter.println(d2.toString());
                    d2.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(l lVar, aa aaVar) {
        this.f2054b = lVar;
        this.f2055c = c.a(aaVar);
    }

    @Override // androidx.loader.a.a
    public void a() {
        this.f2055c.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.g.a.a(this.f2054b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.loader.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2055c.a(str, fileDescriptor, printWriter, strArr);
    }
}
