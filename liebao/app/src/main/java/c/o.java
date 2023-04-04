package c;

import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f3575a;

    /* renamed from: b  reason: collision with root package name */
    int f3576b;

    /* renamed from: c  reason: collision with root package name */
    int f3577c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3578d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3579e;
    o f;
    o g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f3575a = new byte[8192];
        this.f3579e = true;
        this.f3578d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3575a = bArr;
        this.f3576b = i;
        this.f3577c = i2;
        this.f3578d = z;
        this.f3579e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a() {
        this.f3578d = true;
        return new o(this.f3575a, this.f3576b, this.f3577c, true, false);
    }

    @Nullable
    public final o b() {
        o oVar = this.f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.g;
        oVar2.f = this.f;
        this.f.g = oVar2;
        this.f = null;
        this.g = null;
        return oVar;
    }

    public final o a(o oVar) {
        oVar.g = this;
        oVar.f = this.f;
        this.f.g = oVar;
        this.f = oVar;
        return oVar;
    }

    public final o a(int i) {
        o a2;
        if (i <= 0 || i > this.f3577c - this.f3576b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            a2 = a();
        } else {
            a2 = p.a();
            System.arraycopy(this.f3575a, this.f3576b, a2.f3575a, 0, i);
        }
        a2.f3577c = a2.f3576b + i;
        this.f3576b += i;
        this.g.a(a2);
        return a2;
    }

    public final void c() {
        o oVar = this.g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.f3579e) {
            int i = this.f3577c - this.f3576b;
            if (i > (8192 - oVar.f3577c) + (oVar.f3578d ? 0 : oVar.f3576b)) {
                return;
            }
            a(this.g, i);
            b();
            p.a(this);
        }
    }

    public final void a(o oVar, int i) {
        if (!oVar.f3579e) {
            throw new IllegalArgumentException();
        }
        int i2 = oVar.f3577c;
        if (i2 + i > 8192) {
            if (oVar.f3578d) {
                throw new IllegalArgumentException();
            }
            int i3 = oVar.f3576b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.f3575a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            oVar.f3577c -= oVar.f3576b;
            oVar.f3576b = 0;
        }
        System.arraycopy(this.f3575a, this.f3576b, oVar.f3575a, oVar.f3577c, i);
        oVar.f3577c += i;
        this.f3576b += i;
    }
}
