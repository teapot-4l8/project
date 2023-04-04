package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczb {
    private final Executor executor;
    private JSONObject zzgnc;
    private final Map<String, zzcze> zzhaf = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcze>>> zzhag = new ConcurrentHashMap();

    public zzczb(Executor executor) {
        this.executor = executor;
    }

    public final void zzaqq() {
        com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcza
            private final zzczb zzhae;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhae = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhae.zzatc();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczd
            private final zzczb zzhae;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhae = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhae.zzatb();
            }
        });
    }

    public final Map<String, List<Bundle>> zzu(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzcze>> map = this.zzhag.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzcze> list = map.get(str2);
        if (list == null) {
            list = map.get(zzckg.zza(this.zzgnc, str2, str));
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzcze zzczeVar : list) {
            String str3 = zzczeVar.zzcja;
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, new ArrayList());
            }
            ((List) hashMap.get(str3)).add(zzczeVar.zzewv);
        }
        return hashMap;
    }

    public final void zzgq(String str) {
        if (TextUtils.isEmpty(str) || this.zzhaf.containsKey(str)) {
            return;
        }
        this.zzhaf.put(str, new zzcze(str, "", new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzata */
    public final synchronized void zzatd() {
        JSONArray optJSONArray;
        JSONObject zzyu = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg().zzyu();
        if (zzyu != null) {
            try {
                JSONArray optJSONArray2 = zzyu.optJSONArray("ad_unit_id_settings");
                this.zzgnc = zzyu.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject(JThirdPlatFormInterface.KEY_DATA);
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        ArrayList arrayList4 = arrayList3;
                                        int size = arrayList4.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList4.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzgq(str);
                                            if (this.zzhaf.get(str) != null) {
                                                arrayList2.add(new zzcze(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcze>> map = this.zzhag.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.zzhag.put(optString2, map);
                            List<zzcze> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.zzd.zza("Malformed config loading JSON.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzatc() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczc
            private final zzczb zzhae;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhae = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzhae.zzatd();
            }
        });
    }
}
