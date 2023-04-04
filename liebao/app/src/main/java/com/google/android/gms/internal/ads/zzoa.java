package com.google.android.gms.internal.ads;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzoa extends zzob {
    private static final int[] zzbhu = new int[0];
    private final zzof zzbhv;
    private final AtomicReference<zznz> zzbhw;

    public zzoa() {
        this(null);
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private static int zzg(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        } else if (i2 == -1) {
            return 1;
        } else {
            return i - i2;
        }
    }

    private zzoa(zzof zzofVar) {
        this.zzbhv = null;
        this.zzbhw = new AtomicReference<>(new zznz());
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x017f, code lost:
        if (r9.zzahk <= r15) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01af  */
    @Override // com.google.android.gms.internal.ads.zzob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final zzog[] zza(zzib[] zzibVarArr, zznu[] zznuVarArr, int[][][] iArr) {
        int i;
        zznz zznzVar;
        int i2;
        int i3;
        zznu zznuVar;
        int i4;
        zzog[] zzogVarArr;
        zznz zznzVar2;
        int i5;
        zznr zznrVar;
        int i6;
        boolean z;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int[] iArr2;
        zznr zznrVar2;
        int i10;
        int i11;
        boolean z3;
        int i12;
        boolean zze;
        boolean z4;
        int zzg;
        boolean z5;
        int i13;
        int i14;
        boolean z6;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Point point;
        int i20;
        zzib[] zzibVarArr2 = zzibVarArr;
        int length = zzibVarArr2.length;
        zzog[] zzogVarArr2 = new zzog[length];
        zznz zznzVar3 = this.zzbhw.get();
        int i21 = 0;
        boolean z7 = false;
        while (i21 < length) {
            if (2 == zzibVarArr2[i21].getTrackType()) {
                if (z7) {
                    i4 = length;
                    zzogVarArr = zzogVarArr2;
                    zznzVar2 = zznzVar3;
                    i5 = i21;
                } else {
                    zznu zznuVar2 = zznuVarArr[i21];
                    int[][] iArr3 = iArr[i21];
                    int i22 = zznzVar3.zzbho;
                    int i23 = zznzVar3.zzbhp;
                    int i24 = zznzVar3.zzbhq;
                    int i25 = zznzVar3.viewportWidth;
                    int i26 = zznzVar3.viewportHeight;
                    boolean z8 = zznzVar3.zzbht;
                    boolean z9 = zznzVar3.zzbhr;
                    boolean z10 = zznzVar3.zzbhs;
                    i4 = length;
                    zznzVar2 = zznzVar3;
                    zznr zznrVar3 = null;
                    int i27 = 0;
                    int i28 = 0;
                    int i29 = 0;
                    int i30 = -1;
                    int i31 = -1;
                    while (i27 < zznuVar2.length) {
                        zznr zzbf = zznuVar2.zzbf(i27);
                        zznu zznuVar3 = zznuVar2;
                        zzog[] zzogVarArr3 = zzogVarArr2;
                        ArrayList arrayList = new ArrayList(zzbf.length);
                        int i32 = i21;
                        for (int i33 = 0; i33 < zzbf.length; i33++) {
                            arrayList.add(Integer.valueOf(i33));
                        }
                        int i34 = Integer.MAX_VALUE;
                        if (i25 == Integer.MAX_VALUE || i26 == Integer.MAX_VALUE) {
                            zznrVar = zznrVar3;
                            i6 = i28;
                            z = z8;
                            i7 = i26;
                            i8 = i25;
                            z2 = z9;
                            i9 = i24;
                        } else {
                            i6 = i28;
                            int i35 = 0;
                            while (i35 < zzbf.length) {
                                zzht zzbe = zzbf.zzbe(i35);
                                zznr zznrVar4 = zznrVar3;
                                if (zzbe.width <= 0 || zzbe.height <= 0) {
                                    z5 = z8;
                                    i13 = i26;
                                    i14 = i25;
                                    z6 = z9;
                                    i15 = i24;
                                } else {
                                    int i36 = zzbe.width;
                                    z6 = z9;
                                    int i37 = zzbe.height;
                                    z5 = z8;
                                    if (z8) {
                                        i13 = i26;
                                        if ((i36 > i37) != (i25 > i26)) {
                                            i17 = i25;
                                            i14 = i17;
                                            i16 = i13;
                                            i18 = i36 * i17;
                                            i15 = i24;
                                            i19 = i37 * i16;
                                            if (i18 < i19) {
                                                point = new Point(i16, zzpt.zzh(i19, i36));
                                            } else {
                                                point = new Point(zzpt.zzh(i18, i37), i17);
                                            }
                                            i20 = zzbe.width * zzbe.height;
                                            if (zzbe.width >= ((int) (point.x * 0.98f)) && zzbe.height >= ((int) (point.y * 0.98f)) && i20 < i34) {
                                                i34 = i20;
                                            }
                                        }
                                    } else {
                                        i13 = i26;
                                    }
                                    i16 = i25;
                                    i14 = i16;
                                    i17 = i13;
                                    i18 = i36 * i17;
                                    i15 = i24;
                                    i19 = i37 * i16;
                                    if (i18 < i19) {
                                    }
                                    i20 = zzbe.width * zzbe.height;
                                    if (zzbe.width >= ((int) (point.x * 0.98f))) {
                                        i34 = i20;
                                    }
                                }
                                i35++;
                                zznrVar3 = zznrVar4;
                                z9 = z6;
                                z8 = z5;
                                i26 = i13;
                                i25 = i14;
                                i24 = i15;
                            }
                            zznrVar = zznrVar3;
                            z = z8;
                            i7 = i26;
                            i8 = i25;
                            z2 = z9;
                            i9 = i24;
                            if (i34 != Integer.MAX_VALUE) {
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    int zzfd = zzbf.zzbe(((Integer) arrayList.get(size)).intValue()).zzfd();
                                    if (zzfd == -1 || zzfd > i34) {
                                        arrayList.remove(size);
                                    }
                                }
                            }
                        }
                        int[] iArr4 = iArr3[i27];
                        int i38 = i29;
                        int i39 = i30;
                        int i40 = i31;
                        i28 = i6;
                        int i41 = 0;
                        while (i41 < zzbf.length) {
                            if (zze(iArr4[i41], z10)) {
                                zzht zzbe2 = zzbf.zzbe(i41);
                                if (!arrayList.contains(Integer.valueOf(i41)) || ((zzbe2.width != -1 && zzbe2.width > i22) || (zzbe2.height != -1 && zzbe2.height > i23))) {
                                    i11 = i9;
                                } else {
                                    if (zzbe2.zzahk != -1) {
                                        i11 = i9;
                                    } else {
                                        i11 = i9;
                                    }
                                    z3 = true;
                                    if (!z3 || z2) {
                                        zznrVar2 = zzbf;
                                        i10 = i28;
                                        i12 = !z3 ? 2 : 1;
                                        iArr2 = iArr4;
                                        zze = zze(iArr4[i41], false);
                                        if (zze) {
                                            i12 += 1000;
                                        }
                                        z4 = i12 <= i38;
                                        if (i12 == i38) {
                                            if (zzbe2.zzfd() != i39) {
                                                zzg = zzg(zzbe2.zzfd(), i39);
                                            } else {
                                                zzg = zzg(zzbe2.zzahk, i40);
                                            }
                                            z4 = !(zze && z3) ? zzg >= 0 : zzg <= 0;
                                        }
                                        if (z4) {
                                            i40 = zzbe2.zzahk;
                                            i38 = i12;
                                            i39 = zzbe2.zzfd();
                                            zznrVar = zznrVar2;
                                            i28 = i41;
                                            i41++;
                                            i9 = i11;
                                            zzbf = zznrVar2;
                                            iArr4 = iArr2;
                                        }
                                    } else {
                                        iArr2 = iArr4;
                                        zznrVar2 = zzbf;
                                        i10 = i28;
                                    }
                                }
                                z3 = false;
                                if (z3) {
                                }
                                zznrVar2 = zzbf;
                                i10 = i28;
                                if (!z3) {
                                }
                                iArr2 = iArr4;
                                zze = zze(iArr4[i41], false);
                                if (zze) {
                                }
                                if (i12 <= i38) {
                                }
                                if (i12 == i38) {
                                }
                                if (z4) {
                                }
                            } else {
                                iArr2 = iArr4;
                                zznrVar2 = zzbf;
                                i10 = i28;
                                i11 = i9;
                            }
                            i28 = i10;
                            i41++;
                            i9 = i11;
                            zzbf = zznrVar2;
                            iArr4 = iArr2;
                        }
                        i24 = i9;
                        i27++;
                        i29 = i38;
                        i31 = i40;
                        zznuVar2 = zznuVar3;
                        zzogVarArr2 = zzogVarArr3;
                        zznrVar3 = zznrVar;
                        z9 = z2;
                        z8 = z;
                        i26 = i7;
                        i25 = i8;
                        i30 = i39;
                        i21 = i32;
                    }
                    zznr zznrVar5 = zznrVar3;
                    zzogVarArr = zzogVarArr2;
                    i5 = i21;
                    zzogVarArr[i5] = zznrVar5 == null ? null : new zzoc(zznrVar5, i28);
                    z7 = zzogVarArr[i5] != null;
                }
                int i42 = zznuVarArr[i5].length;
            } else {
                i4 = length;
                zzogVarArr = zzogVarArr2;
                zznzVar2 = zznzVar3;
                i5 = i21;
            }
            i21 = i5 + 1;
            zzibVarArr2 = zzibVarArr;
            zznzVar3 = zznzVar2;
            length = i4;
            zzogVarArr2 = zzogVarArr;
        }
        zzog[] zzogVarArr4 = zzogVarArr2;
        zznz zznzVar4 = zznzVar3;
        int i43 = length;
        int i44 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i44 < i43) {
            int trackType = zzibVarArr[i44].getTrackType();
            if (trackType == 1) {
                i = i43;
                zznzVar = zznzVar4;
                if (!z11) {
                    zznu zznuVar4 = zznuVarArr[i44];
                    int[][] iArr5 = iArr[i44];
                    boolean z13 = zznzVar.zzbhs;
                    int i45 = 0;
                    int i46 = 0;
                    int i47 = -1;
                    int i48 = -1;
                    while (i45 < zznuVar4.length) {
                        zznr zzbf2 = zznuVar4.zzbf(i45);
                        int[] iArr6 = iArr5[i45];
                        int i49 = i48;
                        int i50 = i47;
                        int i51 = i46;
                        for (int i52 = 0; i52 < zzbf2.length; i52++) {
                            if (zze(iArr6[i52], z13)) {
                                zzht zzbe3 = zzbf2.zzbe(i52);
                                int i53 = iArr6[i52];
                                int i54 = (zzbe3.zzaie & 1) != 0 ? 2 : 1;
                                if (zze(i53, false)) {
                                    i54 += 1000;
                                }
                                if (i54 > i51) {
                                    i50 = i45;
                                    i49 = i52;
                                    i51 = i54;
                                }
                            }
                        }
                        i45++;
                        i46 = i51;
                        i47 = i50;
                        i48 = i49;
                    }
                    zzogVarArr4[i44] = i47 == -1 ? null : new zzoc(zznuVar4.zzbf(i47), i48);
                    z11 = zzogVarArr4[i44] != null;
                }
            } else if (trackType == 2) {
                i = i43;
                zznzVar = zznzVar4;
            } else if (trackType != 3) {
                zzibVarArr[i44].getTrackType();
                zznu zznuVar5 = zznuVarArr[i44];
                int[][] iArr7 = iArr[i44];
                zznzVar = zznzVar4;
                boolean z14 = zznzVar.zzbhs;
                int i55 = 0;
                int i56 = 0;
                zznr zznrVar6 = null;
                for (int i57 = 0; i57 < zznuVar5.length; i57++) {
                    zznr zzbf3 = zznuVar5.zzbf(i57);
                    int[] iArr8 = iArr7[i57];
                    int i58 = 0;
                    while (i58 < zzbf3.length) {
                        if (zze(iArr8[i58], z14)) {
                            i3 = i43;
                            int i59 = (zzbf3.zzbe(i58).zzaie & 1) != 0 ? 2 : 1;
                            zznuVar = zznuVar5;
                            if (zze(iArr8[i58], false)) {
                                i59 += 1000;
                            }
                            if (i59 > i56) {
                                zznrVar6 = zzbf3;
                                i55 = i58;
                                i56 = i59;
                            }
                        } else {
                            i3 = i43;
                            zznuVar = zznuVar5;
                        }
                        i58++;
                        zznuVar5 = zznuVar;
                        i43 = i3;
                    }
                }
                i = i43;
                zzogVarArr4[i44] = zznrVar6 == null ? null : new zzoc(zznrVar6, i55);
            } else {
                i = i43;
                zznzVar = zznzVar4;
                if (!z12) {
                    zznu zznuVar6 = zznuVarArr[i44];
                    int[][] iArr9 = iArr[i44];
                    boolean z15 = zznzVar.zzbhs;
                    int i60 = 0;
                    int i61 = 0;
                    int i62 = 0;
                    zznr zznrVar7 = null;
                    while (i60 < zznuVar6.length) {
                        zznr zzbf4 = zznuVar6.zzbf(i60);
                        int[] iArr10 = iArr9[i60];
                        zznr zznrVar8 = zznrVar7;
                        int i63 = i62;
                        int i64 = i61;
                        for (int i65 = 0; i65 < zzbf4.length; i65++) {
                            if (zze(iArr10[i65], z15)) {
                                zzht zzbe4 = zzbf4.zzbe(i65);
                                boolean z16 = (zzbe4.zzaie & 1) != 0;
                                boolean z17 = (zzbe4.zzaie & 2) != 0;
                                if (z16) {
                                    i2 = 3;
                                } else if (z17) {
                                    i2 = 1;
                                }
                                if (zze(iArr10[i65], false)) {
                                    i2 += 1000;
                                }
                                if (i2 > i63) {
                                    i64 = i65;
                                    zznrVar8 = zzbf4;
                                    i63 = i2;
                                }
                            }
                        }
                        i60++;
                        i61 = i64;
                        i62 = i63;
                        zznrVar7 = zznrVar8;
                    }
                    zzogVarArr4[i44] = zznrVar7 == null ? null : new zzoc(zznrVar7, i61);
                    z12 = zzogVarArr4[i44] != null;
                }
            }
            i44++;
            zznzVar4 = zznzVar;
            i43 = i;
        }
        return zzogVarArr4;
    }
}
