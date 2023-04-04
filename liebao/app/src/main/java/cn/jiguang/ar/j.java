package cn.jiguang.ar;

import cn.jiguang.internal.JConstants;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class j implements Callable<n> {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<h> f3827a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private l f3828b;

    public j(l lVar) {
        this.f3828b = lVar;
    }

    private void a(r rVar, g gVar) {
        LinkedHashSet<h> b2 = h.b((String) cn.jiguang.g.b.a(this.f3828b.f3835a, cn.jiguang.g.a.N()));
        if (b2.isEmpty()) {
            b2 = h.a(cn.jiguang.aq.a.b());
        }
        b2.removeAll(this.f3827a);
        LinkedList<h> a2 = cn.jiguang.f.k.a(b2);
        cn.jiguang.an.d.b("Sis", "main sis: default sis" + a2);
        for (h hVar : a2) {
            if (a(hVar, rVar, gVar)) {
                return;
            }
        }
        LinkedHashSet<h> a3 = cn.jiguang.as.m.a().a(cn.jiguang.aq.a.c(), 10000L);
        a2.clear();
        if (a3 != null) {
            a3.removeAll(this.f3827a);
            a2 = cn.jiguang.f.k.a(a3);
        }
        cn.jiguang.an.d.b("Sis", "main sis: sis srv" + a2);
        Iterator it = a2.iterator();
        while (it.hasNext() && !a((h) it.next(), rVar, gVar)) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
        r9.f3827a.add(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(h hVar, r rVar, g gVar) {
        InetAddress[] a2;
        if (rVar.a()) {
            return true;
        }
        if (hVar != null && hVar.a() && !this.f3827a.contains(hVar) && (a2 = cn.jiguang.au.a.a().a(this.f3828b.f3835a, hVar.f3820a, 3000L, false)) != null && a2.length != 0) {
            Iterator it = cn.jiguang.f.k.a(Arrays.asList(a2)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                InetAddress inetAddress = (InetAddress) it.next();
                if (!rVar.a()) {
                    h hVar2 = new h(inetAddress, hVar.f3821b);
                    if (!this.f3827a.contains(hVar2) && gVar.a(hVar2)) {
                        this.f3827a.add(hVar2);
                        rVar.a((Callable<?>) new q(this.f3828b, rVar, gVar));
                        break;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ n call() {
        g gVar = new g();
        r rVar = new r(5, 2000, null);
        LinkedHashSet<h> a2 = h.a(cn.jiguang.aq.a.a());
        a2.removeAll(this.f3827a);
        LinkedList a3 = cn.jiguang.f.k.a(a2);
        cn.jiguang.an.d.b("Sis", "main sis: sis host=" + a3);
        Iterator it = a3.iterator();
        while (true) {
            if (!it.hasNext()) {
                h a4 = h.a((String) cn.jiguang.g.b.a(this.f3828b.f3835a, cn.jiguang.g.a.b(true)));
                cn.jiguang.an.d.b("Sis", "main sis: last good sis v4 address=" + a4);
                if (!a(a4, rVar, gVar)) {
                    h a5 = h.a((String) cn.jiguang.g.b.a(this.f3828b.f3835a, cn.jiguang.g.a.b(false)));
                    cn.jiguang.an.d.b("Sis", "main sis: last good sis v6 address=" + a5);
                    a(a5, rVar, gVar);
                }
            } else if (a((h) it.next(), rVar, gVar)) {
                break;
            }
        }
        cn.jiguang.an.d.b("Sis", "main sis: after host and last good, wait Result");
        Object a6 = rVar.a(JConstants.MIN);
        if (a6 instanceof n) {
            return (n) a6;
        }
        a(rVar, gVar);
        cn.jiguang.an.d.b("Sis", "main sis: after default and srv, wait Result");
        Object a7 = rVar.a(JConstants.MIN);
        if (a7 instanceof n) {
            return (n) a7;
        }
        return null;
    }
}
