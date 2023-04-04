package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzpb;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpc<T extends zzpb> extends Handler implements Runnable {
    private volatile boolean zzagd;
    private final T zzbjv;
    private final zzoz<T> zzbjw;
    public final int zzbjx;
    private final long zzbjy;
    private IOException zzbjz;
    private int zzbka;
    private volatile Thread zzbkb;
    private final /* synthetic */ zzpa zzbkc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpc(zzpa zzpaVar, Looper looper, T t, zzoz<T> zzozVar, int i, long j) {
        super(looper);
        this.zzbkc = zzpaVar;
        this.zzbjv = t;
        this.zzbjw = zzozVar;
        this.zzbjx = i;
        this.zzbjy = j;
    }

    public final void zzbj(int i) {
        IOException iOException = this.zzbjz;
        if (iOException != null && this.zzbka > i) {
            throw iOException;
        }
    }

    public final void zzek(long j) {
        zzpc zzpcVar;
        zzpcVar = this.zzbkc.zzbjt;
        zzpg.checkState(zzpcVar == null);
        this.zzbkc.zzbjt = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void zzm(boolean z) {
        this.zzagd = z;
        this.zzbjz = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.zzbjv.cancelLoad();
            if (this.zzbkb != null) {
                this.zzbkb.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbjw.zza((zzoz<T>) this.zzbjv, elapsedRealtime, elapsedRealtime - this.zzbjy, true);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzbkb = Thread.currentThread();
            if (!this.zzbjv.zzib()) {
                String valueOf = String.valueOf(this.zzbjv.getClass().getSimpleName());
                zzpu.beginSection(valueOf.length() != 0 ? "load:".concat(valueOf) : new String("load:"));
                try {
                    this.zzbjv.zzic();
                    zzpu.endSection();
                } catch (Throwable th) {
                    zzpu.endSection();
                    throw th;
                }
            }
            if (this.zzagd) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e2) {
            if (this.zzagd) {
                return;
            }
            obtainMessage(3, e2).sendToTarget();
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.zzagd) {
                return;
            }
            obtainMessage(3, new zzpe(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.zzagd) {
                return;
            }
            obtainMessage(3, new zzpe(e4)).sendToTarget();
        } catch (Error e5) {
            Log.e("LoadTask", "Unexpected error loading stream", e5);
            if (!this.zzagd) {
                obtainMessage(4, e5).sendToTarget();
            }
            throw e5;
        } catch (InterruptedException unused) {
            zzpg.checkState(this.zzbjv.zzib());
            if (this.zzagd) {
                return;
            }
            sendEmptyMessage(2);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzagd) {
            return;
        }
        if (message.what == 0) {
            execute();
        } else if (message.what == 4) {
            throw ((Error) message.obj);
        } else {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.zzbjy;
            if (this.zzbjv.zzib()) {
                this.zzbjw.zza((zzoz<T>) this.zzbjv, elapsedRealtime, j, false);
                return;
            }
            int i = message.what;
            if (i == 1) {
                this.zzbjw.zza((zzoz<T>) this.zzbjv, elapsedRealtime, j, false);
            } else if (i == 2) {
                this.zzbjw.zza(this.zzbjv, elapsedRealtime, j);
            } else if (i != 3) {
            } else {
                IOException iOException = (IOException) message.obj;
                this.zzbjz = iOException;
                int zza = this.zzbjw.zza((zzoz<T>) this.zzbjv, elapsedRealtime, j, iOException);
                if (zza == 3) {
                    this.zzbkc.zzbju = this.zzbjz;
                } else if (zza != 2) {
                    int i2 = zza == 1 ? 1 : this.zzbka + 1;
                    this.zzbka = i2;
                    zzek(Math.min((i2 - 1) * 1000, 5000));
                }
            }
        }
    }

    private final void execute() {
        ExecutorService executorService;
        zzpc zzpcVar;
        this.zzbjz = null;
        executorService = this.zzbkc.zzbjs;
        zzpcVar = this.zzbkc.zzbjt;
        executorService.execute(zzpcVar);
    }

    private final void finish() {
        this.zzbkc.zzbjt = null;
    }
}
