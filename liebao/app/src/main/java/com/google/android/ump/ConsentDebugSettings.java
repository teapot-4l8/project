package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzbz;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public class ConsentDebugSettings {
    private final boolean zza;
    private final int zzb;

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    private ConsentDebugSettings(boolean z, Builder builder) {
        this.zza = z;
        this.zzb = builder.zzc;
    }

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private final Context zzb;
        private boolean zzd;
        private final List<String> zza = new ArrayList();
        private int zzc = 0;

        public Builder(Context context) {
            this.zzb = context.getApplicationContext();
        }

        public Builder setDebugGeography(int i) {
            this.zzc = i;
            return this;
        }

        public Builder addTestDeviceHashedId(String str) {
            this.zza.add(str);
            return this;
        }

        public Builder setForceTesting(boolean z) {
            this.zzd = z;
            return this;
        }

        public ConsentDebugSettings build() {
            boolean z = false;
            return new ConsentDebugSettings(((zzbz.zza() || this.zza.contains(zzbz.zza(this.zzb))) || this.zzd) ? true : true, this);
        }
    }

    public boolean isTestDevice() {
        return this.zza;
    }

    public int getDebugGeography() {
        return this.zzb;
    }
}
