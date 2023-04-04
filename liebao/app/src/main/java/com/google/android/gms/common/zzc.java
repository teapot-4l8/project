package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@CheckReturnValue
/* loaded from: classes.dex */
public final class zzc {
    private static volatile zzq zza;
    private static final Object zzb = new Object();
    private static Context zzc;

    public static synchronized void zza(Context context) {
        synchronized (zzc.class) {
            if (zzc != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzc = context.getApplicationContext();
            }
        }
    }

    public static zzl zza(String str, zzd zzdVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzb(str, zzdVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzl zzb(String str, zzd zzdVar, boolean z, boolean z2) {
        try {
            if (zza == null) {
                Preconditions.checkNotNull(zzc);
                synchronized (zzb) {
                    if (zza == null) {
                        zza = zzp.zza(DynamiteModule.load(zzc, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            Preconditions.checkNotNull(zzc);
            try {
                if (zza.zza(new zzj(str, zzdVar, z, z2), ObjectWrapper.wrap(zzc.getPackageManager()))) {
                    return zzl.zza();
                }
                return zzl.zza(new Callable(z, str, zzdVar) { // from class: com.google.android.gms.common.zze
                    private final boolean zza;
                    private final String zzb;
                    private final zzd zzc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = z;
                        this.zzb = str;
                        this.zzc = zzdVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzc.zza(this.zza, this.zzb, this.zzc);
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return zzl.zza("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return zzl.zza(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }

    public static final /* synthetic */ String zza(boolean z, String str, zzd zzdVar) {
        boolean z2 = true;
        return zzl.zza(str, zzdVar, z, (z || !zzb(str, zzdVar, true, false).zza) ? false : false);
    }
}
