package androidx.media;

import java.util.Arrays;

/* compiled from: AudioAttributesImplBase.java */
/* loaded from: classes.dex */
class c implements a {

    /* renamed from: a  reason: collision with root package name */
    int f2093a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f2094b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2095c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f2096d = -1;

    public int a() {
        int i = this.f2096d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f2095c, this.f2093a);
    }

    public int b() {
        return this.f2094b;
    }

    public int c() {
        return this.f2093a;
    }

    public int d() {
        int i = this.f2095c;
        int a2 = a();
        if (a2 == 6) {
            i |= 4;
        } else if (a2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2094b), Integer.valueOf(this.f2095c), Integer.valueOf(this.f2093a), Integer.valueOf(this.f2096d)});
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f2094b == cVar.b() && this.f2095c == cVar.d() && this.f2093a == cVar.c() && this.f2096d == cVar.f2096d;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2096d != -1) {
            sb.append(" stream=");
            sb.append(this.f2096d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f2093a));
        sb.append(" content=");
        sb.append(this.f2094b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2095c).toUpperCase());
        return sb.toString();
    }
}
