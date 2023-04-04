package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzedv extends zzecu<zzegf> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedv() {
        super(zzegf.class, new zzedy(zzekn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public static void zza(zzegf zzegfVar) {
        zzeku.zzab(zzegfVar.getVersion(), 0);
        zzeku.zzgc(zzegfVar.zzbcc().size());
        zza(zzegfVar.zzbcr());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegf> zzbbn() {
        return new zzedx(this, zzegi.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzegj zzegjVar) {
        if (zzegjVar.zzbcx() < 12 || zzegjVar.zzbcx() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegf zzegfVar) {
        zza(zzegfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegf zzp(zzelq zzelqVar) {
        return zzegf.zzg(zzelqVar, zzemn.zzbiv());
    }
}
