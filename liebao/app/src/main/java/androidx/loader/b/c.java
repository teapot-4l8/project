package androidx.loader.b;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class c<D> {
    int n;
    InterfaceC0050c<D> o;
    b<D> p;

    /* renamed from: q  reason: collision with root package name */
    Context f2070q;
    boolean r = false;
    boolean s = false;
    boolean t = true;
    boolean u = false;
    boolean v = false;

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface b<D> {
        void a(c<D> cVar);
    }

    /* compiled from: Loader.java */
    /* renamed from: androidx.loader.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050c<D> {
        void a(c<D> cVar, D d2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    protected boolean b() {
        return false;
    }

    protected void i() {
    }

    protected void j() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    protected void v() {
    }

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public final class a extends ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            c.this.A();
        }
    }

    public c(Context context) {
        this.f2070q = context.getApplicationContext();
    }

    public void b(D d2) {
        InterfaceC0050c<D> interfaceC0050c = this.o;
        if (interfaceC0050c != null) {
            interfaceC0050c.a(this, d2);
        }
    }

    public void l() {
        b<D> bVar = this.p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public Context m() {
        return this.f2070q;
    }

    public void a(InterfaceC0050c<D> interfaceC0050c) {
        InterfaceC0050c<D> interfaceC0050c2 = this.o;
        if (interfaceC0050c2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0050c2 != interfaceC0050c) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.o = null;
    }

    public boolean n() {
        return this.r;
    }

    public boolean o() {
        return this.s;
    }

    public boolean p() {
        return this.t;
    }

    public final void q() {
        this.r = true;
        this.t = false;
        this.s = false;
        i();
    }

    public boolean r() {
        return b();
    }

    public void s() {
        a();
    }

    public void t() {
        this.r = false;
        j();
    }

    public void u() {
        this.s = true;
        v();
    }

    public void w() {
        k();
        this.t = true;
        this.r = false;
        this.s = false;
        this.u = false;
        this.v = false;
    }

    public boolean x() {
        boolean z = this.u;
        this.u = false;
        this.v |= z;
        return z;
    }

    public void y() {
        this.v = false;
    }

    public void z() {
        if (this.v) {
            A();
        }
    }

    public void A() {
        if (this.r) {
            s();
        } else {
            this.u = true;
        }
    }

    public String c(D d2) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.g.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.n);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.n);
        printWriter.print(" mListener=");
        printWriter.println(this.o);
        if (this.r || this.u || this.v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.v);
        }
        if (this.s || this.t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.s);
            printWriter.print(" mReset=");
            printWriter.println(this.t);
        }
    }
}
