package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzesd<T> implements zzeru<T>, zzesa<T> {
    private static final zzesd<Object> zzjfe = new zzesd<>(null);
    private final T zzeix;

    public static <T> zzesa<T> zzbb(T t) {
        return new zzesd(zzesg.zza(t, "instance cannot be null"));
    }

    public static <T> zzesa<T> zzbc(T t) {
        if (t == null) {
            return zzjfe;
        }
        return new zzesd(t);
    }

    private zzesd(T t) {
        this.zzeix = t;
    }

    @Override // com.google.android.gms.internal.ads.zzeru, com.google.android.gms.internal.ads.zzesn
    public final T get() {
        return this.zzeix;
    }
}
