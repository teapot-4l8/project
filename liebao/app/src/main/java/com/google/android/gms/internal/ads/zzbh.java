package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbh extends ByteArrayOutputStream {
    private final zzat zzcg;

    public zzbh(zzat zzatVar, int i) {
        this.zzcg = zzatVar;
        this.buf = zzatVar.zzf(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zzcg.zza(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzcg.zza(this.buf);
    }

    private final void zzg(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] zzf = this.zzcg.zzf((this.count + i) << 1);
        System.arraycopy(this.buf, 0, zzf, 0, this.count);
        this.zzcg.zza(this.buf);
        this.buf = zzf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzg(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zzg(1);
        super.write(i);
    }
}
