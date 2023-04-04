package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepm extends zzepn<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepm(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzepn
    public final void zzbhe() {
        if (!isImmutable()) {
            for (int i = 0; i < zzblp(); i++) {
                Map.Entry<FieldDescriptorType, Object> zzic = zzic(i);
                if (((zzemv) zzic.getKey()).zzbje()) {
                    zzic.setValue(Collections.unmodifiableList((List) zzic.getValue()));
                }
            }
            Iterator it = zzblq().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((zzemv) entry.getKey()).zzbje()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbhe();
    }
}
