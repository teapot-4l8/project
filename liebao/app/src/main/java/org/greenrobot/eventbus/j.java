package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost.java */
/* loaded from: classes2.dex */
final class j {

    /* renamed from: d  reason: collision with root package name */
    private static final List<j> f7817d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f7818a;

    /* renamed from: b  reason: collision with root package name */
    q f7819b;

    /* renamed from: c  reason: collision with root package name */
    j f7820c;

    private j(Object obj, q qVar) {
        this.f7818a = obj;
        this.f7819b = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(q qVar, Object obj) {
        synchronized (f7817d) {
            int size = f7817d.size();
            if (size > 0) {
                j remove = f7817d.remove(size - 1);
                remove.f7818a = obj;
                remove.f7819b = qVar;
                remove.f7820c = null;
                return remove;
            }
            return new j(obj, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        jVar.f7818a = null;
        jVar.f7819b = null;
        jVar.f7820c = null;
        synchronized (f7817d) {
            if (f7817d.size() < 10000) {
                f7817d.add(jVar);
            }
        }
    }
}
