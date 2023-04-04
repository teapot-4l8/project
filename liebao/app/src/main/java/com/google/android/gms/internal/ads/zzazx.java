package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazx {
    private final Object lock;
    private volatile int zzefb;
    private volatile long zzefc;

    private zzazx() {
        this.lock = new Object();
        this.zzefb = zzazw.zzeex;
        this.zzefc = 0L;
    }

    public final void zzyh() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzefb == zzazw.zzeez) {
                if (this.zzefc + ((Long) zzww.zzra().zzd(zzabq.zzcyg)).longValue() <= currentTimeMillis) {
                    this.zzefb = zzazw.zzeex;
                }
            }
        }
        long currentTimeMillis2 = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzefb != 2) {
                return;
            }
            this.zzefb = 3;
            if (this.zzefb == zzazw.zzeez) {
                this.zzefc = currentTimeMillis2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzazx(zzazu zzazuVar) {
        this();
    }
}
