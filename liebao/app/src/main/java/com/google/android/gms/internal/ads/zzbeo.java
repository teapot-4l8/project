package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeo implements Runnable {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ String zzers;
    private final /* synthetic */ int zzeru;
    private final /* synthetic */ zzbek zzerw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeo(zzbek zzbekVar, String str, String str2, int i) {
        this.zzerw = zzbekVar;
        this.zzeik = str;
        this.zzers = str2;
        this.zzeru = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zzeik);
        hashMap.put("cachedSrc", this.zzers);
        hashMap.put("totalBytes", Integer.toString(this.zzeru));
        this.zzerw.zza("onPrecacheEvent", hashMap);
    }
}
