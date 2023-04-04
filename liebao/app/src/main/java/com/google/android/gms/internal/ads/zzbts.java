package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbts extends zzbxq<zzbtp> {
    public zzbts(Set<zzbzl<zzbtp>> set) {
        super(set);
    }

    public final void zzce(Context context) {
        zza(new zzbxs(context) { // from class: com.google.android.gms.internal.ads.zzbtr
            private final Context zzdbt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtp) obj).zzce(this.zzdbt);
            }
        });
    }

    public final void zzcf(Context context) {
        zza(new zzbxs(context) { // from class: com.google.android.gms.internal.ads.zzbtu
            private final Context zzdbt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtp) obj).zzcf(this.zzdbt);
            }
        });
    }

    public final void zzcg(Context context) {
        zza(new zzbxs(context) { // from class: com.google.android.gms.internal.ads.zzbtt
            private final Context zzdbt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtp) obj).zzcg(this.zzdbt);
            }
        });
    }

    public final void zza(zzcab zzcabVar, Executor executor) {
        zza(zzbzl.zzb(new zzbtw(this, zzcabVar), executor));
    }
}
