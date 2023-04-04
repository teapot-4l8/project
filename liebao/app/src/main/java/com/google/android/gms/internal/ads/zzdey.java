package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.AdRequest;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdey implements zzdhe<zzdev> {
    private final Context context;
    private final zzebs zzhdd;
    private final Set<String> zzhdr;
    private final ViewGroup zzhfc;

    public zzdey(zzebs zzebsVar, ViewGroup viewGroup, Context context, Set<String> set) {
        this.zzhdd = zzebsVar;
        this.zzhdr = set;
        this.zzhfc = viewGroup;
        this.context = context;
    }

    private static Boolean zzl(Activity activity) {
        Window window = activity.getWindow();
        boolean z = true;
        if (window != null && (window.getAttributes().flags & 16777216) != 0) {
            return true;
        }
        try {
            if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdev> zzatu() {
        return this.zzhdd.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdex
            private final zzdey zzhfb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfb = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhfb.zzauf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdev zzauf() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyd)).booleanValue() && this.zzhfc != null && this.zzhdr.contains("banner")) {
            return new zzdev(Boolean.valueOf(this.zzhfc.isHardwareAccelerated()));
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcye)).booleanValue() && this.zzhdr.contains("native")) {
            Context context = this.context;
            if (context instanceof Activity) {
                return new zzdev(zzl((Activity) context));
            }
        }
        return new zzdev(null);
    }
}
