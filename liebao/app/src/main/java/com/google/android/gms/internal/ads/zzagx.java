package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagx extends UnifiedNativeAd {
    private final zzaex zzdhf;
    private final NativeAd.AdChoicesInfo zzdhg;
    private final zzags zzdhm;
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final VideoController zzcks = new VideoController();
    private final List<MuteThisAdReason> zzdhn = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|(3:24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28)))|(2:41|42)|(7:44|45|46|47|(2:49|50)|52|53)|58|45|46|47|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bb, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bc, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ae A[Catch: RemoteException -> 0x00bb, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00bb, blocks: (B:44:0x00a6, B:46:0x00ae), top: B:56:0x00a6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzagx(zzags zzagsVar) {
        zzaex zzaexVar;
        zzaes zztt;
        zzaes zzaesVar;
        IBinder iBinder;
        this.zzdhm = zzagsVar;
        zzaep zzaepVar = null;
        try {
            List images = zzagsVar.getImages();
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
            List muteThisAdReasons = this.zzdhm.getMuteThisAdReasons();
            if (muteThisAdReasons != null) {
                for (Object obj2 : muteThisAdReasons) {
                    zzys zzg = obj2 instanceof IBinder ? zzyr.zzg((IBinder) obj2) : null;
                    if (zzg != null) {
                        this.zzdhn.add(new zzyt(zzg));
                    }
                }
            }
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        try {
            zztt = this.zzdhm.zztt();
        } catch (RemoteException e4) {
            zzbao.zzc("", e4);
        }
        if (zztt != null) {
            zzaexVar = new zzaex(zztt);
            this.zzdhf = zzaexVar;
            if (this.zzdhm.zztu() != null) {
                zzaepVar = new zzaep(this.zzdhm.zztu());
            }
            this.zzdhg = zzaepVar;
        }
        zzaexVar = null;
        this.zzdhf = zzaexVar;
        if (this.zzdhm.zztu() != null) {
        }
        this.zzdhg = zzaepVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhm.zzts();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzka() {
        try {
            IObjectWrapper zztv = this.zzdhm.zztv();
            if (zztv != null) {
                return ObjectWrapper.unwrap(zztv);
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdhm.performClick(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhm.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhm.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdhm.getHeadline();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdhm.getBody();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzdhf;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdhm.getCallToAction();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdhm.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdhm.getStore();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdhm.getPrice();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdhm.getVideoController() != null) {
                this.zzcks.zza(this.zzdhm.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbao.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcks;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdhg;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdhm.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdhm.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdhm.zzud();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdhm.isCustomClickGestureEnabled();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdhm.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdhn;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdhm.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdhm.destroy();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdhm.zza(new zzahl(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbao.zzex("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdhm.zza((zzys) null);
            } else if (muteThisAdReason instanceof zzyt) {
                this.zzdhm.zza(((zzyt) muteThisAdReason).zzrl());
            } else {
                zzbao.zzex("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdhm.zza(new zzyp(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdhm.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdhm.getAdvertiser();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final MediaContent getMediaContent() {
        try {
            if (this.zzdhm.zzue() != null) {
                return new zzaab(this.zzdhm.zzue());
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final ResponseInfo getResponseInfo() {
        zzzc zzzcVar;
        try {
            zzzcVar = this.zzdhm.zzkm();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            zzzcVar = null;
        }
        return ResponseInfo.zza(zzzcVar);
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdhm.zza(new zzaaq(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to setOnPaidEventListener", e2);
        }
    }
}
