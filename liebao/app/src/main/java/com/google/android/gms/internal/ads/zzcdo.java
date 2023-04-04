package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdo extends zzzg {
    private final Object lock = new Object();
    @Nullable
    private zzzd zzggp;
    @Nullable
    private final zzaoh zzggq;

    public zzcdo(@Nullable zzzd zzzdVar, @Nullable zzaoh zzaohVar) {
        this.zzggp = zzzdVar;
        this.zzggq = zzaohVar;
    }

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
        zzaoh zzaohVar = this.zzggq;
        if (zzaohVar != null) {
            return zzaohVar.getVideoDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getCurrentTime() {
        zzaoh zzaohVar = this.zzggq;
        if (zzaohVar != null) {
            return zzaohVar.getVideoCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zza(zzzi zzziVar) {
        synchronized (this.lock) {
            if (this.zzggp != null) {
                this.zzggp.zza(zzziVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzzi zzrm() {
        synchronized (this.lock) {
            if (this.zzggp != null) {
                return this.zzggp.zzrm();
            }
            return null;
        }
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
