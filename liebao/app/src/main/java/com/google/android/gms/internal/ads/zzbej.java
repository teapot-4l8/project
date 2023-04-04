package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbej implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ int zzert;
    private final /* synthetic */ int zzeru;
    private final /* synthetic */ boolean zzerv = false;
    private final /* synthetic */ zzbek zzerw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbej(zzbek zzbekVar, String str, String str2, int i, int i2, boolean z) {
        this.zzerw = zzbekVar;
        this.zzeik = str;
        this.zzers = str2;
        this.zzert = i;
        this.zzeru = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("bytesLoaded", Integer.toString(this.zzert));
        hashMap.put("totalBytes", Integer.toString(this.zzeru));
        hashMap.put("cacheReady", "0");
        this.zzerw.zza("onPrecacheEvent", hashMap);
    }
}
