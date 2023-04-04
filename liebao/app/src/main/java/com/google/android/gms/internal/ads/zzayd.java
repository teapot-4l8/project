package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayd;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzayd {
    private final AtomicReference<ExecutorService> zzecw = new AtomicReference<>(null);
    private final Object zzecx = new Object();
    private String zzecy = null;
    private String zzecz = null;
    private final AtomicBoolean zzeda = new AtomicBoolean(false);
    private final AtomicInteger zzedb = new AtomicInteger(-1);
    private final AtomicReference<Object> zzedc = new AtomicReference<>(null);
    private final AtomicReference<Object> zzedd = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzede = new ConcurrentHashMap(9);
    private final AtomicReference<zzbha> zzedf = new AtomicReference<>(null);
    private final BlockingQueue<FutureTask<?>> zzedg = new ArrayBlockingQueue(20);
    private final Object zzedh = new Object();
    private boolean zzzq = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zza {
        void zza(zzbha zzbhaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zzb<T> {
        T zzb(zzbha zzbhaVar);
    }

    public final boolean isInitialized() {
        synchronized (this.zzedh) {
        }
        return false;
    }

    public final boolean zzaa(Context context) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcoo)).booleanValue() && !this.zzeda.get()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcoy)).booleanValue()) {
                return true;
            }
            if (this.zzedb.get() == -1) {
                zzww.zzqw();
                if (!zzbae.zzf(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzww.zzqw();
                    if (zzbae.zzbr(context)) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzedb.set(0);
                    }
                }
                this.zzedb.set(1);
            }
            if (this.zzedb.get() == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzab(Context context) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcov)).booleanValue()) {
            if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzww.zzra().zzd(zzabq.zzcow)).intValue()) {
                return false;
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcox)).booleanValue()) {
                try {
                    context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    return false;
                } catch (ClassNotFoundException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final void zza(Context context, zzaat zzaatVar) {
        zzayt.zzaj(context).zzxs().zzb(zzaatVar);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpa)).booleanValue() && zzaa(context) && zzab(context)) {
            synchronized (this.zzedh) {
            }
        }
    }

    public final void zza(Context context, zzvq zzvqVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpa)).booleanValue() && zzaa(context) && zzab(context)) {
            synchronized (this.zzedh) {
            }
        }
    }

    public final void setConsent(Bundle bundle) {
        zza("setConsent", new zza(bundle) { // from class: com.google.android.gms.internal.ads.zzayc
            private final Bundle zzecv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzecv = bundle;
            }

            @Override // com.google.android.gms.internal.ads.zzayd.zza
            public final void zza(zzbha zzbhaVar) {
                zzbhaVar.setConsent(this.zzecv);
            }
        });
    }

    public final void zzd(Context context, String str) {
        if (zzaa(context)) {
            if (zzab(context)) {
                zza("beginAdUnitExposure", new zza(str) { // from class: com.google.android.gms.internal.ads.zzayi
                    private final String zzdmo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdmo = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzayd.zza
                    public final void zza(zzbha zzbhaVar) {
                        zzbhaVar.beginAdUnitExposure(this.zzdmo);
                    }
                });
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzaa(context)) {
            if (zzab(context)) {
                zza("endAdUnitExposure", new zza(str) { // from class: com.google.android.gms.internal.ads.zzayl
                    private final String zzdmo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdmo = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzayd.zza
                    public final void zza(zzbha zzbhaVar) {
                        zzbhaVar.endAdUnitExposure(this.zzdmo);
                    }
                });
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final String zzac(Context context) {
        if (zzaa(context)) {
            if (zzab(context)) {
                return (String) zza("getCurrentScreenNameOrScreenClass", "", zzayk.zzedi);
            }
            if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
                try {
                    String str = (String) zzl(context, "getCurrentScreenName").invoke(this.zzedc.get(), new Object[0]);
                    if (str == null) {
                        str = (String) zzl(context, "getCurrentScreenClass").invoke(this.zzedc.get(), new Object[0]);
                    }
                    return str != null ? str : "";
                } catch (Exception unused) {
                    zzh("getCurrentScreenName", false);
                    return "";
                }
            }
            return "";
        }
        return "";
    }

    @Deprecated
    public final void zzf(Context context, String str) {
        if (zzaa(context) && (context instanceof Activity)) {
            if (zzab(context)) {
                zza("setScreenName", new zza(context, str) { // from class: com.google.android.gms.internal.ads.zzayn
                    private final Context zzdbt;
                    private final String zzdkl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdbt = context;
                        this.zzdkl = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzayd.zza
                    public final void zza(zzbha zzbhaVar) {
                        Context context2 = this.zzdbt;
                        zzbhaVar.zzb(ObjectWrapper.wrap(context2), this.zzdkl, context2.getPackageName());
                    }
                });
            } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzedd, false)) {
                try {
                    zzm(context, "setCurrentScreen").invoke(this.zzedd.get(), (Activity) context, str, context.getPackageName());
                } catch (Exception unused) {
                    zzh("setCurrentScreen", false);
                }
            }
        }
    }

    public final String zzad(Context context) {
        if (zzaa(context)) {
            synchronized (this.zzecx) {
                if (this.zzecy != null) {
                    return this.zzecy;
                }
                if (zzab(context)) {
                    this.zzecy = (String) zza("getGmpAppId", this.zzecy, zzaym.zzedi);
                } else {
                    this.zzecy = (String) zza("getGmpAppId", context);
                }
                return this.zzecy;
            }
        }
        return null;
    }

    public final String zzae(Context context) {
        if (zzaa(context)) {
            long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcot)).longValue();
            if (zzab(context)) {
                try {
                    if (longValue < 0) {
                        return (String) zza("getAppInstanceId", (String) null, zzayp.zzedi);
                    }
                    return (String) zzxv().submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzayo
                        private final zzayd zzedj;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzedj = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzedj.zzxx();
                        }
                    }).get(longValue, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused) {
                    return "TIME_OUT";
                } catch (Exception unused2) {
                    return null;
                }
            } else if (longValue < 0) {
                return (String) zza("getAppInstanceId", context);
            } else {
                try {
                    return (String) zzxv().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.zzayr
                        private final Context zzclh;
                        private final zzayd zzedj;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzedj = this;
                            this.zzclh = context;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzedj.zzai(this.zzclh);
                        }
                    }).get(longValue, TimeUnit.MILLISECONDS);
                } catch (TimeoutException unused3) {
                    return "TIME_OUT";
                } catch (Exception unused4) {
                    return null;
                }
            }
        }
        return null;
    }

    public final String zzaf(Context context) {
        if (zzaa(context)) {
            if (zzab(context)) {
                Long l = (Long) zza("getAdEventId", (String) null, zzayf.zzedi);
                if (l != null) {
                    return Long.toString(l.longValue());
                }
                return null;
            }
            Object zza2 = zza("generateEventId", context);
            if (zza2 != null) {
                return zza2.toString();
            }
            return null;
        }
        return null;
    }

    public final String zzag(Context context) {
        if (zzaa(context)) {
            synchronized (this.zzecx) {
                if (this.zzecz != null) {
                    return this.zzecz;
                }
                if (zzab(context)) {
                    this.zzecz = (String) zza("getAppIdOrigin", this.zzecz, zzaye.zzedi);
                } else {
                    this.zzecz = "fa";
                }
                return this.zzecz;
            }
        }
        return null;
    }

    public final void zzg(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzaa(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, Bundle bundle) {
        if (zzaa(context)) {
            Bundle zzk = zzk(str2, str);
            if (bundle != null) {
                zzk.putAll(bundle);
            }
            if (zzab(context)) {
                zza("logEventInternal", new zza(str, zzk) { // from class: com.google.android.gms.internal.ads.zzayh
                    private final String zzdmo;
                    private final Bundle zzedl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdmo = str;
                        this.zzedl = zzk;
                    }

                    @Override // com.google.android.gms.internal.ads.zzayd.zza
                    public final void zza(zzbha zzbhaVar) {
                        zzbhaVar.logEvent("am", this.zzdmo, this.zzedl);
                    }
                });
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
                try {
                    zzah(context).invoke(this.zzedc.get(), "am", str, zzk);
                } catch (Exception unused) {
                    zzh("logEventInternal", true);
                }
            }
        }
    }

    private static Bundle zzk(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e2) {
            String valueOf = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e2);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method zzah(Context context) {
        Method method = this.zzede.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzede.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh("logEventInternal", true);
            return null;
        }
    }

    private final Method zzk(Context context, String str) {
        Method method = this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzl(Context context, String str) {
        Method method = this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = this.zzede.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzede.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
            try {
                zzk(context, str2).invoke(this.zzedc.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
            } catch (Exception unused) {
                zzh(str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzedc, true)) {
            try {
                return zzl(context, str).invoke(this.zzedc.get(), new Object[0]);
            } catch (Exception unused) {
                zzh(str, true);
                return null;
            }
        }
        return null;
    }

    private final void zzh(String str, boolean z) {
        if (this.zzeda.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
        if (z) {
            com.google.android.gms.ads.internal.util.zzd.zzez("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.zzeda.set(true);
        }
    }

    private final ExecutorService zzxv() {
        ExecutorService threadPoolExecutor;
        if (this.zzecw.get() == null) {
            if (ClientLibraryUtils.isPackageSide()) {
                threadPoolExecutor = zzdxa.zzazw().zza(((Integer) zzww.zzra().zzd(zzabq.zzcou)).intValue(), zzxw(), zzdxj.zzhyj);
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(((Integer) zzww.zzra().zzd(zzabq.zzcou)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzcou)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzxw());
            }
            this.zzecw.compareAndSet(null, threadPoolExecutor);
        }
        return this.zzecw.get();
    }

    private final ThreadFactory zzxw() {
        return new zzayq(this);
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception unused) {
                zzh("getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zza zzaVar) {
        synchronized (this.zzedf) {
            FutureTask<?> futureTask = new FutureTask<>(new Runnable(this, zzaVar, str) { // from class: com.google.android.gms.internal.ads.zzayg
                private final String zzdmx;
                private final zzayd zzedj;
                private final zzayd.zza zzedk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzedj = this;
                    this.zzedk = zzaVar;
                    this.zzdmx = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzedj.zza(this.zzedk, this.zzdmx);
                }
            }, null);
            if (this.zzedf.get() != null) {
                futureTask.run();
            } else {
                this.zzedg.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, T t, zzb<T> zzbVar) {
        synchronized (this.zzedf) {
            if (this.zzedf.get() != null) {
                try {
                    return zzbVar.zzb(this.zzedf.get());
                } catch (Exception unused) {
                    zzh(str, false);
                }
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zza zzaVar, String str) {
        if (this.zzedf.get() != null) {
            try {
                zzaVar.zza(this.zzedf.get());
            } catch (Exception unused) {
                zzh(str, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzai(Context context) {
        return (String) zza("getAppInstanceId", context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzxx() {
        return (String) zza("getAppInstanceId", (String) null, zzayj.zzedi);
    }
}
