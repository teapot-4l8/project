package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdkd implements com.google.android.gms.ads.internal.overlay.zzp, zzbsz, zzbus, zzbvb, zzdmi {
    private final zzdqs zzhis;
    private final AtomicReference<zzsq> zzhit = new AtomicReference<>();
    private final AtomicReference<zzsv> zzhiu = new AtomicReference<>();
    private final AtomicReference<zzsw> zzhiv = new AtomicReference<>();
    private final AtomicReference<zzbus> zzhiw = new AtomicReference<>();
    private final AtomicReference<com.google.android.gms.ads.internal.overlay.zzp> zzhix = new AtomicReference<>();
    private final AtomicReference<zzyx> zzhax = new AtomicReference<>();
    private zzdkd zzhiy = null;

    public zzdkd(zzdqs zzdqsVar) {
        this.zzhis = zzdqsVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    public static zzdkd zzb(zzdkd zzdkdVar) {
        zzdkd zzdkdVar2 = new zzdkd(zzdkdVar.zzhis);
        zzdkdVar2.zzb((zzdmi) zzdkdVar);
        return zzdkdVar2;
    }

    public final void zzb(zzsq zzsqVar) {
        this.zzhit.set(zzsqVar);
    }

    public final void zzb(zzsv zzsvVar) {
        this.zzhiu.set(zzsvVar);
    }

    public final void zza(zzsw zzswVar) {
        this.zzhiv.set(zzswVar);
    }

    public final void zza(zzbus zzbusVar) {
        this.zzhiw.set(zzbusVar);
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zzhix.set(zzpVar);
    }

    public final void zzb(zzyx zzyxVar) {
        this.zzhax.set(zzyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzb(zzvv zzvvVar) {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhax, new zzdma(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzdkg
                    private final zzvv zzgch;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgch = zzvvVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzyx) obj).zza(this.zzgch);
                    }
                });
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    public final void zzb(zzsp zzspVar) {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhit, new zzdma(zzspVar) { // from class: com.google.android.gms.internal.ads.zzdkf
                    private final zzsp zzhiz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhiz = zzspVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzsq) obj).zza(this.zzhiz);
                    }
                });
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhit, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzdkk
                    private final zzvh zzgbo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbo = zzvhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzsq) obj).zza(this.zzgbo);
                    }
                });
                zzdlx.zza(zzdkdVar.zzhit, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzdkj
                    private final zzvh zzgbo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbo = zzvhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzsq) obj).onAppOpenAdFailedToLoad(this.zzgbo.errorCode);
                    }
                });
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    public final void onAdClosed() {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdkdVar.zzhis.onAdClosed();
                zzdlx.zza(zzdkdVar.zzhiu, zzdkm.zzhbd);
                zzdlx.zza(zzdkdVar.zzhiv, zzdkl.zzhbd);
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzamk() {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhiw, zzdko.zzhbd);
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhix, zzdkn.zzhbd);
                zzdlx.zza(zzdkdVar.zzhiv, zzdkq.zzhbd);
                zzdlx.zza(zzdkdVar.zzhiv, zzdkp.zzhbd);
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhix, new zzdma(zzlVar) { // from class: com.google.android.gms.internal.ads.zzdki
                    private final com.google.android.gms.ads.internal.overlay.zzl zzgbu;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbu = zzlVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((com.google.android.gms.ads.internal.overlay.zzp) obj).zza(this.zzgbu);
                    }
                });
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
        zzdkd zzdkdVar = this;
        while (true) {
            zzdkd zzdkdVar2 = zzdkdVar.zzhiy;
            if (zzdkdVar2 == null) {
                zzdlx.zza(zzdkdVar.zzhix, zzdkh.zzhbd);
                return;
            }
            zzdkdVar = zzdkdVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdmi
    public final void zzb(zzdmi zzdmiVar) {
        this.zzhiy = (zzdkd) zzdmiVar;
    }
}
