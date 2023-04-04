package okhttp3.internal.e;

import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f7630a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f7631b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f7630a = 0;
        Arrays.fill(this.f7631b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f7631b;
            if (i < iArr.length) {
                this.f7630a = (1 << i) | this.f7630a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f7630a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.f7631b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f7630a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.f7630a & 2) != 0) {
            return this.f7631b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.f7630a & 16) != 0 ? this.f7631b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (this.f7630a & 32) != 0 ? this.f7631b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.f7630a & 128) != 0) {
            return this.f7631b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.a(i)) {
                a(i, mVar.b(i));
            }
        }
    }
}
