package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzefo extends zzecx<zzehy, zzehu> {
    private final /* synthetic */ zzefm zzigz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzefo(zzefm zzefmVar, Class cls) {
        super(cls);
        this.zzigz = zzefmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzehu zze(zzehy zzehyVar) {
        zzehy zzehyVar2 = zzehyVar;
        return (zzehu) ((zzena) zzehu.zzben().zzfq(0).zzd(zzehyVar2.zzbem()).zzae(zzelq.zzt(zzekt.zzgb(zzehyVar2.getKeySize()))).zzbjv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzehy zzr(zzelq zzelqVar) {
        return zzehy.zzu(zzelqVar, zzemn.zzbiv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ void zzd(zzehy zzehyVar) {
        zzehy zzehyVar2 = zzehyVar;
        if (zzehyVar2.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzefm.zza(zzehyVar2.zzbem());
    }
}
