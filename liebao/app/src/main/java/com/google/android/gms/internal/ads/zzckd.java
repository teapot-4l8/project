package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckd {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzgna = new ConcurrentHashMap();
    private JSONObject zzgnb;
    private JSONObject zzgnc;
    private boolean zzxj;

    public zzckd(Executor executor) {
        this.executor = executor;
    }

    public final void zzaqq() {
        com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzckc
            private final zzckd zzgmz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgmz.zzaqu();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzckf
            private final zzckd zzgmz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgmz.zzaqt();
            }
        });
    }

    @CheckForNull
    public final JSONObject zzr(String str, String str2) {
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcum)).booleanValue() || str == null || str2 == null) {
            return null;
        }
        if (!this.zzxj) {
            zzaqv();
        }
        Map<String, JSONObject> map = this.zzgna.get(str2);
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        String zza = zzckg.zza(this.zzgnc, str, str2);
        if (zza == null) {
            return null;
        }
        return map.get(zza);
    }

    @CheckForNull
    public final JSONObject zzaqr() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcun)).booleanValue()) {
            return this.zzgnb;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaqs */
    public final synchronized void zzaqv() {
        Map<String, JSONObject> map;
        this.zzxj = true;
        zzazt zzzg = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg();
        if (zzzg == null) {
            return;
        }
        JSONObject zzyu = zzzg.zzyu();
        if (zzyu == null) {
            return;
        }
        this.zzgnb = ((Boolean) zzww.zzra().zzd(zzabq.zzcun)).booleanValue() ? zzyu.optJSONObject("common_settings") : null;
        this.zzgnc = zzyu.optJSONObject("ad_unit_patterns");
        JSONArray optJSONArray = zzyu.optJSONArray("ad_unit_id_settings");
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("ad_unit_id");
                String optString2 = optJSONObject.optString("format");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                if (optString != null && optJSONObject2 != null && optString2 != null) {
                    if (this.zzgna.containsKey(optString2)) {
                        map = this.zzgna.get(optString2);
                    } else {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        this.zzgna.put(optString2, concurrentHashMap);
                        map = concurrentHashMap;
                    }
                    map.put(optString, optJSONObject2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqu() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcke
            private final zzckd zzgmz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgmz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgmz.zzaqv();
            }
        });
    }
}
