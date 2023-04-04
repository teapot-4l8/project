package com.bumptech.glide.c.d.a;

/* compiled from: DownsampleStrategy.java */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f5001a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final j f5002b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final j f5003c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final j f5004d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final j f5005e = new c();
    public static final j f = new f();
    public static final j g;
    public static final com.bumptech.glide.c.i<j> h;

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    public enum g {
        MEMORY,
        QUALITY
    }

    public abstract float a(int i, int i2, int i3, int i4);

    public abstract g b(int i, int i2, int i3, int i4);

    static {
        j jVar = f5002b;
        g = jVar;
        h = com.bumptech.glide.c.i.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jVar);
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class e extends j {
        e() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class d extends j {
        d() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class a extends j {
        a() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class b extends j {
        b() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.MEMORY;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class f extends j {
        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        f() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* loaded from: classes.dex */
    private static class c extends j {
        c() {
        }

        @Override // com.bumptech.glide.c.d.a.j
        public float a(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, f5001a.a(i, i2, i3, i4));
        }

        @Override // com.bumptech.glide.c.d.a.j
        public g b(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }
    }
}
