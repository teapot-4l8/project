package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbel implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ int zzert;
    private final /* synthetic */ int zzeru;
    private final /* synthetic */ boolean zzerv;
    private final /* synthetic */ zzbek zzerw;
    private final /* synthetic */ long zzery;
    private final /* synthetic */ long zzerz;
    private final /* synthetic */ int zzesa;
    private final /* synthetic */ int zzesb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbel(zzbek zzbekVar, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.zzerw = zzbekVar;
        this.zzeik = str;
        this.zzers = str2;
        this.zzert = i;
        this.zzeru = i2;
        this.zzery = j;
        this.zzerz = j2;
        this.zzerv = z;
        this.zzesa = i3;
        this.zzesb = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("bytesLoaded", Integer.toString(this.zzert));
        hashMap.put("totalBytes", Integer.toString(this.zzeru));
        hashMap.put("bufferedDuration", Long.toString(this.zzery));
        hashMap.put("totalDuration", Long.toString(this.zzerz));
        hashMap.put("cacheReady", this.zzerv ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzesa));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzesb));
        this.zzerw.zza("onPrecacheEvent", hashMap);
    }
}
