package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.content.a.a;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzl {
    private final zzn zza;
    private final Activity zzb;
    private final ConsentDebugSettings zzc;
    private final ConsentRequestParameters zzd;

    /* JADX INFO: Access modifiers changed from: private */
    public zzl(zzn zznVar, Activity activity, ConsentDebugSettings consentDebugSettings, ConsentRequestParameters consentRequestParameters) {
        this.zza = zznVar;
        this.zzb = activity;
        this.zzc = consentDebugSettings;
        this.zzd = consentRequestParameters;
    }

    public final zzbn zza() {
        zzb zzbVar;
        List<zzbs> arrayList;
        Application application;
        zzal zzalVar;
        String locale;
        Application application2;
        Application application3;
        Application application4;
        List<zzbw> list;
        String str;
        zzbn zzbnVar = new zzbn();
        zzbnVar.zza = zzc();
        zzbVar = this.zza.zzb;
        zza zza = zzbVar.zza();
        if (zza != null) {
            zzbnVar.zzb = zza.zza;
            zzbnVar.zzi = Boolean.valueOf(zza.zzb);
        }
        if (!this.zzc.isTestDevice()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList<>();
            int debugGeography = this.zzc.getDebugGeography();
            if (debugGeography == 1) {
                arrayList.add(zzbs.GEO_OVERRIDE_EEA);
            } else if (debugGeography == 2) {
                arrayList.add(zzbs.GEO_OVERRIDE_NON_EEA);
            }
        }
        zzbnVar.zzn = arrayList;
        application = this.zza.zza;
        zzalVar = this.zza.zzc;
        Set<String> zzc = zzalVar.zzc();
        HashMap hashMap = new HashMap();
        for (String str2 : zzc) {
            zzcb zza2 = zzcc.zza(application, str2);
            if (zza2 == null) {
                String valueOf = String.valueOf(str2);
                Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Fetching request info: failed for key: ".concat(valueOf) : new String("Fetching request info: failed for key: "));
            } else {
                Object obj = application.getSharedPreferences(zza2.zza, 0).getAll().get(zza2.zzb);
                if (obj == null) {
                    String valueOf2 = String.valueOf(str2);
                    Log.d("UserMessagingPlatform", valueOf2.length() != 0 ? "Stored info not exists: ".concat(valueOf2) : new String("Stored info not exists: "));
                } else {
                    if (obj instanceof Boolean) {
                        str = ((Boolean) obj).booleanValue() ? "1" : "0";
                    } else if (obj instanceof Number) {
                        str = obj.toString();
                    } else if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        String valueOf3 = String.valueOf(str2);
                        Log.d("UserMessagingPlatform", valueOf3.length() != 0 ? "Failed to fetch stored info: ".concat(valueOf3) : new String("Failed to fetch stored info: "));
                    }
                    hashMap.put(str2, str);
                }
            }
        }
        zzbnVar.zzj = hashMap;
        zzbnVar.zzd = null;
        zzbnVar.zzg = null;
        zzbnVar.zzh = Boolean.valueOf(this.zzd.isTagForUnderAgeOfConsent());
        zzbnVar.zzf = null;
        if (Build.VERSION.SDK_INT >= 21) {
            locale = Locale.getDefault().toLanguageTag();
        } else {
            locale = Locale.getDefault().toString();
        }
        zzbnVar.zze = locale;
        zzbr zzbrVar = new zzbr();
        zzbrVar.zzc = Integer.valueOf(Build.VERSION.SDK_INT);
        zzbrVar.zzb = Build.MODEL;
        zzbrVar.zza = zzbu.zzb;
        zzbnVar.zzc = zzbrVar;
        application2 = this.zza.zza;
        Configuration configuration = application2.getResources().getConfiguration();
        application3 = this.zza.zza;
        application3.getResources().getConfiguration();
        zzbt zzbtVar = new zzbt();
        zzbtVar.zza = Integer.valueOf(configuration.screenWidthDp);
        zzbtVar.zzb = Integer.valueOf(configuration.screenHeightDp);
        application4 = this.zza.zza;
        zzbtVar.zzc = Double.valueOf(application4.getResources().getDisplayMetrics().density);
        if (Build.VERSION.SDK_INT < 28) {
            list = Collections.emptyList();
        } else {
            Activity activity = this.zzb;
            Window window = activity == null ? null : activity.getWindow();
            View decorView = window == null ? null : window.getDecorView();
            WindowInsets rootWindowInsets = decorView == null ? null : decorView.getRootWindowInsets();
            DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
            if (displayCutout == null) {
                list = Collections.emptyList();
            } else {
                displayCutout.getSafeInsetBottom();
                ArrayList arrayList2 = new ArrayList();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    if (rect != null) {
                        zzbw zzbwVar = new zzbw();
                        zzbwVar.zzb = Integer.valueOf(rect.left);
                        zzbwVar.zzc = Integer.valueOf(rect.right);
                        zzbwVar.zza = Integer.valueOf(rect.top);
                        zzbwVar.zzd = Integer.valueOf(rect.bottom);
                        arrayList2.add(zzbwVar);
                    }
                }
                list = arrayList2;
            }
        }
        zzbtVar.zzd = list;
        zzbnVar.zzk = zzbtVar;
        zzbnVar.zzl = zzb();
        zzbv zzbvVar = new zzbv();
        zzbvVar.zza = "1.0.0";
        zzbnVar.zzm = zzbvVar;
        return zzbnVar;
    }

    private final zzbp zzb() {
        Application application;
        PackageInfo packageInfo;
        Application application2;
        Application application3;
        Application application4;
        application = this.zza.zza;
        try {
            application4 = this.zza.zza;
            packageInfo = application4.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        zzbp zzbpVar = new zzbp();
        zzbpVar.zza = application.getPackageName();
        application2 = this.zza.zza;
        PackageManager packageManager = application2.getPackageManager();
        application3 = this.zza.zza;
        CharSequence applicationLabel = packageManager.getApplicationLabel(application3.getApplicationInfo());
        zzbpVar.zzb = applicationLabel != null ? applicationLabel.toString() : null;
        if (packageInfo != null) {
            zzbpVar.zzc = Long.toString(a.a(packageInfo));
        }
        return zzbpVar;
    }

    private final String zzc() {
        Application application;
        Application application2;
        String zza = this.zzd.zza();
        if (TextUtils.isEmpty(zza)) {
            Bundle bundle = null;
            try {
                application = this.zza.zza;
                PackageManager packageManager = application.getPackageManager();
                application2 = this.zza.zza;
                bundle = packageManager.getApplicationInfo(application2.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (bundle != null) {
                zza = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
            }
            if (TextUtils.isEmpty(zza)) {
                throw new zzk(3, "The UMP SDK requires a valid application ID in your AndroidManifest.xml through a com.google.android.gms.ads.APPLICATION_ID meta-data tag.\nExample AndroidManifest:\n    <meta-data\n        android:name=\"com.google.android.gms.ads.APPLICATION_ID\"\n        android:value=\"ca-app-pub-0000000000000000~0000000000\">");
            }
            return zza;
        }
        return zza;
    }
}
