package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbxq<ListenerT> {
    private final Map<ListenerT, Executor> zzgcm = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbxq(Set<zzbzl<ListenerT>> set) {
        zzb(set);
    }

    public final synchronized void zza(zzbzl<ListenerT> zzbzlVar) {
        zza(zzbzlVar.zzgdh, zzbzlVar.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzgcm.put(listenert, executor);
    }

    private final synchronized void zzb(Set<zzbzl<ListenerT>> set) {
        for (zzbzl<ListenerT> zzbzlVar : set) {
            zza(zzbzlVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zza(final zzbxs<ListenerT> zzbxsVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.zzgcm.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbxsVar, key) { // from class: com.google.android.gms.internal.ads.zzbxp
                private final Object zzdms;
                private final zzbxs zzgcl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgcl = zzbxsVar;
                    this.zzdms = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.zzgcl.zzo(this.zzdms);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.zzr.zzkz().zzb(th, "EventEmitter.notify");
                        com.google.android.gms.ads.internal.util.zzd.zza("Event emitter exception.", th);
                    }
                }
            });
        }
    }
}
