package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzctu implements zzbpd {
    private final zzbfi zzewn;

    private zzctu(zzbfi zzbfiVar) {
        this.zzewn = zzbfiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbpd zzm(zzbfi zzbfiVar) {
        return new zzctu(zzbfiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzzd getVideoController() {
        return this.zzewn.zzabv();
    }
}
