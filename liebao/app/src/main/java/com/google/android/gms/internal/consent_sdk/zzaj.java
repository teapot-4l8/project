package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzaj implements zzi {
    private final Application zza;
    private final zzal zzb;
    private final Executor zzc;

    public zzaj(Application application, zzal zzalVar, Executor executor) {
        this.zza = application;
        this.zzb = zzalVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzi
    public final Executor zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzi
    public final boolean zza(String str, JSONObject jSONObject) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != 94746189) {
            if (hashCode == 113399775 && str.equals("write")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (str.equals("clear")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            zzce zzceVar = new zzce(this.zza);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                String valueOf = String.valueOf(opt);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 23 + String.valueOf(valueOf).length());
                sb.append("Writing to storage: [");
                sb.append(next);
                sb.append("] ");
                sb.append(valueOf);
                Log.d("UserMessagingPlatform", sb.toString());
                if (zzceVar.zza(next, opt)) {
                    this.zzb.zzd().add(next);
                } else {
                    String valueOf2 = String.valueOf(next);
                    Log.d("UserMessagingPlatform", valueOf2.length() != 0 ? "Failed writing key: ".concat(valueOf2) : new String("Failed writing key: "));
                }
            }
            this.zzb.zze();
            zzceVar.zza();
            return true;
        } else if (c2 != 1) {
            return false;
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("keys");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                String valueOf3 = String.valueOf(jSONObject.toString());
                Log.d("UserMessagingPlatform", valueOf3.length() != 0 ? "Action[clear]: wrong args.".concat(valueOf3) : new String("Action[clear]: wrong args."));
            } else {
                HashSet hashSet = new HashSet();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (TextUtils.isEmpty(optString)) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Action[clear]: empty key at index: ");
                        sb2.append(i);
                        Log.d("UserMessagingPlatform", sb2.toString());
                    } else {
                        hashSet.add(optString);
                    }
                }
                zzcc.zza(this.zza, hashSet);
            }
            return true;
        }
    }
}
