package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzid {
    public static final zzid zzaiq = new zzic();

    public abstract zzie zza(int i, zzie zzieVar, boolean z, long j);

    public abstract zzif zza(int i, zzif zzifVar, boolean z);

    public abstract int zzc(Object obj);

    public abstract int zzfj();

    public abstract int zzfk();

    public final boolean isEmpty() {
        return zzfj() == 0;
    }

    public final zzie zza(int i, zzie zzieVar, boolean z) {
        return zza(i, zzieVar, false, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if ((zzfj() - 1) == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(int i, zzif zzifVar, zzie zzieVar, int i2) {
        zza(i, zzifVar, false);
        zza(0, zzieVar, false);
        int i3 = 1;
        if (i == 0) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                }
                i3 = 0;
            } else if (zzfj() - 1 == 0) {
                i3 = -1;
            }
            if (i3 == -1) {
                return -1;
            }
            zza(i3, zzieVar, false);
            return 0;
        }
        return i + 1;
    }
}
