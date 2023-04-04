package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzag<T> {
    public final T result;
    public final zzn zzbq;
    public final zzap zzbr;
    public boolean zzbs;

    public static <T> zzag<T> zza(T t, zzn zznVar) {
        return new zzag<>(t, zznVar);
    }

    public static <T> zzag<T> zzc(zzap zzapVar) {
        return new zzag<>(zzapVar);
    }

    public final boolean isSuccess() {
        return this.zzbr == null;
    }

    private zzag(T t, zzn zznVar) {
        this.zzbs = false;
        this.result = t;
        this.zzbq = zznVar;
        this.zzbr = null;
    }

    private zzag(zzap zzapVar) {
        this.zzbs = false;
        this.result = null;
        this.zzbq = null;
        this.zzbr = zzapVar;
    }
}
