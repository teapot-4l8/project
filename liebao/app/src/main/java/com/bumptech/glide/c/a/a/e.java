package com.bumptech.glide.c.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f4635a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final a f4636b;

    /* renamed from: c  reason: collision with root package name */
    private final d f4637c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f4638d;

    /* renamed from: e  reason: collision with root package name */
    private final ContentResolver f4639e;
    private final List<f> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<f> list, d dVar, com.bumptech.glide.c.b.a.b bVar, ContentResolver contentResolver) {
        this(list, f4635a, dVar, bVar, contentResolver);
    }

    e(List<f> list, a aVar, d dVar, com.bumptech.glide.c.b.a.b bVar, ContentResolver contentResolver) {
        this.f4636b = aVar;
        this.f4637c = dVar;
        this.f4638d = bVar;
        this.f4639e = contentResolver;
        this.f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f4639e.openInputStream(uri);
                int b2 = g.b(this.f, inputStream, this.f4638d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b2;
            } catch (IOException | NullPointerException e2) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream b(Uri uri) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File a2 = this.f4636b.a(c2);
        if (a(a2)) {
            Uri fromFile = Uri.fromFile(a2);
            try {
                return this.f4639e.openInputStream(fromFile);
            } catch (NullPointerException e2) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
            }
        }
        return null;
    }

    private String c(Uri uri) {
        Cursor a2 = this.f4637c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    return a2.getString(0);
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }

    private boolean a(File file) {
        return this.f4636b.a(file) && 0 < this.f4636b.b(file);
    }
}
