package cn.jiguang.bb;

import com.umeng.analytics.pro.bz;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f4042a = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, bz.m, 75, 112, 86, -99, 53, 30, 36, bz.l, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, bz.k, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, Byte.MAX_VALUE, 17, -39, 92, 65, 31, bz.n, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: b  reason: collision with root package name */
    private int[] f4043b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    private static int a(char c2) {
        return (byte) "0123456789abcdef".indexOf(c2);
    }

    private int a(int i) {
        byte[] bArr = this.f4042a;
        return (bArr[i & 255] & 255) | ((bArr[(i >>> 24) & 255] & 255) << 24) | ((bArr[(i >>> 16) & 255] & 255) << 16) | ((bArr[(i >>> 8) & 255] & 255) << 8);
    }

    private static int a(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    private void a(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] a2 = a(bArr);
        for (int i = 0; i < 32; i += 4) {
            a2[0] = a2[0] ^ b(a(((a2[1] ^ a2[2]) ^ a2[3]) ^ iArr[i]));
            a2[1] = a2[1] ^ b(a(((a2[2] ^ a2[3]) ^ a2[0]) ^ iArr[i + 1]));
            a2[2] = a2[2] ^ b(a(((a2[3] ^ a2[0]) ^ a2[1]) ^ iArr[i + 2]));
            a2[3] = a2[3] ^ b(a(((a2[1] ^ a2[0]) ^ a2[2]) ^ iArr[i + 3]));
        }
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = 3 - (i2 / 4);
            bArr2[i2] = (byte) ((a2[i3] >>> 24) & 255);
            bArr2[i2 + 1] = (byte) ((a2[i3] >>> 16) & 255);
            bArr2[i2 + 2] = (byte) ((a2[i3] >>> 8) & 255);
            bArr2[i2 + 3] = (byte) (a2[i3] & 255);
        }
    }

    public static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (a(charArray[i2 + 1]) | (a(charArray[i2]) << 4));
        }
        return bArr;
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 4;
            iArr[i] = (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
        }
        return iArr;
    }

    private int[] a(byte[] bArr, boolean z) {
        int[] a2 = a(bArr);
        a2[0] = a2[0] ^ (-1548633402);
        a2[1] = a2[1] ^ 1453994832;
        a2[2] = a2[2] ^ 1736282519;
        a2[3] = a2[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i = 0; i < 32; i += 4) {
            int c2 = a2[0] ^ c(a(((a2[1] ^ a2[2]) ^ a2[3]) ^ this.f4043b[i]));
            a2[0] = c2;
            iArr[i] = c2;
            int i2 = i + 1;
            int c3 = a2[1] ^ c(a(((a2[2] ^ a2[3]) ^ a2[0]) ^ this.f4043b[i2]));
            a2[1] = c3;
            iArr[i2] = c3;
            int i3 = i + 2;
            int c4 = a2[2] ^ c(a(((a2[3] ^ a2[0]) ^ a2[1]) ^ this.f4043b[i3]));
            a2[2] = c4;
            iArr[i3] = c4;
            int i4 = i + 3;
            int c5 = a2[3] ^ c(a(((a2[0] ^ a2[1]) ^ a2[2]) ^ this.f4043b[i4]));
            a2[3] = c5;
            iArr[i4] = c5;
        }
        if (z) {
            for (int i5 = 0; i5 < 16; i5++) {
                int i6 = iArr[i5];
                int i7 = 31 - i5;
                iArr[i5] = iArr[i7];
                iArr[i7] = i6;
            }
        }
        return iArr;
    }

    private int b(int i) {
        return a(i, 24) ^ (((a(i, 2) ^ i) ^ a(i, 10)) ^ a(i, 18));
    }

    private static byte[] b(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i = 0; i < length; i++) {
            copyOf[bArr.length + i] = (byte) length;
        }
        return copyOf;
    }

    private int c(int i) {
        return a(i, 23) ^ (a(i, 13) ^ i);
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] b2 = b(bArr);
        int[] a2 = a(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[b2.length];
        int i = 0;
        while (true) {
            int i2 = i + 16;
            if (i2 > b2.length) {
                return bArr5;
            }
            System.arraycopy(b2, i, bArr4, 0, 16);
            if (bArr3 != null) {
                a(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            a(bArr4, bArr3, a2);
            System.arraycopy(bArr3, 0, bArr5, i, bArr3.length);
            i = i2;
        }
    }

    public final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] a2 = a(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        int length = bArr.length;
        byte[] bArr6 = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i + 16;
            if (i2 > bArr.length) {
                int i3 = length - bArr6[length - 1];
                byte[] bArr7 = new byte[i3];
                System.arraycopy(bArr6, 0, bArr7, 0, i3);
                return bArr7;
            }
            System.arraycopy(bArr, i, bArr4, 0, 16);
            a(bArr4, bArr5, a2);
            if (bArr3 != null) {
                a(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i, 16);
            i = i2;
        }
    }
}
