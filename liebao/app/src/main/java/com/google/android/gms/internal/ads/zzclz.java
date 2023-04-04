package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzclz {
    private final zzbac zzedz;
    private ConcurrentHashMap<String, String> zzgod;

    public zzclz(zzcmg zzcmgVar, zzbac zzbacVar) {
        this.zzgod = new ConcurrentHashMap<>(zzcmgVar.zzgof);
        this.zzedz = zzbacVar;
    }

    public final void zze(zzdpi zzdpiVar) {
        if (zzdpiVar.zzhnt.zzhnq.size() > 0) {
            switch (zzdpiVar.zzhnt.zzhnq.get(0).zzhlz) {
                case 1:
                    this.zzgod.put("ad_format", "banner");
                    break;
                case 2:
                    this.zzgod.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.zzgod.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zzgod.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zzgod.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.zzgod.put("ad_format", "app_open_ad");
                    this.zzgod.put("as", this.zzedz.zzyy() ? "1" : "0");
                    break;
                default:
                    this.zzgod.put("ad_format", "unknown");
                    break;
            }
        }
        if (TextUtils.isEmpty(zzdpiVar.zzhnt.zzeuy.zzbwe)) {
            return;
        }
        this.zzgod.put("gqi", zzdpiVar.zzhnt.zzeuy.zzbwe);
    }

    public final void zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzgod.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzgod.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzsx() {
        return this.zzgod;
    }
}
