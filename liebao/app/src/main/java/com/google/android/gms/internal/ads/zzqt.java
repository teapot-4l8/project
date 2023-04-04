package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqt {
    private final String zzbrw;
    private final JSONObject zzbrx;
    private final String zzbry;
    private final String zzbrz;
    private final boolean zzbsa = false;
    private final boolean zzbsb;

    public zzqt(String str, zzbar zzbarVar, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbrz = zzbarVar.zzbrz;
        this.zzbrx = jSONObject;
        this.zzbry = str;
        this.zzbrw = str2;
        this.zzbsb = z2;
    }

    public final String zzlz() {
        return this.zzbrw;
    }

    public final String zzma() {
        return this.zzbrz;
    }

    public final JSONObject zzmb() {
        return this.zzbrx;
    }

    public final String getUniqueId() {
        return this.zzbry;
    }

    public final boolean isNative() {
        return this.zzbsb;
    }
}
