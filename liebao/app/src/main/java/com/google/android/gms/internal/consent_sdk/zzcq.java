package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzcq<T> implements zzct<T> {
    private static final Object zza = new Object();
    private volatile zzct<T> zzb;
    private volatile Object zzc = zza;

    private zzcq(zzct<T> zzctVar) {
        this.zzb = zzctVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final T zza() {
        T t = (T) this.zzc;
        if (t == zza) {
            synchronized (this) {
                t = this.zzc;
                if (t == zza) {
                    t = this.zzb.zza();
                    Object obj = this.zzc;
                    if (((obj == zza || (obj instanceof zzcr)) ? false : true) && obj != t) {
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
                    this.zzc = t;
                    this.zzb = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzct<T>, T> zzct<T> zza(P p) {
        zzcu.zza(p);
        return p instanceof zzcq ? p : new zzcq(p);
    }
}
