package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzhz {
    public static final zzhz zzaik = new zzhz(1.0f, 1.0f);
    public final float zzail;
    public final float zzaim;
    private final int zzain;

    public zzhz(float f, float f2) {
        this.zzail = f;
        this.zzaim = f2;
        this.zzain = Math.round(f * 1000.0f);
    }

    public final long zzdu(long j) {
        return j * this.zzain;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzhz zzhzVar = (zzhz) obj;
            if (this.zzail == zzhzVar.zzail && this.zzaim == zzhzVar.zzaim) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzail) + 527) * 31) + Float.floatToRawIntBits(this.zzaim);
    }
}
