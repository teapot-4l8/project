package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpm {
    public static final byte[] zzbkd = {0, 0, 0, 1};
    private static final float[] zzbkp = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzbkq = new Object();
    private static int[] zzbkr = new int[10];

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzbkq) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    } else if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < i) {
                    if (zzbkr.length <= i4) {
                        zzbkr = Arrays.copyOf(zzbkr, zzbkr.length << 1);
                    }
                    zzbkr[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = zzbkr[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void zzp(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean zza(String str, byte b2) {
        return ("video/avc".equals(str) && (b2 & 31) == 6) || ("video/hevc".equals(str) && ((b2 & 126) >> 1) == 39);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzpl zzd(byte[] bArr, int i, int i2) {
        int zzji;
        boolean z;
        int i3;
        boolean z2;
        boolean zzjh;
        float f;
        int zzbo;
        int i4;
        zzpq zzpqVar = new zzpq(bArr, i, i2);
        zzpqVar.zzbp(8);
        int zzbo2 = zzpqVar.zzbo(8);
        zzpqVar.zzbp(16);
        int zzji2 = zzpqVar.zzji();
        if (zzbo2 == 100 || zzbo2 == 110 || zzbo2 == 122 || zzbo2 == 244 || zzbo2 == 44 || zzbo2 == 83 || zzbo2 == 86 || zzbo2 == 118 || zzbo2 == 128 || zzbo2 == 138) {
            zzji = zzpqVar.zzji();
            boolean zzjh2 = zzji == 3 ? zzpqVar.zzjh() : false;
            zzpqVar.zzji();
            zzpqVar.zzji();
            zzpqVar.zzbp(1);
            if (zzpqVar.zzjh()) {
                int i5 = zzji != 3 ? 8 : 12;
                int i6 = 0;
                while (i6 < i5) {
                    if (zzpqVar.zzjh()) {
                        int i7 = i6 < 6 ? 16 : 64;
                        int i8 = 8;
                        int i9 = 8;
                        for (int i10 = 0; i10 < i7; i10++) {
                            if (i8 != 0) {
                                i8 = ((zzpqVar.zzjj() + i9) + 256) % 256;
                            }
                            if (i8 != 0) {
                                i9 = i8;
                            }
                        }
                    }
                    i6++;
                }
            }
            z = zzjh2;
        } else {
            zzji = 1;
            z = false;
        }
        int zzji3 = zzpqVar.zzji() + 4;
        int zzji4 = zzpqVar.zzji();
        if (zzji4 == 0) {
            i3 = zzpqVar.zzji() + 4;
        } else if (zzji4 == 1) {
            boolean zzjh3 = zzpqVar.zzjh();
            zzpqVar.zzjj();
            zzpqVar.zzjj();
            long zzji5 = zzpqVar.zzji();
            for (int i11 = 0; i11 < zzji5; i11++) {
                zzpqVar.zzji();
            }
            z2 = zzjh3;
            i3 = 0;
            zzpqVar.zzji();
            zzpqVar.zzbp(1);
            int zzji6 = zzpqVar.zzji() + 1;
            zzjh = zzpqVar.zzjh();
            int zzji7 = (2 - (zzjh ? 1 : 0)) * (zzpqVar.zzji() + 1);
            if (!zzjh) {
                zzpqVar.zzbp(1);
            }
            zzpqVar.zzbp(1);
            int i12 = zzji6 << 4;
            int i13 = zzji7 << 4;
            if (zzpqVar.zzjh()) {
                int zzji8 = zzpqVar.zzji();
                int zzji9 = zzpqVar.zzji();
                int zzji10 = zzpqVar.zzji();
                int zzji11 = zzpqVar.zzji();
                if (zzji == 0) {
                    i4 = 2 - (zzjh ? 1 : 0);
                } else {
                    int i14 = zzji == 3 ? 1 : 2;
                    i4 = (2 - (zzjh ? 1 : 0)) * (zzji == 1 ? 2 : 1);
                    r7 = i14;
                }
                i12 -= (zzji8 + zzji9) * r7;
                i13 -= (zzji10 + zzji11) * i4;
            }
            int i15 = i12;
            int i16 = i13;
            float f2 = 1.0f;
            if (zzpqVar.zzjh() && zzpqVar.zzjh()) {
                zzbo = zzpqVar.zzbo(8);
                if (zzbo != 255) {
                    int zzbo3 = zzpqVar.zzbo(16);
                    int zzbo4 = zzpqVar.zzbo(16);
                    if (zzbo3 != 0 && zzbo4 != 0) {
                        f2 = zzbo3 / zzbo4;
                    }
                    f = f2;
                } else {
                    float[] fArr = zzbkp;
                    if (zzbo < fArr.length) {
                        f = fArr[zzbo];
                    } else {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(zzbo);
                        Log.w("NalUnitUtil", sb.toString());
                    }
                }
                return new zzpl(zzji2, i15, i16, f, z, zzjh, zzji3, zzji4, i3, z2);
            }
            f = 1.0f;
            return new zzpl(zzji2, i15, i16, f, z, zzjh, zzji3, zzji4, i3, z2);
        } else {
            i3 = 0;
        }
        z2 = false;
        zzpqVar.zzji();
        zzpqVar.zzbp(1);
        int zzji62 = zzpqVar.zzji() + 1;
        zzjh = zzpqVar.zzjh();
        int zzji72 = (2 - (zzjh ? 1 : 0)) * (zzpqVar.zzji() + 1);
        if (!zzjh) {
        }
        zzpqVar.zzbp(1);
        int i122 = zzji62 << 4;
        int i132 = zzji72 << 4;
        if (zzpqVar.zzjh()) {
        }
        int i152 = i122;
        int i162 = i132;
        float f22 = 1.0f;
        if (zzpqVar.zzjh()) {
            zzbo = zzpqVar.zzbo(8);
            if (zzbo != 255) {
            }
            return new zzpl(zzji2, i152, i162, f, z, zzjh, zzji3, zzji4, i3, z2);
        }
        f = 1.0f;
        return new zzpl(zzji2, i152, i162, f, z, zzjh, zzji3, zzji4, i3, z2);
    }
}
