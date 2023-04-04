package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzefp extends zzecw<zzeda, zzehu> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefp(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzecw
    public final /* synthetic */ zzeda zzah(zzehu zzehuVar) {
        zzehu zzehuVar2 = zzehuVar;
        zzehs zzbes = zzehuVar2.zzbem().zzbes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzehuVar2.zzbcc().toByteArray(), "HMAC");
        int zzbch = zzehuVar2.zzbem().zzbch();
        int i = zzefr.zzigw[zzbes.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new zzekq(new zzeko("HMACSHA512", secretKeySpec), zzbch);
                }
                throw new GeneralSecurityException("unknown hash");
            }
            return new zzekq(new zzeko("HMACSHA256", secretKeySpec), zzbch);
        }
        return new zzekq(new zzeko("HMACSHA1", secretKeySpec), zzbch);
    }
}
