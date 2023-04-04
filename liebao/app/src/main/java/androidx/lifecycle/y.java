package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private final b f2049a;

    /* renamed from: b  reason: collision with root package name */
    private final aa f2050b;

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public interface b {
        <T extends x> T a(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static abstract class c implements b {
        public abstract <T extends x> T a(String str, Class<T> cls);

        c() {
        }
    }

    public y(aa aaVar, b bVar) {
        this.f2049a = bVar;
        this.f2050b = aaVar;
    }

    public <T extends x> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends x> T a(String str, Class<T> cls) {
        T t;
        T t2 = (T) this.f2050b.a(str);
        if (cls.isInstance(t2)) {
            return t2;
        }
        b bVar = this.f2049a;
        if (bVar instanceof c) {
            t = (T) ((c) bVar).a(str, cls);
        } else {
            t = (T) bVar.a(cls);
        }
        this.f2050b.a(str, t);
        return t;
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class d implements b {
        @Override // androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* compiled from: ViewModelProvider.java */
    /* loaded from: classes.dex */
    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private static a f2051a;

        /* renamed from: b  reason: collision with root package name */
        private Application f2052b;

        public static a a(Application application) {
            if (f2051a == null) {
                f2051a = new a(application);
            }
            return f2051a;
        }

        public a(Application application) {
            this.f2052b = application;
        }

        @Override // androidx.lifecycle.y.d, androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            if (androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.f2052b);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (NoSuchMethodException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                }
            }
            return (T) super.a(cls);
        }
    }
}
