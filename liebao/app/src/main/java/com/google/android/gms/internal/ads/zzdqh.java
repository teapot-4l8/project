package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqh {
    public static zzvh zza(zzdqj zzdqjVar, zzvh zzvhVar) {
        if (zzdqjVar.equals(zzdqj.MEDIATION_SHOW_ERROR)) {
            if (((Integer) zzww.zzra().zzd(zzabq.zzday)).intValue() > 0) {
                return zzvhVar;
            }
        }
        return zza(zzdqjVar, null, zzvhVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzvh zza(zzdqj zzdqjVar, String str, zzvh zzvhVar) {
        if (str == null) {
            switch (zzdqg.zzhou[zzdqjVar.ordinal()]) {
                case 1:
                    str = "Invalid request.";
                    break;
                case 2:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case 3:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case 4:
                    str = "Network error.";
                    break;
                case 5:
                    str = "No fill.";
                    break;
                case 6:
                    str = "App ID missing.";
                    break;
                case 7:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case 8:
                    str = "The ad is not ready.";
                    break;
                case 9:
                    str = "The ad has already been shown.";
                    break;
                case 10:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                case 11:
                case 13:
                default:
                    str = "Internal error.";
                    break;
                case 12:
                    if (((Integer) zzww.zzra().zzd(zzabq.zzdbc)).intValue() <= 0) {
                        str = "The mediation adapter did not return an ad.";
                        break;
                    }
                    str = "No fill.";
                    break;
                case 14:
                    str = "Mismatch request IDs.";
                    break;
            }
        }
        String str2 = str;
        int i = 0;
        switch (zzdqg.zzhou[zzdqjVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 9:
                i = 1;
                break;
            case 4:
            case 8:
                i = 2;
                break;
            case 5:
            case 10:
                i = 3;
                break;
            case 6:
                i = 8;
                break;
            case 7:
                i = 4;
                break;
            case 11:
            case 13:
                break;
            case 12:
                if (((Integer) zzww.zzra().zzd(zzabq.zzdbc)).intValue() <= 0) {
                    i = 9;
                    break;
                }
                i = 3;
                break;
            case 14:
                i = 10;
                break;
            default:
                String valueOf = String.valueOf(zzdqjVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unknown SdkError: ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
        }
        return new zzvh(i, str2, MobileAds.ERROR_DOMAIN, zzvhVar, null);
    }

    public static zzvh zzh(Throwable th) {
        if (th instanceof zzctd) {
            zzctd zzctdVar = (zzctd) th;
            return zza(zzctdVar.zzasc(), zzctdVar.zzasv());
        } else if (th instanceof zzcnp) {
            if (th.getMessage() == null) {
                return zza(((zzcnp) th).zzasc(), null, null);
            }
            return zza(((zzcnp) th).zzasc(), th.getMessage(), null);
        } else if (th instanceof com.google.android.gms.ads.internal.util.zzap) {
            com.google.android.gms.ads.internal.util.zzap zzapVar = (com.google.android.gms.ads.internal.util.zzap) th;
            return new zzvh(zzapVar.getErrorCode(), zzdyq.zzhn(zzapVar.getMessage()), MobileAds.ERROR_DOMAIN, null, null);
        } else {
            return zza(zzdqj.INTERNAL_ERROR, null, null);
        }
    }

    public static zzvh zza(Throwable th, zzctc zzctcVar) {
        zzvh zzh = zzh(th);
        if ((zzh.errorCode == 3 || zzh.errorCode == 0) && zzh.zzchu != null && !zzh.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
            zzh.zzchu = null;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue() && zzctcVar != null) {
            zzh.zzchv = zzctcVar.zzasu();
        }
        return zzh;
    }
}
