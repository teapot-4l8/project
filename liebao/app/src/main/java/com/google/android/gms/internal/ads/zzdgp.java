package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgp implements zzdhe<zzdgq> {
    private final Context context;
    private final zzbar zzbpx;
    private final zzebs zzgka;

    public zzdgp(zzebs zzebsVar, Context context, zzbar zzbarVar) {
        this.zzgka = zzebsVar;
        this.context = context;
        this.zzbpx = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdgq> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgs
            private final zzdgp zzhgd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhgd = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhgd.zzaun();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdgq zzaun() {
        boolean isCallerInstantApp = Wrappers.packageManager(this.context).isCallerInstantApp();
        com.google.android.gms.ads.internal.zzr.zzkv();
        boolean zzax = com.google.android.gms.ads.internal.util.zzj.zzax(this.context);
        String str = this.zzbpx.zzbrz;
        com.google.android.gms.ads.internal.zzr.zzkx();
        boolean zzzx = com.google.android.gms.ads.internal.util.zzr.zzzx();
        com.google.android.gms.ads.internal.zzr.zzkv();
        return new zzdgq(isCallerInstantApp, zzax, str, zzzx, com.google.android.gms.ads.internal.util.zzj.zzau(this.context), DynamiteModule.getRemoteVersion(this.context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.context, ModuleDescriptor.MODULE_ID));
    }
}
