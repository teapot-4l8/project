package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzawv {
    public static zzawf zzd(Context context, String str, zzann zzannVar) {
        try {
            IBinder zzd = ((zzawl) zzban.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzawu.zzbys)).zzd(ObjectWrapper.wrap(context), str, zzannVar, 204890000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzawf) {
                return (zzawf) queryLocalInterface;
            }
            return new zzawh(zzd);
        } catch (RemoteException | zzbap e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
