package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsl implements zzesa<String> {
    private final zzesn<zzbqr> zzfdm;
    private final zzbsj zzgbg;

    private zzbsl(zzbsj zzbsjVar, zzesn<zzbqr> zzesnVar) {
        this.zzgbg = zzbsjVar;
        this.zzfdm = zzesnVar;
    }

    public static zzbsl zzb(zzbsj zzbsjVar, zzesn<zzbqr> zzesnVar) {
        return new zzbsl(zzbsjVar, zzesnVar);
    }

    public static String zza(zzbsj zzbsjVar, zzbqr zzbqrVar) {
        return (String) zzesg.zzbd(zzbqrVar.zzye());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzgbg, this.zzfdm.get());
    }
}
