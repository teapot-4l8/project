package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.service.WakedResultReceiver;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzww;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzam {
    private final Object lock = new Object();
    private String zzeho = "";
    private String zzehp = "";
    private boolean zzehq = false;
    private String zzehr = "";

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (WakedResultReceiver.WAKE_TYPE_KEY.equals(this.zzehr)) {
            zzd.zzdz("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzehr)) {
            zzd.zzdz("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzehr)) {
            zzd.zzdz("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zza(Context context, String str, String str2, String str3) {
        boolean zzaaf = zzaaf();
        if (zzg(context, str, str2)) {
            if (!zzaaf && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzd.zzdz("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzww.zzra().zzd(zzabq.zzcvs), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzd.zzdz("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzehr = jSONObject.optString("status");
            synchronized (this.lock) {
                this.zzehp = optString;
            }
            return true;
        } catch (JSONException e2) {
            zzd.zzd("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzww.zzra().zzd(zzabq.zzcvt), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzd.zzdz("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzehq = equals;
            }
            return equals;
        } catch (JSONException e2) {
            zzd.zzd("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    private static String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzr.zzkv().zzq(context, str2));
        zzebt<String> zzb = new zzay(context).zzb(str, hashMap);
        try {
            return zzb.get(((Integer) zzww.zzra().zzd(zzabq.zzcvv)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String valueOf = String.valueOf(str);
            zzd.zzc(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e2);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String valueOf2 = String.valueOf(str);
            zzd.zzc(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e3);
            zzb.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf3 = String.valueOf(str);
            zzd.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        zzj.zzb(context, zzd(context, (String) zzww.zzra().zzd(zzabq.zzcvr), str, str2));
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !com.google.android.gms.ads.internal.zzr.zzlf().zzaaf()) {
            return false;
        }
        zzd.zzdz("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzww.zzra().zzd(zzabq.zzcvu), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzr.zzkv();
        zzj.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbk(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String zzbk(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzeho)) {
                com.google.android.gms.ads.internal.zzr.zzkv();
                String zzr = zzj.zzr(context, "debug_signals_id.txt");
                this.zzeho = zzr;
                if (TextUtils.isEmpty(zzr)) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.zzeho = zzj.zzzr();
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    zzj.zzc(context, "debug_signals_id.txt", this.zzeho);
                }
            }
            str = this.zzeho;
        }
        return str;
    }

    public final String zzaae() {
        String str;
        synchronized (this.lock) {
            str = this.zzehp;
        }
        return str;
    }

    public final boolean zzaaf() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzehq;
        }
        return z;
    }

    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzd.zzey("Can not create dialog without Activity Context");
        } else {
            zzj.zzegq.post(new zzal(this, context, str, z, z2));
        }
    }
}
