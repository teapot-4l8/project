package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaab implements MediaContent {
    private final VideoController zzcks = new VideoController();
    private final zzaer zzclt;

    public zzaab(zzaer zzaerVar) {
        this.zzclt = zzaerVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzclt.getAspectRatio();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.zzclt.getDuration();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.zzclt.getCurrentTime();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.zzclt.getVideoController() != null) {
                this.zzcks.zza(this.zzclt.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbao.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcks;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zzclt.hasVideoContent();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzclt.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final Drawable getMainImage() {
        try {
            IObjectWrapper zztr = this.zzclt.zztr();
            if (zztr != null) {
                return (Drawable) ObjectWrapper.unwrap(zztr);
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    public final zzaer zzrz() {
        return this.zzclt;
    }
}
