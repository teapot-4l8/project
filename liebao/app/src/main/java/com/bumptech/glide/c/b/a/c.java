package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f4680a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f4681b = new h<>();

    @Override // com.bumptech.glide.c.b.a.l
    public void a(Bitmap bitmap) {
        this.f4681b.a(this.f4680a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.c.b.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f4681b.a((h<a, Bitmap>) this.f4680a.a(i, i2, config));
    }

    @Override // com.bumptech.glide.c.b.a.l
    public Bitmap a() {
        return this.f4681b.a();
    }

    @Override // com.bumptech.glide.c.b.a.l
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.c.b.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    @Override // com.bumptech.glide.c.b.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.i.j.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f4681b;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    static class b extends d<a> {
        b() {
        }

        a a(int i, int i2, Bitmap.Config config) {
            a c2 = c();
            c2.a(i, i2, config);
            return c2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.c.b.a.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AttributeStrategy.java */
    /* loaded from: classes.dex */
    public static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f4682a;

        /* renamed from: b  reason: collision with root package name */
        private int f4683b;

        /* renamed from: c  reason: collision with root package name */
        private int f4684c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f4685d;

        public a(b bVar) {
            this.f4682a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f4683b = i;
            this.f4684c = i2;
            this.f4685d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f4683b == aVar.f4683b && this.f4684c == aVar.f4684c && this.f4685d == aVar.f4685d;
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f4683b * 31) + this.f4684c) * 31;
            Bitmap.Config config = this.f4685d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f4683b, this.f4684c, this.f4685d);
        }

        @Override // com.bumptech.glide.c.b.a.m
        public void a() {
            this.f4682a.a(this);
        }
    }
}
