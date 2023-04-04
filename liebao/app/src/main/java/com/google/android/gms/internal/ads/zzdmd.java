package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdmd implements zzdxw<zzcpo, zzdmf> {
    private final /* synthetic */ zzdmb zzhks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmd(zzdmb zzdmbVar) {
        this.zzhks = zzdmbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    @NullableDecl
    public final /* synthetic */ zzdmf apply(@NullableDecl zzcpo zzcpoVar) {
        zzdri zzavs;
        zzdmf zzdmfVar;
        zzbao.zzc("", zzcpoVar);
        com.google.android.gms.ads.internal.util.zzd.zzed("Failed to get a cache key, reverting to legacy flow.");
        zzdmb zzdmbVar = this.zzhks;
        zzavs = zzdmbVar.zzavs();
        zzdmbVar.zzhkq = new zzdmf(null, zzavs, null);
        zzdmfVar = this.zzhks.zzhkq;
        return zzdmfVar;
    }
}
