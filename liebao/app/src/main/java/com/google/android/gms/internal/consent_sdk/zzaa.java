package com.google.android.gms.internal.consent_sdk;

import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzaa {
    private final zzz zza;
    private final zzby zzb;
    private int zzc = 0;
    private int zzd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzz zzzVar, zzby zzbyVar) {
        this.zza = zzzVar;
        this.zzb = zzbyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzy zza() {
        zzal zzalVar;
        String str;
        zze zzeVar;
        zzaj zzajVar;
        switch (zzx.zza[this.zzb.zza - 1]) {
            case 1:
                this.zzc = 1;
                this.zzd = 0;
                break;
            case 2:
                this.zzc = 2;
                this.zzd = 0;
                break;
            case 3:
                this.zzc = 3;
                this.zzd = 2;
                break;
            case 4:
                this.zzc = 3;
                this.zzd = 1;
                break;
            case 5:
                this.zzc = 3;
                this.zzd = 0;
                break;
            case 6:
                String valueOf = String.valueOf(this.zzb.zzd);
                throw new zzk(1, valueOf.length() != 0 ? "Invalid response from server: ".concat(valueOf) : new String("Invalid response from server: "));
            case 7:
                String valueOf2 = String.valueOf(this.zzb.zzd);
                throw new zzk(3, valueOf2.length() != 0 ? "Publisher misconfiguration: ".concat(valueOf2) : new String("Publisher misconfiguration: "));
            default:
                throw new zzk(1, "Invalid response from server.");
        }
        String str2 = this.zzb.zzb;
        zzbb zzbbVar = str2 == null ? null : new zzbb(this.zzb.zzc, str2);
        zzalVar = this.zza.zzc;
        zzalVar.zza(new HashSet(this.zzb.zze));
        for (zzbx zzbxVar : this.zzb.zzf) {
            int i = zzx.zzb[zzbxVar.zza - 1];
            if (i != 1) {
                if (i == 2) {
                    str = "write";
                } else if (i == 3) {
                    str = "clear";
                }
                if (str == null) {
                    zzeVar = this.zza.zza;
                    String str3 = zzbxVar.zzb;
                    zzajVar = this.zza.zzb;
                    zzeVar.zza(str, str3, zzajVar);
                }
            }
            str = null;
            if (str == null) {
            }
        }
        return new zzy(this.zzc, this.zzd, zzbbVar, null);
    }
}
