package cn.jiguang.ar;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private LinkedHashSet<h> f3817a = new LinkedHashSet<>();

    /* renamed from: b  reason: collision with root package name */
    private LinkedHashSet<h> f3818b = new LinkedHashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private List<Boolean> f3819c = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r2 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h a(boolean z, boolean z2) {
        Object a2;
        LinkedHashSet<h> linkedHashSet = z ? this.f3818b : this.f3817a;
        LinkedHashSet<h> linkedHashSet2 = z2 ? null : z ? this.f3817a : this.f3818b;
        if (linkedHashSet2 != null && !linkedHashSet2.isEmpty()) {
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                boolean z3 = false;
                if (this.f3819c.size() >= 2) {
                    int size = this.f3819c.size() - 1;
                    while (true) {
                        if (size < this.f3819c.size() - 2) {
                            z3 = true;
                            break;
                        } else if (this.f3819c.get(size).booleanValue() != z) {
                            break;
                        } else {
                            size--;
                        }
                    }
                }
            }
            a2 = a(linkedHashSet2);
            return (h) a2;
        }
        a2 = a(linkedHashSet);
        return (h) a2;
    }

    private static <T> T a(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> it = collection.iterator();
        if (it.hasNext()) {
            T next = it.next();
            collection.remove(next);
            return next;
        }
        return null;
    }

    public final h a(int i) {
        cn.jiguang.an.d.b("IpPool", "current ipv4List=" + this.f3817a + " ipv6List=" + this.f3818b);
        h a2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : a(true, false) : a(true, true) : a(false, true) : a(false, false);
        cn.jiguang.an.d.b("IpPool", "get ipPort=" + a2);
        if (a2 != null) {
            if (a2.f3822c instanceof Inet4Address) {
                this.f3819c.add(false);
            } else if (a2.f3822c instanceof Inet6Address) {
                this.f3819c.add(true);
            }
        }
        return a2;
    }

    public final void a() {
        try {
            this.f3817a.clear();
            this.f3818b.clear();
        } catch (Throwable unused) {
        }
    }

    public final boolean a(h hVar) {
        LinkedHashSet<h> linkedHashSet;
        if (hVar.a()) {
            if (hVar.f3822c instanceof Inet4Address) {
                linkedHashSet = this.f3817a;
            } else if (!(hVar.f3822c instanceof Inet6Address)) {
                return false;
            } else {
                linkedHashSet = this.f3818b;
            }
            return linkedHashSet.add(hVar);
        }
        return false;
    }
}
