package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzamv implements zzbbg {
    private final /* synthetic */ zzbbe zzdjs;
    private final /* synthetic */ zzalv zzdmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamv(zzamt zzamtVar, zzbbe zzbbeVar, zzalv zzalvVar) {
        this.zzdjs = zzbbeVar;
        this.zzdmf = zzalvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbg
    public final void run() {
        this.zzdjs.setException(new zzamh("Unable to obtain a JavascriptEngine."));
        this.zzdmf.release();
    }
}
