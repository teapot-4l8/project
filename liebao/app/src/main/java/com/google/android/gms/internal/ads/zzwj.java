package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwj extends zzwt<zzaru> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzann zzcjo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwj(zzwd zzwdVar, Context context, zzann zzannVar) {
        this.val$context = context;
        this.zzcjo = zzannVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* bridge */ /* synthetic */ zzaru zzqp() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzwt
    /* renamed from: zzqs */
    public final zzaru zzqq() {
        try {
            return ((zzarz) zzban.zza(this.val$context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzwm.zzbys)).zzc(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
        } catch (RemoteException | zzbap | NullPointerException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaru zza(zzxz zzxzVar) {
        return zzxzVar.zzc(ObjectWrapper.wrap(this.val$context), this.zzcjo, 204890000);
    }
}
