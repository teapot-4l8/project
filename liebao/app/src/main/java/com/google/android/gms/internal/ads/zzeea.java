package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeea extends zzecu<zzegm> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeea() {
        super(zzegm.class, new zzedz(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegm> zzbbn() {
        return new zzeec(this, zzegn.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegm zzegmVar) {
        zzegm zzegmVar2 = zzegmVar;
        zzeku.zzab(zzegmVar2.getVersion(), 0);
        zzeku.zzgc(zzegmVar2.zzbcc().size());
        if (zzegmVar2.zzbda().zzbcx() != 12 && zzegmVar2.zzbda().zzbcx() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegm zzp(zzelq zzelqVar) {
        return zzegm.zzi(zzelqVar, zzemn.zzbiv());
    }
}
