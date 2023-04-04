package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzjp extends zzji {
    public long zzaov;
    public ByteBuffer zzdr;
    public final zzjl zzaou = new zzjl();
    private final int zzaow = 0;

    public zzjp(int i) {
    }

    public final void zzag(int i) {
        ByteBuffer byteBuffer = this.zzdr;
        if (byteBuffer == null) {
            this.zzdr = zzah(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzdr.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        ByteBuffer zzah = zzah(i2);
        if (position > 0) {
            this.zzdr.position(0);
            this.zzdr.limit(position);
            zzah.put(this.zzdr);
        }
        this.zzdr = zzah;
    }

    public final boolean isEncrypted() {
        return zzae(1073741824);
    }

    @Override // com.google.android.gms.internal.ads.zzji
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzdr;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private final ByteBuffer zzah(int i) {
        ByteBuffer byteBuffer = this.zzdr;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
