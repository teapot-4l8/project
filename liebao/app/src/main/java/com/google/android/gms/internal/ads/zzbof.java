package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbof implements zzesa<zzcsz<zzbne>> {
    private final zzesn<zzcxw<zzbne, zzdqd, zzcuv>> zzffm;
    private final zzesn<Boolean> zzfpu;
    private final zzesn<zzcwe> zzfpw;

    public zzbof(zzesn<Boolean> zzesnVar, zzesn<zzcwe> zzesnVar2, zzesn<zzcxw<zzbne, zzdqd, zzcuv>> zzesnVar3) {
        this.zzfpu = zzesnVar;
        this.zzfpw = zzesnVar2;
        this.zzffm = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfpu.get().booleanValue();
        zzcwe zzcweVar = this.zzfpw.get();
        zzcxw<zzbne, zzdqd, zzcuv> zzcxwVar = this.zzffm.get();
        if (!booleanValue) {
            zzcweVar = zzcxwVar;
        }
        return (zzcsz) zzesg.zzbd(zzcweVar);
    }
}
