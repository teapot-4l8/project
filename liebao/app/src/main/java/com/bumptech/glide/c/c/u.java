package com.bumptech.glide.c.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f4972a;

    @Override // com.bumptech.glide.c.c.n
    public boolean a(String str) {
        return true;
    }

    public u(n<Uri, Data> nVar) {
        this.f4972a = nVar;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<Data> a(String str, int i, int i2, com.bumptech.glide.c.j jVar) {
        Uri b2 = b(str);
        if (b2 == null || !this.f4972a.a(b2)) {
            return null;
        }
        return this.f4972a.a(b2, i, i2, jVar);
    }

    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? c(str) : parse;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<String, InputStream> {
        @Override // com.bumptech.glide.c.c.o
        public n<String, InputStream> a(r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.c.c.o
        public n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.c.c.o
        public n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }
}
