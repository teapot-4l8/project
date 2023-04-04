package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzazs {
    private Context context;
    private zzbar zzbpx;
    private zzebt<ArrayList<String>> zzeen;
    private final Object lock = new Object();
    private final com.google.android.gms.ads.internal.util.zzi zzeeh = new com.google.android.gms.ads.internal.util.zzi();
    private final zzbac zzedz = new zzbac(zzww.zzrb(), this.zzeeh);
    private boolean zzzq = false;
    private zzabx zzeei = null;
    private Boolean zzeej = null;
    private final AtomicInteger zzeek = new AtomicInteger(0);
    private final zzazx zzeel = new zzazx(null);
    private final Object zzeem = new Object();

    public final zzabx zzyf() {
        zzabx zzabxVar;
        synchronized (this.lock) {
            zzabxVar = this.zzeei;
        }
        return zzabxVar;
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzeej = bool;
        }
    }

    public final Boolean zzyg() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzeej;
        }
        return bool;
    }

    public final void zzyh() {
        this.zzeel.zzyh();
    }

    public final void zzd(Context context, zzbar zzbarVar) {
        zzabx zzabxVar;
        synchronized (this.lock) {
            if (!this.zzzq) {
                this.context = context.getApplicationContext();
                this.zzbpx = zzbarVar;
                com.google.android.gms.ads.internal.zzr.zzky().zza(this.zzedz);
                this.zzeeh.initialize(this.context);
                zzatl.zzc(this.context, this.zzbpx);
                com.google.android.gms.ads.internal.zzr.zzle();
                if (!zzadg.zzded.get().booleanValue()) {
                    com.google.android.gms.ads.internal.util.zzd.zzed("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzabxVar = null;
                } else {
                    zzabxVar = new zzabx();
                }
                this.zzeei = zzabxVar;
                if (zzabxVar != null) {
                    zzbba.zza(new zzazu(this).zzyx(), "AppState.registerCsiReporter");
                }
                this.zzzq = true;
                zzym();
            }
        }
        com.google.android.gms.ads.internal.zzr.zzkv().zzq(context, zzbarVar.zzbrz);
    }

    public final Resources getResources() {
        if (this.zzbpx.zzekc) {
            return this.context.getResources();
        }
        try {
            zzban.zzbw(this.context).getResources();
            return null;
        } catch (zzbap e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzatl.zzc(this.context, this.zzbpx).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzatl.zzc(this.context, this.zzbpx).zza(th, str, zzads.zzdfv.get().floatValue());
    }

    public final void zzyi() {
        this.zzeek.incrementAndGet();
    }

    public final void zzyj() {
        this.zzeek.decrementAndGet();
    }

    public final int zzyk() {
        return this.zzeek.get();
    }

    public final com.google.android.gms.ads.internal.util.zzf zzyl() {
        com.google.android.gms.ads.internal.util.zzi zziVar;
        synchronized (this.lock) {
            zziVar = this.zzeeh;
        }
        return zziVar;
    }

    public final Context getApplicationContext() {
        return this.context;
    }

    public final zzebt<ArrayList<String>> zzym() {
        if (PlatformVersion.isAtLeastJellyBean() && this.context != null) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsx)).booleanValue()) {
                synchronized (this.zzeem) {
                    if (this.zzeen != null) {
                        return this.zzeen;
                    }
                    zzebt<ArrayList<String>> zze = zzbat.zzeke.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzazv
                        private final zzazs zzeew;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzeew = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzeew.zzyo();
                        }
                    });
                    this.zzeen = zze;
                    return zze;
                }
            }
        }
        return zzebh.zzag(new ArrayList());
    }

    private static ArrayList<String> zzak(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final zzbac zzyn() {
        return this.zzedz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzyo() {
        return zzak(zzava.zzx(this.context));
    }
}
