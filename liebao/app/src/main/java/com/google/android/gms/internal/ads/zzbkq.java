package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkq implements zzbkn {
    private final Context context;
    private final com.google.android.gms.ads.internal.util.zzf zzeci = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();

    public zzbkq(Context context) {
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbkn
    public final void zzm(Map<String, String> map) {
        Context context;
        if (map.isEmpty()) {
            return;
        }
        String str = map.get("gad_idless");
        if (str != null) {
            boolean parseBoolean = Boolean.parseBoolean(str);
            map.remove("gad_idless");
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
                this.zzeci.zzau(parseBoolean);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && parseBoolean && (context = this.context) != null) {
                    context.deleteDatabase("OfflineUpload.db");
                }
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
            com.google.android.gms.ads.internal.zzr.zzlt().setConsent(bundle);
        }
    }
}
