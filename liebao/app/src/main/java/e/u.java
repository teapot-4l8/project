package e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ad;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
final class u {

    /* renamed from: a  reason: collision with root package name */
    static final Type[] f7133a = new Type[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException a(Method method, String str, Object... objArr) {
        return a(method, (Throwable) null, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException a(Method method, @Nullable Throwable th, String str, Object... objArr) {
        String format = String.format(str, objArr);
        return new IllegalArgumentException(format + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException a(Method method, Throwable th, int i, String str, Object... objArr) {
        return a(method, th, str + " (parameter #" + (i + 1) + ")", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException a(Method method, int i, String str, Object... objArr) {
        return a(method, str + " (parameter #" + (i + 1) + ")", objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> a(Type type) {
        a(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (!(rawType instanceof Class)) {
                throw new IllegalArgumentException();
            }
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(a(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return a(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    private static int a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    static String b(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (!cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException();
        }
        return a(type, cls, a(type, cls, cls2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Type a(Type type, Class<?> cls, Type type2) {
        Type type3;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type a2 = a(type, cls, (TypeVariable<?>) typeVariable);
            if (a2 == typeVariable) {
                return a2;
            }
            type3 = a2;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type a3 = a(type, cls, (Type) componentType);
                return componentType == a3 ? cls2 : new a(a3);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type a4 = a(type, cls, genericComponentType);
            return genericComponentType == a4 ? genericArrayType : new a(a4);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type a5 = a(type, cls, ownerType);
            boolean z = a5 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type a6 = a(type, cls, actualTypeArguments[i]);
                if (a6 != actualTypeArguments[i]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i] = a6;
                }
            }
            return z ? new b(a5, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z2 = type3 instanceof WildcardType;
        WildcardType wildcardType = type3;
        if (z2) {
            WildcardType wildcardType2 = (WildcardType) type3;
            Type[] lowerBounds = wildcardType2.getLowerBounds();
            Type[] upperBounds = wildcardType2.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type a7 = a(type, cls, lowerBounds[0]);
                wildcardType = wildcardType2;
                if (a7 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{a7});
                }
            } else {
                wildcardType = wildcardType2;
                if (upperBounds.length == 1) {
                    Type a8 = a(type, cls, upperBounds[0]);
                    wildcardType = wildcardType2;
                    if (a8 != upperBounds[0]) {
                        return new c(new Type[]{a8}, f7133a);
                    }
                }
            }
        }
        return wildcardType;
    }

    private static Type a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> a2 = a(typeVariable);
        if (a2 == null) {
            return typeVariable;
        }
        Type a3 = a(type, cls, a2);
        if (a3 instanceof ParameterizedType) {
            return ((ParameterizedType) a3).getActualTypeArguments()[a(a2.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void c(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ad a(ad adVar) {
        c.c cVar = new c.c();
        adVar.c().a(cVar);
        return ad.a(adVar.a(), adVar.b(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void a(Class<T> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        if (cls.getInterfaces().length > 0) {
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type a(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i < 0 || i >= actualTypeArguments.length) {
            throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
        }
        Type type = actualTypeArguments[i];
        return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (d(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return d(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type e(Type type) {
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        return a(0, (ParameterizedType) type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* loaded from: classes.dex */
    public static final class b implements ParameterizedType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7135a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f7136b;

        /* renamed from: c  reason: collision with root package name */
        private final Type[] f7137c;

        b(@Nullable Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                u.a(type3, "typeArgument == null");
                u.c(type3);
            }
            this.f7135a = type;
            this.f7136b = type2;
            this.f7137c = (Type[]) typeArr.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f7137c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f7136b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f7135a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && u.a(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f7137c) ^ this.f7136b.hashCode();
            Type type = this.f7135a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f7137c;
            if (typeArr.length == 0) {
                return u.b(this.f7136b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(u.b(this.f7136b));
            sb.append("<");
            sb.append(u.b(this.f7137c[0]));
            for (int i = 1; i < this.f7137c.length; i++) {
                sb.append(", ");
                sb.append(u.b(this.f7137c[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* loaded from: classes2.dex */
    public static final class a implements GenericArrayType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7134a;

        a(Type type) {
            this.f7134a = type;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f7134a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && u.a(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.f7134a.hashCode();
        }

        public String toString() {
            return u.b(this.f7134a) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Utils.java */
    /* loaded from: classes2.dex */
    public static final class c implements WildcardType {

        /* renamed from: a  reason: collision with root package name */
        private final Type f7138a;

        /* renamed from: b  reason: collision with root package name */
        private final Type f7139b;

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length == 1) {
                if (typeArr2[0] == null) {
                    throw null;
                }
                u.c(typeArr2[0]);
                if (typeArr[0] != Object.class) {
                    throw new IllegalArgumentException();
                }
                this.f7139b = typeArr2[0];
                this.f7138a = Object.class;
            } else if (typeArr[0] == null) {
                throw null;
            } else {
                u.c(typeArr[0]);
                this.f7139b = null;
                this.f7138a = typeArr[0];
            }
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f7138a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f7139b;
            return type != null ? new Type[]{type} : u.f7133a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && u.a(this, (WildcardType) obj);
        }

        public int hashCode() {
            Type type = this.f7139b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f7138a.hashCode() + 31);
        }

        public String toString() {
            if (this.f7139b != null) {
                return "? super " + u.b(this.f7139b);
            } else if (this.f7138a == Object.class) {
                return "?";
            } else {
                return "? extends " + u.b(this.f7138a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
