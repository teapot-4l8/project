package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztr extends zzbbe<zztw> {
    private final /* synthetic */ zzto zzbwj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztr(zzto zztoVar) {
        this.zzbwj = zztoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbe, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbwj.disconnect();
        return super.cancel(z);
    }
}
