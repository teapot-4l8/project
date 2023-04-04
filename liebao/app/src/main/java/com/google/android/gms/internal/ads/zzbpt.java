package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpt implements zzebi<zzbpc> {
    private final /* synthetic */ zzebi zzfyz;
    private final /* synthetic */ zzbpn zzfza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpt(zzbpn zzbpnVar, zzebi zzebiVar) {
        this.zzfza = zzbpnVar;
        this.zzfyz = zzebiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        this.zzfza.zzalo();
        this.zzfyz.zzb(th);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbpc zzbpcVar) {
        this.zzfza.zzalo();
        this.zzfyz.onSuccess(zzbpcVar);
    }
}
