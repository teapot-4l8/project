package com.bumptech.glide.c.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class x {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4875a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f4876b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(u<?> uVar) {
        com.bumptech.glide.i.j.a();
        if (this.f4875a) {
            this.f4876b.obtainMessage(1, uVar).sendToTarget();
            return;
        }
        this.f4875a = true;
        uVar.f();
        this.f4875a = false;
    }

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((u) message.obj).f();
                return true;
            }
            return false;
        }
    }
}
