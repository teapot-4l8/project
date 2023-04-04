package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzdcl implements zzear {
    static final zzear zzbpa = new zzdcl();

    private zzdcl() {
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt zzf(Object obj) {
        return zzebh.zzag(new zzdhb((String) obj) { // from class: com.google.android.gms.internal.ads.zzdco
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putString("ms", this.zzdmo);
            }
        });
    }
}
