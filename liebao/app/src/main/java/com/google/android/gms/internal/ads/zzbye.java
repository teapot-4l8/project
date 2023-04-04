package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbye implements zzesa<Set<zzbzl<AdMetadataListener>>> {
    private final zzbxr zzgdc;

    private zzbye(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbye zzr(zzbxr zzbxrVar) {
        return new zzbye(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamw());
    }
}
