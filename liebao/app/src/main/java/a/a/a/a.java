package a.a.a;

import a.a.a.b.c;
import a.a.a.b.f;
import a.a.a.c.b;
import a.a.a.c.d;
import a.a.a.e.h;
import a.a.a.e.k;
import a.a.a.e.q;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.UUID;

/* compiled from: HttpModelHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f1a;

    /* renamed from: b  reason: collision with root package name */
    private Context f2b;

    /* renamed from: c  reason: collision with root package name */
    private b f3c;

    /* renamed from: d  reason: collision with root package name */
    private f f4d;

    /* renamed from: e  reason: collision with root package name */
    private a.a.a.c.a f5e;
    private long f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpModelHelper.java */
    /* renamed from: a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0000a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f9a = new a();
    }

    public static a a() {
        return C0000a.f9a;
    }

    public a a(Context context) {
        this.f2b = context.getApplicationContext();
        return this;
    }

    public boolean b() {
        return this.g;
    }

    public a a(boolean z) {
        this.g = z;
        return this;
    }

    public f c() {
        if (this.f4d == null) {
            this.f4d = new c();
        }
        return this.f4d;
    }

    public a a(f fVar) {
        this.f4d = fVar;
        return this;
    }

    public Context d() {
        return this.f2b;
    }

    public String e() {
        return this.f1a;
    }

    public b f() {
        return this.f3c;
    }

    public long g() {
        return this.f;
    }

    public void a(final String str, b bVar) {
        q.a(bVar, "HttpListener must not be null");
        a.a.a.e.f.a("Welcome to use HttpModel");
        this.f = h.a();
        this.f3c = bVar;
        if (d.a()) {
            HandlerThread handlerThread = new HandlerThread("http" + UUID.randomUUID().toString().substring(0, 8));
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: a.a.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(str);
                }
            });
            return;
        }
        b(str);
    }

    private boolean a(String str) {
        if (this.f2b == null) {
            d.a("Context must not be null");
            return false;
        } else if (!q.b(str)) {
            d.a("The input address must not be null");
            return false;
        } else if (!k.a(this.f2b)) {
            d.a("The network is not available");
            return false;
        } else {
            if (!str.startsWith("http")) {
                str = "http://" + str;
            }
            if (str.startsWith("https")) {
                str = "http://" + str.substring(8);
            }
            if (!a.a.a.e.a.a(str)) {
                d.a("The input address is not legitimate");
                return false;
            }
            this.f1a = str;
            a.a.a.e.f.a("this address is:" + this.f1a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (a(str)) {
            a.a.a.c.a aVar = this.f5e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            a.a.a.c.a aVar2 = new a.a.a.c.a();
            this.f5e = aVar2;
            aVar2.c().d();
            this.f5e.a();
        }
    }

    public a.a.a.c.a h() {
        a.a.a.c.a aVar = new a.a.a.c.a();
        this.f5e = aVar;
        return aVar;
    }

    public int i() {
        a.a.a.c.a aVar = this.f5e;
        if (aVar == null) {
            return 0;
        }
        return aVar.b();
    }
}
