package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzkk {
    public final int zzapr = 1;
    public final byte[] zzaps;

    public zzkk(int i, byte[] bArr) {
        this.zzaps = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkk zzkkVar = (zzkk) obj;
            if (this.zzapr == zzkkVar.zzapr && Arrays.equals(this.zzaps, zzkkVar.zzaps)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzapr * 31) + Arrays.hashCode(this.zzaps);
    }
}
