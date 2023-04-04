package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmr implements Runnable {
    private final /* synthetic */ zzms zzbdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzms zzmsVar) {
        this.zzbdv = zzmsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbdv.zzhx();
    }
}
