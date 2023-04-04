package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzesb<T> implements zzeru<T>, zzesn<T> {
    private static final Object zzjfb = new Object();
    private volatile Object zzeix = zzjfb;
    private volatile zzesn<T> zzjfc;

    private zzesb(zzesn<T> zzesnVar) {
        this.zzjfc = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeru, com.google.android.gms.internal.ads.zzesn
    public final T get() {
        T t = (T) this.zzeix;
        if (t == zzjfb) {
            synchronized (this) {
                t = this.zzeix;
                if (t == zzjfb) {
                    t = this.zzjfc.get();
                    Object obj = this.zzeix;
                    if (((obj == zzjfb || (obj instanceof zzesh)) ? false : true) && obj != t) {
                        String valueOf = String.valueOf(obj);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.zzeix = t;
                    this.zzjfc = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzesn<T>, T> zzesn<T> zzas(P p) {
        zzesg.checkNotNull(p);
        return p instanceof zzesb ? p : new zzesb(p);
    }

    public static <P extends zzesn<T>, T> zzeru<T> zzat(P p) {
        if (p instanceof zzeru) {
            return (zzeru) p;
        }
        return new zzesb((zzesn) zzesg.checkNotNull(p));
    }
}
