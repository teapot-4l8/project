package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzig {
    private static final zzig zzajd = new zzig(new int[]{2}, 2);
    private final int[] zzaje;
    private final int zzajf;

    private zzig(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzaje = copyOf;
        Arrays.sort(copyOf);
        this.zzajf = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzig) {
            zzig zzigVar = (zzig) obj;
            return Arrays.equals(this.zzaje, zzigVar.zzaje) && this.zzajf == zzigVar.zzajf;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzajf + (Arrays.hashCode(this.zzaje) * 31);
    }

    public final String toString() {
        int i = this.zzajf;
        String arrays = Arrays.toString(this.zzaje);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
