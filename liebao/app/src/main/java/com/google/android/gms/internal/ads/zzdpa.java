package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpa implements com.google.android.gms.ads.internal.util.zzbm {
    public final String zzdug;
    public final String zzdui;
    public final JSONObject zzgem;
    private final JSONObject zzhnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdpa(JsonReader jsonReader) {
        JSONObject zzc = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
        this.zzhnk = zzc;
        this.zzdui = zzc.optString("ad_html", null);
        this.zzdug = this.zzhnk.optString("ad_base_url", null);
        this.zzgem = this.zzhnk.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbm
    public final void zza(JsonWriter jsonWriter) {
        com.google.android.gms.ads.internal.util.zzbh.zza(jsonWriter, this.zzhnk);
    }
}
