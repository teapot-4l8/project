package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdis implements zzdhb<JSONObject> {
    private String zzhhp;
    private String zzhhq;

    public zzdis(String str, String str2) {
        this.zzhhp = str;
        this.zzhhq = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            zzb.put("doritos", this.zzhhp);
            zzb.put("doritos_v2", this.zzhhq);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Failed putting doritos string.");
        }
    }
}
