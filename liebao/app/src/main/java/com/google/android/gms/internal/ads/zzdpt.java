package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.ak;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpt {
    public static <T extends zzbex & zzakr & zzbgd & zzbgk & zzbgp & zzbgs & zzbgr> zzaig<T> zza(final zzcsh zzcshVar, final zzdup zzdupVar) {
        return new zzaig(zzdupVar, zzcshVar) { // from class: com.google.android.gms.internal.ads.zzdps
            private final zzdup zzhol;
            private final zzcsh zzhom;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhol = zzdupVar;
                this.zzhom = zzcshVar;
            }

            /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbgk, com.google.android.gms.internal.ads.zzbex] */
            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                int i;
                zzdup zzdupVar2 = this.zzhol;
                zzcsh zzcshVar2 = this.zzhom;
                ?? r9 = (zzbex) obj;
                String str = (String) map.get(ak.aG);
                if (str == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("URL missing from click GMSG.");
                    return;
                }
                String zza = zzahr.zza(r9, str);
                if (!r9.zzadk().zzhmz) {
                    zzdupVar2.zzen(zza);
                    return;
                }
                long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
                String str2 = ((zzbgd) r9).zzaev().zzbwe;
                com.google.android.gms.ads.internal.zzr.zzkv();
                if (com.google.android.gms.ads.internal.util.zzj.zzbd(((zzbgk) r9).getContext())) {
                    i = zzcse.zzgui;
                } else {
                    i = zzcse.zzguh;
                }
                zzcshVar2.zza(new zzcso(currentTimeMillis, str2, zza, i));
            }
        };
    }

    public static <T extends zzbex & zzbgd & zzbgk & zzbgs> zzaig<T> zzb(final zzcsh zzcshVar, final zzdup zzdupVar) {
        return new zzaig(zzdupVar, zzcshVar) { // from class: com.google.android.gms.internal.ads.zzdpv
            private final zzdup zzhol;
            private final zzcsh zzhom;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhol = zzdupVar;
                this.zzhom = zzcshVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                zzdup zzdupVar2 = this.zzhol;
                zzcsh zzcshVar2 = this.zzhom;
                zzbex zzbexVar = (zzbex) obj;
                String str = (String) map.get(ak.aG);
                if (str == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("URL missing from httpTrack GMSG.");
                } else if (!zzbexVar.zzadk().zzhmz) {
                    zzdupVar2.zzen(str);
                } else {
                    zzcshVar2.zza(new zzcso(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis(), ((zzbgd) zzbexVar).zzaev().zzbwe, str, zzcse.zzgui));
                }
            }
        };
    }
}
