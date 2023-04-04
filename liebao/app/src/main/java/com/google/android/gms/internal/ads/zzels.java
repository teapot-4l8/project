package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzels implements Comparator<zzelq> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzelq zzelqVar, zzelq zzelqVar2) {
        int zzb;
        int zzb2;
        zzelq zzelqVar3 = zzelqVar;
        zzelq zzelqVar4 = zzelqVar2;
        zzelv zzelvVar = (zzelv) zzelqVar3.iterator();
        zzelv zzelvVar2 = (zzelv) zzelqVar4.iterator();
        while (zzelvVar.hasNext() && zzelvVar2.hasNext()) {
            zzb = zzelq.zzb(zzelvVar.nextByte());
            zzb2 = zzelq.zzb(zzelvVar2.nextByte());
            int compare = C$r8$backportedMethods$utility$Integer$2$compare.compare(zzb, zzb2);
            if (compare != 0) {
                return compare;
            }
        }
        return C$r8$backportedMethods$utility$Integer$2$compare.compare(zzelqVar3.size(), zzelqVar4.size());
    }
}
