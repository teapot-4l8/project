package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzrz {
    private final int zzbup;
    private final zzrw zzbur = new zzsd();
    private final int zzbuo = 6;
    private final int zzbuq = 0;

    public zzrz(int i) {
        this.zzbup = i;
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            String str = arrayList2.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzbq(sb.toString());
    }

    private final String zzbq(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzsb zzsbVar = new zzsb();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbup, new zzry(this));
        for (String str2 : split) {
            String[] zze = zzsa.zze(str2, false);
            if (zze.length != 0) {
                zzsf.zza(zze, this.zzbup, this.zzbuo, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzsbVar.write(this.zzbur.zzbp(((zzse) it.next()).zzbuv));
            } catch (IOException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error while writing hash to byteStream", e2);
            }
        }
        return zzsbVar.toString();
    }
}
