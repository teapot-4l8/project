package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhd<T> {
    private final Executor executor;
    private final Set<zzdhe<? extends zzdhb<T>>> zzhgm;

    public zzdhd(Executor executor, Set<zzdhe<? extends zzdhb<T>>> set) {
        this.executor = executor;
        this.zzhgm = set;
    }

    public final zzebt<T> zzs(T t) {
        ArrayList arrayList = new ArrayList(this.zzhgm.size());
        for (final zzdhe<? extends zzdhb<T>> zzdheVar : this.zzhgm) {
            zzebt<? extends zzdhb<T>> zzatu = zzdheVar.zzatu();
            if (zzadm.zzdfe.get().booleanValue()) {
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
                zzatu.addListener(new Runnable(zzdheVar, elapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzdhg
                    private final zzdhe zzhgn;
                    private final long zzhgo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhgn = zzdheVar;
                        this.zzhgo = elapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdhe zzdheVar2 = this.zzhgn;
                        long j = this.zzhgo;
                        String canonicalName = zzdheVar2.getClass().getCanonicalName();
                        long elapsedRealtime2 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - j;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(elapsedRealtime2);
                        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
                    }
                }, zzbat.zzekj);
            }
            arrayList.add(zzatu);
        }
        return zzebh.zzk(arrayList).zzb(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.zzdhf
            private final Object zzdms;
            private final List zzhfu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfu = arrayList;
                this.zzdms = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzebt> list = this.zzhfu;
                Object obj = this.zzdms;
                for (zzebt zzebtVar : list) {
                    zzdhb zzdhbVar = (zzdhb) zzebtVar.get();
                    if (zzdhbVar != null) {
                        zzdhbVar.zzr(obj);
                    }
                }
                return obj;
            }
        }, this.executor);
    }
}
