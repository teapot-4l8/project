package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfv implements Runnable {
    private final /* synthetic */ zzbft zzeuo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfv(zzbft zzbftVar) {
        this.zzeuo = zzbftVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbfi zzbfiVar;
        zzbfiVar = this.zzeuo.zzeul;
        zzbfiVar.destroy();
    }
}
