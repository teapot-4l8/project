package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbjb implements zzdnc {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;
    private zzvt zzfqd;

    private zzbjb(zzbie zzbieVar) {
        this.zzfhy = zzbieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdnc
    public final zzdmz zzais() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        zzesg.zza(this.zzfqd, zzvt.class);
        return new zzbje(this.zzfhy, this.zzfob, this.zzfoc, this.zzfqd);
    }

    @Override // com.google.android.gms.internal.ads.zzdnc
    public final /* synthetic */ zzdnc zzd(zzvt zzvtVar) {
        this.zzfqd = (zzvt) zzesg.checkNotNull(zzvtVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnc
    public final /* synthetic */ zzdnc zzfr(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdnc
    public final /* synthetic */ zzdnc zzcc(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
