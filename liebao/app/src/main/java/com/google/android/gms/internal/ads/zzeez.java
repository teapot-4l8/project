package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeez extends zzecu<zzehn> {
    public zzeez() {
        super(zzehn.class, new zzefc(zzecq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzehn zzehnVar) {
        zzehn zzehnVar2 = zzehnVar;
        zzeku.zzab(zzehnVar2.getVersion(), 0);
        zzefg.zza(zzehnVar2.zzbds());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzehn zzp(zzelq zzelqVar) {
        return zzehn.zzs(zzelqVar, zzemn.zzbiv());
    }
}
