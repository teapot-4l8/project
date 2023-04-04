package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczm implements AppEventListener, zzbsy, zzbsz, zzbtm, zzbtq, zzbuj, zzbvb, zzbvm, zzve {
    private final zzdtw zzdjf;
    private final AtomicReference<zzxc> zzhav = new AtomicReference<>();
    private final AtomicReference<zzxy> zzhaw = new AtomicReference<>();
    private final AtomicReference<zzyx> zzhax = new AtomicReference<>();
    private final AtomicReference<zzxd> zzhay = new AtomicReference<>();
    private final AtomicReference<zzyg> zzhaz = new AtomicReference<>();
    private final AtomicBoolean zzhba = new AtomicBoolean(true);
    private final BlockingQueue<Pair<String, String>> zzhbb = new ArrayBlockingQueue(((Integer) zzww.zzra().zzd(zzabq.zzdbp)).intValue());

    public zzczm(zzdtw zzdtwVar) {
        this.zzdjf = zzdtwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(zzavd zzavdVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
    }

    public final synchronized zzxc zzate() {
        return this.zzhav.get();
    }

    public final synchronized zzxy zzatf() {
        return this.zzhaw.get();
    }

    public final void zzc(zzxc zzxcVar) {
        this.zzhav.set(zzxcVar);
    }

    public final void zzb(zzxy zzxyVar) {
        this.zzhaw.set(zzxyVar);
    }

    public final void zzb(zzyx zzyxVar) {
        this.zzhax.set(zzyxVar);
    }

    public final void zza(zzxd zzxdVar) {
        this.zzhay.set(zzxdVar);
    }

    public final void zzb(zzyg zzygVar) {
        this.zzhaz.set(zzygVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        this.zzhba.set(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        zzdlx.zza(this.zzhav, zzczp.zzhbd);
        zzdlx.zza(this.zzhaz, zzczo.zzhbd);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        zzdlx.zza(this.zzhav, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzczw
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzxc) obj).zzc(this.zzgbo);
            }
        });
        zzdlx.zza(this.zzhav, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzczz
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzxc) obj).onAdFailedToLoad(this.zzgbo.errorCode);
            }
        });
        zzdlx.zza(this.zzhay, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzczy
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzxd) obj).zzd(this.zzgbo);
            }
        });
        this.zzhba.set(false);
        this.zzhbb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
        zzdlx.zza(this.zzhav, zzdab.zzhbd);
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        zzdlx.zza(this.zzhav, zzdaa.zzhbd);
        zzdlx.zza(this.zzhay, zzdad.zzhbd);
        Iterator it = this.zzhbb.iterator();
        while (it.hasNext()) {
            zzdlx.zza(this.zzhaw, new zzdma((Pair) it.next()) { // from class: com.google.android.gms.internal.ads.zzczx
                private final Pair zzhbe;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhbe = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdma
                public final void zzp(Object obj) {
                    Pair pair = this.zzhbe;
                    ((zzxy) obj).onAppEvent((String) pair.first, (String) pair.second);
                }
            });
        }
        this.zzhbb.clear();
        this.zzhba.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        zzdlx.zza(this.zzhav, zzdac.zzhbd);
        zzdlx.zza(this.zzhaz, zzdaf.zzhbd);
        zzdlx.zza(this.zzhaz, zzczr.zzhbd);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        zzdlx.zza(this.zzhav, zzczq.zzhbd);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        zzdlx.zza(this.zzhav, zzczt.zzhbd);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzb(zzvv zzvvVar) {
        zzdlx.zza(this.zzhax, new zzdma(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzczs
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
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzhba.get()) {
            if (!this.zzhbb.offer(new Pair<>(str, str2))) {
                com.google.android.gms.ads.internal.util.zzd.zzdz("The queue for app events is full, dropping the new event.");
                if (this.zzdjf != null) {
                    this.zzdjf.zzb(zzdtx.zzgy("dae_action").zzw("dae_name", str).zzw("dae_data", str2));
                }
            }
            return;
        }
        zzdlx.zza(this.zzhaw, new zzdma(str, str2) { // from class: com.google.android.gms.internal.ads.zzczv
            private final String zzdkl;
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdkl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzxy) obj).onAppEvent(this.zzdmo, this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final void zzk(zzvh zzvhVar) {
        zzdlx.zza(this.zzhaz, new zzdma(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzczu
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzyg) obj).zzb(this.zzgbo);
            }
        });
    }
}
