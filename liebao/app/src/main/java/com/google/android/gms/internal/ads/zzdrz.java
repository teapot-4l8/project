package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrz {
    private final long zzhsh;
    private long zzhsj;
    private final zzdry zzhsi = new zzdry();
    private int zzhsk = 0;
    private int zzhsl = 0;
    private int zzhsg = 0;

    public zzdrz() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        this.zzhsh = currentTimeMillis;
        this.zzhsj = currentTimeMillis;
    }

    public final void zzaxm() {
        this.zzhsj = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        this.zzhsk++;
    }

    public final void zzaxn() {
        this.zzhsl++;
        this.zzhsi.zzhsf = true;
    }

    public final void zzaxo() {
        this.zzhsg++;
        this.zzhsi.zzhsg++;
    }

    public final long getCreationTimeMillis() {
        return this.zzhsh;
    }

    public final long zzawp() {
        return this.zzhsj;
    }

    public final int zzawq() {
        return this.zzhsk;
    }

    public final zzdry zzaxp() {
        zzdry zzdryVar = (zzdry) this.zzhsi.clone();
        zzdry zzdryVar2 = this.zzhsi;
        zzdryVar2.zzhsf = false;
        zzdryVar2.zzhsg = 0;
        return zzdryVar;
    }

    public final String zzaxc() {
        return "Created: " + this.zzhsh + " Last accessed: " + this.zzhsj + " Accesses: " + this.zzhsk + "\nEntries retrieved: Valid: " + this.zzhsl + " Stale: " + this.zzhsg;
    }
}
