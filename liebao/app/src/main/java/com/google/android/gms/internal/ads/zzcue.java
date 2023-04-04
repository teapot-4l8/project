package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcue implements zzcth<zzbne, zzaqa, zzcuv> {
    private final Context context;
    private View view;
    private final zzboa zzgwe;
    private zzanu zzgwl;

    public zzcue(Context context, zzboa zzboaVar) {
        this.context = context;
        this.zzgwe = zzboaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        try {
            zzctbVar.zzdoy.zzdn(zzdotVar.zzdpg);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
                zzctbVar.zzdoy.zzb(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcui(this, zzctbVar), zzctbVar.zzgvk, zzdpiVar.zzhns.zzfzg.zzbpy);
            } else {
                zzctbVar.zzdoy.zza(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcui(this, zzctbVar), zzctbVar.zzgvk, zzdpiVar.zzhns.zzfzg.zzbpy);
            }
        } catch (RemoteException e2) {
            throw new zzdpq(e2);
        }
    }

    private final View zze(zzdot zzdotVar) {
        try {
            View view = (View) ObjectWrapper.unwrap(this.zzgwl.zzve());
            boolean shouldDelegateInterscrollerEffect = this.zzgwl.shouldDelegateInterscrollerEffect();
            if (view != null) {
                if (shouldDelegateInterscrollerEffect) {
                    try {
                        return (View) zzebh.zzb(zzebh.zzag(null), new zzear(this, view, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcug
                            private final zzdot zzfxi;
                            private final View zzgjd;
                            private final zzcue zzgwm;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzgwm = this;
                                this.zzgjd = view;
                                this.zzfxi = zzdotVar;
                            }

                            @Override // com.google.android.gms.internal.ads.zzear
                            public final zzebt zzf(Object obj) {
                                return this.zzgwm.zzb(this.zzgjd, this.zzfxi, obj);
                            }
                        }, zzbat.zzeki).get();
                    } catch (InterruptedException | ExecutionException e2) {
                        throw new zzdpq(e2);
                    }
                }
                return view;
            }
            throw new zzdpq(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
        } catch (RemoteException e3) {
            throw new zzdpq(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzbne zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        View view;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
            view = zze(zzdotVar);
        } else {
            view = this.view;
        }
        zzbnh zza = this.zzgwe.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzbnl(view, null, new zzbpd(zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcuh
            private final zzctb zzgwn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwn = zzctbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbpd
            public final zzzd getVideoController() {
                return zzcue.zza(this.zzgwn);
            }
        }, zzdotVar.zzhmj.get(0)));
        zza.zzaij().zzv(view);
        zzctbVar.zzgvk.zzb(zza.zzahn());
        return zza.zzaii();
    }

    public final /* synthetic */ zzebt zzb(View view, zzdot zzdotVar, Object obj) {
        return zzebh.zzag(zzbos.zza(this.context, view, zzdotVar));
    }

    public static final /* synthetic */ zzzd zza(zzctb zzctbVar) {
        try {
            return ((zzaqa) zzctbVar.zzdoy).getVideoController();
        } catch (RemoteException e2) {
            throw new zzdpq(e2);
        }
    }
}
