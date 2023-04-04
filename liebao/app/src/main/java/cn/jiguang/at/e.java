package cn.jiguang.at;

/* loaded from: classes.dex */
public final class e extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final int f3932a;

    public e(int i, String str) {
        super(str);
        this.f3932a = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "JException(" + this.f3932a + "):" + getLocalizedMessage();
    }
}
