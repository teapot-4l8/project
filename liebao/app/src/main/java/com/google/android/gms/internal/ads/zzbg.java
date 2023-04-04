package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbg extends FilterInputStream {
    private final HttpURLConnection zzcx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzbg(HttpURLConnection httpURLConnection) {
        super(r0);
        InputStream zza;
        zza = zzbd.zza(httpURLConnection);
        this.zzcx = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        this.zzcx.disconnect();
    }
}
