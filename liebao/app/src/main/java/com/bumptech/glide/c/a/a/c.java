package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.bumptech.glide.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.c.a.d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f4628a;

    /* renamed from: b  reason: collision with root package name */
    private final e f4629b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f4630c;

    @Override // com.bumptech.glide.c.a.d
    public void c() {
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.a(context).h().a(), dVar, com.bumptech.glide.c.a(context).b(), context.getContentResolver()));
    }

    c(Uri uri, e eVar) {
        this.f4628a = uri;
        this.f4629b = eVar;
    }

    @Override // com.bumptech.glide.c.a.d
    public void a(g gVar, d.a<? super InputStream> aVar) {
        try {
            InputStream e2 = e();
            this.f4630c = e2;
            aVar.a((d.a<? super InputStream>) e2);
        } catch (FileNotFoundException e3) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e3);
            }
            aVar.a((Exception) e3);
        }
    }

    private InputStream e() {
        InputStream b2 = this.f4629b.b(this.f4628a);
        int a2 = b2 != null ? this.f4629b.a(this.f4628a) : -1;
        return a2 != -1 ? new com.bumptech.glide.c.a.g(b2, a2) : b2;
    }

    @Override // com.bumptech.glide.c.a.d
    public void b() {
        InputStream inputStream = this.f4630c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.c.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.c.a.d
    public com.bumptech.glide.c.a d() {
        return com.bumptech.glide.c.a.LOCAL;
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f4633b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4634a;

        b(ContentResolver contentResolver) {
            this.f4634a = contentResolver;
        }

        @Override // com.bumptech.glide.c.a.a.d
        public Cursor a(Uri uri) {
            return this.f4634a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4633b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f4631b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f4632a;

        a(ContentResolver contentResolver) {
            this.f4632a = contentResolver;
        }

        @Override // com.bumptech.glide.c.a.a.d
        public Cursor a(Uri uri) {
            return this.f4632a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4631b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }
}
