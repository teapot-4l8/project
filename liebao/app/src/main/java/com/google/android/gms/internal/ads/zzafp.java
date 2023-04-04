package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafp extends NativeContentAd {
    private final NativeAd.AdChoicesInfo zzdhg;
    private final zzafk zzdhh;
    private final zzaex zzdhi;
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final VideoController zzcks = new VideoController();

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|24|25|(7:27|28|29|30|(2:32|33)|35|36)|41|28|29|30|(0)|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074 A[Catch: RemoteException -> 0x0081, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0081, blocks: (B:30:0x006c, B:32:0x0074), top: B:38:0x006c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzafp(zzafk zzafkVar) {
        zzaex zzaexVar;
        zzaes zztw;
        zzaes zzaesVar;
        IBinder iBinder;
        this.zzdhh = zzafkVar;
        zzaep zzaepVar = null;
        try {
            List images = zzafkVar.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzaesVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        if (queryLocalInterface instanceof zzaes) {
                            zzaesVar = (zzaes) queryLocalInterface;
                        } else {
                            zzaesVar = new zzaeu(iBinder);
                        }
                    }
                    if (zzaesVar != null) {
                        this.zzdhe.add(new zzaex(zzaesVar));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        try {
            zztw = this.zzdhh.zztw();
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        if (zztw != null) {
            zzaexVar = new zzaex(zztw);
            this.zzdhi = zzaexVar;
            if (this.zzdhh.zztu() != null) {
                zzaepVar = new zzaep(this.zzdhh.zztu());
            }
            this.zzdhg = zzaepVar;
        }
        zzaexVar = null;
        this.zzdhi = zzaexVar;
        if (this.zzdhh.zztu() != null) {
        }
        this.zzdhg = zzaepVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhh.zzts();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdhh.performClick(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhh.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhh.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.zzdhh.getHeadline();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.zzdhh.getBody();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.zzdhi;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzdhh.getCallToAction();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.zzdhh.getAdvertiser();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdhh.getVideoController() != null) {
                this.zzcks.zza(this.zzdhh.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbao.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcks;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.zzdhh.getExtras();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdhg;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdhh.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.zzdhh.destroy();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
