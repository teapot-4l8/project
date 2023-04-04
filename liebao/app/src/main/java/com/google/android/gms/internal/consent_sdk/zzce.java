package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzce {
    private final Context zza;
    private final Map<String, SharedPreferences.Editor> zzb = new HashMap();

    public zzce(Context context) {
        this.zza = context;
    }

    public final boolean zza(String str, Object obj) {
        zzcb zza = zzcc.zza(this.zza, str);
        if (zza == null) {
            return false;
        }
        SharedPreferences.Editor zza2 = zza(zza.zza);
        if (obj instanceof Integer) {
            zza2.putInt(zza.zzb, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Long) {
            zza2.putLong(zza.zzb, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Double) {
            zza2.putFloat(zza.zzb, ((Double) obj).floatValue());
            return true;
        } else if (obj instanceof Float) {
            zza2.putFloat(zza.zzb, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Boolean) {
            zza2.putBoolean(zza.zzb, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof String) {
            zza2.putString(zza.zzb, (String) obj);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences.Editor zza(String str) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, this.zza.getSharedPreferences(str, 0).edit());
        }
        return this.zzb.get(str);
    }

    public final void zza() {
        for (SharedPreferences.Editor editor : this.zzb.values()) {
            editor.apply();
        }
    }
}
