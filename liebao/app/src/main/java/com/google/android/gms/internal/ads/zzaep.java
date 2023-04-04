package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaep extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdgq = new ArrayList();
    private final zzaek zzdha;

    public zzaep(zzaek zzaekVar) {
        zzaes zzaesVar;
        IBinder iBinder;
        this.zzdha = zzaekVar;
        try {
            this.text = zzaekVar.getText();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            this.text = "";
        }
        try {
            for (zzaes zzaesVar2 : zzaekVar.zztj()) {
                if (!(zzaesVar2 instanceof IBinder) || (iBinder = (IBinder) zzaesVar2) == null) {
                    zzaesVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    if (queryLocalInterface instanceof zzaes) {
                        zzaesVar = (zzaes) queryLocalInterface;
                    } else {
                        zzaesVar = new zzaeu(iBinder);
                    }
                }
                if (zzaesVar != null) {
                    this.zzdgq.add(new zzaex(zzaesVar));
                }
            }
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdgq;
    }
}
