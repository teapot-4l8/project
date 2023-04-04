package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcys implements zzcym<zzcaj> {
    private final Context context;
    private final zzcbj zzgwq;

    public zzcys(Context context, zzcbj zzcbjVar) {
        this.context = context;
        this.zzgwq = zzcbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcym
    public final /* synthetic */ zzcaj zza(zzdpi zzdpiVar, zzdot zzdotVar, View view, zzcyt zzcytVar) {
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzcyu(this, zzcyv.zzhab));
        zzcytVar.zza(new zzcyx(this, zza));
        return zza.zzait();
    }
}
