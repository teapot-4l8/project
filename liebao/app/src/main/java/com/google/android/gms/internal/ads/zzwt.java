package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzwt<T> {
    private static final zzxz zzcjw = zzqt();

    protected abstract T zza(zzxz zzxzVar);

    protected abstract T zzqp();

    protected abstract T zzqq();

    private static zzxz zzqt() {
        try {
            Object newInstance = zzwd.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbao.zzez("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzxz) {
                return (zzxz) queryLocalInterface;
            }
            return new zzyb(iBinder);
        } catch (Exception unused) {
            zzbao.zzez("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T zzqu() {
        zzxz zzxzVar = zzcjw;
        if (zzxzVar == null) {
            zzbao.zzez("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzxzVar);
        } catch (RemoteException e2) {
            zzbao.zzd("Cannot invoke local loader using ClientApi class.", e2);
            return null;
        }
    }

    private final T zzqv() {
        try {
            return zzqq();
        } catch (RemoteException e2) {
            zzbao.zzd("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final T zzd(Context context, boolean z) {
        boolean z2;
        T zzqu;
        boolean z3 = z;
        if (!z3) {
            zzww.zzqw();
            if (!zzbae.zzf(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbao.zzdz("Google Play Services is not available.");
                z3 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = true;
        }
        zzabq.initialize(context);
        if (zzadj.zzdem.get().booleanValue()) {
            z3 = false;
        } else if (zzadj.zzden.get().booleanValue()) {
            z3 = true;
            z2 = true;
            if (!z3) {
                zzqu = zzqu();
                if (zzqu == null && !z2) {
                    zzqu = zzqv();
                }
            } else {
                T zzqv = zzqv();
                int i = zzqv == null ? 1 : 0;
                if (i != 0) {
                    if (zzww.zzrd().nextInt(zzads.zzdfp.get().intValue()) == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "dynamite_load");
                        bundle.putInt("is_missing", i);
                        zzww.zzqw().zza(context, zzww.zzrc().zzbrz, "gmob-apps", bundle, true);
                    }
                }
                zzqu = zzqv == null ? zzqu() : zzqv;
            }
            return zzqu != null ? zzqp() : zzqu;
        }
        z2 = false;
        if (!z3) {
        }
        if (zzqu != null) {
        }
    }
}
