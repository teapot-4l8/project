package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzeak<I, O, F, T> extends zzebb<O> implements Runnable {
    @NullableDecl
    private zzebt<? extends I> zzibw;
    @NullableDecl
    private F zzics;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzebt<O> zza(zzebt<I> zzebtVar, zzear<? super I, ? extends O> zzearVar, Executor executor) {
        zzdyi.checkNotNull(executor);
        zzeaj zzeajVar = new zzeaj(zzebtVar, zzearVar);
        zzebtVar.addListener(zzeajVar, zzebv.zza(executor, zzeajVar));
        return zzeajVar;
    }

    abstract void setResult(@NullableDecl T t);

    @NullableDecl
    abstract T zzd(F f, @NullableDecl I i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <I, O> zzebt<O> zza(zzebt<I> zzebtVar, zzdxw<? super I, ? extends O> zzdxwVar, Executor executor) {
        zzdyi.checkNotNull(zzdxwVar);
        zzeam zzeamVar = new zzeam(zzebtVar, zzdxwVar);
        zzebtVar.addListener(zzeamVar, zzebv.zza(executor, zzeamVar));
        return zzeamVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeak(zzebt<? extends I> zzebtVar, F f) {
        this.zzibw = (zzebt) zzdyi.checkNotNull(zzebtVar);
        this.zzics = (F) zzdyi.checkNotNull(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzebt<? extends I> zzebtVar = this.zzibw;
        F f = this.zzics;
        if ((isCancelled() | (zzebtVar == null)) || (f == null)) {
            return;
        }
        this.zzibw = null;
        if (zzebtVar.isCancelled()) {
            setFuture(zzebtVar);
            return;
        }
        try {
            try {
                Object zzd = zzd(f, zzebh.zza(zzebtVar));
                this.zzics = null;
                setResult(zzd);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.zzics = null;
                }
            }
        } catch (Error e2) {
            setException(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e3) {
            setException(e3);
        } catch (ExecutionException e4) {
            setException(e4.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzibw);
        this.zzibw = null;
        this.zzics = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final String pendingToString() {
        String str;
        zzebt<? extends I> zzebtVar = this.zzibw;
        F f = this.zzics;
        String pendingToString = super.pendingToString();
        if (zzebtVar != null) {
            String valueOf = String.valueOf(zzebtVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        } else {
            str = "";
        }
        if (f == null) {
            if (pendingToString != null) {
                String valueOf2 = String.valueOf(str);
                String valueOf3 = String.valueOf(pendingToString);
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            return null;
        }
        String valueOf4 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf4).length());
        sb2.append(str);
        sb2.append("function=[");
        sb2.append(valueOf4);
        sb2.append("]");
        return sb2.toString();
    }
}
