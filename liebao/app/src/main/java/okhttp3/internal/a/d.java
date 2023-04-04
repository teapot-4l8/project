package okhttp3.internal.a;

import c.l;
import c.r;
import c.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class d implements Closeable, Flushable {

    /* renamed from: b  reason: collision with root package name */
    final okhttp3.internal.f.a f7413b;

    /* renamed from: c  reason: collision with root package name */
    final File f7414c;

    /* renamed from: d  reason: collision with root package name */
    final int f7415d;

    /* renamed from: e  reason: collision with root package name */
    c.d f7416e;
    int g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private final File n;
    private final File o;
    private final File p;

    /* renamed from: q  reason: collision with root package name */
    private final int f7417q;
    private long r;
    private final Executor u;
    static final /* synthetic */ boolean m = !d.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f7412a = Pattern.compile("[a-z0-9_-]{1,120}");
    private long s = 0;
    final LinkedHashMap<String, b> f = new LinkedHashMap<>(0, 0.75f, true);
    private long t = 0;
    private final Runnable v = new Runnable() { // from class: okhttp3.internal.a.d.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                if ((!d.this.i) || d.this.j) {
                    return;
                }
                try {
                    d.this.e();
                } catch (IOException unused) {
                    d.this.k = true;
                }
                try {
                    if (d.this.c()) {
                        d.this.b();
                        d.this.g = 0;
                    }
                } catch (IOException unused2) {
                    d.this.l = true;
                    d.this.f7416e = l.a(l.a());
                }
            }
        }
    };

    d(okhttp3.internal.f.a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f7413b = aVar;
        this.f7414c = file;
        this.f7417q = i;
        this.n = new File(file, "journal");
        this.o = new File(file, "journal.tmp");
        this.p = new File(file, "journal.bkp");
        this.f7415d = i2;
        this.r = j;
        this.u = executor;
    }

    public synchronized void a() {
        if (!m && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.i) {
            return;
        }
        if (this.f7413b.e(this.p)) {
            if (this.f7413b.e(this.n)) {
                this.f7413b.d(this.p);
            } else {
                this.f7413b.a(this.p, this.n);
            }
        }
        if (this.f7413b.e(this.n)) {
            try {
                g();
                i();
                this.i = true;
                return;
            } catch (IOException e2) {
                okhttp3.internal.g.f c2 = okhttp3.internal.g.f.c();
                c2.a(5, "DiskLruCache " + this.f7414c + " is corrupt: " + e2.getMessage() + ", removing", e2);
                f();
                this.j = false;
            }
        }
        b();
        this.i = true;
    }

    public static d a(okhttp3.internal.f.a aVar, File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            return new d(aVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void g() {
        c.e a2 = l.a(this.f7413b.a(this.n));
        try {
            String r = a2.r();
            String r2 = a2.r();
            String r3 = a2.r();
            String r4 = a2.r();
            String r5 = a2.r();
            if (!"libcore.io.DiskLruCache".equals(r) || !"1".equals(r2) || !Integer.toString(this.f7417q).equals(r3) || !Integer.toString(this.f7415d).equals(r4) || !"".equals(r5)) {
                throw new IOException("unexpected journal header: [" + r + ", " + r2 + ", " + r4 + ", " + r5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(a2.r());
                    i++;
                } catch (EOFException unused) {
                    this.g = i - this.f.size();
                    if (!a2.f()) {
                        b();
                    } else {
                        this.f7416e = h();
                    }
                    okhttp3.internal.c.a(a2);
                    return;
                }
            }
        } catch (Throwable th) {
            okhttp3.internal.c.a(a2);
            throw th;
        }
    }

    private c.d h() {
        return l.a(new e(this.f7413b.c(this.n)) { // from class: okhttp3.internal.a.d.2

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f7419a = !d.class.desiredAssertionStatus();

            @Override // okhttp3.internal.a.e
            protected void a(IOException iOException) {
                if (!f7419a && !Thread.holdsLock(d.this)) {
                    throw new AssertionError();
                }
                d.this.h = true;
            }
        });
    }

    private void d(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.f.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.f.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.f.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.f7430e = true;
            bVar.f = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.f = new a(bVar);
        } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void i() {
        this.f7413b.d(this.o);
        Iterator<b> it = this.f.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.f7415d) {
                    this.s += next.f7427b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.f7415d) {
                    this.f7413b.d(next.f7428c[i]);
                    this.f7413b.d(next.f7429d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void b() {
        if (this.f7416e != null) {
            this.f7416e.close();
        }
        c.d a2 = l.a(this.f7413b.b(this.o));
        a2.b("libcore.io.DiskLruCache").i(10);
        a2.b("1").i(10);
        a2.m(this.f7417q).i(10);
        a2.m(this.f7415d).i(10);
        a2.i(10);
        for (b bVar : this.f.values()) {
            if (bVar.f != null) {
                a2.b("DIRTY").i(32);
                a2.b(bVar.f7426a);
                a2.i(10);
            } else {
                a2.b("CLEAN").i(32);
                a2.b(bVar.f7426a);
                bVar.a(a2);
                a2.i(10);
            }
        }
        a2.close();
        if (this.f7413b.e(this.n)) {
            this.f7413b.a(this.n, this.p);
        }
        this.f7413b.a(this.o, this.n);
        this.f7413b.d(this.p);
        this.f7416e = h();
        this.h = false;
        this.l = false;
    }

    public synchronized c a(String str) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (bVar != null && bVar.f7430e) {
            c a2 = bVar.a();
            if (a2 == null) {
                return null;
            }
            this.g++;
            this.f7416e.b("READ").i(32).b(str).i(10);
            if (c()) {
                this.u.execute(this.v);
            }
            return a2;
        }
        return null;
    }

    @Nullable
    public a b(String str) {
        return a(str, -1L);
    }

    synchronized a a(String str, long j) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (j == -1 || (bVar != null && bVar.g == j)) {
            if (bVar == null || bVar.f == null) {
                if (!this.k && !this.l) {
                    this.f7416e.b("DIRTY").i(32).b(str).i(10);
                    this.f7416e.flush();
                    if (this.h) {
                        return null;
                    }
                    if (bVar == null) {
                        bVar = new b(str);
                        this.f.put(str, bVar);
                    }
                    a aVar = new a(bVar);
                    bVar.f = aVar;
                    return aVar;
                }
                this.u.execute(this.v);
                return null;
            }
            return null;
        }
        return null;
    }

    synchronized void a(a aVar, boolean z) {
        b bVar = aVar.f7421a;
        if (bVar.f != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.f7430e) {
            for (int i = 0; i < this.f7415d; i++) {
                if (!aVar.f7422b[i]) {
                    aVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!this.f7413b.e(bVar.f7429d[i])) {
                    aVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f7415d; i2++) {
            File file = bVar.f7429d[i2];
            if (z) {
                if (this.f7413b.e(file)) {
                    File file2 = bVar.f7428c[i2];
                    this.f7413b.a(file, file2);
                    long j = bVar.f7427b[i2];
                    long f = this.f7413b.f(file2);
                    bVar.f7427b[i2] = f;
                    this.s = (this.s - j) + f;
                }
            } else {
                this.f7413b.d(file);
            }
        }
        this.g++;
        bVar.f = null;
        if (bVar.f7430e | z) {
            bVar.f7430e = true;
            this.f7416e.b("CLEAN").i(32);
            this.f7416e.b(bVar.f7426a);
            bVar.a(this.f7416e);
            this.f7416e.i(10);
            if (z) {
                long j2 = this.t;
                this.t = 1 + j2;
                bVar.g = j2;
            }
        } else {
            this.f.remove(bVar.f7426a);
            this.f7416e.b("REMOVE").i(32);
            this.f7416e.b(bVar.f7426a);
            this.f7416e.i(10);
        }
        this.f7416e.flush();
        if (this.s > this.r || c()) {
            this.u.execute(this.v);
        }
    }

    boolean c() {
        int i = this.g;
        return i >= 2000 && i >= this.f.size();
    }

    public synchronized boolean c(String str) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (bVar == null) {
            return false;
        }
        boolean a2 = a(bVar);
        if (a2 && this.s <= this.r) {
            this.k = false;
        }
        return a2;
    }

    boolean a(b bVar) {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i = 0; i < this.f7415d; i++) {
            this.f7413b.d(bVar.f7428c[i]);
            this.s -= bVar.f7427b[i];
            bVar.f7427b[i] = 0;
        }
        this.g++;
        this.f7416e.b("REMOVE").i(32).b(bVar.f7426a).i(10);
        this.f.remove(bVar.f7426a);
        if (c()) {
            this.u.execute(this.v);
        }
        return true;
    }

    public synchronized boolean d() {
        return this.j;
    }

    private synchronized void j() {
        if (d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.i) {
            j();
            e();
            this.f7416e.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        b[] bVarArr;
        if (this.i && !this.j) {
            for (b bVar : (b[]) this.f.values().toArray(new b[this.f.size()])) {
                if (bVar.f != null) {
                    bVar.f.c();
                }
            }
            e();
            this.f7416e.close();
            this.f7416e = null;
            this.j = true;
            return;
        }
        this.j = true;
    }

    void e() {
        while (this.s > this.r) {
            a(this.f.values().iterator().next());
        }
        this.k = false;
    }

    public void f() {
        close();
        this.f7413b.g(this.f7414c);
    }

    private void e(String str) {
        if (f7412a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        private final String f7432b;

        /* renamed from: c  reason: collision with root package name */
        private final long f7433c;

        /* renamed from: d  reason: collision with root package name */
        private final s[] f7434d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f7435e;

        c(String str, long j, s[] sVarArr, long[] jArr) {
            this.f7432b = str;
            this.f7433c = j;
            this.f7434d = sVarArr;
            this.f7435e = jArr;
        }

        @Nullable
        public a a() {
            return d.this.a(this.f7432b, this.f7433c);
        }

        public s a(int i) {
            return this.f7434d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (s sVar : this.f7434d) {
                okhttp3.internal.c.a(sVar);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes2.dex */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final b f7421a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f7422b;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7424d;

        a(b bVar) {
            this.f7421a = bVar;
            this.f7422b = bVar.f7430e ? null : new boolean[d.this.f7415d];
        }

        void a() {
            if (this.f7421a.f == this) {
                for (int i = 0; i < d.this.f7415d; i++) {
                    try {
                        d.this.f7413b.d(this.f7421a.f7429d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f7421a.f = null;
            }
        }

        public r a(int i) {
            synchronized (d.this) {
                if (this.f7424d) {
                    throw new IllegalStateException();
                }
                if (this.f7421a.f != this) {
                    return l.a();
                }
                if (!this.f7421a.f7430e) {
                    this.f7422b[i] = true;
                }
                try {
                    return new e(d.this.f7413b.b(this.f7421a.f7429d[i])) { // from class: okhttp3.internal.a.d.a.1
                        @Override // okhttp3.internal.a.e
                        protected void a(IOException iOException) {
                            synchronized (d.this) {
                                a.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return l.a();
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                if (this.f7424d) {
                    throw new IllegalStateException();
                }
                if (this.f7421a.f == this) {
                    d.this.a(this, true);
                }
                this.f7424d = true;
            }
        }

        public void c() {
            synchronized (d.this) {
                if (this.f7424d) {
                    throw new IllegalStateException();
                }
                if (this.f7421a.f == this) {
                    d.this.a(this, false);
                }
                this.f7424d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes2.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f7426a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f7427b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f7428c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f7429d;

        /* renamed from: e  reason: collision with root package name */
        boolean f7430e;
        a f;
        long g;

        b(String str) {
            this.f7426a = str;
            this.f7427b = new long[d.this.f7415d];
            this.f7428c = new File[d.this.f7415d];
            this.f7429d = new File[d.this.f7415d];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < d.this.f7415d; i++) {
                sb.append(i);
                this.f7428c[i] = new File(d.this.f7414c, sb.toString());
                sb.append(".tmp");
                this.f7429d[i] = new File(d.this.f7414c, sb.toString());
                sb.setLength(length);
            }
        }

        void a(String[] strArr) {
            if (strArr.length != d.this.f7415d) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f7427b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        void a(c.d dVar) {
            for (long j : this.f7427b) {
                dVar.i(32).m(j);
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        c a() {
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            s[] sVarArr = new s[d.this.f7415d];
            long[] jArr = (long[]) this.f7427b.clone();
            for (int i = 0; i < d.this.f7415d; i++) {
                try {
                    sVarArr[i] = d.this.f7413b.a(this.f7428c[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < d.this.f7415d && sVarArr[i2] != null; i2++) {
                        okhttp3.internal.c.a(sVarArr[i2]);
                    }
                    try {
                        d.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new c(this.f7426a, this.g, sVarArr, jArr);
        }
    }
}
