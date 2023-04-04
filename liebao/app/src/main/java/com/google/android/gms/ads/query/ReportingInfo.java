package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzatg;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class ReportingInfo {
    private final zzatf zzhvd;

    private ReportingInfo(Builder builder) {
        this.zzhvd = new zzatf(builder.zzhve);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private final zzatg zzhve;

        public Builder(View view) {
            zzatg zzatgVar = new zzatg();
            this.zzhve = zzatgVar;
            zzatgVar.zzk(view);
        }

        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhve.zzh(map);
            return this;
        }

        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhvd.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhvd.updateClickUrl(uri, updateClickUrlCallback);
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhvd.reportTouchEvent(motionEvent);
    }
}
