package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzahw implements zzaig<zzbfi> {
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        zzbfi zzbfiVar2 = zzbfiVar;
        if (zzbfiVar2.zzaet() != null) {
            zzbfiVar2.zzaet().zzmz();
        }
        com.google.android.gms.ads.internal.overlay.zze zzaeb = zzbfiVar2.zzaeb();
        if (zzaeb != null) {
            zzaeb.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zze zzaec = zzbfiVar2.zzaec();
        if (zzaec != null) {
            zzaec.close();
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
