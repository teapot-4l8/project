package okhttp3.internal.e;

import java.io.IOException;

/* compiled from: StreamResetException.java */
/* loaded from: classes2.dex */
public final class n extends IOException {

    /* renamed from: a  reason: collision with root package name */
    public final b f7632a;

    public n(b bVar) {
        super("stream was reset: " + bVar);
        this.f7632a = bVar;
    }
}
