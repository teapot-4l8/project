package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqm implements Runnable {
    private final /* synthetic */ zzjm zzajs;
    private final /* synthetic */ zzqj zzbnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqm(zzqj zzqjVar, zzjm zzjmVar) {
        this.zzbnk = zzqjVar;
        this.zzajs = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zze(this.zzajs);
    }
}
