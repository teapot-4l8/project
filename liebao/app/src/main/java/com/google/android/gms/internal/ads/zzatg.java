package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzatg {
    @Nonnull
    private View zzaay;
    private final Map<String, WeakReference<View>> zzdva = new HashMap();

    public final zzatg zzk(View view) {
        this.zzaay = view;
        return this;
    }

    public final zzatg zzh(Map<String, View> map) {
        this.zzdva.clear();
        for (Map.Entry<String, View> entry : map.entrySet()) {
            View value = entry.getValue();
            if (value != null) {
                this.zzdva.put(entry.getKey(), new WeakReference<>(value));
            }
        }
        return this;
    }
}
