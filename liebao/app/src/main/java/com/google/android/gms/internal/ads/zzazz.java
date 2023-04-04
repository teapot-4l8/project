package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazz {
    private final com.google.android.gms.ads.internal.util.zzf zzecl;
    private final String zzefi;
    private long zzefd = -1;
    private long zzefe = -1;
    private int zzeff = -1;
    int zzefg = -1;
    private long zzefh = 0;
    private final Object lock = new Object();
    private int zzefj = 0;
    private int zzefk = 0;

    public zzazz(String str, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzefi = str;
        this.zzecl = zzfVar;
    }

    public final void zzyc() {
        synchronized (this.lock) {
            this.zzefj++;
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            this.zzefk++;
        }
    }

    public final void zza(zzvq zzvqVar, long j) {
        synchronized (this.lock) {
            long zzzh = this.zzecl.zzzh();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
            if (this.zzefe == -1) {
                if (currentTimeMillis - zzzh > ((Long) zzww.zzra().zzd(zzabq.zzcqb)).longValue()) {
                    this.zzefg = -1;
                } else {
                    this.zzefg = this.zzecl.zzzi();
                }
                this.zzefe = j;
                this.zzefd = j;
            } else {
                this.zzefd = j;
            }
            if (zzvqVar == null || zzvqVar.extras == null || zzvqVar.extras.getInt("gw", 2) != 1) {
                this.zzeff++;
                int i = this.zzefg + 1;
                this.zzefg = i;
                if (i == 0) {
                    this.zzefh = 0L;
                    this.zzecl.zzfb(currentTimeMillis);
                } else {
                    this.zzefh = currentTimeMillis - this.zzecl.zzzj();
                }
            }
        }
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzecl.zzzn() ? "" : this.zzefi);
            bundle.putLong("basets", this.zzefe);
            bundle.putLong("currts", this.zzefd);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzeff);
            bundle.putInt("preqs_in_session", this.zzefg);
            bundle.putLong("time_in_session", this.zzefh);
            bundle.putInt("pclick", this.zzefj);
            bundle.putInt("pimp", this.zzefk);
            bundle.putBoolean("support_transparent_background", zzal(context));
        }
        return bundle;
    }

    private static boolean zzal(Context context) {
        Context zzx = zzava.zzx(context);
        int identifier = zzx.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            com.google.android.gms.ads.internal.util.zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzx.getPackageManager().getActivityInfo(new ComponentName(zzx.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            com.google.android.gms.ads.internal.util.zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Fail to fetch AdActivity theme");
            com.google.android.gms.ads.internal.util.zzd.zzey("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
