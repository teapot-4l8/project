package okhttp3.internal.e;

import java.io.IOException;

/* compiled from: Http2.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final c.f f7537a = c.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f7540d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: b  reason: collision with root package name */
    static final String[] f7538b = new String[64];

    /* renamed from: c  reason: collision with root package name */
    static final String[] f7539c = new String[256];

    static {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f7539c;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = okhttp3.internal.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f7538b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            f7538b[iArr[i4] | 8] = f7538b[i] + "|PADDED";
        }
        String[] strArr3 = f7538b;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                int i9 = i8 | i6;
                f7538b[i9] = f7538b[i8] + '|' + f7538b[i6];
                f7538b[i9 | 8] = f7538b[i8] + '|' + f7538b[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f7538b;
            if (i2 >= strArr4.length) {
                return;
            }
            if (strArr4[i2] == null) {
                strArr4[i2] = f7539c[i2];
            }
            i2++;
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.internal.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) {
        throw new IOException(okhttp3.internal.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f7540d;
        String a2 = b2 < strArr.length ? strArr[b2] : okhttp3.internal.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return okhttp3.internal.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f7539c[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = f7538b;
                String str = b3 < strArr.length ? strArr[b3] : f7539c[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f7539c[b3];
    }
}
