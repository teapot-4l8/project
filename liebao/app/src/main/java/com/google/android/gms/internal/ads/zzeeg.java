package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeic;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeeg extends zzecu<zzegv> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeeg() {
        super(zzegv.class, new zzeef(zzecn.class));
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzeic.zza zzbbk() {
        return zzeic.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final zzecx<?, zzegv> zzbbn() {
        return new zzeei(this, zzegy.class);
    }

    private static boolean zzbbz() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void zzbv(boolean z) {
        if (zzbbz()) {
            zzedl.zza((zzecu) new zzeeg(), true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ void zzc(zzegv zzegvVar) {
        zzegv zzegvVar2 = zzegvVar;
        zzeku.zzab(zzegvVar2.getVersion(), 0);
        zzeku.zzgc(zzegvVar2.zzbcc().size());
    }

    @Override // com.google.android.gms.internal.ads.zzecu
    public final /* synthetic */ zzegv zzp(zzelq zzelqVar) {
        return zzegv.zzm(zzelqVar, zzemn.zzbiv());
    }
}
