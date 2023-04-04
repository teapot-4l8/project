package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbai {
    private final List<String> zzejx;
    private static Object lock = new Object();
    private static boolean zzejv = false;
    private static boolean enabled = false;
    private static Clock zzbqq = DefaultClock.getInstance();
    private static final Set<String> zzejw = new HashSet(Arrays.asList(new String[0]));

    public zzbai() {
        this(null);
    }

    public zzbai(String str) {
        List<String> asList;
        if (!isEnabled()) {
            asList = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            asList = Arrays.asList(strArr);
        }
        this.zzejx = asList;
    }

    public final void zza(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zza(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    private final void zzb(String str, String str2, Map<String, ?> map, byte[] bArr) {
        zza("onNetworkRequest", new zzbal(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzbah
            private final String zzdkl;
            private final String zzdmo;
            private final Map zzejt;
            private final byte[] zzeju;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdkl = str2;
                this.zzejt = map;
                this.zzeju = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final void zzb(JsonWriter jsonWriter) {
                zzbai.zza(this.zzdmo, this.zzdkl, this.zzejt, this.zzeju, jsonWriter);
            }
        });
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzbao.zzez(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzev(str);
            }
        }
    }

    public final void zza(Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzev(null);
            }
        }
    }

    private final void zzb(Map<String, ?> map, int i) {
        zza("onNetworkResponse", new zzbal(i, map) { // from class: com.google.android.gms.internal.ads.zzbak
            private final Map zzeds;
            private final int zzejz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzejz = i;
                this.zzeds = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final void zzb(JsonWriter jsonWriter) {
                zzbai.zza(this.zzejz, this.zzeds, jsonWriter);
            }
        });
    }

    public final void zzeu(String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        zza("onNetworkResponseBody", new zzbal(bArr) { // from class: com.google.android.gms.internal.ads.zzbaj
            private final byte[] zzejy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzejy = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final void zzb(JsonWriter jsonWriter) {
                zzbai.zza(this.zzejy, jsonWriter);
            }
        });
    }

    private final void zzev(String str) {
        zza("onNetworkRequestError", new zzbal(str) { // from class: com.google.android.gms.internal.ads.zzbam
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final void zzb(JsonWriter jsonWriter) {
                zzbai.zza(this.zzdmo, jsonWriter);
            }
        });
    }

    private static void zza(JsonWriter jsonWriter, Map<String, ?> map) {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!zzejw.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                        jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.NAME).value(key);
                    jsonWriter.name(AppMeasurementSdk.ConditionalUserProperty.VALUE).value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzbao.zzex("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zza(String str, zzbal zzbalVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbqq.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String str2 : this.zzejx) {
                jsonWriter.value(str2);
            }
            jsonWriter.endArray();
            zzbalVar.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzbao.zzc("unable to log", e2);
        }
        zzew(stringWriter.toString());
    }

    private static synchronized void zzew(String str) {
        synchronized (zzbai.class) {
            zzbao.zzey("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbao.zzey(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzbao.zzey("GMA Debug FINISH");
        }
    }

    public static void zzaas() {
        synchronized (lock) {
            zzejv = false;
            enabled = false;
            zzbao.zzez("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzav(boolean z) {
        synchronized (lock) {
            zzejv = true;
            enabled = z;
        }
    }

    public static boolean zzaat() {
        boolean z;
        synchronized (lock) {
            z = zzejv;
        }
        return z;
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzejv && enabled;
        }
        return z;
    }

    public static boolean zzbv(Context context) {
        if (Build.VERSION.SDK_INT >= 17 && zzadi.zzdek.get().booleanValue()) {
            try {
                return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
            } catch (Exception e2) {
                zzbao.zzd("Fail to determine debug setting.", e2);
                return false;
            }
        }
        return false;
    }

    public static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzes = zzbae.zzes(encode);
            if (zzes != null) {
                jsonWriter.name("bodydigest").value(zzes);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(JThirdPlatFormInterface.KEY_CODE).value(i);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}
