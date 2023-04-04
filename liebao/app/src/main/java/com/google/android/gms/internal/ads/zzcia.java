package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcia implements zzebi<zzbfi> {
    private final /* synthetic */ String zzgln;
    private final /* synthetic */ Map zzglo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcia(zzchu zzchuVar, String str, Map map) {
        this.zzgln = str;
        this.zzglo = map;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbfi zzbfiVar) {
        zzbfiVar.zza(this.zzgln, this.zzglo);
    }
}
