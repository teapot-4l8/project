package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbip implements zzdjy {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;

    private zzbip(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final zzdjv zzaic() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        return new zzbis(this.zzfhy, this.zzfob, this.zzfoc);
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* synthetic */ zzdjy zzfp(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjy
    public final /* synthetic */ zzdjy zzca(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
