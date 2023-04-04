package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaix implements zzaig<Object> {
    private final zzaiw zzdjt;

    public static void zza(zzbfi zzbfiVar, zzaiw zzaiwVar) {
        zzbfiVar.zza("/reward", new zzaix(zzaiwVar));
    }

    private zzaix(zzaiw zzaiwVar) {
        this.zzdjt = zzaiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzavy zzavyVar = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get(d.y);
                if (!TextUtils.isEmpty(str2)) {
                    zzavyVar = new zzavy(str2, parseInt);
                }
            } catch (NumberFormatException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Unable to parse reward amount.", e2);
            }
            this.zzdjt.zza(zzavyVar);
        } else if ("video_start".equals(str)) {
            this.zzdjt.zzul();
        } else if ("video_complete".equals(str)) {
            this.zzdjt.zzum();
        }
    }
}
