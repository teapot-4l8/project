package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzex implements zzdwy {
    private final zzfj zzxo;
    private final zzduz zzys;
    private final zzdvl zzyt;
    private final zzfa zzyu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzex(zzduz zzduzVar, zzdvl zzdvlVar, zzfj zzfjVar, zzfa zzfaVar) {
        this.zzys = zzduzVar;
        this.zzyt = zzdvlVar;
        this.zzxo = zzfjVar;
        this.zzyu = zzfaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(View view) {
        this.zzxo.zze(view);
    }

    private final Map<String, Object> zzcc() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzcp = this.zzyt.zzcp();
        hashMap.put(ak.aE, this.zzys.zzayo());
        hashMap.put("gms", Boolean.valueOf(this.zzys.zzcn()));
        hashMap.put("int", zzcp.zzaf());
        hashMap.put("up", Boolean.valueOf(this.zzyu.zzcg()));
        hashMap.put(ak.aH, new Throwable());
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Map<String, Object> zzcd() {
        Map<String, Object> zzcc = zzcc();
        zzcf.zza zzayv = this.zzyt.zzayv();
        zzcc.put("gai", Boolean.valueOf(this.zzys.zzayp()));
        zzcc.put("did", zzayv.zzak());
        zzcc.put("dst", Integer.valueOf(zzayv.zzal().zzv()));
        zzcc.put("doo", Boolean.valueOf(zzayv.zzam()));
        return zzcc;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Map<String, Object> zzce() {
        return zzcc();
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Map<String, Object> zzcf() {
        Map<String, Object> zzcc = zzcc();
        zzcc.put("lts", Long.valueOf(this.zzxo.zzcv()));
        return zzcc;
    }
}
