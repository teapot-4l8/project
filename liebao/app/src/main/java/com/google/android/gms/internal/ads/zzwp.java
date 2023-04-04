package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwp extends zzwt<zzyh> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwd zzcjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwp(zzwd zzwdVar, Context context) {
        this.zzcjp = zzwdVar;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzyh zzqp() {
        zzwd.zza(this.val$context, "mobile_ads_settings");
        return new zzaaj();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzyh zzqq() {
        zzaaa zzaaaVar;
        zzaaaVar = this.zzcjp.zzcjg;
        return zzaaaVar.zzh(this.val$context);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzyh zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.val$context), 204890000);
    }
}
