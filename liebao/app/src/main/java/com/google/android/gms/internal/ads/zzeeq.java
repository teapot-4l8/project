package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeeq extends zzecu<zzeis> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeeq() {
        super(zzeis.class, new zzeep(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzeis> zzbbn() {
        return new zzees(this, zzeiv.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzeis zzeisVar) {
        zzeku.zzab(zzeisVar.getVersion(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzeis zzp(zzelq zzelqVar) {
        return zzeis.zzx(zzelqVar, zzemn.zzbiv());
    }
}
