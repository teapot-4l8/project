package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjc {
    private final zzaxo zzbos;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final zzei zzeus;
    private final zzdup zzftn;
    private final Executor zzfur;
    private final zzbty zzfzc;
    private final zzbur zzgds;
    private final zzbst zzgeq;
    private final zzbli zzger;
    private final zzbzk zzget;
    private final zzbum zzgls;
    private final zzbxe zzglt;
    private final com.google.android.gms.ads.internal.zza zzgmi;
    private final zzbts zzgmj;
    private final zzbwt zzgmk;

    public zzcjc(zzbst zzbstVar, zzbty zzbtyVar, zzbum zzbumVar, zzbur zzburVar, zzbxe zzbxeVar, Executor executor, zzbzk zzbzkVar, zzbli zzbliVar, com.google.android.gms.ads.internal.zza zzaVar, zzbts zzbtsVar, zzaxo zzaxoVar, zzei zzeiVar, zzbwt zzbwtVar, zzcsh zzcshVar, zzdup zzdupVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        this.zzgeq = zzbstVar;
        this.zzfzc = zzbtyVar;
        this.zzgls = zzbumVar;
        this.zzgds = zzburVar;
        this.zzglt = zzbxeVar;
        this.zzfur = executor;
        this.zzget = zzbzkVar;
        this.zzger = zzbliVar;
        this.zzgmi = zzaVar;
        this.zzgmj = zzbtsVar;
        this.zzbos = zzaxoVar;
        this.zzeus = zzeiVar;
        this.zzgmk = zzbwtVar;
        this.zzdji = zzcshVar;
        this.zzftn = zzdupVar;
        this.zzdje = zzcmbVar;
        this.zzdjf = zzdtwVar;
    }

    public final void zza(final zzbfi zzbfiVar, boolean z, zzaii zzaiiVar) {
        zzdy zzcb;
        zzbfiVar.zzaef().zza(new zzve(this) { // from class: com.google.android.gms.internal.ads.zzcjf
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzve
            public final void onAdClicked() {
                this.zzgmm.zzaqk();
            }
        }, this.zzgls, this.zzgds, new zzahp(this) { // from class: com.google.android.gms.internal.ads.zzcje
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahp
            public final void onAppEvent(String str, String str2) {
                this.zzgmm.zzq(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzx(this) { // from class: com.google.android.gms.internal.ads.zzcjh
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzx
            public final void zzws() {
                this.zzgmm.zzaqj();
            }
        }, z, zzaiiVar, this.zzgmi, new zzcjm(this), this.zzbos, this.zzdji, this.zzftn, this.zzdje, this.zzdjf);
        zzbfiVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.zzcjg
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.zzgmm.zza(view, motionEvent);
            }
        });
        zzbfiVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.zzcjj
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zzgmm.zzae(view);
            }
        });
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsu)).booleanValue() && (zzcb = this.zzeus.zzcb()) != null) {
            zzcb.zzb(zzbfiVar.getView());
        }
        this.zzget.zza(zzbfiVar, this.zzfur);
        this.zzget.zza(new zzqw(zzbfiVar) { // from class: com.google.android.gms.internal.ads.zzcji
            private final zzbfi zzewn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewn = zzbfiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqw
            public final void zza(zzqx zzqxVar) {
                this.zzewn.zzaef().zza(zzqxVar.zzbsh.left, zzqxVar.zzbsh.top, false);
            }
        }, this.zzfur);
        this.zzget.zzv(zzbfiVar.getView());
        zzbfiVar.zza("/trackActiveViewUnit", new zzaig(this, zzbfiVar) { // from class: com.google.android.gms.internal.ads.zzcjl
            private final zzbfi zzgji;
            private final zzcjc zzgmm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmm = this;
                this.zzgji = zzbfiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgmm.zza(this.zzgji, (zzbfi) obj, map);
            }
        });
        this.zzger.zzn(zzbfiVar);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpt)).booleanValue()) {
            return;
        }
        zzbts zzbtsVar = this.zzgmj;
        zzbfiVar.getClass();
        zzbtsVar.zza(zzcjk.zzk(zzbfiVar), this.zzfur);
    }

    public static zzebt<?> zza(zzbfi zzbfiVar, String str, String str2) {
        zzbbe zzbbeVar = new zzbbe();
        zzbfiVar.zzaef().zza(new zzbgt(zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzcjn
            private final zzbbe zzbwk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzbwk = zzbbeVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbgt
            public final void zzam(boolean z) {
                zzbbe zzbbeVar2 = this.zzbwk;
                if (z) {
                    zzbbeVar2.set(null);
                } else {
                    zzbbeVar2.setException(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbfiVar.zzb(str, str2, null);
        return zzbbeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfiVar, zzbfi zzbfiVar2, Map map) {
        this.zzger.zzc(zzbfiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzae(View view) {
        this.zzgmi.recordClick();
        zzaxo zzaxoVar = this.zzbos;
        if (zzaxoVar != null) {
            zzaxoVar.zzxi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgmi.recordClick();
        zzaxo zzaxoVar = this.zzbos;
        if (zzaxoVar != null) {
            zzaxoVar.zzxi();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqj() {
        this.zzfzc.onAdLeftApplication();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(String str, String str2) {
        this.zzglt.onAppEvent(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqk() {
        this.zzgeq.onAdClicked();
    }
}
