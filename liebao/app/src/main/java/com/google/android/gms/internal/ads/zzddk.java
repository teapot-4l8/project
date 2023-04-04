package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzddk implements zzdxw {
    static final zzdxw zzebv = new zzddk();

    private zzddk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxw
    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdhb(arrayList) { // from class: com.google.android.gms.internal.ads.zzddj
            private final ArrayList zzhdq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdq = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.zzhdq);
            }
        };
    }
}
