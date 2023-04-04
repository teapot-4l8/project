package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaim implements zzaig<Object> {
    private final Context context;

    public zzaim(Context context) {
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        if (com.google.android.gms.ads.internal.zzr.zzlt().zzaa(this.context)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c2 = 1;
                    }
                } else if (str.equals("_ac")) {
                    c2 = 0;
                }
            } else if (str.equals("_aa")) {
                c2 = 2;
            }
            if (c2 == 0) {
                com.google.android.gms.ads.internal.zzr.zzlt().zzg(this.context, str2);
            } else if (c2 == 1) {
                com.google.android.gms.ads.internal.zzr.zzlt().zzh(this.context, str2);
            } else if (c2 == 2) {
                com.google.android.gms.ads.internal.zzr.zzlt().zzj(this.context, str2);
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzex("logScionEvent gmsg contained unsupported eventName");
            }
        }
    }
}
