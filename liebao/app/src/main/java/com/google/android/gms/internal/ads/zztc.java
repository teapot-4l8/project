package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztc implements zzrr {
    private final /* synthetic */ zzta zzbvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztc(zzta zztaVar) {
        this.zzbvr = zztaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrr
    public final void zzq(boolean z) {
        if (!z) {
            this.zzbvr.disconnect();
        } else {
            this.zzbvr.connect();
        }
    }
}
