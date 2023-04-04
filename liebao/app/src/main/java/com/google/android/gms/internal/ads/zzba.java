package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzba extends FilterInputStream {
    private final long zzco;
    private long zzcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(InputStream inputStream, long j) {
        super(inputStream);
        this.zzco = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.zzcp++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.zzcp += read;
        }
        return read;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzp() {
        return this.zzco - this.zzcp;
    }
}
