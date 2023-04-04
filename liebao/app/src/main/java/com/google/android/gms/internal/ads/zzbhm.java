package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbhm implements zzesa<WeakReference<Context>> {
    private final zzbhg zzeyi;

    public zzbhm(zzbhg zzbhgVar) {
        this.zzeyi = zzbhgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (WeakReference) zzesg.zzbd(this.zzeyi.zzafq());
    }
}
