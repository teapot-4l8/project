package com.google.android.gms.internal.ads;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzanj {
    private final long zzdmz;
    private final String zzdnt;
    private final String zzdnu;
    public final List<String> zzdnv;
    private final String zzdnw;
    private final String zzdnx;
    private final List<String> zzdny;
    private final List<String> zzdnz;
    private final List<String> zzdoa;
    private final List<String> zzdob;
    private final List<String> zzdoc;
    public final String zzdod;
    private final List<String> zzdoe;
    private final List<String> zzdof;
    private final List<String> zzdog;
    private final String zzdoh;
    private final String zzdoi;
    private final String zzdoj;
    private final String zzdok;
    private final String zzdol;
    private final List<String> zzdom;
    private final String zzdon;
    public final String zzdoo;

    public zzanj(JSONObject jSONObject) {
        List<String> list;
        this.zzdnu = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdnv = Collections.unmodifiableList(arrayList);
        this.zzdnw = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdny = zzanl.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdnz = zzanl.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdoa = zzanl.zza(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdoc = zzanl.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdoe = zzanl.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdog = zzanl.zza(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdof = zzanl.zza(jSONObject, "video_reward_urls");
        this.zzdoh = jSONObject.optString("transaction_id");
        this.zzdoi = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject(ak.aw);
        if (optJSONObject != null) {
            com.google.android.gms.ads.internal.zzr.zzln();
            list = zzanl.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdob = list;
        this.zzdnt = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(JThirdPlatFormInterface.KEY_DATA);
        this.zzdod = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdnx = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdoj = jSONObject.optString("html_template", null);
        this.zzdok = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdol = optJSONObject3 != null ? optJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzr.zzln();
        this.zzdom = zzanl.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdon = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdoo = jSONObject.optString("response_type", null);
        this.zzdmz = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
