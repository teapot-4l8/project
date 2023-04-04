package org.greenrobot.eventbus;

import android.os.Looper;

/* compiled from: MainThreadSupport.java */
/* loaded from: classes2.dex */
public interface h {
    l a(c cVar);

    boolean a();

    /* compiled from: MainThreadSupport.java */
    /* loaded from: classes2.dex */
    public static class a implements h {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f7814a;

        public a(Looper looper) {
            this.f7814a = looper;
        }

        @Override // org.greenrobot.eventbus.h
        public boolean a() {
            return this.f7814a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.h
        public l a(c cVar) {
            return new f(cVar, this.f7814a, 10);
        }
    }
}
