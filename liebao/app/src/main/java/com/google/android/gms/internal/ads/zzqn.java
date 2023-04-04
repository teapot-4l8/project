package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqn implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ int zzbnl;
    private final /* synthetic */ long zzbnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqn(zzqj zzqjVar, int i, long j) {
        this.zzbnk = zzqjVar;
        this.zzbnl = i;
        this.zzbnm = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zzg(this.zzbnl, this.zzbnm);
    }
}
