package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddy implements zzdhe<zzdhb<Bundle>> {
    private final zzdlr zzhej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzddy(zzdlr zzdlrVar) {
        this.zzhej = zzdlrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhb<Bundle>> zzatu() {
        zzdlr zzdlrVar = this.zzhej;
        return zzebh.zzag((zzdlrVar == null || zzdlrVar.zzavo() == null || this.zzhej.zzavo().isEmpty()) ? null : new zzdhb(this) { // from class: com.google.android.gms.internal.ads.zzddx
            private final zzddy zzhei;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhei = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Object obj) {
                this.zzhei.zzo((Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Bundle bundle) {
        bundle.putString("key_schema", this.zzhej.zzavo());
    }
}
