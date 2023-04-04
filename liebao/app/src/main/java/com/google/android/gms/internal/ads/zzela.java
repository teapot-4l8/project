package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.8.0 */
/* loaded from: classes.dex */
final class zzela extends WeakReference<Throwable> {
    private final int zzioi;

    public zzela(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzioi = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zzioi;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzela zzelaVar = (zzela) obj;
            if (this.zzioi == zzelaVar.zzioi && get() == zzelaVar.get()) {
                return true;
            }
        }
        return false;
    }
}
