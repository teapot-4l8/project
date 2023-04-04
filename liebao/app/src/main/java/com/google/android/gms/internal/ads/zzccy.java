package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzccy implements zzesa<zzqt> {
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzfvk;

    public zzccy(zzesn<zzbar> zzesnVar, zzesn<String> zzesnVar2) {
        this.zzfvj = zzesnVar;
        this.zzfvk = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        com.google.android.gms.ads.internal.zzr.zzkv();
        return (zzqt) zzesg.zzbd(new zzqt(com.google.android.gms.ads.internal.util.zzj.zzzr(), this.zzfvj.get(), this.zzfvk.get(), new JSONObject(), false, true));
    }
}
