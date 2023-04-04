package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.umeng.analytics.pro.ak;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaip implements zzaig<zzbfi> {
    private static final Map<String, Integer> zzdjl = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zza zzdjd;
    private final zzaqz zzdjh;
    private final zzari zzdjk;

    public zzaip(com.google.android.gms.ads.internal.zza zzaVar, zzaqz zzaqzVar, zzari zzariVar) {
        this.zzdjd = zzaVar;
        this.zzdjh = zzaqzVar;
        this.zzdjk = zzariVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        com.google.android.gms.ads.internal.zza zzaVar;
        zzbfi zzbfiVar2 = zzbfiVar;
        int intValue = zzdjl.get((String) map.get(ak.av)).intValue();
        if (intValue != 5 && intValue != 7 && (zzaVar = this.zzdjd) != null && !zzaVar.zzkc()) {
            this.zzdjd.zzbk(null);
        } else if (intValue == 1) {
            this.zzdjh.zzg(map);
        } else if (intValue == 3) {
            new zzara(zzbfiVar2, map).execute();
        } else if (intValue == 4) {
            new zzaqu(zzbfiVar2, map).execute();
        } else if (intValue == 5) {
            new zzarb(zzbfiVar2, map).execute();
        } else if (intValue == 6) {
            this.zzdjh.zzag(true);
        } else if (intValue == 7) {
            this.zzdjk.zzwc();
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzey("Unknown MRAID command called.");
        }
    }
}
