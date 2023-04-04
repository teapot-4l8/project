package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* loaded from: classes.dex */
class ao {

    /* renamed from: a  reason: collision with root package name */
    private int f979a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f980b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f981c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f982d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f983e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public int a() {
        return this.f979a;
    }

    public int b() {
        return this.f980b;
    }

    public int c() {
        return this.g ? this.f980b : this.f979a;
    }

    public int d() {
        return this.g ? this.f979a : this.f980b;
    }

    public void a(int i, int i2) {
        this.f981c = i;
        this.f982d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f979a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f980b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f979a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f980b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f983e = i;
            this.f979a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f = i2;
            this.f980b = i2;
        }
    }

    public void a(boolean z) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (!this.h) {
            this.f979a = this.f983e;
            this.f980b = this.f;
        } else if (z) {
            int i = this.f982d;
            if (i == Integer.MIN_VALUE) {
                i = this.f983e;
            }
            this.f979a = i;
            int i2 = this.f981c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f;
            }
            this.f980b = i2;
        } else {
            int i3 = this.f981c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f983e;
            }
            this.f979a = i3;
            int i4 = this.f982d;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f;
            }
            this.f980b = i4;
        }
    }
}
