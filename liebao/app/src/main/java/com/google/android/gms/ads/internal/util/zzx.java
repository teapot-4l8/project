package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zztz;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzx extends zzy {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public final int zzzy() {
        return 16974374;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final CookieManager zzbi(Context context) {
        if (zzzx()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final zzbfh zza(zzbfi zzbfiVar, zztz zztzVar, boolean z) {
        return new zzbgl(zzbfiVar, zztzVar, z);
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
