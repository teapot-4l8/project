package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzei;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzq implements Callable<zzei> {
    private final /* synthetic */ zzl zzbqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzl zzlVar) {
        this.zzbqf = zzlVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzei call() {
        zzbar zzbarVar;
        Context context;
        zzbarVar = this.zzbqf.zzbpx;
        String str = zzbarVar.zzbrz;
        context = this.zzbqf.context;
        return new zzei(zzef.zzb(str, context, false));
    }
}
