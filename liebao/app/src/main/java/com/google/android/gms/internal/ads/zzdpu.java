package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpu {
    private final zzcsh zzdji;
    private final zzdot zzeux;
    private final zzdoy zzeuy;
    private final zzdup zzftn;

    public zzdpu(zzcsh zzcshVar, zzdup zzdupVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        this.zzeux = zzdotVar;
        this.zzeuy = zzdoyVar;
        this.zzdji = zzcshVar;
        this.zzftn = zzdupVar;
    }

    public final void zzj(List<String> list) {
        for (String str : list) {
            zzb(str, zzcse.zzgui);
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Ljava/lang/String;>;Ljava/lang/Integer;)V */
    public final void zza(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), i);
        }
    }

    private final void zzb(String str, int i) {
        if (!this.zzeux.zzhmz) {
            this.zzftn.zzen(str);
            return;
        }
        this.zzdji.zza(new zzcso(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis(), this.zzeuy.zzbwe, str, i));
    }
}
