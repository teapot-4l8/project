package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdij implements zzdhb<JSONObject> {
    private JSONObject zzhhj;

    public zzdij(JSONObject jSONObject) {
        this.zzhhj = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzhhj);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Unable to get cache_state");
        }
    }
}
