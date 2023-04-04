package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbjd implements zzdoo {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;

    private zzbjd(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdoo
    public final zzdol zzaiv() {
        zzesg.zza(this.zzfob, Context.class);
        return new zzbjg(this.zzfhy, this.zzfob, this.zzfoc);
    }

    @Override // com.google.android.gms.internal.ads.zzdoo
    public final /* synthetic */ zzdoo zzfs(String str) {
        this.zzfoc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdoo
    public final /* synthetic */ zzdoo zzcd(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
