package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcb {
    public final String zzhda;
    public String zzhdb;
    public Bundle zzhdc = new Bundle();

    public zzdcb(JsonReader jsonReader) {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -995427962) {
                if (hashCode == -271442291 && nextName.equals("signal_dictionary")) {
                    c2 = 1;
                }
            } else if (nextName.equals("params")) {
                c2 = 0;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                hashMap = com.google.android.gms.ads.internal.util.zzbh.zzb(jsonReader);
            } else {
                jsonReader.skipValue();
            }
        }
        this.zzhda = str;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.zzhdc.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdcb zzn(Bundle bundle) {
        try {
            this.zzhdb = com.google.android.gms.ads.internal.zzr.zzkv().zzc(bundle).toString();
        } catch (JSONException unused) {
            this.zzhdb = "{}";
        }
        return this;
    }
}
