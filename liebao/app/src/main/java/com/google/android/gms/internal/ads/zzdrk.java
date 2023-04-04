package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrk implements zzdri {
    private final String zzcm;

    public zzdrk(String str) {
        this.zzcm = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final boolean equals(Object obj) {
        if (obj instanceof zzdrk) {
            return this.zzcm.equals(((zzdrk) obj).zzcm);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final int hashCode() {
        return this.zzcm.hashCode();
    }

    public final String toString() {
        return this.zzcm;
    }
}
