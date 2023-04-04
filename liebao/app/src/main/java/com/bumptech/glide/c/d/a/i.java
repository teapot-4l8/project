package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.bumptech.glide.c.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: classes.dex */
public final class i implements com.bumptech.glide.c.f {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f4996a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4997b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        int a(byte[] bArr, int i);

        long a(long j);

        short b();

        int c();
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    @Override // com.bumptech.glide.c.f
    public f.a a(InputStream inputStream) {
        return a(new d((InputStream) com.bumptech.glide.i.i.a(inputStream)));
    }

    @Override // com.bumptech.glide.c.f
    public f.a a(ByteBuffer byteBuffer) {
        return a(new a((ByteBuffer) com.bumptech.glide.i.i.a(byteBuffer)));
    }

    @Override // com.bumptech.glide.c.f
    public int a(InputStream inputStream, com.bumptech.glide.c.b.a.b bVar) {
        return a(new d((InputStream) com.bumptech.glide.i.i.a(inputStream)), (com.bumptech.glide.c.b.a.b) com.bumptech.glide.i.i.a(bVar));
    }

    private f.a a(c cVar) {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return f.a.JPEG;
        }
        int a3 = ((a2 << 16) & (-65536)) | (cVar.a() & 65535);
        if (a3 == -1991225785) {
            cVar.a(21L);
            return cVar.c() >= 3 ? f.a.PNG_A : f.a.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return f.a.GIF;
        } else {
            if (a3 != 1380533830) {
                return f.a.UNKNOWN;
            }
            cVar.a(4L);
            if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535)) != 1464156752) {
                return f.a.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535);
            if ((a4 & (-256)) != 1448097792) {
                return f.a.UNKNOWN;
            }
            int i = a4 & 255;
            if (i == 88) {
                cVar.a(4L);
                return (cVar.c() & 16) != 0 ? f.a.WEBP_A : f.a.WEBP;
            } else if (i == 76) {
                cVar.a(4L);
                return (cVar.c() & 8) != 0 ? f.a.WEBP_A : f.a.WEBP;
            } else {
                return f.a.WEBP;
            }
        }
    }

    private int a(c cVar, com.bumptech.glide.c.b.a.b bVar) {
        int a2 = cVar.a();
        if (!a(a2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.a((com.bumptech.glide.c.b.a.b) bArr);
        }
    }

    private int a(c cVar, byte[] bArr, int i) {
        int a2 = cVar.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            }
            return -1;
        } else if (a(bArr, i)) {
            return a(new b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f4996a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f4996a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    private int b(c cVar) {
        short b2;
        short b3;
        int a2;
        long j;
        long a3;
        do {
            if (cVar.b() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) b2));
                }
                return -1;
            }
            b3 = cVar.b();
            if (b3 == 218) {
                return -1;
            }
            if (b3 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b3 == 225) {
                return a2;
            }
            j = a2;
            a3 = cVar.a(j);
        } while (a3 == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
        }
        return -1;
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short b2 = bVar.b(6);
        if (b2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (b2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) b2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.a(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i = 0; i < b3; i++) {
            int a3 = a(a2, i);
            short b4 = bVar.b(a3);
            if (b4 == 274) {
                short b5 = bVar.b(a3 + 2);
                if (b5 < 1 || b5 > 12) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) b5));
                    }
                } else {
                    int a4 = bVar.a(a3 + 4);
                    if (a4 < 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                        }
                        int i2 = a4 + f4997b[b5];
                        if (i2 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) b5));
                            }
                        } else {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > bVar.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) b4));
                                }
                            } else if (i2 < 0 || i2 + i3 > bVar.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) b4));
                                }
                            } else {
                                return bVar.b(i3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4999a;

        b(byte[] bArr, int i) {
            this.f4999a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        void a(ByteOrder byteOrder) {
            this.f4999a.order(byteOrder);
        }

        int a() {
            return this.f4999a.remaining();
        }

        int a(int i) {
            if (a(i, 4)) {
                return this.f4999a.getInt(i);
            }
            return -1;
        }

        short b(int i) {
            if (a(i, 2)) {
                return this.f4999a.getShort(i);
            }
            return (short) -1;
        }

        private boolean a(int i, int i2) {
            return this.f4999a.remaining() - i >= i2;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f4998a;

        a(ByteBuffer byteBuffer) {
            this.f4998a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int a() {
            return ((c() << 8) & 65280) | (c() & 255);
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public short b() {
            return (short) (c() & 255);
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public long a(long j) {
            int min = (int) Math.min(this.f4998a.remaining(), j);
            ByteBuffer byteBuffer = this.f4998a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f4998a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f4998a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int c() {
            if (this.f4998a.remaining() < 1) {
                return -1;
            }
            return this.f4998a.get();
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f5000a;

        d(InputStream inputStream) {
            this.f5000a = inputStream;
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int a() {
            return ((this.f5000a.read() << 8) & 65280) | (this.f5000a.read() & 255);
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public short b() {
            return (short) (this.f5000a.read() & 255);
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f5000a.skip(j2);
                if (skip <= 0) {
                    if (this.f5000a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int a(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f5000a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // com.bumptech.glide.c.d.a.i.c
        public int c() {
            return this.f5000a.read();
        }
    }
}
