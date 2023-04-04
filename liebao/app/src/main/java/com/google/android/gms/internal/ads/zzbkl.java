package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkl {
    private final Map<String, zzbkm> zzftg;
    private final Map<String, zzbkn> zzfth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkl(Map<String, zzbkm> map, Map<String, zzbkn> map2) {
        this.zzftg = map;
        this.zzfth = map2;
    }

    public final void zzb(zzdpi zzdpiVar) {
        for (zzdpf zzdpfVar : zzdpiVar.zzhnt.zzhnr) {
            if (this.zzftg.containsKey(zzdpfVar.name)) {
                this.zzftg.get(zzdpfVar.name).zzi(zzdpfVar.zzhnp);
            } else if (this.zzfth.containsKey(zzdpfVar.name)) {
                zzbkn zzbknVar = this.zzfth.get(zzdpfVar.name);
                JSONObject jSONObject = zzdpfVar.zzhnp;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzbknVar.zzm(hashMap);
            }
        }
    }
}
