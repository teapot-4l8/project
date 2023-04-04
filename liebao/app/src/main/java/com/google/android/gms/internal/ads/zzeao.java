package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeao implements Runnable {
    private final /* synthetic */ zzeal zzicx;
    private final /* synthetic */ zzebt zzicy;
    private final /* synthetic */ int zzicz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeao(zzeal zzealVar, zzebt zzebtVar, int i) {
        this.zzicx = zzealVar;
        this.zzicy = zzebtVar;
        this.zzicz = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzicy.isCancelled()) {
                this.zzicx.zzict = null;
                this.zzicx.cancel(false);
            } else {
                this.zzicx.zza(this.zzicz, this.zzicy);
            }
        } finally {
            this.zzicx.zza((zzdyv) null);
        }
    }
}
