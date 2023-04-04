package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlx {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdma<T> zzdmaVar) {
        T t = atomicReference.get();
        if (t == null) {
            return;
        }
        try {
            zzdmaVar.zzp(t);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }
}
