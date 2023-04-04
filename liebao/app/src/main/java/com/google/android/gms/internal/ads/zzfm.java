package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfm implements Runnable {
    private final /* synthetic */ zzfj zzaaw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfm(zzfj zzfjVar) {
        this.zzaaw = zzfjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzaaw.zzcw();
    }
}
