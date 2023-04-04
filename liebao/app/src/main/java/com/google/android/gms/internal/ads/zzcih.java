package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcih implements Callable<zzchu> {
    private final Context context;
    private final zzbfq zzbqk;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final zzbar zzdvi;
    private final zzei zzeus;
    private final zzdup zzftn;
    private final Executor zzfur;
    private final com.google.android.gms.ads.internal.zzb zzgkn;

    public zzcih(Context context, Executor executor, zzei zzeiVar, zzbar zzbarVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbfq zzbfqVar, zzcsh zzcshVar, zzdup zzdupVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        this.context = context;
        this.zzfur = executor;
        this.zzeus = zzeiVar;
        this.zzdvi = zzbarVar;
        this.zzgkn = zzbVar;
        this.zzbqk = zzbfqVar;
        this.zzdji = zzcshVar;
        this.zzftn = zzdupVar;
        this.zzdje = zzcmbVar;
        this.zzdjf = zzdtwVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzchu call() {
        zzchu zzchuVar = new zzchu(this);
        zzchuVar.zzaqh();
        return zzchuVar;
    }
}
