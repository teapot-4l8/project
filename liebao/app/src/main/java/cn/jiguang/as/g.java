package cn.jiguang.as;

import java.util.HashMap;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Integer[] f3889a = new Integer[64];

    /* renamed from: d  reason: collision with root package name */
    private String f3892d;
    private String f;
    private boolean h;

    /* renamed from: e  reason: collision with root package name */
    private int f3893e = 3;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f3890b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private HashMap f3891c = new HashMap();
    private int g = Integer.MAX_VALUE;

    static {
        int i = 0;
        while (true) {
            Integer[] numArr = f3889a;
            if (i >= numArr.length) {
                return;
            }
            numArr[i] = Integer.valueOf(i);
            i++;
        }
    }

    public g(String str, int i) {
        this.f3892d = str;
    }

    private static Integer c(int i) {
        if (i >= 0) {
            Integer[] numArr = f3889a;
            if (i < numArr.length) {
                return numArr[i];
            }
        }
        return Integer.valueOf(i);
    }

    private void d(int i) {
        if (i < 0 || i > this.g) {
            throw new IllegalArgumentException(this.f3892d + " " + i + "is out of range");
        }
    }

    public final void a(int i) {
        this.g = 3;
    }

    public final void a(int i, String str) {
        d(i);
        Integer c2 = c(i);
        int i2 = this.f3893e;
        if (i2 == 2) {
            str = str.toUpperCase();
        } else if (i2 == 3) {
            str = str.toLowerCase();
        }
        this.f3890b.put(str, c2);
        this.f3891c.put(c2, str);
    }

    public final void a(boolean z) {
        this.h = true;
    }

    public final String b(int i) {
        d(i);
        String str = (String) this.f3891c.get(c(i));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i);
        if (this.f != null) {
            return this.f + num;
        }
        return num;
    }
}
