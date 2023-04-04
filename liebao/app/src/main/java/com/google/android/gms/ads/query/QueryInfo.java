package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzatd;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class QueryInfo {
    private final zzzy zzhva;

    public QueryInfo(zzzy zzzyVar) {
        this.zzhva = zzzyVar;
    }

    public String getQuery() {
        return this.zzhva.getQuery();
    }

    public Bundle getQueryBundle() {
        return this.zzhva.getQueryBundle();
    }

    public String getRequestId() {
        return zzzy.zza(this);
    }

    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzatd(context, adFormat, adRequest == null ? null : adRequest.zzdt()).zza(queryInfoGenerationCallback);
    }
}
