package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzcsr;
import com.google.android.gms.internal.ads.zztz;
import com.google.android.gms.internal.ads.zzww;
import com.umeng.analytics.pro.o;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zze extends zzasg implements zzab {
    private static final int zzdta = Color.argb(0, 0, 0, 0);
    protected final Activity zzaax;
    zzbfi zzdkm;
    AdOverlayInfoParcel zzdtb;
    private zzk zzdtc;
    private zzr zzdtd;
    private FrameLayout zzdtf;
    private WebChromeClient.CustomViewCallback zzdtg;
    private zzh zzdti;
    private Runnable zzdtm;
    private boolean zzdtn;
    private boolean zzdto;
    private boolean zzdte = false;
    private boolean zzdth = false;
    private boolean zzbpo = false;
    private boolean zzdtj = false;
    zzl zzdtk = zzl.BACK_BUTTON;
    private final Object zzdtl = new Object();
    private boolean zzdtp = false;
    private boolean zzdtq = false;
    private boolean zzdtr = true;

    public zze(Activity activity) {
        this.zzaax = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onRestart() {
    }

    public final void close() {
        this.zzdtk = zzl.CUSTOM_CLOSE;
        this.zzaax.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzduk != 5) {
            return;
        }
        this.zzaax.overridePendingTransition(0, 0);
    }

    public final void zzwf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && this.zzdte) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdtf != null) {
            this.zzaax.setContentView(this.zzdti);
            this.zzdto = true;
            this.zzdtf.removeAllViews();
            this.zzdtf = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdtg;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdtg = null;
        }
        this.zzdte = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzab
    public final void zzwg() {
        this.zzdtk = zzl.CLOSE_BUTTON;
        this.zzaax.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onBackPressed() {
        this.zzdtk = zzl.BACK_BUTTON;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onUserLeaveHint() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzduf == null) {
            return;
        }
        this.zzdtb.zzduf.onUserLeaveHint();
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final boolean zzwh() {
        this.zzdtk = zzl.BACK_BUTTON;
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar == null) {
            return true;
        }
        boolean zzaem = zzbfiVar.zzaem();
        if (!zzaem) {
            this.zzdkm.zza("onbackblocked", Collections.emptyMap());
        }
        return zzaem;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public void onCreate(Bundle bundle) {
        this.zzaax.requestWindowFeature(1);
        this.zzdth = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(this.zzaax.getIntent());
            this.zzdtb = zzd;
            if (zzd == null) {
                throw new zzi("Could not get info for ad overlay.");
            }
            if (zzd.zzbpx.zzekb > 7500000) {
                this.zzdtk = zzl.OTHER;
            }
            if (this.zzaax.getIntent() != null) {
                this.zzdtr = this.zzaax.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzdtb.zzdum != null) {
                this.zzbpo = this.zzdtb.zzdum.zzbpo;
            } else if (this.zzdtb.zzduk == 5) {
                this.zzbpo = true;
            } else {
                this.zzbpo = false;
            }
            if (this.zzbpo && this.zzdtb.zzduk != 5 && this.zzdtb.zzdum.zzbpt != -1) {
                new zzj(this).zzyx();
            }
            if (bundle == null) {
                if (this.zzdtb.zzduf != null && this.zzdtr) {
                    this.zzdtb.zzduf.zzvz();
                }
                if (this.zzdtb.zzduk != 1 && this.zzdtb.zzchr != null) {
                    this.zzdtb.zzchr.onAdClicked();
                }
            }
            zzh zzhVar = new zzh(this.zzaax, this.zzdtb.zzdul, this.zzdtb.zzbpx.zzbrz, this.zzdtb.zzbvf);
            this.zzdti = zzhVar;
            zzhVar.setId(1000);
            com.google.android.gms.ads.internal.zzr.zzkx().zzi(this.zzaax);
            int i = this.zzdtb.zzduk;
            if (i == 1) {
                zzao(false);
            } else if (i == 2) {
                this.zzdtc = new zzk(this.zzdtb.zzdkm);
                zzao(false);
            } else if (i == 3) {
                zzao(true);
            } else if (i == 5) {
                zzao(false);
            } else {
                throw new zzi("Could not determine ad overlay type.");
            }
        } catch (zzi e2) {
            com.google.android.gms.ads.internal.util.zzd.zzez(e2.getMessage());
            this.zzdtk = zzl.OTHER;
            this.zzaax.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStart() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue()) {
            zzbfi zzbfiVar = this.zzdkm;
            if (zzbfiVar != null && !zzbfiVar.isDestroyed()) {
                this.zzdkm.onResume();
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzez("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onResume() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzduf != null) {
            this.zzdtb.zzduf.onResume();
        }
        zza(this.zzaax.getResources().getConfiguration());
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue()) {
            return;
        }
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null && !zzbfiVar.isDestroyed()) {
            this.zzdkm.onResume();
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onPause() {
        zzwf();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzduf != null) {
            this.zzdtb.zzduf.onPause();
        }
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue() && this.zzdkm != null && (!this.zzaax.isFinishing() || this.zzdtc == null)) {
            this.zzdkm.onPause();
        }
        zzwj();
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzae(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdth);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStop() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue() && this.zzdkm != null && (!this.zzaax.isFinishing() || this.zzdtc == null)) {
            this.zzdkm.onPause();
        }
        zzwj();
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onDestroy() {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            try {
                this.zzdti.removeView(zzbfiVar.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzwj();
    }

    private final void zzan(boolean z) {
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcwa)).intValue();
        zzq zzqVar = new zzq();
        zzqVar.size = 50;
        zzqVar.paddingLeft = z ? intValue : 0;
        zzqVar.paddingRight = z ? 0 : intValue;
        zzqVar.paddingTop = 0;
        zzqVar.paddingBottom = intValue;
        this.zzdtd = new zzr(this.zzaax, zzqVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdtb.zzduh);
        this.zzdti.addView(this.zzdtd, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzdq() {
        this.zzdto = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzww.zzra().zzd(zzabq.zzcqg)).booleanValue() && (adOverlayInfoParcel2 = this.zzdtb) != null && adOverlayInfoParcel2.zzdum != null && this.zzdtb.zzdum.zzbpv;
        boolean z5 = ((Boolean) zzww.zzra().zzd(zzabq.zzcqh)).booleanValue() && (adOverlayInfoParcel = this.zzdtb) != null && adOverlayInfoParcel.zzdum != null && this.zzdtb.zzdum.zzbpw;
        if (z && z2 && z4 && !z5) {
            new zzarj(this.zzdkm, "useCustomClose").zzdt("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzr zzrVar = this.zzdtd;
        if (zzrVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzrVar.zzap(z3);
        }
    }

    public final void zzac(boolean z) {
        if (z) {
            this.zzdti.setBackgroundColor(0);
        } else {
            this.zzdti.setBackgroundColor(-16777216);
        }
    }

    public final void zzwi() {
        this.zzdti.removeView(this.zzdtd);
        zzan(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaax.getApplicationInfo().targetSdkVersion >= ((Integer) zzww.zzra().zzd(zzabq.zzcyh)).intValue()) {
            if (this.zzaax.getApplicationInfo().targetSdkVersion <= ((Integer) zzww.zzra().zzd(zzabq.zzcyi)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzww.zzra().zzd(zzabq.zzcyj)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzww.zzra().zzd(zzabq.zzcyk)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaax.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkz().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaax);
        this.zzdtf = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzdtf.addView(view, -1, -1);
        this.zzaax.setContentView(this.zzdtf);
        this.zzdto = true;
        this.zzdtg = customViewCallback;
        this.zzdte = true;
    }

    private final void zzao(boolean z) {
        if (!this.zzdto) {
            this.zzaax.requestWindowFeature(1);
        }
        Window window = this.zzaax.getWindow();
        if (window == null) {
            throw new zzi("Invalid activity, no window available.");
        }
        zzbgu zzaef = this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaef() : null;
        boolean z2 = zzaef != null && zzaef.zzadm();
        this.zzdtj = false;
        if (z2) {
            if (this.zzdtb.orientation == 6) {
                this.zzdtj = this.zzaax.getResources().getConfiguration().orientation == 1;
            } else if (this.zzdtb.orientation == 7) {
                this.zzdtj = this.zzaax.getResources().getConfiguration().orientation == 2;
            }
        }
        boolean z3 = this.zzdtj;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Delay onShow to next orientation change: ");
        sb.append(z3);
        com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        setRequestedOrientation(this.zzdtb.orientation);
        window.setFlags(16777216, 16777216);
        com.google.android.gms.ads.internal.util.zzd.zzdz("Hardware acceleration on the AdActivity window enabled.");
        if (!this.zzbpo) {
            this.zzdti.setBackgroundColor(-16777216);
        } else {
            this.zzdti.setBackgroundColor(zzdta);
        }
        this.zzaax.setContentView(this.zzdti);
        this.zzdto = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzr.zzkw();
                zzbfi zza = zzbfq.zza(this.zzaax, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaed() : null, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaee() : null, true, z2, null, null, this.zzdtb.zzbpx, null, null, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaby() : null, zztz.zznl(), null, null);
                this.zzdkm = zza;
                zza.zzaef().zza(null, this.zzdtb.zzdic, null, this.zzdtb.zzdie, this.zzdtb.zzduj, true, null, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaef().zzadl() : null, null, null, null, null, null, null);
                this.zzdkm.zzaef().zza(new zzbgt(this) { // from class: com.google.android.gms.ads.internal.overlay.zzd
                    private final zze zzdsz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdsz = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbgt
                    public final void zzam(boolean z4) {
                        zze zzeVar = this.zzdsz;
                        if (zzeVar.zzdkm != null) {
                            zzeVar.zzdkm.zzwm();
                        }
                    }
                });
                if (this.zzdtb.url != null) {
                    this.zzdkm.loadUrl(this.zzdtb.url);
                } else if (this.zzdtb.zzdui != null) {
                    this.zzdkm.loadDataWithBaseURL(this.zzdtb.zzdug, this.zzdtb.zzdui, "text/html", "UTF-8", null);
                } else {
                    throw new zzi("No URL or HTML to display in ad overlay.");
                }
                if (this.zzdtb.zzdkm != null) {
                    this.zzdtb.zzdkm.zzb(this);
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error obtaining webview.", e2);
                throw new zzi("Could not obtain webview for the overlay.");
            }
        } else {
            zzbfi zzbfiVar = this.zzdtb.zzdkm;
            this.zzdkm = zzbfiVar;
            zzbfiVar.zzby(this.zzaax);
        }
        this.zzdkm.zza(this);
        if (this.zzdtb.zzdkm != null) {
            zzc(this.zzdtb.zzdkm.zzaej(), this.zzdti);
        }
        if (this.zzdtb.zzduk != 5) {
            ViewParent parent = this.zzdkm.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdkm.getView());
            }
            if (this.zzbpo) {
                this.zzdkm.zzaer();
            }
            this.zzdti.addView(this.zzdkm.getView(), -1, -1);
        }
        if (!z && !this.zzdtj) {
            zzwm();
        }
        if (this.zzdtb.zzduk != 5) {
            zzan(z2);
            if (this.zzdkm.zzaeh()) {
                zza(z2, true);
                return;
            }
            return;
        }
        zzcsr.zza(this.zzaax, this, this.zzdtb.zzduo, this.zzdtb.zzdun, this.zzdtb.zzdje, this.zzdtb.zzdjf, this.zzdtb.zzbwe, this.zzdtb.zzdup);
    }

    private final void zzwj() {
        if (!this.zzaax.isFinishing() || this.zzdtp) {
            return;
        }
        this.zzdtp = true;
        if (this.zzdkm != null) {
            this.zzdkm.zzec(this.zzdtk.zzwq());
            synchronized (this.zzdtl) {
                if (!this.zzdtn && this.zzdkm.zzaen()) {
                    this.zzdtm = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.zzg
                        private final zze zzdsz;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdsz = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdsz.zzwk();
                        }
                    };
                    com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(this.zzdtm, ((Long) zzww.zzra().zzd(zzabq.zzcqf)).longValue());
                    return;
                }
            }
        }
        zzwk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzwk() {
        if (this.zzdtq) {
            return;
        }
        this.zzdtq = true;
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            this.zzdti.removeView(zzbfiVar.getView());
            zzk zzkVar = this.zzdtc;
            if (zzkVar != null) {
                this.zzdkm.zzby(zzkVar.context);
                this.zzdkm.zzbe(false);
                this.zzdtc.parent.addView(this.zzdkm.getView(), this.zzdtc.index, this.zzdtc.zzdtv);
                this.zzdtc = null;
            } else if (this.zzaax.getApplicationContext() != null) {
                this.zzdkm.zzby(this.zzaax.getApplicationContext());
            }
            this.zzdkm = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzduf != null) {
            this.zzdtb.zzduf.zza(this.zzdtk);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdtb;
        if (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdkm == null) {
            return;
        }
        zzc(this.zzdtb.zzdkm.zzaej(), this.zzdtb.zzdkm.getView());
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlk().zza(iObjectWrapper, view);
    }

    public final void zzwl() {
        if (this.zzdtj) {
            this.zzdtj = false;
            zzwm();
        }
    }

    private final void zzwm() {
        this.zzdkm.zzwm();
    }

    public final void zzwn() {
        this.zzdti.zzdtt = true;
    }

    public final void zzwo() {
        synchronized (this.zzdtl) {
            this.zzdtn = true;
            if (this.zzdtm != null) {
                com.google.android.gms.ads.internal.util.zzj.zzegq.removeCallbacks(this.zzdtm);
                com.google.android.gms.ads.internal.util.zzj.zzegq.post(this.zzdtm);
            }
        }
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdtb;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdum == null || !this.zzdtb.zzdum.zzbpp) ? false : true;
        boolean zza = com.google.android.gms.ads.internal.zzr.zzkx().zza(this.zzaax, configuration);
        if ((this.zzbpo && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.zzdtb) != null && adOverlayInfoParcel.zzdum != null && this.zzdtb.zzdum.zzbpu) {
            z2 = true;
        }
        Window window = this.zzaax.getWindow();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcqi)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT < 19 || !z2) {
                return;
            }
            window.getDecorView().setSystemUiVisibility(o.a.f6597b);
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }
}
