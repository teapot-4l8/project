package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtx {
    private final HashMap<String, String> zzhul = new HashMap<>();
    private final zzdua zzhum = new zzdua(com.google.android.gms.ads.internal.zzr.zzlc());

    private zzdtx() {
    }

    public static zzdtx zzgy(String str) {
        zzdtx zzdtxVar = new zzdtx();
        zzdtxVar.zzhul.put("action", str);
        return zzdtxVar;
    }

    public static zzdtx zzgz(String str) {
        zzdtx zzdtxVar = new zzdtx();
        zzdtxVar.zzw("request_id", str);
        return zzdtxVar;
    }

    public final zzdtx zzw(String str, String str2) {
        this.zzhul.put(str, str2);
        return this;
    }

    public final zzdtx zzha(String str) {
        this.zzhum.zzhb(str);
        return this;
    }

    public final zzdtx zzx(String str, String str2) {
        this.zzhum.zzy(str, str2);
        return this;
    }

    public final zzdtx zzq(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzhul.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzhul.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final zzdtx zza(zzdpi zzdpiVar, zzbac zzbacVar) {
        if (zzdpiVar.zzhnt == null) {
            return this;
        }
        zzdpg zzdpgVar = zzdpiVar.zzhnt;
        if (zzdpgVar.zzeuy != null) {
            zzb(zzdpgVar.zzeuy);
        }
        if (!zzdpgVar.zzhnq.isEmpty()) {
            switch (zzdpgVar.zzhnq.get(0).zzhlz) {
                case 1:
                    this.zzhul.put("ad_format", "banner");
                    break;
                case 2:
                    this.zzhul.put("ad_format", "interstitial");
                    break;
                case 3:
                    this.zzhul.put("ad_format", "native_express");
                    break;
                case 4:
                    this.zzhul.put("ad_format", "native_advanced");
                    break;
                case 5:
                    this.zzhul.put("ad_format", "rewarded");
                    break;
                case 6:
                    this.zzhul.put("ad_format", "app_open_ad");
                    if (zzbacVar != null) {
                        this.zzhul.put("as", zzbacVar.zzyy() ? "1" : "0");
                        break;
                    }
                    break;
                default:
                    this.zzhul.put("ad_format", "unknown");
                    break;
            }
        }
        return this;
    }

    public final zzdtx zzb(zzdoy zzdoyVar) {
        if (!TextUtils.isEmpty(zzdoyVar.zzbwe)) {
            this.zzhul.put("gqi", zzdoyVar.zzbwe);
        }
        return this;
    }

    public final zzdtx zzg(zzdot zzdotVar) {
        this.zzhul.put("aai", zzdotVar.zzdnw);
        return this;
    }

    public final Map<String, String> zzlw() {
        HashMap hashMap = new HashMap(this.zzhul);
        for (zzdud zzdudVar : this.zzhum.zzayk()) {
            hashMap.put(zzdudVar.label, zzdudVar.value);
        }
        return hashMap;
    }
}
