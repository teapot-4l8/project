package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcch implements zzesa<Set<String>> {
    private final zzesn<zzcdy> zzfxe;

    public zzcch(zzesn<zzcdy> zzesnVar) {
        this.zzfxe = zzesnVar;
    }

    public static Set<String> zza(zzcdy zzcdyVar) {
        Set emptySet;
        if (zzcdyVar.zzapg() != null) {
            emptySet = Collections.singleton("banner");
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(emptySet);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfxe.get());
    }
}
