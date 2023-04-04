package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdby implements zzesa<Set<String>> {
    private final zzdbs zzhcw;

    public zzdby(zzdbs zzdbsVar) {
        this.zzhcw = zzdbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzhcw.zzatr());
    }
}
