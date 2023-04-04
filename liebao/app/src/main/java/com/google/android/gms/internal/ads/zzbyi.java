package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyi implements zzesa<Set<zzbzl<AppEventListener>>> {
    private final zzbxr zzgdc;

    private zzbyi(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyi zzw(zzbxr zzbxrVar) {
        return new zzbyi(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamx());
    }
}
