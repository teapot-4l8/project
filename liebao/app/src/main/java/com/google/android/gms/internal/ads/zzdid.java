package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdid implements zzdhb<JSONObject> {
    private String zzhhh;

    public zzdid(String str) {
        this.zzhhh = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            if (TextUtils.isEmpty(this.zzhhh)) {
                return;
            }
            zzb.put("attok", this.zzhhh);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting attestation token.", e2);
        }
    }
}
