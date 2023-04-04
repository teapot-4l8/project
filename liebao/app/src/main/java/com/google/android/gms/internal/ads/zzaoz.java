package com.google.android.gms.internal.ads;

import android.location.Location;
import cn.jpush.android.service.WakedResultReceiver;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.tencent.bugly.Bugly;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoz implements NativeMediationAdRequest {
    private final String zzadx;
    private final int zzcib;
    private final boolean zzcim;
    private final int zzdos;
    private final int zzdot;
    private final zzaei zzdpr;
    private final List<String> zzdps = new ArrayList();
    private final Map<String, Boolean> zzdpt = new HashMap();
    private final Date zznc;
    private final Set<String> zzne;
    private final boolean zznf;
    private final Location zzng;

    public zzaoz(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzaei zzaeiVar, List<String> list, boolean z2, int i3, String str) {
        this.zznc = date;
        this.zzcib = i;
        this.zzne = set;
        this.zzng = location;
        this.zznf = z;
        this.zzdos = i2;
        this.zzdpr = zzaeiVar;
        this.zzcim = z2;
        this.zzdot = i3;
        this.zzadx = str;
        if (list != null) {
            for (String str2 : list) {
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzdpt.put(split[1], true);
                        } else if (Bugly.SDK_IS_DEV.equals(split[2])) {
                            this.zzdpt.put(split[1], false);
                        }
                    }
                } else {
                    this.zzdps.add(str2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zznc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcib;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzne;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzng;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zznf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdos;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        return zzaei.zzc(this.zzdpr);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzaei.zzb(this.zzdpr);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzzs.zzry().zzrh();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzzs.zzry().zzrg();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdps;
        if (list != null) {
            return list.contains(WakedResultReceiver.WAKE_TYPE_KEY) || this.zzdps.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdps;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdps;
        if (list != null) {
            return list.contains("1") || this.zzdps.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzvw() {
        List<String> list = this.zzdps;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzvx() {
        return this.zzdpt;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcim;
    }
}
