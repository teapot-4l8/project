package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbdz implements zzerm {
    private final ByteBuffer zzamu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdz(ByteBuffer byteBuffer) {
        this.zzamu = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzerm, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.zzerm
    public final int read(ByteBuffer byteBuffer) {
        if (this.zzamu.remaining() != 0 || byteBuffer.remaining() <= 0) {
            int min = Math.min(byteBuffer.remaining(), this.zzamu.remaining());
            byte[] bArr = new byte[min];
            this.zzamu.get(bArr);
            byteBuffer.put(bArr);
            return min;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzerm
    public final long size() {
        return this.zzamu.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzerm
    public final long position() {
        return this.zzamu.position();
    }

    @Override // com.google.android.gms.internal.ads.zzerm
    public final void zzfd(long j) {
        this.zzamu.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzerm
    public final ByteBuffer zzh(long j, long j2) {
        int position = this.zzamu.position();
        this.zzamu.position((int) j);
        ByteBuffer slice = this.zzamu.slice();
        slice.limit((int) j2);
        this.zzamu.position(position);
        return slice;
    }
}
