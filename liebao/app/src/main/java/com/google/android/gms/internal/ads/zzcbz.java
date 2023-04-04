package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcbz implements zzbph<zzbpi> {
    private final zzcdy zzfwx;
    private final Map<String, zzcsz<zzbpi>> zzfyr;
    private final zzesn<zzbph<zzbne>> zzgeb;
    private final Map<String, zzcsz<zzcdf>> zzgec;
    private final Map<String, zzcvm<zzcdf>> zzged;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbz(Map<String, zzcsz<zzbpi>> map, Map<String, zzcsz<zzcdf>> map2, Map<String, zzcvm<zzcdf>> map3, zzesn<zzbph<zzbne>> zzesnVar, zzcdy zzcdyVar) {
        this.zzfyr = map;
        this.zzgec = map2;
        this.zzged = map3;
        this.zzgeb = zzesnVar;
        this.zzfwx = zzcdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final zzcsz<zzbpi> zze(int i, String str) {
        zzcsz<zzbne> zze;
        zzcsz<zzbpi> zzcszVar = this.zzfyr.get(str);
        if (zzcszVar != null) {
            return zzcszVar;
        }
        if (i == 1) {
            if (this.zzfwx.zzapg() == null || (zze = this.zzgeb.get().zze(i, str)) == null) {
                return null;
            }
            return zzbpi.zza(zze);
        } else if (i != 4) {
            return null;
        } else {
            zzcvm<zzcdf> zzcvmVar = this.zzged.get(str);
            if (zzcvmVar != null) {
                return zzbpi.zza((zzcvm<? extends zzbpc>) zzcvmVar);
            }
            zzcsz<zzcdf> zzcszVar2 = this.zzgec.get(str);
            if (zzcszVar2 != null) {
                return zzbpi.zza(zzcszVar2);
            }
            return null;
        }
    }
}
