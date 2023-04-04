package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeq implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ String zzesf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeq(zzbek zzbekVar, String str, String str2, String str3, String str4) {
        this.zzerw = zzbekVar;
        this.zzeik = str;
        this.zzers = str2;
        this.zzesf = str3;
        this.val$message = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String zzfj;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.zzeik);
        if (!TextUtils.isEmpty(this.zzers)) {
            hashMap.put("cachedSrc", this.zzers);
        }
        zzbek zzbekVar = this.zzerw;
        zzfj = zzbek.zzfj(this.zzesf);
        hashMap.put(d.y, zzfj);
        hashMap.put("reason", this.zzesf);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzerw.zza("onPrecacheEvent", hashMap);
    }
}
