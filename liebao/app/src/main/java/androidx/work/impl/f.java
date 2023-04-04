package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.k;
import androidx.work.l;
import androidx.work.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: WorkContinuationImpl.java */
/* loaded from: classes.dex */
public class f extends l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2964a = androidx.work.h.a("WorkContinuationImpl");

    /* renamed from: b  reason: collision with root package name */
    private final h f2965b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2966c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.f f2967d;

    /* renamed from: e  reason: collision with root package name */
    private final List<? extends o> f2968e;
    private final List<String> f;
    private final List<String> g;
    private final List<f> h;
    private boolean i;
    private k j;

    public h a() {
        return this.f2965b;
    }

    public String b() {
        return this.f2966c;
    }

    public androidx.work.f c() {
        return this.f2967d;
    }

    public List<? extends o> d() {
        return this.f2968e;
    }

    public List<String> e() {
        return this.f;
    }

    public boolean f() {
        return this.i;
    }

    public void g() {
        this.i = true;
    }

    public List<f> h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar, List<? extends o> list) {
        this(hVar, null, androidx.work.f.KEEP, list, null);
    }

    f(h hVar, String str, androidx.work.f fVar, List<? extends o> list, List<f> list2) {
        this.f2965b = hVar;
        this.f2966c = str;
        this.f2967d = fVar;
        this.f2968e = list;
        this.h = list2;
        this.f = new ArrayList(this.f2968e.size());
        this.g = new ArrayList();
        if (list2 != null) {
            for (f fVar2 : list2) {
                this.g.addAll(fVar2.g);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String a2 = list.get(i).a();
            this.f.add(a2);
            this.g.add(a2);
        }
    }

    public k i() {
        if (!this.i) {
            androidx.work.impl.utils.b bVar = new androidx.work.impl.utils.b(this);
            this.f2965b.g().a(bVar);
            this.j = bVar.a();
        } else {
            androidx.work.h.a().d(f2964a, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f)), new Throwable[0]);
        }
        return this.j;
    }

    public boolean j() {
        return a(this, new HashSet());
    }

    private static boolean a(f fVar, Set<String> set) {
        set.addAll(fVar.e());
        Set<String> a2 = a(fVar);
        for (String str : set) {
            if (a2.contains(str)) {
                return true;
            }
        }
        List<f> h = fVar.h();
        if (h != null && !h.isEmpty()) {
            for (f fVar2 : h) {
                if (a(fVar2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(fVar.e());
        return false;
    }

    public static Set<String> a(f fVar) {
        HashSet hashSet = new HashSet();
        List<f> h = fVar.h();
        if (h != null && !h.isEmpty()) {
            for (f fVar2 : h) {
                hashSet.addAll(fVar2.e());
            }
        }
        return hashSet;
    }
}
