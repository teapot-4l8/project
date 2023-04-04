package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaav> CREATOR = new zzaau();
    public final String zzbrl;

    public zzaav(SearchAdRequest searchAdRequest) {
        this.zzbrl = searchAdRequest.getQuery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaav(String str) {
        this.zzbrl = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzbrl, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
