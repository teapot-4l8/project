package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzkt {
    private static final long[] zzatc = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzapk = new byte[8];

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjz zzjzVar, boolean z, boolean z2, int i) {
        if (this.state == 0) {
            if (!zzjzVar.zza(this.zzapk, 0, 1, z)) {
                return -1L;
            }
            int zzar = zzar(this.zzapk[0] & 255);
            this.length = zzar;
            if (zzar == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.state = 1;
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2L;
        }
        if (i2 != 1) {
            zzjzVar.readFully(this.zzapk, 1, i2 - 1);
        }
        this.state = 0;
        return zza(this.zzapk, this.length, z2);
    }

    public final int zzha() {
        return this.length;
    }

    public static int zzar(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = zzatc;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = bArr[0] & 255;
        if (z) {
            j &= zzatc[i - 1] ^ (-1);
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }
}
