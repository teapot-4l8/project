package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdu extends zzcdv {
    private final boolean zzdnn;
    private final boolean zzdno;
    private final boolean zzdyg;
    private final JSONObject zzghg;
    private final boolean zzghh;

    public zzcdu(zzdot zzdotVar, JSONObject jSONObject) {
        super(zzdotVar);
        boolean z = false;
        this.zzghg = com.google.android.gms.ads.internal.util.zzbh.zza(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzdno = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzdnn = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zzdyg = com.google.android.gms.ads.internal.util.zzbh.zza(false, jSONObject, "enable_omid");
        if (jSONObject != null && jSONObject.optJSONObject("overlay") != null) {
            z = true;
        }
        this.zzghh = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final JSONObject zzaoz() {
        JSONObject jSONObject = this.zzghg;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zzghi.zzdxq);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final boolean zzapa() {
        return this.zzghh;
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final boolean zzapb() {
        return this.zzdno;
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final boolean zzaok() {
        return this.zzdyg;
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final boolean zzapc() {
        return this.zzdnn;
    }
}
