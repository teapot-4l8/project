package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzauv extends zzaux {
    private final Object lock = new Object();
    private final Context zzaai;
    private SharedPreferences zzeak;
    private final zzamg<JSONObject, JSONObject> zzeal;

    public zzauv(Context context, zzamg<JSONObject, JSONObject> zzamgVar) {
        this.zzaai = context.getApplicationContext();
        this.zzeal = zzamgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaux
    public final zzebt<Void> zzxe() {
        synchronized (this.lock) {
            if (this.zzeak == null) {
                this.zzeak = this.zzaai.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis() - this.zzeak.getLong("js_last_update", 0L) < zzadn.zzdfg.get().longValue()) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzeal.zzh(zzw(this.zzaai)), new zzdxw(this) { // from class: com.google.android.gms.internal.ads.zzauu
            private final zzauv zzeaj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeaj = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return this.zzeaj.zzf((JSONObject) obj);
            }
        }, zzbat.zzekj);
    }

    public static JSONObject zzw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbar.zzaau().zzbrz);
            jSONObject.put("mf", zzadn.zzdff.get());
            jSONObject.put("cl", "360757573");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzabq.zza(this.zzaai, 1, jSONObject);
        this.zzeak.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()).apply();
        return null;
    }
}
