package cn.jiguang.ar;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b  reason: collision with root package name */
    private l f3830b;

    /* renamed from: c  reason: collision with root package name */
    private i f3831c;
    private q f;

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<h> f3829a = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private r f3832d = new r(5, 2000, null);

    /* renamed from: e  reason: collision with root package name */
    private g f3833e = new g();

    public k(l lVar) {
        this.f3830b = lVar;
    }

    private void a() {
        h a2 = h.a((String) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.c(true)));
        cn.jiguang.an.d.b("SisConn", "connect: use last good v4 address=" + a2);
        if (a(a2)) {
            return;
        }
        h a3 = h.a((String) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.c(false)));
        cn.jiguang.an.d.b("SisConn", "connect: use last good v6 address=" + a3);
        if (a(a3)) {
            return;
        }
        LinkedHashSet<h> b2 = b();
        if (b2 != null) {
            b2.removeAll(this.f3829a);
        }
        LinkedList a4 = cn.jiguang.f.k.a(b2);
        cn.jiguang.an.d.b("SisConn", "connect: use defaultConn=" + a4);
        Iterator it = a4.iterator();
        while (it.hasNext()) {
            if (a((h) it.next())) {
                return;
            }
        }
        LinkedHashSet<h> a5 = cn.jiguang.as.m.a().a(cn.jiguang.aq.a.b(this.f3830b.f3835a), 10000L);
        a4.clear();
        if (a5 != null) {
            a5.removeAll(this.f3829a);
            a4 = cn.jiguang.f.k.a(a5);
        }
        cn.jiguang.an.d.b("SisConn", "connect: use srv address" + a4);
        Iterator it2 = a4.iterator();
        while (it2.hasNext() && !a((h) it2.next())) {
        }
    }

    private void a(LinkedHashSet<h> linkedHashSet) {
        linkedHashSet.removeAll(this.f3829a);
        if (linkedHashSet.isEmpty()) {
            return;
        }
        LinkedHashSet<h> a2 = e.a(this.f3830b.f3835a, linkedHashSet, 0L);
        cn.jiguang.an.d.b("SisConn", "connect: last good sis info" + a2);
        Iterator<h> it = a2.iterator();
        while (it.hasNext() && !a(it.next())) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(LinkedHashSet<h> linkedHashSet, long j) {
        InetAddress[] a2;
        this.f3833e.a();
        this.f3832d.b();
        linkedHashSet.removeAll(this.f3829a);
        LinkedHashSet<h> a3 = e.a(this.f3830b.f3835a, linkedHashSet, System.currentTimeMillis());
        cn.jiguang.an.d.b("SisConn", "connect: new sis info=" + a3);
        if (a3.isEmpty()) {
            return;
        }
        Iterator<h> it = a3.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (SystemClock.uptimeMillis() >= j || a(next)) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        cn.jiguang.an.d.b("SisConn", "after connect use new sis, wait connect Result");
        long uptimeMillis = j - SystemClock.uptimeMillis();
        if (uptimeMillis > 0 && this.f3832d.a(uptimeMillis) == null && this.f == null) {
            HashSet hashSet = new HashSet();
            Iterator<h> it2 = a3.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (this.f3829a.contains(next2)) {
                    hashSet.add(next2.f3820a);
                }
            }
            int a4 = this.f3830b.a();
            h a5 = h.a((String) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.b(a4 == 1 || a4 == 0)));
            if (a5 == null || (a2 = cn.jiguang.au.a.a().a(this.f3830b.f3835a, a5.f3820a, 3000L, false)) == null || a2.length <= 0) {
                return;
            }
            a5.f3822c = a2[0];
            long uptimeMillis2 = j - SystemClock.uptimeMillis();
            if (uptimeMillis2 < 10) {
                return;
            }
            this.f = new q(this.f3830b, a5, hashSet);
            cn.jiguang.an.d.b("SisConn", "second sis, addr=" + a5 + ", failIps=" + hashSet);
            FutureTask futureTask = new FutureTask(this.f);
            try {
                JCoreManager.onEvent(null, null, 11, "ASYNC", null, futureTask);
                n nVar = (n) futureTask.get(uptimeMillis2, TimeUnit.MILLISECONDS);
                LinkedHashSet<h> linkedHashSet2 = nVar != null ? nVar.f3841a : null;
                if (linkedHashSet2 == null || linkedHashSet2.isEmpty()) {
                    return;
                }
                this.f3830b.a(nVar.g);
                a(linkedHashSet2, j);
            } catch (Throwable th) {
                cn.jiguang.an.d.f("SisConn", "second sis e:" + th);
            }
        }
    }

    private boolean a(h hVar) {
        InetAddress[] a2;
        cn.jiguang.at.e eVar;
        if (!this.f3831c.f3823a) {
            if (this.f3832d.a()) {
                return true;
            }
            if (hVar != null && hVar.a() && !this.f3829a.contains(hVar) && (a2 = cn.jiguang.au.a.a().a(this.f3830b.f3835a, hVar.f3820a, 3000L, false)) != null && a2.length != 0) {
                Iterator it = cn.jiguang.f.k.a(Arrays.asList(a2)).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it.next();
                    if (!this.f3831c.f3823a) {
                        if (!this.f3832d.a()) {
                            h hVar2 = new h(inetAddress, hVar.f3821b);
                            if (!this.f3829a.contains(hVar2) && this.f3833e.a(hVar2)) {
                                this.f3829a.add(hVar2);
                                r rVar = this.f3832d;
                                rVar.a((Callable<?>) new b(this.f3830b, rVar, this.f3833e, this.f3831c));
                                break;
                            }
                        } else {
                            return true;
                        }
                    } else {
                        eVar = new cn.jiguang.at.e(-991, null);
                        break;
                    }
                }
                this.f3829a.add(hVar);
            }
            return false;
        }
        eVar = new cn.jiguang.at.e(-991, null);
        this.f3832d.a(eVar);
        return true;
    }

    private LinkedHashSet<h> b() {
        InetAddress[] a2;
        try {
            String a3 = cn.jiguang.aq.a.a(this.f3830b.f3835a);
            cn.jiguang.an.d.b("SisConn", "load Default Conn, from host=" + a3);
            if (!TextUtils.isEmpty(a3) && (a2 = cn.jiguang.au.a.a().a(this.f3830b.f3835a, a3, 3000L, false)) != null && a2.length != 0) {
                LinkedList a4 = cn.jiguang.f.k.a(Arrays.asList(a2));
                if (a4.isEmpty()) {
                    return null;
                }
                String hostAddress = ((InetAddress) a4.get(0)).getHostAddress();
                LinkedHashSet<h> linkedHashSet = new LinkedHashSet<>();
                linkedHashSet.add(new h(hostAddress, 7000));
                linkedHashSet.add(new h(hostAddress, 7002));
                linkedHashSet.add(new h(hostAddress, 7003));
                linkedHashSet.add(new h(hostAddress, 7004));
                linkedHashSet.add(new h(hostAddress, 7005));
                linkedHashSet.add(new h(hostAddress, 7006));
                linkedHashSet.add(new h(hostAddress, 7007));
                linkedHashSet.add(new h(hostAddress, 7008));
                linkedHashSet.add(new h(hostAddress, 7009));
                return linkedHashSet;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final cn.jiguang.aw.a a(i iVar) {
        boolean z;
        LinkedHashSet<h> linkedHashSet;
        Object a2;
        this.f3831c = iVar;
        cn.jiguang.an.d.b("SisConn", "start sisAndConnect...");
        this.f3833e = new g();
        long uptimeMillis = SystemClock.uptimeMillis() + 12000;
        LinkedHashSet<h> b2 = h.b((String) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.I()));
        boolean z2 = !b2.isEmpty();
        String c2 = cn.jiguang.f.j.c(this.f3830b.f3835a);
        Context context = this.f3830b.f3835a;
        boolean z3 = false;
        if (!TextUtils.isEmpty(c2)) {
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.E());
            cn.jiguang.an.d.b("SisConn", "newType=" + c2 + " last=" + str);
            if (c2.equalsIgnoreCase(str)) {
                z = false;
                long longValue = ((Long) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.L())).longValue();
                if (!z && !cn.jiguang.f.k.a(longValue, 180000L)) {
                    z3 = true;
                }
                if (z2 && z3) {
                    a(b2);
                }
                n a3 = this.f3830b.a(12000L);
                linkedHashSet = a3 == null ? a3.f3841a : null;
                if (linkedHashSet == null && !linkedHashSet.isEmpty()) {
                    this.f3830b.a(a3.g);
                    a(linkedHashSet, uptimeMillis);
                } else if (z2 && !z3) {
                    a(b2);
                }
                a();
                cn.jiguang.an.d.b("SisConn", "wait final result...");
                a2 = this.f3832d.a(JConstants.MIN);
                if (!(a2 instanceof cn.jiguang.aw.a)) {
                    cn.jiguang.an.d.b("SisConn", "connect succeed");
                    return (cn.jiguang.aw.a) a2;
                } else if (a2 instanceof Exception) {
                    cn.jiguang.an.d.b("SisConn", "all sis and connect failed, e:" + a2);
                    throw ((Exception) a2);
                } else {
                    cn.jiguang.an.d.f("SisConn", "all sis and connect failed:" + a2);
                    throw new cn.jiguang.at.e(1, null);
                }
            }
        }
        z = true;
        long longValue2 = ((Long) cn.jiguang.g.b.a(this.f3830b.f3835a, cn.jiguang.g.a.L())).longValue();
        if (!z) {
            z3 = true;
        }
        if (z2) {
            a(b2);
        }
        n a32 = this.f3830b.a(12000L);
        if (a32 == null) {
        }
        if (linkedHashSet == null) {
        }
        if (z2) {
            a(b2);
        }
        a();
        cn.jiguang.an.d.b("SisConn", "wait final result...");
        a2 = this.f3832d.a(JConstants.MIN);
        if (!(a2 instanceof cn.jiguang.aw.a)) {
        }
    }
}
