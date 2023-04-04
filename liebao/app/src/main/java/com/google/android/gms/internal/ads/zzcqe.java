package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcqe implements zzdsr {
    static final zzdsr zzgqm = new zzcqe();

    private zzcqe() {
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        com.google.android.gms.ads.internal.util.zzd.zzed("Ad request signals:");
        com.google.android.gms.ads.internal.util.zzd.zzed(jSONObject.toString(2));
        return jSONObject;
    }
}
