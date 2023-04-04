package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaic implements zzaig<zzbfi> {
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        zzbfi zzbfiVar2 = zzbfiVar;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbfiVar2.zzkr();
        } else if ("resume".equals(str)) {
            zzbfiVar2.zzks();
        }
    }
}
