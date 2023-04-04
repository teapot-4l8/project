package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzeqa<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(B b2, int i, zzelq zzelqVar);

    abstract void zza(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(T t, zzeqx zzeqxVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zza(zzepc zzepcVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzak(Object obj);

    abstract T zzaq(B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzau(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzay(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzaz(Object obj);

    abstract void zzb(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzba(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B zzblx();

    abstract void zzc(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(T t, zzeqx zzeqxVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzj(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T zzk(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(B b2, zzepc zzepcVar) {
        int tag = zzepcVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza((zzeqa<T, B>) b2, i, zzepcVar.zzbht());
            return true;
        } else if (i2 == 1) {
            zzb(b2, i, zzepcVar.zzbhv());
            return true;
        } else if (i2 == 2) {
            zza((zzeqa<T, B>) b2, i, zzepcVar.zzbhz());
            return true;
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 5) {
                    zzc(b2, i, zzepcVar.zzbhw());
                    return true;
                }
                throw zzenn.zzbke();
            }
            return false;
        } else {
            B zzblx = zzblx();
            int i3 = 4 | (i << 3);
            while (zzepcVar.zzbip() != Integer.MAX_VALUE && zza((zzeqa<T, B>) zzblx, zzepcVar)) {
            }
            if (i3 != zzepcVar.getTag()) {
                throw zzenn.zzbkd();
            }
            zza((zzeqa<T, B>) b2, i, (int) zzaq(zzblx));
            return true;
        }
    }
}
