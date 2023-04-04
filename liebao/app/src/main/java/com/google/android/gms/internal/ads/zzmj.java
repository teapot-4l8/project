package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmj extends zzmo {
    public static final Parcelable.Creator<zzmj> CREATOR = new zzmm();
    public final String description;
    public final String text;
    private final String zzaif;

    public zzmj(String str, String str2, String str3) {
        super("COMM");
        this.zzaif = str;
        this.description = str2;
        this.text = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmj(Parcel parcel) {
        super("COMM");
        this.zzaif = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmj zzmjVar = (zzmj) obj;
            if (zzpt.zza(this.description, zzmjVar.description) && zzpt.zza(this.zzaif, zzmjVar.zzaif) && zzpt.zza(this.text, zzmjVar.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzaif;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.zzaif);
        parcel.writeString(this.text);
    }
}
