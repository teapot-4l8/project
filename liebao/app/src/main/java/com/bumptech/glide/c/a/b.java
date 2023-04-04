package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f4640a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f4641b;

    /* renamed from: c  reason: collision with root package name */
    private T f4642c;

    protected abstract T a(AssetManager assetManager, String str);

    protected abstract void a(T t);

    @Override // com.bumptech.glide.c.a.d
    public void c() {
    }

    public b(AssetManager assetManager, String str) {
        this.f4641b = assetManager;
        this.f4640a = str;
    }

    @Override // com.bumptech.glide.c.a.d
    public void a(com.bumptech.glide.g gVar, d.a<? super T> aVar) {
        try {
            T a2 = a(this.f4641b, this.f4640a);
            this.f4642c = a2;
            aVar.a((d.a<? super T>) a2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.c.a.d
    public void b() {
        T t = this.f4642c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.c.a.d
    public com.bumptech.glide.c.a d() {
        return com.bumptech.glide.c.a.LOCAL;
    }
}
