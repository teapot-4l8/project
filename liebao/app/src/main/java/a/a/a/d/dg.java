package a.a.a.d;

import java.io.IOException;

/* compiled from: WireParseException.java */
/* loaded from: classes.dex */
public class dg extends IOException {
    public dg() {
    }

    public dg(String str) {
        super(str);
    }

    public dg(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
