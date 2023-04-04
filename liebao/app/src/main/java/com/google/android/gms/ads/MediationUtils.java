package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
        if (r2 >= r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        if (r12.zzdw() < r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b9, code lost:
        if (r4 >= r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdSize findClosestSize(Context context, AdSize adSize, List<AdSize> list) {
        AdSize adSize2 = null;
        if (list != null && adSize != null) {
            if (!adSize.zzdv() && !adSize.zzdx()) {
                float f = context.getResources().getDisplayMetrics().density;
                adSize = new AdSize(Math.round(adSize.getWidthInPixels(context) / f), Math.round(adSize.getHeightInPixels(context) / f));
            }
            for (AdSize adSize3 : list) {
                boolean z = false;
                if (adSize3 != null) {
                    int width = adSize.getWidth();
                    int width2 = adSize3.getWidth();
                    int height = adSize.getHeight();
                    int height2 = adSize3.getHeight();
                    double d2 = width;
                    Double.isNaN(d2);
                    if (d2 * MIN_WIDTH_RATIO <= width2 && width >= width2) {
                        if (adSize.zzdx()) {
                            int zzdy = adSize.zzdy();
                            if (((Integer) zzww.zzra().zzd(zzabq.zzdah)).intValue() <= width2) {
                                if (((Integer) zzww.zzra().zzd(zzabq.zzdai)).intValue() <= height2) {
                                }
                            }
                        } else if (!adSize.zzdv()) {
                            double d3 = height;
                            Double.isNaN(d3);
                            if (d3 * MIN_HEIGHT_RATIO <= height2) {
                            }
                        }
                    }
                }
                if (z && (adSize2 == null || adSize2.getWidth() * adSize2.getHeight() <= adSize3.getWidth() * adSize3.getHeight())) {
                    adSize2 = adSize3;
                }
            }
        }
        return adSize2;
    }
}
