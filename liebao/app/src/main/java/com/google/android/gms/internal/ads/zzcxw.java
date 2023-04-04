package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbug;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxw<AdT, AdapterT, ListenerT extends zzbug> implements zzcsz<AdT> {
    private final zzcta<AdapterT, ListenerT> zzfss;
    private final zzdtg zzfzh;
    private final zzcth<AdT, AdapterT, ListenerT> zzgzc;
    private final zzebs zzgzd;

    public zzcxw(zzdtg zzdtgVar, zzebs zzebsVar, zzcta<AdapterT, ListenerT> zzctaVar, zzcth<AdT, AdapterT, ListenerT> zzcthVar) {
        this.zzfzh = zzdtgVar;
        this.zzgzd = zzebsVar;
        this.zzgzc = zzcthVar;
        this.zzfss = zzctaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return !zzdotVar.zzhmi.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<AdT> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzctb<AdapterT, ListenerT> zzctbVar;
        Iterator<String> it = zzdotVar.zzhmi.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzctbVar = null;
                break;
            }
            try {
                zzctbVar = this.zzfss.zzf(it.next(), zzdotVar.zzhmk);
                break;
            } catch (zzdpq unused) {
            }
        }
        if (zzctbVar == null) {
            return zzebh.immediateFailedFuture(new zzcwa("unable to instantiate mediation adapter class"));
        }
        zzbbe zzbbeVar = new zzbbe();
        zzctbVar.zzgvk.zza(new zzcyb(this, zzctbVar, zzbbeVar));
        if (zzdotVar.zzead) {
            Bundle bundle = zzdpiVar.zzhns.zzfzg.zzhnx.zzcih;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzfzh.zzt(zzdth.ADAPTER_LOAD_AD_SYN).zza(new zzdsq(this, zzdpiVar, zzdotVar, zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcxz
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzctb zzgyy;
            private final zzcxw zzgze;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgze = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
                this.zzgyy = zzctbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdsq
            public final void run() {
                this.zzgze.zzd(this.zzgjy, this.zzfxi, this.zzgyy);
            }
        }, this.zzgzd).zzv(zzdth.ADAPTER_LOAD_AD_ACK).zze(zzbbeVar).zzv(zzdth.ADAPTER_WRAP_ADAPTER).zzb(new zzdsr(this, zzdpiVar, zzdotVar, zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcxy
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzctb zzgyy;
            private final zzcxw zzgze;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgze = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
                this.zzgyy = zzctbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                return this.zzgze.zza(this.zzgjy, this.zzfxi, this.zzgyy, (Void) obj);
            }
        }).zzayi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(String str, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 31);
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb zzctbVar, Void r4) {
        return this.zzgzc.zzb(zzdpiVar, zzdotVar, zzctbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdpi zzdpiVar, zzdot zzdotVar, zzctb zzctbVar) {
        this.zzgzc.zza(zzdpiVar, zzdotVar, zzctbVar);
    }
}
