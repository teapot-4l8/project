package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzlb implements zzkz {
    private final zzpn zzaxd;
    private final int zzaxl;
    private final int zzaxm;

    public zzlb(zzky zzkyVar) {
        zzpn zzpnVar = zzkyVar.zzaxd;
        this.zzaxd = zzpnVar;
        zzpnVar.zzbl(12);
        this.zzaxl = this.zzaxd.zzje();
        this.zzaxm = this.zzaxd.zzje();
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzhb() {
        return this.zzaxm;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzhc() {
        int i = this.zzaxl;
        return i == 0 ? this.zzaxd.zzje() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final boolean zzhd() {
        return this.zzaxl != 0;
    }
}
