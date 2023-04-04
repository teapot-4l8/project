package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavs implements Parcelable.Creator<zzavt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavt[] newArray(int i) {
        return new zzavt[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzavt createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzvq zzvqVar = null;
        String str = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                zzvqVar = (zzvq) SafeParcelReader.createParcelable(parcel, readHeader, zzvq.CREATOR);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzavt(zzvqVar, str);
    }
}
