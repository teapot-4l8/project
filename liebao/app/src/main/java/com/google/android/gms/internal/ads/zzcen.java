package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import cn.jpush.android.service.WakedResultReceiver;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcen {
    private final Executor executor;
    private final zzaei zzdpr;
    private final com.google.android.gms.ads.internal.util.zzf zzecl;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcdr zzgeo;
    private final zzcdv zzgfq;
    private final zzcdm zzgfz;
    private final zzcev zzgii;
    private final zzcfd zzgij;

    public zzcen(com.google.android.gms.ads.internal.util.zzf zzfVar, zzdpm zzdpmVar, zzcdv zzcdvVar, zzcdr zzcdrVar, zzcev zzcevVar, zzcfd zzcfdVar, Executor executor, Executor executor2, zzcdm zzcdmVar) {
        this.zzecl = zzfVar;
        this.zzfzg = zzdpmVar;
        this.zzdpr = zzdpmVar.zzdpr;
        this.zzgfq = zzcdvVar;
        this.zzgeo = zzcdrVar;
        this.zzgii = zzcevVar;
        this.zzgij = zzcfdVar;
        this.zzfur = executor;
        this.executor = executor2;
        this.zzgfz = zzcdmVar;
    }

    public final void zza(zzcfl zzcflVar) {
        this.zzfur.execute(new Runnable(this, zzcflVar) { // from class: com.google.android.gms.internal.ads.zzcem
            private final zzcfl zzggf;
            private final zzcen zzgih;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgih = this;
                this.zzggf = zzcflVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgih.zzi(this.zzggf);
            }
        });
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i == 3) {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        }
    }

    public final void zzg(zzcfl zzcflVar) {
        if (zzcflVar == null || this.zzgii == null || zzcflVar.zzapo() == null || !this.zzgfq.zzapa()) {
            return;
        }
        try {
            zzcflVar.zzapo().addView(this.zzgii.zzapz());
        } catch (zzbfu e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("web view can not be obtained", e2);
        }
    }

    public final void zzh(zzcfl zzcflVar) {
        if (zzcflVar == null) {
            return;
        }
        Context context = zzcflVar.zzakl().getContext();
        if (com.google.android.gms.ads.internal.util.zzbn.zza(context, this.zzgfq.zzghi)) {
            if (!(context instanceof Activity)) {
                com.google.android.gms.ads.internal.util.zzd.zzdz("Activity context is needed for policy validator.");
            } else if (this.zzgij == null || zzcflVar.zzapo() == null) {
            } else {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzgij.zza(zzcflVar.zzapo(), windowManager), com.google.android.gms.ads.internal.util.zzbn.zzaaj());
                } catch (zzbfu e2) {
                    com.google.android.gms.ads.internal.util.zzd.zza("web view can not be obtained", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(zzcfl zzcflVar, String[] strArr) {
        Map<String, WeakReference<View>> zzapr = zzcflVar.zzapr();
        if (zzapr == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzapr.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzaos = this.zzgeo.zzaos();
        if (zzaos == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzaos.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzaos.getParent()).removeView(zzaos);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcub)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzaos, layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzgeo.zzaos() != null) {
            if (2 == this.zzgeo.zzaoo() || 1 == this.zzgeo.zzaoo()) {
                this.zzecl.zza(this.zzfzg.zzhny, String.valueOf(this.zzgeo.zzaoo()), z);
            } else if (6 == this.zzgeo.zzaoo()) {
                this.zzecl.zza(this.zzfzg.zzhny, WakedResultReceiver.WAKE_TYPE_KEY, z);
                this.zzecl.zza(this.zzfzg.zzhny, "1", z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzcfl zzcflVar) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        IObjectWrapper zztn;
        Drawable drawable;
        int i = 0;
        if (this.zzgfq.zzapc() || this.zzgfq.zzapb()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            for (int i2 = 0; i2 < 2; i2++) {
                View zzgd = zzcflVar.zzgd(strArr[i2]);
                if (zzgd != null && (zzgd instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzgd;
                    break;
                }
            }
        }
        viewGroup = null;
        boolean z = viewGroup != null;
        Context context = zzcflVar.zzakl().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.zzgeo.zzaop() != null) {
            view = this.zzgeo.zzaop();
            zzaei zzaeiVar = this.zzdpr;
            if (zzaeiVar != null && !z) {
                zza(layoutParams, zzaeiVar.zzbof);
                view.setLayoutParams(layoutParams);
            }
        } else if (this.zzgeo.zztu() instanceof zzaed) {
            zzaed zzaedVar = (zzaed) this.zzgeo.zztu();
            if (!z) {
                zza(layoutParams, zzaedVar.zztm());
            }
            View zzaecVar = new zzaec(context, zzaedVar, layoutParams);
            zzaecVar.setContentDescription((CharSequence) zzww.zzra().zzd(zzabq.zzcty));
            view = zzaecVar;
        } else {
            view = null;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcflVar.zzakl().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(view);
                FrameLayout zzapo = zzcflVar.zzapo();
                if (zzapo != null) {
                    zzapo.addView(adChoicesView);
                }
            }
            zzcflVar.zza(zzcflVar.zzapt(), view, true);
        }
        String[] strArr2 = zzcel.zzgib;
        int length = strArr2.length;
        while (true) {
            if (i >= length) {
                viewGroup2 = null;
                break;
            }
            View zzgd2 = zzcflVar.zzgd(strArr2[i]);
            if (zzgd2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzgd2;
                break;
            }
            i++;
        }
        this.executor.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.zzcep
            private final zzcen zzgih;
            private final ViewGroup zzgin;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgih = this;
                this.zzgin = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgih.zzb(this.zzgin);
            }
        });
        if (viewGroup2 != null) {
            if (zza(viewGroup2)) {
                if (this.zzgeo.zzaot() != null) {
                    this.zzgeo.zzaot().zza(new zzceo(this, zzcflVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View zzakl = zzcflVar.zzakl();
            Context context2 = zzakl != null ? zzakl.getContext() : null;
            if (context2 != null) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzctx)).booleanValue()) {
                    zzaer zzue = this.zzgfz.zzue();
                    if (zzue == null) {
                        return;
                    }
                    try {
                        zztn = zzue.zztr();
                    } catch (RemoteException unused) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Could not get main image drawable");
                        return;
                    }
                } else {
                    zzaes zzaoq = this.zzgeo.zzaoq();
                    if (zzaoq == null) {
                        return;
                    }
                    try {
                        zztn = zzaoq.zztn();
                    } catch (RemoteException unused2) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Could not get drawable from image");
                        return;
                    }
                }
                if (zztn == null || (drawable = (Drawable) ObjectWrapper.unwrap(zztn)) == null) {
                    return;
                }
                ImageView imageView = new ImageView(context2);
                imageView.setImageDrawable(drawable);
                IObjectWrapper zzapu = zzcflVar != null ? zzcflVar.zzapu() : null;
                if (zzapu == null || !((Boolean) zzww.zzra().zzd(zzabq.zzcys)).booleanValue()) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzapu));
                }
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup2.addView(imageView);
            }
        }
    }
}
