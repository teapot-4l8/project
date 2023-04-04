package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zznr {
    public final int length;
    private int zzaih;
    private final zzht[] zzbgb;

    public zznr(zzht... zzhtVarArr) {
        zzpg.checkState(zzhtVarArr.length > 0);
        this.zzbgb = zzhtVarArr;
        this.length = zzhtVarArr.length;
    }

    public final zzht zzbe(int i) {
        return this.zzbgb[i];
    }

    public final int zzh(zzht zzhtVar) {
        int i = 0;
        while (true) {
            zzht[] zzhtVarArr = this.zzbgb;
            if (i >= zzhtVarArr.length) {
                return -1;
            }
            if (zzhtVar == zzhtVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = Arrays.hashCode(this.zzbgb) + 527;
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznr zznrVar = (zznr) obj;
            if (this.length == zznrVar.length && Arrays.equals(this.zzbgb, zznrVar.zzbgb)) {
                return true;
            }
        }
        return false;
    }
}
