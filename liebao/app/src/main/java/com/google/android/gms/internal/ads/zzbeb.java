package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeb implements zzbes {
    @Override // com.google.android.gms.internal.ads.zzbes
    public final zzbek zza(zzbcs zzbcsVar, int i, String str, zzbcp zzbcpVar) {
        if (i > 0) {
            int zzadf = zzbdn.zzadf();
            if (zzadf < zzbcpVar.zzeno) {
                return new zzbev(zzbcsVar, zzbcpVar);
            }
            if (zzadf < zzbcpVar.zzeni) {
                return new zzbew(zzbcsVar, zzbcpVar);
            }
            return new zzbeu(zzbcsVar);
        }
        return new zzber(zzbcsVar);
    }
}
