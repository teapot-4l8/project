package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdse implements zzesa<zzebs> {
    public static zzdse zzaxt() {
        zzdse zzdseVar;
        zzdseVar = zzdsh.zzhso;
        return zzdseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzebs zzebsVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxq)).booleanValue()) {
            zzebsVar = zzbat.zzekg;
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcxp)).booleanValue()) {
                zzebsVar = zzbat.zzeke;
            } else {
                zzebsVar = zzbat.zzeki;
            }
        }
        return (zzebs) zzesg.zzbd(zzebsVar);
    }
}
