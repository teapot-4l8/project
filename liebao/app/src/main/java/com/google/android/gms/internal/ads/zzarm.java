package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarm extends NativeAd {
    private final zzags zzdhm;
    private final zzarn zzdrx;
    private final NativeAd.AdChoicesInfo zzdry;
    private final List<NativeAd.Image> zzdhe = new ArrayList();
    private final List<MuteThisAdReason> zzdhn = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(3:2|3|(2:5|(5:8|(1:10)(1:17)|(3:12|13|14)(1:16)|15|6)))|19|20|(2:22|(5:25|(1:27)(1:34)|(3:29|30|31)(1:33)|32|23))|(2:36|37)|(7:39|40|41|42|(2:44|45)|47|48)|53|40|41|42|(0)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a4, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a5, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0097 A[Catch: RemoteException -> 0x00a4, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00a4, blocks: (B:39:0x008f, B:41:0x0097), top: B:51:0x008f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzarm(zzags zzagsVar) {
        zzarn zzarnVar;
        zzaes zztt;
        this.zzdhm = zzagsVar;
        zzarl zzarlVar = null;
        try {
            List images = zzagsVar.getImages();
            if (images != null) {
                for (Object obj : images) {
                    zzaes zzo = obj instanceof IBinder ? zzaev.zzo((IBinder) obj) : null;
                    if (zzo != null) {
                        this.zzdhe.add(new zzarn(zzo));
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
            zzarnVar = new zzarn(zztt);
            this.zzdrx = zzarnVar;
            if (this.zzdhm.zztu() != null) {
                zzarlVar = new zzarl(this.zzdhm.zztu());
            }
            this.zzdry = zzarlVar;
        }
        zzarnVar = null;
        this.zzdrx = zzarnVar;
        if (this.zzdhm.zztu() != null) {
        }
        this.zzdry = zzarlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.nativead.NativeAd
    /* renamed from: zzts */
    public final IObjectWrapper zzjw() {
        try {
            return this.zzdhm.zzts();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdhm.performClick(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdhm.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdhm.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getHeadline() {
        try {
            return this.zzdhm.getHeadline();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdhe;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getBody() {
        try {
            return this.zzdhm.getBody();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final NativeAd.Image getIcon() {
        return this.zzdrx;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getCallToAction() {
        try {
            return this.zzdhm.getCallToAction();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
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

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getStore() {
        try {
            return this.zzdhm.getStore();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getPrice() {
        try {
            return this.zzdhm.getPrice();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdry;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
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

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdhm.zzud();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zzdhm.isCustomClickGestureEnabled();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdhm.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdhn;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdhm.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void destroy() {
        try {
            this.zzdhm.destroy();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdhm.zza(new zzarv(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
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

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdhm.zza(new zzyp(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdhm.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdhm.getAdvertiser();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
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

    @Override // com.google.android.gms.ads.nativead.NativeAd
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

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzdhm.zza(new zzaaq(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to setOnPaidEventListener", e2);
        }
    }
}
