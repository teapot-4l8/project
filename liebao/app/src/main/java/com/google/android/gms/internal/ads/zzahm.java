package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahm implements zzaig<Object> {
    private final zzahp zzdie;

    public zzahm(zzahp zzahpVar) {
        this.zzdie = zzahpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("App event with no name parameter.");
        } else {
            this.zzdie.onAppEvent(str, map.get("info"));
        }
    }
}
