package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzayb implements zzays {
    private Context zzaai;
    private zzayd zzbrf;
    private com.google.android.gms.ads.internal.util.zzf zzecu;

    private zzayb() {
    }

    @Override // com.google.android.gms.internal.ads.zzays
    public final zzayt zzxu() {
        zzesg.zza(this.zzaai, Context.class);
        zzesg.zza(this.zzecu, com.google.android.gms.ads.internal.util.zzf.class);
        zzesg.zza(this.zzbrf, zzayd.class);
        return new zzaxz(this.zzaai, this.zzecu, this.zzbrf);
    }

    @Override // com.google.android.gms.internal.ads.zzays
    public final /* synthetic */ zzays zza(zzayd zzaydVar) {
        this.zzbrf = (zzayd) zzesg.checkNotNull(zzaydVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzays
    public final /* synthetic */ zzays zza(com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzecu = (com.google.android.gms.ads.internal.util.zzf) zzesg.checkNotNull(zzfVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzays
    public final /* synthetic */ zzays zzz(Context context) {
        this.zzaai = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
