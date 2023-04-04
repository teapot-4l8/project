package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.a.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqt implements MediationInterstitialAdapter {
    private Uri uri;
    private Activity zzdqj;
    private MediationInterstitialListener zzdqk;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdqk = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzbao.zzez("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbao.zzez("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdqk.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(context))) {
                zzbao.zzez("Default browser does not support custom tabs. Bailing out.");
                this.zzdqk.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbao.zzez("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdqk.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzdqj = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdqk.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        c a2 = new c.a().a();
        a2.f1220a.setData(this.uri);
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzaqv(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzb(a2.f1220a, null), null, new zzaqs(this), null, new zzbar(0, 0, false), null)));
        com.google.android.gms.ads.internal.zzr.zzkz().zzyh();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbao.zzdz("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbao.zzdz("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbao.zzdz("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
