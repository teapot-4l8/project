package com.bumptech.glide.c.b;

import android.util.Log;
import androidx.core.g.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class h<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<DataType> f4804a;

    /* renamed from: b  reason: collision with root package name */
    private final List<? extends com.bumptech.glide.c.k<DataType, ResourceType>> f4805b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.c.d.f.e<ResourceType, Transcode> f4806c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a<List<Throwable>> f4807d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4808e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodePath.java */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        u<ResourceType> a(u<ResourceType> uVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.c.k<DataType, ResourceType>> list, com.bumptech.glide.c.d.f.e<ResourceType, Transcode> eVar, e.a<List<Throwable>> aVar) {
        this.f4804a = cls;
        this.f4805b = list;
        this.f4806c = eVar;
        this.f4807d = aVar;
        this.f4808e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public u<Transcode> a(com.bumptech.glide.c.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.c.j jVar, a<ResourceType> aVar) {
        return this.f4806c.a(aVar.a(a(eVar, i, i2, jVar)), jVar);
    }

    private u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.c.j jVar) {
        List<Throwable> list = (List) com.bumptech.glide.i.i.a(this.f4807d.a());
        try {
            return a(eVar, i, i2, jVar, list);
        } finally {
            this.f4807d.a(list);
        }
    }

    private u<ResourceType> a(com.bumptech.glide.c.a.e<DataType> eVar, int i, int i2, com.bumptech.glide.c.j jVar, List<Throwable> list) {
        int size = this.f4805b.size();
        u<ResourceType> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            com.bumptech.glide.c.k<DataType, ResourceType> kVar = this.f4805b.get(i3);
            try {
                if (kVar.a(eVar.a(), jVar)) {
                    uVar = kVar.a(eVar.a(), i, i2, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + kVar, e2);
                }
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.f4808e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f4804a + ", decoders=" + this.f4805b + ", transcoder=" + this.f4806c + '}';
    }
}
