package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzebh;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzww;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zze {
    private Context context;
    private long zzbpb = 0;

    public final void zza(Context context, zzbar zzbarVar, String str, Runnable runnable) {
        zza(context, zzbarVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzbar zzbarVar, String str, zzazt zzaztVar) {
        zza(context, zzbarVar, false, zzaztVar, zzaztVar != null ? zzaztVar.zzys() : null, str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (r11.zzyq() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zza(Context context, zzbar zzbarVar, boolean z, zzazt zzaztVar, String str, String str2, Runnable runnable) {
        if (zzr.zzlc().elapsedRealtime() - this.zzbpb < 5000) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Not retrying to fetch app settings");
            return;
        }
        this.zzbpb = zzr.zzlc().elapsedRealtime();
        boolean z2 = false;
        if (zzaztVar != null) {
            if (!(zzr.zzlc().currentTimeMillis() - zzaztVar.zzyp() > ((Long) zzww.zzra().zzd(zzabq.zzcup)).longValue())) {
            }
        }
        z2 = true;
        if (z2) {
            if (context == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Context not provided to fetch application settings");
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("App settings could not be fetched. Required parameters missing");
            } else {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                this.context = applicationContext;
                zzamg zza = zzr.zzli().zzb(this.context, zzbarVar).zza("google.afma.config.fetchAppSettings", zzamn.zzdma, zzamn.zzdma);
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("app_id", str);
                    } else if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("ad_unit_id", str2);
                    }
                    jSONObject.put("is_init", z);
                    jSONObject.put("pn", context.getPackageName());
                    zzebt zzh = zza.zzh(jSONObject);
                    zzebt zzb = zzebh.zzb(zzh, zzd.zzbpa, zzbat.zzekj);
                    if (runnable != null) {
                        zzh.addListener(runnable, zzbat.zzekj);
                    }
                    zzbba.zza(zzb, "ConfigLoader.maybeFetchNewAppSettings");
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzc("Error requesting application settings", e2);
                }
            }
        }
    }
}
