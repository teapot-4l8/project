package b.a.g;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3191a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f3192b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3193c = false;

    public a(Context context) {
        this.f3191a = context;
    }

    @Override // b.a.g.e
    public synchronized String a(String str) {
        if (this.f3193c) {
            return this.f3192b;
        }
        return b(str);
    }

    @Override // b.a.g.e
    public synchronized void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (this.f3193c && str2.equals(this.f3192b)) {
            return;
        }
        if (b(str, str2)) {
            this.f3193c = true;
        } else {
            this.f3193c = false;
        }
        this.f3192b = str2;
    }

    abstract String b(String str);

    abstract boolean b(String str, String str2);
}
