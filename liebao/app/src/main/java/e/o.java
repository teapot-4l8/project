package e;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import e.c;
import e.f;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
class o {

    /* renamed from: a  reason: collision with root package name */
    private static final o f7096a = e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Method method) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Executor b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        return f7096a;
    }

    private static o e() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends c.a> a(@Nullable Executor executor) {
        if (executor != null) {
            return Collections.singletonList(new h(executor));
        }
        return Collections.singletonList(g.f7033a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends f.a> c() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static class b extends o {
        @Override // e.o
        int d() {
            return 1;
        }

        b() {
        }

        @Override // e.o
        boolean a(Method method) {
            return method.isDefault();
        }

        @Override // e.o
        Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // e.o
        List<? extends c.a> a(@Nullable Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(e.f7022a);
            if (executor != null) {
                arrayList.add(new h(executor));
            } else {
                arrayList.add(g.f7033a);
            }
            return Collections.unmodifiableList(arrayList);
        }

        @Override // e.o
        List<? extends f.a> c() {
            return Collections.singletonList(m.f7068a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes.dex */
    public static class a extends o {
        a() {
        }

        @Override // e.o
        boolean a(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        @Override // e.o
        public Executor b() {
            return new ExecutorC0180a();
        }

        @Override // e.o
        List<? extends c.a> a(@Nullable Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            h hVar = new h(executor);
            return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(e.f7022a, hVar) : Collections.singletonList(hVar);
        }

        @Override // e.o
        List<? extends f.a> c() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(m.f7068a);
            }
            return Collections.emptyList();
        }

        @Override // e.o
        int d() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        /* compiled from: Platform.java */
        /* renamed from: e.o$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class ExecutorC0180a implements Executor {

            /* renamed from: a  reason: collision with root package name */
            private final Handler f7097a = new Handler(Looper.getMainLooper());

            ExecutorC0180a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f7097a.post(runnable);
            }
        }
    }
}
