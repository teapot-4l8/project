package a.a.a.d;

import cn.jiguang.internal.JConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* compiled from: LOCRecord.java */
/* loaded from: classes.dex */
public class ao extends bx {

    /* renamed from: a  reason: collision with root package name */
    private static NumberFormat f134a;

    /* renamed from: b  reason: collision with root package name */
    private static NumberFormat f135b;

    /* renamed from: c  reason: collision with root package name */
    private long f136c;

    /* renamed from: d  reason: collision with root package name */
    private long f137d;

    /* renamed from: e  reason: collision with root package name */
    private long f138e;
    private long f;
    private long k;
    private long l;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f134a = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        f135b = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    @Override // a.a.a.d.bx
    bx a() {
        return new ao();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        if (tVar.g() != 0) {
            throw new dg("Invalid LOC version");
        }
        this.f136c = b(tVar.g());
        this.f137d = b(tVar.g());
        this.f138e = b(tVar.g());
        this.f = tVar.i();
        this.k = tVar.i();
        this.l = tVar.i();
    }

    private void a(StringBuffer stringBuffer, NumberFormat numberFormat, long j, long j2) {
        stringBuffer.append(j / j2);
        long j3 = j % j2;
        if (j3 != 0) {
            stringBuffer.append(".");
            stringBuffer.append(numberFormat.format(j3));
        }
    }

    private String a(long j, char c2, char c3) {
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j - 2147483648L;
        if (j2 < 0) {
            j2 = -j2;
            c2 = c3;
        }
        stringBuffer.append(j2 / JConstants.HOUR);
        long j3 = j2 % JConstants.HOUR;
        stringBuffer.append(" ");
        stringBuffer.append(j3 / JConstants.MIN);
        long j4 = j3 % JConstants.MIN;
        stringBuffer.append(" ");
        a(stringBuffer, f135b, j4, 1000L);
        stringBuffer.append(" ");
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.f, 'N', 'S'));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.k, 'E', 'W'));
        stringBuffer.append(" ");
        a(stringBuffer, f134a, this.l - 10000000, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f134a, this.f136c, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f134a, this.f137d, 100L);
        stringBuffer.append("m ");
        a(stringBuffer, f134a, this.f138e, 100L);
        stringBuffer.append("m");
        return stringBuffer.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(0);
        vVar.b(b(this.f136c));
        vVar.b(b(this.f137d));
        vVar.b(b(this.f138e));
        vVar.a(this.f);
        vVar.a(this.k);
        vVar.a(this.l);
    }

    private static long b(int i) {
        long j = i >> 4;
        int i2 = i & 15;
        if (j > 9 || i2 > 9) {
            throw new dg("Invalid LOC Encoding");
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j;
            }
            j *= 10;
            i2 = i3;
        }
    }

    private int b(long j) {
        byte b2 = 0;
        while (j > 9) {
            b2 = (byte) (b2 + 1);
            j /= 10;
        }
        return (int) ((j << 4) + b2);
    }
}
