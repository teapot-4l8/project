package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzamx {
    private zzale zzdmm;
    private zzebt<zzamc> zzdmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamx(zzale zzaleVar) {
        this.zzdmm = zzaleVar;
    }

    private final void zzvc() {
        if (this.zzdmn == null) {
            final zzbbe zzbbeVar = new zzbbe();
            this.zzdmn = zzbbeVar;
            this.zzdmm.zzb((zzei) null).zza(new zzbbi(zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzamw
                private final zzbbe zzbwk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwk = zzbbeVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbi
                public final void zzg(Object obj) {
                    this.zzbwk.set((zzamc) obj);
                }
            }, new zzbbg(zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzamz
                private final zzbbe zzbwk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwk = zzbbeVar;
                }

                @Override // com.google.android.gms.internal.ads.zzbbg
                public final void run() {
                    this.zzbwk.setException(new zzamh("Cannot get Javascript Engine"));
                }
            });
        }
    }

    public final <I, O> zzana<I, O> zzb(String str, zzaml<I> zzamlVar, zzami<O> zzamiVar) {
        zzvc();
        return new zzana<>(this.zzdmn, str, zzamlVar, zzamiVar);
    }

    public final void zzc(final String str, final zzaig<? super zzamc> zzaigVar) {
        zzvc();
        this.zzdmn = zzebh.zzb(this.zzdmn, new zzear(str, zzaigVar) { // from class: com.google.android.gms.internal.ads.zzamy
            private final String zzdmo;
            private final zzaig zzdmp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdmp = zzaigVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                zzamc zzamcVar = (zzamc) obj;
                zzamcVar.zza(this.zzdmo, this.zzdmp);
                return zzebh.zzag(zzamcVar);
            }
        }, zzbat.zzekj);
    }

    public final void zzd(String str, zzaig<? super zzamc> zzaigVar) {
        this.zzdmn = zzebh.zzb(this.zzdmn, new zzdxw(str, zzaigVar) { // from class: com.google.android.gms.internal.ads.zzanb
            private final String zzdmo;
            private final zzaig zzdmp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdmp = zzaigVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                zzamc zzamcVar = (zzamc) obj;
                zzamcVar.zzb(this.zzdmo, this.zzdmp);
                return zzamcVar;
            }
        }, zzbat.zzekj);
    }
}
