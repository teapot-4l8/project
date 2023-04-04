package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdnb extends AdMetadataListener implements zzbsy, zzbsz, zzbtm, zzbuj, zzbvb, zzdmi {
    private final zzdqs zzhis;
    private final AtomicReference<AdMetadataListener> zzhlb = new AtomicReference<>();
    private final AtomicReference<zzawn> zzhlc = new AtomicReference<>();
    private final AtomicReference<zzawg> zzhld = new AtomicReference<>();
    private final AtomicReference<zzavn> zzhle = new AtomicReference<>();
    private final AtomicReference<zzawo> zzhlf = new AtomicReference<>();
    private final AtomicReference<zzave> zzhlg = new AtomicReference<>();
    private final AtomicReference<zzyx> zzhlh = new AtomicReference<>();
    private zzdnb zzhli = null;

    public zzdnb(zzdqs zzdqsVar) {
        this.zzhis = zzdqsVar;
    }

    public final void zzb(zzawn zzawnVar) {
        this.zzhlc.set(zzawnVar);
    }

    public final void zzb(zzawg zzawgVar) {
        this.zzhld.set(zzawgVar);
    }

    public final void zzb(zzawo zzawoVar) {
        this.zzhlf.set(zzawoVar);
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzhlb.set(adMetadataListener);
    }

    public final void zzd(zzyx zzyxVar) {
        this.zzhlh.set(zzyxVar);
    }

    @Deprecated
    public final void zzb(zzavn zzavnVar) {
        this.zzhle.set(zzavnVar);
    }

    @Deprecated
    public final void zzb(zzave zzaveVar) {
        this.zzhlg.set(zzaveVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhlc, zzdne.zzhbd);
                zzdlx.zza(zzdnbVar.zzhle, zzdnd.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                int i = zzvhVar.errorCode;
                zzdlx.zza(zzdnbVar.zzhlc, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzdnq
                    private final zzvh zzgbo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbo = zzvhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzawn) obj).zzj(this.zzgbo);
                    }
                });
                zzdlx.zza(zzdnbVar.zzhlc, new zzdma(i) { // from class: com.google.android.gms.internal.ads.zzdns
                    private final int zzejz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzejz = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzawn) obj).onRewardedAdFailedToLoad(this.zzejz);
                    }
                });
                zzdlx.zza(zzdnbVar.zzhle, new zzdma(i) { // from class: com.google.android.gms.internal.ads.zzdnr
                    private final int zzejz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzejz = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzavn) obj).onRewardedVideoAdFailedToLoad(this.zzejz);
                    }
                });
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhld, zzdnu.zzhbd);
                zzdlx.zza(zzdnbVar.zzhle, zzdnt.zzhbd);
                zzdlx.zza(zzdnbVar.zzhld, zzdnw.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdnbVar.zzhis.onAdClosed();
                zzdlx.zza(zzdnbVar.zzhld, zzdnv.zzhbd);
                zzdlx.zza(zzdnbVar.zzhle, zzdny.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhle, zzdng.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhle, zzdnf.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(zzavd zzavdVar, String str, String str2) {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhld, new zzdma(zzavdVar) { // from class: com.google.android.gms.internal.ads.zzdni
                    private final zzavd zzgbs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbs = zzavdVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        zzavd zzavdVar2 = this.zzgbs;
                        ((zzawg) obj).zza(new zzaxb(zzavdVar2.getType(), zzavdVar2.getAmount()));
                    }
                });
                zzdlx.zza(zzdnbVar.zzhlf, new zzdma(zzavdVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdnh
                    private final String zzdkl;
                    private final String zzdmx;
                    private final zzavd zzgbs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbs = zzavdVar;
                        this.zzdkl = str;
                        this.zzdmx = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        zzavd zzavdVar2 = this.zzgbs;
                        ((zzawo) obj).zza(new zzaxb(zzavdVar2.getType(), zzavdVar2.getAmount()), this.zzdkl, this.zzdmx);
                    }
                });
                zzdlx.zza(zzdnbVar.zzhle, new zzdma(zzavdVar) { // from class: com.google.android.gms.internal.ads.zzdnk
                    private final zzavd zzgbs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbs = zzavdVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzavn) obj).zza(this.zzgbs);
                    }
                });
                zzdlx.zza(zzdnbVar.zzhlg, new zzdma(zzavdVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdnj
                    private final String zzdkl;
                    private final String zzdmx;
                    private final zzavd zzgbs;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbs = zzavdVar;
                        this.zzdkl = str;
                        this.zzdmx = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzave) obj).zza(this.zzgbs, this.zzdkl, this.zzdmx);
                    }
                });
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhle, zzdnm.zzhbd);
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void zzk(zzvh zzvhVar) {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhld, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzdnl
                    private final zzvh zzgbo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbo = zzvhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzawg) obj).zzi(this.zzgbo);
                    }
                });
                zzdlx.zza(zzdnbVar.zzhld, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzdno
                    private final zzvh zzgbo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgbo = zzvhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdma
                    public final void zzp(Object obj) {
                        ((zzawg) obj).onRewardedAdFailedToShow(this.zzgbo.errorCode);
                    }
                });
                return;
            }
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzdnb zzdnbVar = this.zzhli;
        if (zzdnbVar != null) {
            zzdnbVar.onAdMetadataChanged();
        } else {
            zzdlx.zza(this.zzhlb, zzdnn.zzhbd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzb(zzvv zzvvVar) {
        zzdnb zzdnbVar = this;
        while (true) {
            zzdnb zzdnbVar2 = zzdnbVar.zzhli;
            if (zzdnbVar2 == null) {
                zzdlx.zza(zzdnbVar.zzhlh, new zzdma(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzdnp
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
            zzdnbVar = zzdnbVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdmi
    public final void zzb(zzdmi zzdmiVar) {
        this.zzhli = (zzdnb) zzdmiVar;
    }
}
