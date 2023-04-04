package kotlin.reflect;

import java.util.Collection;
import java.util.List;

/* compiled from: KClass.kt */
/* loaded from: classes2.dex */
public interface KClass<T> extends KAnnotatedElement, KClassifier, KDeclarationContainer {

    /* compiled from: KClass.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isAbstract$annotations() {
        }

        public static /* synthetic */ void isCompanion$annotations() {
        }

        public static /* synthetic */ void isData$annotations() {
        }

        public static /* synthetic */ void isFinal$annotations() {
        }

        public static /* synthetic */ void isInner$annotations() {
        }

        public static /* synthetic */ void isOpen$annotations() {
        }

        public static /* synthetic */ void isSealed$annotations() {
        }

        public static /* synthetic */ void sealedSubclasses$annotations() {
        }

        public static /* synthetic */ void supertypes$annotations() {
        }

        public static /* synthetic */ void typeParameters$annotations() {
        }

        public static /* synthetic */ void visibility$annotations() {
        }
    }

    boolean equals(Object obj);

    Collection<KFunction<T>> getConstructors();

    Collection<KCallable<?>> getMembers();

    Collection<KClass<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<KType> getSupertypes();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isInner();

    boolean isInstance(Object obj);

    boolean isOpen();

    boolean isSealed();
}
