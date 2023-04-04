package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzamn {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzamk<JSONObject> zzdma = new zzamp();
    public static final zzami<InputStream> zzdmb = zzamm.zzdlz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ InputStream zze(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
