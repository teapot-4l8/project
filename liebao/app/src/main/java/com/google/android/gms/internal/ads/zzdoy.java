package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import com.umeng.analytics.pro.ak;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdoy {
    public final int responseCode;
    public final String zzbwe;
    public final List<String> zzdnd;
    public final String zzdyi;
    public final boolean zzegd;
    public final long zzgss;
    public final int zzhnh;
    public final zzdov zzhni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdoy(JsonReader jsonReader) {
        List<String> emptyList = Collections.emptyList();
        jsonReader.beginObject();
        String str = "";
        String str2 = "";
        long j = 0;
        zzdov zzdovVar = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("nofill_urls".equals(nextName)) {
                emptyList = com.google.android.gms.ads.internal.util.zzbh.zza(jsonReader);
            } else if ("refresh_interval".equals(nextName)) {
                i = jsonReader.nextInt();
            } else if ("gws_query_id".equals(nextName)) {
                str = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(nextName)) {
                str2 = jsonReader.nextString();
            } else if ("is_idless".equals(nextName)) {
                z = jsonReader.nextBoolean();
            } else if ("response_code".equals(nextName)) {
                i2 = jsonReader.nextInt();
            } else if (ak.aS.equals(nextName)) {
                j = jsonReader.nextLong();
            } else {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzdaz)).booleanValue() && "public_error".equals(nextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzdovVar = new zzdov(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
        }
        jsonReader.endObject();
        this.zzdnd = emptyList;
        this.zzhnh = i;
        this.zzbwe = str;
        this.zzdyi = str2;
        this.responseCode = i2;
        this.zzgss = j;
        this.zzhni = zzdovVar;
        this.zzegd = z;
    }
}
