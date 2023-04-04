package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzdqh;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzvh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzas();
    public final int errorCode;
    public final String zzacu;

    public static zzaq zzc(Throwable th) {
        String message;
        zzvh zzh = zzdqh.zzh(th);
        if (zzdyq.zzar(th.getMessage())) {
            message = zzh.zzchs;
        } else {
            message = th.getMessage();
        }
        return new zzaq(message, zzh.errorCode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(String str, int i) {
        this.zzacu = str == null ? "" : str;
        this.errorCode = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacu, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
