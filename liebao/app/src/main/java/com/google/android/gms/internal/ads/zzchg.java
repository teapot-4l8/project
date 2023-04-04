package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchg extends zzakd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzaef {
    private zzzd zzggt;
    private View zzggy;
    private zzcdf zzghx;
    private boolean zzevf = false;
    private boolean zzglb = false;

    public zzchg(zzcdf zzcdfVar, zzcdr zzcdrVar) {
        this.zzggy = zzcdrVar.zzaos();
        this.zzggt = zzcdrVar.getVideoController();
        this.zzghx = zzcdfVar;
        if (zzcdrVar.zzaot() != null) {
            zzcdrVar.zzaot().zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zza(IObjectWrapper iObjectWrapper, zzakf zzakfVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzevf) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Instream ad can not be shown after destroy().");
            zza(zzakfVar, 2);
        } else if (this.zzggy == null || this.zzggt == null) {
            String str = this.zzggy == null ? "can not get video view." : "can not get video controller.";
            com.google.android.gms.ads.internal.util.zzd.zzex(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzakfVar, 0);
        } else if (this.zzglb) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Instream ad should not be used again.");
            zza(zzakfVar, 1);
        } else {
            this.zzglb = true;
            zzaqe();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzggy, new ViewGroup.LayoutParams(-1, -1));
            com.google.android.gms.ads.internal.zzr.zzls();
            zzbbm.zza(this.zzggy, (ViewTreeObserver.OnGlobalLayoutListener) this);
            com.google.android.gms.ads.internal.zzr.zzls();
            zzbbm.zza(this.zzggy, (ViewTreeObserver.OnScrollChangedListener) this);
            zzaqf();
            try {
                zzakfVar.zzuo();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void zzr(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new zzchi(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final zzzd getVideoController() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzevf) {
            com.google.android.gms.ads.internal.util.zzd.zzex("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        return this.zzggt;
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final zzaer zzue() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzevf) {
            com.google.android.gms.ads.internal.util.zzd.zzex("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar == null || zzcdfVar.zzaol() == null) {
            return null;
        }
        return this.zzghx.zzaol().zzue();
    }

    @Override // com.google.android.gms.internal.ads.zzaka
    public final void destroy() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaqe();
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar.destroy();
        }
        this.zzghx = null;
        this.zzggy = null;
        this.zzggt = null;
        this.zzevf = true;
    }

    private final void zzaqe() {
        View view = this.zzggy;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zzggy);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzaqf();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzaqf();
    }

    @Override // com.google.android.gms.internal.ads.zzaef
    public final void zzto() {
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzchj
            private final zzchg zzglc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzglc = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzglc.zzaqg();
            }
        });
    }

    private final void zzaqf() {
        View view;
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar == null || (view = this.zzggy) == null) {
            return;
        }
        zzcdfVar.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcdf.zzz(this.zzggy));
    }

    private static void zza(zzakf zzakfVar, int i) {
        try {
            zzakfVar.zzdd(i);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqg() {
        try {
            destroy();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }
}
