package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmf implements zzdtm {
    private final Clock zzbqq;
    private final zzclz zzgok;
    private final Map<zzdth, Long> zzgoj = new HashMap();
    private final Map<zzdth, zzcme> zzgol = new HashMap();

    public zzcmf(zzclz zzclzVar, Set<zzcme> set, Clock clock) {
        zzdth zzdthVar;
        this.zzgok = zzclzVar;
        for (zzcme zzcmeVar : set) {
            Map<zzdth, zzcme> map = this.zzgol;
            zzdthVar = zzcmeVar.zzgoi;
            map.put(zzdthVar, zzcmeVar);
        }
        this.zzbqq = clock;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzb(zzdth zzdthVar, String str) {
        this.zzgoj.put(zzdthVar, Long.valueOf(this.zzbqq.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str, Throwable th) {
        if (this.zzgoj.containsKey(zzdthVar)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzdthVar).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzgol.containsKey(zzdthVar)) {
            zza(zzdthVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzc(zzdth zzdthVar, String str) {
        if (this.zzgoj.containsKey(zzdthVar)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzdthVar).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzgol.containsKey(zzdthVar)) {
            zza(zzdthVar, true);
        }
    }

    private final void zza(zzdth zzdthVar, boolean z) {
        zzdth zzdthVar2;
        String str;
        zzdthVar2 = this.zzgol.get(zzdthVar).zzgoh;
        String str2 = z ? "s." : "f.";
        if (this.zzgoj.containsKey(zzdthVar2)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzdthVar2).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            str = this.zzgol.get(zzdthVar).label;
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
    }
}
