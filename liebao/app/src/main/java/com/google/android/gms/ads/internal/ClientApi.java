package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzash;
import com.google.android.gms.internal.ads.zzass;
import com.google.android.gms.internal.ads.zzavg;
import com.google.android.gms.internal.ads.zzawf;
import com.google.android.gms.internal.ads.zzazc;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcel;
import com.google.android.gms.internal.ads.zzczi;
import com.google.android.gms.internal.ads.zzdjv;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyh;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class ClientApi extends zzyc {
    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzyh zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzass zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzannVar, i).zzagd().zzcb(context).zzc(zzvtVar).zzfq(str).zzain().zzaiq();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzannVar, i).zzagi().zzcc(context).zzd(zzvtVar).zzfr(str).zzais().zzaiw();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxj zza(IObjectWrapper iObjectWrapper, String str, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzczi(zzbhh.zza(context, zzannVar, i), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaew zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcel((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 204890000);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzavg zza(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzannVar, i).zzagl().zzcd(context).zzaiv().zzaiy();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzash zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(activity.getIntent());
        if (zzd == null) {
            return new com.google.android.gms.ads.internal.overlay.zzs(activity);
        }
        int i = zzd.zzduk;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            return new zzy(activity);
                        }
                        return new com.google.android.gms.ads.internal.overlay.zzs(activity);
                    }
                    return new zzu(activity, zzd);
                }
                return new zzac(activity);
            }
            return new zzaa(activity);
        }
        return new zzt(activity);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzyh zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbhh.zzh((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzagb();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, int i) {
        return new zzl((Context) ObjectWrapper.unwrap(iObjectWrapper), zzvtVar, str, new zzbar(204890000, i, true, false));
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzafd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcei((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzawf zzb(IObjectWrapper iObjectWrapper, String str, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbhh.zza(context, zzannVar, i).zzagl().zzcd(context).zzfs(str).zzaiv().zzaiz();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzxq zzc(IObjectWrapper iObjectWrapper, zzvt zzvtVar, String str, zzann zzannVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdjv zzaic = zzbhh.zza(context, zzannVar, i).zzagg().zzfp(str).zzca(context).zzaic();
        if (i >= ((Integer) zzww.zzra().zzd(zzabq.zzcws)).intValue()) {
            return zzaic.zzaig();
        }
        return zzaic.zzaif();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzazc zzb(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        return zzbhh.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzannVar, i).zzagn();
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaru zzc(IObjectWrapper iObjectWrapper, zzann zzannVar, int i) {
        return zzbhh.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzannVar, i).zzago();
    }
}
