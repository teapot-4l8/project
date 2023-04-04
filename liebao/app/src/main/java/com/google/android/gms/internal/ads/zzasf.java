package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzasf extends RemoteCreator<zzasi> {
    public zzasf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzash zze(Activity activity) {
        try {
            IBinder zzaf = getRemoteCreatorInstance(activity).zzaf(ObjectWrapper.wrap(activity));
            if (zzaf == null) {
                return null;
            }
            IInterface queryLocalInterface = zzaf.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzash) {
                return (zzash) queryLocalInterface;
            }
            return new zzasj(zzaf);
        } catch (RemoteException e2) {
            zzbao.zzd("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzbao.zzd("Could not create remote AdOverlay.", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzasi getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzasi) {
            return (zzasi) queryLocalInterface;
        }
        return new zzasl(iBinder);
    }
}
