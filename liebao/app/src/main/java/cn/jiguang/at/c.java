package cn.jiguang.at;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    int f3927a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f3928b;

    /* renamed from: c  reason: collision with root package name */
    public String f3929c;

    /* renamed from: d  reason: collision with root package name */
    int f3930d;

    /* renamed from: e  reason: collision with root package name */
    int f3931e;
    long f;
    byte[] g;
    long h;
    long i;
    boolean j;

    public c(long j, String str, int i, int i2, long j2, long j3, byte[] bArr) {
        this.f3928b = j;
        this.f3929c = str;
        this.f3930d = i;
        this.f3931e = i2;
        this.f = j2;
        this.i = j3;
        this.g = bArr;
        if (j3 > 0) {
            this.j = true;
        }
    }

    public final String toString() {
        return "InnerRequest{times=" + this.f3927a + ", requestId=" + this.f3928b + ", sdkType='" + this.f3929c + "', command=" + this.f3930d + ", ver=" + this.f3931e + ", rid=" + this.f + ", reqeustTime=" + this.h + ", timeout=" + this.i + '}';
    }
}
