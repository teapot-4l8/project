package androidx.coordinatorlayout.widget;

import androidx.b.g;
import androidx.core.g.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: DirectedAcyclicGraph.java */
/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a<ArrayList<T>> f1396a = new e.b(10);

    /* renamed from: b  reason: collision with root package name */
    private final g<T, ArrayList<T>> f1397b = new g<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<T> f1398c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<T> f1399d = new HashSet<>();

    public void a(T t) {
        if (this.f1397b.containsKey(t)) {
            return;
        }
        this.f1397b.put(t, null);
    }

    public boolean b(T t) {
        return this.f1397b.containsKey(t);
    }

    public void a(T t, T t2) {
        if (!this.f1397b.containsKey(t) || !this.f1397b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f1397b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f1397b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public List c(T t) {
        return this.f1397b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f1397b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> c2 = this.f1397b.c(i);
            if (c2 != null && c2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1397b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f1397b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> c2 = this.f1397b.c(i);
            if (c2 != null && c2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        int size = this.f1397b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> c2 = this.f1397b.c(i);
            if (c2 != null) {
                a((ArrayList) c2);
            }
        }
        this.f1397b.clear();
    }

    public ArrayList<T> b() {
        this.f1398c.clear();
        this.f1399d.clear();
        int size = this.f1397b.size();
        for (int i = 0; i < size; i++) {
            a(this.f1397b.b(i), this.f1398c, this.f1399d);
        }
        return this.f1398c;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.f1397b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private ArrayList<T> c() {
        ArrayList<T> a2 = this.f1396a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1396a.a(arrayList);
    }
}
