package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeem extends zzecu<zzeio> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeem() {
        super(zzeio.class, new zzeel(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzeio> zzbbn() {
        return new zzeeo(this, zzeir.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzeio zzeioVar) {
        zzeku.zzab(zzeioVar.getVersion(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzeio zzp(zzelq zzelqVar) {
        return zzeio.zzv(zzelqVar, zzemn.zzbiv());
    }
}
