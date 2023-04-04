package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzis extends Thread {
    private final /* synthetic */ AudioTrack zzajz;
    private final /* synthetic */ zzit zzaka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzit zzitVar, AudioTrack audioTrack) {
        this.zzaka = zzitVar;
        this.zzajz = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        try {
            this.zzajz.flush();
            this.zzajz.release();
        } finally {
            conditionVariable = this.zzaka.zzaki;
            conditionVariable.open();
        }
    }
}
