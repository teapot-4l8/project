package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhy implements zzdhe<zzdhv> {
    private final Executor executor;
    private final PackageInfo zzdvo;
    private final int zzgsm;
    private final zzazo zzhgy;
    private final String zzhhc;

    public zzdhy(zzazo zzazoVar, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zzhgy = zzazoVar;
        this.executor = executor;
        this.zzhhc = str;
        this.zzdvo = packageInfo;
        this.zzgsm = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhv> zzatu() {
        return zzebh.zzb(zzebh.zzb(this.zzhgy.zza(this.zzhhc, this.zzdvo, this.zzgsm), zzdhx.zzebv, this.executor), Throwable.class, new zzear(this) { // from class: com.google.android.gms.internal.ads.zzdia
            private final zzdhy zzhhe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhe = this;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzhhe.zzg((Throwable) obj);
            }
        }, this.executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzg(Throwable th) {
        return zzebh.zzag(new zzdhv(this.zzhhc));
    }
}
