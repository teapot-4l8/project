package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzatc extends zzaza {
    private final /* synthetic */ QueryInfoGenerationCallback zzduw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatc(zzatd zzatdVar, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzduw = queryInfoGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void zzj(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzy(str, null));
        zzww.zzre().put(queryInfo, str2);
        this.zzduw.onSuccess(queryInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void onError(String str) {
        this.zzduw.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzy(str, bundle));
        zzww.zzre().put(queryInfo, str2);
        this.zzduw.onSuccess(queryInfo);
    }
}
