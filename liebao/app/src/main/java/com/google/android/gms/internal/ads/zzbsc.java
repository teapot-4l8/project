package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsc {
    private final String packageName;
    private final zzbar zzbpj;
    private final PackageInfo zzdvo;
    private final List<String> zzdvy;
    private final String zzdyt;
    private final zzdtg zzfzh;
    private final ApplicationInfo zzgar;
    private final zzeru<zzebt<String>> zzgas;
    private final zzdhd<Bundle> zzgat;

    public zzbsc(zzdtg zzdtgVar, zzbar zzbarVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeru<zzebt<String>> zzeruVar, com.google.android.gms.ads.internal.util.zzf zzfVar, String str2, zzdhd<Bundle> zzdhdVar) {
        this.zzfzh = zzdtgVar;
        this.zzbpj = zzbarVar;
        this.zzgar = applicationInfo;
        this.packageName = str;
        this.zzdvy = list;
        this.zzdvo = packageInfo;
        this.zzgas = zzeruVar;
        this.zzdyt = str2;
        this.zzgat = zzdhdVar;
    }

    public final zzebt<Bundle> zzamc() {
        return this.zzfzh.zzt(zzdth.SIGNALS).zze(this.zzgat.zzs(new Bundle())).zzayi();
    }

    public final zzebt<zzauj> zzamd() {
        zzebt<Bundle> zzamc = zzamc();
        return this.zzfzh.zza((zzdtg) zzdth.REQUEST_PARCEL, zzamc, this.zzgas.get()).zzb(new Callable(this, zzamc) { // from class: com.google.android.gms.internal.ads.zzbsf
            private final zzbsc zzgbb;
            private final zzebt zzgbc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbb = this;
                this.zzgbc = zzamc;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgbb.zzc(this.zzgbc);
            }
        }).zzayi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzauj zzc(zzebt zzebtVar) {
        return new zzauj((Bundle) zzebtVar.get(), this.zzbpj, this.zzgar, this.packageName, this.zzdvy, this.zzdvo, this.zzgas.get().get(), this.zzdyt, null, null);
    }
}
