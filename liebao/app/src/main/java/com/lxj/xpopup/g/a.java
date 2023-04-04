package com.lxj.xpopup.g;

import java.io.InputStream;

/* compiled from: ImageHeaderParser.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: com.lxj.xpopup.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private interface InterfaceC0127a {
        int a();

        long a(long j);

        int b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.lxj.xpopup.c.a a(InputStream inputStream) {
        b bVar = new b(inputStream);
        int a2 = bVar.a();
        if (a2 == 65496) {
            return com.lxj.xpopup.c.a.JPEG;
        }
        int a3 = ((a2 << 16) & (-65536)) | (bVar.a() & 65535);
        if (a3 == -1991225785) {
            bVar.a(21L);
            return bVar.b() >= 3 ? com.lxj.xpopup.c.a.PNG_A : com.lxj.xpopup.c.a.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return com.lxj.xpopup.c.a.GIF;
        } else {
            if (a3 != 1380533830) {
                return com.lxj.xpopup.c.a.UNKNOWN;
            }
            bVar.a(4L);
            if ((((bVar.a() << 16) & (-65536)) | (bVar.a() & 65535)) != 1464156752) {
                return com.lxj.xpopup.c.a.UNKNOWN;
            }
            int a4 = ((bVar.a() << 16) & (-65536)) | (bVar.a() & 65535);
            if ((a4 & (-256)) != 1448097792) {
                return com.lxj.xpopup.c.a.UNKNOWN;
            }
            int i = a4 & 255;
            if (i == 88) {
                bVar.a(4L);
                return (bVar.b() & 16) != 0 ? com.lxj.xpopup.c.a.WEBP_A : com.lxj.xpopup.c.a.WEBP;
            } else if (i == 76) {
                bVar.a(4L);
                return (bVar.b() & 8) != 0 ? com.lxj.xpopup.c.a.WEBP_A : com.lxj.xpopup.c.a.WEBP;
            } else {
                inputStream.close();
                return com.lxj.xpopup.c.a.WEBP;
            }
        }
    }

    /* compiled from: ImageHeaderParser.java */
    /* loaded from: classes2.dex */
    private static final class b implements InterfaceC0127a {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f5515a;

        b(InputStream inputStream) {
            this.f5515a = inputStream;
        }

        @Override // com.lxj.xpopup.g.a.InterfaceC0127a
        public int a() {
            return ((this.f5515a.read() << 8) & 65280) | (this.f5515a.read() & 255);
        }

        @Override // com.lxj.xpopup.g.a.InterfaceC0127a
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f5515a.skip(j2);
                if (skip <= 0) {
                    if (this.f5515a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.lxj.xpopup.g.a.InterfaceC0127a
        public int b() {
            return this.f5515a.read();
        }
    }
}
