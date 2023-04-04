package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
abstract class zzkt<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zza();

    abstract T zza(B b2);

    abstract void zza(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzgp zzgpVar);

    abstract void zza(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zzlm zzlmVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzjy zzjyVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzb(Object obj);

    abstract void zzb(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(T t, zzlm zzlmVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzc(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzc(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zze(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzf(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b2, zzjy zzjyVar) {
        int zzb = zzjyVar.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            zza((zzkt<T, B>) b2, i, zzjyVar.zzg());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzjyVar.zzi());
            return true;
        } else if (i2 == 2) {
            zza((zzkt<T, B>) b2, i, zzjyVar.zzn());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zza((zzkt<T, B>) b2, i, zzjyVar.zzj());
                    return true;
                }
                throw zzij.zzf();
            }
            return false;
        } else {
            B zza = zza();
            int i3 = 4 | (i << 3);
            while (zzjyVar.zza() != Integer.MAX_VALUE && zza((zzkt<T, B>) zza, zzjyVar)) {
            }
            if (i3 != zzjyVar.zzb()) {
                throw zzij.zze();
            }
            zza((zzkt<T, B>) b2, i, (int) zza((zzkt<T, B>) zza));
            return true;
        }
    }
}
