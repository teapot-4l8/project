package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzdbs {
    private String zzhcu;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza {
        private String zzhcu;

        public final zza zzgs(String str) {
            this.zzhcu = str;
            return this;
        }
    }

    private zzdbs(zza zzaVar) {
        this.zzhcu = zzaVar.zzhcu;
    }

    public final Set<String> zzatr() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzhcu.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzats() {
        return this.zzhcu.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final zzuh.zza.EnumC0120zza zzatt() {
        char c2;
        String str = this.zzhcu;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 == 3) {
                        return zzuh.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD;
                    }
                    return zzuh.zza.EnumC0120zza.AD_INITIATER_UNSPECIFIED;
                }
                return zzuh.zza.EnumC0120zza.AD_LOADER;
            }
            return zzuh.zza.EnumC0120zza.INTERSTITIAL;
        }
        return zzuh.zza.EnumC0120zza.BANNER;
    }
}
