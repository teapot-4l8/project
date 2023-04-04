package com.google.android.gms.internal.ads;

import androidx.b.g;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcea {
    zzafx zzghj;
    zzafs zzghk;
    zzagl zzghl;
    zzagg zzghm;
    zzakg zzghn;
    final g<String, zzagd> zzgho = new g<>();
    final g<String, zzafy> zzghp = new g<>();

    public final zzcea zzb(zzafx zzafxVar) {
        this.zzghj = zzafxVar;
        return this;
    }

    public final zzcea zzb(zzafs zzafsVar) {
        this.zzghk = zzafsVar;
        return this;
    }

    public final zzcea zzb(zzagl zzaglVar) {
        this.zzghl = zzaglVar;
        return this;
    }

    public final zzcea zza(zzagg zzaggVar) {
        this.zzghm = zzaggVar;
        return this;
    }

    public final zzcea zzb(zzakg zzakgVar) {
        this.zzghn = zzakgVar;
        return this;
    }

    public final zzcea zzb(String str, zzagd zzagdVar, zzafy zzafyVar) {
        this.zzgho.put(str, zzagdVar);
        this.zzghp.put(str, zzafyVar);
        return this;
    }

    public final zzcdy zzapk() {
        return new zzcdy(this);
    }
}
