package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzedu extends zzecu<zzegb> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedu() {
        super(zzegb.class, new zzedt(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegb> zzbbn() {
        return new zzedw(this, zzege.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegb zzegbVar) {
        zzegb zzegbVar2 = zzegbVar;
        zzeku.zzab(zzegbVar2.getVersion(), 0);
        new zzedv();
        zzedv.zza(zzegbVar2.zzbck());
        new zzefm();
        zzefm.zza(zzegbVar2.zzbcl());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegb zzp(zzelq zzelqVar) {
        return zzegb.zze(zzelqVar, zzemn.zzbiv());
    }
}
