package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsj;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsq implements zzesa<zzbsj.zza> {
    private final zzbsj zzgbg;

    private zzbsq(zzbsj zzbsjVar) {
        this.zzgbg = zzbsjVar;
    }

    public static zzbsq zzm(zzbsj zzbsjVar) {
        return new zzbsq(zzbsjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbsj.zza) zzesg.zzbd(this.zzgbg.zzame());
    }
}
