package b.a.k;

import com.umeng.analytics.pro.bz;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066a {

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f3254d;

        /* renamed from: e  reason: collision with root package name */
        private final int f3255e;
        private final boolean f;
        private final boolean g;
        private static final char[] h = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] i = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private static final byte[] j = {bz.k, 10};

        /* renamed from: a  reason: collision with root package name */
        static final C0066a f3251a = new C0066a(false, null, -1, true);

        /* renamed from: b  reason: collision with root package name */
        static final C0066a f3252b = new C0066a(true, null, -1, true);

        /* renamed from: c  reason: collision with root package name */
        static final C0066a f3253c = new C0066a(false, j, 76, true);

        private C0066a(boolean z, byte[] bArr, int i2, boolean z2) {
            this.f = z;
            this.f3254d = bArr;
            this.f3255e = i2;
            this.g = z2;
        }

        private final int a(int i2) {
            int i3;
            if (this.g) {
                i3 = ((i2 + 2) / 3) * 4;
            } else {
                int i4 = i2 % 3;
                i3 = ((i2 / 3) * 4) + (i4 == 0 ? 0 : i4 + 1);
            }
            int i5 = this.f3255e;
            return i5 > 0 ? i3 + (((i3 - 1) / i5) * this.f3254d.length) : i3;
        }

        private int a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            char[] cArr = this.f ? i : h;
            int i4 = ((i3 - i2) / 3) * 3;
            int i5 = i2 + i4;
            int i6 = this.f3255e;
            if (i6 > 0 && i4 > (i6 / 4) * 3) {
                i4 = (i6 / 4) * 3;
            }
            int i7 = 0;
            while (i2 < i5) {
                int min = Math.min(i2 + i4, i5);
                int i8 = i2;
                int i9 = i7;
                while (i8 < min) {
                    int i10 = i8 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((bArr[i8] & 255) << 16) | ((bArr[i10] & 255) << 8);
                    int i13 = i11 + 1;
                    int i14 = i12 | (bArr[i11] & 255);
                    int i15 = i9 + 1;
                    bArr2[i9] = (byte) cArr[(i14 >>> 18) & 63];
                    int i16 = i15 + 1;
                    bArr2[i15] = (byte) cArr[(i14 >>> 12) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i14 >>> 6) & 63];
                    i9 = i17 + 1;
                    bArr2[i17] = (byte) cArr[i14 & 63];
                    i8 = i13;
                }
                int i18 = ((min - i2) / 3) * 4;
                i7 += i18;
                if (i18 == this.f3255e && min < i3) {
                    byte[] bArr3 = this.f3254d;
                    int length = bArr3.length;
                    int i19 = 0;
                    while (i19 < length) {
                        bArr2[i7] = bArr3[i19];
                        i19++;
                        i7++;
                    }
                }
                i2 = min;
            }
            if (i2 < i3) {
                int i20 = i2 + 1;
                int i21 = bArr[i2] & 255;
                int i22 = i7 + 1;
                bArr2[i7] = (byte) cArr[i21 >> 2];
                if (i20 == i3) {
                    int i23 = i22 + 1;
                    bArr2[i22] = (byte) cArr[(i21 << 4) & 63];
                    if (this.g) {
                        int i24 = i23 + 1;
                        bArr2[i23] = 61;
                        int i25 = i24 + 1;
                        bArr2[i24] = 61;
                        return i25;
                    }
                    return i23;
                }
                int i26 = bArr[i20] & 255;
                int i27 = i22 + 1;
                bArr2[i22] = (byte) cArr[((i21 << 4) & 63) | (i26 >> 4)];
                int i28 = i27 + 1;
                bArr2[i27] = (byte) cArr[(i26 << 2) & 63];
                if (this.g) {
                    int i29 = i28 + 1;
                    bArr2[i28] = 61;
                    return i29;
                }
                return i28;
            }
            return i7;
        }

        public C0066a a() {
            return !this.g ? this : new C0066a(this.f, this.f3254d, this.f3255e, false);
        }

        public byte[] a(byte[] bArr) {
            int a2 = a(bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }

        public String b(byte[] bArr) {
            byte[] a2 = a(bArr);
            return new String(a2, 0, 0, a2.length);
        }
    }

    public static C0066a a() {
        return C0066a.f3252b;
    }
}
