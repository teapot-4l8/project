package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.ak;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcqo implements zzaml<zzcqp> {
    @Override // com.google.android.gms.internal.ads.zzaml
    public final /* synthetic */ JSONObject zzi(zzcqp zzcqpVar) {
        zzcqp zzcqpVar2 = zzcqpVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcqpVar2.zzgsg.zzwx());
        jSONObject2.put("signals", zzcqpVar2.zzgsh);
        jSONObject3.put("body", zzcqpVar2.zzgsj.zzdxg);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.zzr.zzkv().zzj(zzcqpVar2.zzgsj.zzaj));
        jSONObject3.put("response_code", zzcqpVar2.zzgsj.zzgsr);
        jSONObject3.put(ak.aS, zzcqpVar2.zzgsj.zzgss);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcqpVar2.zzgsg.zzxb());
        return jSONObject;
    }
}
