package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchy implements zzebi<zzbfi> {
    private final /* synthetic */ String zzetu;
    private final /* synthetic */ zzaig zzglm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchy(zzchu zzchuVar, String str, zzaig zzaigVar) {
        this.zzetu = str;
        this.zzglm = zzaigVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbfi zzbfiVar) {
        zzbfiVar.zza(this.zzetu, this.zzglm);
    }
}
