package kotlin.f;

import kotlin.a.u;

/* compiled from: Progressions.kt */
/* loaded from: classes2.dex */
public class a implements Iterable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final C0182a f7171a = new C0182a(null);

    /* renamed from: b  reason: collision with root package name */
    private final int f7172b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7173c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7174d;

    public a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f7172b = i;
        this.f7173c = kotlin.b.c.a(i, i2, i3);
        this.f7174d = i3;
    }

    public final int a() {
        return this.f7172b;
    }

    public final int b() {
        return this.f7173c;
    }

    public final int c() {
        return this.f7174d;
    }

    @Override // java.lang.Iterable
    /* renamed from: d */
    public u iterator() {
        return new b(this.f7172b, this.f7173c, this.f7174d);
    }

    public boolean e() {
        if (this.f7174d > 0) {
            if (this.f7172b > this.f7173c) {
                return true;
            }
        } else if (this.f7172b < this.f7173c) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!e() || !((a) obj).e()) {
                a aVar = (a) obj;
                if (this.f7172b != aVar.f7172b || this.f7173c != aVar.f7173c || this.f7174d != aVar.f7174d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (((this.f7172b * 31) + this.f7173c) * 31) + this.f7174d;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f7174d > 0) {
            sb = new StringBuilder();
            sb.append(this.f7172b);
            sb.append("..");
            sb.append(this.f7173c);
            sb.append(" step ");
            i = this.f7174d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f7172b);
            sb.append(" downTo ");
            sb.append(this.f7173c);
            sb.append(" step ");
            i = -this.f7174d;
        }
        sb.append(i);
        return sb.toString();
    }

    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0182a {
        private C0182a() {
        }

        public /* synthetic */ C0182a(kotlin.d.b.g gVar) {
            this();
        }

        public final a a(int i, int i2, int i3) {
            return new a(i, i2, i3);
        }
    }
}
