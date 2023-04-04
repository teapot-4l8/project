package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqo implements Runnable {
    private final /* synthetic */ zzht zzajw;
    private final /* synthetic */ zzqj zzbnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqo(zzqj zzqjVar, zzht zzhtVar) {
        this.zzbnk = zzqjVar;
        this.zzajw = zzhtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zzk(this.zzajw);
    }
}
