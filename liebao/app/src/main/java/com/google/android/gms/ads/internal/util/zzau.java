package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzau {
    private final String[] zzeht;
    private final double[] zzehu;
    private final double[] zzehv;
    private final int[] zzehw;
    private int zzehx;

    private zzau(zzav zzavVar) {
        List list;
        List list2;
        List list3;
        List list4;
        list = zzavVar.zzehz;
        int size = list.size();
        list2 = zzavVar.zzehy;
        this.zzeht = (String[]) list2.toArray(new String[size]);
        list3 = zzavVar.zzehz;
        this.zzehu = zzg(list3);
        list4 = zzavVar.zzeia;
        this.zzehv = zzg(list4);
        this.zzehw = new int[size];
        this.zzehx = 0;
    }

    private static double[] zzg(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d2) {
        this.zzehx++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzehv;
            if (i >= dArr.length) {
                return;
            }
            if (dArr[i] <= d2 && d2 < this.zzehu[i]) {
                int[] iArr = this.zzehw;
                iArr[i] = iArr[i] + 1;
            }
            if (d2 < this.zzehv[i]) {
                return;
            }
            i++;
        }
    }

    public final List<zzaw> zzaag() {
        ArrayList arrayList = new ArrayList(this.zzeht.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeht;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d2 = this.zzehv[i];
            double d3 = this.zzehu[i];
            int[] iArr = this.zzehw;
            double d4 = iArr[i];
            double d5 = this.zzehx;
            Double.isNaN(d4);
            Double.isNaN(d5);
            arrayList.add(new zzaw(str, d2, d3, d4 / d5, iArr[i]));
            i++;
        }
    }
}
