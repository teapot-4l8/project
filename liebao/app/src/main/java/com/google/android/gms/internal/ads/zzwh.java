package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwh extends zzwt<zzazc> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwh(zzwd zzwdVar, Context context, zzann zzannVar) {
        this.val$context = context;
        this.zzcjo = zzannVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* bridge */ /* synthetic */ zzazc zzqp() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzwt
    /* renamed from: zzqr */
    public final zzazc zzqq() {
        try {
            return ((zzazh) zzban.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzwk.zzbys)).zze(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
        } catch (RemoteException | zzbap | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzazc zza(zzxz zzxzVar) {
        return zzxzVar.zzb(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
