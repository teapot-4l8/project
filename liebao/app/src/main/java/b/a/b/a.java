package b.a.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import b.a.k.e;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static volatile a f3102e;

    /* renamed from: b  reason: collision with root package name */
    private ClipboardManager f3104b;

    /* renamed from: d  reason: collision with root package name */
    private Handler f3106d;

    /* renamed from: a  reason: collision with root package name */
    private e f3103a = e.a("ClipDataUtil");

    /* renamed from: c  reason: collision with root package name */
    private CountDownLatch f3105c = new CountDownLatch(1);
    private Runnable f = new b(this);

    private a(Context context) {
        this.f3104b = (ClipboardManager) context.getSystemService("clipboard");
        HandlerThread handlerThread = new HandlerThread("ClipData-Thread");
        handlerThread.start();
        this.f3106d = new Handler(handlerThread.getLooper());
    }

    public static a a(Context context) {
        if (f3102e == null) {
            synchronized (a.class) {
                if (f3102e == null) {
                    f3102e = new a(context);
                }
            }
        }
        return f3102e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClipData clipData) {
        try {
            this.f3104b.setPrimaryClip(clipData);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ClipData d() {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f3105c.await(3L, TimeUnit.SECONDS);
            }
            return this.f3104b.getPrimaryClip();
        } catch (Exception unused) {
            return null;
        }
    }

    public c a(String str, String str2) {
        c cVar = new c();
        if (str != null && str.contains(b.a.k.c.f3259d)) {
            cVar.b(str);
            cVar.b(2);
        }
        if (str2 != null && b.a.k.b.a(str2, 8).contains(b.a.k.c.f3259d)) {
            cVar.a(str2);
            cVar.b(1);
        }
        return cVar;
    }

    public void a() {
        this.f3105c.countDown();
    }

    public c b() {
        ClipData.Item itemAt;
        c cVar = new c();
        ClipData d2 = d();
        if (d2 == null || d2.getItemCount() <= 0 || (itemAt = d2.getItemAt(0)) == null) {
            return cVar;
        }
        return a(Build.VERSION.SDK_INT >= 16 ? itemAt.getHtmlText() : null, itemAt.getText() != null ? itemAt.getText().toString() : null);
    }

    public void c() {
        this.f3106d.postDelayed(this.f, 2000L);
    }
}
