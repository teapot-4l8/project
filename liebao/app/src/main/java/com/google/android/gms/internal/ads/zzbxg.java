package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxg implements zzesa<zzbxe> {
    private final zzesn<Set<zzbzl<AppEventListener>>> zzfxl;

    private zzbxg(zzesn<Set<zzbzl<AppEventListener>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbxg zzr(zzesn<Set<zzbzl<AppEventListener>>> zzesnVar) {
        return new zzbxg(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbxe(this.zzfxl.get());
    }
}
