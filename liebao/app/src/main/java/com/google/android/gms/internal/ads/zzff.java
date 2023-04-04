package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzff {
    static zzecq zzzu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(zzfc zzfcVar) {
        Method zza;
        zzecq zza2;
        if (zzzu != null) {
            return true;
        }
        String str = (String) zzww.zzra().zzd(zzabq.zzcsz);
        if (str == null || str.length() == 0) {
            str = null;
            if (zzfcVar != null && (zza = zzfcVar.zza("4ioREl2wGHUH3L1Ffod4L799Wcu9qX0THPnnrMniz0uOTIixizwJO+JKyjfP+vUT", "/fmVllZVlSra7BEtwv3jJDV2EycO3hpoom0fb/ewpTo=")) != null) {
                str = (String) zza.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            zzecz zzl = zzedd.zzl(zzcy.zzb(str, true));
            for (zzeij zzeijVar : zzefb.zzifu.zzbgh()) {
                if (zzeijVar.zzbev().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                }
                if (zzeijVar.zzbfd().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
                if (zzeijVar.zzbfg().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                }
                if (!zzeijVar.zzbfg().equals("TinkAead") && !zzeijVar.zzbfg().equals("TinkMac") && !zzeijVar.zzbfg().equals("TinkHybridDecrypt") && !zzeijVar.zzbfg().equals("TinkHybridEncrypt") && !zzeijVar.zzbfg().equals("TinkPublicKeySign") && !zzeijVar.zzbfg().equals("TinkPublicKeyVerify") && !zzeijVar.zzbfg().equals("TinkStreamingAead") && !zzeijVar.zzbfg().equals("TinkDeterministicAead")) {
                    zzecm<?> zzhs = zzedl.zzhs(zzeijVar.zzbfg());
                    zzedl.zza(zzhs.zzbbg());
                    zzedl.zza(zzhs.zzb(zzeijVar.zzbev(), zzeijVar.zzbfd(), zzeijVar.zzbfe()), zzeijVar.zzbff());
                }
            }
            zza2 = zzeff.zza(zzl);
            zzzu = zza2;
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return zza2 != null;
    }
}
