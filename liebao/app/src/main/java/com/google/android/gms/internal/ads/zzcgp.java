package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgp {
    private final Executor executor;
    private final zzcgf zzgkb;

    public zzcgp(Executor executor, zzcgf zzcgfVar) {
        this.executor = executor;
        this.zzgkb = zzcgfVar;
    }

    public final zzebt<List<zzcgq>> zzg(JSONObject jSONObject, String str) {
        zzebt zzag;
        String optString;
        char c2;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzebh.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)) != null) {
                String optString2 = optJSONObject.optString(d.y);
                if ("string".equals(optString2)) {
                    c2 = 1;
                } else {
                    c2 = "image".equals(optString2) ? (char) 2 : (char) 0;
                }
                if (c2 == 1) {
                    zzag = zzebh.zzag(new zzcgq(optString, optJSONObject.optString("string_value")));
                } else if (c2 == 2) {
                    zzag = zzebh.zzb(this.zzgkb.zzc(optJSONObject, "image_value"), new zzdxw(optString) { // from class: com.google.android.gms.internal.ads.zzcgr
                        private final String zzdmo;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdmo = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdxw
                        public final Object apply(Object obj) {
                            return new zzcgq(this.zzdmo, (zzaee) obj);
                        }
                    }, this.executor);
                }
                arrayList.add(zzag);
            }
            zzag = zzebh.zzag(null);
            arrayList.add(zzag);
        }
        return zzebh.zzb(zzebh.zzi(arrayList), zzcgo.zzebv, this.executor);
    }
}
