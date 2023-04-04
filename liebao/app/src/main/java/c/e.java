package c;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource.java */
/* loaded from: classes.dex */
public interface e extends s, ReadableByteChannel {
    long a(byte b2);

    long a(r rVar);

    String a(Charset charset);

    void a(long j);

    void a(byte[] bArr);

    boolean a(long j, f fVar);

    boolean b(long j);

    c c();

    f d(long j);

    String f(long j);

    boolean f();

    InputStream g();

    byte[] h(long j);

    byte i();

    void i(long j);

    short j();

    int k();

    short l();

    int m();

    long n();

    long o();

    String r();
}
