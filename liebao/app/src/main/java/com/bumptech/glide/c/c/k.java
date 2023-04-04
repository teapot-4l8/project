package com.bumptech.glide.c.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.c.c.n;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4932a;

    public k(Context context) {
        this.f4932a = context;
    }

    @Override // com.bumptech.glide.c.c.n
    public n.a<File> a(Uri uri, int i, int i2, com.bumptech.glide.c.j jVar) {
        return new n.a<>(new com.bumptech.glide.h.b(uri), new b(this.f4932a, uri));
    }

    @Override // com.bumptech.glide.c.c.n
    public boolean a(Uri uri) {
        return com.bumptech.glide.c.a.a.b.a(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements com.bumptech.glide.c.a.d<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f4934a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f4935b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f4936c;

        @Override // com.bumptech.glide.c.a.d
        public void b() {
        }

        @Override // com.bumptech.glide.c.a.d
        public void c() {
        }

        b(Context context, Uri uri) {
            this.f4935b = context;
            this.f4936c = uri;
        }

        @Override // com.bumptech.glide.c.a.d
        public void a(com.bumptech.glide.g gVar, d.a<? super File> aVar) {
            Cursor query = this.f4935b.getContentResolver().query(this.f4936c, f4934a, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f4936c));
                return;
            }
            aVar.a((d.a<? super File>) new File(r0));
        }

        @Override // com.bumptech.glide.c.a.d
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.c.a.d
        public com.bumptech.glide.c.a d() {
            return com.bumptech.glide.c.a.LOCAL;
        }
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f4933a;

        public a(Context context) {
            this.f4933a = context;
        }

        @Override // com.bumptech.glide.c.c.o
        public n<Uri, File> a(r rVar) {
            return new k(this.f4933a);
        }
    }
}
