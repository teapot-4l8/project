package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f4662a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f4663b;

    /* renamed from: c  reason: collision with root package name */
    private T f4664c;

    protected abstract void a(T t);

    protected abstract T b(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.c.a.d
    public void c() {
    }

    public l(ContentResolver contentResolver, Uri uri) {
        this.f4663b = contentResolver;
        this.f4662a = uri;
    }

    @Override // com.bumptech.glide.c.a.d
    public final void a(com.bumptech.glide.g gVar, d.a<? super T> aVar) {
        try {
            T b2 = b(this.f4662a, this.f4663b);
            this.f4664c = b2;
            aVar.a((d.a<? super T>) b2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.c.a.d
    public void b() {
        T t = this.f4664c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.c.a.d
    public com.bumptech.glide.c.a d() {
        return com.bumptech.glide.c.a.LOCAL;
    }
}
