package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzob extends zzoh {
    private zzoe zzbhz;
    private final SparseArray<Map<zznu, zzod>> zzbhx = new SparseArray<>();
    private final SparseBooleanArray zzbhy = new SparseBooleanArray();
    private int zzaip = 0;

    protected abstract zzog[] zza(zzib[] zzibVarArr, zznu[] zznuVarArr, int[][][] iArr);

    public final void zzf(int i, boolean z) {
        if (this.zzbhy.get(i) == z) {
            return;
        }
        this.zzbhy.put(i, z);
        invalidate();
    }

    @Override // com.google.android.gms.internal.ads.zzoh
    public final zzoj zza(zzib[] zzibVarArr, zznu zznuVar) {
        int[] iArr;
        int[] iArr2 = new int[zzibVarArr.length + 1];
        int length = zzibVarArr.length + 1;
        zznr[][] zznrVarArr = new zznr[length];
        int[][][] iArr3 = new int[zzibVarArr.length + 1][];
        for (int i = 0; i < length; i++) {
            zznrVarArr[i] = new zznr[zznuVar.length];
            iArr3[i] = new int[zznuVar.length];
        }
        int length2 = zzibVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            iArr4[i2] = zzibVarArr[i2].zzej();
        }
        for (int i3 = 0; i3 < zznuVar.length; i3++) {
            zznr zzbf = zznuVar.zzbf(i3);
            int length3 = zzibVarArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < zzibVarArr.length; i5++) {
                zzib zzibVar = zzibVarArr[i5];
                for (int i6 = 0; i6 < zzbf.length; i6++) {
                    int zza = zzibVar.zza(zzbf.zzbe(i6)) & 3;
                    if (zza > i4) {
                        length3 = i5;
                        if (zza == 3) {
                            break;
                        }
                        i4 = zza;
                    }
                }
            }
            if (length3 == zzibVarArr.length) {
                iArr = new int[zzbf.length];
            } else {
                zzib zzibVar2 = zzibVarArr[length3];
                int[] iArr5 = new int[zzbf.length];
                for (int i7 = 0; i7 < zzbf.length; i7++) {
                    iArr5[i7] = zzibVar2.zza(zzbf.zzbe(i7));
                }
                iArr = iArr5;
            }
            int i8 = iArr2[length3];
            zznrVarArr[length3][i8] = zzbf;
            iArr3[length3][i8] = iArr;
            iArr2[length3] = iArr2[length3] + 1;
        }
        zznu[] zznuVarArr = new zznu[zzibVarArr.length];
        int[] iArr6 = new int[zzibVarArr.length];
        for (int i9 = 0; i9 < zzibVarArr.length; i9++) {
            int i10 = iArr2[i9];
            zznuVarArr[i9] = new zznu((zznr[]) Arrays.copyOf(zznrVarArr[i9], i10));
            iArr3[i9] = (int[][]) Arrays.copyOf(iArr3[i9], i10);
            iArr6[i9] = zzibVarArr[i9].getTrackType();
        }
        zznu zznuVar2 = new zznu((zznr[]) Arrays.copyOf(zznrVarArr[zzibVarArr.length], iArr2[zzibVarArr.length]));
        zzog[] zza2 = zza(zzibVarArr, zznuVarArr, iArr3);
        int i11 = 0;
        while (true) {
            if (i11 < zzibVarArr.length) {
                if (this.zzbhy.get(i11)) {
                    zza2[i11] = null;
                } else {
                    zznu zznuVar3 = zznuVarArr[i11];
                    Map<zznu, zzod> map = this.zzbhx.get(i11);
                    if ((map != null ? map.get(zznuVar3) : null) != null) {
                        throw new NoSuchMethodError();
                    }
                }
                i11++;
            } else {
                zzoe zzoeVar = new zzoe(iArr6, zznuVarArr, iArr4, iArr3, zznuVar2);
                zzia[] zziaVarArr = new zzia[zzibVarArr.length];
                for (int i12 = 0; i12 < zzibVarArr.length; i12++) {
                    zziaVarArr[i12] = zza2[i12] != null ? zzia.zzaio : null;
                }
                return new zzoj(zznuVar, new zzoi(zza2), zzoeVar, zziaVarArr);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoh
    public final void zzd(Object obj) {
        this.zzbhz = (zzoe) obj;
    }
}
