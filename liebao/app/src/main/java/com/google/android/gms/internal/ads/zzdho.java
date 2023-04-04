package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdho implements zzdhe<zzdhl> {
    private final Context context;
    private final zzebs zzgka;

    public zzdho(zzebs zzebsVar, Context context) {
        this.zzgka = zzebsVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhl> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdhn
            private final zzdho zzhgv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhgv = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhgv.zzaur();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ zzdhl zzaur() {
        int networkType;
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        if (PlatformVersion.isAtLeastR()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbg)).booleanValue()) {
                networkType = 0;
                int phoneType = telephonyManager.getPhoneType();
                com.google.android.gms.ads.internal.zzr.zzkv();
                int i4 = -1;
                if (com.google.android.gms.ads.internal.util.zzj.zzp(this.context, "android.permission.ACCESS_NETWORK_STATE")) {
                    i = -2;
                    z = false;
                    i2 = -1;
                } else {
                    ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        i4 = activeNetworkInfo.getType();
                        i3 = activeNetworkInfo.getDetailedState().ordinal();
                    } else {
                        i3 = -1;
                    }
                    i2 = i3;
                    i = i4;
                    z = connectivityManager.isActiveNetworkMetered();
                }
                return new zzdhl(networkOperator, i, networkType, phoneType, z, i2);
            }
        }
        networkType = telephonyManager.getNetworkType();
        int phoneType2 = telephonyManager.getPhoneType();
        com.google.android.gms.ads.internal.zzr.zzkv();
        int i42 = -1;
        if (com.google.android.gms.ads.internal.util.zzj.zzp(this.context, "android.permission.ACCESS_NETWORK_STATE")) {
        }
        return new zzdhl(networkOperator, i, networkType, phoneType2, z, i2);
    }
}
