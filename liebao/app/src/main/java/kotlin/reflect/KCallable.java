package kotlin.reflect;

import java.util.List;
import java.util.Map;

/* compiled from: KCallable.kt */
/* loaded from: classes2.dex */
public interface KCallable<R> extends KAnnotatedElement {

    /* compiled from: KCallable.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isAbstract$annotations() {
        }

        public static /* synthetic */ void isFinal$annotations() {
        }

        public static /* synthetic */ void isOpen$annotations() {
        }

        public static /* synthetic */ void isSuspend$annotations() {
        }

        public static /* synthetic */ void typeParameters$annotations() {
        }

        public static /* synthetic */ void visibility$annotations() {
        }
    }

    R call(Object... objArr);

    R callBy(Map<KParameter, ? extends Object> map);

    String getName();

    List<KParameter> getParameters();

    KType getReturnType();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
