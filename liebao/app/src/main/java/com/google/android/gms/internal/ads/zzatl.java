package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.umeng.analytics.pro.ak;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzatl implements zzatp {
    private static final Object lock = new Object();
    private static zzatp zzdve = null;
    private static zzatp zzdvf = null;
    private final Context zzcmo;
    private final Object zzdvg;
    private final WeakHashMap<Thread, Boolean> zzdvh;
    private final zzbar zzdvi;
    private final ExecutorService zzzd;

    public static zzatp zzq(Context context) {
        synchronized (lock) {
            if (zzdve == null) {
                if (zzads.zzdft.get().booleanValue()) {
                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzdad)).booleanValue()) {
                        zzdve = new zzatl(context);
                    }
                }
                zzdve = new zzato();
            }
        }
        return zzdve;
    }

    public static zzatp zzc(Context context, zzbar zzbarVar) {
        synchronized (lock) {
            if (zzdvf == null) {
                if (zzads.zzdft.get().booleanValue()) {
                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzdad)).booleanValue()) {
                        zzatl zzatlVar = new zzatl(context, zzbarVar);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzatlVar.zzdvg) {
                                zzatlVar.zzdvh.put(thread, true);
                            }
                            thread.setUncaughtExceptionHandler(new zzatm(zzatlVar, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzatn(zzatlVar, Thread.getDefaultUncaughtExceptionHandler()));
                        zzdvf = zzatlVar;
                    }
                }
                zzdvf = new zzato();
            }
        }
        return zzdvf;
    }

    private zzatl(Context context) {
        this(context, zzbar.zzaau());
    }

    private zzatl(Context context, zzbar zzbarVar) {
        this.zzdvg = new Object();
        this.zzdvh = new WeakHashMap<>();
        this.zzzd = zzdxa.zzazw().zzet(zzdxj.zzhyj);
        this.zzcmo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdvi = zzbarVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x003b, code lost:
        if (r3 == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace;
        boolean z = true;
        if (th != null) {
            boolean z2 = false;
            boolean z3 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (zzbae.zzet(stackTraceElement.getClassName())) {
                        z2 = true;
                    }
                    if (getClass().getName().equals(stackTraceElement.getClassName())) {
                        z3 = true;
                    }
                }
            }
            if (z2) {
            }
        }
        z = false;
        if (z) {
            zza(th, "", 1.0f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatp
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzatp
    public final void zza(Throwable th, String str, float f) {
        if (zzbae.zzd(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzekz.zza(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f);
        int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza(name, stringWriter2, str, i2).toString());
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                this.zzzd.execute(new Runnable(new zzbas(), (String) obj) { // from class: com.google.android.gms.internal.ads.zzatk
                    private final String zzdkl;
                    private final zzbas zzdvd;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdvd = r1;
                        this.zzdkl = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzatl.zza(this.zzdvd, this.zzdkl);
                    }
                });
            }
        }
    }

    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        String str4;
        try {
            z = Wrappers.packageManager(this.zzcmo).isCallerInstantApp();
        } catch (Throwable th) {
            zzbao.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzcmo.getPackageName();
        } catch (Throwable unused) {
            zzbao.zzez("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter(ak.x, Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdvi.zzbrz).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabq.zzsi())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "360757573").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzads.zzdfr.get()));
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrl)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzcmo))).appendQueryParameter("lite", this.zzdvi.zzekd ? "1" : "0");
        }
        return appendQueryParameter2;
    }

    public static final /* synthetic */ void zza(zzbas zzbasVar, String str) {
        zzbasVar.zzen(str);
    }
}
