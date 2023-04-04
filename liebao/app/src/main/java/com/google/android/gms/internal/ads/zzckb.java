package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckb {
    private final zzcjw zzgmx;
    private final AtomicReference<zzann> zzgmy = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzckb(zzcjw zzcjwVar) {
        this.zzgmx = zzcjwVar;
    }

    public final void zzb(zzann zzannVar) {
        this.zzgmy.compareAndSet(null, zzannVar);
    }

    public final zzdqd zzd(String str, JSONObject jSONObject) {
        zzano zze;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zze = new zzaon(new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zze = new zzaon(new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zze = new zzaon(new zzaqt());
            } else {
                zze = zze(str, jSONObject);
            }
            zzdqd zzdqdVar = new zzdqd(zze);
            this.zzgmx.zza(str, zzdqdVar);
            return zzdqdVar;
        } catch (Throwable th) {
            throw new zzdpq(th);
        }
    }

    public final zzaqa zzdi(String str) {
        zzaqa zzdi = zzaqp().zzdi(str);
        this.zzgmx.zza(str, zzdi);
        return zzdi;
    }

    public final boolean zzaqo() {
        return this.zzgmy.get() != null;
    }

    private final zzano zze(String str, JSONObject jSONObject) {
        zzann zzaqp = zzaqp();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                String string = jSONObject.getString("class_name");
                if (zzaqp.zzde(string)) {
                    return zzaqp.zzdd("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                if (zzaqp.zzdf(string)) {
                    return zzaqp.zzdd(string);
                }
                return zzaqp.zzdd("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Invalid custom event.", e2);
            }
        }
        return zzaqp.zzdd(str);
    }

    private final zzann zzaqp() {
        zzann zzannVar = this.zzgmy.get();
        if (zzannVar != null) {
            return zzannVar;
        }
        com.google.android.gms.ads.internal.util.zzd.zzez("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
