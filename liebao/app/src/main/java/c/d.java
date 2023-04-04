package c;

import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.java */
/* loaded from: classes.dex */
public interface d extends r, WritableByteChannel {
    long a(s sVar);

    d b(f fVar);

    d b(String str);

    c c();

    d c(byte[] bArr);

    d c(byte[] bArr, int i, int i2);

    @Override // c.r, java.io.Flushable
    void flush();

    d g(int i);

    d h(int i);

    d i(int i);

    d l(long j);

    d m(long j);

    d x();
}
