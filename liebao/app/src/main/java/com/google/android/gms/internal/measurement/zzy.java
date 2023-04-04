package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public final class zzy extends zza implements zzw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzw
    public final void zza(Bundle bundle) {
        Parcel a_ = a_();
        zzb.zza(a_, bundle);
        zzb(1, a_);
    }
}
