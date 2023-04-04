package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public interface MediationAdapter extends MediationExtrasReceiver {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza {
        private int zzewy;

        public final zza zzed(int i) {
            this.zzewy = 1;
            return this;
        }

        public final Bundle zzafn() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzewy);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
