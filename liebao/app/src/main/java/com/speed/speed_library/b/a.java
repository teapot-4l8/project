package com.speed.speed_library.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.just.agentweb.AgentWeb;

/* compiled from: AndroidInterface.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f5585a;

    /* renamed from: b  reason: collision with root package name */
    private final AgentWeb f5586b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5587c;

    public a(AgentWeb agentWeb, Context context) {
        kotlin.d.b.i.b(agentWeb, "agent");
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        this.f5586b = agentWeb;
        this.f5587c = context;
        this.f5585a = new Handler(Looper.getMainLooper());
    }

    /* compiled from: AndroidInterface.kt */
    /* renamed from: com.speed.speed_library.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class RunnableC0134a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5589b;

        RunnableC0134a(String str) {
            this.f5589b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("Info", "main Thread:" + Thread.currentThread());
            Context applicationContext = a.this.f5587c.getApplicationContext();
            Toast.makeText(applicationContext, "" + this.f5589b, 1).show();
        }
    }

    @JavascriptInterface
    public final void postMessage(String str) {
        kotlin.d.b.i.b(str, JThirdPlatFormInterface.KEY_MSG);
        this.f5585a.post(new RunnableC0134a(str));
        Log.i("Info", "Thread:" + Thread.currentThread());
    }
}
