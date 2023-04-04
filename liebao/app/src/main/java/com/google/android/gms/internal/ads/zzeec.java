package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeec extends zzecx<zzegn, zzegm> {
    private final /* synthetic */ zzeea zziga;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeec(zzeea zzeeaVar, Class cls) {
        super(cls);
        this.zziga = zzeeaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzegm zze(zzegn zzegnVar) {
        zzegn zzegnVar2 = zzegnVar;
        return (zzegm) ((zzena) zzegm.zzbdb().zzv(zzelq.zzt(zzekt.zzgb(zzegnVar2.getKeySize()))).zzb(zzegnVar2.zzbda()).zzfh(0).zzbjv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzegn zzr(zzelq zzelqVar) {
        return zzegn.zzj(zzelqVar, zzemn.zzbiv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ void zzd(zzegn zzegnVar) {
        zzegn zzegnVar2 = zzegnVar;
        zzeku.zzgc(zzegnVar2.getKeySize());
        if (zzegnVar2.zzbda().zzbcx() != 12 && zzegnVar2.zzbda().zzbcx() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
