package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeat<V> extends zzeau<V, List<V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeat(zzdyv<? extends zzebt<? extends V>> zzdyvVar, boolean z) {
        super(zzdyvVar, true);
        zzbav();
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final /* synthetic */ Object zzl(List list) {
        ArrayList zzfb = zzdzi.zzfb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzeaw zzeawVar = (zzeaw) it.next();
            zzfb.add(zzeawVar != null ? zzeawVar.value : null);
        }
        return Collections.unmodifiableList(zzfb);
    }
}
