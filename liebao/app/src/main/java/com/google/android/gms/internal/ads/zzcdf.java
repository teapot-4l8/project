package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.b.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdf extends zzbpc {
    private final Context context;
    private final zzbar zzbpx;
    private final zzei zzeus;
    private final Executor zzfur;
    private final zzcdy zzfwx;
    private final zzaya zzfyl;
    private final zzcdr zzgeo;
    private final zzcdz zzgfo;
    private final zzcen zzgfp;
    private final zzcdv zzgfq;
    private final zzeru<zzchm> zzgfr;
    private final zzeru<zzchk> zzgfs;
    private final zzeru<zzcht> zzgft;
    private final zzeru<zzchg> zzgfu;
    private final zzeru<zzcho> zzgfv;
    private zzcfl zzgfw;
    private boolean zzgfx;
    private boolean zzgfy;
    private final zzcdm zzgfz;
    private final zzdah zzgga;
    private final Map<String, Boolean> zzggb;
    private final List<zzqs> zzggc;
    private final zzqz zzggd;

    public zzcdf(zzbpf zzbpfVar, Executor executor, zzcdr zzcdrVar, zzcdz zzcdzVar, zzcen zzcenVar, zzcdv zzcdvVar, zzcdy zzcdyVar, zzeru<zzchm> zzeruVar, zzeru<zzchk> zzeruVar2, zzeru<zzcht> zzeruVar3, zzeru<zzchg> zzeruVar4, zzeru<zzcho> zzeruVar5, zzaya zzayaVar, zzei zzeiVar, zzbar zzbarVar, Context context, zzcdm zzcdmVar, zzdah zzdahVar, zzqz zzqzVar) {
        super(zzbpfVar);
        this.zzgfy = false;
        this.zzfur = executor;
        this.zzgeo = zzcdrVar;
        this.zzgfo = zzcdzVar;
        this.zzgfp = zzcenVar;
        this.zzgfq = zzcdvVar;
        this.zzfwx = zzcdyVar;
        this.zzgfr = zzeruVar;
        this.zzgfs = zzeruVar2;
        this.zzgft = zzeruVar3;
        this.zzgfu = zzeruVar4;
        this.zzgfv = zzeruVar5;
        this.zzfyl = zzayaVar;
        this.zzeus = zzeiVar;
        this.zzbpx = zzbarVar;
        this.context = context;
        this.zzgfz = zzcdmVar;
        this.zzgga = zzdahVar;
        this.zzggb = new HashMap();
        this.zzggc = new ArrayList();
        this.zzggd = zzqzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void zzakv() {
        this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcde
            private final zzcdf zzgfn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfn.zzaon();
            }
        });
        if (this.zzgeo.zzaoo() != 7) {
            Executor executor = this.zzfur;
            zzcdz zzcdzVar = this.zzgfo;
            zzcdzVar.getClass();
            executor.execute(zzcdh.zza(zzcdzVar));
        }
        super.zzakv();
    }

    public final synchronized void zzfx(String str) {
        this.zzgfo.zzfx(str);
    }

    public final synchronized void zzaod() {
        if (this.zzgfx) {
            return;
        }
        this.zzgfo.zzaod();
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzgfo.zzf(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzgfx) {
            return true;
        }
        boolean zzh = this.zzgfo.zzh(bundle);
        this.zzgfx = zzh;
        return zzh;
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzgfo.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final synchronized void destroy() {
        this.zzfur.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcdg
            private final zzcdf zzgfn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgfn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgfn.zzaom();
            }
        });
        super.destroy();
    }

    public final synchronized void zza(zzcfl zzcflVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrx)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, zzcflVar) { // from class: com.google.android.gms.internal.ads.zzcdj
                private final zzcdf zzgfn;
                private final zzcfl zzggf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgfn = this;
                    this.zzggf = zzcflVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgfn.zzf(this.zzggf);
                }
            });
        } else {
            zzf(zzcflVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zzf(zzcfl zzcflVar) {
        JSONObject jSONObject;
        Iterator<String> keys;
        View view;
        zzdy zzcb;
        this.zzgfw = zzcflVar;
        this.zzgfp.zza(zzcflVar);
        this.zzgfo.zza(zzcflVar.zzakl(), zzcflVar.zzapr(), zzcflVar.zzaps(), zzcflVar, zzcflVar);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsu)).booleanValue() && (zzcb = this.zzeus.zzcb()) != null) {
            zzcb.zzb(zzcflVar.zzakl());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcry)).booleanValue() && this.zzeux.zzhnb && (jSONObject = this.zzeux.zzhna) != null && (keys = jSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                WeakReference<View> weakReference = this.zzgfw.zzapq().get(next);
                this.zzggb.put(next, false);
                if (weakReference != null && (view = weakReference.get()) != null) {
                    zzqs zzqsVar = new zzqs(this.context, view);
                    this.zzggc.add(zzqsVar);
                    zzqsVar.zza(new zzcdk(this, next));
                }
            }
        }
        if (zzcflVar.zzapp() != null) {
            zzcflVar.zzapp().zza(this.zzfyl);
        }
    }

    public final synchronized void zzc(zzcfl zzcflVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrx)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, zzcflVar) { // from class: com.google.android.gms.internal.ads.zzcdi
                private final zzcdf zzgfn;
                private final zzcfl zzggf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgfn = this;
                    this.zzggf = zzcflVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgfn.zze(this.zzggf);
                }
            });
        } else {
            zze(zzcflVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzd */
    public final void zze(zzcfl zzcflVar) {
        this.zzgfo.zza(zzcflVar.zzakl(), zzcflVar.zzapq());
        if (zzcflVar.zzapo() != null) {
            zzcflVar.zzapo().setClickable(false);
            zzcflVar.zzapo().removeAllViews();
        }
        if (zzcflVar.zzapp() != null) {
            zzcflVar.zzapp().zzb(this.zzfyl);
        }
        this.zzgfw = null;
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        this.zzgfp.zzg(this.zzgfw);
        this.zzgfo.zza(view, view2, map, map2, z);
        if (this.zzgfy) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzctv)).booleanValue() && this.zzgeo.zzaot() != null) {
                this.zzgeo.zzaot().zza("onSdkAdUserInteractionClick", new a());
            }
        }
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgfo.zza(view, motionEvent, view2);
    }

    public final synchronized void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        boolean z2;
        if (this.zzgfx) {
            return;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcry)).booleanValue() && this.zzeux.zzhnb) {
            Iterator<String> it = this.zzggb.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!this.zzggb.get(it.next()).booleanValue()) {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                return;
            }
        }
        if (z) {
            this.zzgfp.zzh(this.zzgfw);
            this.zzgfo.zzb(view, map, map2);
            this.zzgfx = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcuc)).booleanValue() && map != null) {
                for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                    View view2 = entry.getValue().get();
                    if (view2 != null && zzz(view2)) {
                        this.zzgfp.zzh(this.zzgfw);
                        this.zzgfo.zzb(view, map, map2);
                        this.zzgfx = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zzgfo.zza(view, map, map2);
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzgfo.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzagr zzagrVar) {
        this.zzgfo.zza(zzagrVar);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzgfo.cancelUnconfirmedClick();
    }

    public final synchronized void zza(zzys zzysVar) {
        this.zzgfo.zza(zzysVar);
    }

    public final synchronized void zza(zzyo zzyoVar) {
        this.zzgfo.zza(zzyoVar);
    }

    public final synchronized void zzud() {
        this.zzgfo.zzud();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzgfw == null) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzfur.execute(new Runnable(this, this.zzgfw instanceof zzcei) { // from class: com.google.android.gms.internal.ads.zzcdl
                private final boolean zzemp;
                private final zzcdf zzgfn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgfn = this;
                    this.zzemp = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgfn.zzbl(this.zzemp);
                }
            });
        }
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzgfo.isCustomClickGestureEnabled();
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    public final boolean zzaoj() {
        return this.zzgfq.zzapb();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzk(String str, boolean z) {
        String str2;
        IObjectWrapper zza;
        zzasc zzascVar;
        zzase zzaseVar;
        if (!this.zzgfq.zzaok()) {
            return;
        }
        zzbfi zzaou = this.zzgeo.zzaou();
        zzbfi zzaot = this.zzgeo.zzaot();
        if (zzaou == null && zzaot == null) {
            return;
        }
        boolean z2 = zzaou != null;
        boolean z3 = zzaot != null;
        String str3 = null;
        if (!z2) {
            if (!z3) {
                zzaou = null;
                str2 = null;
                if (zzaou.getWebView() != null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("Webview is null in InternalNativeAd");
                    return;
                } else if (!com.google.android.gms.ads.internal.zzr.zzlk().zzm(this.context)) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("Failed to initialize omid in InternalNativeAd");
                    return;
                } else {
                    int i = this.zzbpx.zzeka;
                    int i2 = this.zzbpx.zzekb;
                    StringBuilder sb = new StringBuilder(23);
                    sb.append(i);
                    sb.append(".");
                    sb.append(i2);
                    String sb2 = sb.toString();
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcwl)).booleanValue()) {
                        if (z3) {
                            zzascVar = zzasc.VIDEO;
                            zzaseVar = zzase.DEFINED_BY_JAVASCRIPT;
                        } else {
                            zzascVar = zzasc.NATIVE_DISPLAY;
                            if (this.zzgeo.zzaoo() == 3) {
                                zzaseVar = zzase.UNSPECIFIED;
                            } else {
                                zzaseVar = zzase.ONE_PIXEL;
                            }
                        }
                        zza = com.google.android.gms.ads.internal.zzr.zzlk().zzb(sb2, zzaou.getWebView(), "", "javascript", str2, str, zzaseVar, zzascVar, this.zzeux.zzcig);
                    } else {
                        zza = com.google.android.gms.ads.internal.zzr.zzlk().zza(sb2, zzaou.getWebView(), "", "javascript", str2, str);
                    }
                    if (zza == null) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Failed to create omid session in InternalNativeAd");
                        return;
                    }
                    this.zzgeo.zzau(zza);
                    zzaou.zzar(zza);
                    if (z3) {
                        View view = zzaot.getView();
                        if (view != null) {
                            com.google.android.gms.ads.internal.zzr.zzlk().zza(zza, view);
                        }
                        this.zzgfy = true;
                    }
                    if (z) {
                        com.google.android.gms.ads.internal.zzr.zzlk().zzac(zza);
                        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue()) {
                            zzaou.zza("onSdkLoaded", new a());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            str3 = "javascript";
            zzaou = zzaot;
        }
        str2 = str3;
        if (zzaou.getWebView() != null) {
        }
    }

    public final boolean zzaok() {
        return this.zzgfq.zzaok();
    }

    public final void zzaa(View view) {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        boolean z = this.zzgeo.zzaou() != null;
        if (!this.zzgfq.zzaok() || zzaov == null || !z || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlk().zza(zzaov, view);
    }

    public final void zzab(View view) {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        if (!this.zzgfq.zzaok() || zzaov == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlk().zzb(zzaov, view);
    }

    public final zzcdm zzaol() {
        return this.zzgfz;
    }

    public final synchronized void zza(zzyx zzyxVar) {
        this.zzgga.zzc(zzyxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzbl(boolean z) {
        this.zzgfo.zza(this.zzgfw.zzakl(), this.zzgfw.zzapq(), this.zzgfw.zzapr(), z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaom() {
        this.zzgfo.destroy();
        this.zzgeo.destroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaon() {
        try {
            int zzaoo = this.zzgeo.zzaoo();
            if (zzaoo == 1) {
                if (this.zzfwx.zzapd() != null) {
                    zzk("Google", true);
                    this.zzfwx.zzapd().zza(this.zzgfr.get());
                }
            } else if (zzaoo == 2) {
                if (this.zzfwx.zzape() != null) {
                    zzk("Google", true);
                    this.zzfwx.zzape().zza(this.zzgfs.get());
                }
            } else if (zzaoo == 3) {
                if (this.zzfwx.zzgb(this.zzgeo.getCustomTemplateId()) != null) {
                    if (this.zzgeo.zzaot() != null) {
                        zzk("Google", true);
                    }
                    this.zzfwx.zzgb(this.zzgeo.getCustomTemplateId()).zza(this.zzgfv.get());
                }
            } else if (zzaoo == 6) {
                if (this.zzfwx.zzapf() != null) {
                    zzk("Google", true);
                    this.zzfwx.zzapf().zza(this.zzgft.get());
                }
            } else if (zzaoo == 7) {
                if (this.zzfwx.zzaph() != null) {
                    this.zzfwx.zzaph().zza(this.zzgfu.get());
                }
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzex("Wrong native template id!");
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("RemoteException when notifyAdLoad is called", e2);
        }
    }
}
