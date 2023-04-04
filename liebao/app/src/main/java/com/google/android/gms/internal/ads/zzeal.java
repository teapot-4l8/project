package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzeal<InputT, OutputT> extends zzeap<OutputT> {
    private static final Logger logger = Logger.getLogger(zzeal.class.getName());
    @NullableDecl
    private zzdyv<? extends zzebt<? extends InputT>> zzict;
    private final boolean zzicu;
    private final boolean zzicv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeal(zzdyv<? extends zzebt<? extends InputT>> zzdyvVar, boolean z, boolean z2) {
        super(zzdyvVar.size());
        this.zzict = (zzdyv) zzdyi.checkNotNull(zzdyvVar);
        this.zzicu = z;
        this.zzicv = z2;
    }

    abstract void zzb(int i, @NullableDecl InputT inputt);

    abstract void zzbaw();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final void afterDone() {
        super.afterDone();
        zzdyv<? extends zzebt<? extends InputT>> zzdyvVar = this.zzict;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdyvVar != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdzx zzdzxVar = (zzdzx) zzdyvVar.iterator();
            while (zzdzxVar.hasNext()) {
                ((Future) zzdzxVar.next()).cancel(wasInterrupted);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final String pendingToString() {
        zzdyv<? extends zzebt<? extends InputT>> zzdyvVar = this.zzict;
        if (zzdyvVar != null) {
            String valueOf = String.valueOf(zzdyvVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
            sb.append("futures=");
            sb.append(valueOf);
            return sb.toString();
        }
        return super.pendingToString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzbav() {
        if (this.zzict.isEmpty()) {
            zzbaw();
        } else if (this.zzicu) {
            int i = 0;
            zzdzx zzdzxVar = (zzdzx) this.zzict.iterator();
            while (zzdzxVar.hasNext()) {
                zzebt zzebtVar = (zzebt) zzdzxVar.next();
                zzebtVar.addListener(new zzeao(this, zzebtVar, i), zzeba.INSTANCE);
                i++;
            }
        } else {
            zzean zzeanVar = new zzean(this, this.zzicv ? this.zzict : null);
            zzdzx zzdzxVar2 = (zzdzx) this.zzict.iterator();
            while (zzdzxVar2.hasNext()) {
                ((zzebt) zzdzxVar2.next()).addListener(zzeanVar, zzeba.INSTANCE);
            }
        }
    }

    private final void handleException(Throwable th) {
        zzdyi.checkNotNull(th);
        if (this.zzicu && !setException(th) && zza(zzbax(), th)) {
            zzk(th);
        } else if (th instanceof Error) {
            zzk(th);
        }
    }

    private static void zzk(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.android.gms.internal.ads.zzeap
    final void zzh(Set<Throwable> set) {
        zzdyi.checkNotNull(set);
        if (isCancelled()) {
            return;
        }
        zza(set, zzbas());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, (int) zzebh.zza(future));
        } catch (ExecutionException e2) {
            handleException(e2.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(@NullableDecl zzdyv<? extends Future<? extends InputT>> zzdyvVar) {
        int zzbay = zzbay();
        int i = 0;
        if (!(zzbay >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        }
        if (zzbay == 0) {
            if (zzdyvVar != null) {
                zzdzx zzdzxVar = (zzdzx) zzdyvVar.iterator();
                while (zzdzxVar.hasNext()) {
                    Future<? extends InputT> future = (Future) zzdzxVar.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzbaz();
            zzbaw();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zza zzaVar) {
        zzdyi.checkNotNull(zzaVar);
        this.zzict = null;
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
