package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzata extends zzgw implements zzasy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void onSuccess(List<Uri> list) {
        Parcel zzdp = zzdp();
        zzdp.writeTypedList(list);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzasy
    public final void onError(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(2, zzdp);
    }
}
