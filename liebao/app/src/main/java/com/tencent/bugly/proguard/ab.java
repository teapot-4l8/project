package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ab extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6135a = false;

    /* renamed from: b  reason: collision with root package name */
    private List<aa> f6136b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<ac> f6137c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<aa> f6138d = new ArrayList<>();

    public final void a() {
        a(new Handler(Looper.getMainLooper()), 5000L);
    }

    public final void b() {
        for (int i = 0; i < this.f6136b.size(); i++) {
            try {
                if (this.f6136b.get(i).e().equals(Looper.getMainLooper().getThread().getName())) {
                    x.c("remove handler::%s", this.f6136b.get(i));
                    this.f6136b.remove(i);
                }
            } catch (Exception e2) {
                x.b(e2);
                return;
            }
        }
    }

    private void a(Handler handler, long j) {
        if (handler == null) {
            x.e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i = 0; i < this.f6136b.size(); i++) {
            try {
                if (this.f6136b.get(i).e().equals(handler.getLooper().getThread().getName())) {
                    x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        this.f6136b.add(new aa(handler, name, 5000L));
    }

    public final boolean c() {
        this.f6135a = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e2) {
                x.b(e2);
            }
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            x.b(e2);
            return false;
        }
    }

    private int e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6136b.size(); i2++) {
            try {
                i = Math.max(i, this.f6136b.get(i2).c());
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        return i;
    }

    public final void a(ac acVar) {
        if (this.f6137c.contains(acVar)) {
            x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f6137c.add(acVar);
        }
    }

    public final void b(ac acVar) {
        this.f6137c.remove(acVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f6135a) {
            for (int i = 0; i < this.f6136b.size(); i++) {
                try {
                    this.f6136b.get(i).a();
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j = 2000; j > 0 && !isInterrupted(); j = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                sleep(j);
            }
            int e3 = e();
            if (e3 != 0 && e3 != 1) {
                this.f6138d.clear();
                for (int i2 = 0; i2 < this.f6136b.size(); i2++) {
                    aa aaVar = this.f6136b.get(i2);
                    if (aaVar.b()) {
                        this.f6138d.add(aaVar);
                        aaVar.a(Long.MAX_VALUE);
                    }
                }
                boolean z = false;
                for (int i3 = 0; i3 < this.f6138d.size(); i3++) {
                    aa aaVar2 = this.f6138d.get(i3);
                    Thread d2 = aaVar2.d();
                    for (int i4 = 0; i4 < this.f6137c.size(); i4++) {
                        if (this.f6137c.get(i4).a(d2)) {
                            z = true;
                        }
                    }
                    if (!z && aaVar2.e().contains("main")) {
                        aaVar2.f();
                        x.d("although thread is blocked ,may not be anr error,so restore handler check wait time and restart check main thread", new Object[0]);
                    }
                }
            }
        }
    }
}
