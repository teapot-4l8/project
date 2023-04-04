package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbas;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbq extends zza {
    private final String url;
    private final zzbas zzeiw;

    public zzbq(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.zzr.zzkv().zzq(context, str));
    }

    private zzbq(String str, String str2) {
        this.zzeiw = new zzbas(str2);
        this.url = str;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwp() {
        this.zzeiw.zzen(this.url);
    }
}
