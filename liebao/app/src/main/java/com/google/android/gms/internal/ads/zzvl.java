package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzvl extends RemoteCreator<zzxo> {
    public zzvl() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final zzxj zza(Context context, String str, zzann zzannVar) {
        try {
            IBinder zzc = getRemoteCreatorInstance(context).zzc(ObjectWrapper.wrap(context), str, zzannVar, 204890000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxj) {
                return (zzxj) queryLocalInterface;
            }
            return new zzxl(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbao.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxo getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzxo) {
            return (zzxo) queryLocalInterface;
        }
        return new zzxn(iBinder);
    }
}
