package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcgo implements zzdxw {
    static final zzdxw zzebv = new zzcgo();

    private zzcgo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcgq zzcgqVar : (List) obj) {
            if (zzcgqVar != null) {
                arrayList.add(zzcgqVar);
            }
        }
        return arrayList;
    }
}
