package b.b.a.b;

import android.os.Handler;
import android.os.Looper;
import b.b.i;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final i f3271a = b.b.a.a.a.a(new Callable<i>() { // from class: b.b.a.b.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public i call() {
            return C0067a.f3272a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* renamed from: b.b.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0067a {

        /* renamed from: a  reason: collision with root package name */
        static final i f3272a = new b(new Handler(Looper.getMainLooper()), false);
    }

    public static i a() {
        return b.b.a.a.a.a(f3271a);
    }
}
