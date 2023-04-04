package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings;
import com.umeng.analytics.pro.ak;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdot {
    public final String id;
    public final boolean zzadh;
    public final boolean zzbpw;
    public final String zzcig;
    public final List<String> zzdna;
    public final List<String> zzdnb;
    public final String zzdng;
    public final boolean zzdnn;
    public final boolean zzdno;
    public final boolean zzdnp;
    public final String zzdnw;
    public final String zzdoh;
    public final String zzdoi;
    public final String zzdpg;
    public final List<String> zzdxk;
    public final String zzdxn;
    public final String zzdxq;
    public final zzavy zzdxw;
    public final List<String> zzdxx;
    public final List<String> zzdxy;
    public final boolean zzdyg;
    public final boolean zzdyj;
    public final boolean zzdyk;
    public final boolean zzead;
    public final String zzewu;
    public final int zzfvw;
    public final boolean zzfvx;
    public final boolean zzfvy;
    public final String zzgbi;
    public final List<String> zzhly;
    public final int zzhlz;
    public final int zzhma;
    public final List<String> zzhmb;
    public final List<String> zzhmc;
    public final List<String> zzhmd;
    public final List<String> zzhme;
    public final int zzhmf;
    public final List<zzdow> zzhmg;
    public final zzdpa zzhmh;
    public final List<String> zzhmi;
    public final List<zzdow> zzhmj;
    public final JSONObject zzhmk;
    public final zzaxn zzhml;
    public final JSONObject zzhmm;
    public final JSONObject zzhmn;
    public final String zzhmo;
    public final boolean zzhmp;
    public final int zzhmq;
    public final int zzhmr;
    public final OmidSettings zzhms;
    public final int zzhmt;
    public final boolean zzhmu;
    public final zzasm zzhmv;
    public final zzvv zzhmw;
    public final String zzhmx;
    public final JSONObject zzhmy;
    public final boolean zzhmz;
    public final JSONObject zzhna;
    public final boolean zzhnb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdot(JsonReader jsonReader) {
        List<zzdow> list;
        char c2;
        List<String> list2;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<String> emptyList10 = Collections.emptyList();
        List<zzdow> emptyList11 = Collections.emptyList();
        List<String> emptyList12 = Collections.emptyList();
        List<zzdow> emptyList13 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        jsonReader.beginObject();
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        JSONObject jSONObject7 = jSONObject;
        JSONObject jSONObject8 = jSONObject2;
        JSONObject jSONObject9 = jSONObject3;
        JSONObject jSONObject10 = jSONObject4;
        JSONObject jSONObject11 = jSONObject5;
        JSONObject jSONObject12 = jSONObject6;
        zzavy zzavyVar = null;
        zzdpa zzdpaVar = null;
        zzaxn zzaxnVar = null;
        zzasm zzasmVar = null;
        zzvv zzvvVar = null;
        String str13 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = -1;
        int i5 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        int i6 = 0;
        int i7 = -1;
        boolean z11 = false;
        boolean z12 = true;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        List<String> list3 = emptyList12;
        List<zzdow> list4 = emptyList13;
        List<String> list5 = emptyList10;
        List<zzdow> list6 = emptyList11;
        List<String> list7 = emptyList8;
        List<String> list8 = emptyList9;
        List<String> list9 = emptyList6;
        List<String> list10 = emptyList7;
        List<String> list11 = emptyList4;
        List<String> list12 = emptyList5;
        List<String> list13 = emptyList2;
        List<String> list14 = emptyList3;
        List<String> list15 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str14 = nextName == null ? "" : nextName;
            switch (str14.hashCode()) {
                case -1980587809:
                    list = list4;
                    if (str14.equals("debug_signals")) {
                        c2 = 28;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1965512151:
                    list = list4;
                    if (str14.equals("omid_settings")) {
                        c2 = ')';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1812055556:
                    list = list4;
                    if (str14.equals("play_prewarm_options")) {
                        c2 = '1';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1662989631:
                    list = list4;
                    if (str14.equals("is_interscroller")) {
                        c2 = '5';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1620470467:
                    list = list4;
                    if (str14.equals("backend_query_id")) {
                        c2 = '/';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1440104884:
                    list = list4;
                    if (str14.equals("is_custom_close_blocked")) {
                        c2 = '#';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1439500848:
                    list = list4;
                    if (str14.equals("orientation")) {
                        c2 = '%';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1428969291:
                    list = list4;
                    if (str14.equals("enable_omid")) {
                        c2 = '\'';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1403779768:
                    list = list4;
                    if (str14.equals("showable_impression_type")) {
                        c2 = ',';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1375413093:
                    list = list4;
                    if (str14.equals("ad_cover")) {
                        c2 = '6';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1360811658:
                    list = list4;
                    if (str14.equals("ad_sizes")) {
                        c2 = 19;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1306015996:
                    list = list4;
                    if (str14.equals("adapters")) {
                        c2 = 20;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1303332046:
                    list = list4;
                    if (str14.equals("test_mode_enabled")) {
                        c2 = '\"';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1289032093:
                    list = list4;
                    if (str14.equals("extras")) {
                        c2 = 29;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1240082064:
                    list = list4;
                    if (str14.equals("ad_event_value")) {
                        c2 = '3';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1234181075:
                    list = list4;
                    if (str14.equals("allow_pub_rendered_attribution")) {
                        c2 = 30;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1168140544:
                    list = list4;
                    if (str14.equals("presentation_error_urls")) {
                        c2 = 14;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1152230954:
                    list = list4;
                    if (str14.equals("ad_type")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1146534047:
                    list = list4;
                    if (str14.equals("is_scroll_aware")) {
                        c2 = '+';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1115838944:
                    list = list4;
                    if (str14.equals("fill_urls")) {
                        c2 = '\r';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1081936678:
                    list = list4;
                    if (str14.equals("allocation_id")) {
                        c2 = 21;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1078050970:
                    list = list4;
                    if (str14.equals("video_complete_urls")) {
                        c2 = '\t';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1051269058:
                    list = list4;
                    if (str14.equals("active_view")) {
                        c2 = 25;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -982608540:
                    list = list4;
                    if (str14.equals("valid_from_timestamp")) {
                        c2 = 11;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -776859333:
                    list = list4;
                    if (str14.equals("click_urls")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -544216775:
                    list = list4;
                    if (str14.equals("safe_browsing")) {
                        c2 = 26;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -437057161:
                    list = list4;
                    if (str14.equals("imp_urls")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -404433734:
                    list = list4;
                    if (str14.equals("rtb_native_required_assets")) {
                        c2 = '9';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -404326515:
                    list = list4;
                    if (str14.equals("render_timeout_ms")) {
                        c2 = '&';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -397704715:
                    list = list4;
                    if (str14.equals("ad_close_time_ms")) {
                        c2 = '-';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -388807511:
                    list = list4;
                    if (str14.equals("content_url")) {
                        c2 = ';';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -369773488:
                    list = list4;
                    if (str14.equals("is_close_button_enabled")) {
                        c2 = '2';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -213424028:
                    list = list4;
                    if (str14.equals("watermark")) {
                        c2 = '.';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -180214626:
                    list = list4;
                    if (str14.equals("native_required_asset_viewability")) {
                        c2 = ':';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -154616268:
                    list = list4;
                    if (str14.equals("is_offline_ad")) {
                        c2 = '8';
                        break;
                    }
                    c2 = 65535;
                    break;
                case -29338502:
                    list = list4;
                    if (str14.equals("allow_custom_click_gesture")) {
                        c2 = ' ';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3107:
                    list = list4;
                    if (str14.equals(ak.aw)) {
                        c2 = 18;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3355:
                    list = list4;
                    if (str14.equals("id")) {
                        c2 = 23;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3076010:
                    list = list4;
                    if (str14.equals(JThirdPlatFormInterface.KEY_DATA)) {
                        c2 = 22;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 63195984:
                    list = list4;
                    if (str14.equals("render_test_label")) {
                        c2 = '!';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 107433883:
                    list = list4;
                    if (str14.equals("qdata")) {
                        c2 = 24;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 230323073:
                    list = list4;
                    if (str14.equals("ad_load_urls")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 418392395:
                    list = list4;
                    if (str14.equals("is_closable_area_disabled")) {
                        c2 = '$';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 549176928:
                    list = list4;
                    if (str14.equals("presentation_error_timeout_ms")) {
                        c2 = 16;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 597473788:
                    list = list4;
                    if (str14.equals("debug_dialog_string")) {
                        c2 = 27;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 673261304:
                    list = list4;
                    if (str14.equals("reward_granted_urls")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 754887508:
                    list = list4;
                    if (str14.equals("container_sizes")) {
                        c2 = 17;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 791122864:
                    list = list4;
                    if (str14.equals("impression_type")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1010584092:
                    list = list4;
                    if (str14.equals("transaction_id")) {
                        c2 = '\n';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1100650276:
                    list = list4;
                    if (str14.equals("rewards")) {
                        c2 = '\f';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1321720943:
                    list = list4;
                    if (str14.equals("allow_pub_owned_ad_view")) {
                        c2 = 31;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1637553475:
                    list = list4;
                    if (str14.equals("bid_response")) {
                        c2 = '(';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1638957285:
                    list = list4;
                    if (str14.equals("video_start_urls")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1686319423:
                    list = list4;
                    if (str14.equals("ad_network_class_name")) {
                        c2 = '7';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1688341040:
                    list = list4;
                    if (str14.equals("video_reward_urls")) {
                        c2 = '\b';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1799285870:
                    list = list4;
                    if (str14.equals("use_third_party_container_height")) {
                        c2 = '0';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1839650832:
                    list = list4;
                    if (str14.equals("renderers")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1875425491:
                    list = list4;
                    if (str14.equals("is_analytics_logging_enabled")) {
                        c2 = '*';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2068142375:
                    list = list4;
                    if (str14.equals("rule_line_external_id")) {
                        c2 = '4';
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2072888499:
                    list = list4;
                    if (str14.equals("manual_tracking_urls")) {
                        c2 = 15;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    list = list4;
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    list2 = list3;
                    list15 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 1:
                    list2 = list3;
                    String nextString = jsonReader.nextString();
                    if ("banner".equals(nextString)) {
                        i = 1;
                    } else if ("interstitial".equals(nextString)) {
                        i = 2;
                    } else if ("native_express".equals(nextString)) {
                        i = 3;
                    } else if ("native".equals(nextString)) {
                        i = 4;
                    } else if ("rewarded".equals(nextString)) {
                        i = 5;
                    } else {
                        i = "app_open_ad".equals(nextString) ? 6 : 0;
                    }
                    list3 = list2;
                    break;
                case 2:
                    list2 = list3;
                    list13 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 3:
                    list2 = list3;
                    list14 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 4:
                    list2 = list3;
                    list11 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 5:
                    list2 = list3;
                    int nextInt = jsonReader.nextInt();
                    i2 = (nextInt == 0 || nextInt == 1) ? nextInt : 0;
                    list3 = list2;
                    break;
                case 6:
                    list2 = list3;
                    list12 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 7:
                    list2 = list3;
                    com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case '\b':
                    list2 = list3;
                    list9 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case '\t':
                    list2 = list3;
                    list10 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case '\n':
                    list2 = list3;
                    str = jsonReader.nextString();
                    list3 = list2;
                    break;
                case 11:
                    list2 = list3;
                    str2 = jsonReader.nextString();
                    list3 = list2;
                    break;
                case '\f':
                    list2 = list3;
                    zzavyVar = zzavy.zza(com.google.android.gms.ads.internal.util.zzbh.zzd(jsonReader));
                    list3 = list2;
                    break;
                case '\r':
                    list2 = list3;
                    list7 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 14:
                    list2 = list3;
                    list8 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 15:
                    list2 = list3;
                    list5 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    list3 = list2;
                    break;
                case 16:
                    list2 = list3;
                    i3 = jsonReader.nextInt();
                    list3 = list2;
                    break;
                case 17:
                    list2 = list3;
                    list6 = zzdow.zze(jsonReader);
                    list3 = list2;
                    break;
                case 18:
                    list2 = list3;
                    zzdpaVar = new zzdpa(jsonReader);
                    list3 = list2;
                    break;
                case 19:
                    list4 = zzdow.zze(jsonReader);
                    continue;
                case 20:
                    list3 = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
                    break;
                case 21:
                    str3 = jsonReader.nextString();
                    break;
                case 22:
                    jSONObject7 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 23:
                    str4 = jsonReader.nextString();
                    break;
                case 24:
                    str5 = jsonReader.nextString();
                    break;
                case 25:
                    str6 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader).toString();
                    break;
                case 26:
                    zzaxnVar = zzaxn.zzg(com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader));
                    break;
                case 27:
                    str7 = jsonReader.nextString();
                    break;
                case 28:
                    jSONObject8 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 29:
                    jSONObject9 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case 30:
                    z = jsonReader.nextBoolean();
                    break;
                case 31:
                    z2 = jsonReader.nextBoolean();
                    break;
                case ' ':
                    z3 = jsonReader.nextBoolean();
                    break;
                case '!':
                    z4 = jsonReader.nextBoolean();
                    break;
                case '\"':
                    z5 = jsonReader.nextBoolean();
                    break;
                case '#':
                    z6 = jsonReader.nextBoolean();
                    break;
                case '$':
                    z7 = jsonReader.nextBoolean();
                    break;
                case '%':
                    list2 = list3;
                    String nextString2 = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString2)) {
                        i4 = 6;
                    } else {
                        i4 = "portrait".equalsIgnoreCase(nextString2) ? 7 : -1;
                    }
                    list3 = list2;
                    break;
                case '&':
                    i5 = jsonReader.nextInt();
                    break;
                case '\'':
                    z8 = jsonReader.nextBoolean();
                    break;
                case '(':
                    str8 = jsonReader.nextString();
                    break;
                case ')':
                    jSONObject10 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case '*':
                    z9 = jsonReader.nextBoolean();
                    break;
                case '+':
                    z10 = jsonReader.nextBoolean();
                    break;
                case ',':
                    i6 = jsonReader.nextInt();
                    break;
                case '-':
                    i7 = jsonReader.nextInt();
                    break;
                case '.':
                    str9 = jsonReader.nextString();
                    break;
                case '/':
                    str10 = jsonReader.nextString();
                    break;
                case '0':
                    z11 = jsonReader.nextBoolean();
                    break;
                case '1':
                    JSONObject zzc = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    if (zzc == null) {
                        list2 = list3;
                        zzasmVar = null;
                    } else {
                        list2 = list3;
                        zzasmVar = new zzasm(zzc.optBoolean("enable_prewarming", false), zzc.optString("prefetch_url", ""));
                    }
                    list3 = list2;
                    break;
                case '2':
                    z12 = jsonReader.nextBoolean();
                    break;
                case '3':
                    zzvvVar = zzvv.zza(com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader));
                    break;
                case '4':
                    str11 = jsonReader.nextString();
                    break;
                case '5':
                    z13 = jsonReader.nextBoolean();
                    break;
                case '6':
                    jSONObject11 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case '7':
                    str12 = jsonReader.nextString();
                    break;
                case '8':
                    z14 = jsonReader.nextBoolean();
                    break;
                case '9':
                    jSONObject12 = com.google.android.gms.ads.internal.util.zzbh.zzc(jsonReader);
                    break;
                case ':':
                    z15 = jsonReader.nextBoolean();
                    break;
                case ';':
                    str13 = jsonReader.nextString();
                    break;
                default:
                    list2 = list3;
                    jsonReader.skipValue();
                    list3 = list2;
                    break;
            }
            list4 = list;
        }
        jsonReader.endObject();
        this.zzhly = list15;
        this.zzhlz = i;
        this.zzdna = list13;
        this.zzdnb = list14;
        this.zzhmb = list11;
        this.zzhma = i2;
        this.zzdxx = list12;
        this.zzdxy = list9;
        this.zzhmc = list10;
        this.zzdoh = str;
        this.zzdoi = str2;
        this.zzdxw = zzavyVar;
        this.zzhmd = list7;
        this.zzhme = list8;
        this.zzdxk = list5;
        this.zzhmf = i3;
        this.zzhmg = list6;
        this.zzhmh = zzdpaVar;
        this.zzhmi = list3;
        this.zzhmj = list4;
        this.zzdnw = str3;
        this.zzhmk = jSONObject7;
        this.id = str4;
        this.zzdng = str5;
        this.zzdxq = str6;
        this.zzhml = zzaxnVar;
        this.zzdxn = str7;
        this.zzhmm = jSONObject8;
        this.zzhmn = jSONObject9;
        this.zzdnn = z;
        this.zzdno = z2;
        this.zzdnp = z3;
        this.zzead = z4;
        this.zzhmp = z5;
        this.zzfvy = z6;
        this.zzbpw = z7;
        this.zzhmq = i4;
        this.zzhmr = i5;
        this.zzdyg = z8;
        this.zzewu = str8;
        this.zzhms = new OmidSettings(jSONObject10);
        this.zzdyj = z9;
        this.zzdyk = z10;
        this.zzhmt = i6;
        this.zzdpg = str9;
        this.zzfvw = i7;
        this.zzgbi = str10;
        this.zzhmu = z11;
        this.zzhmv = zzasmVar;
        this.zzfvx = z12;
        this.zzhmw = zzvvVar;
        this.zzhmx = str11;
        this.zzadh = z13;
        this.zzhmy = jSONObject11;
        this.zzhmo = str12;
        this.zzhmz = z14;
        this.zzhna = jSONObject12;
        this.zzhnb = z15;
        this.zzcig = str13;
    }
}
