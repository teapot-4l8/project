package com.google.android.gms.internal.consent_sdk;

import android.util.JsonWriter;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public enum zzbs {
    DEBUG_PARAM_UNKNOWN,
    ALWAYS_SHOW,
    GEO_OVERRIDE_EEA,
    GEO_OVERRIDE_NON_EEA;

    public final void zza(JsonWriter jsonWriter) {
        int i = zzbq.zzb[ordinal()];
        if (i == 1) {
            jsonWriter.value("DEBUG_PARAM_UNKNOWN");
        } else if (i == 2) {
            jsonWriter.value("ALWAYS_SHOW");
        } else if (i == 3) {
            jsonWriter.value("GEO_OVERRIDE_EEA");
        } else if (i != 4) {
        } else {
            jsonWriter.value("GEO_OVERRIDE_NON_EEA");
        }
    }
}
