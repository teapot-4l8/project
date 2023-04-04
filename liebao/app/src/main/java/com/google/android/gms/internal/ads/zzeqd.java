package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeqd {
    private static final zzeqd zziyd = new zzeqd(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzior;
    private int zzito;
    private Object[] zzivv;
    private int[] zziye;

    public static zzeqd zzbly() {
        return zziyd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeqd zzblz() {
        return new zzeqd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeqd zza(zzeqd zzeqdVar, zzeqd zzeqdVar2) {
        int i = zzeqdVar.count + zzeqdVar2.count;
        int[] copyOf = Arrays.copyOf(zzeqdVar.zziye, i);
        System.arraycopy(zzeqdVar2.zziye, 0, copyOf, zzeqdVar.count, zzeqdVar2.count);
        Object[] copyOf2 = Arrays.copyOf(zzeqdVar.zzivv, i);
        System.arraycopy(zzeqdVar2.zzivv, 0, copyOf2, zzeqdVar.count, zzeqdVar2.count);
        return new zzeqd(i, copyOf, copyOf2, true);
    }

    private zzeqd() {
        this(0, new int[8], new Object[8], true);
    }

    private zzeqd(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzito = -1;
        this.count = i;
        this.zziye = iArr;
        this.zzivv = objArr;
        this.zzior = z;
    }

    public final void zzbhe() {
        this.zzior = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzeqx zzeqxVar) {
        if (zzeqxVar.zzbiu() == zzeqw.zzjal) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzeqxVar.zzc(this.zziye[i] >>> 3, this.zzivv[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzeqxVar.zzc(this.zziye[i2] >>> 3, this.zzivv[i2]);
        }
    }

    public final void zzb(zzeqx zzeqxVar) {
        if (this.count == 0) {
            return;
        }
        if (zzeqxVar.zzbiu() == zzeqw.zzjak) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zziye[i], this.zzivv[i], zzeqxVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zziye[i2], this.zzivv[i2], zzeqxVar);
        }
    }

    private static void zzb(int i, Object obj, zzeqx zzeqxVar) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzeqxVar.zzq(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzeqxVar.zzk(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzeqxVar.zza(i2, (zzelq) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzeqxVar.zzah(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzenn.zzbke());
        } else if (zzeqxVar.zzbiu() == zzeqw.zzjak) {
            zzeqxVar.zzhm(i2);
            ((zzeqd) obj).zzb(zzeqxVar);
            zzeqxVar.zzhn(i2);
        } else {
            zzeqxVar.zzhn(i2);
            ((zzeqd) obj).zzb(zzeqxVar);
            zzeqxVar.zzhm(i2);
        }
    }

    public final int zzbma() {
        int i = this.zzito;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzemk.zzd(this.zziye[i3] >>> 3, (zzelq) this.zzivv[i3]);
        }
        this.zzito = i2;
        return i2;
    }

    public final int zzbjj() {
        int zzm;
        int i = this.zzito;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zziye[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zzm = zzemk.zzm(i5, ((Long) this.zzivv[i3]).longValue());
            } else if (i6 == 1) {
                zzm = zzemk.zzo(i5, ((Long) this.zzivv[i3]).longValue());
            } else if (i6 == 2) {
                zzm = zzemk.zzc(i5, (zzelq) this.zzivv[i3]);
            } else if (i6 == 3) {
                zzm = (zzemk.zzhd(i5) << 1) + ((zzeqd) this.zzivv[i3]).zzbjj();
            } else if (i6 == 5) {
                zzm = zzemk.zzal(i5, ((Integer) this.zzivv[i3]).intValue());
            } else {
                throw new IllegalStateException(zzenn.zzbke());
            }
            i2 += zzm;
        }
        this.zzito = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzeqd)) {
            zzeqd zzeqdVar = (zzeqd) obj;
            int i = this.count;
            if (i == zzeqdVar.count) {
                int[] iArr = this.zziye;
                int[] iArr2 = zzeqdVar.zziye;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        z = true;
                        break;
                    } else if (iArr[i2] != iArr2[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    Object[] objArr = this.zzivv;
                    Object[] objArr2 = zzeqdVar.zzivv;
                    int i3 = this.count;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i3) {
                            z2 = true;
                            break;
                        } else if (!objArr[i4].equals(objArr2[i4])) {
                            z2 = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zziye;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzivv;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzeoo.zza(sb, i, String.valueOf(this.zziye[i2] >>> 3), this.zzivv[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i, Object obj) {
        if (!this.zzior) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.count;
        if (i2 == this.zziye.length) {
            int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
            this.zziye = Arrays.copyOf(this.zziye, i3);
            this.zzivv = Arrays.copyOf(this.zzivv, i3);
        }
        int[] iArr = this.zziye;
        int i4 = this.count;
        iArr[i4] = i;
        this.zzivv[i4] = obj;
        this.count = i4 + 1;
    }
}
