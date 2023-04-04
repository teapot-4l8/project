package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzas implements zzad {
    private final zzm zzbn;
    private final zzal zzby;
    private final BlockingQueue<zzab<?>> zzm;
    private final Map<String, List<zzab<?>>> zzbx = new HashMap();
    private final zzaf zzau = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzm zzmVar, BlockingQueue<zzab<?>> blockingQueue, zzal zzalVar) {
        this.zzby = zzalVar;
        this.zzbn = zzmVar;
        this.zzm = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzad
    public final void zzb(zzab<?> zzabVar, zzag<?> zzagVar) {
        List<zzab<?>> remove;
        if (zzagVar.zzbq == null || zzagVar.zzbq.zza()) {
            zzc(zzabVar);
            return;
        }
        String zze = zzabVar.zze();
        synchronized (this) {
            remove = this.zzbx.remove(zze);
        }
        if (remove != null) {
            if (zzao.DEBUG) {
                zzao.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zze);
            }
            for (zzab<?> zzabVar2 : remove) {
                this.zzby.zza(zzabVar2, zzagVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzad
    public final synchronized void zzc(zzab<?> zzabVar) {
        String zze = zzabVar.zze();
        List<zzab<?>> remove = this.zzbx.remove(zze);
        if (remove != null && !remove.isEmpty()) {
            if (zzao.DEBUG) {
                zzao.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zze);
            }
            zzab<?> remove2 = remove.remove(0);
            this.zzbx.put(zze, remove);
            remove2.zza((zzad) this);
            if (this.zzbn != null && this.zzm != null) {
                try {
                    this.zzm.put(remove2);
                } catch (InterruptedException e2) {
                    zzao.e("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.zzbn.quit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzg(zzab<?> zzabVar) {
        String zze = zzabVar.zze();
        if (this.zzbx.containsKey(zze)) {
            List<zzab<?>> list = this.zzbx.get(zze);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzabVar.zzc("waiting-for-response");
            list.add(zzabVar);
            this.zzbx.put(zze, list);
            if (zzao.DEBUG) {
                zzao.d("Request for cacheKey=%s is in flight, putting on hold.", zze);
            }
            return true;
        }
        this.zzbx.put(zze, null);
        zzabVar.zza((zzad) this);
        if (zzao.DEBUG) {
            zzao.d("new request, sending to network %s", zze);
        }
        return false;
    }
}
