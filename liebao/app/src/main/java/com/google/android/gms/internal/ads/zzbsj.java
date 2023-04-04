package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbsj {
    private final Context context;
    private final zzdpm zzfzg;
    private Bundle zzgbd;
    private final String zzgbe;
    private final zzdph zzgbf;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza {
        private Context context;
        private zzdpm zzfzg;
        private Bundle zzgbd;
        private String zzgbe;
        private zzdph zzgbf;

        public final zza zzci(Context context) {
            this.context = context;
            return this;
        }

        public final zza zza(zzdpm zzdpmVar) {
            this.zzfzg = zzdpmVar;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzgbd = bundle;
            return this;
        }

        public final zza zzft(String str) {
            this.zzgbe = str;
            return this;
        }

        public final zzbsj zzami() {
            return new zzbsj(this);
        }

        public final zza zza(zzdph zzdphVar) {
            this.zzgbf = zzdphVar;
            return this;
        }
    }

    private zzbsj(zza zzaVar) {
        this.context = zzaVar.context;
        this.zzfzg = zzaVar.zzfzg;
        this.zzgbd = zzaVar.zzgbd;
        this.zzgbe = zzaVar.zzgbe;
        this.zzgbf = zzaVar.zzgbf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza zzame() {
        return new zza().zzci(this.context).zza(this.zzfzg).zzft(this.zzgbe).zze(this.zzgbd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdpm zzamf() {
        return this.zzfzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdph zzamg() {
        return this.zzgbf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzamh() {
        return this.zzgbd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zzch(Context context) {
        return this.zzgbe != null ? context : this.context;
    }
}
