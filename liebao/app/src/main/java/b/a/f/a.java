package b.a.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fm.openinstall.Configuration;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends o {
    private final b.a.k.e n;
    private b.a.a.c o;
    private b.a.g p;

    public a(Context context, Looper looper, b.a.b bVar, b.a.f fVar, b.a.c.b bVar2, Configuration configuration) {
        super(context, looper, bVar, fVar, bVar2, configuration);
        this.n = b.a.k.e.a("CoreHandler");
        this.o = null;
        this.p = null;
        this.p = new b.a.g();
        this.o = new b.a.a.c();
    }

    private long a(long j) {
        if (j <= 0) {
            return 10L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.a.b.c a(b.a.b.c cVar) {
        b.a.b.c e2 = this.h.e();
        if (e2 != null) {
            return e2;
        }
        this.h.a(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.fm.openinstall.b.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.fm.openinstall.b.a aVar = new com.fm.openinstall.b.a();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has(ak.aF)) {
            aVar.a(jSONObject.optString(ak.aF));
        }
        if (jSONObject.has("d") && !jSONObject.isNull("d")) {
            aVar.b(jSONObject.optString("d"));
        }
        return aVar;
    }

    private void b(long j, com.fm.openinstall.a.b bVar) {
        b.a.j.b bVar2 = new b.a.j.b(this.f3179b, new n(this, j), new c(this, bVar));
        bVar2.a(j);
        this.f3178a.execute(bVar2);
    }

    private void b(Uri uri) {
        this.f3178a.execute(new d(this, uri));
    }

    private void b(Uri uri, com.fm.openinstall.a.c cVar) {
        this.f3178a.execute(new b.a.j.b(this.f3179b, new l(this, uri), new m(this, cVar, uri)));
    }

    private void b(com.fm.openinstall.a.d dVar) {
        String str = this.f3180c.getApplicationInfo().sourceDir;
        this.f3178a.execute(new f(this, str, this.f3180c.getFilesDir() + File.separator + this.f3180c.getPackageName() + ".apk", dVar));
    }

    private void g() {
        this.f3178a.execute(new k(this));
    }

    private void h() {
        this.f3178a.execute(new e(this));
    }

    @Override // b.a.f.o
    protected ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new b(this), new g(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public void a(Activity activity) {
        activity.getWindow().getDecorView().post(new j(this));
    }

    @Override // b.a.f.o
    protected ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new h(this), new i(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.f.o
    public void c() {
        super.c();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            g();
        } else if (message.what == 2) {
            p pVar = (p) message.obj;
            b((Uri) pVar.a(), (com.fm.openinstall.a.c) pVar.c());
        } else if (message.what == 3) {
            p pVar2 = (p) message.obj;
            b(a(pVar2.b().longValue()), (com.fm.openinstall.a.b) pVar2.c());
        } else if (message.what == 12) {
            b((Uri) ((p) message.obj).a());
        } else if (message.what == 11) {
            h();
        } else if (message.what == 31) {
            b((com.fm.openinstall.a.d) ((p) message.obj).c());
        } else if (message.what == 0) {
            c();
        }
    }
}
