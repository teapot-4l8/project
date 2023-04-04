package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeex extends zzecw<zzecr, zzehm> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeex(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzecw
    public final /* synthetic */ zzecr zzah(zzehm zzehmVar) {
        zzehm zzehmVar2 = zzehmVar;
        zzehj zzbds = zzehmVar2.zzbdz().zzbds();
        zzehq zzbdu = zzbds.zzbdu();
        zzejy zza = zzefg.zza(zzbdu.zzbeh());
        byte[] byteArray = zzehmVar2.zzbcc().toByteArray();
        return new zzejt((ECPrivateKey) zzekd.zzinp.zzhx("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzejw.zza(zza))), zzbdu.zzbej().toByteArray(), zzefg.zza(zzbdu.zzbei()), zzefg.zza(zzbds.zzbdw()), new zzefi(zzbds.zzbdv().zzbdp()));
    }
}
