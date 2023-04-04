package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbga implements zzaig<zzbfi> {
    private final /* synthetic */ zzbfy zzewd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbga(zzbfy zzbfyVar) {
        this.zzewd = zzbfyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.zzewd) {
                    i = this.zzewd.zzevs;
                    if (i != parseInt) {
                        this.zzewd.zzevs = parseInt;
                        this.zzewd.requestLayout();
                    }
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
