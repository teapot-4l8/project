package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbks implements zzbkm {
    private final zzaxx zzedp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbks(zzaxx zzaxxVar) {
        this.zzedp = zzaxxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkm
    public final void zzi(JSONObject jSONObject) {
        int i;
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa") ? 1 : 0;
        }
        this.zzedp.zzdh(i);
    }
}
