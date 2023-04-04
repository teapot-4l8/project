package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbbj implements zzebi<T> {
    private final /* synthetic */ zzbbi zzeks;
    private final /* synthetic */ zzbbg zzekt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbj(zzbbh zzbbhVar, zzbbi zzbbiVar, zzbbg zzbbgVar) {
        this.zzeks = zzbbiVar;
        this.zzekt = zzbbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void onSuccess(T t) {
        this.zzeks.zzg(t);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        this.zzekt.run();
    }
}
