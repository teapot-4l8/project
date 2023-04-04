package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzebj<V> implements Runnable {
    private final Future<V> zzido;
    private final zzebi<? super V> zzidp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebj(Future<V> future, zzebi<? super V> zzebiVar) {
        this.zzido = future;
        this.zzidp = zzebiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable zza;
        Future<V> future = this.zzido;
        if ((future instanceof zzecl) && (zza = zzeck.zza((zzecl) future)) != null) {
            this.zzidp.zzb(zza);
            return;
        }
        try {
            this.zzidp.onSuccess(zzebh.zza(this.zzido));
        } catch (Error e2) {
            e = e2;
            this.zzidp.zzb(e);
        } catch (RuntimeException e3) {
            e = e3;
            this.zzidp.zzb(e);
        } catch (ExecutionException e4) {
            this.zzidp.zzb(e4.getCause());
        }
    }

    public final String toString() {
        return zzdxy.zzw(this).zzy(this.zzidp).toString();
    }
}
