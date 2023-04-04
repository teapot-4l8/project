package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwr extends zzwt<zzafd> {
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ View zzcjr;
    private final /* synthetic */ HashMap zzcjs;
    private final /* synthetic */ HashMap zzcjt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwr(zzwd zzwdVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzcjp = zzwdVar;
        this.zzcjr = view;
        this.zzcjs = hashMap;
        this.zzcjt = hashMap2;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzafd zzqp() {
        zzwd.zza(this.zzcjr.getContext(), "native_ad_view_holder_delegate");
        return new zzaak();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzafd zzqq() {
        zzagz zzagzVar;
        zzagzVar = this.zzcjp.zzcjl;
        return zzagzVar.zzb(this.zzcjr, this.zzcjs, this.zzcjt);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzafd zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.zzcjr), ObjectWrapper.wrap(this.zzcjs), ObjectWrapper.wrap(this.zzcjt));
    }
}
