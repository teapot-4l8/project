package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzead<V, X extends Throwable, F, T> extends zzebb<V> implements Runnable {
    @NullableDecl
    private zzebt<? extends V> zzibw;
    @NullableDecl
    private Class<X> zzibx;
    @NullableDecl
    private F zziby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <X extends Throwable, V> zzebt<V> zza(zzebt<? extends V> zzebtVar, Class<X> cls, zzear<? super X, ? extends V> zzearVar, Executor executor) {
        zzeag zzeagVar = new zzeag(zzebtVar, cls, zzearVar);
        zzebtVar.addListener(zzeagVar, zzebv.zza(executor, zzeagVar));
        return zzeagVar;
    }

    abstract void setResult(@NullableDecl T t);

    @NullableDecl
    abstract T zza(F f, X x);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzead(zzebt<? extends V> zzebtVar, Class<X> cls, F f) {
        this.zzibw = (zzebt) zzdyi.checkNotNull(zzebtVar);
        this.zzibx = (Class) zzdyi.checkNotNull(cls);
        this.zziby = (F) zzdyi.checkNotNull(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Class<X extends java.lang.Throwable>, F] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        zzebt<? extends V> zzebtVar = this.zzibw;
        Class<X> cls = this.zzibx;
        F f = this.zziby;
        if (((f == null) || ((zzebtVar == null) | (cls == null))) || isCancelled()) {
            return;
        }
        ?? r3 = (Class<X>) false;
        this.zzibw = null;
        try {
            th = zzebtVar instanceof zzecl ? zzeck.zza((zzecl) zzebtVar) : null;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null) {
                String valueOf = String.valueOf(zzebtVar.getClass());
                String valueOf2 = String.valueOf(e2.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + String.valueOf(valueOf2).length());
                sb.append("Future type ");
                sb.append(valueOf);
                sb.append(" threw ");
                sb.append(valueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            obj = zzebh.zza(zzebtVar);
            if (th != null) {
                set(obj);
                return;
            } else if (!cls.isInstance(th)) {
                setFuture(zzebtVar);
                return;
            } else {
                try {
                    Object zza = zza((zzead<V, X, F, T>) f, (F) th);
                    this.zzibx = null;
                    this.zziby = null;
                    setResult(zza);
                    return;
                } catch (Throwable th2) {
                    try {
                        setException(th2);
                        return;
                    } finally {
                        this.zzibx = null;
                        this.zziby = null;
                    }
                }
            }
        }
        obj = null;
        if (th != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final String pendingToString() {
        String str;
        zzebt<? extends V> zzebtVar = this.zzibw;
        Class<X> cls = this.zzibx;
        F f = this.zziby;
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
        if (cls == null || f == null) {
            if (pendingToString != null) {
                String valueOf2 = String.valueOf(str);
                String valueOf3 = String.valueOf(pendingToString);
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            return null;
        }
        String valueOf4 = String.valueOf(cls);
        String valueOf5 = String.valueOf(f);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb2.append(str);
        sb2.append("exceptionType=[");
        sb2.append(valueOf4);
        sb2.append("], fallback=[");
        sb2.append(valueOf5);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeah
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzibw);
        this.zzibw = null;
        this.zzibx = null;
        this.zziby = null;
    }
}
