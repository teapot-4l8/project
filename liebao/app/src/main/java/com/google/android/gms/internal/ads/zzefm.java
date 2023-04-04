package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzefm extends zzecu<zzehu> {
    public zzefm() {
        super(zzehu.class, new zzefp(zzeda.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    public static void zza(zzehu zzehuVar) {
        zzeku.zzab(zzehuVar.getVersion(), 0);
        if (zzehuVar.zzbcc().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zza(zzehuVar.zzbem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzehz zzehzVar) {
        if (zzehzVar.zzbch() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = zzefr.zzigw[zzehzVar.zzbes().ordinal()];
        if (i == 1) {
            if (zzehzVar.zzbch() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 2) {
            if (zzehzVar.zzbch() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 3) {
            if (zzehzVar.zzbch() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzehu> zzbbn() {
        return new zzefo(this, zzehy.class);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzehu zzehuVar) {
        zza(zzehuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzehu zzp(zzelq zzelqVar) {
        return zzehu.zzt(zzelqVar, zzemn.zzbiv());
    }
}
