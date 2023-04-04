package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblo implements zzesa<zzqt> {
    private final zzesn<JSONObject> zzfli;
    private final zzesn<zzdot> zzfvi;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzfvk;

    private zzblo(zzesn<zzdot> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<JSONObject> zzesnVar3, zzesn<String> zzesnVar4) {
        this.zzfvi = zzesnVar;
        this.zzfvj = zzesnVar2;
        this.zzfli = zzesnVar3;
        this.zzfvk = zzesnVar4;
    }

    public static zzblo zza(zzesn<zzdot> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<JSONObject> zzesnVar3, zzesn<String> zzesnVar4) {
        return new zzblo(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        this.zzfvi.get();
        zzbar zzbarVar = this.zzfvj.get();
        JSONObject jSONObject = this.zzfli.get();
        String str = this.zzfvk.get();
        boolean equals = "native".equals(str);
        com.google.android.gms.ads.internal.zzr.zzkv();
        return (zzqt) zzesg.zzbd(new zzqt(com.google.android.gms.ads.internal.util.zzj.zzzr(), zzbarVar, str, jSONObject, false, equals));
    }
}
