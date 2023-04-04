package com.bumptech.glide.c.b;

import android.os.Build;
import android.util.Log;
import androidx.core.g.e;
import com.bumptech.glide.c.b.e;
import com.bumptech.glide.c.b.h;
import com.bumptech.glide.h;
import com.bumptech.glide.i.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
class g<R> implements e.a, a.c, Comparable<g<?>>, Runnable {
    private com.bumptech.glide.c.a A;
    private com.bumptech.glide.c.a.d<?> B;
    private volatile com.bumptech.glide.c.b.e C;
    private volatile boolean D;
    private volatile boolean E;

    /* renamed from: d  reason: collision with root package name */
    private final d f4781d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a<g<?>> f4782e;
    private com.bumptech.glide.e h;
    private com.bumptech.glide.c.h i;
    private com.bumptech.glide.g j;
    private m k;
    private int l;
    private int m;
    private i n;
    private com.bumptech.glide.c.j o;
    private a<R> p;

    /* renamed from: q  reason: collision with root package name */
    private int f4783q;
    private EnumC0088g r;
    private f s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private com.bumptech.glide.c.h x;
    private com.bumptech.glide.c.h y;
    private Object z;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.f<R> f4778a = new com.bumptech.glide.c.b.f<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f4779b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.i.a.c f4780c = com.bumptech.glide.i.a.c.a();
    private final c<?> f = new c<>();
    private final e g = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface a<R> {
        void a(g<?> gVar);

        void a(p pVar);

        void a(u<R> uVar, com.bumptech.glide.c.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public interface d {
        com.bumptech.glide.c.b.b.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.c.b.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0088g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, e.a<g<?>> aVar) {
        this.f4781d = dVar;
        this.f4782e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g<R> a(com.bumptech.glide.e eVar, Object obj, m mVar, com.bumptech.glide.c.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.g gVar, i iVar, Map<Class<?>, com.bumptech.glide.c.m<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.c.j jVar, a<R> aVar, int i3) {
        this.f4778a.a(eVar, obj, hVar, i, i2, iVar, cls, cls2, gVar, jVar, map, z, z2, this.f4781d);
        this.h = eVar;
        this.i = hVar;
        this.j = gVar;
        this.k = mVar;
        this.l = i;
        this.m = i2;
        this.n = iVar;
        this.u = z3;
        this.o = jVar;
        this.p = aVar;
        this.f4783q = i3;
        this.s = f.INITIALIZE;
        this.v = obj;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        EnumC0088g a2 = a(EnumC0088g.INITIALIZE);
        return a2 == EnumC0088g.RESOURCE_CACHE || a2 == EnumC0088g.DATA_CACHE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (this.g.a(z)) {
            g();
        }
    }

    private void e() {
        if (this.g.a()) {
            g();
        }
    }

    private void f() {
        if (this.g.b()) {
            g();
        }
    }

    private void g() {
        this.g.c();
        this.f.b();
        this.f4778a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.f4779b.clear();
        this.f4782e.a(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g<?> gVar) {
        int h = h() - gVar.h();
        return h == 0 ? this.f4783q - gVar.f4783q : h;
    }

    private int h() {
        return this.j.ordinal();
    }

    public void b() {
        this.E = true;
        com.bumptech.glide.c.b.e eVar = this.C;
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r1 != null) goto L13;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        com.bumptech.glide.i.a.b.a("DecodeJob#run(model=%s)", this.v);
        com.bumptech.glide.c.a.d<?> dVar = this.B;
        try {
            if (this.E) {
                l();
                return;
            }
            i();
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("DecodeJob", 3)) {
                    Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.r, th);
                }
                if (this.r != EnumC0088g.ENCODE) {
                    this.f4779b.add(th);
                    l();
                }
                if (!this.E) {
                    throw th;
                }
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.i.a.b.a();
            } finally {
                if (dVar != null) {
                    dVar.b();
                }
                com.bumptech.glide.i.a.b.a();
            }
        }
    }

