package c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f3562a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static r a(OutputStream outputStream) {
        return a(outputStream, new t());
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream != null) {
            if (tVar == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new r() { // from class: c.l.1
                @Override // c.r
                public void a_(c cVar, long j) {
                    u.a(cVar.f3542b, 0L, j);
                    while (j > 0) {
                        t.this.g();
                        o oVar = cVar.f3541a;
                        int min = (int) Math.min(j, oVar.f3577c - oVar.f3576b);
                        outputStream.write(oVar.f3575a, oVar.f3576b, min);
                        oVar.f3576b += min;
                        long j2 = min;
                        j -= j2;
                        cVar.f3542b -= j2;
                        if (oVar.f3576b == oVar.f3577c) {
                            cVar.f3541a = oVar.b();
                            p.a(oVar);
                        }
                    }
                }

                @Override // c.r, java.io.Flushable
                public void flush() {
                    outputStream.flush();
                }

                @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    outputStream.close();
                }

                @Override // c.r
                public t a() {
                    return t.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    public static r a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a c2 = c(socket);
        return c2.a(a(socket.getOutputStream(), c2));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream != null) {
            if (tVar == null) {
                throw new IllegalArgumentException("timeout == null");
            }
            return new s() { // from class: c.l.2
                @Override // c.s
                public long a(c cVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0L;
                    } else {
                        try {
                            t.this.g();
                            o e2 = cVar.e(1);
                            int read = inputStream.read(e2.f3575a, e2.f3577c, (int) Math.min(j, 8192 - e2.f3577c));
                            if (read == -1) {
                                return -1L;
                            }
                            e2.f3577c += read;
                            long j2 = read;
                            cVar.f3542b += j2;
                            return j2;
                        } catch (AssertionError e3) {
                            if (l.a(e3)) {
                                throw new IOException(e3);
                            }
                            throw e3;
                        }
                    }
                }

                @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    inputStream.close();
                }

                @Override // c.s
                public t a() {
                    return t.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    public static s a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static r b(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static r c(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }

    public static r a() {
        return new r() { // from class: c.l.3
            @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // c.r, java.io.Flushable
            public void flush() {
            }

            @Override // c.r
            public void a_(c cVar, long j) {
                cVar.i(j);
            }

            @Override // c.r
            public t a() {
                return t.f3582c;
            }
        };
    }

    public static s b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a c2 = c(socket);
        return c2.a(a(socket.getInputStream(), c2));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: c.l.4
            @Override // c.a
            protected IOException a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // c.a
            protected void a() {
                try {
                    socket.close();
                } catch (AssertionError e2) {
                    if (l.a(e2)) {
                        Logger logger = l.f3562a;
                        Level level = Level.WARNING;
                        logger.log(level, "Failed to close timed out socket " + socket, (Throwable) e2);
                        return;
                    }
                    throw e2;
                } catch (Exception e3) {
                    Logger logger2 = l.f3562a;
                    Level level2 = Level.WARNING;
                    logger2.log(level2, "Failed to close timed out socket " + socket, (Throwable) e3);
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
