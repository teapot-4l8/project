package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeeh extends zzecu<zzegz> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeeh() {
        super(zzegz.class, new zzeek(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegz> zzbbn() {
        return new zzeej(this, zzehc.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegz zzegzVar) {
        zzegz zzegzVar2 = zzegzVar;
        zzeku.zzab(zzegzVar2.getVersion(), 0);
        if (zzegzVar2.zzbcc().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegz zzp(zzelq zzelqVar) {
        return zzegz.zzo(zzelqVar, zzemn.zzbiv());
    }
}
