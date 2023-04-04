package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwi extends zzwt<zzash> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzwd zzcjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwi(zzwd zzwdVar, Activity activity) {
        this.zzcjp = zzwdVar;
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzash zzqp() {
        zzwd.zza(this.val$activity, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzash zzqq() {
        zzasf zzasfVar;
        zzasfVar = this.zzcjp.zzcjk;
        return zzasfVar.zze(this.val$activity);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzash zza(zzxz zzxzVar) {
        return zzxzVar.zzb(ObjectWrapper.wrap(this.val$activity));
    }
}
