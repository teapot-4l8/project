package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdr implements zzdwd {
    private final /* synthetic */ zzduv zzvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdr(zzduv zzduvVar) {
        this.zzvr = zzduvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwd
    public final void zza(int i, long j) {
        this.zzvr.zzh(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzdwd
    public final void zza(int i, long j, String str) {
        this.zzvr.zzb(i, System.currentTimeMillis() - j, str);
    }
}
