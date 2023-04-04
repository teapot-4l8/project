package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgv implements zzdhe<zzdhb<Bundle>> {
    private final Context zzaai;
    private final zzebs zzgka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgv(zzebs zzebsVar, Context context) {
        this.zzgka = zzebsVar;
        this.zzaai = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgy
            private final zzdgv zzhgg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhgg = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhgg.zzauo();
            }
        });
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt(d.y, -1);
            if (optInt == 0) {
                i = zzdgz.zzhgh;
            } else if (optInt == 1) {
                i = zzdgz.zzhgi;
            } else {
                i = optInt != 2 ? 0 : zzdgz.zzhgj;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i3 = zzdha.zzhgl[i - 1];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            if (obj instanceof Integer) {
                                bundle.putInt(optString, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                bundle.putLong(optString, ((Long) obj).longValue());
                            } else if (obj instanceof Float) {
                                bundle.putFloat(optString, ((Float) obj).floatValue());
                            }
                        } else if (i3 == 3 && (obj instanceof Boolean)) {
                            bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhb zzauo() {
        String str = (String) zzww.zzra().zzd(zzabq.zzcyp);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzdhb(zza(this.zzaai, new JSONArray(str))) { // from class: com.google.android.gms.internal.ads.zzdgx
                private final Bundle zzecv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzecv = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdhb
                public final void zzr(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", this.zzecv);
                }
            };
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzb("JSON parsing error", e2);
            return null;
        }
    }
}
