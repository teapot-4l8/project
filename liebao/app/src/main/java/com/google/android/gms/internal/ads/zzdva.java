package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdva extends zzduz {
    private final String zzhvq;
    private final boolean zzxk;
    private final boolean zzzo;

    private zzdva(String str, boolean z, boolean z2) {
        this.zzhvq = str;
        this.zzxk = z;
        this.zzzo = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzduz
    public final String zzayo() {
        return this.zzhvq;
    }

    @Override // com.google.android.gms.internal.ads.zzduz
    public final boolean zzayp() {
        return this.zzxk;
    }

    @Override // com.google.android.gms.internal.ads.zzduz
    public final boolean zzcn() {
        return this.zzzo;
    }

    public final String toString() {
        String str = this.zzhvq;
        boolean z = this.zzxk;
        boolean z2 = this.zzzo;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzduz) {
            zzduz zzduzVar = (zzduz) obj;
            if (this.zzhvq.equals(zzduzVar.zzayo()) && this.zzxk == zzduzVar.zzayp() && this.zzzo == zzduzVar.zzcn()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzhvq.hashCode() ^ 1000003) * 1000003) ^ (this.zzxk ? 1231 : 1237)) * 1000003) ^ (this.zzzo ? 1231 : 1237);
    }
}
