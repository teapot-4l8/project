package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaho implements zzaig<zzbfi> {
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        zzbfi zzbfiVar2 = zzbfiVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbfiVar2.zzacb().zzb(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzd("Malformed timestamp for CSI tick.", e2);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str5)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No value given for CSI experiment.");
                return;
            }
            zzach zzsr = zzbfiVar2.zzacb().zzsr();
            if (zzsr == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No ticker for WebView, dropping experiment ID.");
            } else {
                zzsr.zzg("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            String str7 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str7)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No name given for CSI extra.");
            } else {
                zzach zzsr2 = zzbfiVar2.zzacb().zzsr();
                if (zzsr2 == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzsr2.zzg(str6, str7);
                }
            }
        }
    }
}
