package com.bumptech.glide.b;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f4609b;

    /* renamed from: c  reason: collision with root package name */
    private c f4610c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f4608a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f4611d = 0;

    public d a(ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f4609b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f4609b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f4609b = null;
        this.f4610c = null;
    }

    private void c() {
        this.f4609b = null;
        Arrays.fill(this.f4608a, (byte) 0);
        this.f4610c = new c();
        this.f4611d = 0;
    }

    public c b() {
        if (this.f4609b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (o()) {
            return this.f4610c;
        }
        h();
        if (!o()) {
            d();
            if (this.f4610c.f4605c < 0) {
                this.f4610c.f4604b = 1;
            }
        }
        return this.f4610c;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f4610c.f4605c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 == 1) {
                    k();
                } else if (m2 == 249) {
                    this.f4610c.f4606d = new b();
                    e();
                } else if (m2 == 254) {
                    k();
                } else if (m2 == 255) {
                    l();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f4608a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        g();
                    } else {
                        k();
                    }
                } else {
                    k();
                }
            } else if (m == 44) {
                if (this.f4610c.f4606d == null) {
                    this.f4610c.f4606d = new b();
                }
                f();
            } else if (m != 59) {
                this.f4610c.f4604b = 1;
            } else {
                z = true;
            }
        }
    }

    private void e() {
        m();
        int m = m();
        this.f4610c.f4606d.g = (m & 28) >> 2;
        if (this.f4610c.f4606d.g == 0) {
            this.f4610c.f4606d.g = 1;
        }
        this.f4610c.f4606d.f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        this.f4610c.f4606d.i = n * 10;
        this.f4610c.f4606d.h = m();
        m();
    }

    private void f() {
        this.f4610c.f4606d.f4598a = n();
        this.f4610c.f4606d.f4599b = n();
        this.f4610c.f4606d.f4600c = n();
        this.f4610c.f4606d.f4601d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f4610c.f4606d.f4602e = (m & 64) != 0;
        if (z) {
            this.f4610c.f4606d.k = b(pow);
        } else {
            this.f4610c.f4606d.k = null;
        }
        this.f4610c.f4606d.j = this.f4609b.position();
        j();
        if (o()) {
            return;
        }
        this.f4610c.f4605c++;
        this.f4610c.f4607e.add(this.f4610c.f4606d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f4608a;
            if (bArr[0] == 1) {
                this.f4610c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f4611d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f4610c.f4604b = 1;
            return;
        }
        i();
        if (!this.f4610c.h || o()) {
            return;
        }
        c cVar = this.f4610c;
        cVar.f4603a = b(cVar.i);
        c cVar2 = this.f4610c;
        cVar2.l = cVar2.f4603a[this.f4610c.j];
    }

    private void i() {
        this.f4610c.f = n();
        this.f4610c.g = n();
        int m = m();
        this.f4610c.h = (m & 128) != 0;
        this.f4610c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f4610c.j = m();
        this.f4610c.k = m();
    }

    private int[] b(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f4609b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f4610c.f4604b = 1;
        }
        return iArr;
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f4609b.position(Math.min(this.f4609b.position() + m, this.f4609b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.f4611d = m;
        if (m > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f4611d) {
                try {
                    i2 = this.f4611d - i;
                    this.f4609b.get(this.f4608a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f4611d, e2);
                    }
                    this.f4610c.f4604b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f4609b.get() & 255;
        } catch (Exception unused) {
            this.f4610c.f4604b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f4609b.getShort();
    }

    private boolean o() {
        return this.f4610c.f4604b != 0;
    }
}
