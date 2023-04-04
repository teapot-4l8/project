package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbur extends zzbxq<com.google.android.gms.ads.internal.overlay.zzp> implements com.google.android.gms.ads.internal.overlay.zzp {
    public zzbur(Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        zza(new zzbxs(zzlVar) { // from class: com.google.android.gms.internal.ads.zzbuu
            private final com.google.android.gms.ads.internal.overlay.zzl zzgbu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbu = zzlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzp) obj).zza(this.zzgbu);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onUserLeaveHint() {
        zza(zzbut.zzgbn);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        zza(zzbuw.zzgbn);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        zza(zzbuv.zzgbn);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzvz() {
        zza(zzbuy.zzgbn);
    }
}
