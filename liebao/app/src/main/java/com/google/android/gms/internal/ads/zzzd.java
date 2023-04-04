package com.google.android.gms.internal.ads;

import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzzd extends IInterface {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    int getPlaybackState();

    boolean isClickToExpandEnabled();

    boolean isCustomControlsEnabled();

    boolean isMuted();

    void mute(boolean z);

    void pause();

    void play();

    void stop();

    void zza(zzzi zzziVar);

    zzzi zzrm();
}
