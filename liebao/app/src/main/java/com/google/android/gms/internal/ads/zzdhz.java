package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhz implements zzdhb<JSONObject> {
    private final JSONObject zzhhd;

    public zzdhz(JSONObject jSONObject) {
        this.zzhhd = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.zzhhd;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Failed putting app indexing json.");
        }
    }
}
