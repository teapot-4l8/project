package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class zzacy<T> {
    private final String zzcm;
    private final T zzcmg;
    private final int zzddk;

    public static zzacy<Boolean> zzg(String str, boolean z) {
        return new zzacy<>(str, Boolean.valueOf(z), zzada.zzddl);
    }

    public static zzacy<Long> zzb(String str, long j) {
        return new zzacy<>(str, Long.valueOf(j), zzada.zzddm);
    }

    public static zzacy<Double> zzb(String str, double d2) {
        return new zzacy<>(str, Double.valueOf(d2), zzada.zzddn);
    }

    public static zzacy<String> zzh(String str, String str2) {
        return new zzacy<>(str, str2, zzada.zzddo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public zzacy(String str, Object obj, int i) {
        this.zzcm = str;
        this.zzcmg = obj;
        this.zzddk = i;
    }

    public T get() {
        zzady zzti = zzaeb.zzti();
        if (zzti == null) {
            throw new IllegalStateException("Flag is not initialized.");
        }
        int i = zzadb.zzddq[this.zzddk - 1];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return (T) zzti.get(this.zzcm, (String) this.zzcmg);
                    }
                    throw new IllegalStateException();
                }
                return (T) zzti.zza(this.zzcm, ((Double) this.zzcmg).doubleValue());
            }
            return (T) zzti.getLong(this.zzcm, ((Long) this.zzcmg).longValue());
        }
        return (T) zzti.zzf(this.zzcm, ((Boolean) this.zzcmg).booleanValue());
    }
}
