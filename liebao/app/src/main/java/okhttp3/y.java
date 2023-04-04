package okhttp3;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes2.dex */
public enum y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    private final String g;

    y(String str) {
        this.g = str;
    }

    public static y a(String str) {
        if (str.equals(HTTP_1_0.g)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.g)) {
            return HTTP_1_1;
        }
        if (str.equals(H2_PRIOR_KNOWLEDGE.g)) {
            return H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(HTTP_2.g)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.g)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.g)) {
            return QUIC;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.g;
    }
}
