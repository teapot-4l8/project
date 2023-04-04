package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdow {
    public final int height;
    public final int width;
    public final boolean zzhng;

    public zzdow(int i, int i2, boolean z) {
        this.width = i;
        this.height = i2;
        this.zzhng = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzdow> zze(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdow(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
