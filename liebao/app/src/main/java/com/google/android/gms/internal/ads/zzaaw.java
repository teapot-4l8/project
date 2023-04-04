package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaaw extends zzzh {
    private final VideoController.VideoLifecycleCallbacks zzaeb;

    public zzaaw(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzaeb = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoStart() {
        this.zzaeb.onVideoStart();
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoPlay() {
        this.zzaeb.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoPause() {
        this.zzaeb.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoEnd() {
        this.zzaeb.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoMute(boolean z) {
        this.zzaeb.onVideoMute(z);
    }
}
