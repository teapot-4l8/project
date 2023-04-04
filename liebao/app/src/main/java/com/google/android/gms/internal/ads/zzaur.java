package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaur {
    private float zzbsn;
    private int zzdrr;
    private int zzdrs;
    private int zzdyx;
    private boolean zzdyy;
    private boolean zzdyz;
    private String zzdza;
    private String zzdzb;
    private boolean zzdzc;
    private final boolean zzdzd;
    private boolean zzdze;
    private boolean zzdzf;
    private boolean zzdzg;
    private String zzdzh;
    private String zzdzi;
    private String zzdzj;
    private int zzdzk;
    private int zzdzl;
    private int zzdzm;
    private int zzdzn;
    private int zzdzo;
    private int zzdzp;
    private double zzdzq;
    private boolean zzdzr;
    private boolean zzdzs;
    private int zzdzt;
    private String zzdzu;
    private String zzdzv;
    private boolean zzdzw;

    public zzaur(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzs(context);
        zzt(context);
        zzu(context);
        Locale locale = Locale.getDefault();
        this.zzdyy = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdyz = zza(packageManager, "http://www.google.com") != null;
        this.zzdzb = locale.getCountry();
        zzww.zzqw();
        this.zzdzc = zzbae.zzaap();
        this.zzdzd = DeviceProperties.isLatchsky(context);
        this.zzdze = DeviceProperties.isSidewinder(context);
        this.zzdzh = locale.getLanguage();
        this.zzdzi = zza(context, packageManager);
        this.zzdzj = zzv(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.zzbsn = displayMetrics.density;
        this.zzdrr = displayMetrics.widthPixels;
        this.zzdrs = displayMetrics.heightPixels;
    }

    public zzaur(Context context, zzauo zzauoVar) {
        zzs(context);
        zzt(context);
        zzu(context);
        this.zzdzu = Build.FINGERPRINT;
        this.zzdzv = Build.DEVICE;
        this.zzdzw = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(context);
        this.zzdyy = zzauoVar.zzdyy;
        this.zzdyz = zzauoVar.zzdyz;
        this.zzdzb = zzauoVar.zzdzb;
        this.zzdzc = zzauoVar.zzdzc;
        this.zzdzd = zzauoVar.zzdzd;
        this.zzdze = zzauoVar.zzdze;
        this.zzdzh = zzauoVar.zzdzh;
        this.zzdzi = zzauoVar.zzdzi;
        this.zzdzj = zzauoVar.zzdzj;
        this.zzbsn = zzauoVar.zzbsn;
        this.zzdrr = zzauoVar.zzdrr;
        this.zzdrs = zzauoVar.zzdrs;
    }

    private final void zzs(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdyx = audioManager.getMode();
                this.zzdzf = audioManager.isMusicActive();
                this.zzdzg = audioManager.isSpeakerphoneOn();
                this.zzdzk = audioManager.getStreamVolume(3);
                this.zzdzo = audioManager.getRingerMode();
                this.zzdzp = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdyx = -2;
        this.zzdzf = false;
        this.zzdzg = false;
        this.zzdzk = 0;
        this.zzdzo = 2;
        this.zzdzp = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzt(Context context) {
        int networkType;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdza = telephonyManager.getNetworkOperator();
        if (PlatformVersion.isAtLeastR()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbg)).booleanValue()) {
                networkType = 0;
                this.zzdzm = networkType;
                this.zzdzn = telephonyManager.getPhoneType();
                this.zzdzl = -2;
                this.zzdzs = false;
                this.zzdzt = -1;
                com.google.android.gms.ads.internal.zzr.zzkv();
                if (com.google.android.gms.ads.internal.util.zzj.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzdzl = activeNetworkInfo.getType();
                    this.zzdzt = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzdzl = -1;
                }
                this.zzdzs = connectivityManager.isActiveNetworkMetered();
                return;
            }
        }
        networkType = telephonyManager.getNetworkType();
        this.zzdzm = networkType;
        this.zzdzn = telephonyManager.getPhoneType();
        this.zzdzl = -2;
        this.zzdzs = false;
        this.zzdzt = -1;
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
        }
    }

    private final void zzu(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdzq = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            this.zzdzr = (intExtra == 2 || intExtra == 5) ? true : true;
            return;
        }
        this.zzdzq = -1.0d;
        this.zzdzr = false;
    }

    private static String zzv(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzauo zzxd() {
        return new zzauo(this.zzdyx, this.zzdyy, this.zzdyz, this.zzdza, this.zzdzb, this.zzdzc, this.zzdzd, this.zzdze, this.zzdzf, this.zzdzg, this.zzdzh, this.zzdzi, this.zzdzj, this.zzdzk, this.zzdzl, this.zzdzm, this.zzdzn, this.zzdzo, this.zzdzp, this.zzbsn, this.zzdrr, this.zzdrs, this.zzdzq, this.zzdzr, this.zzdzs, this.zzdzt, this.zzdzu, this.zzdzw, this.zzdzv);
    }
}
