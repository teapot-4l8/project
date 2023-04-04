package com.bumptech.glide.c.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c.c.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f4976a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: b  reason: collision with root package name */
    private final c<Data> f4977b;

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public interface c<Data> {
        com.bumptech.glide.c.a.d<Data> a(Uri uri);
    }

    public w(c<Data> cVar) {
        this.f4977b = cVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(Uri uri, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(uri), this.f4977b.a(uri));
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return f4976a.contains(uri.getScheme());
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4980a;

        public d(ContentResolver contentResolver) {
            this.f4980a = contentResolver;
        }

        @Override // com.bumptech.glide.c.c.w.c
        public com.bumptech.glide.c.a.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.c.a.n(this.f4980a, uri);
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4979a;

        public b(ContentResolver contentResolver) {
            this.f4979a = contentResolver;
        }

        @Override // com.bumptech.glide.c.c.w.c
        public com.bumptech.glide.c.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.c.a.i(this.f4979a, uri);
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4978a;

        public a(ContentResolver contentResolver) {
            this.f4978a = contentResolver;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // com.bumptech.glide.c.c.w.c
        public com.bumptech.glide.c.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.c.a.a(this.f4978a, uri);
        }
    }
}
