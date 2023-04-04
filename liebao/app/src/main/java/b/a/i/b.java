package b.a.i;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b {
    private static int a(FileChannel fileChannel, long j, ByteBuffer byteBuffer) {
        int read;
        int i = 0;
        while (byteBuffer.hasRemaining() && (read = fileChannel.read(byteBuffer, j)) != -1) {
            j += read;
            i += read;
        }
        return i;
    }

    private static int a(FileChannel fileChannel, long j, byte[] bArr, int i, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        int i3 = 0;
        while (i3 < i2) {
            int read = fileChannel.read(wrap, i3 + j);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }

    public static a a(FileChannel fileChannel) {
        f b2 = b(fileChannel);
        if (b2 == null) {
            return null;
        }
        if (b2.f < 32) {
            return new a(b2);
        }
        byte[] bArr = new byte[24];
        a(fileChannel, b2.f - 24, bArr, 0, 24);
        long c2 = c.c(bArr, 0, ByteOrder.LITTLE_ENDIAN);
        long c3 = c.c(bArr, 8, ByteOrder.LITTLE_ENDIAN);
        long c4 = c.c(bArr, 16, ByteOrder.LITTLE_ENDIAN);
        if (c3 == 2334950737559900225L && c4 == 3617552046287187010L) {
            int i = (int) (8 + c2);
            long j = i;
            long j2 = b2.f - j;
            if (i < 32 || j2 < 0) {
                return new a(b2);
            }
            if (j > 20971520) {
                return new a(b2);
            }
            ByteBuffer allocate = ByteBuffer.allocate(i - 24);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            if (a(fileChannel, j2, allocate) == allocate.capacity() && ((ByteBuffer) allocate.flip()).getLong() == c2) {
                e eVar = new e(j2);
                while (allocate.hasRemaining()) {
                    long j3 = allocate.getLong();
                    int i2 = allocate.getInt();
                    int i3 = (int) (j3 - 4);
                    byte[] bArr2 = new byte[i3];
                    allocate.get(bArr2, 0, i3);
                    eVar.a(i2, bArr2);
                }
                return new a(eVar, b2);
            }
            return new a(b2);
        }
        return new a(b2);
    }

    private static void a(FileChannel fileChannel, FileChannel fileChannel2, long j, long j2) {
        while (j2 > 0) {
            long transferTo = fileChannel.transferTo(j, j2, fileChannel2);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public static void a(byte[] bArr, File file, File file2) {
        ByteBuffer[] e2;
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            FileChannel channel = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            a a2 = a(channel);
            channel.position(0L);
            if (a2 == null) {
                a(channel, channel2, 0L, channel.size());
                return;
            }
            a2.a(bArr);
            e b2 = a2.b();
            f a3 = a2.a();
            if (b2 != null) {
                a(channel, channel2, 0L, b2.b());
                for (ByteBuffer byteBuffer : b2.e()) {
                    while (byteBuffer.hasRemaining()) {
                        channel2.write(byteBuffer);
                    }
                }
                a(channel, channel2, a3.f, a3.h - a3.f);
            } else {
                a(channel, channel2, 0L, a3.h);
            }
            ByteBuffer a4 = a3.a(b2 != null ? b2.a() : a3.f);
            while (a4.hasRemaining()) {
                channel2.write(a4);
            }
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    private static f b(FileChannel fileChannel) {
        int i;
        byte[] bArr = new byte[128];
        long size = fileChannel.size();
        f fVar = null;
        if (size < 22) {
            return null;
        }
        long j = 106;
        long j2 = (size > 65557 ? size - 65557 : 0L) - j;
        long j3 = size - 128;
        while (j3 >= j2) {
            if (j3 < 0) {
                int i2 = (int) (-j3);
                Arrays.fill(bArr, 0, i2, (byte) 0);
                i = i2;
            } else {
                i = 0;
            }
            long j4 = j3;
            long j5 = j;
            a(fileChannel, j3 < 0 ? 0L : j3, bArr, i, 128 - i);
            for (int i3 = 106; i3 >= 0; i3--) {
                if (bArr[i3 + 0] == 80 && bArr[i3 + 1] == 75 && bArr[i3 + 2] == 5 && bArr[i3 + 3] == 6) {
                    int b2 = c.b(bArr, i3 + 20, ByteOrder.LITTLE_ENDIAN) & 65535;
                    long j6 = j4 + i3;
                    if (j6 + 22 + b2 == size) {
                        f fVar2 = new f();
                        fVar2.h = j6;
                        fVar2.f3239a = c.b(bArr, i3 + 4, ByteOrder.LITTLE_ENDIAN) & 65535;
                        fVar2.f3240b = c.b(bArr, i3 + 6, ByteOrder.LITTLE_ENDIAN) & 65535;
                        fVar2.f3241c = c.b(bArr, i3 + 8, ByteOrder.LITTLE_ENDIAN) & 65535;
                        fVar2.f3242d = 65535 & c.b(bArr, i3 + 10, ByteOrder.LITTLE_ENDIAN);
                        fVar2.f3243e = c.a(bArr, i3 + 12, ByteOrder.LITTLE_ENDIAN) & 4294967295L;
                        fVar2.f = c.a(bArr, i3 + 16, ByteOrder.LITTLE_ENDIAN) & 4294967295L;
                        if (b2 > 0) {
                            fVar2.g = new byte[b2];
                            a(fileChannel, fVar2.h + 22, fVar2.g, 0, b2);
                        }
                        return fVar2;
                    }
                }
            }
            j3 = j4 - j5;
            j = j5;
            fVar = null;
        }
        return fVar;
    }
}
