package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcge implements zzdxw {
    static final zzdxw zzebv = new zzcge();

    private zzcge() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzaee zzaeeVar : (List) obj) {
            if (zzaeeVar != null) {
                arrayList.add(zzaeeVar);
            }
        }
        return arrayList;
    }
}
