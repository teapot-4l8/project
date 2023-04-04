package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.umeng.analytics.pro.o;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4612a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private int[] f4613b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f4614c;

    /* renamed from: d  reason: collision with root package name */
    private final a.InterfaceC0084a f4615d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f4616e;
    private byte[] f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private int f4617q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public e(a.InterfaceC0084a interfaceC0084a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0084a);
        a(cVar, byteBuffer, i);
    }

    public e(a.InterfaceC0084a interfaceC0084a) {
        this.f4614c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f4615d = interfaceC0084a;
        this.m = new c();
    }

    @Override // com.bumptech.glide.b.a
    public ByteBuffer a() {
        return this.f4616e;
    }

    @Override // com.bumptech.glide.b.a
    public void b() {
        this.l = (this.l + 1) % this.m.f4605c;
    }

    public int a(int i) {
        if (i < 0 || i >= this.m.f4605c) {
            return -1;
        }
        return this.m.f4607e.get(i).i;
    }

    @Override // com.bumptech.glide.b.a
    public int c() {
        int i;
        if (this.m.f4605c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.bumptech.glide.b.a
    public int d() {
        return this.m.f4605c;
    }

    @Override // com.bumptech.glide.b.a
    public int e() {
        return this.l;
    }

    @Override // com.bumptech.glide.b.a
    public void f() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.b.a
    public int g() {
        return this.f4616e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.bumptech.glide.b.a
    public synchronized Bitmap h() {
        if (this.m.f4605c <= 0 || this.l < 0) {
            if (Log.isLoggable(f4612a, 3)) {
                String str = f4612a;
                Log.d(str, "Unable to decode frame, frameCount=" + this.m.f4605c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p != 1 && this.p != 2) {
            this.p = 0;
            if (this.f == null) {
                this.f = this.f4615d.a(255);
            }
            b bVar = this.m.f4607e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.m.f4607e.get(i) : null;
            int[] iArr = bVar.k != null ? bVar.k : this.m.f4603a;
            this.f4613b = iArr;
            if (iArr == null) {
                if (Log.isLoggable(f4612a, 3)) {
                    String str2 = f4612a;
                    Log.d(str2, "No valid color table found for frame #" + this.l);
                }
                this.p = 1;
                return null;
            }
            if (bVar.f) {
                System.arraycopy(this.f4613b, 0, this.f4614c, 0, this.f4613b.length);
                int[] iArr2 = this.f4614c;
                this.f4613b = iArr2;
                iArr2[bVar.h] = 0;
            }
            return a(bVar, bVar2);
        }
        if (Log.isLoggable(f4612a, 3)) {
            String str3 = f4612a;
            Log.d(str3, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    @Override // com.bumptech.glide.b.a
    public void i() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f4615d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f4615d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f4615d.a(bitmap);
        }
        this.n = null;
        this.f4616e = null;
        this.t = null;
        byte[] bArr2 = this.f;
        if (bArr2 != null) {
            this.f4615d.a(bArr2);
        }
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.p = 0;
        this.m = cVar;
        this.l = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f4616e = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f4616e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        Iterator<b> it = cVar.f4607e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.o = true;
                break;
            }
        }
        this.f4617q = highestOneBit;
        this.s = cVar.f / highestOneBit;
        this.r = cVar.g / highestOneBit;
        this.j = this.f4615d.a(cVar.f * cVar.g);
        this.k = this.f4615d.b(this.s * this.r);
    }

    @Override // com.bumptech.glide.b.a
    public void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.u = config;
    }

    private Bitmap a(b bVar, b bVar2) {
        Bitmap bitmap;
        int[] iArr = this.k;
        int i = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f4615d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g > 0) {
            if (bVar2.g == 2) {
                if (!bVar.f) {
                    int i2 = this.m.l;
                    if (bVar.k == null || this.m.j != bVar.h) {
                        i = i2;
                    }
                } else if (this.l == 0) {
                    this.t = true;
                }
                int i3 = bVar2.f4601d / this.f4617q;
                int i4 = bVar2.f4599b / this.f4617q;
                int i5 = bVar2.f4600c / this.f4617q;
                int i6 = bVar2.f4598a / this.f4617q;
                int i7 = this.s;
                int i8 = (i4 * i7) + i6;
                int i9 = (i3 * i7) + i8;
                while (i8 < i9) {
                    int i10 = i8 + i5;
                    for (int i11 = i8; i11 < i10; i11++) {
                        iArr[i11] = i;
                    }
                    i8 += this.s;
                }
            } else if (bVar2.g == 3 && (bitmap = this.n) != null) {
                int i12 = this.s;
                bitmap.getPixels(iArr, 0, i12, 0, 0, i12, this.r);
            }
        }
        c(bVar);
        if (bVar.f4602e || this.f4617q != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && (bVar.g == 0 || bVar.g == 1)) {
            if (this.n == null) {
                this.n = l();
            }
            Bitmap bitmap3 = this.n;
            int i13 = this.s;
            bitmap3.setPixels(iArr, 0, i13, 0, 0, i13, this.r);
        }
        Bitmap l = l();
        int i14 = this.s;
        l.setPixels(iArr, 0, i14, 0, 0, i14, this.r);
        return l;
    }

    private void a(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i = bVar2.f4601d;
        int i2 = bVar2.f4599b;
        int i3 = bVar2.f4600c;
        int i4 = bVar2.f4598a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f4613b;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.f4600c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b3 = bArr[i11];
                int i13 = i;
                int i14 = b3 & 255;
                if (i14 != b2) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    private void b(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.k;
        int i6 = bVar.f4601d / this.f4617q;
        int i7 = bVar.f4599b / this.f4617q;
        int i8 = bVar.f4600c / this.f4617q;
        int i9 = bVar.f4598a / this.f4617q;
        boolean z = this.l == 0;
        int i10 = this.f4617q;
        int i11 = this.s;
        int i12 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f4613b;
        Boolean bool = this.t;
        int i13 = 8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        while (i14 < i6) {
            Boolean bool2 = bool;
            if (bVar.f4602e) {
                if (i15 >= i6) {
                    i = i6;
                    int i17 = i16 + 1;
                    if (i17 == 2) {
                        i16 = i17;
                        i15 = 4;
                    } else if (i17 == 3) {
                        i16 = i17;
                        i15 = 2;
                        i13 = 4;
                    } else if (i17 != 4) {
                        i16 = i17;
                    } else {
                        i16 = i17;
                        i15 = 1;
                        i13 = 2;
                    }
                } else {
                    i = i6;
                }
                i2 = i15 + i13;
            } else {
                i = i6;
                i2 = i15;
                i15 = i14;
            }
            int i18 = i15 + i7;
            boolean z2 = i10 == 1;
            if (i18 < i12) {
                int i19 = i18 * i11;
                int i20 = i19 + i9;
                int i21 = i20 + i8;
                int i22 = i19 + i11;
                if (i22 < i21) {
                    i21 = i22;
                }
                i3 = i2;
                int i23 = i14 * i10 * bVar.f4600c;
                if (z2) {
                    int i24 = i20;
                    while (i24 < i21) {
                        int i25 = i7;
                        int i26 = iArr2[bArr[i23] & 255];
                        if (i26 != 0) {
                            iArr[i24] = i26;
                        } else if (z && bool2 == null) {
                            bool2 = true;
                        }
                        i23 += i10;
                        i24++;
                        i7 = i25;
                    }
                } else {
                    i5 = i7;
                    int i27 = ((i21 - i20) * i10) + i23;
                    int i28 = i20;
                    while (true) {
                        i4 = i8;
                        if (i28 < i21) {
                            int a2 = a(i23, i27, bVar.f4600c);
                            if (a2 != 0) {
                                iArr[i28] = a2;
                            } else if (z && bool2 == null) {
                                bool2 = true;
                            }
                            i23 += i10;
                            i28++;
                            i8 = i4;
                        }
                    }
                    bool = bool2;
                    i14++;
                    i7 = i5;
                    i8 = i4;
                    i6 = i;
                    i15 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i7;
            i4 = i8;
            bool = bool2;
            i14++;
            i7 = i5;
            i8 = i4;
            i6 = i;
            i15 = i3;
        }
        Boolean bool3 = bool;
        if (this.t == null) {
            this.t = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.f4617q + i; i9++) {
            byte[] bArr = this.j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f4613b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.f4617q + i11; i12++) {
            byte[] bArr2 = this.j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f4613b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(b bVar) {
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f4616e.position(bVar.j);
        }
        int i = bVar == null ? eVar.m.f * eVar.m.g : bVar.f4601d * bVar.f4600c;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i) {
            eVar.j = eVar.f4615d.a(i);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.g == null) {
            eVar.g = new short[4096];
        }
        short[] sArr = eVar.g;
        if (eVar.h == null) {
            eVar.h = new byte[4096];
        }
        byte[] bArr3 = eVar.h;
        if (eVar.i == null) {
            eVar.i = new byte[o.a.f6596a];
        }
        byte[] bArr4 = eVar.i;
        int j = j();
        int i2 = 1 << j;
        int i3 = i2 + 1;
        int i4 = i2 + 2;
        int i5 = j + 1;
        int i6 = (1 << i5) - 1;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            sArr[i8] = 0;
            bArr3[i8] = (byte) i8;
        }
        byte[] bArr5 = eVar.f;
        int i9 = i5;
        int i10 = i4;
        int i11 = i6;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = -1;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i7 >= i) {
                break;
            }
            if (i12 == 0) {
                i12 = k();
                if (i12 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i13 = 0;
            }
            i15 += (bArr5[i13] & 255) << i14;
            i13++;
            i12--;
            int i20 = i14 + 8;
            int i21 = i10;
            int i22 = i9;
            int i23 = i17;
            int i24 = i5;
            int i25 = i18;
            while (true) {
                if (i20 < i22) {
                    i17 = i23;
                    i10 = i21;
                    i14 = i20;
                    eVar = this;
                    i18 = i25;
                    i5 = i24;
                    i9 = i22;
                    break;
                }
                int i26 = i4;
                int i27 = i15 & i11;
                i15 >>= i22;
                i20 -= i22;
                if (i27 == i2) {
                    i11 = i6;
                    i22 = i24;
                    i21 = i26;
                    i4 = i21;
                    i23 = -1;
                } else if (i27 == i3) {
                    i14 = i20;
                    i18 = i25;
                    i10 = i21;
                    i5 = i24;
                    i4 = i26;
                    i17 = i23;
                    i9 = i22;
                    eVar = this;
                    break;
                } else if (i23 == -1) {
                    bArr2[i16] = bArr3[i27];
                    i16++;
                    i7++;
                    i23 = i27;
                    i25 = i23;
                    i4 = i26;
                    i20 = i20;
                } else {
                    if (i27 >= i21) {
                        bArr4[i19] = (byte) i25;
                        i19++;
                        s = i23;
                    } else {
                        s = i27;
                    }
                    while (s >= i2) {
                        bArr4[i19] = bArr3[s];
                        i19++;
                        s = sArr[s];
                    }
                    i25 = bArr3[s] & 255;
                    byte b2 = (byte) i25;
                    bArr2[i16] = b2;
                    while (true) {
                        i16++;
                        i7++;
                        if (i19 <= 0) {
                            break;
                        }
                        i19--;
                        bArr2[i16] = bArr4[i19];
                    }
                    byte[] bArr6 = bArr4;
                    if (i21 < 4096) {
                        sArr[i21] = (short) i23;
                        bArr3[i21] = b2;
                        i21++;
                        if ((i21 & i11) == 0 && i21 < 4096) {
                            i22++;
                            i11 += i21;
                        }
                    }
                    i23 = i27;
                    i4 = i26;
                    i20 = i20;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i16, i, (byte) 0);
    }

    private int j() {
        return this.f4616e.get() & 255;
    }

    private int k() {
        int j = j();
        if (j <= 0) {
            return j;
        }
        ByteBuffer byteBuffer = this.f4616e;
        byteBuffer.get(this.f, 0, Math.min(j, byteBuffer.remaining()));
        return j;
    }

    private Bitmap l() {
        Boolean bool = this.t;
        Bitmap a2 = this.f4615d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }
}
