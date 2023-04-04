package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzahz implements zzaig<zzbfi> {
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        JSONObject zztq;
        zzbfi zzbfiVar2 = zzbfiVar;
        zzaeg zzaeq = zzbfiVar2.zzaeq();
        if (zzaeq != null && (zztq = zzaeq.zztq()) != null) {
            zzbfiVar2.zza("nativeAdViewSignalsReady", zztq);
        } else {
            zzbfiVar2.zza("nativeAdViewSignalsReady", new JSONObject());
        }
    }
}
