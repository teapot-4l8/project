package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class g {
    private static final String[] h = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final androidx.b.a<String, Integer> f2423a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f2424b;

    /* renamed from: c  reason: collision with root package name */
    final j f2425c;

    /* renamed from: d  reason: collision with root package name */
    AtomicBoolean f2426d;

    /* renamed from: e  reason: collision with root package name */
    volatile androidx.e.a.f f2427e;
    final androidx.a.a.b.b<b, c> f;
    Runnable g;
    private Map<String, Set<String>> i;
    private volatile boolean j;
    private a k;
    private final f l;
    private h m;

    public g(j jVar, String... strArr) {
        this(jVar, new HashMap(), Collections.emptyMap(), strArr);
    }

    public g(j jVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f2426d = new AtomicBoolean(false);
        this.j = false;
        this.f = new androidx.a.a.b.b<>();
        this.g = new Runnable() { // from class: androidx.room.g.1
            @Override // java.lang.Runnable
            public void run() {
                Lock a2 = g.this.f2425c.a();
                Set<Integer> set = null;
                try {
                    try {
                        a2.lock();
                    } catch (SQLiteException | IllegalStateException e2) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    }
                    if (g.this.a()) {
                        if (g.this.f2426d.compareAndSet(true, false)) {
                            if (g.this.f2425c.l()) {
                                return;
                            }
                            if (g.this.f2425c.f2455b) {
                                androidx.e.a.b a3 = g.this.f2425c.b().a();
                                a3.a();
                                try {
                                    set = a();
                                    a3.c();
                                    a3.b();
                                } catch (Throwable th) {
                                    a3.b();
                                    throw th;
                                }
                            } else {
                                set = a();
                            }
                            if (set == null || set.isEmpty()) {
                                return;
                            }
                            synchronized (g.this.f) {
                                Iterator<Map.Entry<b, c>> it = g.this.f.iterator();
                                while (it.hasNext()) {
                                    it.next().getValue().a(set);
                                }
                            }
                        }
                    }
                } finally {
                    a2.unlock();
                }
            }

            private Set<Integer> a() {
                androidx.b.b bVar = new androidx.b.b();
                Cursor a2 = g.this.f2425c.a(new androidx.e.a.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                while (a2.moveToNext()) {
                    try {
                        bVar.add(Integer.valueOf(a2.getInt(0)));
                    } catch (Throwable th) {
                        a2.close();
                        throw th;
                    }
                }
                a2.close();
                if (!bVar.isEmpty()) {
                    g.this.f2427e.a();
                }
                return bVar;
            }
        };
        this.f2425c = jVar;
        this.k = new a(strArr.length);
        this.f2423a = new androidx.b.a<>();
        this.i = map2;
        this.l = new f(this.f2425c);
        int length = strArr.length;
        this.f2424b = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.f2423a.put(lowerCase, Integer.valueOf(i));
            String str = map.get(strArr[i]);
            if (str != null) {
                this.f2424b[i] = str.toLowerCase(Locale.US);
            } else {
                this.f2424b[i] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.f2423a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                androidx.b.a<String, Integer> aVar = this.f2423a;
                aVar.put(lowerCase3, aVar.get(lowerCase2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.e.a.b bVar) {
        synchronized (this) {
            if (this.j) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.c("PRAGMA temp_store = MEMORY;");
            bVar.c("PRAGMA recursive_triggers='ON';");
            bVar.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            b(bVar);
            this.f2427e = bVar.a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, String str) {
        this.m = new h(context, str, this, this.f2425c.i());
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void a(androidx.e.a.b bVar, int i) {
        String[] strArr;
        String str = this.f2424b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a(sb, str, str2);
            bVar.c(sb.toString());
        }
    }

    private void b(androidx.e.a.b bVar, int i) {
        String[] strArr;
        bVar.c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        String str = this.f2424b[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.c(sb.toString());
        }
    }

    public void a(b bVar) {
        c a2;
        String[] b2 = b(bVar.f2434a);
        int[] iArr = new int[b2.length];
        int length = b2.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.f2423a.get(b2[i].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + b2[i]);
            }
            iArr[i] = num.intValue();
        }
        c cVar = new c(bVar, iArr, b2);
        synchronized (this.f) {
            a2 = this.f.a(bVar, cVar);
        }
        if (a2 == null && this.k.a(iArr)) {
            c();
        }
    }

    private String[] b(String[] strArr) {
        androidx.b.b bVar = new androidx.b.b();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.i.containsKey(lowerCase)) {
                bVar.addAll(this.i.get(lowerCase));
            } else {
                bVar.add(str);
            }
        }
        return (String[]) bVar.toArray(new String[bVar.size()]);
    }

    public void b(b bVar) {
        a(new d(this, bVar));
    }

    public void c(b bVar) {
        c b2;
        synchronized (this.f) {
            b2 = this.f.b(bVar);
        }
        if (b2 == null || !this.k.b(b2.f2435a)) {
            return;
        }
        c();
    }

    boolean a() {
        if (this.f2425c.d()) {
            if (!this.j) {
                this.f2425c.b().a();
            }
            if (this.j) {
                return true;
            }
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return false;
    }

    public void b() {
        if (this.f2426d.compareAndSet(false, true)) {
            this.f2425c.i().execute(this.g);
        }
    }

    public void a(String... strArr) {
        synchronized (this.f) {
            Iterator<Map.Entry<b, c>> it = this.f.iterator();
            while (it.hasNext()) {
                Map.Entry<b, c> next = it.next();
                if (!next.getKey().a()) {
                    next.getValue().a(strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(androidx.e.a.b bVar) {
        if (bVar.d()) {
            return;
        }
        while (true) {
            try {
                Lock a2 = this.f2425c.a();
                a2.lock();
                try {
                    int[] a3 = this.k.a();
                    if (a3 == null) {
                        return;
                    }
                    int length = a3.length;
                    bVar.a();
                    for (int i = 0; i < length; i++) {
                        int i2 = a3[i];
                        if (i2 == 1) {
                            b(bVar, i);
                        } else if (i2 == 2) {
                            a(bVar, i);
                        }
                    }
                    bVar.c();
                    bVar.b();
                    this.k.b();
                } finally {
                    a2.unlock();
                }
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                return;
            }
        }
    }

    void c() {
        if (this.f2425c.d()) {
            b(this.f2425c.b().a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f2435a;

        /* renamed from: b  reason: collision with root package name */
        final b f2436b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f2437c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f2438d;

        c(b bVar, int[] iArr, String[] strArr) {
            this.f2436b = bVar;
            this.f2435a = iArr;
            this.f2437c = strArr;
            if (iArr.length == 1) {
                androidx.b.b bVar2 = new androidx.b.b();
                bVar2.add(this.f2437c[0]);
                this.f2438d = Collections.unmodifiableSet(bVar2);
                return;
            }
            this.f2438d = null;
        }

        void a(Set<Integer> set) {
            int length = this.f2435a.length;
            Set<String> set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(Integer.valueOf(this.f2435a[i]))) {
                    if (length == 1) {
                        set2 = this.f2438d;
                    } else {
                        if (set2 == null) {
                            set2 = new androidx.b.b<>(length);
                        }
                        set2.add(this.f2437c[i]);
                    }
                }
            }
            if (set2 != null) {
                this.f2436b.a(set2);
            }
        }

        void a(String[] strArr) {
            Set<String> set = null;
            if (this.f2437c.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (strArr[i].equalsIgnoreCase(this.f2437c[0])) {
                        set = this.f2438d;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                androidx.b.b bVar = new androidx.b.b();
                for (String str : strArr) {
                    String[] strArr2 = this.f2437c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String str2 = strArr2[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                bVar.add(str2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (bVar.size() > 0) {
                    set = bVar;
                }
            }
            if (set != null) {
                this.f2436b.a(set);
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String[] f2434a;

        public abstract void a(Set<String> set);

        boolean a() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.f2434a = strArr2;
            strArr2[strArr.length] = str;
        }

        public b(String[] strArr) {
            this.f2434a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long[] f2429a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f2430b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f2431c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2432d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2433e;

        a(int i) {
            long[] jArr = new long[i];
            this.f2429a = jArr;
            this.f2430b = new boolean[i];
            this.f2431c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.f2430b, false);
        }

        boolean a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f2429a[i];
                    this.f2429a[i] = 1 + j;
                    if (j == 0) {
                        this.f2432d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        boolean b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long j = this.f2429a[i];
                    this.f2429a[i] = j - 1;
                    if (j == 1) {
                        this.f2432d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        int[] a() {
            synchronized (this) {
                if (this.f2432d && !this.f2433e) {
                    int length = this.f2429a.length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i < length) {
                            boolean z = this.f2429a[i] > 0;
                            if (z != this.f2430b[i]) {
                                int[] iArr = this.f2431c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[i] = i2;
                            } else {
                                this.f2431c[i] = 0;
                            }
                            this.f2430b[i] = z;
                            i++;
                        } else {
                            this.f2433e = true;
                            this.f2432d = false;
                            return this.f2431c;
                        }
                    }
                }
                return null;
            }
        }

        void b() {
            synchronized (this) {
                this.f2433e = false;
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    static class d extends b {

        /* renamed from: b  reason: collision with root package name */
        final g f2439b;

        /* renamed from: c  reason: collision with root package name */
        final WeakReference<b> f2440c;

        d(g gVar, b bVar) {
            super(bVar.f2434a);
            this.f2439b = gVar;
            this.f2440c = new WeakReference<>(bVar);
        }

        @Override // androidx.room.g.b
        public void a(Set<String> set) {
            b bVar = this.f2440c.get();
            if (bVar == null) {
                this.f2439b.c(this);
            } else {
                bVar.a(set);
            }
        }
    }
}
