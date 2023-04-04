package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcp {
    public final boolean zzenh;
    public final int zzeni;
    public final int zzenj;
    public final int zzenk;
    private final String zzenl;
    public final int zzenm;
    public final int zzenn;
    public final int zzeno;
    public final int zzenp;
    public final boolean zzenq;
    public final int zzenr;
    public final boolean zzens;

    public zzbcp(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzenh = zza(jSONObject, "aggressive_media_codec_release", zzabq.zzcnv);
        this.zzeni = zzb(jSONObject, "byte_buffer_precache_limit", zzabq.zzcnb);
        this.zzenj = zzb(jSONObject, "exo_cache_buffer_size", zzabq.zzcnk);
        this.zzenk = zzb(jSONObject, "exo_connect_timeout_millis", zzabq.zzcmx);
        this.zzenl = zzc(jSONObject, "exo_player_version", zzabq.zzcmw);
        this.zzenm = zzb(jSONObject, "exo_read_timeout_millis", zzabq.zzcmy);
        this.zzenn = zzb(jSONObject, "load_check_interval_bytes", zzabq.zzcmz);
        this.zzeno = zzb(jSONObject, "player_precache_limit", zzabq.zzcna);
        this.zzenp = zzb(jSONObject, "socket_receive_buffer_size", zzabq.zzcnc);
        this.zzenq = zza(jSONObject, "use_cache_data_source", zzabq.zzcuz);
        this.zzenr = zzb(jSONObject, "min_retry_count", zzabq.zzcne);
        this.zzens = zza(jSONObject, "treat_load_exception_as_non_fatal", zzabq.zzcnh);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzabf<Boolean> zzabfVar) {
        return zza(jSONObject, str, ((Boolean) zzww.zzra().zzd(zzabfVar)).booleanValue());
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int zzb(JSONObject jSONObject, String str, zzabf<Integer> zzabfVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzww.zzra().zzd(zzabfVar)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzabf<String> zzabfVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzww.zzra().zzd(zzabfVar);
    }
}
