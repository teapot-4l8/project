package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzcjk implements zzcab {
    private final zzbfi zzewn;

    private zzcjk(zzbfi zzbfiVar) {
        this.zzewn = zzbfiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcab zzk(zzbfi zzbfiVar) {
        return new zzcjk(zzbfiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcab
    public final void zzanm() {
        this.zzewn.destroy();
    }
}
