package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarl extends NativeAd.AdChoicesInfo {
    private String text;
    private final List<NativeAd.Image> zzdgq = new ArrayList();

    public zzarl(zzaek zzaekVar) {
        try {
            this.text = zzaekVar.getText();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            this.text = "";
        }
        try {
            for (zzaes zzaesVar : zzaekVar.zztj()) {
                zzaes zzo = zzaesVar instanceof IBinder ? zzaev.zzo((IBinder) zzaesVar) : null;
                if (zzo != null) {
                    this.zzdgq.add(new zzarn(zzo));
                }
            }
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.text;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdgq;
    }
}
