package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdjj implements zzdhb<JSONObject> {
    private final Map<String, Object> zzhhx;

    public zzdjj(Map<String, Object> map) {
        this.zzhhx = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", com.google.android.gms.ads.internal.zzr.zzkv().zzj(this.zzhhx));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
