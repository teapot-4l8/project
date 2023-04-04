package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczh extends zzaqe {
    private final String zzdka;
    private final zzaqa zzhai;
    private zzbbe<JSONObject> zzhaj;
    private final JSONObject zzhak;
    private boolean zzhal;

    public zzczh(String str, zzaqa zzaqaVar, zzbbe<JSONObject> zzbbeVar) {
        JSONObject jSONObject = new JSONObject();
        this.zzhak = jSONObject;
        this.zzhal = false;
        this.zzhaj = zzbbeVar;
        this.zzdka = str;
        this.zzhai = zzaqaVar;
        try {
            jSONObject.put("adapter_version", zzaqaVar.zzvm().toString());
            this.zzhak.put("sdk_version", this.zzhai.zzvn().toString());
            this.zzhak.put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.zzdka);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final synchronized void zzdo(String str) {
        if (this.zzhal) {
            return;
        }
        if (str == null) {
            onFailure("Adapter returned null signals");
            return;
        }
        try {
            this.zzhak.put("signals", str);
        } catch (JSONException unused) {
        }
        this.zzhaj.set(this.zzhak);
        this.zzhal = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final synchronized void onFailure(String str) {
        if (this.zzhal) {
            return;
        }
        try {
            this.zzhak.put("signal_error", str);
        } catch (JSONException unused) {
        }
        this.zzhaj.set(this.zzhak);
        this.zzhal = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaqf
    public final synchronized void zzh(zzvh zzvhVar) {
        if (this.zzhal) {
            return;
        }
        try {
            this.zzhak.put("signal_error", zzvhVar.zzchs);
        } catch (JSONException unused) {
        }
        this.zzhaj.set(this.zzhak);
        this.zzhal = true;
    }
}
