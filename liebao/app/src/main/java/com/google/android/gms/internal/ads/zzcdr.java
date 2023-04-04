package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.b.g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdr {
    private Bundle extras;
    private zzaek zzdha;
    private List<?> zzexb;
    private double zzexe;
    private float zzexq;
    private IObjectWrapper zzfya;
    private int zzggs;
    private zzzd zzggt;
    private View zzggu;
    private zzzz zzggv;
    private zzbfi zzggw;
    private zzbfi zzggx;
    private View zzggy;
    private IObjectWrapper zzggz;
    private zzaes zzgha;
    private zzaes zzghb;
    private String zzghc;
    private String zzghf;
    private g<String, zzaee> zzghd = new g<>();
    private g<String, String> zzghe = new g<>();
    private List<zzzz> zzdhn = Collections.emptyList();

    public final synchronized void zzeh(int i) {
        this.zzggs = i;
    }

    public final synchronized void zzb(zzzd zzzdVar) {
        this.zzggt = zzzdVar;
    }

    public final synchronized void zza(zzaek zzaekVar) {
        this.zzdha = zzaekVar;
    }

    public final synchronized void setImages(List<zzaee> list) {
        this.zzexb = list;
    }

    public final synchronized void zzh(List<zzzz> list) {
        this.zzdhn = list;
    }

    public final synchronized void zza(zzzz zzzzVar) {
        this.zzggv = zzzzVar;
    }

    public final synchronized void zzac(View view) {
        this.zzggy = view;
    }

    public final synchronized void setStarRating(double d2) {
        this.zzexe = d2;
    }

    public final synchronized void zza(zzaes zzaesVar) {
        this.zzgha = zzaesVar;
    }

    public final synchronized void zzb(zzaes zzaesVar) {
        this.zzghb = zzaesVar;
    }

    public final synchronized void zzfy(String str) {
        this.zzghc = str;
    }

    public final synchronized void zzf(zzbfi zzbfiVar) {
        this.zzggw = zzbfiVar;
    }

    public final synchronized void zzg(zzbfi zzbfiVar) {
        this.zzggx = zzbfiVar;
    }

    public final synchronized void zzau(IObjectWrapper iObjectWrapper) {
        this.zzfya = iObjectWrapper;
    }

    public final synchronized void zzo(String str, String str2) {
        if (str2 == null) {
            this.zzghe.remove(str);
        } else {
            this.zzghe.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzaee zzaeeVar) {
        if (zzaeeVar == null) {
            this.zzghd.remove(str);
        } else {
            this.zzghd.put(str, zzaeeVar);
        }
    }

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzexq = f;
    }

    public final synchronized void zzfz(String str) {
        this.zzghf = str;
    }

    private final synchronized String zzga(String str) {
        return this.zzghe.get(str);
    }

    public final synchronized int zzaoo() {
        return this.zzggs;
    }

    public final synchronized zzzd getVideoController() {
        return this.zzggt;
    }

    public final synchronized zzaek zztu() {
        return this.zzdha;
    }

    public final synchronized View zzaop() {
        return this.zzggu;
    }

    public final synchronized String getHeadline() {
        return zzga("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzexb;
    }

    public final zzaes zzaoq() {
        List<?> list = this.zzexb;
        if (list != null && list.size() != 0) {
            Object obj = this.zzexb.get(0);
            if (obj instanceof IBinder) {
                return zzaev.zzo((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized List<zzzz> getMuteThisAdReasons() {
        return this.zzdhn;
    }

    public final synchronized zzzz zzaor() {
        return this.zzggv;
    }

    public final synchronized String getBody() {
        return zzga("body");
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getCallToAction() {
        return zzga("call_to_action");
    }

    public final synchronized View zzaos() {
        return this.zzggy;
    }

    public final synchronized IObjectWrapper zztv() {
        return this.zzggz;
    }

    public final synchronized String getStore() {
        return zzga("store");
    }

    public final synchronized String getPrice() {
        return zzga("price");
    }

    public final synchronized double getStarRating() {
        return this.zzexe;
    }

    public final synchronized zzaes zztt() {
        return this.zzgha;
    }

    public final synchronized String getAdvertiser() {
        return zzga("advertiser");
    }

    public final synchronized zzaes zztw() {
        return this.zzghb;
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzghc;
    }

    public final synchronized zzbfi zzaot() {
        return this.zzggw;
    }

    public final synchronized zzbfi zzaou() {
        return this.zzggx;
    }

    public final synchronized IObjectWrapper zzaov() {
        return this.zzfya;
    }

    public final synchronized g<String, zzaee> zzaow() {
        return this.zzghd;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzexq;
    }

    public final synchronized String zzaox() {
        return this.zzghf;
    }

    public final synchronized g<String, String> zzaoy() {
        return this.zzghe;
    }

    public final synchronized void destroy() {
        if (this.zzggw != null) {
            this.zzggw.destroy();
            this.zzggw = null;
        }
        if (this.zzggx != null) {
            this.zzggx.destroy();
            this.zzggx = null;
        }
        this.zzfya = null;
        this.zzghd.clear();
        this.zzghe.clear();
        this.zzggt = null;
        this.zzdha = null;
        this.zzggu = null;
        this.zzexb = null;
        this.extras = null;
        this.zzggy = null;
        this.zzggz = null;
        this.zzgha = null;
        this.zzghb = null;
        this.zzghc = null;
    }

    public static zzcdr zza(zzaoc zzaocVar) {
        try {
            zzcdo zza = zza(zzaocVar.getVideoController(), (zzaoh) null);
            zzaek zztu = zzaocVar.zztu();
            String headline = zzaocVar.getHeadline();
            List<?> images = zzaocVar.getImages();
            String body = zzaocVar.getBody();
            Bundle extras = zzaocVar.getExtras();
            String callToAction = zzaocVar.getCallToAction();
            IObjectWrapper zztv = zzaocVar.zztv();
            String advertiser = zzaocVar.getAdvertiser();
            zzaes zztw = zzaocVar.zztw();
            zzcdr zzcdrVar = new zzcdr();
            zzcdrVar.zzggs = 1;
            zzcdrVar.zzggt = zza;
            zzcdrVar.zzdha = zztu;
            zzcdrVar.zzggu = (View) zzav(zzaocVar.zzvr());
            zzcdrVar.zzo("headline", headline);
            zzcdrVar.zzexb = images;
            zzcdrVar.zzo("body", body);
            zzcdrVar.extras = extras;
            zzcdrVar.zzo("call_to_action", callToAction);
            zzcdrVar.zzggy = (View) zzav(zzaocVar.zzvs());
            zzcdrVar.zzggz = zztv;
            zzcdrVar.zzo("advertiser", advertiser);
            zzcdrVar.zzghb = zztw;
            return zzcdrVar;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public static zzcdr zza(zzaob zzaobVar) {
        try {
            zzcdo zza = zza(zzaobVar.getVideoController(), (zzaoh) null);
            zzaek zztu = zzaobVar.zztu();
            String headline = zzaobVar.getHeadline();
            List<?> images = zzaobVar.getImages();
            String body = zzaobVar.getBody();
            Bundle extras = zzaobVar.getExtras();
            String callToAction = zzaobVar.getCallToAction();
            IObjectWrapper zztv = zzaobVar.zztv();
            String store = zzaobVar.getStore();
            String price = zzaobVar.getPrice();
            double starRating = zzaobVar.getStarRating();
            zzaes zztt = zzaobVar.zztt();
            zzcdr zzcdrVar = new zzcdr();
            zzcdrVar.zzggs = 2;
            zzcdrVar.zzggt = zza;
            zzcdrVar.zzdha = zztu;
            zzcdrVar.zzggu = (View) zzav(zzaobVar.zzvr());
            zzcdrVar.zzo("headline", headline);
            zzcdrVar.zzexb = images;
            zzcdrVar.zzo("body", body);
            zzcdrVar.extras = extras;
            zzcdrVar.zzo("call_to_action", callToAction);
            zzcdrVar.zzggy = (View) zzav(zzaobVar.zzvs());
            zzcdrVar.zzggz = zztv;
            zzcdrVar.zzo("store", store);
            zzcdrVar.zzo("price", price);
            zzcdrVar.zzexe = starRating;
            zzcdrVar.zzgha = zztt;
            return zzcdrVar;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzcdr zzb(zzaoh zzaohVar) {
        try {
            return zza(zza(zzaohVar.getVideoController(), zzaohVar), zzaohVar.zztu(), (View) zzav(zzaohVar.zzvr()), zzaohVar.getHeadline(), zzaohVar.getImages(), zzaohVar.getBody(), zzaohVar.getExtras(), zzaohVar.getCallToAction(), (View) zzav(zzaohVar.zzvs()), zzaohVar.zztv(), zzaohVar.getStore(), zzaohVar.getPrice(), zzaohVar.getStarRating(), zzaohVar.zztt(), zzaohVar.getAdvertiser(), zzaohVar.getMediaContentAspectRatio());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    public static zzcdr zzb(zzaob zzaobVar) {
        try {
            return zza(zza(zzaobVar.getVideoController(), (zzaoh) null), zzaobVar.zztu(), (View) zzav(zzaobVar.zzvr()), zzaobVar.getHeadline(), zzaobVar.getImages(), zzaobVar.getBody(), zzaobVar.getExtras(), zzaobVar.getCallToAction(), (View) zzav(zzaobVar.zzvs()), zzaobVar.zztv(), zzaobVar.getStore(), zzaobVar.getPrice(), zzaobVar.getStarRating(), zzaobVar.zztt(), null, 0.0f);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to get native ad assets from app install ad mapper", e2);
            return null;
        }
    }

    public static zzcdr zzb(zzaoc zzaocVar) {
        try {
            return zza(zza(zzaocVar.getVideoController(), (zzaoh) null), zzaocVar.zztu(), (View) zzav(zzaocVar.zzvr()), zzaocVar.getHeadline(), zzaocVar.getImages(), zzaocVar.getBody(), zzaocVar.getExtras(), zzaocVar.getCallToAction(), (View) zzav(zzaocVar.zzvs()), zzaocVar.zztv(), null, null, -1.0d, zzaocVar.zztw(), zzaocVar.getAdvertiser(), 0.0f);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to get native ad assets from content ad mapper", e2);
            return null;
        }
    }

    private static zzcdr zza(zzzd zzzdVar, zzaek zzaekVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d2, zzaes zzaesVar, String str6, float f) {
        zzcdr zzcdrVar = new zzcdr();
        zzcdrVar.zzggs = 6;
        zzcdrVar.zzggt = zzzdVar;
        zzcdrVar.zzdha = zzaekVar;
        zzcdrVar.zzggu = view;
        zzcdrVar.zzo("headline", str);
        zzcdrVar.zzexb = list;
        zzcdrVar.zzo("body", str2);
        zzcdrVar.extras = bundle;
        zzcdrVar.zzo("call_to_action", str3);
        zzcdrVar.zzggy = view2;
        zzcdrVar.zzggz = iObjectWrapper;
        zzcdrVar.zzo("store", str4);
        zzcdrVar.zzo("price", str5);
        zzcdrVar.zzexe = d2;
        zzcdrVar.zzgha = zzaesVar;
        zzcdrVar.zzo("advertiser", str6);
        zzcdrVar.setMediaContentAspectRatio(f);
        return zzcdrVar;
    }

    private static <T> T zzav(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private static zzcdo zza(zzzd zzzdVar, zzaoh zzaohVar) {
        if (zzzdVar == null) {
            return null;
        }
        return new zzcdo(zzzdVar, zzaohVar);
    }
}
