package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.umeng.analytics.pro.ak;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblg implements zzaml<zzblk> {
    private final Context context;
    private final PowerManager zzaaj;
    private final zzqt zzful;

    public zzblg(Context context, zzqt zzqtVar) {
        this.context = context;
        this.zzful = zzqtVar;
        this.zzaaj = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzaml
    /* renamed from: zza */
    public final JSONObject zzi(zzblk zzblkVar) {
        boolean isScreenOn;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzblkVar.zzfva == null) {
            jSONObject = new JSONObject();
        } else {
            zzqx zzqxVar = zzblkVar.zzfva;
            if (this.zzful.zzmb() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzqxVar.zzbsf;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzful.zzma()).put("activeViewJSON", this.zzful.zzmb()).put("timestamp", zzblkVar.timestamp).put("adFormat", this.zzful.zzlz()).put("hashCode", this.zzful.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzblkVar.zzfux).put("isNative", this.zzful.isNative());
            if (Build.VERSION.SDK_INT >= 20) {
                isScreenOn = this.zzaaj.isInteractive();
            } else {
                isScreenOn = this.zzaaj.isScreenOn();
            }
            put.put("isScreenOn", isScreenOn).put("appMuted", com.google.android.gms.ads.internal.zzr.zzla().zzrh()).put("appVolume", com.google.android.gms.ads.internal.zzr.zzla().zzrg()).put("deviceVolume", com.google.android.gms.ads.internal.util.zzae.zzbj(this.context.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqxVar.zzaaq).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzqxVar.zzbsg.top).put("bottom", zzqxVar.zzbsg.bottom).put("left", zzqxVar.zzbsg.left).put("right", zzqxVar.zzbsg.right)).put("adBox", new JSONObject().put("top", zzqxVar.zzbsh.top).put("bottom", zzqxVar.zzbsh.bottom).put("left", zzqxVar.zzbsh.left).put("right", zzqxVar.zzbsh.right)).put("globalVisibleBox", new JSONObject().put("top", zzqxVar.zzbsi.top).put("bottom", zzqxVar.zzbsi.bottom).put("left", zzqxVar.zzbsi.left).put("right", zzqxVar.zzbsi.right)).put("globalVisibleBoxVisible", zzqxVar.zzbsj).put("localVisibleBox", new JSONObject().put("top", zzqxVar.zzbsk.top).put("bottom", zzqxVar.zzbsk.bottom).put("left", zzqxVar.zzbsk.left).put("right", zzqxVar.zzbsk.right)).put("localVisibleBoxVisible", zzqxVar.zzbsl).put("hitBox", new JSONObject().put("top", zzqxVar.zzbsm.top).put("bottom", zzqxVar.zzbsm.bottom).put("left", zzqxVar.zzbsm.left).put("right", zzqxVar.zzbsm.right)).put("screenDensity", this.context.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzblkVar.zzbrt);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcrj)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                if (zzqxVar.zzbso != null) {
                    for (Rect rect2 : zzqxVar.zzbso) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzblkVar.zzfuz)) {
                jSONObject3.put("doneReasonCode", ak.aG);
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
