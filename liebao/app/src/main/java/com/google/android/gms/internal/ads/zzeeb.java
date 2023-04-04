package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeeb extends zzecu<zzegr> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeeb() {
        super(zzegr.class, new zzeee(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegr> zzbbn() {
        return new zzeed(this, zzegu.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegr zzegrVar) {
        zzegr zzegrVar2 = zzegrVar;
        zzeku.zzab(zzegrVar2.getVersion(), 0);
        zzeku.zzgc(zzegrVar2.zzbcc().size());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegr zzp(zzelq zzelqVar) {
        return zzegr.zzk(zzelqVar, zzemn.zzbiv());
    }
}
