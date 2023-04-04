package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzabm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzcmo;
    private final Object lock = new Object();
    private final ConditionVariable zzcmm = new ConditionVariable();
    private volatile boolean zzzq = false;
    private volatile boolean zzcll = false;
    private SharedPreferences zzcmn = null;
    private Bundle metaData = new Bundle();
    private JSONObject zzcmp = new JSONObject();

    public final void initialize(Context context) {
        if (this.zzzq) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzzq) {
                return;
            }
            if (!this.zzcll) {
                this.zzcll = true;
            }
            Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
            this.zzcmo = applicationContext;
            try {
                this.metaData = Wrappers.packageManager(applicationContext).getApplicationInfo(this.zzcmo.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null && context != null) {
                Context applicationContext2 = context.getApplicationContext();
                if (applicationContext2 != null) {
                    context = applicationContext2;
                }
                remoteContext = context;
            }
            if (remoteContext == null) {
                this.zzcll = false;
                this.zzcmm.open();
                return;
            }
            zzww.zzqy();
            SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
            this.zzcmn = sharedPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
            }
            zzaeb.zza(new zzabr(this));
            zzsk();
            this.zzzq = true;
            this.zzcll = false;
            this.zzcmm.open();
        }
    }

    public final <T> T zzd(zzabf<T> zzabfVar) {
        if (!this.zzcmm.block(5000L)) {
            synchronized (this.lock) {
                if (!this.zzcll) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzq || this.zzcmn == null) {
            synchronized (this.lock) {
                if (this.zzzq && this.zzcmn != null) {
                }
                return zzabfVar.zzsh();
            }
        }
        if (zzabfVar.getSource() == 2) {
            Bundle bundle = this.metaData;
            if (bundle == null) {
                return zzabfVar.zzsh();
            }
            return zzabfVar.zza(bundle);
        } else if (zzabfVar.getSource() == 1 && this.zzcmp.has(zzabfVar.getKey())) {
            return zzabfVar.zzb(this.zzcmp);
        } else {
            return (T) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdyp(this, zzabfVar) { // from class: com.google.android.gms.internal.ads.zzabp
                private final zzabm zzcmq;
                private final zzabf zzcmr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmq = this;
                    this.zzcmr = zzabfVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyp
                public final Object get() {
                    return this.zzcmq.zze(this.zzcmr);
                }
            });
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzsk();
        }
    }

    private final void zzsk() {
        if (this.zzcmn == null) {
            return;
        }
        try {
            this.zzcmp = new JSONObject((String) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdyp(this) { // from class: com.google.android.gms.internal.ads.zzabo
                private final zzabm zzcmq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmq = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyp
                public final Object get() {
                    return this.zzcmq.zzsl();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzsl() {
        return this.zzcmn.getString("flag_configuration", "{}");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzabf zzabfVar) {
        return zzabfVar.zza(this.zzcmn);
    }
}
