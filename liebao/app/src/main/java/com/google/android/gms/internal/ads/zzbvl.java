package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbvl extends AdMetadataListener implements AppEventListener, com.google.android.gms.ads.internal.overlay.zzp, zzbsy, zzbtm, zzbtq, zzbus, zzbvb, zzve {
    private final zzbwp zzgcb = new zzbwp(this);
    @Nullable
    private zzczm zzgcc;
    @Nullable
    private zzdaj zzgcd;
    @Nullable
    private zzdkd zzgce;
    @Nullable
    private zzdnb zzgcf;

    public final zzbwp zzaln() {
        return this.zzgcb;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        zza(this.zzgcc, zzbvo.zzgcg);
        zza(this.zzgcf, zzbvn.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        zza(this.zzgcc, zzbwa.zzgcg);
        zza(this.zzgcf, zzbwh.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
        zza(this.zzgcc, zzbwk.zzgcg);
        zza(this.zzgcf, zzbwj.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
        zza(this.zzgcc, zzbwm.zzgcg);
        zza(this.zzgcf, zzbwl.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(final zzavd zzavdVar, final String str, final String str2) {
        zza(this.zzgcc, new zzbws(zzavdVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbwo
            private final String zzdkl;
            private final String zzdmx;
            private final zzavd zzgbs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbs = zzavdVar;
                this.zzdkl = str;
                this.zzdmx = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                zzczm zzczmVar = (zzczm) obj;
            }
        });
        zza(this.zzgcf, new zzbws(zzavdVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbwn
            private final String zzdkl;
            private final String zzdmx;
            private final zzavd zzgbs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbs = zzavdVar;
                this.zzdkl = str;
                this.zzdmx = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzdnb) obj).zzb(this.zzgbs, this.zzdkl, this.zzdmx);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
        zza(this.zzgcc, zzbvq.zzgcg);
        zza(this.zzgcf, zzbvp.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        zza(this.zzgcc, zzbvs.zzgcg);
        zza(this.zzgcd, zzbvr.zzgcg);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zza(this.zzgcc, new zzbws(str, str2) { // from class: com.google.android.gms.internal.ads.zzbvu
            private final String zzdkl;
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdkl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzczm) obj).onAppEvent(this.zzdmo, this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzb(final zzvv zzvvVar) {
        zza(this.zzgcc, new zzbws(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzbvt
            private final zzvv zzgch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgch = zzvvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzczm) obj).zzb(this.zzgch);
            }
        });
        zza(this.zzgcf, new zzbws(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzbvw
            private final zzvv zzgch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgch = zzvvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzdnb) obj).zzb(this.zzgch);
            }
        });
        zza(this.zzgce, new zzbws(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzbvv
            private final zzvv zzgch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgch = zzvvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzdkd) obj).zzb(this.zzgch);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        zza(this.zzgcc, zzbvy.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzamk() {
        zza(this.zzgce, zzbvx.zzgcg);
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zza(this.zzgcf, zzbvz.zzgcg);
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void zzk(final zzvh zzvhVar) {
        zza(this.zzgcf, new zzbws(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzbwc
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzdnb) obj).zzk(this.zzgbo);
            }
        });
        zza(this.zzgcc, new zzbws(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzbwb
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzczm) obj).zzk(this.zzgbo);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        zza(this.zzgce, zzbwe.zzgcg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(final com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        zza(this.zzgce, new zzbws(zzlVar) { // from class: com.google.android.gms.internal.ads.zzbwd
            private final com.google.android.gms.ads.internal.overlay.zzl zzgbu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbu = zzlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbws
            public final void zzp(Object obj) {
                ((zzdkd) obj).zza(this.zzgbu);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
        zza(this.zzgce, zzbwg.zzgcg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
        zza(this.zzgce, zzbwf.zzgcg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
        zza(this.zzgce, zzbwi.zzgcg);
    }

    private static <T> void zza(T t, zzbws<T> zzbwsVar) {
        if (t != null) {
            zzbwsVar.zzp(t);
        }
    }
}
