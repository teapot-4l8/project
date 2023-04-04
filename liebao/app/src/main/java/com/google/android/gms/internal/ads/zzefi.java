package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzefi implements zzejq {
    private final String zzigr;
    private final int zzigs;
    private zzegr zzigt;
    private zzegb zzigu;
    private int zzigv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefi(zzeif zzeifVar) {
        String zzbev = zzeifVar.zzbev();
        this.zzigr = zzbev;
        if (zzbev.equals(zzedr.zzifn)) {
            try {
                zzegu zzl = zzegu.zzl(zzeifVar.zzbew(), zzemn.zzbiv());
                this.zzigt = (zzegr) zzedl.zzb(zzeifVar);
                this.zzigs = zzl.getKeySize();
            } catch (zzenn e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else if (this.zzigr.equals(zzedr.zzifm)) {
            try {
                zzege zzf = zzege.zzf(zzeifVar.zzbew(), zzemn.zzbiv());
                this.zzigu = (zzegb) zzedl.zzb(zzeifVar);
                this.zzigv = zzf.zzbco().getKeySize();
                this.zzigs = this.zzigv + zzf.zzbcp().getKeySize();
            } catch (zzenn e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(this.zzigr);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzejq
    public final int zzbcb() {
        return this.zzigs;
    }

    @Override // com.google.android.gms.internal.ads.zzejq
    public final zzecn zzm(byte[] bArr) {
        if (bArr.length != this.zzigs) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.zzigr.equals(zzedr.zzifn)) {
            return (zzecn) zzedl.zza(this.zzigr, (zzegr) ((zzena) zzegr.zzbdg().zza(this.zzigt).zzw(zzelq.zzi(bArr, 0, this.zzigs)).zzbjv()), zzecn.class);
        } else if (this.zzigr.equals(zzedr.zzifm)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzigv);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzigv, this.zzigs);
            zzegb.zza zzc = zzegb.zzbcm().zzff(this.zzigu.getVersion()).zzc((zzegf) ((zzena) zzegf.zzbcs().zza(this.zzigu.zzbck()).zzu(zzelq.zzt(copyOfRange)).zzbjv()));
            return (zzecn) zzedl.zza(this.zzigr, (zzegb) ((zzena) zzc.zzc((zzehu) ((zzena) zzehu.zzben().zza(this.zzigu.zzbcl()).zzae(zzelq.zzt(copyOfRange2)).zzbjv())).zzbjv()), zzecn.class);
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
