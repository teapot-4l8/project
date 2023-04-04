package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdk implements zzqw {
    private final /* synthetic */ String zzggg;
    private final /* synthetic */ zzcdf zzggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdk(zzcdf zzcdfVar, String str) {
        this.zzggh = zzcdfVar;
        this.zzggg = str;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        Map map;
        zzcfl zzcflVar;
        zzcfl zzcflVar2;
        zzcfl zzcflVar3;
        if (zzqxVar.zzbrt) {
            map = this.zzggh.zzggb;
            map.put(this.zzggg, true);
            zzcdf zzcdfVar = this.zzggh;
            zzcflVar = zzcdfVar.zzgfw;
            View zzakl = zzcflVar.zzakl();
            zzcflVar2 = this.zzggh.zzgfw;
            Map<String, WeakReference<View>> zzapq = zzcflVar2.zzapq();
            zzcflVar3 = this.zzggh.zzgfw;
            zzcdfVar.zzb(zzakl, zzapq, zzcflVar3.zzapr(), true);
        }
    }
}
