package cn.jpush.android.n;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private long f4403a;

    /* renamed from: b  reason: collision with root package name */
    private int f4404b;

    /* renamed from: c  reason: collision with root package name */
    private int f4405c;

    /* renamed from: d  reason: collision with root package name */
    private int f4406d;

    /* renamed from: e  reason: collision with root package name */
    private String f4407e;
    private long f;
    private long g;

    public c() {
        this.f4403a = 0L;
        this.f4404b = 0;
        this.f4405c = 0;
        this.f4406d = 0;
        this.f4407e = "";
        this.f = 0L;
        this.g = 0L;
        this.f4403a = 0L;
        this.f4404b = 0;
        this.f4405c = 0;
        this.f4406d = 0;
        this.f4407e = "";
        this.f = 0L;
        this.g = 0L;
    }

    public long a() {
        return this.f4403a;
    }

    public void a(int i) {
        this.f4404b = i;
    }

    public void a(long j) {
        this.f4403a = j;
    }

    public void a(String str) {
        this.f4407e = str;
    }

    public int b() {
        return this.f4404b;
    }

    public void b(int i) {
        this.f4405c = i;
    }

    public void b(long j) {
        this.g = j;
    }

    public int c() {
        return this.f4405c;
    }

    public void c(int i) {
        this.f4406d = i;
    }

    public void c(long j) {
        this.f = j;
    }

    public String d() {
        return this.f4407e;
    }

    public long e() {
        return this.g;
    }

    public long f() {
        return this.f;
    }

    public String toString() {
        return "LocalNotificationDBData [ln_id=" + this.f4403a + ", ln_count=" + this.f4404b + ", ln_remove=" + this.f4405c + ", ln_type=" + this.f4406d + ", ln_extra=" + this.f4407e + ", ln_trigger_time=" + this.f + ", ln_add_time=" + this.g + "]";
    }
}
