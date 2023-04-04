package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdlp<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdru<AdT> {
    private final zzdmh<R, zzdrj<AdT>> zzhke;

    public zzdlp(zzdmh<R, zzdrj<AdT>> zzdmhVar) {
        this.zzhke = zzdmhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void zzb(Throwable th) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdru
    public final zzebt<zzdrj<AdT>> zza(zzdrx zzdrxVar) {
        zzdls zzdlsVar = (zzdls) zzdrxVar;
        return this.zzhke.zza(zzdlsVar.zzhki, zzdlsVar.zzhkh);
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void zza(zzdrj<AdT> zzdrjVar) {
        zzdrjVar.zzhrj = this.zzhke.zzavm().zzahd();
    }
}
