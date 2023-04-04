package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeer extends zzecu<zzejb> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeer() {
        super(zzejb.class, new zzeeu(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzejb> zzbbn() {
        return new zzeet(this, zzejc.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzejb zzejbVar) {
        zzejb zzejbVar2 = zzejbVar;
        zzeku.zzab(zzejbVar2.getVersion(), 0);
        if (zzejbVar2.zzbcc().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzejb zzp(zzelq zzelqVar) {
        return zzejb.zzz(zzelqVar, zzemn.zzbiv());
    }
}
