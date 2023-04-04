package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdcu implements zzdhe<zzdhb<Bundle>> {
    private final Set<String> zzhdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdcu(Set<String> set) {
        this.zzhdr = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzhdr) {
            arrayList.add(str);
        }
        return zzebh.zzag(new zzdhb(arrayList) { // from class: com.google.android.gms.internal.ads.zzdct
            private final ArrayList zzhdq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdq = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.zzhdq);
            }
        });
    }
}
