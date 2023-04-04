package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpa {
    private final ExecutorService zzbjs;
    private zzpc<? extends zzpb> zzbjt;
    private IOException zzbju;

    public zzpa(String str) {
        this.zzbjs = zzpt.zzbf(str);
    }

    public final <T extends zzpb> long zza(T t, zzoz<T> zzozVar, int i) {
        Looper myLooper = Looper.myLooper();
        zzpg.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzpc(this, myLooper, t, zzozVar, i, elapsedRealtime).zzek(0L);
        return elapsedRealtime;
    }

    public final boolean isLoading() {
        return this.zzbjt != null;
    }

    public final void zzix() {
        this.zzbjt.zzm(false);
    }

    public final void zza(Runnable runnable) {
        zzpc<? extends zzpb> zzpcVar = this.zzbjt;
        if (zzpcVar != null) {
            zzpcVar.zzm(true);
        }
        this.zzbjs.execute(runnable);
        this.zzbjs.shutdown();
    }

    public final void zzbj(int i) {
        IOException iOException = this.zzbju;
        if (iOException != null) {
            throw iOException;
        }
        zzpc<? extends zzpb> zzpcVar = this.zzbjt;
        if (zzpcVar != null) {
            zzpcVar.zzbj(zzpcVar.zzbjx);
        }
    }
}
