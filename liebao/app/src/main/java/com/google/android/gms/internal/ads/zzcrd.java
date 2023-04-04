package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrd implements zzdtm {
    private final zzdtx zzgsu;
    private final Map<zzdth, String> zzgsw = new HashMap();
    private final Map<zzdth, String> zzgsx = new HashMap();

    public zzcrd(Set<zzcrc> set, zzdtx zzdtxVar) {
        zzdth zzdthVar;
        String str;
        zzdth zzdthVar2;
        String str2;
        this.zzgsu = zzdtxVar;
        for (zzcrc zzcrcVar : set) {
            Map<zzdth, String> map = this.zzgsw;
            zzdthVar = zzcrcVar.zzgoh;
            str = zzcrcVar.label;
            map.put(zzdthVar, str);
            Map<zzdth, String> map2 = this.zzgsx;
            zzdthVar2 = zzcrcVar.zzgoi;
            str2 = zzcrcVar.label;
            map2.put(zzdthVar2, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzb(zzdth zzdthVar, String str) {
        zzdtx zzdtxVar = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtxVar.zzha(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."));
        if (this.zzgsw.containsKey(zzdthVar)) {
            zzdtx zzdtxVar2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsw.get(zzdthVar));
            zzdtxVar2.zzha(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str, Throwable th) {
        zzdtx zzdtxVar = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtxVar.zzx(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "f.");
        if (this.zzgsx.containsKey(zzdthVar)) {
            zzdtx zzdtxVar2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsx.get(zzdthVar));
            zzdtxVar2.zzx(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "f.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzc(zzdth zzdthVar, String str) {
        zzdtx zzdtxVar = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtxVar.zzx(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "s.");
        if (this.zzgsx.containsKey(zzdthVar)) {
            zzdtx zzdtxVar2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsx.get(zzdthVar));
            zzdtxVar2.zzx(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "s.");
        }
    }
}
