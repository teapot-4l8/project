package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblc implements zzaig<Object> {
    final /* synthetic */ zzbld zzfuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblc(zzbld zzbldVar) {
        this.zzfuf = zzbldVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        boolean zzn;
        Executor executor;
        zzn = this.zzfuf.zzn(map);
        if (zzn) {
            executor = this.zzfuf.executor;
            executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzblf
                private final zzblc zzfuk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfuk = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbli zzbliVar;
                    zzbliVar = this.zzfuk.zzfuf.zzfuh;
                    zzbliVar.zzajs();
                }
            });
        }
    }
}
