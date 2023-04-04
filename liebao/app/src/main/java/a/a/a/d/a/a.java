package a.a.a.d.a;

import java.io.ByteArrayOutputStream;

/* compiled from: base16.java */
/* loaded from: classes.dex */
public class a {
    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b2 : bArr) {
            short s = (short) (b2 & 255);
            byteArrayOutputStream.write("0123456789ABCDEF".charAt((byte) (s >> 4)));
            byteArrayOutputStream.write("0123456789ABCDEF".charAt((byte) (s & 15)));
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
