package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdty implements zzdtw {
    private final zzdtw zzhun;
    private final Queue<zzdtx> zzhuo = new LinkedBlockingQueue();
    private final int zzhup = ((Integer) zzww.zzra().zzd(zzabq.zzdbo)).intValue();
    private final AtomicBoolean zzhuq = new AtomicBoolean(false);

    public zzdty(zzdtw zzdtwVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzhun = zzdtwVar;
        long intValue = ((Integer) zzww.zzra().zzd(zzabq.zzdbn)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdub
            private final zzdty zzhuu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhuu = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhuu.zzayj();
            }
        }, intValue, intValue, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final void zzb(zzdtx zzdtxVar) {
        if (this.zzhuo.size() >= this.zzhup) {
            if (this.zzhuq.getAndSet(true)) {
                return;
            }
            Queue<zzdtx> queue = this.zzhuo;
            zzdtx zzgy = zzdtx.zzgy("dropped_event");
            Map<String, String> zzlw = zzdtxVar.zzlw();
            if (zzlw.containsKey("action")) {
                zzgy.zzw("dropped_action", zzlw.get("action"));
            }
            queue.offer(zzgy);
            return;
        }
        this.zzhuo.offer(zzdtxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final String zzc(zzdtx zzdtxVar) {
        return this.zzhun.zzc(zzdtxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzayj() {
        while (!this.zzhuo.isEmpty()) {
            this.zzhun.zzb(this.zzhuo.remove());
        }
    }
}
