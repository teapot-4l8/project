package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzku {
    private final zzpn zzaqd = new zzpn(8);
    private int zzatd;

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009c, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(zzjz zzjzVar) {
        long length = zzjzVar.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        zzjzVar.zza(this.zzaqd.data, 0, 4);
        long zzjb = this.zzaqd.zzjb();
        this.zzatd = 4;
        while (zzjb != 440786851) {
            int i2 = this.zzatd + 1;
            this.zzatd = i2;
            if (i2 == i) {
                return false;
            }
            zzjzVar.zza(this.zzaqd.data, 0, 1);
            zzjb = ((zzjb << 8) & (-256)) | (this.zzaqd.data[0] & 255);
        }
        long zzc = zzc(zzjzVar);
        long j2 = this.zzatd;
        if (zzc != Long.MIN_VALUE && (length == -1 || j2 + zzc < length)) {
            while (true) {
                int i3 = this.zzatd;
                long j3 = j2 + zzc;
                if (i3 < j3) {
                    if (zzc(zzjzVar) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzc2 = zzc(zzjzVar);
                    if (zzc2 < 0 || zzc2 > 2147483647L) {
                        break;
                    } else if (zzc2 != 0) {
                        zzjzVar.zzak((int) zzc2);
                        this.zzatd = (int) (this.zzatd + zzc2);
                    }
                } else if (i3 == j3) {
                    return true;
                }
            }
        }
        return false;
    }

    private final long zzc(zzjz zzjzVar) {
        int i = 0;
        zzjzVar.zza(this.zzaqd.data, 0, 1);
        int i2 = this.zzaqd.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ (-1));
        zzjzVar.zza(this.zzaqd.data, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.zzaqd.data[i] & 255) + (i5 << 8);
        }
        this.zzatd += i4 + 1;
        return i5;
    }
}
