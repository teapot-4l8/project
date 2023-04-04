package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhp implements zzdhb<JSONObject> {
    private final AdvertisingIdClient.Info zzhgw;
    private final String zzhgx;

    public zzdhp(AdvertisingIdClient.Info info, String str) {
        this.zzhgw = info;
        this.zzhgx = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbh.zzb(jSONObject, "pii");
            if (this.zzhgw != null && !TextUtils.isEmpty(this.zzhgw.getId())) {
                zzb.put("rdid", this.zzhgw.getId());
                zzb.put("is_lat", this.zzhgw.isLimitAdTrackingEnabled());
                zzb.put("idtype", "adid");
                return;
            }
            zzb.put("pdid", this.zzhgx);
            zzb.put("pdidtype", "ssaid");
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed putting Ad ID.", e2);
        }
    }
}
