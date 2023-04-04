package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarb {
    private final zzbfi zzdkm;
    private final boolean zzdrg;
    private final String zzdrh;

    public zzarb(zzbfi zzbfiVar, Map<String, String> map) {
        this.zzdkm = zzbfiVar;
        this.zzdrh = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdrg = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdrg = true;
        }
    }

    public final void execute() {
        int zzzv;
        if (this.zzdkm == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdrh)) {
            zzzv = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdrh)) {
            zzzv = 6;
        } else {
            zzzv = this.zzdrg ? -1 : com.google.android.gms.ads.internal.zzr.zzkx().zzzv();
        }
        this.zzdkm.setRequestedOrientation(zzzv);
    }
}
