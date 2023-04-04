package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final androidx.b.a<String, Method> f2725a;

    /* renamed from: b  reason: collision with root package name */
    protected final androidx.b.a<String, Method> f2726b;

    /* renamed from: c  reason: collision with root package name */
    protected final androidx.b.a<String, Class> f2727c;

    protected abstract void a(int i);

    protected abstract void a(Parcelable parcelable);

    protected abstract void a(CharSequence charSequence);

    protected abstract void a(String str);

    protected abstract void a(boolean z);

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    public boolean a() {
        return false;
    }

    protected abstract void b();

    protected abstract boolean b(int i);

    protected abstract a c();

    protected abstract void c(int i);

    protected abstract int d();

    protected abstract String e();

    protected abstract byte[] f();

    protected abstract CharSequence g();

    protected abstract <T extends Parcelable> T h();

    protected abstract boolean i();

    public a(androidx.b.a<String, Method> aVar, androidx.b.a<String, Method> aVar2, androidx.b.a<String, Class> aVar3) {
        this.f2725a = aVar;
        this.f2726b = aVar2;
        this.f2727c = aVar3;
    }

    public void a(boolean z, int i) {
        c(i);
        a(z);
    }

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public void a(CharSequence charSequence, int i) {
        c(i);
        a(charSequence);
    }

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    public boolean b(boolean z, int i) {
        return !b(i) ? z : i();
    }

    public int b(int i, int i2) {
        return !b(i2) ? i : d();
    }

    public String b(String str, int i) {
        return !b(i) ? str : e();
    }

    public byte[] b(byte[] bArr, int i) {
        return !b(i) ? bArr : f();
    }

    public <T extends Parcelable> T b(T t, int i) {
        return !b(i) ? t : (T) h();
    }

    public CharSequence b(CharSequence charSequence, int i) {
        return !b(i) ? charSequence : g();
    }

    public void a(c cVar, int i) {
        c(i);
        a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(c cVar) {
        if (cVar == null) {
            a((String) null);
            return;
        }
        b(cVar);
        a c2 = c();
        a((a) cVar, c2);
        c2.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(c cVar) {
        try {
            a(b((Class<? extends c>) cVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public <T extends c> T b(T t, int i) {
        return !b(i) ? t : (T) j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends c> T j() {
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        return (T) a(e2, c());
    }

    protected <T extends c> T a(String str, a aVar) {
        try {
            return (T) b(str).invoke(null, aVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    protected <T extends c> void a(T t, a aVar) {
        try {
            a(t.getClass()).invoke(null, t, aVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    private Method b(String str) {
        Method method = this.f2725a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            this.f2725a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Method a(Class cls) {
        Method method = this.f2726b.get(cls.getName());
        if (method == null) {
            Class b2 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b2.getDeclaredMethod("write", cls, a.class);
            this.f2726b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private Class b(Class<? extends c> cls) {
        Class cls2 = this.f2727c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f2727c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }
}
