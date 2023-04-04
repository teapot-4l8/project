package kotlin.d.b;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* compiled from: CallableReference.java */
/* loaded from: classes2.dex */
public abstract class c implements Serializable, KCallable {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f7151b = a.f7154a;

    /* renamed from: a  reason: collision with root package name */
    protected final Object f7152a;

    /* renamed from: c  reason: collision with root package name */
    private transient KCallable f7153c;

    protected abstract KCallable a();

    /* compiled from: CallableReference.java */
    /* loaded from: classes2.dex */
    private static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final a f7154a = new a();

        private a() {
        }
    }

    public c() {
        this(f7151b);
    }

    protected c(Object obj) {
        this.f7152a = obj;
    }

    public Object b() {
        return this.f7152a;
    }

    public KCallable c() {
        KCallable kCallable = this.f7153c;
        if (kCallable == null) {
            KCallable a2 = a();
            this.f7153c = a2;
            return a2;
        }
        return kCallable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KCallable d() {
        KCallable c2 = c();
        if (c2 != this) {
            return c2;
        }
        throw new kotlin.d.b();
    }

    public KDeclarationContainer e() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        throw new AbstractMethodError();
    }

    public String f() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return d().getParameters();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return d().getReturnType();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return d().getAnnotations();
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return d().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... objArr) {
        return d().call(objArr);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map map) {
        return d().callBy(map);
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return d().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return d().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return d().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return d().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return d().isSuspend();
    }
}
