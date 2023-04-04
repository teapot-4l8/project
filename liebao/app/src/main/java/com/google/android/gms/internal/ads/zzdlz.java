package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlz<RequestComponentT extends zzbsh<AdT>, AdT> implements zzdmh<RequestComponentT, AdT> {
    private RequestComponentT zzhjx;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdmh
    /* renamed from: zzavn */
    public final synchronized RequestComponentT zzavm() {
        return this.zzhjx;
    }

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final synchronized zzebt<AdT> zza(zzdmm zzdmmVar, zzdmj<RequestComponentT> zzdmjVar) {
        RequestComponentT zzahg;
        zzahg = zzdmjVar.zzc(zzdmmVar.zzhku).zzahg();
        this.zzhjx = zzahg;
        return zzahg.zzahd().zzalv();
    }
}
