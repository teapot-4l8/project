package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.e.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: RoomDatabase.java */
/* loaded from: classes.dex */
public abstract class j {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile androidx.e.a.b f2454a;

    /* renamed from: b  reason: collision with root package name */
    boolean f2455b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    protected List<b> f2456c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f2457d;

    /* renamed from: e  reason: collision with root package name */
    private Executor f2458e;
    private androidx.e.a.c f;
    private boolean h;
    private final ReentrantReadWriteLock i = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> j = new ThreadLocal<>();
    private final Map<String, Object> k = new ConcurrentHashMap();
    private final g g = c();

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(androidx.e.a.b bVar) {
        }

        public void b(androidx.e.a.b bVar) {
        }
    }

    protected abstract androidx.e.a.c b(androidx.room.a aVar);

    protected abstract g c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock a() {
        return this.i.readLock();
    }

    public void a(androidx.room.a aVar) {
        this.f = b(aVar);
        if (Build.VERSION.SDK_INT >= 16) {
            r1 = aVar.g == c.WRITE_AHEAD_LOGGING;
            this.f.a(r1);
        }
        this.f2456c = aVar.f2394e;
        this.f2457d = aVar.h;
        this.f2458e = new o(aVar.i);
        this.h = aVar.f;
        this.f2455b = r1;
        if (aVar.j) {
            this.g.a(aVar.f2391b, aVar.f2392c);
        }
    }

    public androidx.e.a.c b() {
        return this.f;
    }

    public boolean d() {
        androidx.e.a.b bVar = this.f2454a;
        return bVar != null && bVar.e();
    }

    public void e() {
        if (!this.h && m()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void f() {
        if (!l() && this.j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor a(androidx.e.a.e eVar) {
        e();
        f();
        return this.f.a().a(eVar);
    }

    public androidx.e.a.f a(String str) {
        e();
        f();
        return this.f.a().a(str);
    }

    @Deprecated
    public void g() {
        e();
        androidx.e.a.b a2 = this.f.a();
        this.g.b(a2);
        a2.a();
    }

    @Deprecated
    public void h() {
        this.f.a().b();
        if (l()) {
            return;
        }
        this.g.b();
    }

    public Executor i() {
        return this.f2457d;
    }

    @Deprecated
    public void j() {
        this.f.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(androidx.e.a.b bVar) {
        this.g.a(bVar);
    }

    public g k() {
        return this.g;
    }

    public boolean l() {
        return this.f.a().d();
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        c a(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !androidx.core.app.b.a(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class a<T extends j> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f2459a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2460b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f2461c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f2462d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f2463e;
        private Executor f;
        private c.InterfaceC0044c g;
        private boolean h;
        private boolean j;
        private boolean l;
        private Set<Integer> n;
        private Set<Integer> o;
        private c i = c.AUTOMATIC;
        private boolean k = true;
        private final d m = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, Class<T> cls, String str) {
            this.f2461c = context;
            this.f2459a = cls;
            this.f2460b = str;
        }

        public a<T> a(androidx.room.a.a... aVarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (androidx.room.a.a aVar : aVarArr) {
                this.o.add(Integer.valueOf(aVar.f2395a));
                this.o.add(Integer.valueOf(aVar.f2396b));
            }
            this.m.a(aVarArr);
            return this;
        }

        public a<T> a() {
            this.h = true;
            return this;
        }

        public a<T> a(Executor executor) {
            this.f2463e = executor;
            return this;
        }

        public a<T> b() {
            this.k = false;
            this.l = true;
            return this;
        }

        public a<T> a(b bVar) {
            if (this.f2462d == null) {
                this.f2462d = new ArrayList<>();
            }
            this.f2462d.add(bVar);
            return this;
        }

        public T c() {
            Executor executor;
            if (this.f2461c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f2459a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            if (this.f2463e == null && this.f == null) {
                Executor b2 = androidx.a.a.a.a.b();
                this.f = b2;
                this.f2463e = b2;
            } else {
                Executor executor2 = this.f2463e;
                if (executor2 != null && this.f == null) {
                    this.f = executor2;
                } else if (this.f2463e == null && (executor = this.f) != null) {
                    this.f2463e = executor;
                }
            }
            Set<Integer> set = this.o;
            if (set != null && this.n != null) {
                for (Integer num : set) {
                    if (this.n.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.g == null) {
                this.g = new androidx.e.a.a.c();
            }
            Context context = this.f2461c;
            androidx.room.a aVar = new androidx.room.a(context, this.f2460b, this.g, this.m, this.f2462d, this.h, this.i.a(context), this.f2463e, this.f, this.j, this.k, this.l, this.n);
            T t = (T) i.a(this.f2459a, "_Impl");
            t.a(aVar);
            return t;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private androidx.b.h<androidx.b.h<androidx.room.a.a>> f2468a = new androidx.b.h<>();

        public void a(androidx.room.a.a... aVarArr) {
            for (androidx.room.a.a aVar : aVarArr) {
                a(aVar);
            }
        }

        private void a(androidx.room.a.a aVar) {
            int i = aVar.f2395a;
            int i2 = aVar.f2396b;
            androidx.b.h<androidx.room.a.a> a2 = this.f2468a.a(i);
            if (a2 == null) {
                a2 = new androidx.b.h<>();
                this.f2468a.b(i, a2);
            }
            androidx.room.a.a a3 = a2.a(i2);
            if (a3 != null) {
                Log.w("ROOM", "Overriding migration " + a3 + " with " + aVar);
            }
            a2.c(i2, aVar);
        }

        public List<androidx.room.a.a> a(int i, int i2) {
            if (i == i2) {
                return Collections.emptyList();
            }
            return a(new ArrayList(), i2 > i, i, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0019 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<androidx.room.a.a> a(List<androidx.room.a.a> list, boolean z, int i, int i2) {
            androidx.b.h<androidx.room.a.a> a2;
            boolean z2;
            int i3;
            int i4;
            int i5 = z ? -1 : 1;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                    a2 = this.f2468a.a(i);
                    if (a2 != null) {
                        return null;
                    }
                    int b2 = a2.b();
                    z2 = false;
                    if (z) {
                        i4 = b2 - 1;
                        i3 = -1;
                    } else {
                        i3 = b2;
                        i4 = 0;
                    }
                    while (true) {
                        if (i4 != i3) {
                            int c2 = a2.c(i4);
                            if (!z ? c2 < i2 || c2 >= i : c2 > i2 || c2 <= i) {
                                list.add(a2.d(i4));
                                i = c2;
                                z2 = true;
                                continue;
                                break;
                            }
                            i4 += i5;
                        }
                    }
                } else {
                    if (i <= i2) {
                        return list;
                    }
                    a2 = this.f2468a.a(i);
                    if (a2 != null) {
                    }
                }
            } while (z2);
            return null;
        }
    }

    private static boolean m() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
