package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzais implements zzaig<Object> {
    private final Object lock = new Object();
    private final Map<String, zzaiu> zzdjr = new HashMap();

    public final void zza(String str, zzaiu zzaiuVar) {
        synchronized (this.lock) {
            this.zzdjr.put(str, zzaiuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = "";
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzaiu remove = this.zzdjr.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str5 == null) {
                remove.zzc(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (com.google.android.gms.ads.internal.util.zzd.zzyz()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        com.google.android.gms.ads.internal.util.zzd.zzed(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e2) {
                    remove.onFailure(e2.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzalf> zzebt<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbe zzbbeVar = new zzbbe();
        com.google.android.gms.ads.internal.zzr.zzkv();
        String zzzr = com.google.android.gms.ads.internal.util.zzj.zzzr();
        zza(zzzr, new zzaiv(this, zzbbeVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzzr);
            jSONObject2.put("args", jSONObject);
            enginet.zzb(str, jSONObject2);
        } catch (Exception e2) {
            zzbbeVar.setException(e2);
        }
        return zzbbeVar;
    }
}
