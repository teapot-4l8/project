package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* compiled from: SubscriberMethod.java */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    final Method f7827a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f7828b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f7829c;

    /* renamed from: d  reason: collision with root package name */
    final int f7830d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f7831e;
    String f;

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f7827a = method;
        this.f7828b = threadMode;
        this.f7829c = cls;
        this.f7830d = i;
        this.f7831e = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            a();
            o oVar = (o) obj;
            oVar.a();
            return this.f.equals(oVar.f);
        }
        return false;
    }

    private synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f7827a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f7827a.getName());
            sb.append('(');
            sb.append(this.f7829c.getName());
            this.f = sb.toString();
        }
    }

    public int hashCode() {
        return this.f7827a.hashCode();
    }
}
