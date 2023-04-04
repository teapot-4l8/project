package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.h;
import androidx.work.impl.utils.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SystemAlarmDispatcher.java */
/* loaded from: classes.dex */
public class e implements androidx.work.impl.a {

    /* renamed from: a  reason: collision with root package name */
    static final String f2923a = h.a("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    final Context f2924b;

    /* renamed from: c  reason: collision with root package name */
    final androidx.work.impl.background.systemalarm.b f2925c;

    /* renamed from: d  reason: collision with root package name */
    final List<Intent> f2926d;

    /* renamed from: e  reason: collision with root package name */
    Intent f2927e;
    private final androidx.work.impl.utils.b.a f;
    private final g g;
    private final androidx.work.impl.c h;
    private final androidx.work.impl.h i;
    private final Handler j;
    private b k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this(context, null, null);
    }

    e(Context context, androidx.work.impl.c cVar, androidx.work.impl.h hVar) {
        Context applicationContext = context.getApplicationContext();
        this.f2924b = applicationContext;
        this.f2925c = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.g = new g();
        hVar = hVar == null ? androidx.work.impl.h.b(context) : hVar;
        this.i = hVar;
        this.h = cVar == null ? hVar.f() : cVar;
        this.f = this.i.g();
        this.h.a(this);
        this.f2926d = new ArrayList();
        this.f2927e = null;
        this.j = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        h.a().b(f2923a, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.h.b(this);
        this.g.a();
        this.k = null;
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        a(new a(this, androidx.work.impl.background.systemalarm.b.a(this.f2924b, str, z), 0));
    }

    public boolean a(Intent intent, int i) {
        h.a().b(f2923a, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        h();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            h.a().d(f2923a, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && a("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.f2926d) {
                boolean z = this.f2926d.isEmpty() ? false : true;
                this.f2926d.add(intent);
                if (!z) {
                    g();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (this.k != null) {
            h.a().e(f2923a, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.k = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.work.impl.c b() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.work.impl.h d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.work.impl.utils.b.a e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        this.j.post(runnable);
    }

    void f() {
        h.a().b(f2923a, "Checking if commands are complete.", new Throwable[0]);
        h();
        synchronized (this.f2926d) {
            if (this.f2927e != null) {
                h.a().b(f2923a, String.format("Removing command %s", this.f2927e), new Throwable[0]);
                if (!this.f2926d.remove(0).equals(this.f2927e)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.f2927e = null;
            }
            if (!this.f2925c.a() && this.f2926d.isEmpty()) {
                h.a().b(f2923a, "No more commands & intents.", new Throwable[0]);
                if (this.k != null) {
                    this.k.a();
                }
            } else if (!this.f2926d.isEmpty()) {
                g();
            }
        }
    }

    private void g() {
        h();
        PowerManager.WakeLock a2 = i.a(this.f2924b, "ProcessCommand");
        try {
            a2.acquire();
            this.i.g().a(new Runnable() { // from class: androidx.work.impl.background.systemalarm.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e eVar;
                    c cVar;
                    synchronized (e.this.f2926d) {
                        e.this.f2927e = e.this.f2926d.get(0);
                    }
                    if (e.this.f2927e != null) {
                        String action = e.this.f2927e.getAction();
                        int intExtra = e.this.f2927e.getIntExtra("KEY_START_ID", 0);
                        h.a().b(e.f2923a, String.format("Processing command %s, %s", e.this.f2927e, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock a3 = i.a(e.this.f2924b, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                        try {
                            h.a().b(e.f2923a, String.format("Acquiring operation wake lock (%s) %s", action, a3), new Throwable[0]);
                            a3.acquire();
                            e.this.f2925c.a(e.this.f2927e, intExtra, e.this);
                            h.a().b(e.f2923a, String.format("Releasing operation wake lock (%s) %s", action, a3), new Throwable[0]);
                            a3.release();
                            eVar = e.this;
                            cVar = new c(eVar);
                        } catch (Throwable th) {
                            try {
                                h.a().e(e.f2923a, "Unexpected error in onHandleIntent", th);
                                h.a().b(e.f2923a, String.format("Releasing operation wake lock (%s) %s", action, a3), new Throwable[0]);
                                a3.release();
                                eVar = e.this;
                                cVar = new c(eVar);
                            } catch (Throwable th2) {
                                h.a().b(e.f2923a, String.format("Releasing operation wake lock (%s) %s", action, a3), new Throwable[0]);
                                a3.release();
                                e eVar2 = e.this;
                                eVar2.a(new c(eVar2));
                                throw th2;
                            }
                        }
                        eVar.a(cVar);
                    }
                }
            });
        } finally {
            a2.release();
        }
    }

    private boolean a(String str) {
        h();
        synchronized (this.f2926d) {
            for (Intent intent : this.f2926d) {
                if (str.equals(intent.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void h() {
        if (this.j.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f2932a;

        c(e eVar) {
            this.f2932a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2932a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f2929a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f2930b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2931c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(e eVar, Intent intent, int i) {
            this.f2929a = eVar;
            this.f2930b = intent;
            this.f2931c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2929a.a(this.f2930b, this.f2931c);
        }
    }
}
