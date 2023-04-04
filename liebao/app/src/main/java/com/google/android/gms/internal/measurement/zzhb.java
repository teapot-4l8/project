package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public abstract class zzhb {
    int zza;
    int zzb;
    zzhg zzc;
    private int zzd;
    private boolean zze;

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhb zza(byte[] bArr, int i, int i2, boolean z) {
        zzhd zzhdVar = new zzhd(bArr, i2);
        try {
            zzhdVar.zzc(i2);
            return zzhdVar;
        } catch (zzij e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zza();

    public abstract void zza(int i);

    public abstract double zzb();

    public abstract boolean zzb(int i);

    public abstract float zzc();

    public abstract int zzc(int i);

    public abstract long zzd();

    public abstract void zzd(int i);

    public abstract long zze();

    public abstract int zzf();

    public abstract long zzg();

    public abstract int zzh();

    public abstract boolean zzi();

    public abstract String zzj();

    public abstract String zzk();

    public abstract zzgp zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract int zzo();

    public abstract long zzp();

    public abstract int zzq();

    public abstract long zzr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzs();

    public abstract boolean zzt();

    public abstract int zzu();

    private zzhb() {
        this.zzb = 100;
        this.zzd = Integer.MAX_VALUE;
        this.zze = false;
    }
}
