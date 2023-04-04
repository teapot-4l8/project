package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzzd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    private zzzd zzaea;
    private VideoLifecycleCallbacks zzaeb;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void zza(zzzd zzzdVar) {
        synchronized (this.lock) {
            this.zzaea = zzzdVar;
            if (this.zzaeb != null) {
                setVideoLifecycleCallbacks(this.zzaeb);
            }
        }
    }

    public final zzzd zzdz() {
        zzzd zzzdVar;
        synchronized (this.lock) {
            zzzdVar = this.zzaea;
        }
        return zzzdVar;
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return;
            }
            try {
                this.zzaea.play();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call play on video controller.", e2);
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return;
            }
            try {
                this.zzaea.pause();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call pause on video controller.", e2);
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return;
            }
            try {
                this.zzaea.stop();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call stop on video controller.", e2);
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return;
            }
            try {
                this.zzaea.mute(z);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call mute on video controller.", e2);
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return true;
            }
            try {
                return this.zzaea.isMuted();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call isMuted on video controller.", e2);
                return true;
            }
        }
    }

    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0;
            }
            try {
                return this.zzaea.getPlaybackState();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call getPlaybackState on video controller.", e2);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return false;
            }
            try {
                return this.zzaea.isCustomControlsEnabled();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call isUsingCustomPlayerControls.", e2);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return false;
            }
            try {
                return this.zzaea.isClickToExpandEnabled();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call isClickToExpandEnabled.", e2);
                return false;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                return this.zzaea.getDuration();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call getDuration on video controller.", e2);
                return 0.0f;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                return this.zzaea.getCurrentTime();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call getCurrentTime on video controller.", e2);
                return 0.0f;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzaeb = videoLifecycleCallbacks;
            if (this.zzaea == null) {
                return;
            }
            try {
                this.zzaea.zza(new zzaaw(videoLifecycleCallbacks));
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e2);
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzaeb;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzaea != null;
        }
        return z;
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzaea == null) {
                return 0.0f;
            }
            try {
                return this.zzaea.getAspectRatio();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call getAspectRatio on video controller.", e2);
                return 0.0f;
            }
        }
    }
}
