package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzefl extends zzecu<zzefw> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefl() {
        super(zzefw.class, new zzefk(zzeda.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzega zzegaVar) {
        if (zzegaVar.zzbch() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzegaVar.zzbch() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzfc(int i) {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzefw> zzbbn() {
        return new zzefn(this, zzefx.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzefw zzefwVar) {
        zzefw zzefwVar2 = zzefwVar;
        zzeku.zzab(zzefwVar2.getVersion(), 0);
        zzfc(zzefwVar2.zzbcc().size());
        zza(zzefwVar2.zzbcd());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzefw zzp(zzelq zzelqVar) {
        return zzefw.zzc(zzelqVar, zzemn.zzbiv());
    }
}
