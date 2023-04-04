package b.a.f;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fm.openinstall.Configuration;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public abstract class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    protected ThreadPoolExecutor f3178a;

    /* renamed from: b  reason: collision with root package name */
    protected ThreadPoolExecutor f3179b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f3180c;

    /* renamed from: d  reason: collision with root package name */
    protected b.a.b f3181d;

    /* renamed from: e  reason: collision with root package name */
    protected b.a.c.b f3182e;
    protected String f;
    protected boolean g;
    protected b.a.f h;
    protected b.a.i i;
    protected b.a.b.a j;
    protected b.a.g.d k;
    protected Configuration l;
    protected b.a.h.a.d m;

    public o(Context context, Looper looper, b.a.b bVar, b.a.f fVar, b.a.c.b bVar2, Configuration configuration) {
        super(looper);
        this.f3180c = context;
        this.f3181d = bVar;
        this.f3178a = a();
        this.f3179b = b();
        this.f3182e = bVar2;
        this.l = configuration;
        this.h = fVar;
        this.i = b.a.i.a(context);
        this.j = b.a.b.a.a(context);
        this.k = b.a.g.d.a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(boolean z, String str) {
        Object[] objArr = new Object[4];
        objArr[0] = z ? b.a.h.a.b() : b.a.h.a.a();
        objArr[1] = this.g ? "v2_5" : "v2";
        objArr[2] = this.f;
        objArr[3] = str;
        return String.format("https://%s/api/%s/android/%s/%s", objArr);
    }

    protected abstract ThreadPoolExecutor a();

    public void a(long j, com.fm.openinstall.a.b bVar) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = new p(null, Long.valueOf(j), bVar);
        sendMessage(obtain);
    }

    public void a(Uri uri) {
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = new p(uri, null, null);
        sendMessage(obtain);
    }

    public void a(Uri uri, com.fm.openinstall.a.c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = new p(uri, null, cVar);
        sendMessage(obtain);
    }

    public void a(b.a.e.a aVar) {
        Message obtain = Message.obtain();
        obtain.what = 21;
        obtain.obj = new p(aVar, null, null);
        sendMessage(obtain);
    }

    public void a(com.fm.openinstall.a.d dVar) {
        Message obtain = Message.obtain();
        obtain.what = 31;
        obtain.obj = new p(null, null, dVar);
        sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.a.c.b b2 = b.a.c.b.b(str);
        if (!this.f3182e.equals(b2)) {
            this.f3182e.a(b2);
            this.h.a(this.f3182e);
            this.f3182e.i();
        }
        if (TextUtils.isEmpty(this.f3182e.h())) {
            return;
        }
        this.k.b(this.f, this.f3182e.h());
    }

    public void a(String str, boolean z) {
        this.f = str;
        this.g = z;
    }

    public void a(boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 22;
        obtain.obj = new p(Boolean.valueOf(z), null, null);
        sendMessage(obtain);
    }

    protected abstract ThreadPoolExecutor b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        ThreadPoolExecutor threadPoolExecutor = this.f3178a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.f3179b;
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor2.shutdown();
        }
        getLooper().quit();
    }

    public void d() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        sendMessage(obtain);
    }

    public void e() {
        Message obtain = Message.obtain();
        obtain.what = 23;
        obtain.obj = null;
        sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.a.h.a.d f() {
        if (this.m == null) {
            this.m = new b.a.h.a.d(this.g);
            if (!this.l.isImeiDisabled()) {
                this.m.a("dI", this.i.j());
            }
            if (!this.l.isMacDisabled()) {
                this.m.a("mA", this.i.l());
            }
            this.m.a("sN", this.i.m());
            this.m.a("andI", this.i.n());
            this.m.a("Pk", this.i.b());
            this.m.a("cF", this.i.c());
            this.m.a("ver", this.i.d());
            this.m.a("verI", String.valueOf(this.i.e()));
            this.m.a("apV", "2.5.2");
        }
        this.m.a("iI", TextUtils.isEmpty(this.f3182e.h()) ? this.k.a(this.f) : this.f3182e.h());
        return this.m;
    }
}
