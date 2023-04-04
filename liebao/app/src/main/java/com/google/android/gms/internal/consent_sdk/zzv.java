package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzv implements zzcp<zzp> {
    private final zzct<Application> zza;
    private final zzct<zzab> zzb;
    private final zzct<Handler> zzc;
    private final zzct<Executor> zzd;
    private final zzct<zzal> zze;
    private final zzct<zzaz> zzf;
    private final zzct<zzn> zzg;
    private final zzct<zzz> zzh;
    private final zzct<zze> zzi;

    public zzv(zzct<Application> zzctVar, zzct<zzab> zzctVar2, zzct<Handler> zzctVar3, zzct<Executor> zzctVar4, zzct<zzal> zzctVar5, zzct<zzaz> zzctVar6, zzct<zzn> zzctVar7, zzct<zzz> zzctVar8, zzct<zze> zzctVar9) {
        this.zza = zzctVar;
        this.zzb = zzctVar2;
        this.zzc = zzctVar3;
        this.zzd = zzctVar4;
        this.zze = zzctVar5;
        this.zzf = zzctVar6;
        this.zzg = zzctVar7;
        this.zzh = zzctVar8;
        this.zzi = zzctVar9;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final /* synthetic */ Object zza() {
        return new zzp(this.zza.zza(), this.zzb.zza(), this.zzc.zza(), this.zzd.zza(), this.zze.zza(), this.zzf.zza(), this.zzg.zza(), this.zzh.zza(), this.zzi.zza());
    }
}
