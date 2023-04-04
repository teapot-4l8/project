package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeey extends zzedi<zzehm, zzehn> {
    private static final byte[] zzigm = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeey() {
        super(zzehm.class, zzehn.class, new zzeex(zzecr.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<zzehi, zzehm> zzbbn() {
        return new zzefa(this, zzehi.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzeon zzeonVar) {
        zzehm zzehmVar = (zzehm) zzeonVar;
        if (zzehmVar.zzbcc().isEmpty()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzeku.zzab(zzehmVar.getVersion(), 0);
        zzefg.zza(zzehmVar.zzbdz().zzbds());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzeon zzp(zzelq zzelqVar) {
        return zzehm.zzr(zzelqVar, zzemn.zzbiv());
    }
}
