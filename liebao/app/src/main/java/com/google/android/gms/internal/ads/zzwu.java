package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwu extends zzwt<zzavg> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwu(zzwd zzwdVar, Context context, zzann zzannVar) {
        this.zzcjp = zzwdVar;
        this.val$context = context;
        this.zzcjo = zzannVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzavg zzqp() {
        zzwd.zza(this.val$context, "rewarded_video");
        return new zzaap();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzavg zzqq() {
        zzavr zzavrVar;
        zzavrVar = this.zzcjp.zzcji;
        return zzavrVar.zzc(this.val$context, this.zzcjo);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzavg zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
