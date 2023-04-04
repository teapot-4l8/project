package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import androidx.browser.a.c;
import androidx.core.app.l;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzacs;
import com.google.android.gms.internal.ads.zzads;
import com.google.android.gms.internal.ads.zzava;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzdxi;
import com.google.android.gms.internal.ads.zzebh;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzesm;
import com.google.android.gms.internal.ads.zzww;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzj {
    public static final zzdxi zzegq = new zzg(Looper.getMainLooper());
    private String zzbjd;
    private AtomicReference<Pattern> zzego = new AtomicReference<>(null);
    private AtomicReference<Pattern> zzegp = new AtomicReference<>(null);
    private boolean zzza = true;
    private final Object zzegr = new Object();
    private boolean zzegs = false;
    private boolean zzegt = false;
    private final Executor zzegu = Executors.newSingleThreadExecutor();

    public static int zzdl(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i > 0) {
            StringBuilder sb = new StringBuilder(97);
            sb.append("HTTP timeout too low: ");
            sb.append(i);
            sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
            zzd.zzez(sb.toString());
            return 60000;
        }
        return 60000;
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zzdl = zzdl(i);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(zzdl);
        sb.append(" milliseconds.");
        zzd.zzey(sb.toString());
        httpURLConnection.setConnectTimeout(zzdl);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zzdl);
        httpURLConnection.setRequestProperty("User-Agent", zzq(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static boolean zzp(Context context, String str) {
        Context zzx = zzava.zzx(context);
        return Wrappers.packageManager(zzx).checkPermission(str, zzx.getPackageName()) == 0;
    }

    public static void zzb(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            new zzbq(context, str, (String) obj).zzyx();
        }
    }

    public final zzacs zza(Context context, Uri uri) {
        zzacs zzacsVar;
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            zzd.zzed("Chrome Custom Tabs can only work with version Jellybean onwards.");
            zzacsVar = zzacs.PLATFORM_VERSION_TOO_LOW;
        } else if (context == null) {
            zzd.zzed("Trying to open chrome custom tab on a null context");
            zzacsVar = zzacs.CONTEXT_NULL;
        } else if (!(context instanceof Activity)) {
            zzd.zzed("Chrome Custom Tabs can only work with Activity context.");
            zzacsVar = zzacs.CONTEXT_NOT_AN_ACTIVITY;
        } else if (zzesm.zzcp(context) == null) {
            zzd.zzed("Default browser does not support custom tabs.");
            zzacsVar = zzacs.CCT_NOT_SUPPORTED;
        } else {
            zzacsVar = null;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvn)).equals(zzww.zzra().zzd(zzabq.zzcvo))) {
            zzacsVar = zzacs.WRONG_EXP_SETUP;
        }
        if (zzacsVar != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return zzacsVar;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvn)).booleanValue()) {
            zzacq zzacqVar = new zzacq();
            zzacqVar.zza(new zzo(this, zzacqVar, context, uri));
            zzacqVar.zzd((Activity) context);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvo)).booleanValue()) {
            new c.a().a().a(context, uri);
        }
        return zzacs.CCT_READY_TO_OPEN;
    }

    public static String zza(InputStreamReader inputStreamReader) {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean zzan(Context context) {
        if (this.zzegs) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new zzs(this, null), intentFilter);
        this.zzegs = true;
        return true;
    }

    public final boolean zzao(Context context) {
        if (this.zzegt) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new zzp(this, null), intentFilter);
        this.zzegt = true;
        return true;
    }

    private static String zzzq() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public final String zzq(Context context, String str) {
        synchronized (this.zzegr) {
            if (this.zzbjd != null) {
                return this.zzbjd;
            } else if (str == null) {
                return zzzq();
            } else {
                try {
                    this.zzbjd = com.google.android.gms.ads.internal.zzr.zzkx().getDefaultUserAgent(context);
                } catch (Exception unused) {
                }
                if (TextUtils.isEmpty(this.zzbjd)) {
                    zzww.zzqw();
                    if (!zzbae.zzaaq()) {
                        this.zzbjd = null;
                        zzegq.post(new zzn(this, context));
                        while (this.zzbjd == null) {
                            try {
                                this.zzegr.wait();
                            } catch (InterruptedException unused2) {
                                String zzzq = zzzq();
                                this.zzbjd = zzzq;
                                String valueOf = String.valueOf(zzzq);
                                zzd.zzez(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                            }
                        }
                    } else {
                        this.zzbjd = zzap(context);
                    }
                }
                String valueOf2 = String.valueOf(this.zzbjd);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
                sb.append(valueOf2);
                sb.append(" (Mobile; ");
                sb.append(str);
                this.zzbjd = sb.toString();
                try {
                    if (Wrappers.packageManager(context).isCallerInstantApp()) {
                        this.zzbjd = String.valueOf(this.zzbjd).concat(";aia");
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AdUtil.getUserAgent");
                }
                String concat = String.valueOf(this.zzbjd).concat(")");
                this.zzbjd = concat;
                return concat;
            }
        }
    }

    public static String zzap(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return zzzq();
        }
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, List<String> list) {
        for (String str : list) {
            if (Class.forName(str, false, classLoader).isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final JSONObject zzj(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zza(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final JSONObject zza(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzc(bundle);
            } catch (JSONException e2) {
                zzd.zzc("Error converting Bundle to JSON", e2);
            }
        }
        return null;
    }

    public final JSONObject zzc(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zza(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    private final JSONArray zza(Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            zza(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void zza(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzj((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                zza(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void zza(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzj((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, zza((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, zza(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static Map<String, String> zzg(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
        }
        return hashMap;
    }

    public final zzebt<Map<String, String>> zzh(Uri uri) {
        return zzebh.zza(new Callable(uri) { // from class: com.google.android.gms.ads.internal.util.zzm
            private final Uri zzegv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzegv = uri;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzj.zzi(this.zzegv);
            }
        }, this.zzegu);
    }

    public static String zzzr() {
        return UUID.randomUUID().toString();
    }

    public static int zzei(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzd.zzez(sb.toString());
            return 0;
        }
    }

    public static String zzzs() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    private static int[] zzzt() {
        return new int[]{0, 0};
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzzt() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        return new int[]{zzww.zzqw().zzd(activity, zzf[0]), zzww.zzqw().zzd(activity, zzf[1])};
    }

    public static int[] zzh(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] zzzt = (window == null || (findViewById = window.findViewById(16908290)) == null) ? zzzt() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        return new int[]{zzww.zzqw().zzd(activity, zzzt[0]), zzww.zzqw().zzd(activity, zzzt[1])};
    }

    public static boolean zzej(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static AlertDialog.Builder zzaq(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static AlertDialog.Builder zzc(Context context, int i) {
        return new AlertDialog.Builder(context, i);
    }

    public static zzabb zzar(Context context) {
        return new zzabb(context);
    }

    public static Bitmap zzm(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static PopupWindow zza(View view, int i, int i2, boolean z) {
        return new PopupWindow(view, i, i2, false);
    }

    public static String zzas(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && runningTaskInfo.topActivity != null) {
                return runningTaskInfo.topActivity.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean zzat(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public final void zza(Context context, String str, String str2, Bundle bundle, boolean z) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        bundle.putString("device", zzzs());
        bundle.putString("eids", TextUtils.join(",", zzabq.zzsi()));
        zzww.zzqw();
        zzbae.zza(context, str, str2, bundle, true, new zzq(this, context, str));
    }

    public static void zzc(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzbat.zzeke.execute(runnable);
        }
    }

    public static Bitmap zzn(View view) {
        if (view == null) {
            return null;
        }
        Bitmap zzp = zzp(view);
        return zzp == null ? zzo(view) : zzp;
    }

    private static Bitmap zzo(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzd.zzez("Width or height of view is zero");
            return null;
        } catch (RuntimeException e2) {
            zzd.zzc("Fail to capture the webview", e2);
            return null;
        }
    }

    private static Bitmap zzp(View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e2) {
            zzd.zzc("Fail to capture the web view", e2);
        }
        return r0;
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static int zzau(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, zzav(context));
    }

    private static KeyguardManager zzav(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    public static boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!com.google.android.gms.ads.internal.zzr.zzkv().zzza) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !zzq(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrf)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcrf)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zzq(View view) {
        Activity activity;
        View rootView = view.getRootView();
        if (rootView != null) {
            Context context = rootView.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
                if (activity != null) {
                    return false;
                }
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
                return (attributes == null || (attributes.flags & 524288) == 0) ? false : true;
            }
        }
        activity = null;
        if (activity != null) {
        }
    }

    public static boolean zzaw(Context context) {
        KeyguardManager zzav;
        return context != null && PlatformVersion.isAtLeastJellyBean() && (zzav = zzav(context)) != null && zzav.isKeyguardLocked();
    }

    public static int zzr(View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean zzs(View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof ScrollView)) {
            parent = parent.getParent();
        }
        return parent != null;
    }

    public static boolean zzax(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzd.zzc("Error loading class.", th);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static void zzb(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzd.zzdz(sb.toString());
        } catch (ActivityNotFoundException e2) {
            zzd.zzc("No browser is found.", e2);
        }
    }

    public static void zzb(Context context, Intent intent) {
        if (intent != null && PlatformVersion.isAtLeastJellyBeanMR2()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder("android.support.customtabs.extra.SESSION", null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static void zzc(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e2) {
            zzd.zzc("Error writing to file in internal storage.", e2);
        }
    }

    public static String zzr(Context context, String str) {
        try {
            return new String(IOUtils.readInputStreamFully(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzd.zzdz("Error reading from internal storage.");
            return "";
        }
    }

    public final boolean zzek(String str) {
        return zza(str, this.zzego, (String) zzww.zzra().zzd(zzabq.zzcop));
    }

    public final boolean zzel(String str) {
        return zza(str, this.zzegp, (String) zzww.zzra().zzd(zzabq.zzcoq));
    }

    private static boolean zza(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    public static String zzzu() {
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkz().getResources();
        return resources != null ? resources.getString(R.string.s7) : "Test Ad";
    }

    public static WebResourceResponse zzd(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzr.zzkv().zzq(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = new zzay(context).zzb(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
            zzd.zzd("Could not fetch MRAID JS.", e2);
            return null;
        }
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        String contentType = httpURLConnection.getContentType();
        String str = "";
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        com.google.android.gms.ads.internal.zzr.zzkv();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    if (split[i].trim().startsWith("charset")) {
                        String[] split2 = split[i].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        String str2 = str;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return com.google.android.gms.ads.internal.zzr.zzkx().zza(trim, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    public static void zza(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = zzads.zzdfq.get().booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            CrashUtils.addDynamiteErrorToDropBox(context, th);
        }
    }

    public static String zzay(Context context) {
        return !((Boolean) zzww.zzra().zzd(zzabq.zzcym)).booleanValue() ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    public static Bundle zzaz(Context context) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyn)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Bundle bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
            return bundle;
        }
        return null;
    }

    public static boolean zzba(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzem(String str) {
        if (zzbai.isEnabled()) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwd)).booleanValue()) {
                String str2 = (String) zzww.zzra().zzd(zzabq.zzcwf);
                if (!str2.isEmpty()) {
                    for (String str3 : str2.split(";")) {
                        if (str3.equals(str)) {
                            return false;
                        }
                    }
                }
                String str4 = (String) zzww.zzra().zzd(zzabq.zzcwe);
                if (str4.isEmpty()) {
                    return true;
                }
                for (String str5 : str4.split(";")) {
                    if (str5.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static String zzbb(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzd(getMetadata(context));
    }

    public static boolean zzbc(Context context) {
        Bundle metadata = getMetadata(context);
        return TextUtils.isEmpty(zzd(metadata)) && !TextUtils.isEmpty(metadata.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    private static String zzd(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return TextUtils.isEmpty(string) ? "" : (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "";
    }

    private static Bundle getMetadata(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            zzd.zza("Error getting metadata", e2);
            return null;
        }
    }

    public static boolean zzbd(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void zzbe(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static boolean zzbf(Context context) {
        return l.a(context).a();
    }

    public static zzbg zzbg(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzd.zzex("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbg) {
                return (zzbg) queryLocalInterface;
            }
            return new zzbi(iBinder);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static void zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
    }

    public static final /* synthetic */ Map zzi(Uri uri) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        return zzg(uri);
    }
}
