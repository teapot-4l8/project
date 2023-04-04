package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import java.util.ArrayList;

/* compiled from: Snapshot.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private int f1313a;

    /* renamed from: b  reason: collision with root package name */
    private int f1314b;

    /* renamed from: c  reason: collision with root package name */
    private int f1315c;

    /* renamed from: d  reason: collision with root package name */
    private int f1316d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a> f1317e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Snapshot.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f1318a;

        /* renamed from: b  reason: collision with root package name */
        private e f1319b;

        /* renamed from: c  reason: collision with root package name */
        private int f1320c;

        /* renamed from: d  reason: collision with root package name */
        private e.b f1321d;

        /* renamed from: e  reason: collision with root package name */
        private int f1322e;

        public a(e eVar) {
            this.f1318a = eVar;
            this.f1319b = eVar.g();
            this.f1320c = eVar.e();
            this.f1321d = eVar.f();
            this.f1322e = eVar.h();
        }

        public void a(f fVar) {
            e a2 = fVar.a(this.f1318a.d());
            this.f1318a = a2;
            if (a2 != null) {
                this.f1319b = a2.g();
                this.f1320c = this.f1318a.e();
                this.f1321d = this.f1318a.f();
                this.f1322e = this.f1318a.h();
                return;
            }
            this.f1319b = null;
            this.f1320c = 0;
            this.f1321d = e.b.STRONG;
            this.f1322e = 0;
        }

        public void b(f fVar) {
            fVar.a(this.f1318a.d()).a(this.f1319b, this.f1320c, this.f1321d, this.f1322e);
        }
    }

    public p(f fVar) {
        this.f1313a = fVar.n();
        this.f1314b = fVar.o();
        this.f1315c = fVar.p();
        this.f1316d = fVar.r();
        ArrayList<e> C = fVar.C();
        int size = C.size();
        for (int i = 0; i < size; i++) {
            this.f1317e.add(new a(C.get(i)));
        }
    }

    public void a(f fVar) {
        this.f1313a = fVar.n();
        this.f1314b = fVar.o();
        this.f1315c = fVar.p();
        this.f1316d = fVar.r();
        int size = this.f1317e.size();
        for (int i = 0; i < size; i++) {
            this.f1317e.get(i).a(fVar);
        }
    }

    public void b(f fVar) {
        fVar.h(this.f1313a);
        fVar.i(this.f1314b);
        fVar.j(this.f1315c);
        fVar.k(this.f1316d);
        int size = this.f1317e.size();
        for (int i = 0; i < size; i++) {
            this.f1317e.get(i).b(fVar);
        }
    }
}
