package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcw implements zzesa<zzdcu> {
    private final zzesn<Set<String>> zzhdt;

    private zzdcw(zzesn<Set<String>> zzesnVar) {
        this.zzhdt = zzesnVar;
    }

    public static zzdcw zzal(zzesn<Set<String>> zzesnVar) {
        return new zzdcw(zzesnVar);
    }

    public static zzdcu zzd(Set<String> set) {
        return new zzdcu(set);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzd(this.zzhdt.get());
    }
}
