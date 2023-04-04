package kotlin.d.b;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* compiled from: ClassReference.kt */
/* loaded from: classes2.dex */
public final class e implements d, KClass<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f7155a;

    public e(Class<?> cls) {
        i.b(cls, "jClass");
        this.f7155a = cls;
    }

    @Override // kotlin.d.b.d
    public Class<?> a() {
        return this.f7155a;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KDeclarationContainer, kotlin.reflect.KClass
    public Collection<KCallable<?>> getMembers() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object obj) {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        b();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        b();
        throw null;
    }

    private final Void b() {
        throw new kotlin.d.b();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object obj) {
        return (obj instanceof e) && i.a(kotlin.d.a.a(this), kotlin.d.a.a((KClass) obj));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return kotlin.d.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
