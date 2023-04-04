package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzahc;
import com.google.android.gms.internal.ads.zzahe;
import com.google.android.gms.internal.ads.zzahg;
import com.google.android.gms.internal.ads.zzahh;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzank;
import com.google.android.gms.internal.ads.zzarp;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzvj;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzzl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class AdLoader {
    private final Context context;
    private final zzvr zzacy;
    private final zzxi zzacz;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static class Builder {
        private final Context context;
        private final zzxj zzacx;

        @Deprecated
        public Builder withCorrelator(Correlator correlator) {
            return this;
        }

        public Builder(Context context, String str) {
            this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzww.zzqx().zzb(context, str, new zzank()));
        }

        private Builder(Context context, zzxj zzxjVar) {
            this.context = context;
            this.zzacx = zzxjVar;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacx.zza(new zzahh(onContentAdLoadedListener));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add content ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacx.zza(new zzahe(onAppInstallAdLoadedListener));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add app install ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacx.zza(new zzahi(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add google native ad listener", e2);
            }
            return this;
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzacx.zza(new zzars(onNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add google native ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagy zzagyVar = new zzagy(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacx.zza(str, zzagyVar.zzuf(), zzagyVar.zzug());
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add custom template ad listener", e2);
            }
            return this;
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzarp zzarpVar = new zzarp(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzacx.zza(str, zzarpVar.zzwd(), zzarpVar.zzug());
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add custom format ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacx.zza(new zzahg(onPublisherAdViewLoadedListener), new zzvt(this.context, adSizeArr));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add publisher banner ad listener", e2);
            }
            return this;
        }

        public Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacx.zza(new zzahc(onAdManagerAdViewLoadedListener), new zzvt(this.context, adSizeArr));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to add Google Ad Manager banner ad listener", e2);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacx.zzb(new zzvj(adListener));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to set AdListener.", e2);
            }
            return this;
        }

        @Deprecated
        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacx.zza(new zzaei(nativeAdOptions));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to specify native ad options", e2);
            }
            return this;
        }

        public Builder withNativeAdOptions(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzacx.zza(new zzaei(nativeAdOptions));
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to specify native ad options", e2);
            }
            return this;
        }

        @Deprecated
        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacx.zza(publisherAdViewOptions);
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to specify Ad Manager banner ad options", e2);
            }
            return this;
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzacx.zza(adManagerAdViewOptions);
            } catch (RemoteException e2) {
                zzbao.zzd("Failed to specify Ad Manager banner ad options", e2);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.context, this.zzacx.zzrf());
            } catch (RemoteException e2) {
                zzbao.zzc("Failed to build AdLoader.", e2);
                return null;
            }
        }
    }

    AdLoader(Context context, zzxi zzxiVar) {
        this(context, zzxiVar, zzvr.zzciq);
    }

    private AdLoader(Context context, zzxi zzxiVar, zzvr zzvrVar) {
        this.context = context;
        this.zzacz = zzxiVar;
        this.zzacy = zzvrVar;
    }

    private final void zza(zzzl zzzlVar) {
        try {
            this.zzacz.zzb(zzvr.zza(this.context, zzzlVar));
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to load ad.", e2);
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdt());
    }

    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdt());
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        zza(adManagerAdRequest.zzdt());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzacz.zza(zzvr.zza(this.context, adRequest.zzdt()), i);
        } catch (RemoteException e2) {
            zzbao.zzc("Failed to load ads.", e2);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzacz.zzkl();
        } catch (RemoteException e2) {
            zzbao.zzd("Failed to get the mediation adapter class name.", e2);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzacz.isLoading();
        } catch (RemoteException e2) {
            zzbao.zzd("Failed to check if ad is loading.", e2);
            return false;
        }
    }
}
