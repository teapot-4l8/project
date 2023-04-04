package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdd extends zzaeq {
    private final zzcdr zzgeo;
    private IObjectWrapper zzgfm;

    public zzcdd(zzcdr zzcdrVar) {
        this.zzgeo = zzcdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getAspectRatio() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyw)).booleanValue()) {
            if (this.zzgeo.getMediaContentAspectRatio() != 0.0f) {
                return this.zzgeo.getMediaContentAspectRatio();
            }
            if (this.zzgeo.getVideoController() != null) {
                return zzaoi();
            }
            IObjectWrapper iObjectWrapper = this.zzgfm;
            if (iObjectWrapper != null) {
                return zzat(iObjectWrapper);
            }
            zzaes zzaoq = this.zzgeo.zzaoq();
            if (zzaoq == null) {
                return 0.0f;
            }
            float width = (zzaoq == null || zzaoq.getWidth() == -1 || zzaoq.getHeight() == -1) ? 0.0f : zzaoq.getWidth() / zzaoq.getHeight();
            return width != 0.0f ? width : zzat(zzaoq.zztn());
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getDuration() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null) {
            return this.zzgeo.getVideoController().getDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final float getCurrentTime() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null) {
            return this.zzgeo.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final zzzd getVideoController() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue()) {
            return this.zzgeo.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final boolean hasVideoContent() {
        return ((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && this.zzgeo.getVideoController() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zza(zzage zzageVar) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyx)).booleanValue() && (this.zzgeo.getVideoController() instanceof zzbgc)) {
            ((zzbgc) this.zzgeo.getVideoController()).zza(zzageVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctx)).booleanValue()) {
            this.zzgfm = iObjectWrapper;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final IObjectWrapper zztr() {
        IObjectWrapper iObjectWrapper = this.zzgfm;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaes zzaoq = this.zzgeo.zzaoq();
        if (zzaoq == null) {
            return null;
        }
        return zzaoq.zztn();
    }

    private final float zzaoi() {
        try {
            return this.zzgeo.getVideoController().getAspectRatio();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Remote exception getting video controller aspect ratio.", e2);
            return 0.0f;
        }
    }

    private static float zzat(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }
}
