package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaie implements zzaig<zzbfi> {
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        zzbfi zzbfiVar2 = zzbfiVar;
        if (map.keySet().contains("start")) {
            zzbfiVar2.zzbg(true);
        }
        if (map.keySet().contains("stop")) {
            zzbfiVar2.zzbg(false);
        }
    }
}
