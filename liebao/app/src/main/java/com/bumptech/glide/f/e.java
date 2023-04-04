package com.bumptech.glide.f;

import com.bumptech.glide.c.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f5164a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f5165b = new HashMap();

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f5164a);
        this.f5164a.clear();
        this.f5164a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f5164a.add(str);
            }
        }
    }

    public synchronized <T, R> List<k<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f5164a) {
            List<a<?, ?>> list = this.f5165b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f5167b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f5164a) {
            List<a<?, ?>> list = this.f5165b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f5166a)) {
                        arrayList.add(aVar.f5166a);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, kVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f5164a.contains(str)) {
            this.f5164a.add(str);
        }
        list = this.f5165b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f5165b.put(str, list);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceDecoderRegistry.java */
    /* loaded from: classes.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final Class<R> f5166a;

        /* renamed from: b  reason: collision with root package name */
        final k<T, R> f5167b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<T> f5168c;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.f5168c = cls;
            this.f5166a = cls2;
            this.f5167b = kVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f5168c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5166a);
        }
    }
}
