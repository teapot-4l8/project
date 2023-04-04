package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzhp {
    public final int index;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final zzib[] zzafu;
    private final zzhx zzafv;
    private final zzne zzagb;
    public int zzags;
    public long zzagt;
    public final zznc zzagw;
    public final Object zzagx;
    public final zznn[] zzagy;
    private final boolean[] zzagz;
    public final long zzaha;
    public boolean zzahb;
    public boolean zzahc;
    public boolean zzahd;
    public zzhp zzahe;
    public zzoj zzahf;
    private zzoj zzahg;

    public zzhp(zzhy[] zzhyVarArr, zzib[] zzibVarArr, long j, zzoh zzohVar, zzhx zzhxVar, zzne zzneVar, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaex = zzhyVarArr;
        this.zzafu = zzibVarArr;
        this.zzaha = j;
        this.zzaey = zzohVar;
        this.zzafv = zzhxVar;
        this.zzagb = zzneVar;
        this.zzagx = zzpg.checkNotNull(obj);
        this.index = i;
        this.zzags = i2;
        this.zzahb = z;
        this.zzagt = j2;
        this.zzagy = new zznn[zzhyVarArr.length];
        this.zzagz = new boolean[zzhyVarArr.length];
        this.zzagw = zzneVar.zza(i2, zzhxVar.zzfh());
    }

    public final long zzfa() {
        return this.zzaha - this.zzagt;
    }

    public final void zzc(int i, boolean z) {
        this.zzags = i;
        this.zzahb = z;
    }

    public final boolean zzfb() {
        if (this.zzahc) {
            return !this.zzahd || this.zzagw.zzhv() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzfc() {
        boolean z;
        zzoj zza = this.zzaey.zza(this.zzafu, this.zzagw.zzht());
        zzoj zzojVar = this.zzahg;
        if (zzojVar != null) {
            for (int i = 0; i < zza.zzbii.length; i++) {
                if (zza.zza(zzojVar, i)) {
                }
            }
            z = true;
            if (z) {
                this.zzahf = zza;
                return true;
            }
            return false;
        }
        z = false;
        if (z) {
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaex.length]);
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzoi zzoiVar = this.zzahf.zzbii;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzoiVar.length) {
                break;
            }
            boolean[] zArr2 = this.zzagz;
            if (z || !this.zzahf.zza(this.zzahg, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzagw.zza(zzoiVar.zziq(), this.zzagz, this.zzagy, zArr, j);
        this.zzahg = this.zzahf;
        this.zzahd = false;
        int i2 = 0;
        while (true) {
            zznn[] zznnVarArr = this.zzagy;
            if (i2 < zznnVarArr.length) {
                if (zznnVarArr[i2] != null) {
                    zzpg.checkState(zzoiVar.zzbh(i2) != null);
                    this.zzahd = true;
                } else {
                    zzpg.checkState(zzoiVar.zzbh(i2) == null);
                }
                i2++;
            } else {
                this.zzafv.zza(this.zzaex, this.zzahf.zzbih, zzoiVar);
                return zza;
            }
        }
    }

    public final void release() {
        try {
            this.zzagb.zzb(this.zzagw);
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
        }
    }
}
