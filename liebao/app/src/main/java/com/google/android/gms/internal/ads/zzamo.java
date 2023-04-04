package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzamo {
    private static final com.google.android.gms.ads.internal.util.zzar<zzakv> zzdmc = new zzamr();
    private static final com.google.android.gms.ads.internal.util.zzar<zzakv> zzdmd = new zzamq();
    private final zzale zzdme;

    public zzamo(Context context, zzbar zzbarVar, String str) {
        this.zzdme = new zzale(context, zzbarVar, str, zzdmc, zzdmd);
    }

    public final <I, O> zzamg<I, O> zza(String str, zzaml<I> zzamlVar, zzami<O> zzamiVar) {
        return new zzamt(this.zzdme, str, zzamlVar, zzamiVar);
    }

    public final zzamx zzvb() {
        return new zzamx(this.zzdme);
    }
}
