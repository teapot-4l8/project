package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzarj {
    private final zzbfi zzdkm;
    private final String zzdrv;

    public zzarj(zzbfi zzbfiVar) {
        this(zzbfiVar, "");
    }

    public zzarj(zzbfi zzbfiVar, String str) {
        this.zzdkm = zzbfiVar;
        this.zzdrv = str;
    }

    public final void zzdt(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzdrv);
            if (this.zzdkm != null) {
                this.zzdkm.zza("onError", put);
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while dispatching error event.", e2);
        }
    }

    public final void zzdu(String str) {
        try {
            this.zzdkm.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while dispatching ready Event.", e2);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdkm.zza("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while dispatching size change.", e2);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzdkm.zza("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while dispatching default position.", e2);
        }
    }

    public final void zzdv(String str) {
        try {
            this.zzdkm.zza("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while dispatching state change.", e2);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzdkm.zza("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occurred while obtaining screen information.", e2);
        }
    }
}
