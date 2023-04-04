package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwo extends zzwt<zzxq> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ zzvt zzcjq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwo(zzwd zzwdVar, Context context, zzvt zzvtVar, String str) {
        this.zzcjp = zzwdVar;
        this.val$context = context;
        this.zzcjq = zzvtVar;
        this.zzcjn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxq zzqp() {
        zzwd.zza(this.val$context, "search");
        return new zzaah();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxq zzqq() {
        zzvo zzvoVar;
        zzvoVar = this.zzcjp.zzcje;
        return zzvoVar.zza(this.val$context, this.zzcjq, this.zzcjn, null, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxq zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcjq, this.zzcjn, 204890000);
    }
}
