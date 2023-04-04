package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzcwf<AdT> implements zzcsz<AdT> {
    protected abstract zzebt<AdT> zza(zzdpm zzdpmVar, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return !TextUtils.isEmpty(zzdotVar.zzhmk.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<AdT> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        String optString = zzdotVar.zzhmk.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdpm zzdpmVar = zzdpiVar.zzhns.zzfzg;
        zzdpo zzgt = new zzdpo().zzc(zzdpmVar).zzgt(optString);
        Bundle zzm = zzm(zzdpmVar.zzhnx.zzcih);
        Bundle zzm2 = zzm(zzm.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzm2.putInt("gw", 1);
        String optString2 = zzdotVar.zzhmk.optString("mad_hac", null);
        if (optString2 != null) {
            zzm2.putString("mad_hac", optString2);
        }
        String optString3 = zzdotVar.zzhmk.optString("adJson", null);
        if (optString3 != null) {
            zzm2.putString("_ad", optString3);
        }
        zzm2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzdotVar.zzhmn.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzdotVar.zzhmn.optString(next, null);
            if (next != null) {
                zzm2.putString(next, optString4);
            }
        }
        zzm.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzm2);
        zzdpm zzawg = zzgt.zzh(new zzvq(zzdpmVar.zzhnx.versionCode, zzdpmVar.zzhnx.zzcia, zzm2, zzdpmVar.zzhnx.zzcib, zzdpmVar.zzhnx.zzcic, zzdpmVar.zzhnx.zzcid, zzdpmVar.zzhnx.zzadv, zzdpmVar.zzhnx.zzbns, zzdpmVar.zzhnx.zzcie, zzdpmVar.zzhnx.zzcif, zzdpmVar.zzhnx.zzng, zzdpmVar.zzhnx.zzcig, zzm, zzdpmVar.zzhnx.zzcii, zzdpmVar.zzhnx.zzcij, zzdpmVar.zzhnx.zzcik, zzdpmVar.zzhnx.zzcil, zzdpmVar.zzhnx.zzcim, zzdpmVar.zzhnx.zzcip, zzdpmVar.zzhnx.zzadw, zzdpmVar.zzhnx.zzadx, zzdpmVar.zzhnx.zzcin, zzdpmVar.zzhnx.zzcio)).zzawg();
        Bundle bundle = new Bundle();
        zzdoy zzdoyVar = zzdpiVar.zzhnt.zzeuy;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzdoyVar.zzdnd));
        bundle2.putInt("refresh_interval", zzdoyVar.zzhnh);
        bundle2.putString("gws_query_id", zzdoyVar.zzbwe);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdpiVar.zzhns.zzfzg.zzhny;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzdotVar.zzdnw);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzdotVar.zzdna));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzdotVar.zzdnb));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzdotVar.zzdxk));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzdotVar.zzhmd));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzdotVar.zzdxx));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzdotVar.zzdxy));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzdotVar.zzhmc));
        bundle3.putString("transaction_id", zzdotVar.zzdoh);
        bundle3.putString("valid_from_timestamp", zzdotVar.zzdoi);
        bundle3.putBoolean("is_closable_area_disabled", zzdotVar.zzbpw);
        if (zzdotVar.zzdxw != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdotVar.zzdxw.zzean);
            bundle4.putString("rb_type", zzdotVar.zzdxw.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzawg, bundle);
    }

    private static Bundle zzm(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }
}
