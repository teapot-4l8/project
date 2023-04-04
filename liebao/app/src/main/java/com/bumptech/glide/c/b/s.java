package com.bumptech.glide.c.b;

import androidx.core.g.e;
import com.bumptech.glide.c.b.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class s<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f4857a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f4858b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends h<Data, ResourceType, Transcode>> f4859c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4860d;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, e.a<List<Throwable>> aVar) {
        this.f4857a = cls;
        this.f4858b = aVar;
        this.f4859c = (List) com.bumptech.glide.i.i.a(list);
        this.f4860d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public u<Transcode> a(com.bumptech.glide.c.a.e<Data> eVar, com.bumptech.glide.c.j jVar, int i, int i2, h.a<ResourceType> aVar) {
        List<Throwable> list = (List) com.bumptech.glide.i.i.a(this.f4858b.a());
        try {
            return a(eVar, jVar, i, i2, aVar, list);
        } finally {
            this.f4858b.a(list);
        }
    }

    private u<Transcode> a(com.bumptech.glide.c.a.e<Data> eVar, com.bumptech.glide.c.j jVar, int i, int i2, h.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.f4859c.size();
        u<Transcode> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                uVar = this.f4859c.get(i3).a(eVar, i, i2, jVar, aVar);
            } catch (p e2) {
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.f4860d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4859c.toArray()) + '}';
    }
}
