package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzt implements zzbzq {
    private final List<String> zzdxk;
    private final zzdup zzftn;
    private boolean zzgdj;

    public zzbzt(zzdot zzdotVar, zzdup zzdupVar) {
        this.zzdxk = zzdotVar.zzdxk;
        this.zzftn = zzdupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzq
    public final void zzanl() {
        if (this.zzgdj) {
            return;
        }
        this.zzftn.zzk(this.zzdxk);
        this.zzgdj = true;
    }
}
