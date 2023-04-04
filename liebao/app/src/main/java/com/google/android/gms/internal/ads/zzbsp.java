package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsp extends zzzb {
    private final List<zzvx> zzaed;
    private final String zzgbh;
    private final String zzgbi;

    public zzbsp(zzdot zzdotVar, String str, zzctc zzctcVar) {
        this.zzgbi = zzdotVar == null ? null : zzdotVar.zzgbi;
        String zzb = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) ? zzb(zzdotVar) : null;
        this.zzgbh = zzb != null ? zzb : str;
        this.zzaed = zzctcVar.getAdapterResponses();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getMediationAdapterClassName() {
        return this.zzgbh;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String getResponseId() {
        return this.zzgbi;
    }

    private static String zzb(zzdot zzdotVar) {
        try {
            return zzdotVar.zzhmk.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final List<zzvx> getAdapterResponses() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            return this.zzaed;
        }
        return null;
    }
}
