package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwq extends zzwt<zzxj> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcjn;
    private final /* synthetic */ zzann zzcjo;
    private final /* synthetic */ zzwd zzcjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwq(zzwd zzwdVar, Context context, String str, zzann zzannVar) {
        this.zzcjp = zzwdVar;
        this.val$context = context;
        this.zzcjn = str;
        this.zzcjo = zzannVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzxj zzqp() {
        zzwd.zza(this.val$context, "native_ad");
        return new zzaad();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxj zzqq() {
        zzvl zzvlVar;
        zzvlVar = this.zzcjp.zzcjf;
        return zzvlVar.zza(this.val$context, this.zzcjn, this.zzcjo);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxj zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.val$context), this.zzcjn, this.zzcjo, 204890000);
    }
}
