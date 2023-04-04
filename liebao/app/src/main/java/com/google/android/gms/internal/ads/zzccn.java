package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.umeng.analytics.pro.ak;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzccn implements zzcdz {
    private final Context context;
    private final zzbar zzbpx;
    private final Clock zzbqq;
    private final zzei zzeus;
    private final zzdot zzeux;
    private final zzdup zzftn;
    private final zzcdy zzfwx;
    private final zzdpm zzfzg;
    private final JSONObject zzgem;
    private final zzchu zzgen;
    private final zzcdr zzgeo;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzbli zzger;
    private final zzceq zzges;
    private final zzbzk zzget;
    private boolean zzgev;
    private zzyo zzgfc;
    private boolean zzgeu = false;
    private boolean zzgew = false;
    private boolean zzgex = false;
    private Point zzgey = new Point();
    private Point zzgez = new Point();
    private long zzgfa = 0;
    private long zzgfb = 0;

    public zzccn(Context context, zzcdy zzcdyVar, JSONObject jSONObject, zzchu zzchuVar, zzcdr zzcdrVar, zzei zzeiVar, zzbtl zzbtlVar, zzbst zzbstVar, zzdot zzdotVar, zzbar zzbarVar, zzdpm zzdpmVar, zzbli zzbliVar, zzceq zzceqVar, Clock clock, zzbzk zzbzkVar, zzdup zzdupVar) {
        this.context = context;
        this.zzfwx = zzcdyVar;
        this.zzgem = jSONObject;
        this.zzgen = zzchuVar;
        this.zzgeo = zzcdrVar;
        this.zzeus = zzeiVar;
        this.zzgep = zzbtlVar;
        this.zzgeq = zzbstVar;
        this.zzeux = zzdotVar;
        this.zzbpx = zzbarVar;
        this.zzfzg = zzdpmVar;
        this.zzger = zzbliVar;
        this.zzges = zzceqVar;
        this.zzbqq = clock;
        this.zzget = zzbzkVar;
        this.zzftn = zzdupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzgey = new Point();
        this.zzgez = new Point();
        if (!this.zzgev) {
            this.zzget.zzv(view);
            this.zzgev = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzger.zzn(this);
        boolean zzdn = com.google.android.gms.ads.internal.util.zzbn.zzdn(this.zzbpx.zzekb);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    if (zzdn) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> entry2 : map2.entrySet()) {
                View view3 = entry2.getValue().get();
                if (view3 != null) {
                    if (zzdn) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        this.zzgey = new Point();
        this.zzgez = new Point();
        this.zzget.zzw(view);
        this.zzgev = false;
    }

    private final boolean zzfw(String str) {
        JSONObject optJSONObject = this.zzgem.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view2);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view2);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view2);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view2);
        String zzb2 = zzb(view, map);
        zza(((Boolean) zzww.zzra().zzd(zzabq.zzctk)).booleanValue() ? view2 : view, zza2, zza, zzt, zzb, zzb2, com.google.android.gms.ads.internal.util.zzbn.zza(zzb2, this.context, this.zzgez, this.zzgey), null, z, false);
    }

    private final String zzb(View view, Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int zzaoo = this.zzgeo.zzaoo();
        if (zzaoo != 1) {
            if (zzaoo != 2) {
                if (zzaoo != 6) {
                    return null;
                }
                return "3099";
            }
            return "2099";
        }
        return "1099";
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzfx(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzf(Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Click data is null. No click is reported.");
        } else if (!zzfw("click_reporting")) {
            com.google.android.gms.ads.internal.util.zzd.zzex("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, com.google.android.gms.ads.internal.zzr.zzkv().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgex) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzaoc()) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Custom click reporting failed. Ad unit id not in the allow list.");
        } else {
            JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view);
            JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view);
            JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view);
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view);
            String zzb2 = zzb(null, map);
            zza(view, zza2, zza, zzt, zzb, zzb2, com.google.android.gms.ads.internal.util.zzbn.zza(zzb2, this.context, this.zzgez, this.zzgey), null, z, true);
        }
    }

    private final boolean zzaoc() {
        return this.zzgem.optBoolean("allow_custom_click_gesture", false);
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzud() {
        this.zzgex = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final boolean isCustomClickGestureEnabled() {
        return zzaoc();
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(ak.aw, this.zzgem);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzfwx.zzgc(this.zzgeo.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzgeo.zzaoo());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfzg.zzdpr != null && this.zzfzg.zzdpr.zzboh);
            jSONObject8.put("custom_mute_enabled", (this.zzgeo.getMuteThisAdReasons().isEmpty() || this.zzgeo.zzaor() == null) ? false : true);
            if (this.zzges.zzapx() != null && this.zzgem.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbqq.currentTimeMillis());
            if (this.zzgex && zzaoc()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzfwx.zzgc(this.zzgeo.getCustomTemplateId()) != null);
            jSONObject8.put("click_signals", zzx(view));
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcvp)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbj)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbk)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbqq.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzgfa);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzgfb);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbba.zza(this.zzgen.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Unable to create click JSON.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgey = com.google.android.gms.ads.internal.util.zzbn.zza(motionEvent, view2);
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        this.zzgfb = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzgfa = currentTimeMillis;
            this.zzgez = this.zzgey;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(this.zzgey.x, this.zzgey.y);
        this.zzeus.zza(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzg(Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.ads.internal.util.zzd.zzdz("Touch event data is null. No touch event is reported.");
        } else if (!zzfw("touch_reporting")) {
            com.google.android.gms.ads.internal.util.zzd.zzex("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzeus.zzcb().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zza);
            jSONObject.put("ad_view_signal", zza2);
            jSONObject.put("scroll_view_signal", zzt);
            jSONObject.put("lock_screen_signal", zzb);
            return jSONObject;
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Unable to create native ad view signals JSON.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaod() {
        zza(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void setClickConfirmingView(View view) {
        if (!this.zzgem.optBoolean("custom_one_point_five_click_enabled", false)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzceq zzceqVar = this.zzges;
        if (view != null) {
            view.setOnClickListener(zzceqVar);
            view.setClickable(true);
            zzceqVar.zzgit = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzagr zzagrVar) {
        if (!this.zzgem.optBoolean("custom_one_point_five_click_enabled", false)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzges.zza(zzagrVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void cancelUnconfirmedClick() {
        if (this.zzgem.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzges.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzys zzysVar) {
        try {
            if (this.zzgew) {
                return;
            }
            if (zzysVar == null && this.zzgeo.zzaor() != null) {
                this.zzgew = true;
                this.zzftn.zzen(this.zzgeo.zzaor().zzrk());
                zzaoe();
                return;
            }
            this.zzgew = true;
            this.zzftn.zzen(zzysVar.zzrk());
            zzaoe();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzyo zzyoVar) {
        this.zzgfc = zzyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaoe() {
        try {
            if (this.zzgfc != null) {
                this.zzgfc.onAdMuted();
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        zza(com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view), com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view), com.google.android.gms.ads.internal.util.zzbn.zzt(view), com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view), zzy(view), null, com.google.android.gms.ads.internal.util.zzbn.zza(this.context, this.zzeux));
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaof() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ak.aw, this.zzgem);
            zzbba.zza(this.zzgen.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final boolean zzh(Bundle bundle) {
        if (!zzfw("impression_reporting")) {
            com.google.android.gms.ads.internal.util.zzd.zzex("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        return zza(null, null, null, null, null, com.google.android.gms.ads.internal.zzr.zzkv().zza(bundle, (JSONObject) null), false);
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(ak.aw, this.zzgem);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzctj)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", com.google.android.gms.ads.internal.util.zzbn.zzbn(this.context));
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbf)).booleanValue()) {
                this.zzgen.zza("/clickRecorded", new zzcco(this));
            } else {
                this.zzgen.zza("/logScionEvent", new zzccp(this));
            }
            this.zzgen.zza("/nativeImpression", new zzccr(this));
            zzbba.zza(this.zzgen.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzgeu || this.zzeux.zzhmm == null) {
                return true;
            }
            this.zzgeu |= com.google.android.gms.ads.internal.zzr.zzlf().zzb(this.context, this.zzbpx.zzbrz, this.zzeux.zzhmm.toString(), this.zzfzg.zzhny);
            return true;
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Unable to create impression JSON.", e2);
            return false;
        }
    }

    private final String zzx(View view) {
        try {
            JSONObject optJSONObject = this.zzgem.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzeus.zzcb().zza(this.context, optJSONObject.optString("click_string"), view);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Exception obtaining click signals", e2);
            return null;
        }
    }

    private final String zzy(View view) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctj)).booleanValue()) {
            try {
                return this.zzeus.zzcb().zza(this.context, view, (Activity) null);
            } catch (Exception unused) {
                com.google.android.gms.ads.internal.util.zzd.zzex("Exception getting data.");
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void destroy() {
        this.zzgen.destroy();
    }
}
