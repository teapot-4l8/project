package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzayv {
    public static String zzc(String str, Context context, boolean z) {
        String zzaf;
        if ((!((Boolean) zzww.zzra().zzd(zzabq.zzcoz)).booleanValue() || z) && com.google.android.gms.ads.internal.zzr.zzlt().zzaa(context) && !TextUtils.isEmpty(str) && (zzaf = com.google.android.gms.ads.internal.zzr.zzlt().zzaf(context)) != null) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcor)).booleanValue()) {
                String str2 = (String) zzww.zzra().zzd(zzabq.zzcos);
                if (str.contains(str2)) {
                    if (com.google.android.gms.ads.internal.zzr.zzkv().zzek(str)) {
                        com.google.android.gms.ads.internal.zzr.zzlt().zzg(context, zzaf);
                        return zzb(str, context).replace(str2, zzaf);
                    } else if (com.google.android.gms.ads.internal.zzr.zzkv().zzel(str)) {
                        com.google.android.gms.ads.internal.zzr.zzlt().zzh(context, zzaf);
                        return zzb(str, context).replace(str2, zzaf);
                    } else {
                        return str;
                    }
                }
                return str;
            } else if (str.contains("fbs_aeid")) {
                return str;
            } else {
                if (com.google.android.gms.ads.internal.zzr.zzkv().zzek(str)) {
                    com.google.android.gms.ads.internal.zzr.zzlt().zzg(context, zzaf);
                    return zza(zzb(str, context), "fbs_aeid", zzaf).toString();
                } else if (com.google.android.gms.ads.internal.zzr.zzkv().zzel(str)) {
                    com.google.android.gms.ads.internal.zzr.zzlt().zzh(context, zzaf);
                    return zza(zzb(str, context), "fbs_aeid", zzaf).toString();
                } else {
                    return str;
                }
            }
        }
        return str;
    }

    private static String zzb(String str, Context context) {
        String zzad = com.google.android.gms.ads.internal.zzr.zzlt().zzad(context);
        String zzae = com.google.android.gms.ads.internal.zzr.zzlt().zzae(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzad)) {
            str = zza(str, "gmp_app_id", zzad).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzae)) ? str : zza(str, "fbs_aiid", zzae).toString();
    }

    public static String zzb(Uri uri, Context context) {
        if (!com.google.android.gms.ads.internal.zzr.zzlt().zzaa(context)) {
            return uri.toString();
        }
        String zzaf = com.google.android.gms.ads.internal.zzr.zzlt().zzaf(context);
        if (zzaf == null) {
            return uri.toString();
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcor)).booleanValue()) {
            String str = (String) zzww.zzra().zzd(zzabq.zzcos);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                com.google.android.gms.ads.internal.zzr.zzlt().zzg(context, zzaf);
                return zzb(uri2, context).replace(str, zzaf);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = zza(zzb(uri.toString(), context), "fbs_aeid", zzaf).toString();
            com.google.android.gms.ads.internal.zzr.zzlt().zzg(context, zzaf);
            return uri3;
        }
        return uri.toString();
    }

    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }
}
