package com.google.android.gms.internal.ads;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdix implements zzdhb<JSONObject> {
    private Bundle zzhhs;

    public zzdix(Bundle bundle) {
        this.zzhhs = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzhhs != null) {
            try {
                com.google.android.gms.ads.internal.util.zzbh.zzb(com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject2, "device"), "play_store").put("parental_controls", com.google.android.gms.ads.internal.zzr.zzkv().zzc(this.zzhhs));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzed("Failed putting parental controls bundle.");
            }
        }
    }
}
