package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddh implements zzdhe<zzdhb<Bundle>> {
    private final Executor executor;
    private final zzazs zzbqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzddh(Executor executor, zzazs zzazsVar) {
        this.executor = executor;
        this.zzbqn = zzazsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsx)).booleanValue()) {
            return zzebh.zzag(null);
        }
        return zzebh.zzb(this.zzbqn.zzym(), zzddk.zzebv, this.executor);
    }
}
