package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzvx;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class AdapterResponseInfo {
    private final zzvx zzadn;
    private final AdError zzado;

    private AdapterResponseInfo(zzvx zzvxVar) {
        this.zzadn = zzvxVar;
        this.zzado = zzvxVar.zzcjc == null ? null : zzvxVar.zzcjc.zzqh();
    }

    public static AdapterResponseInfo zza(zzvx zzvxVar) {
        if (zzvxVar != null) {
            return new AdapterResponseInfo(zzvxVar);
        }
        return null;
    }

    public final String getAdapterClassName() {
        return this.zzadn.zzcja;
    }

    public final long getLatencyMillis() {
        return this.zzadn.zzcjb;
    }

    public final AdError getAdError() {
        return this.zzado;
    }

    public final Bundle getCredentials() {
        return this.zzadn.zzcjd;
    }

    public final JSONObject zzds() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zzadn.zzcja);
        jSONObject.put("Latency", this.zzadn.zzcjb);
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zzadn.zzcjd.keySet()) {
            jSONObject2.put(str, this.zzadn.zzcjd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzado;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzds());
        }
        return jSONObject;
    }

    public final String toString() {
        try {
            return zzds().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
