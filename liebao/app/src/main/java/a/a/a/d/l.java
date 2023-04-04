package a.a.a.d;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Cache.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private a f308a;

    /* renamed from: b  reason: collision with root package name */
    private int f309b;

    /* renamed from: c  reason: collision with root package name */
    private int f310c;

    /* renamed from: d  reason: collision with root package name */
    private int f311d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(int i);

        boolean a();

        int b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(long j, long j2) {
        if (j2 >= 0 && j2 < j) {
            j = j2;
        }
        long currentTimeMillis = (System.currentTimeMillis() / 1000) + j;
        if (currentTimeMillis < 0 || currentTimeMillis > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes.dex */
    public static class b<T extends bx> extends bu<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        int f313a;

        /* renamed from: b  reason: collision with root package name */
        int f314b;

        public b(bu<T> buVar, int i, long j) {
            super(buVar);
            this.f313a = i;
            this.f314b = l.b(buVar.f(), j);
        }

        @Override // a.a.a.d.l.c
        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.f314b;
        }

        @Override // a.a.a.d.l.c
        public final int a(int i) {
            return this.f313a - i;
        }

        @Override // a.a.a.d.bu
        public String toString() {
            return super.toString() + " cl = " + this.f313a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes.dex */
    public static class d implements c {

        /* renamed from: a  reason: collision with root package name */
        int f315a;

        /* renamed from: b  reason: collision with root package name */
        bj f316b;

        /* renamed from: c  reason: collision with root package name */
        int f317c;

        /* renamed from: d  reason: collision with root package name */
        int f318d;

        public d(bj bjVar, int i, cg cgVar, int i2, long j) {
            this.f316b = bjVar;
            this.f315a = i;
            long f = cgVar != null ? cgVar.f() : 0L;
            this.f317c = i2;
            this.f318d = l.b(f, j);
        }

        @Override // a.a.a.d.l.c
        public int b() {
            return this.f315a;
        }

        @Override // a.a.a.d.l.c
        public final boolean a() {
            return ((int) (System.currentTimeMillis() / 1000)) >= this.f318d;
        }

        @Override // a.a.a.d.l.c
        public final int a(int i) {
            return this.f317c - i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f315a == 0) {
                sb.append("NXDOMAIN ");
                sb.append(this.f316b);
            } else {
                sb.append("NXRRSET ");
                sb.append(this.f316b);
                sb.append(" ");
                sb.append(cz.b(this.f315a));
            }
            sb.append(" cl = ");
            sb.append(this.f317c);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.java */
    /* loaded from: classes.dex */
    public static class a extends LinkedHashMap<bj, Object> {

        /* renamed from: a  reason: collision with root package name */
        private int f312a;

        a(int i) {
            super(16, 0.75f, true);
            this.f312a = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<bj, Object> entry) {
            return this.f312a >= 0 && size() > this.f312a;
        }
    }

    public l(int i) {
        this.f309b = -1;
        this.f310c = -1;
        this.f311d = i;
        this.f308a = new a(50000);
    }

    public l() {
        this(1);
    }

    private synchronized Object a(bj bjVar) {
        return this.f308a.get(bjVar);
    }

    private synchronized c[] a(Object obj) {
        if (!(obj instanceof List)) {
            return new c[]{(c) obj};
        }
        List list = (List) obj;
        return (c[]) list.toArray(new c[list.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r0.b() == r6) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized c a(bj bjVar, Object obj, int i, int i2) {
        if (i == 255) {
            throw new IllegalArgumentException("oneElement(ANY)");
        }
        if (obj instanceof List) {
            for (c cVar : (List) obj) {
                if (cVar.b() == i) {
                    break;
                }
            }
            cVar = null;
        } else {
            cVar = (c) obj;
        }
        if (cVar == null) {
            return null;
        }
        if (cVar.a()) {
            a(bjVar, i);
            return null;
        } else if (cVar.a(i2) < 0) {
            return null;
        } else {
            return cVar;
        }
    }

    private synchronized c c(bj bjVar, int i, int i2) {
        Object a2 = a(bjVar);
        if (a2 == null) {
            return null;
        }
        return a(bjVar, a2, i, i2);
    }

    private synchronized void a(bj bjVar, c cVar) {
        Object obj = this.f308a.get(bjVar);
        if (obj == null) {
            this.f308a.put(bjVar, cVar);
            return;
        }
        int b2 = cVar.b();
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                if (((c) list.get(i)).b() == b2) {
                    list.set(i, cVar);
                    return;
                }
            }
            list.add(cVar);
        } else {
            c cVar2 = (c) obj;
            if (cVar2.b() == b2) {
                this.f308a.put(bjVar, cVar);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(cVar2);
                linkedList.add(cVar);
                this.f308a.put(bjVar, linkedList);
            }
        }
    }

    private synchronized void a(bj bjVar, int i) {
        Object obj = this.f308a.get(bjVar);
        if (obj == null) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (((c) list.get(i2)).b() == i) {
                    list.remove(i2);
                    if (list.size() == 0) {
                        this.f308a.remove(bjVar);
                    }
                    return;
                }
            }
        } else if (((c) obj).b() == i) {
            this.f308a.remove(bjVar);
        }
    }

    public synchronized void a() {
        this.f308a.clear();
    }

    public synchronized <T extends bx> void a(bu<T> buVar, int i) {
        b bVar;
        long f = buVar.f();
        bj d2 = buVar.d();
        int b2 = buVar.b();
        c c2 = c(d2, b2, 0);
        if (f == 0) {
            if (c2 != null && c2.a(i) <= 0) {
                a(d2, b2);
            }
        } else {
            if (c2 != null && c2.a(i) <= 0) {
                c2 = null;
            }
            if (c2 == null) {
                if (buVar instanceof b) {
                    bVar = (b) buVar;
                } else {
                    bVar = new b(buVar, i, this.f310c);
                }
                a(d2, bVar);
            }
        }
    }

    public synchronized void a(bj bjVar, int i, cg cgVar, int i2) {
        long m = cgVar != null ? cgVar.m() : 0L;
        c c2 = c(bjVar, i, 0);
        if (m == 0) {
            if (c2 != null && c2.a(i2) <= 0) {
                a(bjVar, i);
            }
        } else {
            if (c2 != null && c2.a(i2) <= 0) {
                c2 = null;
            }
            if (c2 == null) {
                a(bjVar, new d(bjVar, i, cgVar, i2, this.f309b));
            }
        }
    }

    protected synchronized cm a(bj bjVar, int i, int i2) {
        bj bjVar2;
        c[] a2;
        int c2 = bjVar.c();
        int i3 = c2;
        while (i3 >= 1) {
            boolean z = i3 == 1;
            boolean z2 = i3 == c2;
            if (z) {
                bjVar2 = bj.f178a;
            } else {
                bjVar2 = z2 ? bjVar : new bj(bjVar, c2 - i3);
            }
            Object obj = this.f308a.get(bjVar2);
            if (obj != null) {
                if (z2 && i == 255) {
                    cm cmVar = new cm(6);
                    int i4 = 0;
                    for (c cVar : a(obj)) {
                        if (cVar.a()) {
                            a(bjVar2, cVar.b());
                        } else if ((cVar instanceof b) && cVar.a(i2) >= 0) {
                            cmVar.a((b) cVar);
                            i4++;
                        }
                    }
                    if (i4 > 0) {
                        return cmVar;
                    }
                } else if (z2) {
                    c a3 = a(bjVar2, obj, i, i2);
                    if (a3 instanceof b) {
                        cm cmVar2 = new cm(6);
                        cmVar2.a((b) a3);
                        return cmVar2;
                    } else if (a3 != null) {
                        return new cm(2);
                    } else {
                        c a4 = a(bjVar2, obj, 5, i2);
                        if (a4 instanceof b) {
                            return new cm(4, (b) a4);
                        }
                    }
                } else {
                    c a5 = a(bjVar2, obj, 39, i2);
                    if (a5 instanceof b) {
                        return new cm(5, (b) a5);
                    }
                }
                c a6 = a(bjVar2, obj, 2, i2);
                if (a6 instanceof b) {
                    return new cm(3, (b) a6);
                } else if (z2 && a(bjVar2, obj, 0, i2) != null) {
                    return cm.a(1);
                }
            }
            i3--;
        }
        return cm.a(0);
    }

    public cm b(bj bjVar, int i, int i2) {
        return a(bjVar, i, i2);
    }

    private int a(int i, boolean z) {
        if (i == 1) {
            return z ? 4 : 3;
        } else if (i == 2) {
            return z ? 4 : 3;
        } else if (i == 3) {
            return 1;
        } else {
            throw new IllegalArgumentException("getCred: invalid section");
        }
    }

    private static void a(bu<?> buVar, Set<bj> set) {
        if (buVar.g().c() == null) {
            return;
        }
        Iterator<?> it = buVar.c().iterator();
        while (it.hasNext()) {
            bj c2 = ((bx) it.next()).c();
            if (c2 != null) {
                set.add(c2);
            }
        }
    }

    public cm a(ax axVar) {
        bu[] b2;
        bu[] b3;
        int i;
        bu<?>[] buVarArr;
        boolean b4 = axVar.a().b(5);
        bx b5 = axVar.b();
        int c2 = axVar.a().c();
        boolean b6 = bo.b("verbosecache");
        if ((c2 == 0 || c2 == 3) && b5 != null) {
            bj j = b5.j();
            int k = b5.k();
            int l = b5.l();
            HashSet hashSet = new HashSet();
            int i2 = 1;
            bu<?>[] b7 = axVar.b(1);
            int length = b7.length;
            cm cmVar = null;
            bj bjVar = j;
            int i3 = 0;
            boolean z = false;
            while (i3 < length) {
                bu<?> buVar = b7[i3];
                if (buVar.e() != l) {
                    i = l;
                    buVarArr = b7;
                } else {
                    int b8 = buVar.b();
                    i = l;
                    bj d2 = buVar.d();
                    buVarArr = b7;
                    int a2 = a(i2, b4);
                    if ((b8 == k || k == 255) && d2.equals(bjVar)) {
                        a(buVar, a2);
                        if (bjVar == j) {
                            cm cmVar2 = cmVar == null ? new cm(6) : cmVar;
                            cmVar2.a(buVar);
                            cmVar = cmVar2;
                        }
                        a(buVar, hashSet);
                        z = true;
                    } else if (b8 == 5 && d2.equals(bjVar)) {
                        a(buVar, a2);
                        if (bjVar == j) {
                            cmVar = new cm(4, buVar);
                        }
                        bjVar = ((k) buVar.g()).g_();
                    } else if (b8 == 39 && bjVar.a(d2)) {
                        a(buVar, a2);
                        if (bjVar == j) {
                            cmVar = new cm(5, buVar);
                        }
                        try {
                            bjVar = bjVar.a((s) buVar.g());
                        } catch (bk unused) {
                        }
                    }
                    i3++;
                    l = i;
                    b7 = buVarArr;
                    i2 = 1;
                }
                i3++;
                l = i;
                b7 = buVarArr;
                i2 = 1;
            }
            bu buVar2 = null;
            bu buVar3 = null;
            for (bu buVar4 : axVar.b(2)) {
                if (buVar4.b() == 6 && bjVar.a(buVar4.d())) {
                    buVar3 = buVar4;
                } else if (buVar4.b() == 2 && bjVar.a(buVar4.d())) {
                    buVar2 = buVar4;
                }
            }
            if (!z) {
                if (c2 == 3) {
                    k = 0;
                }
                if (c2 == 3 || buVar3 != null || buVar2 == null) {
                    a(bjVar, k, buVar3 != null ? (cg) buVar3.g() : null, a(2, b4));
                    if (cmVar == null) {
                        cmVar = cm.a(c2 == 3 ? 1 : 2);
                    }
                } else {
                    a(buVar2, a(2, b4));
                    a(buVar2, hashSet);
                    if (cmVar == null) {
                        cmVar = new cm(3, buVar2);
                    }
                }
            } else if (c2 == 0 && buVar2 != null) {
                a(buVar2, a(2, b4));
                a(buVar2, hashSet);
            }
            cm cmVar3 = cmVar;
            for (bu buVar5 : axVar.b(3)) {
                int b9 = buVar5.b();
                if ((b9 == 1 || b9 == 28 || b9 == 38) && hashSet.contains(buVar5.d())) {
                    a(buVar5, a(3, b4));
                }
            }
            if (b6) {
                System.out.println("addMessage: " + cmVar3);
            }
            return cmVar3;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            for (Object obj : this.f308a.values()) {
                for (c cVar : a(obj)) {
                    sb.append(cVar);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
