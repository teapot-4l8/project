package com.c.a.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* compiled from: PayloadReader.java */
/* loaded from: classes.dex */
public final class e {
    public static String a(File file, int i) {
        byte[] b2 = b(file, i);
        if (b2 == null) {
            return null;
        }
        try {
            return new String(b2, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] b(File file, int i) {
        ByteBuffer byteBuffer;
        Map<Integer, ByteBuffer> a2 = a(file);
        if (a2 == null || (byteBuffer = a2.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return a(byteBuffer);
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Map<Integer, ByteBuffer> a(File file) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Map<Integer, ByteBuffer> map = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                } catch (IOException unused) {
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = null;
                }
                try {
                    map = a.a(a.c(fileChannel).a());
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (IOException unused3) {
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused7) {
                fileChannel = null;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                randomAccessFile = null;
            }
            randomAccessFile.close();
        } catch (f | IOException unused8) {
        }
        return map;
    }
}
