package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcma {
    private final Map<String, String> zzdcn = new ConcurrentHashMap();
    private final /* synthetic */ zzcmb zzgoe;

    public zzcma(zzcmb zzcmbVar) {
        this.zzgoe = zzcmbVar;
    }

    public final zzcma zzarl() {
        Map<? extends String, ? extends String> map;
        Map<String, String> map2 = this.zzdcn;
        map = this.zzgoe.zzgof;
        map2.putAll(map);
        return this;
    }

    public final zzcma zza(zzdoy zzdoyVar) {
        this.zzdcn.put("gqi", zzdoyVar.zzbwe);
        return this;
    }

    public final zzcma zzc(zzdot zzdotVar) {
        this.zzdcn.put("aai", zzdotVar.zzdnw);
        return this;
    }

    public final zzcma zzs(String str, String str2) {
        this.zzdcn.put(str, str2);
        return this;
    }

    public final void zzarm() {
        Executor executor;
        executor = this.zzgoe.executor;
        executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcmd
            private final zzcma zzgog;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgog = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgog.zzaro();
            }
        });
    }

    public final String zzarn() {
        zzcmg zzcmgVar;
        zzcmgVar = this.zzgoe.zzgob;
        return zzcmgVar.zzp(this.zzdcn);
    }

    public final /* synthetic */ void zzaro() {
        zzcmg zzcmgVar;
        zzcmgVar = this.zzgoe.zzgob;
        zzcmgVar.zzo(this.zzdcn);
    }
}
