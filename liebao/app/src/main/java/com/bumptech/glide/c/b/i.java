package com.bumptech.glide.c.b;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f4809a = new i() { // from class: com.bumptech.glide.c.b.i.1
        @Override // com.bumptech.glide.c.b.i
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(com.bumptech.glide.c.a aVar) {
            return aVar == com.bumptech.glide.c.a.REMOTE;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar) {
            return (aVar == com.bumptech.glide.c.a.RESOURCE_DISK_CACHE || aVar == com.bumptech.glide.c.a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final i f4810b = new i() { // from class: com.bumptech.glide.c.b.i.2
        @Override // com.bumptech.glide.c.b.i
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(com.bumptech.glide.c.a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean b() {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final i f4811c = new i() { // from class: com.bumptech.glide.c.b.i.3
        @Override // com.bumptech.glide.c.b.i
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar) {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(com.bumptech.glide.c.a aVar) {
            return (aVar == com.bumptech.glide.c.a.DATA_DISK_CACHE || aVar == com.bumptech.glide.c.a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final i f4812d = new i() { // from class: com.bumptech.glide.c.b.i.4
        @Override // com.bumptech.glide.c.b.i
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(com.bumptech.glide.c.a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar) {
            return (aVar == com.bumptech.glide.c.a.RESOURCE_DISK_CACHE || aVar == com.bumptech.glide.c.a.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final i f4813e = new i() { // from class: com.bumptech.glide.c.b.i.5
        @Override // com.bumptech.glide.c.b.i
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(com.bumptech.glide.c.a aVar) {
            return aVar == com.bumptech.glide.c.a.REMOTE;
        }

        @Override // com.bumptech.glide.c.b.i
        public boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar) {
            return ((z && aVar == com.bumptech.glide.c.a.DATA_DISK_CACHE) || aVar == com.bumptech.glide.c.a.LOCAL) && cVar == com.bumptech.glide.c.c.TRANSFORMED;
        }
    };

    public abstract boolean a();

    public abstract boolean a(com.bumptech.glide.c.a aVar);

    public abstract boolean a(boolean z, com.bumptech.glide.c.a aVar, com.bumptech.glide.c.c cVar);

    public abstract boolean b();
}
