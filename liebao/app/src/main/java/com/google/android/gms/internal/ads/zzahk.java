package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahk implements zzaig<Object> {
    private final zzahn zzdic;

    public zzahk(zzahn zzahnVar) {
        this.zzdic = zzahnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzdic == null) {
            return;
        }
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzey("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundle = null;
        if (map.containsKey("info")) {
            try {
                bundle = com.google.android.gms.ads.internal.util.zzbh.zzh(new JSONObject(map.get("info")));
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Failed to convert ad metadata to JSON.", e2);
            }
        }
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to convert ad metadata to Bundle.");
        } else {
            this.zzdic.zza(str, bundle);
        }
    }
}
