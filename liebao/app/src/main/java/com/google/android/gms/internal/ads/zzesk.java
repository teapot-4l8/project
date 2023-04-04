package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzesk<T> implements zzesn<T> {
    private static final Object zzjfb = new Object();
    private volatile Object zzeix = zzjfb;
    private volatile zzesn<T> zzjfc;

    private zzesk(zzesn<T> zzesnVar) {
        this.zzjfc = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final T get() {
        T t = (T) this.zzeix;
        if (t == zzjfb) {
            zzesn<T> zzesnVar = this.zzjfc;
            if (zzesnVar == null) {
                return (T) this.zzeix;
            }
            T t2 = zzesnVar.get();
            this.zzeix = t2;
            this.zzjfc = null;
            return t2;
        }
        return t;
    }

    public static <P extends zzesn<T>, T> zzesn<T> zzas(P p) {
        return ((p instanceof zzesk) || (p instanceof zzesb)) ? p : new zzesk((zzesn) zzesg.checkNotNull(p));
    }
}
