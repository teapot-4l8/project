package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrq extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbsq;
    private final int zzbss;
    private final boolean zzbst;
    private boolean zzbtr;
    private boolean zzbts;
    private final zzrn zzbtt;
    private final int zzbtu;
    private final int zzbtv;
    private final int zzbtw;
    private final int zzbtx;
    private final int zzbty;
    private final int zzbtz;
    private final String zzbua;
    private final boolean zzbub;
    private final boolean zzbuc;

    public zzrq() {
        this(new zzrn());
    }

    private zzrq(zzrn zzrnVar) {
        this.started = false;
        this.zzbtr = false;
        this.zzbts = false;
        this.zzbtt = zzrnVar;
        this.lock = new Object();
        this.zzbsq = zzadh.zzdeh.get().intValue();
        this.zzbtv = zzadh.zzdee.get().intValue();
        this.zzbss = zzadh.zzdei.get().intValue();
        this.zzbtw = zzadh.zzdeg.get().intValue();
        this.zzbtx = ((Integer) zzww.zzra().zzd(zzabq.zzcog)).intValue();
        this.zzbty = ((Integer) zzww.zzra().zzd(zzabq.zzcoh)).intValue();
        this.zzbtz = ((Integer) zzww.zzra().zzd(zzabq.zzcoi)).intValue();
        this.zzbtu = zzadh.zzdej.get().intValue();
        this.zzbua = (String) zzww.zzra().zzd(zzabq.zzcok);
        this.zzbub = ((Boolean) zzww.zzra().zzd(zzabq.zzcol)).booleanValue();
        this.zzbst = ((Boolean) zzww.zzra().zzd(zzabq.zzcom)).booleanValue();
        this.zzbuc = ((Boolean) zzww.zzra().zzd(zzabq.zzcon)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzmo() {
        synchronized (this.lock) {
            if (this.started) {
                com.google.android.gms.ads.internal.util.zzd.zzdz("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                if (zzmp()) {
                    Activity activity = com.google.android.gms.ads.internal.zzr.zzky().getActivity();
                    if (activity == null) {
                        com.google.android.gms.ads.internal.util.zzd.zzdz("ContentFetchThread: no activity. Sleeping.");
                        zzmr();
                    } else if (activity != null) {
                        View view = null;
                        try {
                            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                view = activity.getWindow().getDecorView().findViewById(16908290);
                            }
                        } catch (Exception e2) {
                            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "ContentFetchTask.extractContent");
                            com.google.android.gms.ads.internal.util.zzd.zzdz("Failed getting root view of activity. Content not extracted.");
                        }
                        if (view != null && view != null) {
                            view.post(new zzrt(this, view));
                        }
                    }
                } else {
                    com.google.android.gms.ads.internal.util.zzd.zzdz("ContentFetchTask: sleeping");
                    zzmr();
                }
                Thread.sleep(this.zzbtu * 1000);
            } catch (InterruptedException e3) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error in ContentFetchTask", e3);
            } catch (Exception e4) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error in ContentFetchTask", e4);
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e4, "ContentFetchTask.run");
            }
            synchronized (this.lock) {
                while (this.zzbtr) {
                    try {
                        com.google.android.gms.ads.internal.util.zzd.zzdz("ContentFetchTask: waiting");
                        this.lock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(View view) {
        try {
            zzrk zzrkVar = new zzrk(this.zzbsq, this.zzbtv, this.zzbss, this.zzbtw, this.zzbtx, this.zzbty, this.zzbtz, this.zzbst);
            Context context = com.google.android.gms.ads.internal.zzr.zzky().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbua)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzww.zzra().zzd(zzabq.zzcoj), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbua)) {
                    return;
                }
            }
            zzru zza = zza(view, zzrkVar);
            zzrkVar.zzmm();
            if (zza.zzbuj == 0 && zza.zzbuk == 0) {
                return;
            }
            if (zza.zzbuk == 0 && zzrkVar.zzmn() == 0) {
                return;
            }
            if (zza.zzbuk == 0 && this.zzbtt.zza(zzrkVar)) {
                return;
            }
            this.zzbtt.zzc(zzrkVar);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Exception in fetchContentOnUIThread", e2);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "ContentFetchTask.fetchContent");
        }
    }

    private static boolean zzmp() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            Context context = com.google.android.gms.ads.internal.zzr.zzky().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final zzru zza(View view, zzrk zzrkVar) {
        boolean z;
        if (view == null) {
            return new zzru(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzrkVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new zzru(this, 1, 0);
            }
            return new zzru(this, 0, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbfi)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.isAtLeastKitKat()) {
                zzrkVar.zzmk();
                webView.post(new zzrs(this, zzrkVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new zzru(this, 0, 1);
            }
            return new zzru(this, 0, 0);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzru zza = zza(viewGroup.getChildAt(i3), zzrkVar);
                i += zza.zzbuj;
                i2 += zza.zzbuk;
            }
            return new zzru(this, i, i2);
        } else {
            return new zzru(this, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzrk zzrkVar, WebView webView, String str, boolean z) {
        zzrkVar.zzmj();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!this.zzbub && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzrkVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzrkVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzrkVar.zzme()) {
                this.zzbtt.zzb(zzrkVar);
            }
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Json string may be malformed.");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zzd.zzb("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzrk zzmq() {
        return this.zzbtt.zzp(this.zzbuc);
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbtr = false;
            this.lock.notifyAll();
            com.google.android.gms.ads.internal.util.zzd.zzdz("ContentFetchThread: wakeup");
        }
    }

    private final void zzmr() {
        synchronized (this.lock) {
            this.zzbtr = true;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(true);
            com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        }
    }

    public final boolean zzms() {
        return this.zzbtr;
    }
}
