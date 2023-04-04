package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zznu {
    public static final zznu zzbhf = new zznu(new zznr[0]);
    public final int length;
    private int zzaih;
    private final zznr[] zzbhg;

    public zznu(zznr... zznrVarArr) {
        this.zzbhg = zznrVarArr;
        this.length = zznrVarArr.length;
    }

    public final zznr zzbf(int i) {
        return this.zzbhg[i];
    }

    public final int zza(zznr zznrVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbhg[i] == zznrVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = Arrays.hashCode(this.zzbhg);
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznu zznuVar = (zznu) obj;
            if (this.length == zznuVar.length && Arrays.equals(this.zzbhg, zznuVar.zzbhg)) {
                return true;
            }
        }
        return false;
    }
}
