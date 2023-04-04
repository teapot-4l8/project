package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmo {
    public static Set<zzbzl<zzbtp>> zza(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<AppEventListener>> zzb(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzbuj>> zzc(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzbsz>> zzd(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzbsy>> zze(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzbtq>> zzf(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzve>> zzg(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzdtm>> zzh(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    public static Set<zzbzl<zzbvm>> zzi(zzcmy zzcmyVar, Executor executor) {
        return zzc(zzcmyVar, executor);
    }

    private static <T> Set<zzbzl<T>> zzc(T t, Executor executor) {
        if (zzadm.zzdfe.get().booleanValue()) {
            return Collections.singleton(new zzbzl(t, executor));
        }
        return Collections.emptySet();
    }
}
