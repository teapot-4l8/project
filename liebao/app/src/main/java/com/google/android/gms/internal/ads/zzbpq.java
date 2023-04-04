package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpq implements zzebi<zzbpi> {
    private final /* synthetic */ zzebi zzfyz;
    private final /* synthetic */ zzbpn zzfza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpq(zzbpn zzbpnVar, zzebi zzebiVar) {
        this.zzfza = zzbpnVar;
        this.zzfyz = zzebiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        this.zzfyz.zzb(th);
        this.zzfza.zzalo();
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbpi zzbpiVar) {
        this.zzfza.zza(zzbpiVar.zzfys, this.zzfyz);
    }
}
