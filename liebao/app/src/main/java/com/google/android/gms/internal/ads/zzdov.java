package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import cn.jpush.android.api.JThirdPlatFormInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdov {
    private int code;
    private String description;

    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdov(JsonReader jsonReader) {
        jsonReader.beginObject();
        int i = 3;
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1724546052) {
                if (hashCode == 3059181 && nextName.equals(JThirdPlatFormInterface.KEY_CODE)) {
                    c2 = 0;
                }
            } else if (nextName.equals("description")) {
                c2 = 1;
            }
            if (c2 == 0) {
                i = jsonReader.nextInt();
            } else if (c2 == 1) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        this.code = i;
        this.description = str;
    }
}
