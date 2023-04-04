package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class zzwd {
    private final zzvo zzcje;
    private final zzvl zzcjf;
    private final zzaaa zzcjg;
    private final zzagw zzcjh;
    private final zzavr zzcji;
    private final zzawv zzcjj;
    private final zzasf zzcjk;
    private final zzagz zzcjl;

    public zzwd(zzvo zzvoVar, zzvl zzvlVar, zzaaa zzaaaVar, zzagw zzagwVar, zzavr zzavrVar, zzawv zzawvVar, zzasf zzasfVar, zzagz zzagzVar) {
        this.zzcje = zzvoVar;
        this.zzcjf = zzvlVar;
        this.zzcjg = zzaaaVar;
        this.zzcjh = zzagwVar;
        this.zzcji = zzavrVar;
        this.zzcjj = zzawvVar;
        this.zzcjk = zzasfVar;
        this.zzcjl = zzagzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzww.zzqw().zza(context, zzww.zzrc().zzbrz, "gmob-apps", bundle, true);
    }

    public final zzxq zza(Context context, zzvt zzvtVar, String str, zzann zzannVar) {
        return new zzwl(this, context, zzvtVar, str, zzannVar).zzd(context, false);
    }

    public final zzxq zzb(Context context, zzvt zzvtVar, String str, zzann zzannVar) {
        return new zzwn(this, context, zzvtVar, str, zzannVar).zzd(context, false);
    }

    public final zzxj zzb(Context context, String str, zzann zzannVar) {
        return new zzwq(this, context, str, zzannVar).zzd(context, false);
    }

    public final zzaew zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new zzws(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzafd zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return new zzwr(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzawf zzc(Context context, String str, zzann zzannVar) {
        return new zzwf(this, context, str, zzannVar).zzd(context, false);
    }

    public final zzash zzb(Activity activity) {
        zzwi zzwiVar = new zzwi(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbao.zzex("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return zzwiVar.zzd(activity, z);
    }

    public final zzazc zza(Context context, zzann zzannVar) {
        return new zzwh(this, context, zzannVar).zzd(context, false);
    }

    public final zzaru zzb(Context context, zzann zzannVar) {
        return new zzwj(this, context, zzannVar).zzd(context, false);
    }
}
