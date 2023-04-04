package com.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LogConfiguration.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f4530a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4531b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4532c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4533d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4534e;
    public final int f;
    public final boolean g;
    public final com.a.a.a.b.a.b h;
    public final com.a.a.a.b.d.b i;
    public final com.a.a.a.b.c.b j;
    public final com.a.a.a.d.b k;
    public final com.a.a.a.c.b l;
    public final com.a.a.a.a.a m;
    public final List<com.a.a.b.a> n;
    private final Map<Class<?>, com.a.a.a.b.b.c<?>> o;

    a(C0082a c0082a) {
        this.f4530a = c0082a.f4535a;
        this.f4531b = c0082a.f4536b;
        this.f4532c = c0082a.f4537c;
        this.f4533d = c0082a.f4538d;
        this.f4534e = c0082a.f4539e;
        this.f = c0082a.f;
        this.g = c0082a.g;
        this.h = c0082a.h;
        this.i = c0082a.i;
        this.j = c0082a.j;
        this.k = c0082a.k;
        this.l = c0082a.l;
        this.m = c0082a.m;
        this.o = c0082a.n;
        this.n = c0082a.o;
    }

    /* compiled from: LogConfiguration.java */
    /* renamed from: com.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0082a {

        /* renamed from: a  reason: collision with root package name */
        private int f4535a;

        /* renamed from: b  reason: collision with root package name */
        private String f4536b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4537c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4538d;

        /* renamed from: e  reason: collision with root package name */
        private String f4539e;
        private int f;
        private boolean g;
        private com.a.a.a.b.a.b h;
        private com.a.a.a.b.d.b i;
        private com.a.a.a.b.c.b j;
        private com.a.a.a.d.b k;
        private com.a.a.a.c.b l;
        private com.a.a.a.a.a m;
        private Map<Class<?>, com.a.a.a.b.b.c<?>> n;
        private List<com.a.a.b.a> o;

        public C0082a() {
            this.f4535a = Integer.MIN_VALUE;
            this.f4536b = "X-LOG";
        }

        public C0082a(a aVar) {
            this.f4535a = Integer.MIN_VALUE;
            this.f4536b = "X-LOG";
            this.f4535a = aVar.f4530a;
            this.f4536b = aVar.f4531b;
            this.f4537c = aVar.f4532c;
            this.f4538d = aVar.f4533d;
            this.f4539e = aVar.f4534e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            if (aVar.o != null) {
                this.n = new HashMap(aVar.o);
            }
            if (aVar.n != null) {
                this.o = new ArrayList(aVar.n);
            }
        }

        public C0082a a(int i) {
            this.f4535a = i;
            return this;
        }

        public C0082a a(String str) {
            this.f4536b = str;
            return this;
        }

        public C0082a a() {
            this.f4537c = true;
            return this;
        }

        public C0082a b() {
            this.f4537c = false;
            return this;
        }

        public C0082a a(String str, int i) {
            this.f4538d = true;
            this.f4539e = str;
            this.f = i;
            return this;
        }

        public C0082a c() {
            this.f4538d = false;
            this.f4539e = null;
            this.f = 0;
            return this;
        }

        public C0082a d() {
            this.g = true;
            return this;
        }

        public C0082a e() {
            this.g = false;
            return this;
        }

        public C0082a a(com.a.a.a.b.a.b bVar) {
            this.h = bVar;
            return this;
        }

        public C0082a a(com.a.a.a.b.d.b bVar) {
            this.i = bVar;
            return this;
        }

        public C0082a a(com.a.a.a.b.c.b bVar) {
            this.j = bVar;
            return this;
        }

        public C0082a a(com.a.a.a.d.b bVar) {
            this.k = bVar;
            return this;
        }

        public C0082a a(com.a.a.a.c.b bVar) {
            this.l = bVar;
            return this;
        }

        public C0082a a(com.a.a.a.a.a aVar) {
            this.m = aVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0082a a(Map<Class<?>, com.a.a.a.b.b.c<?>> map) {
            this.n = map;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0082a a(List<com.a.a.b.a> list) {
            this.o = list;
            return this;
        }

        public a f() {
            g();
            return new a(this);
        }

        private void g() {
            if (this.h == null) {
                this.h = com.a.a.c.a.a();
            }
            if (this.i == null) {
                this.i = com.a.a.c.a.b();
            }
            if (this.j == null) {
                this.j = com.a.a.c.a.c();
            }
            if (this.k == null) {
                this.k = com.a.a.c.a.d();
            }
            if (this.l == null) {
                this.l = com.a.a.c.a.e();
            }
            if (this.m == null) {
                this.m = com.a.a.c.a.f();
            }
            if (this.n == null) {
                this.n = new HashMap(com.a.a.c.a.g());
            }
        }
    }
}
