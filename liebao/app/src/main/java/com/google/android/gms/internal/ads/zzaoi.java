package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoi extends zzzg {
    private final Object lock = new Object();
    private volatile zzzi zzdor;

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void play() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void pause() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void stop() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void mute(boolean z) {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isMuted() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final int getPlaybackState() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getDuration() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getCurrentTime() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zza(zzzi zzziVar) {
        synchronized (this.lock) {
            this.zzdor = zzziVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzzi zzrm() {
        zzzi zzziVar;
        synchronized (this.lock) {
            zzziVar = this.zzdor;
        }
        return zzziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getAspectRatio() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isCustomControlsEnabled() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isClickToExpandEnabled() {
        throw new RemoteException();
    }
}
