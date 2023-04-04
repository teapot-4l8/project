package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeph {
    private final ArrayDeque<zzelq> zzixf;

    private zzeph() {
        this.zzixf = new ArrayDeque<>();
    }

    public final zzelq zzc(zzelq zzelqVar, zzelq zzelqVar2) {
        zzam(zzelqVar);
        zzam(zzelqVar2);
        zzelq pop = this.zzixf.pop();
        while (!this.zzixf.isEmpty()) {
            pop = new zzepf(this.zzixf.pop(), pop, null);
        }
        return pop;
    }

    private final void zzam(zzelq zzelqVar) {
        zzelq zzelqVar2;
        while (!zzelqVar.zzbhm()) {
            if (zzelqVar instanceof zzepf) {
                zzepf zzepfVar = (zzepf) zzelqVar;
                zzelqVar2 = zzepfVar.zziwz;
                zzam(zzelqVar2);
                zzelqVar = zzepfVar.zzixa;
            } else {
                String valueOf = String.valueOf(zzelqVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzia = zzia(zzelqVar.size());
        int zzhz = zzepf.zzhz(zzia + 1);
        if (this.zzixf.isEmpty() || this.zzixf.peek().size() >= zzhz) {
            this.zzixf.push(zzelqVar);
            return;
        }
        int zzhz2 = zzepf.zzhz(zzia);
        zzelq pop = this.zzixf.pop();
        while (!this.zzixf.isEmpty() && this.zzixf.peek().size() < zzhz2) {
            pop = new zzepf(this.zzixf.pop(), pop, null);
        }
        zzepf zzepfVar2 = new zzepf(pop, zzelqVar, null);
        while (!this.zzixf.isEmpty()) {
            if (this.zzixf.peek().size() >= zzepf.zzhz(zzia(zzepfVar2.size()) + 1)) {
                break;
            }
            zzepfVar2 = new zzepf(this.zzixf.pop(), zzepfVar2, null);
        }
        this.zzixf.push(zzepfVar2);
    }

    private static int zzia(int i) {
        int binarySearch = Arrays.binarySearch(zzepf.zziwx, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzeph(zzepe zzepeVar) {
        this();
    }

    public static /* synthetic */ zzelq zza(zzeph zzephVar, zzelq zzelqVar, zzelq zzelqVar2) {
        return zzephVar.zzc(zzelqVar, zzelqVar2);
    }
}
