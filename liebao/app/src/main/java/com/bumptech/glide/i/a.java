package com.bumptech.glide.i;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ByteBufferUtil.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f5233a = new AtomicReference<>();

    public static ByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length == 0) {
                    throw new IOException("File unsuitable for memory mapping");
                }
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return load;
                } catch (Throwable th) {
                    th = th;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void a(ByteBuffer byteBuffer, File file) {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileChannel = randomAccessFile.getChannel();
            fileChannel.write(byteBuffer);
            fileChannel.force(false);
            fileChannel.close();
            randomAccessFile.close();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        b c2 = c(byteBuffer);
        if (c2 != null && c2.f5240a == 0 && c2.f5241b == c2.f5242c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream b(ByteBuffer byteBuffer) {
        return new C0098a(byteBuffer);
    }

    private static b c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferUtil.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f5240a;

        /* renamed from: b  reason: collision with root package name */
        final int f5241b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f5242c;

        b(byte[] bArr, int i, int i2) {
            this.f5242c = bArr;
            this.f5240a = i;
            this.f5241b = i2;
        }
    }

    /* compiled from: ByteBufferUtil.java */
    /* renamed from: com.bumptech.glide.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0098a extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f5235a;

        /* renamed from: b  reason: collision with root package name */
        private int f5236b = -1;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        C0098a(ByteBuffer byteBuffer) {
            this.f5235a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5235a.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f5235a.hasRemaining()) {
                return this.f5235a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f5236b = this.f5235a.position();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (this.f5235a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f5235a.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            if (this.f5236b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f5235a.position(this.f5236b);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (this.f5235a.hasRemaining()) {
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.f5235a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }
    }
}
