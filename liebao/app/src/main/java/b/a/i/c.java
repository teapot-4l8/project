package b.a.i;

import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class c {
    public static int a(byte b2, byte b3, byte b4, byte b5) {
        return ((b2 & 255) << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int a(byte[] bArr, int i, ByteOrder byteOrder) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            b2 = bArr[i + 3];
            b3 = bArr[i + 2];
            b4 = bArr[i + 1];
            b5 = bArr[i];
        } else {
            b2 = bArr[i];
            b3 = bArr[i + 1];
            b4 = bArr[i + 2];
            b5 = bArr[i + 3];
        }
        return a(b2, b3, b4, b5);
    }

    public static long a(byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9) {
        return ((a(b2, b3, b4, b5) & (-1)) << 32) | ((-1) & a(b6, b7, b8, b9));
    }

    public static short a(byte b2, byte b3) {
        return (short) ((b2 << 8) | (b3 & 255));
    }

    public static short b(byte[] bArr, int i, ByteOrder byteOrder) {
        byte b2;
        byte b3;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            b2 = bArr[i + 1];
            b3 = bArr[i];
        } else {
            b2 = bArr[i];
            b3 = bArr[i + 1];
        }
        return a(b2, b3);
    }

    public static long c(byte[] bArr, int i, ByteOrder byteOrder) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        byte b9;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            b2 = bArr[i + 7];
            b3 = bArr[i + 6];
            b4 = bArr[i + 5];
            b5 = bArr[i + 4];
            b6 = bArr[i + 3];
            b7 = bArr[i + 2];
            b8 = bArr[i + 1];
            b9 = bArr[i];
        } else {
            b2 = bArr[i];
            b3 = bArr[i + 1];
            b4 = bArr[i + 2];
            b5 = bArr[i + 3];
            b6 = bArr[i + 4];
            b7 = bArr[i + 5];
            b8 = bArr[i + 6];
            b9 = bArr[i + 7];
        }
        return a(b2, b3, b4, b5, b6, b7, b8, b9);
    }
}
