package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeah;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzeap<OutputT> extends zzeah.zzh<OutputT> {
    private static final Logger zzice = Logger.getLogger(zzeap.class.getName());
    private static final zza zzida;
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static abstract class zza {
        private zza() {
        }

        abstract void zza(zzeap zzeapVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int zzc(zzeap zzeapVar);
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzb extends zza {
        private zzb() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzeap.zza
        final void zza(zzeap zzeapVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzeapVar) {
                if (zzeapVar.seenExceptions == null) {
                    zzeapVar.seenExceptions = set2;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeap.zza
        final int zzc(zzeap zzeapVar) {
            int zzb;
            synchronized (zzeapVar) {
                zzb = zzeap.zzb(zzeapVar);
            }
            return zzb;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeap(int i) {
        this.remaining = i;
    }

    abstract void zzh(Set<Throwable> set);

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzc extends zza {
        private final AtomicReferenceFieldUpdater<zzeap, Set<Throwable>> zzide;
        private final AtomicIntegerFieldUpdater<zzeap> zzidf;

        zzc(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzide = atomicReferenceFieldUpdater;
            this.zzidf = atomicIntegerFieldUpdater;
        }

        @Override // com.google.android.gms.internal.ads.zzeap.zza
        final void zza(zzeap zzeapVar, Set<Throwable> set, Set<Throwable> set2) {
            this.zzide.compareAndSet(zzeapVar, null, set2);
        }

        @Override // com.google.android.gms.internal.ads.zzeap.zza
        final int zzc(zzeap zzeapVar) {
            return this.zzidf.decrementAndGet(zzeapVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Throwable> zzbax() {
        Set<Throwable> set = this.seenExceptions;
        if (set == null) {
            Set<Throwable> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            zzh(newSetFromMap);
            zzida.zza(this, null, newSetFromMap);
            return this.seenExceptions;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzbay() {
        return zzida.zzc(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzbaz() {
        this.seenExceptions = null;
    }

    static /* synthetic */ int zzb(zzeap zzeapVar) {
        int i = zzeapVar.remaining - 1;
        zzeapVar.remaining = i;
        return i;
    }

    static {
        zza zzbVar;
        Throwable th;
        try {
            zzbVar = new zzc(AtomicReferenceFieldUpdater.newUpdater(zzeap.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzeap.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            zzbVar = new zzb();
            th = th2;
        }
        zzida = zzbVar;
        if (th != null) {
            zzice.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }
}
