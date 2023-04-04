package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.umeng.analytics.pro.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdci implements zzdhb<Bundle> {
    private final zzdpm zzfzg;

    public zzdci(zzdpm zzdpmVar) {
        Preconditions.checkNotNull(zzdpmVar, "the targeting must not be null");
        this.zzfzg = zzdpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzvq zzvqVar = this.zzfzg.zzhnx;
        bundle2.putInt("http_timeout_millis", this.zzfzg.zzhnx.zzcio);
        bundle2.putString("slotname", this.zzfzg.zzhny);
        int i = zzdch.zzgmf[this.zzfzg.zzhof.zzhnj - 1];
        if (i == 1) {
            bundle2.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle2.putBoolean("is_rewarded_interstitial", true);
        }
        zzdpw.zza(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzvqVar.zzcia)), zzvqVar.zzcia != -1);
        zzdpw.zza(bundle2, "extras", zzvqVar.extras);
        zzdpw.zza(bundle2, "cust_gender", Integer.valueOf(zzvqVar.zzcib), zzvqVar.zzcib != -1);
        zzdpw.zza(bundle2, "kw", zzvqVar.zzcic);
        zzdpw.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzvqVar.zzadv), zzvqVar.zzadv != -1);
        if (zzvqVar.zzcid) {
            bundle2.putBoolean("test_request", zzvqVar.zzcid);
        }
        zzdpw.zza(bundle2, "d_imp_hdr", (Integer) 1, zzvqVar.versionCode >= 2 && zzvqVar.zzbns);
        zzdpw.zza(bundle2, "ppid", zzvqVar.zzcie, zzvqVar.versionCode >= 2 && !TextUtils.isEmpty(zzvqVar.zzcie));
        if (zzvqVar.zzng != null) {
            Location location = zzvqVar.zzng;
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong(d.C, valueOf3.longValue());
            bundle3.putLong("long", valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdpw.zza(bundle2, ImagesContract.URL, zzvqVar.zzcig);
        zzdpw.zza(bundle2, "neighboring_content_urls", zzvqVar.zzcin);
        zzdpw.zza(bundle2, "custom_targeting", zzvqVar.zzcii);
        zzdpw.zza(bundle2, "category_exclusions", zzvqVar.zzcij);
        zzdpw.zza(bundle2, "request_agent", zzvqVar.zzcik);
        zzdpw.zza(bundle2, "request_pkg", zzvqVar.zzcil);
        zzdpw.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzvqVar.zzcim), zzvqVar.versionCode >= 7);
        if (zzvqVar.versionCode >= 8) {
            zzdpw.zza(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzvqVar.zzadw), zzvqVar.zzadw != -1);
            zzdpw.zza(bundle2, "max_ad_content_rating", zzvqVar.zzadx);
        }
    }
}
