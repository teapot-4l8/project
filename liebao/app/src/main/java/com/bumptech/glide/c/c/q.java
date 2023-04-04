package com.bumptech.glide.c.c;

import androidx.core.g.e;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f4950a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f4951b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(List<n<Model, Data>> list, e.a<List<Throwable>> aVar) {
        this.f4950a = list;
        this.f4951b = aVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Model model, int i, int i2, com.bumptech.glide.c.j jVar) {
        n.a<Data> a2;
        int size = this.f4950a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.c.h hVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            n<Model, Data> nVar = this.f4950a.get(i3);
            if (nVar.a(model) && (a2 = nVar.a(model, i, i2, jVar)) != null) {
                hVar = a2.f4943a;
                arrayList.add(a2.f4945c);
            }
        }
        if (arrayList.isEmpty() || hVar == null) {
            return null;
        }
        return new n.a<>(hVar, new a(arrayList, this.f4951b));
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Model model) {
        for (n<Model, Data> nVar : this.f4950a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f4950a.toArray()) + '}';
    }

    /* compiled from: MultiModelLoader.java */
    /* loaded from: classes.dex */
    static class a<Data> implements com.bumptech.glide.c.a.d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.bumptech.glide.c.a.d<Data>> f4952a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a<List<Throwable>> f4953b;

        /* renamed from: c  reason: collision with root package name */
        private int f4954c;

        /* renamed from: d  reason: collision with root package name */
        private com.bumptech.glide.g f4955d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f4956e;
        private List<Throwable> f;

        a(List<com.bumptech.glide.c.a.d<Data>> list, e.a<List<Throwable>> aVar) {
            this.f4953b = aVar;
            com.bumptech.glide.i.i.a(list);
            this.f4952a = list;
            this.f4954c = 0;
        }

        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            this.f4955d = gVar;
            this.f4956e = aVar;
            this.f = this.f4953b.a();
            this.f4952a.get(this.f4954c).a(gVar, this);
        }

        @Override // com.bumptech.glide.c.a.d
        public void b() {
            List<Throwable> list = this.f;
            if (list != null) {
                this.f4953b.a(list);
            }
            this.f = null;
            for (com.bumptech.glide.c.a.d<Data> dVar : this.f4952a) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public void c() {
            for (com.bumptech.glide.c.a.d<Data> dVar : this.f4952a) {
                dVar.c();
            }
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<Data> a() {
            return this.f4952a.get(0).a();
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return this.f4952a.get(0).d();
        }

        @Override // com.bumptech.glide.c.a.d.a
        public void a(Data data) {
            if (data != null) {
                this.f4956e.a((d.a<? super Data>) data);
            } else {
                e();
            }
        }

        @Override // com.bumptech.glide.c.a.d.a
        public void a(Exception exc) {
            ((List) com.bumptech.glide.i.i.a(this.f)).add(exc);
            e();
        }

        private void e() {
            if (this.f4954c < this.f4952a.size() - 1) {
                this.f4954c++;
                a(this.f4955d, this.f4956e);
                return;
            }
            com.bumptech.glide.i.i.a(this.f);
            this.f4956e.a((Exception) new com.bumptech.glide.c.b.p("Fetch failed", new ArrayList(this.f)));
        }
    }
}
