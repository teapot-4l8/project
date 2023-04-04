package a.a.a.e;

import a.a.a.c.i.a;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: PortScan.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    private InetAddress f385c;
    private a h;

    /* renamed from: a  reason: collision with root package name */
    private int f383a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f384b = 50;

    /* renamed from: d  reason: collision with root package name */
    private int f386d = 1000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f387e = false;
    private ArrayList<Integer> f = new ArrayList<>();
    private ArrayList<Integer> g = new ArrayList<>();

    /* compiled from: PortScan.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.C0002a c0002a);

        void a(ArrayList<Integer> arrayList);
    }

    private n() {
    }

    public static n a(String str) {
        return a(InetAddress.getByName(str));
    }

    public static n a(InetAddress inetAddress) {
        n nVar = new n();
        nVar.b(inetAddress);
        nVar.c();
        return nVar;
    }

    public n a() {
        this.f.clear();
        for (int i = 1; i < 1024; i++) {
            this.f.add(Integer.valueOf(i));
        }
        return this;
    }

    private void b(InetAddress inetAddress) {
        this.f385c = inetAddress;
    }

    private void c() {
        if (g.a(this.f385c)) {
            this.f386d = 25;
            this.f384b = 7;
        } else if (g.b(this.f385c)) {
            this.f386d = 1000;
            this.f384b = 50;
        } else {
            this.f386d = 2500;
            this.f384b = 50;
        }
    }

    private n a(int i) {
        if (i == 0 || i == 1) {
            this.f383a = i;
            return this;
        }
        throw new IllegalArgumentException("Invalid method type " + i);
    }

    public n b() {
        a(0);
        return this;
    }

    public n a(a aVar) {
        this.h = aVar;
        this.g.clear();
        this.f387e = false;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.f384b);
        Iterator<Integer> it = this.f.iterator();
        while (it.hasNext()) {
            newFixedThreadPool.execute(new b(this.f385c, it.next().intValue(), this.f386d, this.f383a));
        }
        newFixedThreadPool.shutdown();
        try {
            newFixedThreadPool.awaitTermination(30L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        if (aVar != null) {
            Collections.sort(this.g);
            aVar.a(this.g);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(a.C0002a c0002a) {
        if (c0002a.c()) {
            this.g.add(Integer.valueOf(c0002a.d()));
        }
        if (this.h != null) {
            this.h.a(c0002a);
        }
    }

    /* compiled from: PortScan.java */
    /* loaded from: classes.dex */
    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final InetAddress f389b;

        /* renamed from: c  reason: collision with root package name */
        private final int f390c;

        /* renamed from: d  reason: collision with root package name */
        private final int f391d;

        /* renamed from: e  reason: collision with root package name */
        private final int f392e;

        b(InetAddress inetAddress, int i, int i2, int i3) {
            this.f389b = inetAddress;
            this.f390c = i;
            this.f391d = i2;
            this.f392e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f387e) {
                return;
            }
            int i = this.f392e;
            if (i == 0) {
                n.this.a(o.a(this.f389b, this.f390c, this.f391d));
            } else if (i == 1) {
                n.this.a(p.a(this.f389b, this.f390c, this.f391d));
            } else {
                throw new IllegalArgumentException("Invalid method");
            }
        }
    }
}
