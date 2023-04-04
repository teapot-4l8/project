package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcad implements zzbxs {
    static final zzbxs zzgbn = new zzcad();

    private zzcad() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxs
    public final void zzo(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoPause();
    }
}
