package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbep implements zzaig<zzbcs> {
    private static Integer zza(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            try {
                return Integer.valueOf(Integer.parseInt(map.get(str)));
            } catch (NumberFormatException unused) {
                String str2 = map.get(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
                sb.append("Precache invalid numeric parameter '");
                sb.append(str);
                sb.append("': ");
                sb.append(str2);
                com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbcs zzbcsVar, Map map) {
        zzbek zzbekVar;
        zzbcs zzbcsVar2 = zzbcsVar;
        if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        }
        com.google.android.gms.ads.internal.zzr.zzlr();
        if (map.containsKey("abort")) {
            if (zzbeh.zzc(zzbcsVar2)) {
                return;
            }
            com.google.android.gms.ads.internal.util.zzd.zzez("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer zza = zza(map, "periodicReportIntervalMs");
        Integer zza2 = zza(map, "exoPlayerRenderingIntervalMs");
        Integer zza3 = zza(map, "exoPlayerIdleIntervalMs");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String valueOf2 = String.valueOf(str2);
                    com.google.android.gms.ads.internal.util.zzd.zzez(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbeh.zzd(zzbcsVar2) != null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Precache task is already running.");
                return;
            } else if (zzbcsVar2.zzaby() == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Precache requires a dependency provider.");
                return;
            } else {
                zzbcp zzbcpVar = new zzbcp((String) map.get("flags"));
                Integer zza4 = zza(map, "player");
                if (zza4 == null) {
                    zza4 = 0;
                }
                if (zza != null) {
                    zzbcsVar2.zzdv(zza.intValue());
                }
                if (zza2 != null) {
                    zzbcsVar2.zzdw(zza2.intValue());
                }
                if (zza3 != null) {
                    zzbcsVar2.zzdx(zza3.intValue());
                }
                zzbekVar = zzbcsVar2.zzaby().zzbou.zza(zzbcsVar2, zza4.intValue(), null, zzbcpVar);
                new zzbef(zzbcsVar2, zzbekVar, str, strArr).zzyx();
            }
        } else {
            zzbef zzd = zzbeh.zzd(zzbcsVar2);
            if (zzd != null) {
                zzbekVar = zzd.zzerp;
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzez("Precache must specify a source.");
                return;
            }
        }
        Integer zza5 = zza(map, "minBufferMs");
        if (zza5 != null) {
            zzbekVar.zzdq(zza5.intValue());
        }
        Integer zza6 = zza(map, "maxBufferMs");
        if (zza6 != null) {
            zzbekVar.zzdr(zza6.intValue());
        }
        Integer zza7 = zza(map, "bufferForPlaybackMs");
        if (zza7 != null) {
            zzbekVar.zzds(zza7.intValue());
        }
        Integer zza8 = zza(map, "bufferForPlaybackAfterRebufferMs");
        if (zza8 != null) {
            zzbekVar.zzdt(zza8.intValue());
        }
    }
}
