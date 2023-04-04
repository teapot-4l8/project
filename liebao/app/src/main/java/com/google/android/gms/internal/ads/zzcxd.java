package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxd implements zzcta<zzdqd, zzcuu> {
    private final zzckb zzgph;
    private final Map<String, zzctb<zzdqd, zzcuu>> zzgym = new HashMap();

    public zzcxd(zzckb zzckbVar) {
        this.zzgph = zzckbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzctb<zzdqd, zzcuu> zzf(String str, JSONObject jSONObject) {
        synchronized (this) {
            zzctb<zzdqd, zzcuu> zzctbVar = this.zzgym.get(str);
            if (zzctbVar == null) {
                zzdqd zzd = this.zzgph.zzd(str, jSONObject);
                if (zzd == null) {
                    return null;
                }
                zzctbVar = new zzctb<>(zzd, new zzcuu(), str);
                this.zzgym.put(str, zzctbVar);
            }
            return zzctbVar;
        }
    }
}
