package cn.jiguang.v;

/* loaded from: classes.dex */
public final class a {
    public static String a(byte[] bArr) {
        return new String(b(bArr));
    }

    private static byte[] b(byte[] bArr) {
        try {
            byte[] bArr2 = {32, 25, 8, 22, 17, 48};
            byte[] bArr3 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr3[i] = (byte) (bArr[i] ^ bArr2[(bArr.length + i) % 6]);
            }
            return bArr3;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }
}
