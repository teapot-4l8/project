package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzayt {
    private static zzayt zzedm;

    abstract zzaxt zzxr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract zzaxx zzxs();

    abstract zzayu zzxt();

    public static synchronized zzayt zzaj(Context context) {
        synchronized (zzayt.class) {
            if (zzedm != null) {
                return zzedm;
            }
            Context applicationContext = context.getApplicationContext();
            zzabq.initialize(applicationContext);
            com.google.android.gms.ads.internal.util.zzf zzyl = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();
            zzyl.initialize(applicationContext);
            zzayt zzxu = new zzayb().zzz(applicationContext).zza(zzyl).zza(com.google.android.gms.ads.internal.zzr.zzlt()).zzxu();
            zzedm = zzxu;
            zzxu.zzxr().zzxn();
            zzedm.zzxs().zzxq();
            zzayu zzxt = zzedm.zzxt();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) zzww.zzra().zzd(zzabq.zzcpf));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String optString = optJSONArray.optString(i);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String str : hashMap.keySet()) {
                        zzxt.zzea(str);
                    }
                    zzxt.zza(new zzayz(zzxt, hashMap) { // from class: com.google.android.gms.internal.ads.zzayx
                        private final zzayu zzedr;
                        private final Map zzeds;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzedr = zzxt;
                            this.zzeds = hashMap;
                        }

                        @Override // com.google.android.gms.internal.ads.zzayz
                        public final void zza(SharedPreferences sharedPreferences, String str2, String str3) {
                            this.zzedr.zza(this.zzeds, sharedPreferences, str2, str3);
                        }
                    });
                } catch (JSONException e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzb("Failed to parse listening list", e2);
                }
            }
            return zzedm;
        }
    }
}
