package com.google.android.gms.internal.ads;

import com.tencent.bugly.BuglyStrategy;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbdo implements zzhx {
    private int zzbir;
    private final zzor zzeqx;
    private long zzeqy;
    private long zzeqz;
    private long zzera;
    private long zzerb;
    private boolean zzerc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdo() {
        this(15000, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, 2500L, 5000L);
    }

    private zzbdo(int i, int i2, long j, long j2) {
        this.zzeqx = new zzor(true, 65536);
        this.zzeqy = 15000000L;
        this.zzeqz = 30000000L;
        this.zzera = 2500000L;
        this.zzerb = 5000000L;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzff() {
        zzl(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zza(zzhy[] zzhyVarArr, zznu zznuVar, zzoi zzoiVar) {
        this.zzbir = 0;
        for (int i = 0; i < zzhyVarArr.length; i++) {
            if (zzoiVar.zzbh(i) != null) {
                this.zzbir += zzpt.zzbs(zzhyVarArr[i].getTrackType());
            }
        }
        this.zzeqx.zzbi(this.zzbir);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void onStopped() {
        zzl(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final void zzfg() {
        zzl(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final zzol zzfh() {
        return this.zzeqx;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzerb : this.zzera;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.gms.internal.ads.zzhx
    public final synchronized boolean zzdt(long j) {
        boolean z;
        char c2;
        z = false;
        if (j > this.zzeqz) {
            c2 = 0;
        } else {
            c2 = j < this.zzeqy ? (char) 2 : (char) 1;
        }
        boolean z2 = this.zzeqx.zziu() >= this.zzbir;
        if (c2 == 2 || (c2 == 1 && this.zzerc && !z2)) {
            z = true;
        }
        this.zzerc = z;
        return z;
    }

    public final synchronized void zzea(int i) {
        this.zzeqy = i * 1000;
    }

    public final synchronized void zzeb(int i) {
        this.zzeqz = i * 1000;
    }

    public final synchronized void zzds(int i) {
        this.zzera = i * 1000;
    }

    public final synchronized void zzdt(int i) {
        this.zzerb = i * 1000;
    }

    private final void zzl(boolean z) {
        this.zzbir = 0;
        this.zzerc = false;
        if (z) {
            this.zzeqx.reset();
        }
    }
}
