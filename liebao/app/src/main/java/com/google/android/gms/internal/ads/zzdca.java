package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdca implements zzear<zzauj, zzdcb> {
    private Executor executor;
    private zzcon zzhcz;

    public zzdca(Executor executor, zzcon zzconVar) {
        this.executor = executor;
        this.zzhcz = zzconVar;
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final /* synthetic */ zzebt<zzdcb> zzf(zzauj zzaujVar) {
        final zzauj zzaujVar2 = zzaujVar;
        return zzebh.zzb(this.zzhcz.zzg(zzaujVar2), new zzear(zzaujVar2) { // from class: com.google.android.gms.internal.ads.zzdbz
            private final zzauj zzgca;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgca = zzaujVar2;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return zzebh.zzag(new zzdcb(new JsonReader(new InputStreamReader((InputStream) obj))).zzn(this.zzgca.zzdys));
            }
        }, this.executor);
    }
}
