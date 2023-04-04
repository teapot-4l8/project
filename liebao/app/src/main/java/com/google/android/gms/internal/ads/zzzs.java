package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class zzzs {
    private static zzzs zzclj;
    private zzyh zzclk;
    private RewardedVideoAd zzclm;
    private InitializationStatus zzclo;
    private final Object lock = new Object();
    private boolean zzcll = false;
    private boolean zzzq = false;
    private RequestConfiguration zzcln = new RequestConfiguration.Builder().build();
    private ArrayList<OnInitializationCompleteListener> zzcli = new ArrayList<>();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    private class zza extends zzajs {
        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzajt
        public final void zze(List<zzajm> list) {
            int i = 0;
            zzzs.this.zzcll = false;
            zzzs.this.zzzq = true;
            zzzs zzzsVar = zzzs.this;
            InitializationStatus zzd = zzzs.zzd(list);
            ArrayList arrayList = zzzs.zzry().zzcli;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((OnInitializationCompleteListener) obj).onInitializationComplete(zzd);
            }
            zzzs.zzry().zzcli.clear();
        }

        /* synthetic */ zza(zzzs zzzsVar, zzzv zzzvVar) {
            this();
        }
    }

    private zzzs() {
    }

    public static zzzs zzry() {
        zzzs zzzsVar;
        synchronized (zzzs.class) {
            if (zzclj == null) {
                zzclj = new zzzs();
            }
            zzzsVar = zzclj;
        }
        return zzzsVar;
    }

    public final void zza(final Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.lock) {
            if (this.zzcll) {
                if (onInitializationCompleteListener != null) {
                    zzry().zzcli.add(onInitializationCompleteListener);
                }
            } else if (this.zzzq) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(getInitializationStatus());
                }
            } else {
                this.zzcll = true;
                if (onInitializationCompleteListener != null) {
                    zzry().zzcli.add(onInitializationCompleteListener);
                }
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null.");
                }
                try {
                    zzane.zzvd().zzc(context, str);
                    zzg(context);
                    if (onInitializationCompleteListener != null) {
                        this.zzclk.zza(new zza(this, null));
                    }
                    this.zzclk.zza(new zzank());
                    this.zzclk.initialize();
                    this.zzclk.zza(str, ObjectWrapper.wrap(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.zzzr
                        private final zzzs zzclg;
                        private final Context zzclh;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzclg = this;
                            this.zzclh = context;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzclg.getRewardedVideoAdInstance(this.zzclh);
                        }
                    }));
                    if (this.zzcln.getTagForChildDirectedTreatment() != -1 || this.zzcln.getTagForUnderAgeOfConsent() != -1) {
                        zza(this.zzcln);
                    }
                    zzabq.initialize(context);
                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwx)).booleanValue() && !getVersionString().endsWith("0")) {
                        zzbao.zzex("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                        this.zzclo = new InitializationStatus(this) { // from class: com.google.android.gms.internal.ads.zzzt
                            private final zzzs zzclg;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.zzclg = this;
                            }

                            @Override // com.google.android.gms.ads.initialization.InitializationStatus
                            public final Map getAdapterStatusMap() {
                                zzzs zzzsVar = this.zzclg;
                                HashMap hashMap = new HashMap();
                                hashMap.put("com.google.android.gms.ads.MobileAds", new zzzv(zzzsVar));
                                return hashMap;
                            }
                        };
                        if (onInitializationCompleteListener != null) {
                            zzbae.zzaah.post(new Runnable(this, onInitializationCompleteListener) { // from class: com.google.android.gms.internal.ads.zzzu
                                private final zzzs zzclg;
                                private final OnInitializationCompleteListener zzclp;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.zzclg = this;
                                    this.zzclp = onInitializationCompleteListener;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zzclg.zza(this.zzclp);
                                }
                            });
                        }
                    }
                } catch (RemoteException e2) {
                    zzbao.zzd("MobileAdsSettingManager initialization failed", e2);
                }
            }
        }
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            if (this.zzclm != null) {
                return this.zzclm;
            }
            zzavv zzavvVar = new zzavv(context, new zzwu(zzww.zzqx(), context, new zzank()).zzd(context, false));
            this.zzclm = zzavvVar;
            return zzavvVar;
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzclk == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzclk.setAppVolume(f);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to set app volume.", e2);
            }
        }
    }

    public final float zzrg() {
        synchronized (this.lock) {
            float f = 1.0f;
            if (this.zzclk == null) {
                return 1.0f;
            }
            try {
                f = this.zzclk.zzrg();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to get app volume.", e2);
            }
            return f;
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzclk != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzclk.setAppMuted(z);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to set app mute state.", e2);
            }
        }
    }

    public final boolean zzrh() {
        synchronized (this.lock) {
            boolean z = false;
            if (this.zzclk == null) {
                return false;
            }
            try {
                z = this.zzclk.zzrh();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to get app mute state.", e2);
            }
            return z;
        }
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzclk != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzclk.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to open debug menu.", e2);
            }
        }
    }

    public final String getVersionString() {
        String zzhn;
        synchronized (this.lock) {
            Preconditions.checkState(this.zzclk != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhn = zzdyq.zzhn(this.zzclk.getVersionString());
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to get version string.", e2);
                return "";
            }
        }
        return zzhn;
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzclk.zzce(cls.getCanonicalName());
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to register RtbAdapter", e2);
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzclk != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                if (this.zzclo != null) {
                    return this.zzclo;
                }
                return zzd(this.zzclk.zzri());
            } catch (RemoteException unused) {
                zzbao.zzex("Unable to get Initialization status.");
                return null;
            }
        }
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzclk.zzrj();
            } catch (RemoteException unused) {
                zzbao.zzex("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzd(List<zzajm> list) {
        HashMap hashMap = new HashMap();
        for (zzajm zzajmVar : list) {
            hashMap.put(zzajmVar.zzdka, new zzaju(zzajmVar.zzdkb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzajmVar.description, zzajmVar.zzdkc));
        }
        return new zzajx(hashMap);
    }

    public final RequestConfiguration getRequestConfiguration() {
        return this.zzcln;
    }

    public final void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.lock) {
            RequestConfiguration requestConfiguration2 = this.zzcln;
            this.zzcln = requestConfiguration;
            if (this.zzclk == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zza(requestConfiguration);
            }
        }
    }

    private final void zza(RequestConfiguration requestConfiguration) {
        try {
            this.zzclk.zza(new zzaat(requestConfiguration));
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to set request configuration parcel.", e2);
        }
    }

    private final void zzg(Context context) {
        if (this.zzclk == null) {
            this.zzclk = new zzwp(zzww.zzqx(), context).zzd(context, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzclo);
    }
}
