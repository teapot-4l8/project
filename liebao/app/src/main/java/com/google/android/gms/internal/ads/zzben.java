package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzben implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ long zzerz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzben(zzbek zzbekVar, String str, String str2, long j) {
        this.zzerw = zzbekVar;
        this.zzeik = str;
        this.zzers = str2;
        this.zzerz = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("totalDuration", Long.toString(this.zzerz));
        this.zzerw.zza("onPrecacheEvent", hashMap);
    }
}