    private void i() {
        int i = AnonymousClass1.f4784a[this.s.ordinal()];
        if (i == 1) {
            this.r = a(EnumC0088g.INITIALIZE);
            this.C = j();
            k();
        } else if (i == 2) {
            k();
        } else if (i == 3) {
            n();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private com.bumptech.glide.c.b.e j() {
        int i = AnonymousClass1.f4785b[this.r.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.r);
                }
                return new y(this.f4778a, this);
            }
            return new com.bumptech.glide.c.b.b(this.f4778a, this);
        }
        return new v(this.f4778a, this);
    }

    private void k() {
        this.w = Thread.currentThread();
        this.t = com.bumptech.glide.i.e.a();
        boolean z = false;
        while (!this.E && this.C != null && !(z = this.C.a())) {
            this.r = a(this.r);
            this.C = j();
            if (this.r == EnumC0088g.SOURCE) {
                c();
                return;
            }
        }
        if ((this.r == EnumC0088g.FINISHED || this.E) && !z) {
            l();
        }
    }

    private void l() {
        m();
        this.p.a(new p("Failed to load resource", new ArrayList(this.f4779b)));
        f();
    }

    private void a(u<R> uVar, com.bumptech.glide.c.a aVar) {
        m();
        this.p.a(uVar, aVar);
    }

    private void m() {
        this.f4780c.b();
        if (this.D) {
            throw new IllegalStateException("Already notified");
        }
        this.D = true;
    }

    private EnumC0088g a(EnumC0088g enumC0088g) {
        int i = AnonymousClass1.f4785b[enumC0088g.ordinal()];
        if (i == 1) {
            return this.n.b() ? EnumC0088g.DATA_CACHE : a(EnumC0088g.DATA_CACHE);
        } else if (i == 2) {
            return this.u ? EnumC0088g.FINISHED : EnumC0088g.SOURCE;
        } else if (i == 3 || i == 4) {
            return EnumC0088g.FINISHED;
        } else {
            if (i == 5) {
                return this.n.a() ? EnumC0088g.RESOURCE_CACHE : a(EnumC0088g.RESOURCE_CACHE);
            }
            throw new IllegalArgumentException("Unrecognized stage: " + enumC0088g);
        }
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void c() {
        this.s = f.SWITCH_TO_SOURCE_SERVICE;
        this.p.a((g<?>) this);
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void a(com.bumptech.glide.c.h hVar, Object obj, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.h hVar2) {
        this.x = hVar;
        this.z = obj;
        this.B = dVar;
        this.A = aVar;
        this.y = hVar2;
        if (Thread.currentThread() != this.w) {
            this.s = f.DECODE_DATA;
            this.p.a((g<?>) this);
            return;
        }
        com.bumptech.glide.i.a.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            n();
        } finally {
            com.bumptech.glide.i.a.b.a();
        }
    }

    @Override // com.bumptech.glide.c.b.e.a
    public void a(com.bumptech.glide.c.h hVar, Exception exc, com.bumptech.glide.c.a.d<?> dVar, com.bumptech.glide.c.a aVar) {
        dVar.b();
        p pVar = new p("Fetching data failed", exc);
        pVar.a(hVar, aVar, dVar.a());
        this.f4779b.add(pVar);
        if (Thread.currentThread() != this.w) {
            this.s = f.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((g<?>) this);
            return;
        }
        k();
    }

    private void n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.t;
            a("Retrieved data", j, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        u<R> uVar = null;
        try {
            uVar = a(this.B, (com.bumptech.glide.c.a.d<?>) this.z, this.A);
        } catch (p e2) {
            e2.a(this.y, this.A);
            this.f4779b.add(e2);
        }
        if (uVar != null) {
            b(uVar, this.A);
        } else {
            k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(u<R> uVar, com.bumptech.glide.c.a aVar) {
        if (uVar instanceof q) {
            ((q) uVar).a();
        }
        t tVar = 0;
        if (this.f.a()) {
            uVar = t.a(uVar);
            tVar = uVar;
        }
        a((u) uVar, aVar);
        this.r = EnumC0088g.ENCODE;
        try {
            if (this.f.a()) {
                this.f.a(this.f4781d, this.o);
            }
            e();
        } finally {
            if (tVar != 0) {
                tVar.a();
            }
        }
    }

    private <Data> u<R> a(com.bumptech.glide.c.a.d<?> dVar, Data data, com.bumptech.glide.c.a aVar) {
        if (data != null) {
            try {
                long a2 = com.bumptech.glide.i.e.a();
                u<R> a3 = a((g<R>) data, aVar);
                if (Log.isLoggable("DecodeJob", 2)) {
                    a("Decoded result " + a3, a2);
                }
                return a3;
            } finally {
                dVar.b();
            }
        }
        return null;
    }

    private <Data> u<R> a(Data data, com.bumptech.glide.c.a aVar) {
        return a((g<R>) data, aVar, (s<g<R>, ResourceType, R>) ((s<Data, ?, R>) this.f4778a.b(data.getClass())));
    }

    private com.bumptech.glide.c.j a(com.bumptech.glide.c.a aVar) {
        com.bumptech.glide.c.j jVar = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return jVar;
        }
        boolean z = aVar == com.bumptech.glide.c.a.RESOURCE_DISK_CACHE || this.f4778a.l();
        Boolean bool = (Boolean) jVar.a(com.bumptech.glide.c.d.a.k.f5012d);
        if (bool == null || (bool.booleanValue() && !z)) {
            com.bumptech.glide.c.j jVar2 = new com.bumptech.glide.c.j();
            jVar2.a(this.o);
            jVar2.a(com.bumptech.glide.c.d.a.k.f5012d, Boolean.valueOf(z));
            return jVar2;
        }
        return jVar;
    }

    private <Data, ResourceType> u<R> a(Data data, com.bumptech.glide.c.a aVar, s<Data, ResourceType, R> sVar) {
        com.bumptech.glide.c.j a2 = a(aVar);
        com.bumptech.glide.c.a.e<Data> b2 = this.h.c().b((com.bumptech.glide.h) data);
        try {
            return sVar.a(b2, a2, this.l, this.m, new b(aVar));
        } finally {
            b2.b();
        }
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.i.e.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    @Override // com.bumptech.glide.i.a.a.c
    public com.bumptech.glide.i.a.c d_() {
        return this.f4780c;
    }

    <Z> u<Z> a(com.bumptech.glide.c.a aVar, u<Z> uVar) {
        u<Z> uVar2;
        com.bumptech.glide.c.m<Z> mVar;
        com.bumptech.glide.c.c cVar;
        com.bumptech.glide.c.h cVar2;
        Class<?> cls = uVar.d().getClass();
        com.bumptech.glide.c.l<Z> lVar = null;
        if (aVar != com.bumptech.glide.c.a.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.c.m<Z> c2 = this.f4778a.c(cls);
            mVar = c2;
            uVar2 = c2.a(this.h, uVar, this.l, this.m);
        } else {
            uVar2 = uVar;
            mVar = null;
        }
        if (!uVar.equals(uVar2)) {
            uVar.f();
        }
        if (this.f4778a.a((u<?>) uVar2)) {
            lVar = this.f4778a.b(uVar2);
            cVar = lVar.a(this.o);
        } else {
            cVar = com.bumptech.glide.c.c.NONE;
        }
        com.bumptech.glide.c.l lVar2 = lVar;
        if (this.n.a(!this.f4778a.a(this.x), aVar, cVar)) {
            if (lVar2 == null) {
                throw new h.d(uVar2.d().getClass());
            }
            int i = AnonymousClass1.f4786c[cVar.ordinal()];
            if (i == 1) {
                cVar2 = new com.bumptech.glide.c.b.c(this.x, this.i);
            } else if (i == 2) {
                cVar2 = new w(this.f4778a.i(), this.x, this.i, this.l, this.m, mVar, cls, this.o);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + cVar);
            }
            t a2 = t.a(uVar2);
            this.f.a(cVar2, lVar2, a2);
            return a2;
        }
        return uVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodeJob.java */
    /* renamed from: com.bumptech.glide.c.b.g$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4784a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4785b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f4786c;

        static {
            int[] iArr = new int[com.bumptech.glide.c.c.values().length];
            f4786c = iArr;
            try {
                iArr[com.bumptech.glide.c.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4786c[com.bumptech.glide.c.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0088g.values().length];
            f4785b = iArr2;
            try {
                iArr2[EnumC0088g.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4785b[EnumC0088g.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4785b[EnumC0088g.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4785b[EnumC0088g.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4785b[EnumC0088g.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[f.values().length];
            f4784a = iArr3;
            try {
                iArr3[f.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4784a[f.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4784a[f.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public final class b<Z> implements h.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.c.a f4788b;

        b(com.bumptech.glide.c.a aVar) {
            this.f4788b = aVar;
        }

        @Override // com.bumptech.glide.c.b.h.a
        public u<Z> a(u<Z> uVar) {
            return g.this.a(this.f4788b, uVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4792a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4793b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4794c;

        e() {
        }

        synchronized boolean a(boolean z) {
            this.f4792a = true;
            return b(z);
        }

        synchronized boolean a() {
            this.f4793b = true;
            return b(false);
        }

        synchronized boolean b() {
            this.f4794c = true;
            return b(false);
        }

        synchronized void c() {
            this.f4793b = false;
            this.f4792a = false;
            this.f4794c = false;
        }

        private boolean b(boolean z) {
            return (this.f4794c || z || this.f4793b) && this.f4792a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodeJob.java */
    /* loaded from: classes.dex */
    public static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        private com.bumptech.glide.c.h f4789a;

        /* renamed from: b  reason: collision with root package name */
        private com.bumptech.glide.c.l<Z> f4790b;

        /* renamed from: c  reason: collision with root package name */
        private t<Z> f4791c;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(com.bumptech.glide.c.h hVar, com.bumptech.glide.c.l<X> lVar, t<X> tVar) {
            this.f4789a = hVar;
            this.f4790b = lVar;
            this.f4791c = tVar;
        }

        void a(d dVar, com.bumptech.glide.c.j jVar) {
            com.bumptech.glide.i.a.b.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f4789a, new com.bumptech.glide.c.b.d(this.f4790b, this.f4791c, jVar));
            } finally {
                this.f4791c.a();
                com.bumptech.glide.i.a.b.a();
            }
        }

        boolean a() {
            return this.f4791c != null;
        }

        void b() {
            this.f4789a = null;
            this.f4790b = null;
            this.f4791c = null;
        }
    }
}
