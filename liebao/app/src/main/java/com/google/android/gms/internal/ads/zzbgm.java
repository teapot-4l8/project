package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbgm extends zzbfh {
    public zzbgm(zzbfi zzbfiVar, zztz zztzVar, boolean z) {
        super(zzbfiVar, zztzVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbfi)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbfi zzbfiVar = (zzbfi) webView;
        if (this.zzeti != null) {
            this.zzeti.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzbfiVar.zzaef() != null) {
            zzbfiVar.zzaef().zzwi();
        }
        if (zzbfiVar.zzaed().zzafj()) {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcoc);
        } else if (zzbfiVar.zzaek()) {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcob);
        } else {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcoa);
        }
        com.google.android.gms.ads.internal.zzr.zzkv();
        return com.google.android.gms.ads.internal.util.zzj.zzd(zzbfiVar.getContext(), zzbfiVar.zzacc().zzbrz, str2);
    }
}
