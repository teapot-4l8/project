package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqr implements Runnable {
    private final /* synthetic */ zzjm zzajy;
    private final /* synthetic */ zzqj zzbnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqr(zzqj zzqjVar, zzjm zzjmVar) {
        this.zzbnk = zzqjVar;
        this.zzajy = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        this.zzajy.zzgr();
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zzf(this.zzajy);
    }
}
