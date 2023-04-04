package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedh implements Comparable<zzedh> {
    private final byte[] zziey;

    private zzedh(byte[] bArr) {
        this.zziey = Arrays.copyOf(bArr, bArr.length);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zziey);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzedh) {
            return Arrays.equals(this.zziey, ((zzedh) obj).zziey);
        }
        return false;
    }

    public final String toString() {
        byte[] bArr = this.zziey;
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            sb.append("0123456789abcdef".charAt(i / 16));
            sb.append("0123456789abcdef".charAt(i % 16));
        }
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzedh zzedhVar) {
        int i;
        int i2;
        zzedh zzedhVar2 = zzedhVar;
        byte[] bArr = this.zziey;
        int length = bArr.length;
        byte[] bArr2 = zzedhVar2.zziey;
        if (length != bArr2.length) {
            i = bArr.length;
            i2 = bArr2.length;
        } else {
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.zziey;
                if (i3 >= bArr3.length) {
                    return 0;
                }
                byte b2 = bArr3[i3];
                byte[] bArr4 = zzedhVar2.zziey;
                if (b2 != bArr4[i3]) {
                    i = bArr3[i3];
                    i2 = bArr4[i3];
                    break;
                }
                i3++;
            }
        }
        return i - i2;
    }
}
