package a.a.a.d;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExtendedResolver.java */
/* loaded from: classes.dex */
public class z implements ca {

    /* renamed from: a  reason: collision with root package name */
    private List<ca> f349a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f350b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f351c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f352d = 3;

    static /* synthetic */ int a(z zVar, int i) {
        int i2 = zVar.f351c % i;
        zVar.f351c = i2;
        return i2;
    }

    static /* synthetic */ int c(z zVar) {
        int i = zVar.f351c;
        zVar.f351c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExtendedResolver.java */
    /* loaded from: classes.dex */
    public static class a implements cc {

        /* renamed from: a  reason: collision with root package name */
        ca[] f353a;

        /* renamed from: b  reason: collision with root package name */
        int[] f354b;

        /* renamed from: c  reason: collision with root package name */
        Object[] f355c;

        /* renamed from: d  reason: collision with root package name */
        int f356d;

        /* renamed from: e  reason: collision with root package name */
        int f357e;
        boolean f;
        ax g;
        ax h;
        Throwable i;
        cc j;

        public a(z zVar, ax axVar) {
            this.f353a = (ca[]) zVar.f349a.toArray(new ca[0]);
            if (zVar.f350b) {
                int length = this.f353a.length;
                int c2 = z.c(zVar) % length;
                if (zVar.f351c > length) {
                    z.a(zVar, length);
                }
                if (c2 > 0) {
                    ca[] caVarArr = new ca[length];
                    for (int i = 0; i < length; i++) {
                        caVarArr[i] = this.f353a[(i + c2) % length];
                    }
                    this.f353a = caVarArr;
                }
            }
            ca[] caVarArr2 = this.f353a;
            this.f354b = new int[caVarArr2.length];
            this.f355c = new Object[caVarArr2.length];
            this.f356d = zVar.f352d;
            this.g = axVar;
        }

        public void a(int i) {
            int[] iArr = this.f354b;
            iArr[i] = iArr[i] + 1;
            this.f357e++;
            try {
                this.f355c[i] = this.f353a[i].b(this.g, this);
            } finally {
            }
        }

        public ax a() {
            try {
                int[] iArr = this.f354b;
                iArr[0] = iArr[0] + 1;
                this.f357e++;
                this.f355c[0] = new Object();
                return this.f353a[0].a(this.g);
            } catch (Exception e2) {
                a(this.f355c[0], e2);
                synchronized (this) {
                    while (!this.f) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                    ax axVar = this.h;
                    if (axVar != null) {
                        return axVar;
                    }
                    Throwable th = this.i;
                    if (th instanceof IOException) {
                        throw ((IOException) th);
                    }
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (th instanceof Error) {
                        throw ((Error) th);
                    }
                    throw new IllegalStateException("ExtendedResolver failure");
                }
            }
        }

        public void a(cc ccVar) {
            this.j = ccVar;
            a(0);
        }

        @Override // a.a.a.d.cc
        public void a(Object obj, ax axVar) {
            if (bo.b("verbose")) {
                System.err.println("ExtendedResolver: received message");
            }
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.h = axVar;
                this.f = true;
                if (this.j == null) {
                    notifyAll();
                } else {
                    this.j.a(this, axVar);
                }
            }
        }

        @Override // a.a.a.d.cc
        public void a(Object obj, Exception exc) {
            if (bo.b("verbose")) {
                System.err.println("ExtendedResolver: got " + exc);
            }
            synchronized (this) {
                this.f357e--;
                if (this.f) {
                    return;
                }
                boolean z = false;
                int i = 0;
                while (i < this.f355c.length && this.f355c[i] != obj) {
                    i++;
                }
                if (i == this.f355c.length) {
                    return;
                }
                if (this.f354b[i] == 1 && i < this.f353a.length - 1) {
                    z = true;
                }
                if (exc instanceof InterruptedIOException) {
                    if (this.f354b[i] < this.f356d) {
                        a(i);
                    }
                    if (this.i == null) {
                        this.i = exc;
                    }
                } else if (exc instanceof SocketException) {
                    if (this.i == null || (this.i instanceof InterruptedIOException)) {
                        this.i = exc;
                    }
                } else {
                    this.i = exc;
                }
                if (this.f) {
                    return;
                }
                if (z) {
                    a(i + 1);
                }
                if (this.f) {
                    return;
                }
                if (this.f357e == 0) {
                    this.f = true;
                    if (this.j == null) {
                        notifyAll();
                        return;
                    }
                }
                if (this.f) {
                    if (!(this.i instanceof Exception)) {
                        this.i = new RuntimeException(this.i.getMessage());
                    }
                    this.j.a(this, (Exception) this.i);
                }
            }
        }
    }

    private void a() {
        this.f349a = new ArrayList();
    }

    public z() {
        a();
        String[] f = cb.j().f();
        if (f != null) {
            for (String str : f) {
                cn cnVar = new cn(str);
                cnVar.a(5);
                this.f349a.add(cnVar);
            }
            return;
        }
        this.f349a.add(new cn());
    }

    @Override // a.a.a.d.ca
    public void a(int i, int i2) {
        for (ca caVar : this.f349a) {
            caVar.a(i, i2);
        }
    }

    @Override // a.a.a.d.ca
    public void a(int i) {
        a(i, 0);
    }

    @Override // a.a.a.d.ca
    public ax a(ax axVar) {
        return new a(this, axVar).a();
    }

    @Override // a.a.a.d.ca
    /* renamed from: a */
    public a b(ax axVar, cc ccVar) {
        a aVar = new a(this, axVar);
        aVar.a(ccVar);
        return aVar;
    }
}
