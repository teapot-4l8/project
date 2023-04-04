package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzby {
    public String zzb;
    public String zzc;
    public String zzd;
    public int zza = zzbu.zzg;
    public List<String> zze = Collections.emptyList();
    public List<zzbx> zzf = Collections.emptyList();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzby zza(JsonReader jsonReader) {
        char c2;
        char c3;
        zzby zzbyVar = new zzby();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -2001388947:
                    if (nextName.equals("consent_signal")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1938755376:
                    if (nextName.equals("error_message")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1851537225:
                    if (nextName.equals("consent_form_base_url")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1161803523:
                    if (nextName.equals("actions")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -986806987:
                    if (nextName.equals("request_info_keys")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -790907624:
                    if (nextName.equals("consent_form_payload")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                zzbyVar.zza = zzbu.zzb(jsonReader);
            } else if (c2 == 1) {
                zzbyVar.zzb = jsonReader.nextString();
            } else if (c2 == 2) {
                zzbyVar.zzc = jsonReader.nextString();
            } else if (c2 == 3) {
                zzbyVar.zzd = jsonReader.nextString();
            } else if (c2 == 4) {
                zzbyVar.zze = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    zzbyVar.zze.add(jsonReader.nextString());
                }
                jsonReader.endArray();
            } else if (c2 == 5) {
                zzbyVar.zzf = new ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    zzbx zzbxVar = new zzbx();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode = nextName2.hashCode();
                        if (hashCode != -2105551094) {
                            if (hashCode == 1583758243 && nextName2.equals("action_type")) {
                                c3 = 0;
                            }
                            c3 = 65535;
                        } else {
                            if (nextName2.equals("args_json")) {
                                c3 = 1;
                            }
                            c3 = 65535;
                        }
                        if (c3 == 0) {
                            zzbxVar.zza = zzbu.zza(jsonReader);
                        } else if (c3 == 1) {
                            zzbxVar.zzb = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zzbyVar.zzf.add(zzbxVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return zzbyVar;
    }
}
