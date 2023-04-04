package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeca<V> extends zzebb<V> {
    @NullableDecl
    private zzebt<V> zzieb;
    @NullableDecl
    private ScheduledFuture<?> zziec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzebt<V> zzb(zzebt<V> zzebtVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzeca zzecaVar = new zzeca(zzebtVar);
        zzecc zzeccVar = new zzecc(zzecaVar);
        zzecaVar.zziec = scheduledExecutorService.schedule(zzeccVar, j, timeUnit);
        zzebtVar.addListener(zzeccVar, zzeba.INSTANCE);
        return zzecaVar;
    }

    private zzeca(zzebt<V> zzebtVar) {
        this.zzieb = (zzebt) zzdyi.checkNotNull(zzebtVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final String pendingToString() {
        zzebt<V> zzebtVar = this.zzieb;
        ScheduledFuture<?> scheduledFuture = this.zziec;
        if (zzebtVar != null) {
            String valueOf = String.valueOf(zzebtVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("]");
            String sb2 = sb.toString();
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    String valueOf2 = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
                    sb3.append(valueOf2);
                    sb3.append(", remaining delay=[");
                    sb3.append(delay);
                    sb3.append(" ms]");
                    return sb3.toString();
                }
                return sb2;
            }
            return sb2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzieb);
        ScheduledFuture<?> scheduledFuture = this.zziec;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzieb = null;
        this.zziec = null;
    }
}
