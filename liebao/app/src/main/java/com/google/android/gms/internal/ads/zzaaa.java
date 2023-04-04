package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaaa extends RemoteCreator<zzym> {
    public zzaaa() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final zzyh zzh(Context context) {
        try {
            IBinder zzb = getRemoteCreatorInstance(context).zzb(ObjectWrapper.wrap(context), 204890000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyh) {
                return (zzyh) queryLocalInterface;
            }
            return new zzyj(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbao.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzym getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzym) {
            return (zzym) queryLocalInterface;
        }
        return new zzyl(iBinder);
    }
}
