package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzat {
    private static final Comparator<byte[]> zzcd = new zzaw();
    private final List<byte[]> zzbz = new ArrayList();
    private final List<byte[]> zzca = new ArrayList(64);
    private int zzcb = 0;
    private final int zzcc = 4096;

    public zzat(int i) {
    }

    public final synchronized byte[] zzf(int i) {
        for (int i2 = 0; i2 < this.zzca.size(); i2++) {
            byte[] bArr = this.zzca.get(i2);
            if (bArr.length >= i) {
                this.zzcb -= bArr.length;
                this.zzca.remove(i2);
                this.zzbz.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzcc) {
                this.zzbz.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzca, bArr, zzcd);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzca.add(binarySearch, bArr);
                this.zzcb += bArr.length;
                zzn();
            }
        }
    }

    private final synchronized void zzn() {
        while (this.zzcb > this.zzcc) {
            byte[] remove = this.zzbz.remove(0);
            this.zzca.remove(remove);
            this.zzcb -= remove.length;
        }
    }
}
