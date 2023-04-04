package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzemb {
    int zzipo;
    int zzipp;
    int zzipq;
    zzemi zzipr;
    private boolean zzips;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemb zzb(byte[] bArr, int i, int i2, boolean z) {
        zzemd zzemdVar = new zzemd(bArr, i, i2, z);
        try {
            zzemdVar.zzgn(i2);
            return zzemdVar;
        } catch (zzenn e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static long zzfh(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzgp(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int zzbhr();

    public abstract long zzbhs();

    public abstract long zzbht();

    public abstract int zzbhu();

    public abstract long zzbhv();

    public abstract int zzbhw();

    public abstract boolean zzbhx();

    public abstract String zzbhy();

    public abstract zzelq zzbhz();

    public abstract int zzbia();

    public abstract int zzbib();

    public abstract int zzbic();

    public abstract long zzbid();

    public abstract int zzbie();

    public abstract long zzbif();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long zzbig();

    public abstract boolean zzbih();

    public abstract int zzbii();

    public abstract void zzgl(int i);

    public abstract boolean zzgm(int i);

    public abstract int zzgn(int i);

    public abstract void zzgo(int i);

    private zzemb() {
        this.zzipp = 100;
        this.zzipq = Integer.MAX_VALUE;
        this.zzips = false;
    }
}
