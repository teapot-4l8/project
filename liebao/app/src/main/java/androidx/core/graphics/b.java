package androidx.core.graphics;

import android.graphics.Insets;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f1603a = new b(0, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f1604b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1605c;

    /* renamed from: d  reason: collision with root package name */
    public final int f1606d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1607e;

    private b(int i, int i2, int i3, int i4) {
        this.f1604b = i;
        this.f1605c = i2;
        this.f1606d = i3;
        this.f1607e = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return f1603a;
        }
        return new b(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1607e == bVar.f1607e && this.f1604b == bVar.f1604b && this.f1606d == bVar.f1606d && this.f1605c == bVar.f1605c;
    }

    public int hashCode() {
        return (((((this.f1604b * 31) + this.f1605c) * 31) + this.f1606d) * 31) + this.f1607e;
    }

    public String toString() {
        return "Insets{left=" + this.f1604b + ", top=" + this.f1605c + ", right=" + this.f1606d + ", bottom=" + this.f1607e + '}';
    }

    public Insets a() {
        return Insets.of(this.f1604b, this.f1605c, this.f1606d, this.f1607e);
    }
}
