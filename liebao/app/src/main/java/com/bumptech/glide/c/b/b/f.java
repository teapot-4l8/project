package com.bumptech.glide.c.b.b;

import android.content.Context;
import com.bumptech.glide.c.b.b.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(final Context context, final String str, long j) {
        super(new d.a() { // from class: com.bumptech.glide.c.b.b.f.1
            @Override // com.bumptech.glide.c.b.b.d.a
            public File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}