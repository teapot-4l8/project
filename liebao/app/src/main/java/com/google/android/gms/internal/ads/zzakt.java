package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzakt {
    public static void zza(zzakq zzakqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzakqVar.zzi(str, jSONObject.toString());
    }

    public static void zza(zzakq zzakqVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzakqVar.zzcv(sb.toString());
    }

    public static void zzb(zzakq zzakqVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzakqVar.zzcv(sb.toString());
    }

    public static void zza(zzakq zzakqVar, String str, Map map) {
        try {
            zzakqVar.zza(str, com.google.android.gms.ads.internal.zzr.zzkv().zzj(map));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Could not convert parameters to JSON.");
        }
    }
}
