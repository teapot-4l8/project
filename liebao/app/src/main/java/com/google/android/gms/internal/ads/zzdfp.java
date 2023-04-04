package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfp implements zzdhe<zzdfq> {
    private final Context context;
    private final zzebs zzhdd;
    private final Set<String> zzhdr;

    public zzdfp(zzebs zzebsVar, Context context, Set<String> set) {
        this.zzhdd = zzebsVar;
        this.context = context;
        this.zzhdr = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdfq> zzatu() {
        return this.zzhdd.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfs
            private final zzdfp zzhfj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfj = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhfj.zzaui();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfq zzaui() {
        boolean zze;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwh)).booleanValue()) {
            zze = zzdfq.zze(this.zzhdr);
            if (zze) {
                return new zzdfq(com.google.android.gms.ads.internal.zzr.zzlk().getVersion(this.context));
            }
        }
        return new zzdfq(null);
    }
}
