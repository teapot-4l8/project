package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafl extends NativeAppInstallAd {
    private final zzafg zzdhd;
    private final zzaex zzdhf;
    private final NativeAd.AdChoicesInfo zzdhg;
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
    public zzafl(zzafg zzafgVar) {
        zzaex zzaexVar;
        zzaes zztt;
        zzaes zzaesVar;
        IBinder iBinder;
        this.zzdhd = zzafgVar;
        zzaep zzaepVar = null;
        try {
            List images = zzafgVar.getImages();
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
            zztt = this.zzdhd.zztt();
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        if (zztt != null) {
            zzaexVar = new zzaex(zztt);
            this.zzdhf = zzaexVar;
            if (this.zzdhd.zztu() != null) {
                zzaepVar = new zzaep(this.zzdhd.zztu());
            }
            this.zzdhg = zzaepVar;
        }
        zzaexVar = null;
        this.zzdhf = zzaexVar;
        if (this.zzdhd.zztu() != null) {
        }
        this.zzdhg = zzaepVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhd.zzts();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdhd.performClick(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhd.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhd.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.zzdhd.getHeadline();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.zzdhd.getBody();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.zzdhf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzdhd.getCallToAction();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdhd.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.zzdhd.getStore();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.zzdhd.getPrice();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdhd.getVideoController() != null) {
                this.zzcks.zza(this.zzdhd.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbao.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcks;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdhg;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdhd.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.zzdhd.getExtras();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.zzdhd.destroy();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
