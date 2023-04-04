package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzams implements zzbbi<zzamc> {
    private final /* synthetic */ Object val$input;
    private final /* synthetic */ zzbbe zzdjs;
    private final /* synthetic */ zzalv zzdmf;
    private final /* synthetic */ zzamt zzdmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzams(zzamt zzamtVar, zzalv zzalvVar, Object obj, zzbbe zzbbeVar) {
        this.zzdmg = zzamtVar;
        this.zzdmf = zzalvVar;
        this.val$input = obj;
        this.zzdjs = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbi
    public final /* synthetic */ void zzg(zzamc zzamcVar) {
        this.zzdmg.zza(this.zzdmf, zzamcVar, this.val$input, this.zzdjs);
    }
}
