package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeny extends zzenx {
    private zzeny() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final <L> List<L> zza(Object obj, long j) {
        zzenk zzc = zzc(obj, j);
        if (zzc.zzbhd()) {
            return zzc;
        }
        int size = zzc.size();
        zzenk zzgg = zzc.zzgg(size == 0 ? 10 : size << 1);
        zzeqg.zza(obj, j, zzgg);
        return zzgg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzbhe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.ads.zzenk] */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzenk<E> zzc = zzc(obj, j);
        zzenk<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzenk<E> zzenkVar = zzc;
        zzenkVar = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzbhd = zzc.zzbhd();
            zzenk<E> zzenkVar2 = zzc;
            if (!zzbhd) {
                zzenkVar2 = zzc.zzgg(size2 + size);
            }
            zzenkVar2.addAll(zzc2);
            zzenkVar = zzenkVar2;
        }
        if (size > 0) {
            zzc2 = zzenkVar;
        }
        zzeqg.zza(obj, j, zzc2);
    }

    private static <E> zzenk<E> zzc(Object obj, long j) {
        return (zzenk) zzeqg.zzp(obj, j);
    }
}
