package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyr extends zzbxq<zzbyw> implements zzbyw {
    public zzbyr(Set<zzbzl<zzbyw>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzfu(String str) {
        zza(new zzbxs(str) { // from class: com.google.android.gms.internal.ads.zzbyq
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbyw) obj).zzfu(this.zzdmo);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzfv(String str) {
        zza(new zzbxs(str) { // from class: com.google.android.gms.internal.ads.zzbyt
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbyw) obj).zzfv(this.zzdmo);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzn(String str, String str2) {
        zza(new zzbxs(str, str2) { // from class: com.google.android.gms.internal.ads.zzbys
            private final String zzdkl;
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdkl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbyw) obj).zzn(this.zzdmo, this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzang() {
        zza(zzbyv.zzgbn);
    }

    @Override // com.google.android.gms.internal.ads.zzbyw
    public final void zzanh() {
        zza(zzbyu.zzgbn);
    }
}
