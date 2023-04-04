package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbbc implements zzebi<Object> {
    private final /* synthetic */ String zzekn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbc(String str) {
        this.zzekn = str;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void onSuccess(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.zzr.zzkz().zzb(th, this.zzekn);
    }
}
