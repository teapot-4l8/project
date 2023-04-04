package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzenz extends zzenx {
    private static final Class<?> zzivh = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzenz() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzeqg.zzp(obj, j);
        if (list instanceof zzenu) {
            unmodifiableList = ((zzenu) list).zzbkm();
        } else if (zzivh.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzeoz) && (list instanceof zzenk)) {
                zzenk zzenkVar = (zzenk) list;
                if (zzenkVar.zzbhd()) {
                    zzenkVar.zzbhe();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzeqg.zza(obj, j, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzenv zzenvVar;
        List<L> arrayList;
        List<L> zzd = zzd(obj, j);
        if (zzd.isEmpty()) {
            if (zzd instanceof zzenu) {
                arrayList = new zzenv(i);
            } else if ((zzd instanceof zzeoz) && (zzd instanceof zzenk)) {
                arrayList = ((zzenk) zzd).zzgg(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzeqg.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zzivh.isAssignableFrom(zzd.getClass())) {
            ArrayList arrayList2 = new ArrayList(zzd.size() + i);
            arrayList2.addAll(zzd);
            zzeqg.zza(obj, j, arrayList2);
            zzenvVar = arrayList2;
        } else if (zzd instanceof zzeqf) {
            zzenv zzenvVar2 = new zzenv(zzd.size() + i);
            zzenvVar2.addAll((zzeqf) zzd);
            zzeqg.zza(obj, j, zzenvVar2);
            zzenvVar = zzenvVar2;
        } else if ((zzd instanceof zzeoz) && (zzd instanceof zzenk)) {
            zzenk zzenkVar = (zzenk) zzd;
            if (zzenkVar.zzbhd()) {
                return zzd;
            }
            zzenk zzgg = zzenkVar.zzgg(zzd.size() + i);
            zzeqg.zza(obj, j, zzgg);
            return zzgg;
        } else {
            return zzd;
        }
        return zzenvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzenx
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzeqg.zza(obj, j, zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzeqg.zzp(obj, j);
    }
}
