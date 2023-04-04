package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zztv extends PushbackInputStream {
    private final /* synthetic */ zztq zzbwq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztv(zztq zztqVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbwq = zztqVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.zzbwq.zzbwj.disconnect();
        super.close();
    }
}
