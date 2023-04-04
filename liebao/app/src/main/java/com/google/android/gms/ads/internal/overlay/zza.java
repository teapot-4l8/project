package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzacs;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zza {
    public static boolean zza(Context context, zzb zzbVar, zzx zzxVar, zzv zzvVar) {
        int i = 0;
        if (zzbVar == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("No intent data for launcher overlay.");
            return false;
        }
        zzabq.initialize(context);
        if (zzbVar.intent != null) {
            return zza(context, zzbVar.intent, zzxVar, zzvVar, zzbVar.zzdsy);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzbVar.url)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzbVar.mimeType)) {
            intent.setDataAndType(Uri.parse(zzbVar.url), zzbVar.mimeType);
        } else {
            intent.setData(Uri.parse(zzbVar.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzbVar.packageName)) {
            intent.setPackage(zzbVar.packageName);
        }
        if (!TextUtils.isEmpty(zzbVar.zzdsv)) {
            String[] split = zzbVar.zzdsv.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzbVar.zzdsv);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzbVar.zzdsw;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvl)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcvk)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzkv();
                com.google.android.gms.ads.internal.util.zzj.zzb(context, intent);
            }
        }
        return zza(context, intent, zzxVar, zzvVar, zzbVar.zzdsy);
    }

    private static boolean zza(Context context, Intent intent, zzx zzxVar, zzv zzvVar, boolean z) {
        if (z) {
            return zza(context, intent.getData(), zzxVar, zzvVar);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzr.zzkv();
            com.google.android.gms.ads.internal.util.zzj.zza(context, intent);
            if (zzxVar != null) {
                zzxVar.zzws();
            }
            if (zzvVar != null) {
                zzvVar.zzaf(true);
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzez(e2.getMessage());
            if (zzvVar != null) {
                zzvVar.zzaf(false);
            }
            return false;
        }
    }

    private static boolean zza(Context context, Uri uri, zzx zzxVar, zzv zzvVar) {
        zzacs zzacsVar = zzacs.UNKNOWN;
        try {
            try {
                zzacsVar = com.google.android.gms.ads.internal.zzr.zzkv().zza(context, uri);
                if (zzxVar != null) {
                    zzxVar.zzws();
                }
                if (zzvVar != null) {
                    zzvVar.zzb(zzacsVar);
                }
                return zzacsVar.equals(zzacs.CCT_READY_TO_OPEN);
            } catch (ActivityNotFoundException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzez(e2.getMessage());
                zzacs zzacsVar2 = zzacs.ACTIVITY_NOT_FOUND;
                if (zzvVar != null) {
                    zzvVar.zzb(zzacsVar2);
                }
                return zzacsVar2.equals(zzacs.CCT_READY_TO_OPEN);
            }
        } catch (Throwable unused) {
            if (zzvVar != null) {
                zzvVar.zzb(zzacsVar);
            }
            return zzacsVar.equals(zzacs.CCT_READY_TO_OPEN);
        }
    }
}
