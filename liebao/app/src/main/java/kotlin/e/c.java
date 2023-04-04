package kotlin.e;

import kotlin.d.b.g;

/* compiled from: Random.kt */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: b  reason: collision with root package name */
    public static final b f7166b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private static final c f7167c = kotlin.b.b.f7144a.a();

    /* renamed from: a  reason: collision with root package name */
    public static final a f7165a = a.f7168c;

    public abstract int a(int i);

    public int b() {
        return a(32);
    }

    public int a(int i, int i2) {
        int b2;
        int i3;
        int i4;
        d.b(i, i2);
        int i5 = i2 - i;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                i4 = a(d.a(i5));
            } else {
                do {
                    b2 = b() >>> 1;
                    i3 = b2 % i5;
                } while ((b2 - i3) + (i5 - 1) < 0);
                i4 = i3;
            }
            return i + i4;
        }
        while (true) {
            int b3 = b();
            if (i <= b3 && i2 > b3) {
                return b3;
            }
        }
    }

    /* compiled from: Random.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        @Override // kotlin.e.c
        public int a(int i) {
            return c.f7167c.a(i);
        }

        @Override // kotlin.e.c
        public int b() {
            return c.f7167c.b();
        }

        @Override // kotlin.e.c
        public int a(int i, int i2) {
            return c.f7167c.a(i, i2);
        }
    }

    /* compiled from: Random.kt */
    /* loaded from: classes2.dex */
    public static final class a extends c {

        /* renamed from: c  reason: collision with root package name */
        public static final a f7168c = new a();

        private a() {
        }

        @Override // kotlin.e.c
        public int a(int i) {
            return c.f7166b.a(i);
        }
    }
}
