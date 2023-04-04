package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzuh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcru {
    private static final SparseArray<zzuh.zzo.zzb> zzgtt;
    private final Context context;
    private final com.google.android.gms.ads.internal.util.zzf zzeci;
    private final zzbsc zzfzn;
    private final zzcrr zzgqu;
    private final TelephonyManager zzgtq;
    private final zzcrl zzgtr;
    private zzur zzgts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcru(Context context, zzbsc zzbscVar, zzcrr zzcrrVar, zzcrl zzcrlVar, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.context = context;
        this.zzfzn = zzbscVar;
        this.zzgqu = zzcrrVar;
        this.zzgtr = zzcrlVar;
        this.zzgtq = (TelephonyManager) context.getSystemService("phone");
        this.zzeci = zzfVar;
    }

    private static zzur zzbn(boolean z) {
        return z ? zzur.ENUM_TRUE : zzur.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzuh.zzm zzj(Bundle bundle) {
        zzuh.zzm.zzb zzbVar;
        zzuh.zzm.zza zzov = zzuh.zzm.zzov();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzgts = zzur.ENUM_TRUE;
        } else {
            this.zzgts = zzur.ENUM_FALSE;
            if (i == 0) {
                zzov.zza(zzuh.zzm.zzc.CELL);
            } else if (i == 1) {
                zzov.zza(zzuh.zzm.zzc.WIFI);
            } else {
                zzov.zza(zzuh.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzuh.zzm.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzuh.zzm.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzuh.zzm.zzb.LTE;
                    break;
                default:
                    zzbVar = zzuh.zzm.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzov.zza(zzbVar);
        }
        return (zzuh.zzm) ((zzena) zzov.zzbjv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzuh.zzo.zzb zzk(Bundle bundle) {
        return zzgtt.get(zzdpw.zza(zzdpw.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzuh.zzo.zzb.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<zzuh.zzc.zza> zzl(Bundle bundle) {
        List<String> emptyList;
        List asList;
        zzuh.zzc.zza zzaVar;
        Object obj = bundle.get("ad_types");
        if (obj instanceof List) {
            asList = (List) obj;
        } else if (obj instanceof String[]) {
            asList = Arrays.asList((String[]) obj);
        } else {
            emptyList = Collections.emptyList();
            ArrayList<zzuh.zzc.zza> arrayList = new ArrayList<>();
            for (String str : emptyList) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1396342996:
                        if (str.equals("banner")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (str.equals("native")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -239580146:
                        if (str.equals("rewarded")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str.equals("interstitial")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    zzaVar = zzuh.zzc.zza.BANNER;
                } else if (c2 == 1) {
                    zzaVar = zzuh.zzc.zza.INTERSTITIAL;
                } else if (c2 == 2) {
                    zzaVar = zzuh.zzc.zza.NATIVE_APP_INSTALL;
                } else if (c2 == 3) {
                    zzaVar = zzuh.zzc.zza.REWARD_BASED_VIDEO_AD;
                } else {
                    zzaVar = zzuh.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                }
                arrayList.add(zzaVar);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(asList.size());
        for (Object obj2 : asList) {
            if (obj2 instanceof String) {
                arrayList2.add((String) obj2);
            }
        }
        emptyList = Collections.unmodifiableList(arrayList2);
        ArrayList<zzuh.zzc.zza> arrayList3 = new ArrayList<>();
        while (r7.hasNext()) {
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzuh.zzc.zza> arrayList, zzuh.zzm zzmVar, zzuh.zzo.zzb zzbVar) {
        return ((zzuh.zzo.zza) ((zzena) zzuh.zzo.zza.zzpk().zze(arrayList).zzh(zzbn(com.google.android.gms.ads.internal.zzr.zzkx().zzb(this.context.getContentResolver()) != 0)).zzi(com.google.android.gms.ads.internal.zzr.zzkx().zza(this.context, this.zzgtq)).zzet(this.zzgqu.zzpa()).zzeu(this.zzgqu.zzpb()).zzcm(this.zzgqu.getResponseCode()).zzb(zzbVar).zzb(zzmVar).zzj(this.zzgts).zzf(zzbn(z)).zzes(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()).zzg(zzbn(com.google.android.gms.ads.internal.zzr.zzkx().zza(this.context.getContentResolver()) != 0)).zzbjv())).toByteArray();
    }

    public final void zzbm(boolean z) {
        zzebh.zza(this.zzfzn.zzamc(), new zzcrx(this, z), zzbat.zzekj);
    }

    static {
        SparseArray<zzuh.zzo.zzb> sparseArray = new SparseArray<>();
        zzgtt = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzuh.zzo.zzb.CONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzuh.zzo.zzb.CONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzuh.zzo.zzb.DISCONNECTING);
        zzgtt.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzuh.zzo.zzb.DISCONNECTED);
        zzgtt.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzuh.zzo.zzb.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzgtt.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzuh.zzo.zzb.CONNECTING);
        }
        zzgtt.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzuh.zzo.zzb.CONNECTING);
    }
}
