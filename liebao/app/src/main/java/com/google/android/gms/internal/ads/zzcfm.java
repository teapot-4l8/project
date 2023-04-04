package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcfm implements zzcdz {
    private final Context context;
    private final zzbar zzbpx;
    private final zzdot zzeux;
    private final zzdpm zzfzg;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzaob zzgjm;
    private final zzaoc zzgjn;
    private final zzaoh zzgjo;
    private boolean zzgeu = false;
    private boolean zzgex = false;
    private boolean zzgjp = true;

    public zzcfm(zzaob zzaobVar, zzaoc zzaocVar, zzaoh zzaohVar, zzbtl zzbtlVar, zzbst zzbstVar, Context context, zzdot zzdotVar, zzbar zzbarVar, zzdpm zzdpmVar) {
        this.zzgjm = zzaobVar;
        this.zzgjn = zzaocVar;
        this.zzgjo = zzaohVar;
        this.zzgep = zzbtlVar;
        this.zzgeq = zzbstVar;
        this.context = context;
        this.zzeux = zzdotVar;
        this.zzbpx = zzbarVar;
        this.zzfzg = zzdpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzagr zzagrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaod() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaof() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzf(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzfx(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final boolean zzh(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            this.zzgjp = zzc(map, map2);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzgjo != null) {
                this.zzgjo.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzgjm != null) {
                this.zzgjm.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgjm.zzw(wrap);
            } else if (this.zzgjn != null) {
                this.zzgjn.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgjn.zzw(wrap);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to call trackView", e2);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzgjo != null) {
                this.zzgjo.zzx(wrap);
            } else if (this.zzgjm != null) {
                this.zzgjm.zzx(wrap);
            } else if (this.zzgjn != null) {
                this.zzgjn.zzx(wrap);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to call untrackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzgex && this.zzeux.zzdnp) {
            return;
        }
        zzad(view);
    }

    private final void zzad(View view) {
        try {
            if (this.zzgjo != null && !this.zzgjo.getOverrideClickHandling()) {
                this.zzgjo.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            } else if (this.zzgjm != null && !this.zzgjm.getOverrideClickHandling()) {
                this.zzgjm.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            } else if (this.zzgjn == null || this.zzgjn.getOverrideClickHandling()) {
            } else {
                this.zzgjn.zzv(ObjectWrapper.wrap(view));
                this.zzgeq.onAdClicked();
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to call handleClick", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgex) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzeux.zzdnp) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzud() {
        this.zzgex = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final boolean isCustomClickGestureEnabled() {
        return this.zzeux.zzdnp;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzgeu && this.zzeux.zzhmm != null) {
                this.zzgeu |= com.google.android.gms.ads.internal.zzr.zzlf().zzb(this.context, this.zzbpx.zzbrz, this.zzeux.zzhmm.toString(), this.zzfzg.zzhny);
            }
            if (this.zzgjp) {
                if (this.zzgjo != null && !this.zzgjo.getOverrideImpressionRecording()) {
                    this.zzgjo.recordImpression();
                    this.zzgep.onAdImpression();
                } else if (this.zzgjm != null && !this.zzgjm.getOverrideImpressionRecording()) {
                    this.zzgjm.recordImpression();
                    this.zzgep.onAdImpression();
                } else if (this.zzgjn == null || this.zzgjn.getOverrideImpressionRecording()) {
                } else {
                    this.zzgjn.recordImpression();
                    this.zzgep.onAdImpression();
                }
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Failed to call recordImpression", e2);
        }
    }

    private final boolean zzc(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        Object obj;
        JSONObject jSONObject = this.zzeux.zzhna;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcru)).booleanValue() && jSONObject.length() != 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            hashMap.putAll(map2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    WeakReference weakReference = (WeakReference) hashMap.get(next);
                    if (weakReference == null || (obj = weakReference.get()) == null) {
                        return false;
                    }
                    Class<?> cls = obj.getClass();
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcrv)).booleanValue() && next.equals("3010")) {
                        Object zzaqa = zzaqa();
                        if (zzaqa == null) {
                            return false;
                        }
                        cls = zzaqa.getClass();
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        com.google.android.gms.ads.internal.util.zzbh.zza(optJSONArray, arrayList);
                        com.google.android.gms.ads.internal.zzr.zzkv();
                        if (!com.google.android.gms.ads.internal.util.zzj.zza(this.context.getClassLoader(), cls, arrayList)) {
                            return false;
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return true;
    }

    private final Object zzaqa() {
        IObjectWrapper zzvs;
        zzaoh zzaohVar = this.zzgjo;
        if (zzaohVar != null) {
            try {
                zzvs = zzaohVar.zzvs();
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            zzaob zzaobVar = this.zzgjm;
            if (zzaobVar != null) {
                try {
                    zzvs = zzaobVar.zzvs();
                } catch (RemoteException unused2) {
                    return null;
                }
            } else {
                zzaoc zzaocVar = this.zzgjn;
                if (zzaocVar != null) {
                    try {
                        zzvs = zzaocVar.zzvs();
                    } catch (RemoteException unused3) {
                        return null;
                    }
                } else {
                    zzvs = null;
                }
            }
        }
        if (zzvs != null) {
            try {
                return ObjectWrapper.unwrap(zzvs);
            } catch (IllegalArgumentException unused4) {
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzys zzysVar) {
        com.google.android.gms.ads.internal.util.zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zza(zzyo zzyoVar) {
        com.google.android.gms.ads.internal.util.zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzcdz
    public final void zzaoe() {
        com.google.android.gms.ads.internal.util.zzd.zzez("Mute This Ad is not supported for 3rd party ads");
    }
}
