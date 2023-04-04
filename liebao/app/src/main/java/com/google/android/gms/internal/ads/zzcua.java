package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcua implements zzcth<zzbne, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzboa zzgwe;

    public zzcua(Context context, zzboa zzboaVar, Executor executor) {
        this.context = context;
        this.zzgwe = zzboaVar;
        this.zzfur = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzvt zzb;
        zzvt zzvtVar = zzdpiVar.zzhns.zzfzg.zzbpy;
        if (zzvtVar.zzciy) {
            zzb = new zzvt(this.context, com.google.android.gms.ads.zza.zzb(zzvtVar.width, zzvtVar.height));
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
                zzb = new zzvt(this.context, com.google.android.gms.ads.zza.zzc(zzvtVar.width, zzvtVar.height));
            } else {
                zzb = zzdpr.zzb(this.context, zzdotVar.zzhmj);
            }
        }
        zzvt zzvtVar2 = zzb;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
            zzctbVar.zzdoy.zza(this.context, zzvtVar2, zzdpiVar.zzhns.zzfzg.zzhnx, zzdotVar.zzhmk.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdotVar.zzhmh), zzctbVar.zzgvk);
        } else {
            zzctbVar.zzdoy.zzb(this.context, zzvtVar2, zzdpiVar.zzhns.zzfzg.zzhnx, zzdotVar.zzhmk.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdotVar.zzhmh), zzctbVar.zzgvk);
        }
    }

    private final View zza(zzctb<zzdqd, zzcuv> zzctbVar, zzdot zzdotVar) {
        zzanu zzvo = zzctbVar.zzdoy.zzvo();
        if (zzvo == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
            throw new zzdpq(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
        }
        try {
            View view = (View) ObjectWrapper.unwrap(zzvo.zzve());
            boolean shouldDelegateInterscrollerEffect = zzvo.shouldDelegateInterscrollerEffect();
            if (view != null) {
                if (shouldDelegateInterscrollerEffect) {
                    try {
                        return (View) zzebh.zzb(zzebh.zzag(null), new zzear(this, view, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcuc
                            private final zzdot zzfxi;
                            private final View zzgjd;
                            private final zzcua zzgwj;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzgwj = this;
                                this.zzgjd = view;
                                this.zzfxi = zzdotVar;
                            }

                            @Override // com.google.android.gms.internal.ads.zzear
                            public final zzebt zzf(Object obj) {
                                return this.zzgwj.zza(this.zzgjd, this.zzfxi, obj);
                            }
                        }, zzbat.zzeki).get();
                    } catch (InterruptedException | ExecutionException e2) {
                        throw new zzdpq(e2);
                    }
                }
                return view;
            }
            throw new zzdpq(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
        } catch (RemoteException e3) {
            throw new zzdpq(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzbne zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        View view;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
            view = zza(zzctbVar, zzdotVar);
        } else {
            view = zzctbVar.zzdoy.getView();
        }
        zzboa zzboaVar = this.zzgwe;
        zzbps zzbpsVar = new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja);
        zzdqd zzdqdVar = zzctbVar.zzdoy;
        zzdqdVar.getClass();
        zzbnh zza = zzboaVar.zza(zzbpsVar, new zzbnl(view, null, zzcud.zza(zzdqdVar), zzdotVar.zzhmj.get(0)));
        zza.zzaij().zzv(view);
        zza.zzahh().zza((zzbts) new zzbkx(zzctbVar.zzdoy), this.zzfur);
        zzctbVar.zzgvk.zzb(zza.zzahm());
        return zza.zzaii();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(View view, zzdot zzdotVar, Object obj) {
        return zzebh.zzag(zzbos.zza(this.context, view, zzdotVar));
    }
}
