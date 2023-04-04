package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdra {
    private final zzdrd zzhqd = new zzdrd();
    private int zzhqe;
    private int zzhqf;
    private int zzhqg;
    private int zzhqh;
    private int zzhqi;

    public final void zzaww() {
        this.zzhqg++;
    }

    public final void zzawx() {
        this.zzhqh++;
    }

    public final void zzawy() {
        this.zzhqe++;
        this.zzhqd.zzhqx = true;
    }

    public final void zzawz() {
        this.zzhqf++;
        this.zzhqd.zzhqy = true;
    }

    public final void zzaxa() {
        this.zzhqi++;
    }

    public final zzdrd zzaxb() {
        zzdrd zzdrdVar = (zzdrd) this.zzhqd.clone();
        zzdrd zzdrdVar2 = this.zzhqd;
        zzdrdVar2.zzhqx = false;
        zzdrdVar2.zzhqy = false;
        return zzdrdVar;
    }

    public final String zzaxc() {
        return "\n\tPool does not exist: " + this.zzhqg + "\n\tNew pools created: " + this.zzhqe + "\n\tPools removed: " + this.zzhqf + "\n\tEntries added: " + this.zzhqi + "\n\tNo entries retrieved: " + this.zzhqh + "\n";
    }
}
