package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfx implements zzesa<zzbzl<VideoController.VideoLifecycleCallbacks>> {
    private final zzesn<zzcil> zzeyk;
    private final zzesn<Executor> zzfxf;
    private final zzcfo zzgjs;

    public zzcfx(zzcfo zzcfoVar, zzesn<zzcil> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzgjs = zzcfoVar;
        this.zzeyk = zzesnVar;
        this.zzfxf = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzfxf.get()));
    }
}
