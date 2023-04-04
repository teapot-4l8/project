package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaw {
    public final int count;
    public final String name;
    private final double zzeib;
    private final double zzeic;
    public final double zzeid;

    public zzaw(String str, double d2, double d3, double d4, int i) {
        this.name = str;
        this.zzeic = d2;
        this.zzeib = d3;
        this.zzeid = d4;
        this.count = i;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("minBound", Double.valueOf(this.zzeic)).add("maxBound", Double.valueOf(this.zzeib)).add("percent", Double.valueOf(this.zzeid)).add("count", Integer.valueOf(this.count)).toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaw) {
            zzaw zzawVar = (zzaw) obj;
            return Objects.equal(this.name, zzawVar.name) && this.zzeib == zzawVar.zzeib && this.zzeic == zzawVar.zzeic && this.count == zzawVar.count && Double.compare(this.zzeid, zzawVar.zzeid) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzeib), Double.valueOf(this.zzeic), Double.valueOf(this.zzeid), Integer.valueOf(this.count));
    }
}
