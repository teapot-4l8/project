package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-base@@19.8.0 */
/* loaded from: classes.dex */
public class zzgw implements IInterface {
    private final IBinder zzaco;
    private final String zzacp;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgw(IBinder iBinder, String str) {
        this.zzaco = iBinder;
        this.zzacp = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzaco;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zzdp() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzacp);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzaco.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzaco.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(int i, Parcel parcel) {
        try {
            this.zzaco.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
