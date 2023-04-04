package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdiw implements zzdhb<JSONObject> {
    private List<String> zzdvy;

    public zzdiw(List<String> list) {
        this.zzdvy = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzdvy));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Failed putting experiment ids.");
        }
    }
}
