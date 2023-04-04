package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalp implements Runnable {
    private final /* synthetic */ zzakv zzdld;
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalp(zzale zzaleVar, zzalz zzalzVar, zzakv zzakvVar) {
        this.zzdlf = zzaleVar;
        this.zzdlg = zzalzVar;
        this.zzdld = zzakvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.zzdlf.lock;
        synchronized (obj) {
            if (this.zzdlg.getStatus() != -1 && this.zzdlg.getStatus() != 1) {
                this.zzdlg.reject();
                zzebs zzebsVar = zzbat.zzeki;
                zzakv zzakvVar = this.zzdld;
                zzakvVar.getClass();
                zzebsVar.execute(zzalo.zzb(zzakvVar));
                com.google.android.gms.ads.internal.util.zzd.zzed("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
