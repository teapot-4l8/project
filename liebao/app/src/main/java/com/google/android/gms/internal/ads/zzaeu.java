package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaeu extends zzgw implements zzaes {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zztn() {
        Parcel zza = zza(1, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final Uri getUri() {
        Parcel zza = zza(2, zzdp());
        Uri uri = (Uri) zzgx.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final double getScale() {
        Parcel zza = zza(3, zzdp());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final int getWidth() {
        Parcel zza = zza(4, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final int getHeight() {
        Parcel zza = zza(5, zzdp());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
