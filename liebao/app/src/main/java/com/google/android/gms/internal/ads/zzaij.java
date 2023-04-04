package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaij implements zzaig<zzbfi> {
    private final zzaii zzdja;

    public zzaij(zzaii zzaiiVar) {
        this.zzdja = zzaiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        zzbfi zzbfiVar2 = zzbfiVar;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Fail to parse float", e2);
        }
        this.zzdja.zzac(equals);
        this.zzdja.zza(equals2, f);
        zzbfiVar2.zzac(equals);
    }
}
