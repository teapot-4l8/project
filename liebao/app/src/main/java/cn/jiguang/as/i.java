package cn.jiguang.as;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private List f3899a;

    /* renamed from: b  reason: collision with root package name */
    private short f3900b;

    /* renamed from: c  reason: collision with root package name */
    private short f3901c;

    public i() {
        this.f3899a = new ArrayList(1);
        this.f3900b = (short) 0;
        this.f3901c = (short) 0;
    }

    public i(j jVar) {
        this();
        b(jVar);
    }

    private static String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            stringBuffer.append("[");
            stringBuffer.append(((j) it.next()).a());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int i;
        List subList;
        int size = this.f3899a.size();
        int i2 = z ? size - this.f3900b : this.f3900b;
        if (i2 == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i = size - this.f3900b;
        } else if (z2) {
            if (this.f3901c >= i2) {
                this.f3901c = (short) 0;
            }
            i = this.f3901c;
            this.f3901c = (short) (i + 1);
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList(i2);
        if (z) {
            arrayList.addAll(this.f3899a.subList(i, i2));
            if (i != 0) {
                subList = this.f3899a.subList(0, i);
            }
            return arrayList.iterator();
        }
        subList = this.f3899a.subList(i, size);
        arrayList.addAll(subList);
        return arrayList.iterator();
    }

    private void b(j jVar) {
        if (this.f3900b == 0) {
            this.f3899a.add(jVar);
            return;
        }
        List list = this.f3899a;
        list.add(list.size() - this.f3900b, jVar);
    }

    private synchronized long c() {
        return b().f();
    }

    public final synchronized Iterator a() {
        return a(true, true);
    }

    public final synchronized void a(j jVar) {
        if (this.f3899a.size() == 0) {
            b(jVar);
            return;
        }
        j b2 = b();
        if (!jVar.a(b2)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (jVar.f() != b2.f()) {
            if (jVar.f() > b2.f()) {
                jVar = jVar.g();
                jVar.a(b2.f());
            } else {
                for (int i = 0; i < this.f3899a.size(); i++) {
                    j g = ((j) this.f3899a.get(i)).g();
                    g.a(jVar.f());
                    this.f3899a.set(i, g);
                }
            }
        }
        if (!this.f3899a.contains(jVar)) {
            b(jVar);
        }
    }

    public final synchronized j b() {
        if (this.f3899a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (j) this.f3899a.get(0);
    }

    public final String toString() {
        if (this.f3899a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        stringBuffer.append(b().b() + " ");
        stringBuffer.append(c() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.f3900b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
