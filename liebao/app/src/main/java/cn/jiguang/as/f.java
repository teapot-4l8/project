package cn.jiguang.as;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static j[] f3884d = new j[0];

    /* renamed from: e  reason: collision with root package name */
    private static i[] f3885e = new i[0];

    /* renamed from: a  reason: collision with root package name */
    private e f3886a;

    /* renamed from: b  reason: collision with root package name */
    private List[] f3887b;

    /* renamed from: c  reason: collision with root package name */
    private int f3888c;

    public f() {
        this(new e());
    }

    private f(c cVar) {
        this(new e(cVar));
        for (int i = 0; i < 4; i++) {
            try {
                int b2 = this.f3886a.b(i);
                if (b2 > 0) {
                    this.f3887b[i] = new ArrayList(b2);
                }
                for (int i2 = 0; i2 < b2; i2++) {
                    this.f3887b[i].add(j.a(cVar, i));
                }
            } catch (IOException e2) {
                throw e2;
            }
        }
        this.f3888c = cVar.a();
    }

    private f(e eVar) {
        this.f3887b = new List[4];
        this.f3886a = eVar;
    }

    public f(byte[] bArr) {
        this(new c(bArr));
    }

    public static f a(j jVar) {
        f fVar = new f();
        List[] listArr = fVar.f3887b;
        if (listArr[0] == null) {
            listArr[0] = new LinkedList();
        }
        fVar.f3886a.a(0);
        fVar.f3887b[0].add(jVar);
        return fVar;
    }

    public final j a() {
        List list = this.f3887b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (j) list.get(0);
    }

    public final i[] a(int i) {
        j[] jVarArr;
        boolean z;
        if (this.f3887b[1] == null) {
            return f3885e;
        }
        LinkedList linkedList = new LinkedList();
        List[] listArr = this.f3887b;
        if (listArr[1] == null) {
            jVarArr = f3884d;
        } else {
            List list = listArr[1];
            jVarArr = (j[]) list.toArray(new j[list.size()]);
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jVarArr.length; i2++) {
            h b2 = jVarArr[i2].b();
            if (hashSet.contains(b2)) {
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    i iVar = (i) linkedList.get(size);
                    if (iVar.b().d() == jVarArr[i2].d() && iVar.b().e() == jVarArr[i2].e() && iVar.b().b().equals(b2)) {
                        iVar.a(jVarArr[i2]);
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                linkedList.add(new i(jVarArr[i2]));
                hashSet.add(b2);
            }
        }
        return (i[]) linkedList.toArray(new i[linkedList.size()]);
    }

    public final byte[] b(int i) {
        d dVar = new d();
        this.f3886a.a(dVar);
        a aVar = new a();
        this.f3886a.a();
        for (int i2 = 0; i2 < 4; i2++) {
            List[] listArr = this.f3887b;
            if (listArr[i2] != null) {
                int size = listArr[i2].size();
                int a2 = dVar.a();
                j jVar = null;
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        j jVar2 = (j) this.f3887b[i2].get(i3);
                        if (i2 != 3) {
                            if (jVar != null) {
                                if (!(jVar2.d() == jVar.d() && jVar2.e() == jVar.e() && jVar2.b().equals(jVar.b()))) {
                                    a2 = dVar.a();
                                }
                            }
                            jVar2.a(dVar, aVar);
                            if (dVar.a() > 65535) {
                                dVar.a(a2);
                                break;
                            }
                            jVar = jVar2;
                        }
                        i3++;
                    }
                }
            }
        }
        this.f3888c = dVar.a();
        return dVar.b();
    }

    public final Object clone() {
        f fVar = new f();
        int i = 0;
        while (true) {
            List[] listArr = this.f3887b;
            if (i >= listArr.length) {
                fVar.f3886a = (e) this.f3886a.clone();
                fVar.f3888c = this.f3888c;
                return fVar;
            }
            if (listArr[i] != null) {
                fVar.f3887b[i] = new LinkedList(this.f3887b[i]);
            }
            i++;
        }
    }
}
