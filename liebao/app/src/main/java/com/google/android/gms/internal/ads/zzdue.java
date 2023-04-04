package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdue {
    private final Context context;
    private final String packageName;
    private final String zzbrz;

    public zzdue(Context context, zzbar zzbarVar) {
        this.context = context;
        this.packageName = context.getPackageName();
        this.zzbrz = zzbarVar.zzbrz;
    }

    public final void zzq(Map<String, String> map) {
        map.put(ak.aB, "gmob_sdk");
        map.put(ak.aE, "3");
        map.put(ak.x, Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzr.zzkv();
        map.put("device", com.google.android.gms.ads.internal.util.zzj.zzzs());
        map.put("app", this.packageName);
        com.google.android.gms.ads.internal.zzr.zzkv();
        map.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzj.zzax(this.context) ? "1" : "0");
        List<String> zzsj = zzabq.zzsj();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczx)).booleanValue()) {
            zzsj.addAll(com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzg().zznm());
        }
        map.put("e", TextUtils.join(",", zzsj));
        map.put("sdkVersion", this.zzbrz);
    }
}
