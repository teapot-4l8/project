package androidx.lifecycle;

import androidx.lifecycle.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class m extends h {

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<l> f2022d;

    /* renamed from: b  reason: collision with root package name */
    private androidx.a.a.b.a<k, a> f2020b = new androidx.a.a.b.a<>();

    /* renamed from: e  reason: collision with root package name */
    private int f2023e = 0;
    private boolean f = false;
    private boolean g = false;
    private ArrayList<h.b> h = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private h.b f2021c = h.b.INITIALIZED;

    public m(l lVar) {
        this.f2022d = new WeakReference<>(lVar);
    }

    @Deprecated
    public void a(h.b bVar) {
        b(bVar);
    }

    public void b(h.b bVar) {
        c(bVar);
    }

    public void a(h.a aVar) {
        c(b(aVar));
    }

    private void c(h.b bVar) {
        if (this.f2021c == bVar) {
            return;
        }
        this.f2021c = bVar;
        if (this.f || this.f2023e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        d();
        this.f = false;
    }

    private boolean b() {
        if (this.f2020b.a() == 0) {
            return true;
        }
        h.b bVar = this.f2020b.d().getValue().f2026a;
        h.b bVar2 = this.f2020b.e().getValue().f2026a;
        return bVar == bVar2 && this.f2021c == bVar2;
    }

    private h.b c(k kVar) {
        Map.Entry<k, a> d2 = this.f2020b.d(kVar);
        h.b bVar = null;
        h.b bVar2 = d2 != null ? d2.getValue().f2026a : null;
        if (!this.h.isEmpty()) {
            ArrayList<h.b> arrayList = this.h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f2021c, bVar2), bVar);
    }

    @Override // androidx.lifecycle.h
    public void a(k kVar) {
        l lVar;
        a aVar = new a(kVar, this.f2021c == h.b.DESTROYED ? h.b.DESTROYED : h.b.INITIALIZED);
        if (this.f2020b.a(kVar, aVar) == null && (lVar = this.f2022d.get()) != null) {
            boolean z = this.f2023e != 0 || this.f;
            h.b c2 = c(kVar);
            this.f2023e++;
            while (aVar.f2026a.compareTo(c2) < 0 && this.f2020b.c(kVar)) {
                d(aVar.f2026a);
                aVar.a(lVar, f(aVar.f2026a));
                c();
                c2 = c(kVar);
            }
            if (!z) {
                d();
            }
            this.f2023e--;
        }
    }

    private void c() {
        ArrayList<h.b> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void d(h.b bVar) {
        this.h.add(bVar);
    }

    @Override // androidx.lifecycle.h
    public void b(k kVar) {
        this.f2020b.b(kVar);
    }

    @Override // androidx.lifecycle.h
    public h.b a() {
        return this.f2021c;
    }

    static h.b b(h.a aVar) {
        switch (AnonymousClass1.f2024a[aVar.ordinal()]) {
            case 1:
            case 2:
                return h.b.CREATED;
            case 3:
            case 4:
                return h.b.STARTED;
            case 5:
                return h.b.RESUMED;
            case 6:
                return h.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* renamed from: androidx.lifecycle.m$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2024a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2025b;

        static {
            int[] iArr = new int[h.b.values().length];
            f2025b = iArr;
            try {
                iArr[h.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2025b[h.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2025b[h.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2025b[h.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2025b[h.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[h.a.values().length];
            f2024a = iArr2;
            try {
                iArr2[h.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2024a[h.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2024a[h.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2024a[h.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2024a[h.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2024a[h.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2024a[h.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static h.a e(h.b bVar) {
        int i = AnonymousClass1.f2025b[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            throw new IllegalArgumentException();
                        }
                        throw new IllegalArgumentException("Unexpected state value " + bVar);
                    }
                    return h.a.ON_PAUSE;
                }
                return h.a.ON_STOP;
            }
            return h.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    private static h.a f(h.b bVar) {
        int i = AnonymousClass1.f2025b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return h.a.ON_START;
            }
            if (i == 3) {
                return h.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return h.a.ON_CREATE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(l lVar) {
        androidx.a.a.b.b<k, a>.d c2 = this.f2020b.c();
        while (c2.hasNext() && !this.g) {
            Map.Entry next = c2.next();
            a aVar = (a) next.getValue();
            while (aVar.f2026a.compareTo(this.f2021c) < 0 && !this.g && this.f2020b.c(next.getKey())) {
                d(aVar.f2026a);
                aVar.a(lVar, f(aVar.f2026a));
                c();
            }
        }
    }

    private void b(l lVar) {
        Iterator<Map.Entry<k, a>> b2 = this.f2020b.b();
        while (b2.hasNext() && !this.g) {
            Map.Entry<k, a> next = b2.next();
            a value = next.getValue();
            while (value.f2026a.compareTo(this.f2021c) > 0 && !this.g && this.f2020b.c(next.getKey())) {
                h.a e2 = e(value.f2026a);
                d(b(e2));
                value.a(lVar, e2);
                c();
            }
        }
    }

    private void d() {
        l lVar = this.f2022d.get();
        if (lVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!b()) {
            this.g = false;
            if (this.f2021c.compareTo(this.f2020b.d().getValue().f2026a) < 0) {
                b(lVar);
            }
            Map.Entry<k, a> e2 = this.f2020b.e();
            if (!this.g && e2 != null && this.f2021c.compareTo(e2.getValue().f2026a) > 0) {
                a(lVar);
            }
        }
        this.g = false;
    }

    static h.b a(h.b bVar, h.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LifecycleRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        h.b f2026a;

        /* renamed from: b  reason: collision with root package name */
        j f2027b;

        a(k kVar, h.b bVar) {
            this.f2027b = p.a(kVar);
            this.f2026a = bVar;
        }

        void a(l lVar, h.a aVar) {
            h.b b2 = m.b(aVar);
            this.f2026a = m.a(this.f2026a, b2);
            this.f2027b.onStateChanged(lVar, aVar);
            this.f2026a = b2;
        }
    }
}
