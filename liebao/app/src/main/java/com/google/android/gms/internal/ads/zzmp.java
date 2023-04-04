package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmp implements zznq {
    private final zznq[] zzbdu;

    public zzmp(zznq[] zznqVarArr) {
        this.zzbdu = zznqVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznq
    public final long zzhr() {
        long j = Long.MAX_VALUE;
        for (zznq zznqVar : this.zzbdu) {
            long zzhr = zznqVar.zzhr();
            if (zzhr != Long.MIN_VALUE) {
                j = Math.min(j, zzhr);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j) {
        zznq[] zznqVarArr;
        boolean z;
        boolean z2 = false;
        do {
            long zzhr = zzhr();
            if (zzhr == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznq zznqVar : this.zzbdu) {
                if (zznqVar.zzhr() == zzhr) {
                    z |= zznqVar.zzee(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
