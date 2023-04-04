package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqm implements zzazy, zzbsz {
    private final Context context;
    private final zzbac zzedz;
    private final HashSet<zzazr> zzhpl = new HashSet<>();

    public zzdqm(Context context, zzbac zzbacVar) {
        this.context = context;
        this.zzedz = zzbacVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final synchronized void zzd(zzvh zzvhVar) {
        if (zzvhVar.errorCode != 3) {
            this.zzedz.zzb(this.zzhpl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazy
    public final synchronized void zza(HashSet<zzazr> hashSet) {
        this.zzhpl.clear();
        this.zzhpl.addAll(hashSet);
    }

    public final Bundle zzawm() {
        return this.zzedz.zza(this.context, this);
    }
}
