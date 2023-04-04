package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
final class zzak implements zzar {
    private zzct<zzbh> zza;
    private zzct<zzbb> zzb;
    private zzct<zzat> zzc;
    private zzct zzd;
    private zzct<zzbe> zze;
    private final /* synthetic */ zzag zzf;

    private zzak(zzag zzagVar, zzbb zzbbVar) {
        zzct zzctVar;
        zzct zzctVar2;
        zzan zzanVar;
        zzap zzapVar;
        zzct zzctVar3;
        zzct zzctVar4;
        zzan zzanVar2;
        zzct zzctVar5;
        zzct zzctVar6;
        zzct zzctVar7;
        this.zzf = zzagVar;
        zzctVar = this.zzf.zza;
        this.zza = zzcq.zza(new zzbk(zzctVar));
        this.zzb = zzcs.zza(zzbbVar);
        this.zzc = new zzcn();
        zzctVar2 = this.zzf.zza;
        zzct<zzbh> zzctVar8 = this.zza;
        zzanVar = zzaq.zza;
        zzapVar = zzas.zza;
        zzctVar3 = this.zzf.zzh;
        zzctVar4 = this.zzf.zzi;
        this.zzd = new zzbo(zzctVar2, zzctVar8, zzanVar, zzapVar, zzctVar3, zzctVar4, this.zzc);
        zzct<zzbh> zzctVar9 = this.zza;
        zzanVar2 = zzaq.zza;
        this.zze = new zzbi(zzctVar9, zzanVar2, this.zzd);
        zzct<zzat> zzctVar10 = this.zzc;
        zzctVar5 = this.zzf.zza;
        zzctVar6 = this.zzf.zzc;
        zzct<zzbh> zzctVar11 = this.zza;
        zzctVar7 = this.zzf.zzb;
        zzcn.zza(zzctVar10, zzcq.zza(new zzba(zzctVar5, zzctVar6, zzctVar11, zzctVar7, this.zzb, this.zze)));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzar
    public final zzat zza() {
        return this.zzc.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzak(zzag zzagVar, zzbb zzbbVar, zzaf zzafVar) {
        this(zzagVar, zzbbVar);
    }
}
