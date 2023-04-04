package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzry implements Comparator<zzse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzry(zzrz zzrzVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzse zzseVar, zzse zzseVar2) {
        zzse zzseVar3 = zzseVar;
        zzse zzseVar4 = zzseVar2;
        int i = zzseVar3.zzbuo - zzseVar4.zzbuo;
        return i != 0 ? i : (int) (zzseVar3.value - zzseVar4.value);
    }
}
