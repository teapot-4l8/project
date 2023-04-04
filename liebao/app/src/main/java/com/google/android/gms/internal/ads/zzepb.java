package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepb {
    private static final zzepb zziwr = new zzepb();
    private final ConcurrentMap<Class<?>, zzepi<?>> zziwt = new ConcurrentHashMap();
    private final zzepl zziws = new zzeoa();

    public static zzepb zzble() {
        return zziwr;
    }

    public final <T> zzepi<T> zzj(Class<T> cls) {
        zzenc.zza(cls, "messageType");
        zzepi<T> zzepiVar = (zzepi<T>) this.zziwt.get(cls);
        if (zzepiVar == null) {
            zzepi<T> zzi = this.zziws.zzi(cls);
            zzenc.zza(cls, "messageType");
            zzenc.zza(zzi, "schema");
            zzepi<T> zzepiVar2 = (zzepi<T>) this.zziwt.putIfAbsent(cls, zzi);
            return zzepiVar2 != null ? zzepiVar2 : zzi;
        }
        return zzepiVar;
    }

    public final <T> zzepi<T> zzax(T t) {
        return zzj(t.getClass());
    }

    private zzepb() {
    }
}
