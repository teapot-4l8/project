package cn.jiguang.as;

import java.util.Random;

/* loaded from: classes.dex */
public final class e implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    private static Random f3880d = new Random();

    /* renamed from: a  reason: collision with root package name */
    private int f3881a;

    /* renamed from: b  reason: collision with root package name */
    private int f3882b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f3883c;

    public e() {
        this.f3882b = 256;
        b();
    }

    private e(int i) {
        this.f3882b = 256;
        b();
        if (i >= 0 && i <= 65535) {
            this.f3881a = i;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this(cVar.g());
        this.f3882b = cVar.g();
        int i = 0;
        while (true) {
            int[] iArr = this.f3883c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = cVar.g();
            i++;
        }
    }

    private void b() {
        this.f3883c = new int[4];
        this.f3882b = 256;
        this.f3881a = -1;
    }

    private int c() {
        int i;
        int i2 = this.f3881a;
        if (i2 >= 0) {
            return i2;
        }
        synchronized (this) {
            if (this.f3881a < 0) {
                this.f3881a = f3880d.nextInt(65535);
            }
            i = this.f3881a;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f3882b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        int[] iArr = this.f3883c;
        if (iArr[i] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(d dVar) {
        dVar.c(c());
        dVar.c(this.f3882b);
        int i = 0;
        while (true) {
            int[] iArr = this.f3883c;
            if (i >= iArr.length) {
                return;
            }
            dVar.c(iArr[i]);
            i++;
        }
    }

    public final int b(int i) {
        return this.f3883c[i];
    }

    public final Object clone() {
        e eVar = new e();
        eVar.f3881a = this.f3881a;
        eVar.f3882b = this.f3882b;
        int[] iArr = this.f3883c;
        System.arraycopy(iArr, 0, eVar.f3883c, 0, iArr.length);
        return eVar;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + c());
        stringBuffer.append("\n");
        stringBuffer.append("; ");
        for (int i = 0; i < 4; i++) {
            stringBuffer.append(p.a(i) + ": " + this.f3883c[i] + " ");
        }
        return stringBuffer.toString();
    }
}
