package com.google.android.gms.internal.ads;

import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzefa extends zzecx<zzehi, zzehm> {
    private final /* synthetic */ zzeey zzign;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzefa(zzeey zzeeyVar, Class cls) {
        super(cls);
        this.zzign = zzeeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzehm zze(zzehi zzehiVar) {
        zzehi zzehiVar2 = zzehiVar;
        KeyPair zza = zzejw.zza(zzejw.zza(zzefg.zza(zzehiVar2.zzbds().zzbdu().zzbeh())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzehm) ((zzena) zzehm.zzbea().zzfm(0).zzb((zzehn) ((zzena) zzehn.zzbee().zzfn(0).zzc(zzehiVar2.zzbds()).zzac(zzelq.zzt(w.getAffineX().toByteArray())).zzad(zzelq.zzt(w.getAffineY().toByteArray())).zzbjv())).zzab(zzelq.zzt(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbjv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzehi zzr(zzelq zzelqVar) {
        return zzehi.zzq(zzelqVar, zzemn.zzbiv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ void zzd(zzehi zzehiVar) {
        zzefg.zza(zzehiVar.zzbds());
    }
}
