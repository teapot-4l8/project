package androidx.work;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* compiled from: WorkRequest.java */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private UUID f3080a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.work.impl.b.j f3081b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f3082c;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(UUID uuid, androidx.work.impl.b.j jVar, Set<String> set) {
        this.f3080a = uuid;
        this.f3081b = jVar;
        this.f3082c = set;
    }

    public String a() {
        return this.f3080a.toString();
    }

    public androidx.work.impl.b.j b() {
        return this.f3081b;
    }

    public Set<String> c() {
        return this.f3082c;
    }

    /* compiled from: WorkRequest.java */
    /* loaded from: classes.dex */
    public static abstract class a<B extends a, W extends o> {

        /* renamed from: b  reason: collision with root package name */
        UUID f3084b;

        /* renamed from: c  reason: collision with root package name */
        androidx.work.impl.b.j f3085c;

        /* renamed from: a  reason: collision with root package name */
        boolean f3083a = false;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f3086d = new HashSet();

        abstract B c();

        abstract W d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Class<? extends ListenableWorker> cls) {
            UUID randomUUID = UUID.randomUUID();
            this.f3084b = randomUUID;
            this.f3085c = new androidx.work.impl.b.j(randomUUID.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(c cVar) {
            this.f3085c.j = cVar;
            return c();
        }

        public final B a(e eVar) {
            this.f3085c.f2868e = eVar;
            return c();
        }

        public final B a(String str) {
            this.f3086d.add(str);
            return c();
        }

        public final W e() {
            W d2 = d();
            this.f3084b = UUID.randomUUID();
            androidx.work.impl.b.j jVar = new androidx.work.impl.b.j(this.f3085c);
            this.f3085c = jVar;
            jVar.f2864a = this.f3084b.toString();
            return d2;
        }
    }
}
