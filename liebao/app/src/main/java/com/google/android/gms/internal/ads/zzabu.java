package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.umeng.analytics.pro.ak;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzabu {
    private Context context;
    private String zzbrz;
    private String zzdbu = zzadg.zzdec.get();
    private Map<String, String> zzdbv;

    public zzabu(Context context, String str) {
        String packageName;
        this.context = null;
        this.zzbrz = null;
        this.context = context;
        this.zzbrz = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzdbv = linkedHashMap;
        linkedHashMap.put(ak.aB, "gmob_sdk");
        this.zzdbv.put(ak.aE, "3");
        this.zzdbv.put(ak.x, Build.VERSION.RELEASE);
        this.zzdbv.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzdbv;
        com.google.android.gms.ads.internal.zzr.zzkv();
        map.put("device", com.google.android.gms.ads.internal.util.zzj.zzzs());
        Map<String, String> map2 = this.zzdbv;
        if (context.getApplicationContext() != null) {
            packageName = context.getApplicationContext().getPackageName();
        } else {
            packageName = context.getPackageName();
        }
        map2.put("app", packageName);
        Map<String, String> map3 = this.zzdbv;
        com.google.android.gms.ads.internal.zzr.zzkv();
        map3.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzj.zzax(context) ? "1" : "0");
        Future<zzauo> zzr = com.google.android.gms.ads.internal.zzr.zzlg().zzr(this.context);
        try {
            this.zzdbv.put("network_coarse", Integer.toString(zzr.get().zzdzl));
            this.zzdbv.put("network_fine", Integer.toString(zzr.get().zzdzm));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzsm() {
        return this.zzdbu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzma() {
        return this.zzbrz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzsn() {
        return this.zzdbv;
    }
}
