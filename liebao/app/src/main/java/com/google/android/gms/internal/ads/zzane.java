package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzane {
    private static zzane zzdmt;
    private AtomicBoolean zzdmu = new AtomicBoolean(false);

    public static zzane zzvd() {
        if (zzdmt == null) {
            zzdmt = new zzane();
        }
        return zzdmt;
    }

    zzane() {
    }

    public final Thread zzc(final Context context, final String str) {
        if (this.zzdmu.compareAndSet(false, true)) {
            Thread thread = new Thread(new Runnable(this, context, str) { // from class: com.google.android.gms.internal.ads.zzanh
                private final Context zzclh;
                private final zzane zzdmw;
                private final String zzdmx;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdmw = this;
                    this.zzclh = context;
                    this.zzdmx = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = this.zzclh;
                    String str2 = this.zzdmx;
                    zzabq.initialize(context2);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("measurementEnabled", ((Boolean) zzww.zzra().zzd(zzabq.zzcov)).booleanValue());
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
                        bundle.putString("ad_storage", "denied");
                        bundle.putString("analytics_storage", "denied");
                    }
                    try {
                        ((zzbhc) zzban.zza(context2, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzang.zzbys)).zza(ObjectWrapper.wrap(context2), new zzanf(AppMeasurementSdk.getInstance(context2, "FA-Ads", "am", str2, bundle)));
                    } catch (RemoteException | zzbap | NullPointerException e2) {
                        zzbao.zze("#007 Could not call remote method.", e2);
                    }
                }
            });
            thread.start();
            return thread;
        }
        return null;
    }
}
