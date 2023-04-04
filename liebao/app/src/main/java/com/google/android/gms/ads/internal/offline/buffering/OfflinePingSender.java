package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.ads.zzank;
import com.google.android.gms.internal.ads.zzaru;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class OfflinePingSender extends Worker {
    private final zzaru zzdsh;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zzdsh = zzww.zzqx().zzb(context, new zzank());
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        try {
            this.zzdsh.zzwe();
            return ListenableWorker.a.a();
        } catch (RemoteException unused) {
            return ListenableWorker.a.c();
        }
    }
}
