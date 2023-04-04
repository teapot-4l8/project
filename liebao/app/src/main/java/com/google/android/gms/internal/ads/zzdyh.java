package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdyh {
    private final int limit;
    private final zzdxr zzhzb;
    private final boolean zzhzc;
    private final zzdyo zzhzd;

    private zzdyh(zzdyo zzdyoVar) {
        this(zzdyoVar, false, zzdxv.zzhyv, Integer.MAX_VALUE);
    }

    private zzdyh(zzdyo zzdyoVar, boolean z, zzdxr zzdxrVar, int i) {
        this.zzhzd = zzdyoVar;
        this.zzhzc = false;
        this.zzhzb = zzdxrVar;
        this.limit = Integer.MAX_VALUE;
    }

    public static zzdyh zza(zzdxr zzdxrVar) {
        zzdyi.checkNotNull(zzdxrVar);
        return new zzdyh(new zzdyk(zzdxrVar));
    }

    public final Iterable<String> zza(CharSequence charSequence) {
        zzdyi.checkNotNull(charSequence);
        return new zzdym(this, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator<String> zzb(CharSequence charSequence) {
        return this.zzhzd.zzb(this, charSequence);
    }

    public final List<String> zzc(CharSequence charSequence) {
        zzdyi.checkNotNull(charSequence);
        Iterator<String> zzb = zzb(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzb.hasNext()) {
            arrayList.add(zzb.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
