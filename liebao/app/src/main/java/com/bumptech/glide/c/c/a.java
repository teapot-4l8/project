package com.bumptech.glide.c.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c.c.n;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4886a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f4887b;

    /* renamed from: c  reason: collision with root package name */
    private final InterfaceC0089a<Data> f4888c;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a<Data> {
        com.bumptech.glide.c.a.d<Data> a(AssetManager assetManager, String str);
    }

    public a(AssetManager assetManager, InterfaceC0089a<Data> interfaceC0089a) {
        this.f4887b = assetManager;
        this.f4888c = interfaceC0089a;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(uri), this.f4888c.a(this.f4887b, uri.toString().substring(f4886a)));
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class c implements InterfaceC0089a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f4895a;

        public c(AssetManager assetManager) {
            this.f4895a = assetManager;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f4895a, this);
        }

        @Override // com.bumptech.glide.c.c.a.InterfaceC0089a
        public com.bumptech.glide.c.a.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.c.a.m(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements InterfaceC0089a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f4892a;

        public b(AssetManager assetManager) {
            this.f4892a = assetManager;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f4892a, this);
        }

        @Override // com.bumptech.glide.c.c.a.InterfaceC0089a
        public com.bumptech.glide.c.a.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.c.a.h(assetManager, str);
        }
    }
}
