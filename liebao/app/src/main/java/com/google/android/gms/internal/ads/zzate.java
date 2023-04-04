package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzate extends zzatb {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzduz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzate(zzatf zzatfVar, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzduz = updateImpressionUrlsCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void onSuccess(List<Uri> list) {
        this.zzduz.onSuccess(list);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void onError(String str) {
        this.zzduz.onFailure(str);
    }
}
