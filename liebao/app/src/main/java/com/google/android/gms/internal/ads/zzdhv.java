package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhv implements zzdhb<JSONObject> {
    private final String zzhhb;

    public zzdhv(String str) {
        this.zzhhb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzhhb);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting Ad ID.", e2);
        }
    }
}
