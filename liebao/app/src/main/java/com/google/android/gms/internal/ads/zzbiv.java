package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbiv implements zzdlh {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;
    private zzvt zzfqd;

    private zzbiv(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final zzdli zzain() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        zzesg.zza(this.zzfqd, zzvt.class);
        return new zzbiy(this.zzfhy, this.zzfob, this.zzfoc, this.zzfqd);
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final /* synthetic */ zzdlh zzc(zzvt zzvtVar) {
        this.zzfqd = (zzvt) zzesg.checkNotNull(zzvtVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final /* synthetic */ zzdlh zzfq(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdlh
    public final /* synthetic */ zzdlh zzcb(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
