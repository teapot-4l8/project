package okhttp3.internal.c;

import java.net.ProtocolException;
import okhttp3.y;

/* compiled from: StatusLine.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final y f7493a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7494b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7495c;

    public k(y yVar, int i, String str) {
        this.f7493a = yVar;
        this.f7494b = i;
        this.f7495c = str;
    }

    public static k a(String str) {
        y yVar;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                yVar = y.HTTP_1_0;
            } else if (charAt == 1) {
                yVar = y.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            yVar = y.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else if (str.charAt(i2) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            } else {
                str2 = str.substring(i + 4);
            }
            return new k(yVar, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7493a == y.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f7494b);
        if (this.f7495c != null) {
            sb.append(' ');
            sb.append(this.f7495c);
        }
        return sb.toString();
    }
}
