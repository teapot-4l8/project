package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazl implements Parcelable.Creator<zzazi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazi[] newArray(int i) {
        return new zzazi[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazi createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzvt zzvtVar = null;
        zzvq zzvqVar = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                str2 = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 3) {
                zzvtVar = (zzvt) SafeParcelReader.createParcelable(parcel, readHeader, zzvt.CREATOR);
            } else if (fieldId == 4) {
                zzvqVar = (zzvq) SafeParcelReader.createParcelable(parcel, readHeader, zzvq.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzazi(str, str2, zzvtVar, zzvqVar);
    }
}
