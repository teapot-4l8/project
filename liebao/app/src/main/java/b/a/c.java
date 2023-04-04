package b.a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f3111a = new c(1, "未初始化");

    /* renamed from: b  reason: collision with root package name */
    public static final c f3112b = new c(2, "正在初始化");

    /* renamed from: c  reason: collision with root package name */
    public static final c f3113c = new c(0, "初始化成功");

    /* renamed from: d  reason: collision with root package name */
    public static final c f3114d = new c(-1, "初始化失败");

    /* renamed from: e  reason: collision with root package name */
    public static final c f3115e = new c(-2, "初始化错误");
    private int f;
    private String g;

    c(int i, String str) {
        this.f = i;
        this.g = str;
    }

    public static c a(int i) {
        return i != -2 ? i != -1 ? i != 0 ? i != 2 ? f3111a : f3112b : f3113c : f3114d : f3115e;
    }

    public int a() {
        return this.f;
    }
}
