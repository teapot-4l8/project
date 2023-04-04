package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahr {
    public static final zzaig<zzbfi> zzdig = zzahq.zzdif;
    public static final zzaig<zzbfi> zzdih = zzaht.zzdif;
    public static final zzaig<zzbfi> zzdii = zzahs.zzdif;
    public static final zzaig<zzbfi> zzdij = zzahv.zzdif;
    public static final zzaig<zzbfi> zzdik = new zzahw();
    public static final zzaig<zzbfi> zzdil = new zzahy();
    public static final zzaig<zzbfi> zzdim = zzahu.zzdif;
    public static final zzaig<Object> zzdin = new zzaib();
    public static final zzaig<zzbfi> zzdio = new zzaia();
    public static final zzaig<zzbfi> zzdip = zzahx.zzdif;
    public static final zzaig<zzbfi> zzdiq = new zzaid();
    public static final zzaig<zzbfi> zzdir = new zzaic();
    public static final zzaig<zzbcs> zzdis = new zzbed();
    public static final zzaig<zzbcs> zzdit = new zzbeg();
    public static final zzaig<zzbfi> zzdiu = new zzaho();
    public static final zzais zzdiv = new zzais();
    public static final zzaig<zzbfi> zzdiw = new zzaif();
    public static final zzaig<zzbfi> zzdix = new zzaie();
    public static final zzaig<zzbfi> zzdiy = new zzaih();
    public static final zzaig<zzbfi> zzdiz = new zzahz();

    public static <T extends zzbgk & zzbgp & zzbgr> String zza(T t, String str) {
        Uri parse = Uri.parse(str);
        try {
            zzei zzaei = t.zzaei();
            if (zzaei != null && zzaei.zzb(parse)) {
                parse = zzaei.zza(parse, t.getContext(), t.getView(), t.zzabx());
            }
        } catch (zzeh unused) {
            String valueOf = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        return zzayv.zzb(parse, t.getContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzbgp zzbgpVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzei zzaei = zzbgpVar.zzaei();
            if (zzaei != null) {
                zzaei.zzcb().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(zzbgk zzbgkVar, Map map) {
        String str = (String) map.get(ak.aG);
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("URL missing from httpTrack GMSG.");
        } else {
            new com.google.android.gms.ads.internal.util.zzbq(zzbgkVar.getContext(), ((zzbgs) zzbgkVar).zzacc().zzbrz, str).zzyx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void zza(zzbex zzbexVar, Map map) {
        String str = (String) map.get(ak.aG);
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("URL missing from click GMSG.");
            return;
        }
        new com.google.android.gms.ads.internal.util.zzbq(((zzbgk) zzbexVar).getContext(), ((zzbgs) zzbexVar).zzacc().zzbrz, zza(zzbexVar, str)).zzyx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzb(zzbgk zzbgkVar, Map map) {
        PackageManager packageManager = zzbgkVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get(JThirdPlatFormInterface.KEY_DATA)).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString(ak.aG);
                        String optString3 = jSONObject2.optString(ak.aC);
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString(ak.ax);
                        String optString6 = jSONObject2.optString(ak.aF);
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e2) {
                                String valueOf = String.valueOf(optString7);
                                com.google.android.gms.ads.internal.util.zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e3) {
                            com.google.android.gms.ads.internal.util.zzd.zzc("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        com.google.android.gms.ads.internal.util.zzd.zzc("Error parsing the intent data.", e4);
                    }
                }
                ((zzakr) zzbgkVar).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzakr) zzbgkVar).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzakr) zzbgkVar).zza("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzc(zzbgk zzbgkVar, Map map) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzdaw)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzd.zzez("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get(ak.o);
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        Boolean valueOf = Boolean.valueOf(zzbgkVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
        hashMap.put(str, valueOf);
        String valueOf2 = String.valueOf(valueOf);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(valueOf2).length());
        sb.append("/canOpenApp;");
        sb.append(str);
        sb.append(";");
        sb.append(valueOf2);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        ((zzakr) zzbgkVar).zza("openableApp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzd(zzbgk zzbgkVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbgkVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            hashMap.put(str2, valueOf);
            String valueOf2 = String.valueOf(valueOf);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("/canOpenURLs;");
            sb.append(str2);
            sb.append(";");
            sb.append(valueOf2);
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        }
        ((zzakr) zzbgkVar).zza("openableURLs", hashMap);
    }
}
