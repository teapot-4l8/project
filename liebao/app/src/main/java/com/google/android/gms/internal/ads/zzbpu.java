package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpu implements zzesa<String> {
    private final zzbps zzfzb;

    private zzbpu(zzbps zzbpsVar) {
        this.zzfzb = zzbpsVar;
    }

    public static zzbpu zza(zzbps zzbpsVar) {
        return new zzbpu(zzbpsVar);
    }

    public static String zzb(zzbps zzbpsVar) {
        return (String) zzesg.zzbd(zzbpsVar.zzalt());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzb(this.zzfzb);
    }
}
