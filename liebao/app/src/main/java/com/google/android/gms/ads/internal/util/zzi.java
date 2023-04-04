package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzrq;
import com.google.android.gms.internal.ads.zzww;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzi implements zzf {
    private SharedPreferences zzcmn;
    private boolean zzefv;
    private zzebt<?> zzefx;
    private SharedPreferences.Editor zzefz;
    private String zzegb;
    private String zzegc;
    private final Object lock = new Object();
    private final List<Runnable> zzefw = new ArrayList();
    private zzrq zzefy = null;
    private boolean zzega = false;
    private boolean zzdvu = true;
    private boolean zzegd = true;
    private zzazt zzege = new zzazt("", 0);
    private long zzegf = 0;
    private long zzegg = 0;
    private int zzegh = -1;
    private int zzegi = 0;
    private Set<String> zzegj = Collections.emptySet();
    private JSONObject zzegk = new JSONObject();
    private boolean zzdxs = true;
    private boolean zzdyd = true;
    private String zzegl = null;
    private int zzegm = -1;
    private int zzegn = -1;

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void initialize(Context context) {
        synchronized (this.lock) {
            if (this.zzcmn != null) {
                return;
            }
            this.zzefx = zzbat.zzeke.zzg(new Runnable(this, context, "admob") { // from class: com.google.android.gms.ads.internal.util.zzh
                private final Context zzclh;
                private final String zzdmx;
                private final zzi zzefu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzefu = this;
                    this.zzclh = context;
                    this.zzdmx = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzefu.zzo(this.zzclh, this.zzdmx);
                }
            });
            this.zzefv = true;
        }
    }

    private final void zzzo() {
        zzebt<?> zzebtVar = this.zzefx;
        if (zzebtVar == null || zzebtVar.isDone()) {
            return;
        }
        try {
            this.zzefx.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzd.zzd("Interrupted while waiting for preferences loaded.", e2);
        } catch (CancellationException e3) {
            e = e3;
            zzd.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e4) {
            e = e4;
            zzd.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e5) {
            e = e5;
            zzd.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void zzzp() {
        zzbat.zzeke.execute(new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.zzk
            private final zzi zzefu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzefu = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzefu.zzza();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final zzrq zzza() {
        if (this.zzefv) {
            if (!(zzzb() && zzzd()) && zzadh.zzdef.get().booleanValue()) {
                synchronized (this.lock) {
                    if (Looper.getMainLooper() == null) {
                        return null;
                    }
                    if (this.zzefy == null) {
                        this.zzefy = new zzrq();
                    }
                    this.zzefy.zzmo();
                    zzd.zzey("start fetching content...");
                    return this.zzefy;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzas(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzdxs == z) {
                return;
            }
            this.zzdxs = z;
            if (this.zzefz != null) {
                this.zzefz.putBoolean("content_url_opted_out", z);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzzb() {
        boolean z;
        zzzo();
        synchronized (this.lock) {
            z = this.zzdxs;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzee(String str) {
        zzzo();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzegb)) {
                    this.zzegb = str;
                    if (this.zzefz != null) {
                        this.zzefz.putString("content_url_hashes", str);
                        this.zzefz.apply();
                    }
                    zzzp();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String zzzc() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegb;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzat(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzdyd == z) {
                return;
            }
            this.zzdyd = z;
            if (this.zzefz != null) {
                this.zzefz.putBoolean("content_vertical_opted_out", z);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzzd() {
        boolean z;
        zzzo();
        synchronized (this.lock) {
            z = this.zzdyd;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzef(String str) {
        zzzo();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzegc)) {
                    this.zzegc = str;
                    if (this.zzefz != null) {
                        this.zzefz.putString("content_vertical_hashes", str);
                        this.zzefz.apply();
                    }
                    zzzp();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String zzze() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegc;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzau(boolean z) {
        zzzo();
        synchronized (this.lock) {
            if (z == this.zzegd) {
                return;
            }
            this.zzegd = z;
            if (this.zzefz != null) {
                this.zzefz.putBoolean("gad_idless", z);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzzn() {
        boolean z;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
            zzzo();
            synchronized (this.lock) {
                z = this.zzegd;
            }
            return z;
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzdi(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegi == i) {
                return;
            }
            this.zzegi = i;
            if (this.zzefz != null) {
                this.zzefz.putInt("version_code", i);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int zzzf() {
        int i;
        zzzo();
        synchronized (this.lock) {
            i = this.zzegi;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzeg(String str) {
        zzzo();
        synchronized (this.lock) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
            if (str != null && !str.equals(this.zzege.zzyr())) {
                this.zzege = new zzazt(str, currentTimeMillis);
                if (this.zzefz != null) {
                    this.zzefz.putString("app_settings_json", str);
                    this.zzefz.putLong("app_settings_last_update_ms", currentTimeMillis);
                    this.zzefz.apply();
                }
                zzzp();
                for (Runnable runnable : this.zzefw) {
                    runnable.run();
                }
                return;
            }
            this.zzege.zzez(currentTimeMillis);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final zzazt zzzg() {
        zzazt zzaztVar;
        zzzo();
        synchronized (this.lock) {
            zzaztVar = this.zzege;
        }
        return zzaztVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzb(Runnable runnable) {
        this.zzefw.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzfa(long j) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegf == j) {
                return;
            }
            this.zzegf = j;
            if (this.zzefz != null) {
                this.zzefz.putLong("app_last_background_time_ms", j);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long zzzh() {
        long j;
        zzzo();
        synchronized (this.lock) {
            j = this.zzegf;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzdj(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegh == i) {
                return;
            }
            this.zzegh = i;
            if (this.zzefz != null) {
                this.zzefz.putInt("request_in_session_count", i);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int zzzi() {
        int i;
        zzzo();
        synchronized (this.lock) {
            i = this.zzegh;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzfb(long j) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegg == j) {
                return;
            }
            this.zzegg = j;
            if (this.zzefz != null) {
                this.zzefz.putLong("first_ad_req_time_ms", j);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long zzzj() {
        long j;
        zzzo();
        synchronized (this.lock) {
            j = this.zzegg;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zza(String str, String str2, boolean z) {
        zzzo();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzegk.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzegk.put(str, optJSONArray);
            } catch (JSONException e2) {
                zzd.zzd("Could not update native advanced settings", e2);
            }
            if (this.zzefz != null) {
                this.zzefz.putString("native_advanced_settings", this.zzegk.toString());
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final JSONObject zzzk() {
        JSONObject jSONObject;
        zzzo();
        synchronized (this.lock) {
            jSONObject = this.zzegk;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzzl() {
        zzzo();
        synchronized (this.lock) {
            this.zzegk = new JSONObject();
            if (this.zzefz != null) {
                this.zzefz.remove("native_advanced_settings");
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String zzzm() {
        String str;
        zzzo();
        synchronized (this.lock) {
            str = this.zzegl;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzeh(String str) {
        zzzo();
        synchronized (this.lock) {
            if (TextUtils.equals(this.zzegl, str)) {
                return;
            }
            this.zzegl = str;
            if (this.zzefz != null) {
                this.zzefz.putString("display_cutout", str);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzdk(int i) {
        zzzo();
        synchronized (this.lock) {
            if (this.zzegn == i) {
                return;
            }
            this.zzegn = i;
            if (this.zzefz != null) {
                this.zzefz.putInt("sd_app_measure_npa", i);
                this.zzefz.apply();
            }
            zzzp();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcmn = sharedPreferences;
            this.zzefz = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzega = z;
            this.zzdvu = this.zzcmn.getBoolean("use_https", this.zzdvu);
            this.zzdxs = this.zzcmn.getBoolean("content_url_opted_out", this.zzdxs);
            this.zzegb = this.zzcmn.getString("content_url_hashes", this.zzegb);
            this.zzegd = this.zzcmn.getBoolean("gad_idless", this.zzegd);
            this.zzdyd = this.zzcmn.getBoolean("content_vertical_opted_out", this.zzdyd);
            this.zzegc = this.zzcmn.getString("content_vertical_hashes", this.zzegc);
            this.zzegi = this.zzcmn.getInt("version_code", this.zzegi);
            this.zzege = new zzazt(this.zzcmn.getString("app_settings_json", this.zzege.zzyr()), this.zzcmn.getLong("app_settings_last_update_ms", this.zzege.zzyp()));
            this.zzegf = this.zzcmn.getLong("app_last_background_time_ms", this.zzegf);
            this.zzegh = this.zzcmn.getInt("request_in_session_count", this.zzegh);
            this.zzegg = this.zzcmn.getLong("first_ad_req_time_ms", this.zzegg);
            this.zzegj = this.zzcmn.getStringSet("never_pool_slots", this.zzegj);
            this.zzegl = this.zzcmn.getString("display_cutout", this.zzegl);
            this.zzegm = this.zzcmn.getInt("app_measurement_npa", this.zzegm);
            this.zzegn = this.zzcmn.getInt("sd_app_measure_npa", this.zzegn);
            try {
                this.zzegk = new JSONObject(this.zzcmn.getString("native_advanced_settings", "{}"));
            } catch (JSONException e2) {
                zzd.zzd("Could not convert native advanced settings to json object", e2);
            }
            zzzp();
        }
    }
}
