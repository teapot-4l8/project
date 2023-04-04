package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbed implements zzaig<zzbcs> {
    private boolean zzern;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                zzww.zzqw();
                return zzbae.zze(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                return i;
            }
        }
        return i;
    }

    private static Integer zza(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            try {
                return Integer.valueOf(Integer.parseInt(map.get(str)));
            } catch (NumberFormatException unused) {
                String str2 = map.get(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41 + String.valueOf(str2).length());
                sb.append("Video gmsg invalid numeric parameter '");
                sb.append(str);
                sb.append("': ");
                sb.append(str2);
                com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                return null;
            }
        }
        return null;
    }

    private static void zza(zzbcb zzbcbVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcbVar.zzdq(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzez(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbcbVar.zzdr(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcbVar.zzds(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcbVar.zzdt(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcbVar.zzdu(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbcs zzbcsVar, Map map) {
        int i;
        String[] split;
        zzbcs zzbcsVar2 = zzbcsVar;
        String str = (String) map.get("action");
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Action missing from video GMSG.");
            return;
        }
        if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbcsVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("No MIME types specified for decoder properties inspection.");
                zzbcb.zza(zzbcsVar2, "missingMimeTypes");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, com.google.android.gms.ads.internal.util.zzbx.zzer(str4.trim()));
            }
            zzbcb.zza(zzbcsVar2, hashMap);
            return;
        }
        zzbch zzabu = zzbcsVar2.zzabu();
        if (zzabu == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzbcsVar2.getContext();
            int zza = zza(context, map, "x", 0);
            int zza2 = zza(context, map, "y", 0);
            int zza3 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            int min = Math.min(zza3, zzbcsVar2.zzace() - zza);
            int min2 = Math.min(zza4, zzbcsVar2.zzacd() - zza2);
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
            if (equals && zzabu.zzabo() == null) {
                zzabu.zza(zza, zza2, min, min2, i, parseBoolean, new zzbcp((String) map.get("flags")));
                zzbcb zzabo = zzabu.zzabo();
                if (zzabo != null) {
                    zza(zzabo, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzabu.zze(zza, zza2, min, min2);
            return;
        }
        zzbgc zzabv = zzbcsVar2.zzabv();
        if (zzabv != null) {
            if ("timeupdate".equals(str)) {
                String str5 = (String) map.get("currentTime");
                if (str5 == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzabv.zze(Float.parseFloat(str5));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf = String.valueOf(str5);
                    com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                    return;
                }
            } else if ("skip".equals(str)) {
                zzabv.zzafe();
                return;
            }
        }
        zzbcb zzabo2 = zzabu.zzabo();
        if (zzabo2 == null) {
            zzbcb.zza(zzbcsVar2);
        } else if ("click".equals(str)) {
            Context context2 = zzbcsVar2.getContext();
            int zza5 = zza(context2, map, "x", 0);
            int zza6 = zza(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza5, zza6, 0);
            zzabo2.zze(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            String str6 = (String) map.get("time");
            if (str6 == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzabo2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
            } catch (NumberFormatException unused4) {
                String valueOf2 = String.valueOf(str6);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
            }
        } else if ("hide".equals(str)) {
            zzabo2.setVisibility(4);
        } else if ("load".equals(str)) {
            zzabo2.zzic();
        } else if ("loadControl".equals(str)) {
            zza(zzabo2, (Map<String, String>) map);
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzabo2.zzabi();
            } else {
                zzabo2.zzabj();
            }
        } else if ("pause".equals(str)) {
            zzabo2.pause();
        } else if ("play".equals(str)) {
            zzabo2.play();
        } else if ("show".equals(str)) {
            zzabo2.setVisibility(0);
        } else if ("src".equals(str)) {
            String str7 = (String) map.get("src");
            Integer zza7 = zza(map, "periodicReportIntervalMs");
            String[] strArr = {str7};
            String str8 = (String) map.get("demuxed");
            if (str8 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str8);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused5) {
                    String valueOf3 = String.valueOf(str8);
                    com.google.android.gms.ads.internal.util.zzd.zzez(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                    strArr = new String[]{str7};
                }
            }
            if (zza7 != null) {
                zzbcsVar2.zzdv(zza7.intValue());
            }
            zzabo2.zzc(str7, strArr);
        } else if ("touchMove".equals(str)) {
            Context context3 = zzbcsVar2.getContext();
            zzabo2.zza(zza(context3, map, "dx", 0), zza(context3, map, "dy", 0));
            if (this.zzern) {
                return;
            }
            zzbcsVar2.zzwn();
            this.zzern = true;
        } else if ("volume".equals(str)) {
            String str9 = (String) map.get("volume");
            if (str9 == null) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzabo2.setVolume(Float.parseFloat(str9));
            } catch (NumberFormatException unused6) {
                String valueOf4 = String.valueOf(str9);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
            }
        } else if ("watermark".equals(str)) {
            zzabo2.zzabk();
        } else {
            String valueOf5 = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzez(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
        }
    }
}
