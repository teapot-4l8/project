package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzdbs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdbf extends zzazf {
    private static final List<String> zzhck = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> zzhcl = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> zzhcm = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> zzhcn = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private Context context;
    private zzbar zzbpj;
    private final ScheduledExecutorService zzftq;
    private zzei zzftt;
    private Point zzgey = new Point();
    private Point zzgez = new Point();
    private final zzebs zzgka;
    private zzdqc<zzchu> zzgxm;
    private zzbhh zzhco;
    private zzatj zzhcp;

    public zzdbf(zzbhh zzbhhVar, Context context, zzei zzeiVar, zzbar zzbarVar, zzdqc<zzchu> zzdqcVar, zzebs zzebsVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzhco = zzbhhVar;
        this.context = context;
        this.zzftt = zzeiVar;
        this.zzbpj = zzbarVar;
        this.zzgxm = zzdqcVar;
        this.zzgka = zzebsVar;
        this.zzftq = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final IObjectWrapper zzap(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(IObjectWrapper iObjectWrapper, zzazi zzaziVar, zzazb zzazbVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.context = context;
        String str = zzaziVar.zzbvf;
        String str2 = zzaziVar.zzbrw;
        zzvt zzvtVar = zzaziVar.zzedt;
        zzvq zzvqVar = zzaziVar.zzedu;
        zzdbc zzagm = this.zzhco.zzagm();
        zzbsj.zza zzci = new zzbsj.zza().zzci(context);
        zzdpo zzdpoVar = new zzdpo();
        if (str == null) {
            str = "adUnitId";
        }
        zzdpo zzgt = zzdpoVar.zzgt(str);
        if (zzvqVar == null) {
            zzvqVar = new zzvp().zzqj();
        }
        zzdpo zzh = zzgt.zzh(zzvqVar);
        if (zzvtVar == null) {
            zzvtVar = new zzvt();
        }
        zzebh.zza(zzagm.zzg(zzci.zza(zzh.zzg(zzvtVar).zzawg()).zzami()).zza(new zzdbs(new zzdbs.zza().zzgs(str2))).zzg(new zzbxr.zza().zzanf()).zzajg().zzajf(), new zzdbo(this, zzazbVar), this.zzhco.zzafv());
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zzao(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzatj zzatjVar = this.zzhcp;
            this.zzgey = com.google.android.gms.ads.internal.util.zzbn.zza(motionEvent, zzatjVar == null ? null : zzatjVar.zzaay);
            if (motionEvent.getAction() == 0) {
                this.zzgez = this.zzgey;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(this.zzgey.x, this.zzgey.y);
            this.zzftt.zza(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(zzatj zzatjVar) {
        this.zzhcp = zzatjVar;
        this.zzgxm.ensureSize(1);
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasyVar) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
            try {
                zzasyVar.onError("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
                return;
            }
        }
        zzebt zze = this.zzgka.zze(new Callable(this, list, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzdbe
            private final zzdbf zzhch;
            private final List zzhci;
            private final IObjectWrapper zzhcj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzhci = list;
                this.zzhcj = iObjectWrapper;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhch.zza(this.zzhci, this.zzhcj);
            }
        });
        if (zzatq()) {
            zze = zzebh.zzb(zze, new zzear(this) { // from class: com.google.android.gms.internal.ads.zzdbh
                private final zzdbf zzhch;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhch = this;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    return this.zzhch.zzb((ArrayList) obj);
                }
            }, this.zzgka);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzey("Asset view map is empty.");
        }
        zzebh.zza(zze, new zzdbr(this, zzasyVar), this.zzhco.zzafv());
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasy zzasyVar) {
        try {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
                zzasyVar.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzasyVar.onError("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zza(uri, zzhck, zzhcl)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                    zzasyVar.onSuccess(list);
                    return;
                }
                zzebt zze = this.zzgka.zze(new Callable(this, uri, iObjectWrapper) { // from class: com.google.android.gms.internal.ads.zzdbg
                    private final Uri zzgws;
                    private final zzdbf zzhch;
                    private final IObjectWrapper zzhcj;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhch = this;
                        this.zzgws = uri;
                        this.zzhcj = iObjectWrapper;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzhch.zzb(this.zzgws, this.zzhcj);
                    }
                });
                if (zzatq()) {
                    zze = zzebh.zzb(zze, new zzear(this) { // from class: com.google.android.gms.internal.ads.zzdbj
                        private final zzdbf zzhch;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzhch = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzear
                        public final zzebt zzf(Object obj) {
                            return this.zzhch.zzl((Uri) obj);
                        }
                    }, this.zzgka);
                } else {
                    com.google.android.gms.ads.internal.util.zzd.zzey("Asset view map is empty.");
                }
                zzebh.zza(zze, new zzdbq(this, zzasyVar), this.zzhco.zzafv());
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    private static boolean zzk(Uri uri) {
        return zza(uri, zzhcm, zzhcn);
    }

    /* renamed from: zza */
    public final Uri zzb(Uri uri, IObjectWrapper iObjectWrapper) {
        try {
            uri = this.zzftt.zza(uri, this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzeh e2) {
            zzbao.zzd("", e2);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            for (String str : list) {
                if (path.contains(str)) {
                    for (String str2 : list2) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private final zzebt<String> zzgr(String str) {
        zzchu[] zzchuVarArr = new zzchu[1];
        zzebt zzb = zzebh.zzb(this.zzgxm.zzawl(), new zzear(this, zzchuVarArr, str) { // from class: com.google.android.gms.internal.ads.zzdbm
            private final String zzdmx;
            private final zzdbf zzhch;
            private final zzchu[] zzhcq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzhcq = zzchuVarArr;
                this.zzdmx = str;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzhch.zza(this.zzhcq, this.zzdmx, (zzchu) obj);
            }
        }, this.zzgka);
        zzb.addListener(new Runnable(this, zzchuVarArr) { // from class: com.google.android.gms.internal.ads.zzdbp
            private final zzdbf zzhch;
            private final zzchu[] zzhcq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzhcq = zzchuVarArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhch.zza(this.zzhcq);
            }
        }, this.zzgka);
        return zzebc.zzg(zzb).zza(((Integer) zzww.zzra().zzd(zzabq.zzdab)).intValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(zzdbk.zzebv, this.zzgka).zza(Exception.class, zzdbn.zzebv, this.zzgka);
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private final boolean zzatq() {
        zzatj zzatjVar = this.zzhcp;
        return (zzatjVar == null || zzatjVar.zzdva == null || this.zzhcp.zzdva.isEmpty()) ? false : true;
    }

    public final /* synthetic */ void zza(zzchu[] zzchuVarArr) {
        if (zzchuVarArr[0] != null) {
            this.zzgxm.zzd(zzebh.zzag(zzchuVarArr[0]));
        }
    }

    public final /* synthetic */ zzebt zza(zzchu[] zzchuVarArr, String str, zzchu zzchuVar) {
        zzchuVarArr[0] = zzchuVar;
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, this.zzhcp.zzdva, this.zzhcp.zzdva, this.zzhcp.zzaay);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, this.zzhcp.zzaay);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(this.zzhcp.zzaay);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, this.zzhcp.zzaay);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", com.google.android.gms.ads.internal.util.zzbn.zza((String) null, this.context, this.zzgez, this.zzgey));
        }
        return zzchuVar.zzc(str, jSONObject);
    }

    public static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    public static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzk(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zza(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public final /* synthetic */ zzebt zzl(Uri uri) {
        return zzebh.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdxw(this, uri) { // from class: com.google.android.gms.internal.ads.zzdbl
            private final Uri zzgws;
            private final zzdbf zzhch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzgws = uri;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return zzdbf.zzc(this.zzgws, (String) obj);
            }
        }, this.zzgka);
    }

    public final /* synthetic */ zzebt zzb(ArrayList arrayList) {
        return zzebh.zzb(zzgr("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdxw(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdbi
            private final zzdbf zzhch;
            private final List zzhci;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhch = this;
                this.zzhci = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return zzdbf.zza(this.zzhci, (String) obj);
            }
        }, this.zzgka);
    }

    public final /* synthetic */ ArrayList zza(List list, IObjectWrapper iObjectWrapper) {
        String zza = this.zzftt.zzcb() != null ? this.zzftt.zzcb().zza(this.context, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (TextUtils.isEmpty(zza)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzk(uri)) {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Not a Google URL: ");
                sb.append(valueOf);
                com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                arrayList.add(uri);
            } else {
                arrayList.add(zza(uri, "ms", zza));
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }
}
