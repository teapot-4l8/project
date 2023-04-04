package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.bugly.Bugly;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzeah<V> extends zzecl implements zzebt<V> {
    private static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final Logger zzice;
    private static final zzb zzicf;
    @NullableDecl
    private volatile zze listeners;
    @NullableDecl
    private volatile Object value;
    @NullableDecl
    private volatile zzk waiters;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class zzb {
        private zzb() {
        }

        abstract void zza(zzk zzkVar, zzk zzkVar2);

        abstract void zza(zzk zzkVar, Thread thread);

        abstract boolean zza(zzeah<?> zzeahVar, zze zzeVar, zze zzeVar2);

        abstract boolean zza(zzeah<?> zzeahVar, zzk zzkVar, zzk zzkVar2);

        abstract boolean zza(zzeah<?> zzeahVar, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzc {
        static final zzc zzici = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzeah.zzc.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzc(Throwable th) {
            this.exception = (Throwable) zzdyi.checkNotNull(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zze {
        static final zze zzicj = new zze(null, null);
        final Executor executor;
        @NullableDecl
        zze next;
        final Runnable task;

        zze(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzf extends zzb {
        private zzf() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzeahVar) {
                if (((zzeah) zzeahVar).waiters == zzkVar) {
                    ((zzeah) zzeahVar).waiters = zzkVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzeahVar) {
                if (((zzeah) zzeahVar).listeners == zzeVar) {
                    ((zzeah) zzeahVar).listeners = zzeVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, Object obj, Object obj2) {
            synchronized (zzeahVar) {
                if (((zzeah) zzeahVar).value == obj) {
                    ((zzeah) zzeahVar).value = obj2;
                    return true;
                }
                return false;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    static abstract class zzh<V> extends zzeah<V> implements zzi<V> {
        @Override // com.google.android.gms.internal.ads.zzeah, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zzi<V> extends zzebt<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzj extends zzb {
        static final Unsafe zzicl;
        static final long zzicm;
        static final long zzicn;
        static final long zzico;
        static final long zzicp;
        static final long zzicq;

        private zzj() {
            super();
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, Thread thread) {
            zzicl.putObject(zzkVar, zzicp, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            zzicl.putObject(zzkVar, zzicq, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zzk zzkVar, zzk zzkVar2) {
            return zzicl.compareAndSwapObject(zzeahVar, zzicn, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zze zzeVar, zze zzeVar2) {
            return zzicl.compareAndSwapObject(zzeahVar, zzicm, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, Object obj, Object obj2) {
            return zzicl.compareAndSwapObject(zzeahVar, zzico, obj, obj2);
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzeah.zzj.1
                        @Override // java.security.PrivilegedExceptionAction
                        public /* synthetic */ Unsafe run() {
                            Field[] declaredFields;
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzicn = unsafe.objectFieldOffset(zzeah.class.getDeclaredField("waiters"));
                    zzicm = unsafe.objectFieldOffset(zzeah.class.getDeclaredField("listeners"));
                    zzico = unsafe.objectFieldOffset(zzeah.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
                    zzicp = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                    zzicq = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                    zzicl = unsafe;
                } catch (Exception e2) {
                    zzdys.zzi(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzk {
        static final zzk zzicr = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        private zzk(boolean z) {
        }

        zzk() {
            zzeah.zzicf.zza(this, Thread.currentThread());
        }

        final void zzb(zzk zzkVar) {
            zzeah.zzicf.zza(this, zzkVar);
        }
    }

    private final void zza(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 == zzk.zzicr) {
                return;
            }
            zzk zzkVar3 = null;
            while (zzkVar2 != null) {
                zzk zzkVar4 = zzkVar2.next;
                if (zzkVar2.thread != null) {
                    zzkVar3 = zzkVar2;
                } else if (zzkVar3 != null) {
                    zzkVar3.next = zzkVar4;
                    if (zzkVar3.thread == null) {
                        break;
                    }
                } else if (zzicf.zza((zzeah<?>) this, zzkVar2, zzkVar4)) {
                }
                zzkVar2 = zzkVar4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterDone() {
    }

    protected void interruptTask() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza {
        static final zza zzicg;
        static final zza zzich;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        zza(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }

        static {
            if (zzeah.GENERATE_CANCELLATION_CAUSES) {
                zzich = null;
                zzicg = null;
                return;
            }
            zzich = new zza(false, null);
            zzicg = new zza(true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zzg<V> implements Runnable {
        final zzebt<? extends V> future;
        final zzeah<V> zzick;

        zzg(zzeah<V> zzeahVar, zzebt<? extends V> zzebtVar) {
            this.zzick = zzeahVar;
            this.future = zzebtVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzeah) this.zzick).value != this) {
                return;
            }
            if (zzeah.zzicf.zza((zzeah<?>) this.zzick, (Object) this, zzeah.getFutureValue(this.future))) {
                zzeah.zza((zzeah<?>) this.zzick);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzd extends zzb {
        final AtomicReferenceFieldUpdater<zzeah, zze> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzeah, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzeah, zzk> waitersUpdater;

        zzd(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzeah, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzeah, zze> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzeah, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final void zza(zzk zzkVar, zzk zzkVar2) {
            this.waiterNextUpdater.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zzk zzkVar, zzk zzkVar2) {
            return this.waitersUpdater.compareAndSet(zzeahVar, zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, zze zzeVar, zze zzeVar2) {
            return this.listenersUpdater.compareAndSet(zzeahVar, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzeah.zzb
        final boolean zza(zzeah<?> zzeahVar, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzeahVar, obj, obj2);
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) & (!(obj instanceof zzg))) {
            return (V) zzaf(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zzk zzkVar = this.waiters;
            if (zzkVar != zzk.zzicr) {
                zzk zzkVar2 = new zzk();
                do {
                    zzkVar2.zzb(zzkVar);
                    if (zzicf.zza((zzeah<?>) this, zzkVar, zzkVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzkVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) & (!(obj2 instanceof zzg))) {
                                return (V) zzaf(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzkVar2);
                    } else {
                        zzkVar = this.waiters;
                    }
                } while (zzkVar != zzk.zzicr);
                return (V) zzaf(this.value);
            }
            return (V) zzaf(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) & (!(obj3 instanceof zzg))) {
                return (V) zzaf(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String zzeahVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j);
        sb.append(" ");
        sb.append(lowerCase2);
        String sb2 = sb.toString();
        if (nanos + 1000 < 0) {
            String concat = String.valueOf(sb2).concat(" (plus ");
            long j2 = -nanos;
            long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String valueOf = String.valueOf(concat);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(lowerCase).length());
                sb3.append(valueOf);
                sb3.append(convert);
                sb3.append(" ");
                sb3.append(lowerCase);
                String sb4 = sb3.toString();
                if (z) {
                    sb4 = String.valueOf(sb4).concat(",");
                }
                concat = String.valueOf(sb4).concat(" ");
            }
            if (z) {
                String valueOf2 = String.valueOf(concat);
                StringBuilder sb5 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
                sb5.append(valueOf2);
                sb5.append(nanos2);
                sb5.append(" nanoseconds ");
                concat = sb5.toString();
            }
            sb2 = String.valueOf(concat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(zzeahVar).length());
        sb6.append(sb2);
        sb6.append(" for ");
        sb6.append(zzeahVar);
        throw new TimeoutException(sb6.toString());
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) & (!(obj2 instanceof zzg))) {
            return (V) zzaf(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zzicr) {
            zzk zzkVar2 = new zzk();
            do {
                zzkVar2.zzb(zzkVar);
                if (zzicf.zza((zzeah<?>) this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzg))));
                    return (V) zzaf(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zzicr);
            return (V) zzaf(this.value);
        }
        return (V) zzaf(this.value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static V zzaf(Object obj) {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).exception);
        } else {
            if (obj == NULL) {
                return null;
            }
            return obj;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zzg)) & (obj != null);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        zza zzaVar;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof zzg)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            zzaVar = new zza(z, new CancellationException("Future.cancel() was called."));
        } else if (z) {
            zzaVar = zza.zzicg;
        } else {
            zzaVar = zza.zzich;
        }
        boolean z2 = false;
        zzeah<V> zzeahVar = this;
        while (true) {
            if (zzicf.zza((zzeah<?>) zzeahVar, obj, (Object) zzaVar)) {
                if (z) {
                    zzeahVar.interruptTask();
                }
                zza((zzeah<?>) zzeahVar);
                if (!(obj instanceof zzg)) {
                    return true;
                }
                zzebt<? extends V> zzebtVar = ((zzg) obj).future;
                if (zzebtVar instanceof zzi) {
                    zzeahVar = (zzeah) zzebtVar;
                    obj = zzeahVar.value;
                    if (!(obj == null) && !(obj instanceof zzg)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    zzebtVar.cancel(z);
                    return true;
                }
            } else {
                obj = zzeahVar.value;
                if (!(obj instanceof zzg)) {
                    return z2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zza) && ((zza) obj).wasInterrupted;
    }

    @Override // com.google.android.gms.internal.ads.zzebt
    public void addListener(Runnable runnable, Executor executor) {
        zze zzeVar;
        zzdyi.checkNotNull(runnable, "Runnable was null.");
        zzdyi.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (zzeVar = this.listeners) != zze.zzicj) {
            zze zzeVar2 = new zze(runnable, executor);
            do {
                zzeVar2.next = zzeVar;
                if (zzicf.zza((zzeah<?>) this, zzeVar, zzeVar2)) {
                    return;
                }
                zzeVar = this.listeners;
            } while (zzeVar != zze.zzicj);
            zza(runnable, executor);
        }
        zza(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = (V) NULL;
        }
        if (zzicf.zza((zzeah<?>) this, (Object) null, (Object) v)) {
            zza((zzeah<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (zzicf.zza((zzeah<?>) this, (Object) null, (Object) new zzc((Throwable) zzdyi.checkNotNull(th)))) {
            zza((zzeah<?>) this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean setFuture(zzebt<? extends V> zzebtVar) {
        zzc zzcVar;
        zzdyi.checkNotNull(zzebtVar);
        Object obj = this.value;
        if (obj == null) {
            if (zzebtVar.isDone()) {
                if (zzicf.zza((zzeah<?>) this, (Object) null, getFutureValue(zzebtVar))) {
                    zza((zzeah<?>) this);
                    return true;
                }
                return false;
            }
            zzg zzgVar = new zzg(this, zzebtVar);
            if (zzicf.zza((zzeah<?>) this, (Object) null, (Object) zzgVar)) {
                try {
                    zzebtVar.addListener(zzgVar, zzeba.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Throwable unused) {
                        zzcVar = zzc.zzici;
                    }
                    zzicf.zza((zzeah<?>) this, (Object) zzgVar, (Object) zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zza) {
            zzebtVar.cancel(((zza) obj).wasInterrupted);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getFutureValue(zzebt<?> zzebtVar) {
        Throwable zza2;
        if (zzebtVar instanceof zzi) {
            Object obj = ((zzeah) zzebtVar).value;
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                if (zzaVar.wasInterrupted) {
                    if (zzaVar.cause != null) {
                        return new zza(false, zzaVar.cause);
                    }
                    return zza.zzich;
                }
                return obj;
            }
            return obj;
        } else if ((zzebtVar instanceof zzecl) && (zza2 = zzeck.zza((zzecl) zzebtVar)) != null) {
            return new zzc(zza2);
        } else {
            boolean isCancelled = zzebtVar.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
                return zza.zzich;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzebtVar);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzebtVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zza(false, new IllegalArgumentException(sb.toString()));
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    String valueOf2 = String.valueOf(zzebtVar);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 77);
                    sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    sb2.append(valueOf2);
                    return new zzc(new IllegalArgumentException(sb2.toString(), e2));
                }
                return new zza(false, e2);
            } catch (ExecutionException e3) {
                if (isCancelled) {
                    String valueOf3 = String.valueOf(zzebtVar);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 84);
                    sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb3.append(valueOf3);
                    return new zza(false, new IllegalArgumentException(sb3.toString(), e3));
                }
                return new zzc(e3.getCause());
            } catch (Throwable th) {
                return new zzc(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzeah$zzb] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.internal.ads.zzeah<?>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzeah] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzeah<V>, com.google.android.gms.internal.ads.zzeah] */
    public static void zza(zzeah<?> zzeahVar) {
        zze zzeVar;
        zze zzeVar2;
        zze zzeVar3 = null;
        while (true) {
            zzk zzkVar = ((zzeah) zzeahVar).waiters;
            if (zzicf.zza((zzeah) zzeahVar, zzkVar, zzk.zzicr)) {
                while (zzkVar != null) {
                    Thread thread = zzkVar.thread;
                    if (thread != null) {
                        zzkVar.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzkVar = zzkVar.next;
                }
                ((zzeah) zzeahVar).afterDone();
                do {
                    zzeVar = ((zzeah) zzeahVar).listeners;
                } while (!zzicf.zza((zzeah) zzeahVar, zzeVar, zze.zzicj));
                while (true) {
                    zzeVar2 = zzeVar3;
                    zzeVar3 = zzeVar;
                    if (zzeVar3 == null) {
                        break;
                    }
                    zzeVar = zzeVar3.next;
                    zzeVar3.next = zzeVar2;
                }
                while (zzeVar2 != null) {
                    zzeVar3 = zzeVar2.next;
                    Runnable runnable = zzeVar2.task;
                    if (runnable instanceof zzg) {
                        zzg zzgVar = (zzg) runnable;
                        zzeahVar = zzgVar.zzick;
                        if (((zzeah) zzeahVar).value == zzgVar) {
                            if (!zzicf.zza(zzeahVar, zzgVar, getFutureValue(zzgVar.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzeVar2.executor);
                    }
                    zzeVar2 = zzeVar3;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzecl
    @NullableDecl
    public final Throwable zzbas() {
        if (this instanceof zzi) {
            Object obj = this.value;
            if (obj instanceof zzc) {
                return ((zzc) obj).exception;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    public String toString() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            zza(sb2);
        } else {
            int length = sb2.length();
            sb2.append("PENDING");
            Object obj = this.value;
            if (obj instanceof zzg) {
                sb2.append(", setFuture=[");
                zzebt<? extends V> zzebtVar = ((zzg) obj).future;
                try {
                    if (zzebtVar == this) {
                        sb2.append("this future");
                    } else {
                        sb2.append(zzebtVar);
                    }
                } catch (RuntimeException | StackOverflowError e2) {
                    sb2.append("Exception thrown from implementation: ");
                    sb2.append(e2.getClass());
                }
                sb2.append("]");
            } else {
                try {
                    sb = zzdyq.emptyToNull(pendingToString());
                } catch (RuntimeException | StackOverflowError e3) {
                    String valueOf = String.valueOf(e3.getClass());
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb3.append("Exception thrown from implementation: ");
                    sb3.append(valueOf);
                    sb = sb3.toString();
                }
                if (sb != null) {
                    sb2.append(", info=[");
                    sb2.append(sb);
                    sb2.append("]");
                }
            }
            if (isDone()) {
                sb2.delete(length, sb2.length());
                zza(sb2);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (this instanceof ScheduledFuture) {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder(41);
            sb.append("remaining delay=[");
            sb.append(delay);
            sb.append(" ms]");
            return sb.toString();
        }
        return null;
    }

    private final void zza(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            if (uninterruptibly == null) {
                sb.append("null");
            } else if (uninterruptibly == this) {
                sb.append("this future");
            } else {
                sb.append(uninterruptibly.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(uninterruptibly)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzice;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e2);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zzb zzfVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Bugly.SDK_IS_DEV));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        zzice = Logger.getLogger(zzeah.class.getName());
        try {
            zzfVar = new zzj();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = th3;
                zzfVar = new zzd(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzeah.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzeah.class, zze.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzeah.class, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
                th = null;
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                zzfVar = new zzf();
            }
        }
        zzicf = zzfVar;
        if (th != null) {
            zzice.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzice.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }
}
