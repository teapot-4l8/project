package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmi extends zzmo {
    public static final Parcelable.Creator<zzmi> CREATOR = new zzmk();
    private final String description;
    private final String mimeType;
    private final int zzbds;
    private final byte[] zzbdt;

    public zzmi(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbds = 3;
        this.zzbdt = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmi(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbds = parcel.readInt();
        this.zzbdt = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmi zzmiVar = (zzmi) obj;
            if (this.zzbds == zzmiVar.zzbds && zzpt.zza(this.mimeType, zzmiVar.mimeType) && zzpt.zza(this.description, zzmiVar.description) && Arrays.equals(this.zzbdt, zzmiVar.zzbdt)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.zzbds + 527) * 31;
        String str = this.mimeType;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzbdt);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbds);
        parcel.writeByteArray(this.zzbdt);
    }
}
