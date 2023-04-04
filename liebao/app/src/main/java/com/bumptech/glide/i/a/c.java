package com.bumptech.glide.i.a;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(boolean z);

    public abstract void b();

    public static c a() {
        return new a();
    }

    private c() {
    }

    /* compiled from: StateVerifier.java */
    /* loaded from: classes.dex */
    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f5243a;

        a() {
            super();
        }

        @Override // com.bumptech.glide.i.a.c
        public void b() {
            if (this.f5243a) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.i.a.c
        public void a(boolean z) {
            this.f5243a = z;
        }
    }
}
