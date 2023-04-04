package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class LoadAdError extends AdError {
    private final ResponseInfo zzads;

    public LoadAdError(int i, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i, str, str2, adError);
        this.zzads = responseInfo;
    }

    public final ResponseInfo getResponseInfo() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            return this.zzads;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject zzds() {
        JSONObject zzds = super.zzds();
        ResponseInfo responseInfo = getResponseInfo();
        if (responseInfo == null) {
            zzds.put("Response Info", "null");
        } else {
            zzds.put("Response Info", responseInfo.zzds());
        }
        return zzds;
    }

    @Override // com.google.android.gms.ads.AdError
    public final String toString() {
        try {
            return zzds().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
