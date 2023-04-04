package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzwa implements Parcelable.Creator<zzvx> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvx[] newArray(int i) {
        return new zzvx[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvx createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzvh zzvhVar = null;
        Bundle bundle = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                j = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 3) {
                zzvhVar = (zzvh) SafeParcelReader.createParcelable(parcel, readHeader, zzvh.CREATOR);
            } else if (fieldId == 4) {
                bundle = SafeParcelReader.createBundle(parcel, readHeader);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzvx(str, j, zzvhVar, bundle);
    }
}
