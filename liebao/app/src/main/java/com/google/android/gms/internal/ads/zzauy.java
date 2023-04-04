package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzauy implements zzaun {
    private zzamg<JSONObject, JSONObject> zzeal;
    private zzamg<JSONObject, JSONObject> zzeam;

    public zzauy(Context context) {
        this.zzeam = com.google.android.gms.ads.internal.zzr.zzli().zza(context, zzbar.zzaau()).zza("google.afma.request.getAdDictionary", zzamn.zzdma, zzamn.zzdma);
        this.zzeal = com.google.android.gms.ads.internal.zzr.zzli().zza(context, zzbar.zzaau()).zza("google.afma.sdkConstants.getSdkConstants", zzamn.zzdma, zzamn.zzdma);
    }

    @Override // com.google.android.gms.internal.ads.zzaun
    public final zzamg<JSONObject, JSONObject> zzwv() {
        return this.zzeal;
    }
}
