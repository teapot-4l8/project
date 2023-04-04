package cn.jiguang.ax;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.just.agentweb.WebIndicator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4005a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4006b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private boolean f4007c = false;

    /* renamed from: d  reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f4008d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Handler f4009e;
    private HandlerThread f;

    private b() {
    }

    public static b a() {
        if (f4005a == null) {
            synchronized (f4006b) {
                if (f4005a == null) {
                    f4005a = new b();
                }
            }
        }
        return f4005a;
    }

    public final void a(int i, long j, a aVar) {
        if (this.f4009e == null) {
            return;
        }
        aVar.f4003b = j;
        aVar.f4004c = 1;
        this.f4008d.put(Integer.valueOf((int) WebIndicator.MAX_UNIFORM_SPEED_DURATION), aVar);
        if (this.f4009e.hasMessages(WebIndicator.MAX_UNIFORM_SPEED_DURATION)) {
            cn.jiguang.an.d.f("TaskHandlerManager_xxx", "registerFixedAction,same action in handler,will replace");
            this.f4009e.removeMessages(WebIndicator.MAX_UNIFORM_SPEED_DURATION);
        }
        this.f4009e.sendEmptyMessageDelayed(WebIndicator.MAX_UNIFORM_SPEED_DURATION, j);
    }

    public final synchronized void a(Context context) {
        if (this.f4007c) {
            return;
        }
        if (context == null) {
            cn.jiguang.an.d.b("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        cn.jiguang.an.d.b("TaskHandlerManager_xxx", "init task manager...");
        try {
            if (this.f == null || !this.f.isAlive()) {
                c cVar = new c(this, "TaskHandlerManager_xxx");
                this.f = cVar;
                cVar.start();
            }
            this.f4009e = new d(this, this.f.getLooper() == null ? Looper.getMainLooper() : this.f.getLooper());
        } catch (Exception unused) {
            this.f4009e = new d(this, Looper.getMainLooper());
        }
        this.f4007c = true;
    }

    public final boolean a(int i) {
        Handler handler = this.f4009e;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(1011);
    }

    public final void b(int i) {
        if (this.f4009e == null) {
            return;
        }
        this.f4008d.remove(Integer.valueOf(i));
        this.f4009e.removeMessages(i);
    }

    public final void b(int i, long j, a aVar) {
        if (this.f4009e == null) {
            return;
        }
        aVar.f4004c = 2;
        this.f4008d.put(Integer.valueOf(i), aVar);
        if (this.f4009e.hasMessages(i)) {
            cn.jiguang.an.d.b("TaskHandlerManager_xxx", "sendMsg,replace:" + i);
            this.f4009e.removeMessages(i);
        } else {
            cn.jiguang.an.d.b("TaskHandlerManager_xxx", "sendMsg,action=" + i);
        }
        this.f4009e.sendEmptyMessageDelayed(i, j);
    }
}
