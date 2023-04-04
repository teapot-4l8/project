package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdtj extends zzbxq<zzdtm> implements zzdte<zzdth> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtj(Set<zzbzl<zzdtm>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final void zza(zzdst<zzdth, ?> zzdstVar) {
        zza(new zzbxs(zzdstVar) { // from class: com.google.android.gms.internal.ads.zzdti
            private final zzdst zzhuh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuh = zzdstVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                zzdst zzdstVar2 = this.zzhuh;
                ((zzdtm) obj).zza((zzdth) zzdstVar2.zzayg(), zzdstVar2.zzayh());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final void zzb(zzdst<zzdth, ?> zzdstVar) {
        zza(new zzbxs(zzdstVar) { // from class: com.google.android.gms.internal.ads.zzdtl
            private final zzdst zzhuh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuh = zzdstVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                zzdst zzdstVar2 = this.zzhuh;
                ((zzdtm) obj).zzb((zzdth) zzdstVar2.zzayg(), zzdstVar2.zzayh());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final void zza(zzdst<zzdth, ?> zzdstVar, Throwable th) {
        zza(new zzbxs(zzdstVar, th) { // from class: com.google.android.gms.internal.ads.zzdtk
            private final zzdst zzhuh;
            private final Throwable zzhui;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuh = zzdstVar;
                this.zzhui = th;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                zzdst zzdstVar2 = this.zzhuh;
                ((zzdtm) obj).zza((zzdth) zzdstVar2.zzayg(), zzdstVar2.zzayh(), this.zzhui);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdte
    public final void zzc(zzdst<zzdth, ?> zzdstVar) {
        zza(new zzbxs(zzdstVar) { // from class: com.google.android.gms.internal.ads.zzdtn
            private final zzdst zzhuh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuh = zzdstVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                zzdst zzdstVar2 = this.zzhuh;
                ((zzdtm) obj).zzc((zzdth) zzdstVar2.zzayg(), zzdstVar2.zzayh());
            }
        });
    }
}
